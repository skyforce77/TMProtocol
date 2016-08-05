package fr.skyforce77.towerminer.protocol.packets;

import java.util.Date;

import com.esotericsoftware.kryonet.Connection;

import fr.skyforce77.towerminer.protocol.Protocol;


public class Packet15ServerInfos extends Packet{
	
	private static final long serialVersionUID = 888815L;
	
	public int version = Protocol.version;
	public long date;
	public String name;
	public String message;
	
	public Packet15ServerInfos() {}
	
	public Packet15ServerInfos(String name, String message) {
		this.name = name;
		this.message = message;
	}
	
	@Override
	public void onSent(Connection c) {
		date = new Date().getTime();
	}

}
