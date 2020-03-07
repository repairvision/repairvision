package org.sidiff.revision.configuration.test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Settings;
import org.sidiff.revision.configuration.impl.ConfigurationImpl;
import org.sidiff.revision.configuration.impl.SettingsImpl;
import org.sidiff.revision.configuration.test.ConfigurableA.Properties;
import org.sidiff.revision.configuration.util.ConfigUtil;

/**
 * Unit tests for the configuration plugin.
 * 
 * @author Manuel Ohrndorf
 */
public class ConfigurationTests {

	@Test
	public void testLocalConfigurableSetupPublicInjection() {
		ConfigurableA configurable = new ConfigurableA();
		configurable.configure(null); // null -> create local config

		Assert.assertNotNull(configurable.getConfig()); // config in public field
		Assert.assertNotNull(configurable.getSettings()); // settings in public field
	}

	@Test
	public void testLocalConfigurableSetupPrivateInjection() {
		ConfigurableB configurable = new ConfigurableB();
		configurable.configure(null); // null -> create local config

		Assert.assertNotNull(configurable.getConfig()); // config in private field
		Assert.assertNotNull(configurable.getSettings()); // settings in private field
	}

	@Test
	public void testInjectExistingSettings() {
		Configuration config = new ConfigurationImpl();

		Settings<ConfigurableA.Properties> settings = new SettingsImpl<>(ConfigurableA.Properties.class);
		config.add(ConfigurableA.Properties.class, settings);

		ConfigurableA configurable1 = new ConfigurableA();
		configurable1.configure(config);

		ConfigurableA configurable2 = new ConfigurableA();
		configurable2.configure(config);

		Assert.assertEquals(settings, configurable1.getSettings());
		Assert.assertEquals(settings, configurable2.getSettings());
	}

	@Test
	public void testReflectiveUtilsWithAnnotations() {
		Configuration config = new ConfigurationImpl();
		
		Settings<ConfigurableA.Properties> settings = new SettingsImpl<>(ConfigurableA.Properties.class);
		config.add(ConfigurableA.Properties.class, settings);

		ConfigurableA configurable = new ConfigurableA();
		configurable.configure(config);

		Assert.assertEquals(ConfigurableA.Properties.class, ConfigUtil.getConfigProperties(configurable)); // Properties
		Assert.assertEquals(config, ConfigUtil.getConfigField(configurable)); // Config
		Assert.assertEquals(settings, ConfigUtil.getConfigSettings(configurable)); // Settings
	}
	
	@Test
	public void testReflectiveUtilsWithoutAnnotations() {
		ConfigurableC configurableWithoutAnnotations = new ConfigurableC();
		
		Assert.assertNull(ConfigUtil.getConfigProperties(configurableWithoutAnnotations)); // Properties
		Assert.assertNull(ConfigUtil.getConfigField(configurableWithoutAnnotations)); // Config
		Assert.assertNull(ConfigUtil.getConfigSettings(configurableWithoutAnnotations)); // Settings
	}

	@Test
	public void testGlobalConfigurableSetup() {
		Configuration config = new ConfigurationImpl();

		ConfigurableA configurable = new ConfigurableA();
		configurable.configure(config); // global config

		Assert.assertEquals(config, configurable.getConfig());
		Assert.assertNotNull(config.settings(ConfigurableA.Properties.class));
		Assert.assertTrue(config.settings().contains(configurable.getSettings()));
	}

	@Test
	public void testAddRemoveSettingsOnConfiguration() {
		Configuration config = new ConfigurationImpl();

		Assert.assertTrue(config.settings().isEmpty());

		// add A:
		Settings<ConfigurableA.Properties> settingsA = new SettingsImpl<>(ConfigurableA.Properties.class);
		config.add(ConfigurableA.Properties.class, settingsA);

		Assert.assertNotNull(config.settings(ConfigurableA.Properties.class));
		Assert.assertTrue(config.settings().contains(settingsA));

		// add B:
		Settings<ConfigurableB.Properties> settingsB = new SettingsImpl<>(ConfigurableB.Properties.class);
		config.add(ConfigurableB.Properties.class, settingsB);

		Assert.assertNotNull(config.settings(ConfigurableB.Properties.class));
		Assert.assertTrue(config.settings().contains(settingsB));

		// remove A:
		config.remove(ConfigurableA.Properties.class);

		Assert.assertNull(config.settings(ConfigurableA.Properties.class));
		Assert.assertFalse(config.settings().contains(settingsA));
	}

