package fr.skyforce77.towerminer.protocol.packets;

import fr.skyforce77.towerminer.protocol.save.TMStorage;


public class Packet27UpdateOverlayComponent extends Packet{
	
	public String componentId;
	public byte[] storage;
	
	public Packet27UpdateOverlayComponent() {}
	
	public Packet27UpdateOverlayComponent(String componentId, TMStorage storage) {
		this.componentId = componentId;
		this.storage = serialize(storage);
	}
	
	public String getComponentId() {
		return componentId;
	}
	
	public TMStorage getStorage() {
		return (TMStorage)deserialize(storage);
	}

}