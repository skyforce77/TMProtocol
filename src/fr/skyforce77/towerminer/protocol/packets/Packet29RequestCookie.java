package fr.skyforce77.towerminer.protocol.packets;



public class Packet29RequestCookie extends Packet{
	
	public String name;
	
	public Packet29RequestCookie() {}
	
	public Packet29RequestCookie(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}