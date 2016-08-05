package fr.skyforce77.towerminer.protocol.packets;

import java.util.ArrayList;
import java.util.UUID;

import fr.skyforce77.towerminer.protocol.Connect;
import fr.skyforce77.towerminer.protocol.Protocol;

public class Packet0Connecting extends Packet{
	
	private static final long serialVersionUID = 88880L;
	
	public int version = Protocol.version;
	public String player = "Missigno";
	public byte[] uuid;
	public byte[] plugins;
	public String game = Connect.getGame();
	
	public Packet0Connecting() {}
	
	public Packet0Connecting(int version, String player, UUID uuid, ArrayList<String> plugins) {
		this.version = version;
		this.player = player;
		this.uuid = serialize(uuid);
		this.plugins = serialize(plugins);
	}
	
	public int getVersion() {
		return version;
	}
	
	public String getPlayer() {
		return player;
	}
	
	public String getGame() {
		return game;
	}
	
	public UUID getUUID() {
		return (UUID)deserialize(uuid);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getPlugins() {
		return (ArrayList<String>)deserialize(plugins);
	}

}
