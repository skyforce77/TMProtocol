package fr.skyforce77.towerminer.protocol.packets;


public class Packet19Particle extends Packet{
	
	private static final long serialVersionUID = 888819L;
	
	public byte[] particle;
	
	public Packet19Particle() {}
	
	public Packet19Particle(Object particle) {
		this.particle = serialize(particle);
	}

}
