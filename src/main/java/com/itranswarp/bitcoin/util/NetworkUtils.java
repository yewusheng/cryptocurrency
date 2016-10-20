package com.itranswarp.bitcoin.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.itranswarp.cryptocurrency.common.Hash;

public class NetworkUtils {

	public static InetAddress getLocalInetAddress() {
		try {
			return InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}

	public static byte[] getIPv6(InetAddress inetAddr) {
		byte[] ip = inetAddr.getAddress();
		if (ip.length == 16) {
			return ip;
		}
		if (ip.length == 4) {
			byte[] ipv6 = new byte[16];
			ipv6[10] = -1;
			ipv6[11] = -1;
			System.arraycopy(ip, 0, ipv6, 12, 4);
			return ipv6;
		}
		throw new RuntimeException("Bad IP: " + Hash.toHexString(ip));
	}
}
