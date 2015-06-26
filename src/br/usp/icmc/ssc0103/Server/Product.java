package br.usp.icmc.ssc0103.Server;

import java.time.LocalDate;

/**
 * Created by arnaldo on 26/06/15.
 */
public class Product {
    private String name;
    private float price;
    private LocalDate expirationDate;
    private String provider;

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getProvider() {
        return provider;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
