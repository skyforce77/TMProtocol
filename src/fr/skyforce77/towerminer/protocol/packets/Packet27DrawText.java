package fr.skyforce77.towerminer.protocol.packets;


public class Packet27DrawText extends Packet{
	
	public String componentId;
	public String text;
	public int x,y,size;
	
	public Packet27DrawText() {}
	
	public Packet27DrawText(String componentId, int x, int y, int size, String text) {
		this.componentId = componentId;
		this.x = x;
		this.y = y;
		this.size = size;
		this.text = text;
	}
	
	public String getComponentId() {
		return componentId;
	}

}