package fr.skyforce77.towerminer.protocol;

import java.util.ArrayList;
import java.util.HashMap;

import com.esotericsoftware.kryonet.Connection;

import fr.skyforce77.towerminer.protocol.ObjectReceiver.ReceivingThread;
import fr.skyforce77.towerminer.protocol.packets.Packet2BigSending;

public class BigSending {
	
	public static ArrayList<BigSending> sendlist = new ArrayList<>();
	public static HashMap<Integer, ObjectReceiver> receiving = new HashMap<Integer, ObjectReceiver>();
	public static HashMap<Integer, ObjectSender> sending = new HashMap<Integer, ObjectSender>();
	public static int bytesize = 2000;

	public Object object;
	public Connection client;
	public ReceivingThread run;
	
	public BigSending(Object object, Connection client, ReceivingThread run) {
		this.object = object;
		this.client = client;
		this.run = run;
		sendlist.add(this);
	}
	
	public static void initBigSending() {
		new Thread("BigSending") {
			@Override
			public void run() {
				while(!Thread.interrupted()) {
					if(sendlist.size() >= 1 && sendlist.get(0) != null) {
						try {
							boolean ok = sendlist.get(0).send();
							if(ok) {
								sendlist.remove(0);
							} else {
								BigSending bs = sendlist.get(0);
								sendlist.remove(0);
								sendlist.add(bs);
							}
						} catch(Exception e) {
							e.printStackTrace();
							BigSending bs = sendlist.get(0);
							sendlist.remove(0);
							sendlist.add(bs);
						}
					} else {
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
	}
	
	public boolean send() {
		byte[] map = new Packet2BigSending().serialize(object);
		int lenght = 0;
		int id = 0;
		ArrayList<byte[]> datas = new ArrayList<byte[]>();
		
		while(receiving.get(id) != null) {
			id++;
		}
		
		while(lenght < map.length) {
			byte[] data = null;
			if(lenght+bytesize > map.length) {
				data = new byte[map.length-lenght];
			} else {
				data = new byte[bytesize];
			}

			int i = 0;
			while(i < data.length) {
				data[i] = map[lenght+i];
				i++;
			}
			
			lenght+=data.length;
			datas.add(data);
		}
		
		Packet2BigSending init = new Packet2BigSending();
		init.data = init.serialize(datas.size());
		init.lenght = map.length;
		init.type = 0;
		init.pid = id;
		init.sendConnectionTCP(client);
		
		ObjectSender sender = new ObjectSender();
		sender.packets = new Packet2BigSending[datas.size()+10];
		sender.thread = run;
		sending.put(id, sender);
		
		int i = 0;
		while(i < datas.size()) {
			Packet2BigSending send = new Packet2BigSending();

			send.data = datas.get(i);
			send.pack = i;
			send.type = 1;
			send.pid = id;
			send.lenght = map.length;

			send.sendConnectionTCP(client);
			
			sending.get(id).packets[i] = send;
			i++;
			
			try {
				Thread.sleep(2l);
				if(i > 10)
					Thread.sleep(2l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(30l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Packet2BigSending send = new Packet2BigSending();

		send.type = 2;
		send.pack = i;
		send.pid = id;

		sending.get(id).testpacket = send;
		send.sendConnectionTCP(client);
		return true;
	}
	
	public static boolean receive(int id, int lenght, int pack, byte[] data) {
		receiving.get(id).data = add(receiving.get(id).data, pack*bytesize, data);
		receiving.get(id).received[pack] = true;
		return pack*bytesize+data.length >= lenght;
	}
	
	public static byte[] add(byte[] base, int start, byte[] data) {
		int i = 0;
		while(i < data.length) {
			base[i+start] = data[i];
			i++;
		}
		return base;
	}

}
