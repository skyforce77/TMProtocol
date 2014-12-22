package fr.skyforce77.towerminer.protocol.packets;


public class Packet28DrawImage extends Packet{
	
	public String componentId;
	public int bigSendingId = 0;
	public int x,y,width,height;
	
	public Packet28DrawImage() {}
	
	public Packet28DrawImage(String componentId, int bigSendingId, int x, int y, int width, int height) {
		this.componentId = componentId;
		this.bigSendingId = bigSendingId;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public String getComponentId() {
		return componentId;
	}

}