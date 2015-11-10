/*
 * Java Cookbook, Second Edition by Ian F. Darwin
 * Copyright © 2004, 2001 O’Reilly Media
 */
package com.iesvirgendelcarmen.acceso.tema01;

import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Transforms an XML file by following XSLT file rules 
 */
public class JAXPTransform {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println(
                    "Usage: java JAXPTransform inputFile.xml inputFile.xsl outputFile");
            System.exit(1);
        }  // Create a transformer object
        Transformer tx = TransformerFactory.newInstance().newTransformer(
                new StreamSource(new File(args[1]))); // not 0
        tx.transform( // Use its transform( ) method to perform the transformation
                new StreamSource(new File(args[0])),
                new StreamResult(new File(args[2])));
    }
}

