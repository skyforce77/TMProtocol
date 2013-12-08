package fr.skyforce77.towerminer.protocol.packets;

import fr.skyforce77.towerminer.protocol.Protocol;

public class Packet0Connecting extends Packet{
	
	public int version = Protocol.version;
	public String player = "Missigno";
	
	public Packet0Connecting() {}
	
	public Packet0Connecting(int version, String player) {
		this.version = version;
		this.player = player;
	}

}
