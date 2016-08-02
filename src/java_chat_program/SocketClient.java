/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_chat_program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Bradley
 */
public class SocketClient extends Thread {
    
    private String ip;
    private String name;
    private String message;
   
    public SocketClient(String message ,String ip ,String name )
    {
        this.message = message;
        this.ip = ip;
        this.name = name;
    }
    
    @Override
    public void run() {
        try {
            Socket socket = null;
            PrintWriter out = null;
            System.out.println("Getting Ready");
            try {
                socket = new Socket(ip,1521);
                out = new PrintWriter(socket.getOutputStream(), true);
                System.out.println("Client Connected and ready to send");
            }   catch (IOException ex) {
                System.out.println("Failed to setup socket");
                System.out.println(ex.getMessage());
            }
            //Send message
            out.print(name + ": " + message + "\n");
            out.flush();

           //Close Socket Client
            out.close();
            socket.close();
  
        }   catch (IOException ex) {
            System.out.println("Message failed to send");
            System.out.print(ex.getMessage());
        }     
    }
}
