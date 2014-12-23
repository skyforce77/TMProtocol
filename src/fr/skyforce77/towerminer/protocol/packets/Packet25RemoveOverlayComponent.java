package fr.skyforce77.towerminer.protocol.packets;


public class Packet25RemoveOverlayComponent extends Packet{
	
	public String componentId;
	
	public Packet25RemoveOverlayComponent() {}
	
	public Packet25RemoveOverlayComponent(String componentId) {
		this.componentId = componentId;
	}
	
	public String getComponentId() {
		return componentId;
	}

}