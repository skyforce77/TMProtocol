package fr.skyforce77.towerminer.protocol.packets;

import fr.skyforce77.towerminer.protocol.Protocol;


public class Packet14ServerPing extends Packet{
	
	public int version = Protocol.version;
	public String name;

}
