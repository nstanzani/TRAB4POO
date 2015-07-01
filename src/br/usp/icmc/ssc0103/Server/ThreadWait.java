package br.usp.icmc.ssc0103.Server;

import java.net.*;
/**
 * Created by Guilherme on 29/06/2015.
 */
public class ThreadWait implements Runnable {
    int port;
    ThreadWait(int port){
        this.port = port;
    }

    /**
     * Método responsável por ficar a espera de novas conexões e criar uma nova thread para cada novo cliente
     * conectado
     */
    @Override
    public void run(){
        try {
            ServerSocket ss = new ServerSocket(port);
            Socket s;
            while (true) {
                s = null;
                s = ss.accept();
                ThreadClient t = new ThreadClient(s);
                Thread tc = new Thread(t);
                tc.start();
            }
        }
        catch (Exception e) {
            System.out.println("Erro na conexao com o cliente: " + e);
        }
    }
}
