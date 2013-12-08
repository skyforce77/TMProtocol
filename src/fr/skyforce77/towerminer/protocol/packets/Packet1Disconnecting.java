package fr.skyforce77.towerminer.protocol.packets;


public class Packet1Disconnecting extends Packet{
	
	public String reason;
	
	public Packet1Disconnecting() {}
	
	public Packet1Disconnecting(String reason) {
		this.reason = reason;
	}

}
