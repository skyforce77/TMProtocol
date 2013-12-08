package fr.skyforce77.towerminer.protocol.packets;


public class Packet16Sound extends Packet{
	
	public int channel;
	public boolean custom;
	public String music;
	
	public Packet16Sound() {}
	
	public Packet16Sound(int channel, boolean custom, String music) {
		this.channel = channel;
		this.custom = custom;
		this.music = music;
	}

}
