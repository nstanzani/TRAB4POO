package br.usp.icmc.ssc0103.Server;

public class MainServer
{
    /**
     * Inicia a aplicação do servidor
     */
    public static void main(String[] args) {
        Server s = new Server();
        ThreadWait t = new ThreadWait(Integer.parseInt(args[0]));
        Thread tw = new Thread(t);
        tw.start();
        s.menuServer();
    }
}