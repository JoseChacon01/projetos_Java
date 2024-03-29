package com.udp;

import java.net.*;
import java.io.*;

public class UDPServer {

    public static void main(String args[]) {
        
        for(int i=2; i > 1; i++){
        DatagramSocket aSocket = null;
        String msg = null;
        try {
            
            aSocket = new DatagramSocket(1010); //7878
            byte[] buffer = new byte[1000];
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                
                System.out.println("");
                System.out.println("Executando!");
                aSocket.receive(request);
                DatagramPacket reply = new DatagramPacket(request.getData(),
                        request.getLength(), request.getAddress(), request.getPort());
                aSocket.send(reply);
                msg = new String(request.getData());
                System.out.println("Receber: " + msg);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
        }
    }
}
