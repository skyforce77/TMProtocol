package fr.skyforce77.towerminer.protocol.packets;


public class Packet25WindowTitle extends Packet{
	
	public String title;
	
	public Packet25WindowTitle() {}
	
	public Packet25WindowTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

}
