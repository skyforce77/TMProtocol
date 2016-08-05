package fr.skyforce77.towerminer.protocol.packets;


public class Packet25RemoveOverlayComponent extends Packet{
	
	private static final long serialVersionUID = 888825L;
	
	public String componentId;
	
	public Packet25RemoveOverlayComponent() {}
	
	public Packet25RemoveOverlayComponent(String componentId) {
		this.componentId = componentId;
	}
	
	public String getComponentId() {
		return componentId;
	}

}