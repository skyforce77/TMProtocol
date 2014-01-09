package fr.skyforce77.towerminer.protocol.packets;

import java.util.UUID;

import fr.skyforce77.towerminer.protocol.Protocol;

public class Packet0Connecting extends Packet{
	
	public int version = Protocol.version;
	public String player = "Missigno";
	public byte[] uuid;
	
	public Packet0Connecting() {}
	
	public Packet0Connecting(int version, String player, UUID uuid) {
		this.version = version;
		this.player = player;
		this.uuid = serialize(uuid);
	}

}
