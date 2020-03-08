package org.sidiff.revision.configuration.test;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.sidiff.revision.configuration.Configuration;
import org.sidiff.revision.configuration.Settings;
import org.sidiff.revision.configuration.annotations.ConfigField;
import org.sidiff.revision.configuration.annotations.ConfigSettings;
import org.sidiff.revision.configuration.impl.ConfigurationImpl;
import org.sidiff.revision.configuration.impl.SettingsImpl;
import org.sidiff.revision.configuration.test.data.ConfigurableA;
import org.sidiff.revision.configuration.test.data.ConfigurableB;
import org.sidiff.revision.configuration.test.data.ConfigurableC;
import org.sidiff.revision.configuration.test.data.ConfigurableD;
import org.sidiff.revision.configuration.test.data.ConfigurableA.Properties;
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
		config.addSettings(ConfigurableA.Properties.class, settings);

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
		config.addSettings(ConfigurableA.Properties.class, settings);

		ConfigurableA configurable = new ConfigurableA();
		configurable.configure(config);

		Assert.assertEquals(ConfigurableA.Properties.class, ConfigUtil.getConfigProperties(configurable)); // Properties
		Assert.assertEquals(config, ConfigUtil.read(configurable, ConfigField.class)); // Config
		Assert.assertEquals(settings, ConfigUtil.read(configurable, ConfigSettings.class)); // Settings
	}
	
	@Test
	public void testReflectiveUtilsWithoutAnnotations() {
		ConfigurableC configurableWithoutAnnotations = new ConfigurableC();
		
		Assert.assertNull(ConfigUtil.getConfigProperties(configurableWithoutAnnotations)); // Properties
		Assert.assertNull(ConfigUtil.read(configurableWithoutAnnotations, ConfigField.class)); // Config
		Assert.assertNull(ConfigUtil.read(configurableWithoutAnnotations, ConfigSettings.class)); // Settings
	}

	@Test
	public void testGlobalConfigurableSetup() {
		Configuration config = new ConfigurationImpl();

		ConfigurableD configurable = new ConfigurableD(config); // global config

		Assert.assertEquals(config, configurable.getConfig());
		
		Assert.assertNotNull(config.settings(ConfigurableD.Properties.class));
		Assert.assertTrue(config.settings().contains(configurable.getSettings()));
		
		Assert.assertNotNull(config.singletons(ConfigurableD.class));
		Assert.assertTrue(config.singletons().contains(configurable.getSingletons()));
		
		Assert.assertNotNull(config.factories(ConfigurableD.class));
		Assert.assertTrue(config.factories().contains(configurable.getFactories()));
	}
	
	@Test
	public void testAddRemoveSettingsOnConfiguration() {
		Configuration config = new ConfigurationImpl();

		Assert.assertTrue(config.settings().isEmpty());

		// add A:
		Settings<ConfigurableA.Properties> settingsA = new SettingsImpl<>(ConfigurableA.Properties.class);
		config.addSettings(ConfigurableA.Properties.class, settingsA);

		Assert.assertNotNull(config.settings(ConfigurableA.Properties.class));
		Assert.assertTrue(config.settings().contains(settingsA));

		// add B:
		Settings<ConfigurableB.Properties> settingsB = new SettingsImpl<>(ConfigurableB.Properties.class);
		config.addSettings(ConfigurableB.Properties.class, settingsB);

		Assert.assertNotNull(config.settings(ConfigurableB.Properties.class));
		Assert.assertTrue(config.settings().contains(settingsB));

		// remove A:
		config.removeSettings(ConfigurableA.Properties.class);

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

		Assert.assertTrue(settings.settings().isEmpty());
		Assert.assertNull(settings.get(ConfigurableA.Properties.PROPERTY_A1));

		// set properties:
		settings.set(ConfigurableA.Properties.PROPERTY_A1, "HalloWelt");
		Assert.assertEquals(1, settings.settings().size());

		settings.set(ConfigurableA.Properties.PROPERTY_A2, 42);
		Assert.assertEquals(2, settings.settings().size());

		settings.set(ConfigurableA.Properties.PROPERTY_A3, configurable);
		Assert.assertEquals(3, settings.settings().size());

		// get properties:
		Assert.assertEquals("HalloWelt", settings.get(ConfigurableA.Properties.PROPERTY_A1));
		Assert.assertEquals(42, settings.get(ConfigurableA.Properties.PROPERTY_A2));
		Assert.assertEquals(configurable, settings.get(ConfigurableA.Properties.PROPERTY_A3));

		// unset propery:
		settings.set(ConfigurableA.Properties.PROPERTY_A1, null);
		Assert.assertEquals(2, settings.settings().size());
		Assert.assertNull(settings.get(ConfigurableA.Properties.PROPERTY_A1));
	}
	
	@Test
	public void testEmpytSettings() {
		Configuration config = new ConfigurationImpl();
		Assert.assertTrue(config.settings().isEmpty());
		
		ConfigurableA configurable = new ConfigurableA();
		configurable.configure(config);
		
		Assert.assertTrue(config.settings(ConfigurableA.Properties.class).settings().isEmpty());
	}
	
	@Test
	public void testEmpytSingletons() {
		Configuration config = new ConfigurationImpl();
		Assert.assertTrue(config.singletons().isEmpty());
		
		ConfigurableA configurable = new ConfigurableA();
		configurable.configure(config);
		
		Assert.assertTrue(config.singletons(ConfigurableA.class).singletons().isEmpty());
		Assert.assertNull(config.singletons(ConfigurableA.class).get(List.class));
	}
	
	@Test
	public void testEmpytFactories() {
		Configuration config = new ConfigurationImpl();
		Assert.assertTrue(config.factories().isEmpty());
		
		ConfigurableA configurable = new ConfigurableA();
		configurable.configure(config);
		
		Assert.assertTrue(config.factories(ConfigurableA.class).factories().isEmpty());
		Assert.assertNull(config.factories(ConfigurableA.class).get(List.class));
	}

	@Test
	public void testSingletons() {
		Configuration config = new ConfigurationImpl();
		
		// local:
		ConfigurableD configurable = new ConfigurableD(config);
		
		// get singleton:
		Assert.assertEquals(2, configurable.getSingletons().singletons().size());
		Assert.assertTrue(configurable.getSingletons().singletons().contains(List.class));
		Assert.assertTrue(configurable.getSingletons().singletons().contains(Set.class));
		
		@SuppressWarnings("unchecked")
		List<String> hallo = configurable.getSingletons().get(List.class);
		Assert.assertTrue(hallo.contains("Hallo"));
		
		@SuppressWarnings("unchecked")
		Set<String> welt = configurable.getSingletons().get(Set.class);
		Assert.assertTrue(welt.contains("Welt"));
		
		// unset binding:
		configurable.getSingletons().set(List.class, null);
		
		@SuppressWarnings("unchecked")
		List<String> notBound = configurable.getSingletons().get(List.class);
		Assert.assertNull(notBound);
	}

	@Test
	public void testFactorys() {
		Configuration config = new ConfigurationImpl();
		
		// local:
		ConfigurableD configurable = new ConfigurableD(config);
		
		Assert.assertEquals(2, configurable.getFactories().factories().size());
		Assert.assertTrue(configurable.getFactories().factories().contains(List.class));
		Assert.assertTrue(configurable.getFactories().factories().contains(Set.class));
		
		// without parameters:
		Assert.assertTrue(configurable.getFactories().get(List.class).create() instanceof List);
		Assert.assertTrue(configurable.getFactories().create(Set.class) instanceof Set);
		
		// unset binding:
		configurable.getFactories().set(List.class, null);
		
		@SuppressWarnings("unchecked")
		List<String> notBound = configurable.getFactories().create(List.class);
		Assert.assertNull(notBound);
	}
}
