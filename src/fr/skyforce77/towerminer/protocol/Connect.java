package fr.skyforce77.towerminer.protocol;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import fr.skyforce77.towerminer.protocol.listeners.ConnectionListener;
import fr.skyforce77.towerminer.protocol.listeners.ListenersManager;
import fr.skyforce77.towerminer.protocol.listeners.PacketListener;
import fr.skyforce77.towerminer.protocol.packets.Packet;
import fr.skyforce77.towerminer.protocol.packets.Packet0Connecting;
import fr.skyforce77.towerminer.protocol.packets.Packet10DataValueUpdate;
import fr.skyforce77.towerminer.protocol.packets.Packet11ChatMessage;
import fr.skyforce77.towerminer.protocol.packets.Packet12Popup;
import fr.skyforce77.towerminer.protocol.packets.Packet13EntityTeleport;
import fr.skyforce77.towerminer.protocol.packets.Packet14ServerPing;
import fr.skyforce77.towerminer.protocol.packets.Packet15ServerInfos;
import fr.skyforce77.towerminer.protocol.packets.Packet16Sound;
import fr.skyforce77.towerminer.protocol.packets.Packet17Player;
import fr.skyforce77.towerminer.protocol.packets.Packet18ParticleEffect;
import fr.skyforce77.towerminer.protocol.packets.Packet19Particle;
import fr.skyforce77.towerminer.protocol.packets.Packet1Disconnecting;
import fr.skyforce77.towerminer.protocol.packets.Packet20EntityStorage;
import fr.skyforce77.towerminer.protocol.packets.Packet21LoadPlugin;
import fr.skyforce77.towerminer.protocol.packets.Packet22PluginMessage;
import fr.skyforce77.towerminer.protocol.packets.Packet23BlockChange;
import fr.skyforce77.towerminer.protocol.packets.Packet24ServerPopup;
import fr.skyforce77.towerminer.protocol.packets.Packet25RemoveOverlayComponent;
import fr.skyforce77.towerminer.protocol.packets.Packet26AddOverlayComponent;
import fr.skyforce77.towerminer.protocol.packets.Packet27UpdateOverlayComponent;
import fr.skyforce77.towerminer.protocol.packets.Packet28Cookie;
import fr.skyforce77.towerminer.protocol.packets.Packet29RequestCookie;
import fr.skyforce77.towerminer.protocol.packets.Packet2BigSending;
import fr.skyforce77.towerminer.protocol.packets.Packet30EventNotify;
import fr.skyforce77.towerminer.protocol.packets.Packet31ServerProperties;
import fr.skyforce77.towerminer.protocol.packets.Packet3Action;
import fr.skyforce77.towerminer.protocol.packets.Packet4RoundFinished;
import fr.skyforce77.towerminer.protocol.packets.Packet5UpdateInfos;
import fr.skyforce77.towerminer.protocol.packets.Packet6EntityCreate;
import fr.skyforce77.towerminer.protocol.packets.Packet7EntityMove;
import fr.skyforce77.towerminer.protocol.packets.Packet8EntityRemove;
import fr.skyforce77.towerminer.protocol.packets.Packet99CustomPacket;
import fr.skyforce77.towerminer.protocol.packets.Packet9MouseClick;

public class Connect {

	public static Server server;
	public static Client client;
	public static int tcp = 25252;
	public static int udp = 25252;
	public static String localip;
	private static String game = "";

	public static boolean initServer(String gameName) {
		
		game = gameName;
		BigSending.initBigSending();
		server = new Server();
		server.start();
		try {
			server.bind(tcp,udp);
		} catch (IOException e) {
			System.err.println("[TMProtocol] Server can't be launched, port already used.");
			return false;
		}

		server.addListener(new Listener() {
			public void received (Connection connection, Object object) {
				if (object instanceof Packet) {
					ListenersManager.callMethod(PacketListener.class, "onPacketReceived", new Class<?>[]{Connection.class, Packet.class}, new Object[]{connection, object});
					ListenersManager.callMethod(PacketListener.class, "onServerReceived", new Class<?>[]{Connection.class, Packet.class}, new Object[]{connection, object});
				}
			}

			@Override
			public void connected(Connection arg0) {
				ListenersManager.callMethod(ConnectionListener.class, "onConnected", Connection.class, arg0);
			}

			@Override
			public void disconnected(Connection arg0) {
				ListenersManager.callMethod(ConnectionListener.class, "onDisconnected", Connection.class, arg0);
			}
		});

		initKryo(server.getKryo());
		return true;
	}

