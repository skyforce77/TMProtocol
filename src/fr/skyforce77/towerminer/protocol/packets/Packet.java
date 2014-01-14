package fr.skyforce77.towerminer.protocol.packets;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import com.esotericsoftware.kryonet.Connection;

import fr.skyforce77.towerminer.protocol.Connect;

public class Packet {

	private int id = -1;

	public byte[] serialize(Object o) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
		try {
			out = new ObjectOutputStream(bos);   
			out.writeObject(o);
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Object deserialize(byte[] bytes) {
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInput in = null;
		try {
			in = new ObjectInputStream(bis);
			return in.readObject(); 
		} catch (Exception e) {}
		finally {
			try {
				bis.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int getId() {
		if(id == -1) {
			String classname = getClass().getSimpleName();
			classname = classname.replace("Packet", "");
			if(Character.isDigit(classname.charAt(0))) {
				id = Integer.parseInt(classname.charAt(0)+"");
				if(Character.isDigit(classname.charAt(1))) {
					id = id*10+Integer.parseInt(classname.charAt(1)+"");
				}
			}
		}
		return id;
	}
	
	public void onSent(Connection c) {}

	public void sendServerTCP(int destination) {
		if(Connect.server != null) {
			sendConnectionTCP(Connect.server.getConnections()[destination]);
		}
	}

	public void sendClientTCP() {
		if(Connect.client != null) {
			sendConnectionTCP(Connect.client);
		}
	}

	public void sendServerUDP(int destination) {
		if(Connect.server != null) {
			sendConnectionUDP(Connect.server.getConnections()[destination]);
		}
	}

	public void sendClientUDP() {
		if(Connect.client != null) {
			sendConnectionUDP(Connect.client);
		}
	}

	public void sendConnectionUDP(Connection c) {
		onSent(c);
		c.sendUDP(this);
	}

	public void sendConnectionTCP(Connection c) {
		onSent(c);
		c.sendTCP(this);
	}

	public void sendAllTCP() {
		if(Connect.server != null) {
			for(Connection c : Connect.server.getConnections()) {
				sendConnectionTCP(c);
			}
		}
		if(Connect.client != null) {
			sendConnectionTCP(Connect.client);
		}
	}

	public void sendAllUDP() {
		if(Connect.server != null) {
			for(Connection c : Connect.server.getConnections()) {
				sendConnectionUDP(c);
			}
		}
		if(Connect.client != null) {
			sendConnectionUDP(Connect.client);
		}
	}

}
