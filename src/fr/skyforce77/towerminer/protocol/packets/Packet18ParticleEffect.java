package fr.skyforce77.towerminer.protocol.packets;


public class Packet18ParticleEffect extends Packet{
	
	public int x, y;
	public int color;
	public int type;
	public int data;
	
	public Packet18ParticleEffect() {}
	
	public Packet18ParticleEffect(int x, int y, int color, int type) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = type;
	}
	
	public Packet18ParticleEffect(int x, int y, int color, int type, int data) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = type;
		this.data = data;
	}

}
