package fr.skyforce77.towerminer.protocol.packets;


public class Packet3Action extends Packet{
	
	public String action;
	public byte[] data;
	
	public Packet3Action() {}
	
	public Packet3Action(String action) {
		this.action = action;
	}
	
	public Packet3Action(String action, byte... data) {
		this.action = action;
		this.data = data;
	}

}
