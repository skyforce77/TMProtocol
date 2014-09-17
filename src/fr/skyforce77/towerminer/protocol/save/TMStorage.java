package fr.skyforce77.towerminer.protocol.save;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class TMStorage implements Serializable {

	private static final long serialVersionUID = -7775936155165721980L;
	
	private HashMap<String, TMEntry> entries = new HashMap<String, TMEntry>();

	public TMStorage(){};
	
	public void addObject(String key, Serializable value)
	{
		short type = TMEntry.UNKNOWN;
		if(value instanceof Boolean) {
			type = TMEntry.BOOLEAN;
		} else if(value instanceof Byte) {
			type = TMEntry.BYTE;
		} else if(value instanceof Double) {
			type = TMEntry.DOUBLE;
		} else if(value instanceof Float) {
			type = TMEntry.FLOAT;
		} else if(value instanceof Integer) {
			type = TMEntry.INTEGER;
		} else if(value instanceof Long) {
			type = TMEntry.LONG;
		} else if(value instanceof Short) {
			type = TMEntry.SHORT;
		} else if(value instanceof String) {
			type = TMEntry.STRING;
		} else if(value instanceof TMImage) {
			type = TMEntry.TMIMAGE;
		} else if(value instanceof TMStorage) {
			type = TMEntry.TMSTORAGE;
		}
		entries.put(key, new TMEntry(type, value));
	}
	
	public void addObject(String key, short type, Serializable value)
	{
		entries.put(key, new TMEntry(type, value));
	}
	
	public void addString(String key, String value)
	{
		entries.put(key, new TMEntry(TMEntry.STRING, value));
	}
	
	public void addInteger(String key, Integer value)
	{
		entries.put(key, new TMEntry(TMEntry.INTEGER, value));
	}
	
	public void addLong(String key, Long value)
	{
		entries.put(key, new TMEntry(TMEntry.LONG, value));
	}
	
	public void addDouble(String key, Double value)
	{
		entries.put(key, new TMEntry(TMEntry.DOUBLE, value));
	}
	
	public void addFloat(String key, Float value)
	{
		entries.put(key, new TMEntry(TMEntry.FLOAT, value));
	}
	
	public void addByte(String key, Byte value)
	{
		entries.put(key, new TMEntry(TMEntry.BYTE, value));
	}
	
	public void addBoolean(String key, Boolean value)
	{
		entries.put(key, new TMEntry(TMEntry.BOOLEAN, value));
	}
	
	public void addTMStorage(String key, TMStorage value)
	{
		entries.put(key, new TMEntry(TMEntry.TMSTORAGE, value));
	}
	
	public void addTMImage(String key, TMImage value)
	{
		entries.put(key, new TMEntry(TMEntry.TMIMAGE, value));
	}
	
	public TMEntry getEntry(String key)
	{
		return entries.get(key);
	}
	
	public Object getObject(String key)
	{
		return entries.get(key).getEntry();
	}
	
	public String getString(String key)
	{
		if(entries.containsKey(key) && entries.get(key).getType() == TMEntry.STRING)
		{
			return (String)entries.get(key).getEntry();
		}
		else
		{
			return "";
		}
	}
	
	public Integer getInteger(String key)
	{
		if(entries.containsKey(key) && entries.get(key).getType() == TMEntry.INTEGER)
		{
			return (Integer)entries.get(key).getEntry();
		}
		else
		{
			return 0;
		}
	}
	
	public Long getLong(String key)
	{
		if(entries.containsKey(key) && entries.get(key).getType() == TMEntry.LONG)
		{
			return (Long)entries.get(key).getEntry();
		}
		else
		{
			return (long)0;
		}
	}
	
	public Double getDouble(String key)
	{
		if(entries.containsKey(key) && entries.get(key).getType() == TMEntry.DOUBLE)
		{
			return (Double)entries.get(key).getEntry();
		}
		else
		{
			return (double)0;
		}
	}
	
	public Float getFloat(String key)
	{
		if(entries.containsKey(key) && entries.get(key).getType() == TMEntry.FLOAT)
		{
			return (Float)entries.get(key).getEntry();
		}
		else
		{
			return (float)0;
		}
	}
	
	public Byte getByte(String key)
	{
		if(entries.containsKey(key) && entries.get(key).getType() == TMEntry.BYTE)
		{
			return (Byte)entries.get(key).getEntry();
		}
		else
		{
			return (byte)0;
		}
	}
	
	public Boolean getBoolean(String key)
	{
		if(entries.containsKey(key) && entries.get(key).getType() == TMEntry.BOOLEAN)
		{
			return (Boolean)entries.get(key).getEntry();
		}
		else
		{
			return false;
		}
	}
	
	public TMStorage getTMStorage(String key)
	{
		if(entries.containsKey(key) && entries.get(key).getType() == TMEntry.TMSTORAGE)
		{
			return (TMStorage)entries.get(key).getEntry();
		}
		else
		{
			return null;
		}
	}
	
	public TMImage getTMImage(String key)
	{
		if(entries.containsKey(key) && entries.get(key).getType() == TMEntry.TMIMAGE)
		{
			return (TMImage)entries.get(key).getEntry();
		}
		else
		{
			return null;
		}
	}
	
	public HashMap<String, TMEntry> getValues()
	{
		return entries;
	}
	
	public void add(TMStorage storage)
	{
		for(Object s : storage.getValues().keySet())
		{
			entries.put((String)s, storage.getValues().get(s));
		}
	}
	
	public Boolean Serialize(String file)
	{
		try
		{
			new File(file).getParentFile().mkdirs();
			FileOutputStream fichier = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fichier);
			oos.writeObject(this);
			oos.flush();
			oos.close();
			return true;
		}
		catch (java.io.IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public static TMStorage Deserialize(String file)
	{
		try
		{
			FileInputStream fichier = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fichier);
			TMStorage o = (TMStorage)ois.readObject();
			ois.close();
			return o;
		}
		catch (Exception e) 
		{
			return new TMStorage();
		}
	}

}
