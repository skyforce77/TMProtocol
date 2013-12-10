package fr.skyforce77.towerminer.protocol.listeners;

import java.util.EventListener;

import com.esotericsoftware.kryonet.Connection;

public interface ConnectionListener extends EventListener{

	public void onConnected(Connection c);
	
	public void onDisconnected(Connection c);

}
