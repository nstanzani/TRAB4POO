package br.usp.icmc.ssc0103.Server;

import br.usp.icmc.ssc0103.Client.User;

import java.net.*;
import java.io.*;

/**
 * Created by Guilherme on 29/06/2015.
 */

public class ThreadClient implements Runnable {
    PrintWriter sockOut;
    BufferedReader sockIn;

    ThreadClient(Socket s){
        try {
            this.sockOut = new PrintWriter(s.getOutputStream(), true);
            this.sockIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        }
        catch (Exception e){
            System.out.println("Erro na conexao: " + e);
        }
    }

    public void run(){
        try {
            System.out.println("Nova conexao realizada no servidor!");
            String cmdLine;
            String[] splitLine, values;
            Market market = new Market();
            Server server = new Server();
            while ((cmdLine = sockIn.readLine()) != null) {
                if (Thread.interrupted()) {
                    break;
                }
                if(cmdLine.equals("listar")){
                    market.listProducts(sockOut);
                }
                else {
                    splitLine = cmdLine.split(":");
                    if (splitLine[0].equals("login")){
                        values = splitLine[1].split(",");
                        if(server.login(Integer.parseInt(values[0]), values[1]))
                            sockOut.println("true");
                        else
                            sockOut.println("false");
                    }
                    else if(splitLine[0].equals("registrar")){
                        server.register(splitLine[1]);
                    }
                    else if(splitLine[0].equals("comprar")){
                        values = splitLine[1].split(",");
                        market.makeBuy(values[0], Integer.parseInt(values[1]));
                    }
                }
            }
        }
        catch(Exception e) {
            System.out.println("Erro na conexao servidor/cliente: " + e);
        }
    }
}
