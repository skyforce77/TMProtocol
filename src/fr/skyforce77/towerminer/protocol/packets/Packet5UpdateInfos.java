package fr.skyforce77.towerminer.protocol.packets;


public class Packet5UpdateInfos extends Packet{
	
	private static final long serialVersionUID = 88885L;
	
	public int life;
	public int gold;

	public Packet5UpdateInfos() {}

	public Packet5UpdateInfos(int life, int gold) {
		this.life = life;
		this.gold = gold;
	}
	
}
