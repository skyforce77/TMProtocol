package fr.skyforce77.towerminer.protocol;

public class ObjectReceiver {

	public int id;
	public byte[] data;
	public int sent;
	public boolean[] received;
	
	public static class ReceivingThread {	
		public void run(int objectid) {}
	}

}
