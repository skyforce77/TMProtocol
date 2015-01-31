package fr.skyforce77.towerminer.protocol.packets;

import fr.skyforce77.towerminer.protocol.save.TMStorage;


public class Packet28Cookie extends Packet{
	
	public String name;
	public byte[] storage;
	public int action;
	
	public Packet28Cookie() {}
	
	public Packet28Cookie(String name, TMStorage storage) {
		this.name = name;
		this.storage = serialize(storage);
	}
	
	public String getName() {
		return name;
	}
	
	/*0 = add (server to client)
	 *1 = remove (server to client)
	 *2 = response (client to server)
	 **/
	public int getAction() {
		return action;
	}
	
	public TMStorage getStorage() {
		return (TMStorage)deserialize(storage);
	}

}