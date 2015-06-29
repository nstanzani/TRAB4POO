package br.usp.icmc.ssc0103.Server;

import java.net.*;
/**
 * Created by Guilherme on 29/06/2015.
 */
public class ThreadClient implements Runnable {
    Socket socket;

    ThreadClient(Socket s){
        this.socket = s;
    }
    public void run(){
        System.out.println("Entrou na thread");
    }
}
