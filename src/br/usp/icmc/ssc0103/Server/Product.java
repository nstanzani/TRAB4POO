package br.usp.icmc.ssc0103.Server;

public class Product {
    private String name;
    private float price;
    private String provider;
    private int quantity;

    Product(String name, float price, String provider, int quantity){
        this.name = name;
        this.price = price;
        this.provider = provider;
        this.quantity = quantity;
    }

    /**
     * Métode que formata o texto a ser escrito no arquivo
     */
    public String toFile(){
        return this.name + "," + this.price + "," + this.provider + "," + this.quantity + "\n";
    }

    @Override
    public String toString(){
        return "Nome: " + this.name + "\nPreco: " + this.price + "\nFornecedor: " + this.provider + "\nQuantidade disponivel: " + this.quantity;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getProvider() {
        return provider;
    }

    public int getQuantity(){ return quantity; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setQuantity(int quantity){ this.quantity = quantity; }
}
