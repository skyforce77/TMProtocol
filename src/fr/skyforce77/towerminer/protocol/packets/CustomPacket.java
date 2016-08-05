package fr.skyforce77.towerminer.protocol.packets;

import com.esotericsoftware.kryonet.Connection;

public class CustomPacket extends Packet {
	
	private static final long serialVersionUID = 2949368968737322185L;

	public CustomPacket() {
		super();
	}

	public void sendConnectionUDP(Connection c) {
		onSent(c);
		c.sendUDP(new Packet99CustomPacket(this));
	}

	public void sendConnectionTCP(Connection c) {
		onSent(c);
		c.sendTCP(new Packet99CustomPacket(this));
	}

}
