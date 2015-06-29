package br.usp.icmc.ssc0103.Server;

/**
 * Created by Guilherme on 29/06/2015.
 */
public class MainServer
{
    public static void main(String[] args) {
        Server s = new Server();
        ThreadWait t = new ThreadWait(Integer.parseInt(args[0]));
        Thread tw = new Thread(t);
        tw.start();
        s.menuServer();
    }
}