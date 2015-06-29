package br.usp.icmc.ssc0103.Server;

import java.io.*;
import java.util.*;

/**
 * Created by arnaldo on 26/06/15.
 */
public class Market {

    Scanner scanner = new Scanner(System.in);

    public void registerNewProduct() {
        try {
            FileWriter fw = new FileWriter("products.csv", true);
            Product product;
            String name, provider;
            float price;
            int quantity;
            System.out.println("Digite o nome do produto: ");
            name = scanner.nextLine();
            System.out.println("Digite o nome do fabricante: ");
            provider = scanner.nextLine();
            System.out.println("Digite o preco: ");
            price = Float.parseFloat(scanner.nextLine());
            System.out.println("Digite a quantidade desse produto no estoque no momento: ");
            quantity = Integer.parseInt(scanner.nextLine());
            product = new Product(name, price, provider, quantity);
            fw.write(product.toFile());
            System.out.println("Adicionado com sucesso");
            fw.close();
        }
        catch (Exception e){
            System.out.println("Erro ao abrir o arquivo: " + e);
        }
    }
    public void listProducts() {
        try {
            String line;
            String[] splitLine;
            Product prod;
            BufferedReader products = new BufferedReader(new FileReader("products.csv"));
            while((line = products.readLine()) != null){
                splitLine = line.split(",");
                prod = new Product(splitLine[0], Float.parseFloat(splitLine[1]), splitLine[2], Integer.parseInt(splitLine[3]));
                System.out.println(prod + "\n");
            }
        }
        catch (Exception e){
            System.out.println("Erro ao recuperar os produtos: " + e);
        }
    }
    public void updateStock() {

    }
}