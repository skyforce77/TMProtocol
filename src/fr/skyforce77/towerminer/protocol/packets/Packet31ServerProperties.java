package fr.skyforce77.towerminer.protocol.packets;

import fr.skyforce77.towerminer.protocol.save.TMStorage;


public class Packet31ServerProperties extends Packet{
	
	private static final long serialVersionUID = 888831L;

	public byte[] storage;
	
	public Packet31ServerProperties() {}
	
	public Packet31ServerProperties(TMStorage storage) {
		this.storage = serialize(storage);
	}
	
	public TMStorage getStorage() {
		return (TMStorage)deserialize(storage);
	}

}