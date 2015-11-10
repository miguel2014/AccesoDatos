/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvirgendelcarmen.acceso.tema01;

/**
 *
 * @author juangu
 */
import java.io.*;

/**
 * Some simple file IO primitives reimplemented in Java. All methods are static
 * since there is no state.
 */
public class FileIO {

    /**
     * Copy a file from one filename to another
     * @param inName
     * @param outName
     * @throws java.io.FileNotFoundException
     */
    public static void copyFile(String inName, String outName)
            throws FileNotFoundException, IOException {
        BufferedInputStream is
                = new BufferedInputStream(new FileInputStream(inName));
        BufferedOutputStream os
                = new BufferedOutputStream(new FileOutputStream(outName));
        copyFile(is, os, true);
    }

    /**
     * Copy a file from an opened InputStream to an opened OutputStream
     * @param is
     * @param os
     * @param close
     * @throws java.io.IOException
     */
    public static void copyFile(InputStream is, OutputStream os, boolean close)
            throws IOException {
        int b; // the byte read from the file
        while ((b = is.read()) != -1) {
            os.write(b);
        }
        is.close();
        if (close) {
            os.close();
        }
    }

    /**
     * Copy a file from an opened Reader to an opened Writer
     * @param is
     * @param os
     * @param close
     * @throws java.io.IOException
     */
    public static void copyFile(Reader is, Writer os, boolean close)
            throws IOException {
        int b; // the byte read from the file
        while ((b = is.read()) != -1) {
            os.write(b);
        }
        is.close();
        if (close) {
            os.close();
        }
    }

    /**
     * Copy a file from a filename to a PrintWriter.
     * @param inName
     * @param pw
     * @param close
     * @throws java.io.FileNotFoundException
     */
    public static void copyFile(String inName, PrintWriter pw, boolean close)
            throws FileNotFoundException, IOException {
        BufferedReader ir = new BufferedReader(new FileReader(inName));
        copyFile(ir, pw, close);
    }

    /**
     * Open a file and read the first line from it.
     * @param inName
     * @return 
     * @throws java.io.FileNotFoundException 
     */
    public static String readLine(String inName)
            throws FileNotFoundException, IOException {
        String line;
        try (BufferedReader is = new BufferedReader(new FileReader(inName))) {
            // line = null;
            line = is.readLine();
        }
        return line;
    }
    /**
     * The size of blocking to use
     */
    protected static final int BLKSIZ = 8192;

    /**
     * Copy a data file from one filename to another, alternate method. As the
     * name suggests, use my own buffer instead of letting the BufferedReader
     * allocate and use the buffer. (just to show how, not necessarily optimal).
     * @param inName
     * @param outName
     * @throws java.io.FileNotFoundException
     */
    public void copyFileBuffered(String inName, String outName) throws
            FileNotFoundException, IOException {
        OutputStream os;
        try (InputStream is = new FileInputStream(inName)) {
            os = new FileOutputStream(outName);
            int count = 0; // the byte count
            byte[] b = new byte[BLKSIZ]; // the bytes read from the file
            while ((count = is.read(b)) != -1) {
                os.write(b, 0, count);
            }
        }
        os.close();
    }

    /**
     * Read the entire content of a Reader into a String
     * @param is
     * @return 
     * @throws java.io.IOException
     */
    public static String readerToString(Reader is) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] b = new char[BLKSIZ];
        int n;
// Read a block. If it gets any chars, append them.
        while ((n = is.read(b)) > 0) {
            sb.append(b, 0, n);
        }
// Only construct the String object once, here.
        return sb.toString();
    }

    /**
     * Read the content of a Stream into a String
     * @param is
     * @return 
     * @throws java.io.IOException
     */
    public static String inputStreamToString(InputStream is)
            throws IOException {
        return readerToString(new InputStreamReader(is));
    }
}
