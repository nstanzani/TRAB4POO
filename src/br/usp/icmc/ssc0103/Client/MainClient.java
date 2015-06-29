package br.usp.icmc.ssc0103.Client;

import java.io.*;
import java.net.*;

/**
 * Created by Guilherme on 29/06/2015.
 */
public class MainClient
{
    public static void main(String[] args) {
        Client c = new Client();
        c.Connect(args);
        c.menuIni();
    }

}