package fr.skyforce77.towerminer.protocol.packets;


public class Packet20EntityStorage extends Packet{
	
	public int bigsendingid = 0;
	public int entityid = 0;
	
	public Packet20EntityStorage(){}
	
	public Packet20EntityStorage(int entityid, int bigsendingid) {
		this.entityid = entityid;
		this.bigsendingid = bigsendingid;
	}

}
