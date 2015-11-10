/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvirgendelcarmen.acceso.tema01;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author juangu
 */
public class NSLookup {

    public static void main(String[] args) {
        String host;
        Scanner input = new Scanner(System.in);
        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
            System.out.println("your local IP address is: "+address);
        } catch (UnknownHostException uhEx) {
            System.out.println(
                    "Could not find local address!");
        }

        System.out.print("\n\nEnter host name: ");
        host  = input.next();

        try {
                address = InetAddress.getByName(host);
            System.out.println("IP address: "
                    + address.toString());
        }
        catch (UnknownHostException uhEx) {
                System.out.println("Could not find " + host);
        }
    }

}
