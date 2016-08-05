package fr.skyforce77.towerminer.protocol.packets;


public class Packet4RoundFinished extends Packet{
	
	private static final long serialVersionUID = 88884L;
	
	public int life;
	public int gold;
	public int round;
	public boolean timed = true;
	
	public Packet4RoundFinished(){}
	
	public Packet4RoundFinished(int life, int gold, int round) {
		this.life = life;
		this.gold = gold;
		this.round = round;
	}

	public Packet4RoundFinished(int life, int gold, int round, boolean timed) {
		this.life = life;
		this.gold = gold;
		this.round = round;
		this.timed = timed;
	}

}
