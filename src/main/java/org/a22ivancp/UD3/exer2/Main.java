package org.a22ivancp.UD3.exer2;

import java.net.*;

public class Main {

    public static void main(String[] args) throws UnknownHostException, SocketException {
        InetAddress val = InetAddress.getLocalHost();
        System.out.println(val.getHostAddress());
        InterfaceAddress ia = NetworkInterface.getByInetAddress(val).getInterfaceAddresses().get(0);
        short prefix = ia.getNetworkPrefixLength();
        System.out.println(prefix);

        String maskIP = genMask(prefix);
    }

    private static String genMask(short prefix) {
        StringBuilder sb = new StringBuilder();
        int cont = prefix/8;
        int rest = prefix%8;
        for (int i = 0; i < cont; i++) {
            sb.append("255.");
        }
        int val = 0;
        for (int i = 7; 0 < rest; i--) {
            sb.append("");
        }
        return sb.toString();
    }
}