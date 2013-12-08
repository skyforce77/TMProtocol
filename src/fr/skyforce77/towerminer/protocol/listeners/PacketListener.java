package fr.skyforce77.towerminer.protocol.listeners;

import java.util.EventListener;

import com.esotericsoftware.kryonet.Connection;

import fr.skyforce77.towerminer.protocol.packets.Packet;

public interface PacketListener extends EventListener{

	public void onPacketReceived(Connection c, Packet p);
	
	public void onClientReceived(Connection c, Packet p);
	
	public void onServerReceived(Connection c, Packet p);

}
