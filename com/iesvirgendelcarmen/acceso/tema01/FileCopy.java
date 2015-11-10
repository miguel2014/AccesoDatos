package com.iesvirgendelcarmen.acceso.tema01;

import java.io.*;

/**
 *
 * @author juangu
 */
public class FileCopy {
    public static void main(String[] argv) {
        if (argv.length==2) {
            try {
                FileIO.copyFile(argv[0], argv[1]);
                } catch (FileNotFoundException e) {
                    System.err.println(e);
                } catch (IOException e) {
                    System.err.println(e);
            }
        } else {
            System.out.println("Usage: FileCopy source.file destinatio.file");
        }
    }
}
