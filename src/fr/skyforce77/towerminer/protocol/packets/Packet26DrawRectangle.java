package fr.skyforce77.towerminer.protocol.packets;


public class Packet26DrawRectangle extends Packet{
	
	public String componentId;
	public int x,y,width,height;
	
	public Packet26DrawRectangle() {}
	
	public Packet26DrawRectangle(String componentId, int x, int y, int width, int height) {
		this.componentId = componentId;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public String getComponentId() {
		return componentId;
	}

}