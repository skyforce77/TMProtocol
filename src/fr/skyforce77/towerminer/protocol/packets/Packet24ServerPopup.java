package fr.skyforce77.towerminer.protocol.packets;


public class Packet24ServerPopup extends Packet{
	
	public String message;
	public String[] description;
	public int imageid;
	public long time;
	
	public Packet24ServerPopup() {}
	
	public Packet24ServerPopup(String message, String[] description, int imageid, long time) {
		this.message = message;
		this.description = description;
		this.imageid = imageid;
		this.time = time;
	}

}
