package org.a22ivancp.UD3.exer1;

import java.net.*;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        Stream<NetworkInterface> list = NetworkInterface.networkInterfaces();
        for (NetworkInterface ni: list.toList()) {
            List<InterfaceAddress> c;
            if (!(c = ni.getInterfaceAddresses()).isEmpty()){
                System.out.println(ni.getName());
                for (InterfaceAddress address: c) {
                    System.out.println(address.getAddress().toString());
                }
                System.out.println("-----------------------\n");
            }
        }
    }
}
