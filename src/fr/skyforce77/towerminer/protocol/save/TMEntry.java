package fr.skyforce77.towerminer.protocol.save;

import java.io.Serializable;

public class TMEntry implements Serializable{

	private static final long serialVersionUID = -2259281015682699241L;
	
	public static short BYTE = 0;
	public static short SHORT = 1;
	public static short INTEGER = 2;
	public static short LONG = 3;
	public static short FLOAT = 4;
	public static short DOUBLE = 5;
	public static short BOOLEAN = 6;
	public static short STRING = 7;
	public static short TMSTORAGE = 8;
	public static short TMIMAGE = 9;
	public static short UNKNOWN = 100;
	
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
