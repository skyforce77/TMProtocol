package fr.skyforce77.towerminer.protocol.packets;

import java.awt.Point;


public class Packet6EntityCreate extends Packet{
	
	public int eid = 0;
	public int type = 0;
	public int x = 0;
	public int y = 0;
	public String owner = "";
	public int shooter = 0;
	public int mob = 0;
	
	public Packet6EntityCreate() {}
	
	public Packet6EntityCreate(int eid, int type) {
		this.type = type;
		this.eid = eid;
	}
	
	public Packet6EntityCreate(int eid, int type, Point location, String owner) {
		this.type = type;
		this.x = location.x;
		this.y = location.y;
		this.owner = owner;
		this.eid = eid;
	}
	
	public Packet6EntityCreate(int eid, int type, int shooter, int mob) {
		this.type = type;
		this.shooter = shooter;
		this.mob = mob;
		this.eid = eid;
	}

}
