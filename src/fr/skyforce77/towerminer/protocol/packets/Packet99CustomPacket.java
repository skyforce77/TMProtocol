package fr.skyforce77.towerminer.protocol.packets;

public class Packet99CustomPacket extends Packet {

	private static final long serialVersionUID = -1012892895918653801L;
	
	public byte[] data;
	
	public Packet99CustomPacket() {}
	
	public Packet99CustomPacket(CustomPacket packet) {
		this.data = serialize(packet);
	}
	
	public CustomPacket getPacket() {
		return (CustomPacket)deserialize(data);
	}

}
