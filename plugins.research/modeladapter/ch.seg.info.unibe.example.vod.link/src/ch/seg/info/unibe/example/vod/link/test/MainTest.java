package ch.seg.info.unibe.example.vod.link.test;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import ch.seg.info.unibe.example.vod.Server;
import ch.seg.info.unibe.example.vod.User;
import ch.seg.info.unibe.example.vod.Video;
import ch.seg.info.unibe.example.vod.link.UserLink;
import default_.DefaultFactory;
import default_.DefaultPackage;
import default_.root;

public class MainTest {
	
	// TODO: Link -> ModelAdapter
	
	// xsi:schemaLocation="ch.seg.info.unibe.example.vod/default ../../../../../../../../../../ch.seg.info.unibe.example.vod.model/model/ch.seg.info.unibe.example.vod.ecore ch.seg.info.unibe.example.vod/default.ch.seg.info.unibe.example.vod ../../../../../../../../../../ch.seg.info.unibe.example.vod.model/model/ch.seg.info.unibe.example.vod.ecore#//ch/seg/info/unibe/example/vod">
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Server serverA = new Server("ServerA");
		Server serverB = new Server("ServerB");
		Server serverC = new Server("ServerC");
		Server serverD = new Server("ServerD");
		
		Video videoA = new Video("VideoA", serverA, serverB);
		Video videoB = new Video("VideoB", serverA, serverB);
		Video videoC = new Video("VideoC", serverC, serverD);
		Video videoD = new Video("VideoD", serverC, serverD);
		
		User alice = new User("Alice");
		alice.setOpen(videoA);
		
		User bob = new User("Bob");
		bob.setOpen(videoC);
		
		// Translate to model:
		Map<Object, EObject> trace = new LinkedHashMap<>();
		UserLink eBob = UserLink.__create__model__element__(bob, trace, true);
		UserLink eAlice = UserLink.__create__model__element__(alice, trace, true);
		
		// Initialize EMF
		org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.put(DefaultPackage.eNS_URI, DefaultPackage.eINSTANCE);

		ResourceSet rss = new ResourceSetImpl();
		rss.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource resource = rss.createResource(URI.createFileURI("C:\\Users\\manue\\Workspaces\\runtime-EclipseApplicationMME\\ch.seg.info.unibe.example.vod.link\\src\\ch\\seg\\info\\unibe\\example\\vod\\link\\test\\MainTest.xmi"));
		
		root root = DefaultFactory.eINSTANCE.createroot();
		trace.values().stream().forEach(e -> root.getContainedElements().add(e));
		resource.getContents().add(root);
		
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
