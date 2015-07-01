package br.usp.icmc.ssc0103.Client;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    static BufferedReader sockIn;
    static PrintWriter sockOut;
    static ClientConnection server = new ClientConnection();
    static Scanner scanner = new Scanner(System.in);
    static Optional<User> user;

    /**
     * Método responsável por iniciar a aplicação do cliente e conectá-lo ao servidor
     */
    public static void main(String[] args) {
        try {
            Socket socket;
            socket = server.connect(args);
            if(socket == null){
                System.out.println("Conexao nao estabelecida, cheque se o ip e a porta foram colocados corretamente");
                System.exit(0);
            }
            sockIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sockOut = new PrintWriter(socket.getOutputStream(), true);
            menuIni();
        }
        catch(Exception e){
            System.out.println("Erro na conexao: " + e);
        }
    }

    /**
     * Imprime o menu de opções do cliente e seleciona a opção desejada
     */
    public static void menuIni(){
        try {
            int opt;
            do {
                System.out.println("\t\tMenu\n");
                System.out.println("1 - Login");
                System.out.println("2 - Cadastar usuario");
                System.out.println("0 - Sair");
                opt = Integer.parseInt(scanner.nextLine());
                switch (opt) {
                    case 1:
                        if (server.login(sockIn, sockOut))
                            menuLogged();
                        break;
                    case 2:
                        server.registerNewUser(sockIn, sockOut);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                }
            } while (opt != 0);
        }
        catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }

    /**
     * Imprime o menu para o usuário que já está logado, mostrando novas opções de ação
     */
    public static void menuLogged() {
        int opt;
        do{
            System.out.println("\t\tMenu\n");
            System.out.println("1 - Listar todos os produtos");
            System.out.println("2 - Efetuar uma compra");
            System.out.println("0 - Sair");
            opt = Integer.parseInt(scanner.nextLine());
            switch(opt){
                case 1:
                    server.getProducts(sockIn, sockOut);
                    break;
                case 2:
                    server.buyProduct(sockIn, sockOut);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while(opt != 0);
    }
}
