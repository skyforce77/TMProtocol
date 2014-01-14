package fr.skyforce77.towerminer.protocol.packets;


public class Packet19Particle extends Packet{
	
	public byte[] particle;
	
	public Packet19Particle() {}
	
	public Packet19Particle(Object particle) {
		this.particle = serialize(particle);
	}

}
