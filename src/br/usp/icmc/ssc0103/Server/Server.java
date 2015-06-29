package br.usp.icmc.ssc0103.Server;

import java.util.*;
/**
 * Created by Guilherme on 29/06/2015.
 */
public class Server {

    Scanner scanner = new Scanner(System.in);
    Market market = new Market();

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
                    market.listProducts();
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
}
