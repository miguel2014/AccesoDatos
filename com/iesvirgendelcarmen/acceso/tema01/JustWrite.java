/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iesvirgendelcarmen.acceso.tema01;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 *
 * @author juangu
 */
public class JustWrite {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) 
        throws FileNotFoundException {
        try (PrintStream diskWriter = new PrintStream("justWrite.txt")) {
            diskWriter.println("hola mundo!, estoy escribiendo ficheros!");
        }
    }
    
}
