package br.usp.icmc.ssc0103.Client;

import java.io.*;
import java.net.*;
import java.util.*;


public class ClientConnection {
    Socket socket;
    Scanner scanner = new Scanner(System.in);

    /**
     * Realiza a conexão com o servidor
     */
    public Socket connect(String[] args) {
        try {
            int port = Integer.parseInt(args[1]);
            socket = new Socket(args[0], port);
            return socket;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Registra um novo usuário no sistema do supermercado, possibilitando-o a logar-se e comprar produtos
     */
    public void registerNewUser(BufferedReader sockIn, PrintWriter sockOut) {
        User user;
        int id;
        String name, address, phone, email, password;
        System.out.println("Digite o nome: ");
        name = scanner.nextLine();
        System.out.println("Digite o endereco: ");
        address = scanner.nextLine();
        System.out.println("Digite o telefone: ");
        phone = scanner.nextLine();
        System.out.println("Digite o email: ");
        email = scanner.nextLine();
        System.out.println("Digite a senha: ");
        password = scanner.nextLine();
        System.out.println("Digite o ID: ");
        id = Integer.parseInt(scanner.nextLine());
        user = new User(name, address, phone, email, password, id);
        sockOut.println("registrar:" + user.toFile());
        System.out.println("Adicionado com sucesso");
    }

    /**
     * Permite o login do usuário no sistema, comparando seu ID e senha cadastrados
     */
    public boolean login(BufferedReader sockIn, PrintWriter sockOut) {
        try {
            int id;
            String pass, line;
            System.out.println("Digite o ID: ");
            id = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite a senha: ");
            pass = scanner.nextLine();
            sockOut.println("login:" + id + "," + pass);
            line = sockIn.readLine();
            if (line.equals("true"))
                return true;
            System.out.println("Dados incorretos");
            return false;
        }
        catch(Exception e){
            System.out.println("Erro ao abrir o arquivo no servidor: " + e);
            return false;
        }
    }

    /**
     * Adquire a lista de produtos do servidor para mostrar ao usuário
     */
    public void getProducts(BufferedReader sockIn, PrintWriter sockOut) {
        try {
            String line;
            sockOut.println("listar");
            while ((line = sockIn.readLine()).equals("Fim da listagem") != true) {
                System.out.println(line);
            }
        }
        catch(Exception e){
            System.out.println("Erro na listagem: " + e);
        }
    }

    /**
     * Permite a compra de produtos por usuários que estejam logados no sistema e atualizada a disponibilidade
     * dos produtos
     */
    public void buyProduct(BufferedReader sockIn, PrintWriter sockOut) {
        try {
            String name;
            String returned;
            int quantity;
            System.out.println("Digite o nome do produto que deseja comprar:");
            name = scanner.nextLine();
            System.out.println("Digite a quantidade que deseja comprar: ");
            quantity = Integer.parseInt(scanner.nextLine());
            sockOut.println("comprar:" + name + "," + quantity);
            returned = sockIn.readLine();
            if(returned.equals("true"))
                System.out.println("Compra realizada com sucesso");
            else
                System.out.println("Problema na compra: o produto pode nao existir ou nao ter estoque suficiente. Tente novamente");
        }
        catch(Exception e){
            System.out.println("Erro ao executar a compra: " + e);
        }
    }
}
