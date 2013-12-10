package fr.skyforce77.towerminer.protocol.listeners;

import java.util.ArrayList;
import java.util.EventListener;


public class ListenersManager {

	private static ArrayList<EventListener> listeners = new ArrayList<>();

	public static void register(EventListener listener) {
		listeners.add(listener);
	}

	public static Object callMethod(Class<? extends EventListener> handlerClass, String name, Class<?>[] classes, Object[] objects) {
		Object returns = null;
		for(EventListener listener : listeners) {
			try{
				returns = listener.getClass().getMethod(name, classes).invoke(listener, objects);
			} catch(Exception e) {}
		}
		return returns;
	}
	
	public static Object callMethod(Class<? extends EventListener> handlerClass, String name, Class<?> calledclass, Object object) {
		Object returns = null;
		for(EventListener listener : listeners) {
			try{
				returns = listener.getClass().getMethod(name, calledclass).invoke(listener, object);
			} catch(Exception e) {}
		}
		return returns;
	}

}