	@Test
	public void testSetProperties() {
		Configuration config = new ConfigurationImpl();

		ConfigurableA configurable = new ConfigurableA();
		configurable.configure(config);

		// initialize settings:
		Settings<Properties> settings = config.settings(ConfigurableA.Properties.class);

		Assert.assertTrue(settings.properties().isEmpty());
		Assert.assertNull(settings.property(ConfigurableA.Properties.PROPERTY_A1));

		// set properties:
		settings.setProperty(ConfigurableA.Properties.PROPERTY_A1, "HalloWelt");
		Assert.assertEquals(1, settings.properties().size());

		settings.setProperty(ConfigurableA.Properties.PROPERTY_A2, 42);
		Assert.assertEquals(2, settings.properties().size());

		settings.setProperty(ConfigurableA.Properties.PROPERTY_A3, configurable);
		Assert.assertEquals(3, settings.properties().size());

		// get properties:
		Assert.assertEquals("HalloWelt", settings.property(ConfigurableA.Properties.PROPERTY_A1));
		Assert.assertEquals(42, settings.property(ConfigurableA.Properties.PROPERTY_A2));
		Assert.assertEquals(configurable, settings.property(ConfigurableA.Properties.PROPERTY_A3));

		// unset propery:
		settings.setProperty(ConfigurableA.Properties.PROPERTY_A1, null);
		Assert.assertEquals(2, settings.properties().size());
		Assert.assertNull(settings.property(ConfigurableA.Properties.PROPERTY_A1));
	}

	@Test
	public void testSingletons() {
		Configuration config = new ConfigurationImpl();
		
		// global:
		Assert.assertTrue(config.singletons().isEmpty());
		Assert.assertNull(config.singleton(List.class));
		
		// local:
		ConfigurableD configurable = new ConfigurableD(config);
		
		// get singleton:
		Assert.assertEquals(2, configurable.getSettings().singletons().size());
		Assert.assertTrue(configurable.getSettings().singletons().contains(List.class));
		Assert.assertTrue(configurable.getSettings().singletons().contains(Set.class));
		
		@SuppressWarnings("unchecked")
		List<String> hallo = configurable.getSettings().singleton(List.class);
		Assert.assertTrue(hallo.contains("Hallo"));
		
		@SuppressWarnings("unchecked")
		Set<String> welt = configurable.getSettings().singleton(Set.class);
		Assert.assertTrue(welt.contains("Welt"));
		
		// unset binding:
		configurable.getSettings().setSingleton(List.class, null);
		
		@SuppressWarnings("unchecked")
		List<String> notBound = configurable.getSettings().singleton(List.class);
		Assert.assertNull(notBound);
	}

	@Test
	public void testFactorys() {
		Configuration config = new ConfigurationImpl();
		
		// global:
		Assert.assertTrue(config.factories().isEmpty());
		Assert.assertNull(config.factory(List.class));
		
		// local:
		ConfigurableD configurable = new ConfigurableD(config);
		
		Assert.assertEquals(2, configurable.getSettings().factories().size());
		Assert.assertTrue(configurable.getSettings().factories().contains(List.class));
		Assert.assertTrue(configurable.getSettings().factories().contains(Set.class));
		
		// without parameters:
		Assert.assertTrue(configurable.getSettings().create(List.class) instanceof List);
		Assert.assertTrue(configurable.getSettings().create(Set.class) instanceof Set);
		
		// with parameters:
		@SuppressWarnings("unchecked")
		List<String> hallo = configurable.getSettings().create(List.class, Collections.singletonList("Hallo"));
		Assert.assertTrue(hallo.contains("Hallo"));
		
		@SuppressWarnings("unchecked")
		Set<String> welt = configurable.getSettings().create(Set.class, Collections.singleton("Welt"));
		Assert.assertTrue(welt.contains("Welt"));
		
		// unset binding:
		configurable.getSettings().setFactory(List.class, null);
		
		@SuppressWarnings("unchecked")
		List<String> notBound = configurable.getSettings().create(List.class);
		Assert.assertNull(notBound);
	}
}
