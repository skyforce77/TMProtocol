package fr.skyforce77.towerminer.protocol.packets;

public class Packet2BigSending extends Packet{
	
	private static final long serialVersionUID = 88882L;
	
	public byte type = 0;
	public int pid = 0;
	public int lenght = 0;
	public int pack = 0;
	public byte[] data;

}
