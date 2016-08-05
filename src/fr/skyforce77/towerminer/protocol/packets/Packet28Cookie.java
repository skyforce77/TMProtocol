package fr.skyforce77.towerminer.protocol.packets;



public class Packet28Cookie extends Packet{
	
	private static final long serialVersionUID = 888828L;
	
	public static final int ADD = 0;
	public static final int REMOVE = 1;
	public static final int RESPOND = 2;
	
	public String name;
	public String cookie;
	public int action;
	
	public Packet28Cookie() {}
	
	public Packet28Cookie(String name, String cookie) {
		this.name = name;
		this.cookie = cookie;
	}
	
	public Packet28Cookie(int action, String name, String cookie) {
		this.name = name;
		this.cookie = cookie;
		this.action = action;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAction() {
		return action;
	}
	
	public String getCookie() {
		return cookie;
	}

}