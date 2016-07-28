/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_chat_program;

/**
 *
 * @author Bradley
 */
public class SocketClient extends Thread {
    
    private String ip;
    private int port;
    private String name;
    private String message;
    
    public SocketClient(String message , String ip, int port, String name)
    {
        this.message = message;
        this.ip = ip;
        this.port = port;
        this.name = name;
    }
    
    
}
