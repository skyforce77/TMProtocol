package fr.skyforce77.towerminer.protocol.packets;

import fr.skyforce77.towerminer.protocol.save.TMStorage;


public class Packet26AddOverlayComponent extends Packet{
	
	private static final long serialVersionUID = 888826L;
	
	public String componentId;
	public byte[] storage;
	
	public Packet26AddOverlayComponent() {}
	
	public Packet26AddOverlayComponent(String componentId, TMStorage storage) {
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