	public static void initClient(String gameName) {
		
		game = gameName;
		BigSending.initBigSending();
		client = new Client();
		client.start();

		client.addListener(new Listener() {
			public void received (Connection connection, Object object) {
				if (object instanceof Packet) {
					ListenersManager.callMethod(PacketListener.class, "onPacketReceived", new Class<?>[]{Connection.class, Packet.class}, new Object[]{connection, object});
					ListenersManager.callMethod(PacketListener.class, "onClientReceived", new Class<?>[]{Connection.class, Packet.class}, new Object[]{connection, object});
				}
			}

			@Override
			public void connected(Connection arg0) {
				ListenersManager.callMethod(ConnectionListener.class, "onConnected", Connection.class, arg0);
			}

			@Override
			public void disconnected(Connection arg0) {
				ListenersManager.callMethod(ConnectionListener.class, "onDisconnected", Connection.class, arg0);
			}
		});

		initKryo(client.getKryo());
	}

	public static boolean connect(String ip) {
		try {
			client.connect(5000, ip, tcp, udp);
		} catch (IOException e) {
			return false;
		}
		return client.isConnected();
	}

	public static String getLocalIp() {
		if(localip == null) {
			try {
				Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
				while (interfaces.hasMoreElements()) {
					NetworkInterface iface = interfaces.nextElement();
					if (iface.isLoopback() || !iface.isUp())
						continue;

					Enumeration<InetAddress> addresses = iface.getInetAddresses();
					while(addresses.hasMoreElements()) {
						InetAddress addr = addresses.nextElement();
						if(!addr.isLoopbackAddress() && addr.isSiteLocalAddress() && !(addr instanceof Inet6Address))
							localip = addr.getHostAddress();
					}
				}
			} catch (SocketException e) {
				throw new RuntimeException(e);
			}
			
			if(localip == null) {
				return "127.0.0.1";
			}
		}
		return localip;
	}

	public static void initKryo(Kryo kryo) {
		kryo.register(byte[].class);
		kryo.register(String[].class);
		kryo.register(byte[][].class);

		kryo.register(Packet.class);
		kryo.register(Packet0Connecting.class);
		kryo.register(Packet1Disconnecting.class);
		kryo.register(Packet2BigSending.class);
		kryo.register(Packet3Action.class);
		kryo.register(Packet4RoundFinished.class);
		kryo.register(Packet5UpdateInfos.class);
		kryo.register(Packet6EntityCreate.class);
		kryo.register(Packet7EntityMove.class);
		kryo.register(Packet8EntityRemove.class);
		kryo.register(Packet9MouseClick.class);
		kryo.register(Packet10DataValueUpdate.class);
		kryo.register(Packet11ChatMessage.class);
		kryo.register(Packet12Popup.class);
		kryo.register(Packet13EntityTeleport.class);
		kryo.register(Packet14ServerPing.class);
		kryo.register(Packet15ServerInfos.class);
		kryo.register(Packet16Sound.class);
		kryo.register(Packet17Player.class);
		kryo.register(Packet18ParticleEffect.class);
		kryo.register(Packet19Particle.class);
		kryo.register(Packet20EntityStorage.class);
		kryo.register(Packet21LoadPlugin.class);
		kryo.register(Packet22PluginMessage.class);
		kryo.register(Packet23BlockChange.class);
		kryo.register(Packet24ServerPopup.class);
		kryo.register(Packet25RemoveOverlayComponent.class);
		kryo.register(Packet26AddOverlayComponent.class);
		kryo.register(Packet27UpdateOverlayComponent.class);
		kryo.register(Packet28Cookie.class);
		kryo.register(Packet29RequestCookie.class);
		kryo.register(Packet30EventNotify.class);
		kryo.register(Packet31ServerProperties.class);
		
		kryo.register(Packet99CustomPacket.class);
	}

	public static int getServerConnection(Connection c) {
		if(server != null) {
			int i = 0;
			while(i < server.getConnections().length-1) {
				if(server.getConnections()[i].equals(c)) {
					return i;
				}
				i++;
			}
		}
		return -1;
	}
	
	public static String getGame() {
		return game;
	}

}
