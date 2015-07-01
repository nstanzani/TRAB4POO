package br.usp.icmc.ssc0103.Server;

import java.io.*;
import java.util.*;

public class Market {

    Scanner scanner = new Scanner(System.in);
    static List<Product> list = new LinkedList<Product>();

    /**
     * Permite o registro de um novo produto no sistema
     */
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

    /**
     * Imprime a lista de produtos e as suas disponibilidades no sistema
     */
    public void listProducts(PrintWriter fw) {
        try {
            String line;
            String[] splitLine;
            Product prod;
            FileReader fr = new FileReader("products.csv");
            BufferedReader products = new BufferedReader(fr);
            while((line = products.readLine()) != null){
                splitLine = line.split(",");
                prod = new Product(splitLine[0], Float.parseFloat(splitLine[1]), splitLine[2], Integer.parseInt(splitLine[3]));
                fw.println(prod + "\n");
            }
            fw.println("Fim da listagem");
            fr.close();
        }
        catch (Exception e){
            System.out.println("Erro ao recuperar os produtos: " + e);
        }
    }

    /**
     * Permite a reposição do estoque de produtos que estejam em falta
     */
    public void updateStock() {
        try {
            Product prod;
            String line;
            String[] splitLine;
            ListIterator itr;
            FileReader fr = new FileReader("products.csv");
            FileWriter fw;
            BufferedReader products = new BufferedReader(fr);
            list.clear();
            while((line = products.readLine()) != null){
                splitLine = line.split(",");
                prod = new Product(splitLine[0], Float.parseFloat(splitLine[1]), splitLine[2], Integer.parseInt(splitLine[3]));
                list.add(prod);
            }
            fr.close();
            fw = new FileWriter("products.csv", false);
            itr = list.listIterator();
            while(itr.hasNext()){
                prod = (Product) itr.next();
                if(prod.getQuantity() < 70) {
                    prod.setQuantity(prod.getQuantity() + 250);
                }
                fw.write(prod.toFile());
            }
            fw.close();
        }
        catch (IOException e){
            System.out.println("Erro ao recuperar os produtos: " + e);
        }
    }

    /**
     * Permite a realização da compra de um produto do sistema, atualizando sua disponibilidade
     * O método é synchronized visto que mais de uma thread pode acessá-lo ao mesmo tempo
     * */
    public synchronized boolean makeBuy(String name, int quantity){
        try {
            Boolean returned = false;
            Product prod;
            String line;
            String[] splitLine;
            ListIterator itr;
            FileReader fr = new FileReader("products.csv");
            FileWriter fw;
            BufferedReader products = new BufferedReader(fr);
            list.clear();
            while ((line = products.readLine()) != null) {
                splitLine = line.split(",");
                prod = new Product(splitLine[0], Float.parseFloat(splitLine[1]), splitLine[2], Integer.parseInt(splitLine[3]));
                list.add(prod);
            }
            fr.close();
            fw = new FileWriter("products.csv", false);
            itr = list.listIterator();
            while(itr.hasNext()){
                prod = (Product) itr.next();
                if(prod.getQuantity() >= quantity && prod.getName().toLowerCase().equals(name.toLowerCase())) {
                    prod.setQuantity(prod.getQuantity() - quantity);
                    returned = true;
                }
                fw.write(prod.toFile());
            }
            fw.close();
            return returned;
        }
        catch (IOException e){
            System.out.println("Erro ao recuperar os produtos: " + e);
            return false;
        }
    }
}