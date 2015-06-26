package br.usp.icmc.ssc0103.Client;

/**
 * Created by arnaldo on 26/06/15.
 */
public class User {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String password;
    private int ID;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
