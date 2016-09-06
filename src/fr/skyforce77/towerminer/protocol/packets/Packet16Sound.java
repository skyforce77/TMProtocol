package fr.skyforce77.towerminer.protocol.packets;


public class Packet16Sound extends Packet{
	
	private static final long serialVersionUID = 888816L;
	
	public boolean isMusic;
	public boolean custom;
	public String music;
	
	public Packet16Sound() {}
	
	public Packet16Sound(boolean isMusic, boolean custom, String music) {
		this.isMusic = isMusic;
		this.custom = custom;
		this.music = music;
	}

}
