package fr.skyforce77.towerminer.protocol;

import fr.skyforce77.towerminer.protocol.ObjectReceiver.ReceivingThread;
import fr.skyforce77.towerminer.protocol.packets.Packet2BigSending;

public class ObjectSender {

	public Packet2BigSending[] packets;
	public Packet2BigSending testpacket;
	public ReceivingThread thread;

}
