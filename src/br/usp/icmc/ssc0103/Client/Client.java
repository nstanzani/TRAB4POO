package br.usp.icmc.ssc0103.Client;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by Guilherme on 29/06/2015.
 */
public class Client {

    BufferedReader sockIn;
    PrintWriter sockOut;
    ServerConnection server = new ServerConnection();
    Scanner scanner = new Scanner(System.in);
    Optional<User> user;

    public void Connect(String[] args){
        Socket sock;
        try {
            sock = server.connect(args);
            sockIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            sockOut = new PrintWriter(sock.getOutputStream(), true);
        }
        catch (Exception ex){
            System.out.println("Erro com a conexão ao servidor: " + ex);
        }
    }

    public void menuIni(){
        int opt;
        do{
            System.out.println("\t\tMenu\n");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastar usuario");
            System.out.println("0 - Sair");
            opt = Integer.parseInt(scanner.nextLine());
            switch(opt){
                case 1:
                    user = server.login();
                    if(user.isPresent() == true)
                        menuLogged();
                    break;
                case 2:
                    server.registerNewUser();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while(opt != 0);
    }

    public void menuLogged() {
        int opt;
        do{
            System.out.println("\t\tMenu\n");
            System.out.println("1 - Listar todos os produtos");
            System.out.println("2 - Efetuar uma compra");
            System.out.println("0 - Sair");
            opt = Integer.parseInt(scanner.nextLine());
            switch(opt){
                case 1:
                    server.getProducts();
                    break;
                case 2:
                    server.buyProduct();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while(opt != 0);
    }
}
