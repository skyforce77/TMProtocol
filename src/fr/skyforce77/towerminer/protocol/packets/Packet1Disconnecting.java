package fr.skyforce77.towerminer.protocol.packets;

public class Packet1Disconnecting extends Packet{
	
	private static final long serialVersionUID = 88881L;
	
	public String reason;
	
	public Packet1Disconnecting() {}
	
	public Packet1Disconnecting(String reason) {
		this.reason = reason;
	}
	
	public String getReason() {
		return reason;
	}

}
