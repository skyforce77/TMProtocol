package fr.skyforce77.towerminer.protocol.listeners;

import java.lang.reflect.InvocationTargetException;
import java.util.EventListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class ListenersManager {

	private static List<EventListener> listeners = new CopyOnWriteArrayList<EventListener>();

	public static void register(EventListener listener) {
		listeners.add(listener);
	}

	public static Object callMethod(Class<? extends EventListener> handlerClass, String name, Class<?>[] classes, Object[] objects) {
		Object returns = null;
		for(EventListener listener : listeners) {
			try{
				returns = listener.getClass().getMethod(name, classes).invoke(listener, objects);
			} catch(NoSuchMethodException | InvocationTargetException e) {
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return returns;
	}
	
	public static Object callMethod(Class<? extends EventListener> handlerClass, String name, Class<?> calledclass, Object object) {
		Object returns = null;
		for(EventListener listener : listeners) {
			try{
				returns = listener.getClass().getMethod(name, calledclass).invoke(listener, object);
			} catch(NoSuchMethodException | InvocationTargetException e) {
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return returns;
	}

}
