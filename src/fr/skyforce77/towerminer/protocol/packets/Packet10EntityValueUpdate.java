package fr.skyforce77.towerminer.protocol.packets;


public class Packet10EntityValueUpdate extends Packet{
	
	public int entity;
	public String value;
	public byte[] data;
	
	public Packet10EntityValueUpdate() {}
	
	public Packet10EntityValueUpdate(int entity, String value, int data) {
		this.value = value;
		this.data = this.serialize(data);
		this.entity = entity;
	}
	
	public Packet10EntityValueUpdate(int entity, String value, Object data) {
		this.value = value;
		this.data = this.serialize(data);
		this.entity = entity;
	}

}
