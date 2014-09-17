package fr.skyforce77.towerminer.protocol.packets;

import java.io.Serializable;


public class Packet10DataValueUpdate extends Packet{
	
	public int entity;
	public String value;
	public byte[] data;
	
	public Packet10DataValueUpdate() {}
	
	public Packet10DataValueUpdate(int entity, String value, Serializable data) {
		this.value = value;
		this.data = this.serialize(data);
		this.entity = entity;
	}

}
