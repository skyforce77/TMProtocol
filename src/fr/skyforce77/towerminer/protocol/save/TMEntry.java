package fr.skyforce77.towerminer.protocol.save;

import java.io.Serializable;

public class TMEntry implements Serializable{

	private static final long serialVersionUID = -2259281015682699241L;
	
	public final static short UNKNOWN = -1;
	public final static short BYTE = 0;
	public final static short SHORT = 1;
	public final static short INTEGER = 2;
	public final static short LONG = 3;
	public final static short FLOAT = 4;
	public final static short DOUBLE = 5;
	public final static short BOOLEAN = 6;
	public final static short STRING = 7;
	public final static short TMSTORAGE = 8;
	public final static short TMIMAGE = 9;
	
	private short type;
	private Serializable entry;
	
	public TMEntry(short type, Serializable entry) {
		this.type = type;
		this.entry = entry;
	}
	
	public Serializable getEntry() {
		return entry;
	}
	
	public short getType() {
		return type;
	}
}
