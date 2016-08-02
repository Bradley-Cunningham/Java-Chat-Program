/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_chat_program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Bradley
 */
public class SocketServer extends Thread{
    private ChatGui gui;
    
    public SocketServer(ChatGui gui){
        this.gui = gui;
    }

     @Override
     public void run() {
        while(!this.isInterrupted()){
        ServerSocket serverSocket = null;
        String reply = "";
        try {
            serverSocket = new ServerSocket(1521);

            Socket clientSocket = null;
            clientSocket = serverSocket.accept();
            System.out.println("Socket setup");
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //------------------------------------------------------------------
            String textFromClient = in.readLine(); // read the text from client
            gui.newText(textFromClient);
            //------------------------------------------------------------------
            in.close();
            clientSocket.close();
            serverSocket.close();
            //------------------------------------------------------------------
        } catch (IOException e) {
        }
         }
    }
    
}
