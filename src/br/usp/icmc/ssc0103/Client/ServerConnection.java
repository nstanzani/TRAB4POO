package br.usp.icmc.ssc0103.Client;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by arnaldo on 26/06/15.
 */
public class ServerConnection {
    Socket socket;
    Scanner scanner = new Scanner(System.in);

    public Socket connect(String[] args) {
        try {
            int port = Integer.parseInt(args[1]);
            socket = new Socket(args[0], port);

            return socket;
        } catch (Exception e) {
            return null;
        }
    }

    public void registerNewUser() {
        try {
            FileWriter fw = new FileWriter("users.csv", true);
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
            fw.write(user.toFile());
            System.out.println("Adicionado com sucesso");
            fw.close();
        }
        catch (Exception e){
            System.out.println("Erro ao abrir o arquivo: " + e);
        }
    }
    public Optional<User> login() {
        try {
            User user;
            BufferedReader users = new BufferedReader(new FileReader("users.csv"));
            int id;
            String pass, line;
            String[] splitLine;
            System.out.println("Digite o ID: ");
            id = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite a senha: ");
            pass = scanner.nextLine();
            while ((line = users.readLine()) != null){
                splitLine = line.split(",");
                user = new User(splitLine[0], splitLine[1], splitLine[2], splitLine[3], splitLine[4], Integer.parseInt(splitLine[5]));
                if(user.getID() == id && user.getPassword().equals(pass)) {
                    return Optional.of(user);
                }
            }
            System.out.println("Usuario nao encontrado");
            return Optional.empty();
        }
        catch (Exception ex){
            System.out.println("Erro ao recuperar usuarios: " + ex);
            return Optional.empty();
        }
    }
    public void getProducts() {

    }
    public void buyProduct() {

    }

}
