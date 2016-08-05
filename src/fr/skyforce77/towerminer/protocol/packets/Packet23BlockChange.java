package fr.skyforce77.towerminer.protocol.packets;


public class Packet23BlockChange extends Packet{
	
	private static final long serialVersionUID = 888823L;
	
	public int x,y,type,data;
	public boolean overlay;
	public byte[] storage;
	
	public Packet23BlockChange() {}

	public Packet23BlockChange(int x, int y, int type, int data, boolean overlay) {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
		this.data = data;
		this.overlay = overlay;
	}
	
	public Packet23BlockChange(int x, int y, int type, int data, boolean overlay, Object storage) {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
		this.data = data;
		this.overlay = overlay;
		this.storage = serialize(storage);
	}
	
	public Object getStorage() {
		return deserialize(storage);
	}
	
	public boolean hasStorage() {
		return storage != null;
	}

}
