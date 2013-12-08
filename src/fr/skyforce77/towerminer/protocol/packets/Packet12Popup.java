package fr.skyforce77.towerminer.protocol.packets;

import java.awt.Image;


public class Packet12Popup extends Packet{
	
	public String message;
	public String option;
	public String image;
	public byte[] imagedata;
	
	public Packet12Popup() {}
	
	public Packet12Popup(String message) {
		this.message = message;
	}
	
	public Packet12Popup(String message, String option) {
		this.message = message;
		this.option = option;
	}
	
	public Packet12Popup(String message, String option, String image) {
		this.message = message;
		this.option = option;
		this.image = image;
	}
	
	public Packet12Popup(String message, String option, Image image) {
		this.message = message;
		this.option = option;
		this.imagedata = serialize(image);
	}

}
