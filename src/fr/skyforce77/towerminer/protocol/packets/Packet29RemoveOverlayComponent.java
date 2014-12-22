package fr.skyforce77.towerminer.protocol.packets;


public class Packet29RemoveOverlayComponent extends Packet{
	
	public String componentId;
	
	public Packet29RemoveOverlayComponent() {}
	
	public Packet29RemoveOverlayComponent(String componentId) {
		this.componentId = componentId;
	}
	
	public String getComponentId() {
		return componentId;
	}

}