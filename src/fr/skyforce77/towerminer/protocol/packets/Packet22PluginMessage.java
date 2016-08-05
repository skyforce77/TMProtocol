package fr.skyforce77.towerminer.protocol.packets;


public class Packet22PluginMessage extends Packet{
	
	private static final long serialVersionUID = 888822L;
	
	public String plugin;
	public String version;
	public int type;
	public byte[] data;
	
	public Packet22PluginMessage() {}
	
	public Packet22PluginMessage(String plugin, String version, int type, Object data) {
		this.plugin = plugin;
		this.version = version;
		this.type = type;
		this.data = serialize(data);
	}

}
