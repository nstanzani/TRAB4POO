package br.usp.icmc.ssc0103.Server;

import java.io.*;
import java.util.*;
/**
 * Created by Guilherme on 29/06/2015.
 */
public class Server {

    Scanner scanner = new Scanner(System.in);
    Market market = new Market();

    /**
     * Imprime o menu do servidor, com opções específicas para o dono do sistema
     */
    public void menuServer(){
        int opt;
        do{
            System.out.println("\t\tMenu\n");
            System.out.println("1 - Registrar novo produto");
            System.out.println("2 - Listar todos os produtos");
            System.out.println("3 - Atualizar o estoque (fazer pedido dos produtos em falta)");
            System.out.println("0 - Sair");
            opt = Integer.parseInt(scanner.nextLine());
            switch(opt){
                case 1:
                    market.registerNewProduct();
                    break;
                case 2:
                    market.listProducts(new PrintWriter(System.out, true));
                    break;
                case 3:
                    market.updateStock();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while(opt != 0);
    }

    /**
     * Registra o cadastro de um usuário no sistema
     */
    public void register(String value){
        try {
            FileWriter fw = new FileWriter("users.csv", true);
            fw.write(value + "\n");
            fw.close();
        }
        catch(Exception e){
            System.out.println("Erro ao gravar no arquivo: " + e);
        }
    }

    /**
     * Loga o usuário no sistema
     */
    public boolean login(int id, String pass){
        try {
            BufferedReader users = new BufferedReader(new FileReader("users.csv"));
            String line;
            String[] splitLine;
            while ((line = users.readLine()) != null){
                splitLine = line.split(",");
                if(Integer.parseInt(splitLine[5]) == id && splitLine[4].equals(pass)) {
                    return true;
                }
            }
            return false;
        }
        catch(Exception e){
            System.out.println("Erro ao ler o arquivo: " + e);
            return false;
        }
    }
}
