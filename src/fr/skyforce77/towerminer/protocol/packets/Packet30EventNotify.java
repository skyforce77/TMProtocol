package fr.skyforce77.towerminer.protocol.packets;

import fr.skyforce77.towerminer.protocol.save.TMStorage;


public class Packet30EventNotify extends Packet{
	
	private static final long serialVersionUID = 888830L;

	public byte[] storage;
	
	public Packet30EventNotify() {}
	
	public Packet30EventNotify(TMStorage storage) {
		this.storage = serialize(storage);
	}
	
	public TMStorage getStorage() {
		return (TMStorage)deserialize(storage);
	}

}