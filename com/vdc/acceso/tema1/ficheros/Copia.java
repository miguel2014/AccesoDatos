package com.vdc.acceso.tema1.ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Copia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Comprueba que hemos pasado 2 parametros
			if (args.length==2) {
				Path source=Paths.get(args[0]);
				Path out=Paths.get(args[1]);
				//Comprueba que el fichero origen existe,que no exista el destino(out) y si existe lo borra
				//Despues lo copia 
				try {
					if (Files.exists(source) && (Files.notExists(out) || Files.deleteIfExists(out))) {
						Files.copy(source, out);
						System.out.println("Fichero copiado");
					}
					else{
						System.out.println("No se puede leer el archivo de entrada o escribir el de salida");
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				System.out.println("Has de introducir parametros");
				System.exit(0);
			}
		
	}

}
