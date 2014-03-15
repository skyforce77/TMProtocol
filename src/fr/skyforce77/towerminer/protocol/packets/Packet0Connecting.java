package fr.skyforce77.towerminer.protocol.packets;

import java.util.ArrayList;
import java.util.UUID;

import fr.skyforce77.towerminer.protocol.Protocol;

public class Packet0Connecting extends Packet{
	
	public int version = Protocol.version;
	public String player = "Missigno";
	public byte[] uuid;
	public byte[] plugins;
	
	public Packet0Connecting() {}
	
	public Packet0Connecting(int version, String player, UUID uuid, ArrayList<String> plugins) {
		this.version = version;
		this.player = player;
		this.uuid = serialize(uuid);
		this.plugins = serialize(plugins);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getPlugins() {
		return (ArrayList<String>)deserialize(plugins);
	}

}
