package com.vdc.acceso.tema1.ficheros;

import java.nio.IntBuffer;

public class BufferDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntBuffer buffer=IntBuffer.allocate(20);
		System.out.println("El buffer tiene "+buffer.capacity()+" bytes de capacidad");
		System.out.println("El limite del buffer esta en "+buffer.limit()+" i-esima posicion");
		System.out.println("Estamos en la "+buffer.position()+" posicion del buffer");
		System.out.println("Me quedan "+buffer.remaining()+" posiciones hasta el final del buffer");
		buffer.position(2);
		System.out.println();
		System.out.println("Estamos en la "+buffer.position()+" posicion del buffer");
		System.out.println("Me quedan "+buffer.remaining()+" posiciones hasta el final del buffer");
		
		buffer.limit(15);
		System.out.println("\nCambiamos el limite del buffer");
		System.out.println("El buffer tiene "+buffer.capacity()+" bytes de capacidad");
		System.out.println("El limite del buffer esta en "+buffer.limit()+" i-esima posicion");
		System.out.println("Estamos en la "+buffer.position()+" posicion del buffer");
		System.out.println("Me quedan "+buffer.remaining()+" posiciones hasta el final del buffer");
		buffer.rewind();
		System.out.println("\nRewind al buffer");
		System.out.println("El buffer tiene "+buffer.capacity()+" bytes de capacidad");
		System.out.println("El limite del buffer esta en "+buffer.limit()+" i-esima posicion");
		System.out.println("Estamos en la "+buffer.position()+" posicion del buffer");
		System.out.println("Me quedan "+buffer.remaining()+" posiciones hasta el final del buffer");
		
		
		for (int i = 0; i < buffer.limit(); i++) {
			buffer.put(i);
			
		}
		buffer.rewind();//Rebobinar
		for (int i = 0; i <buffer.limit(); i++) {
			System.out.printf("Contenido del buffer en posicion : %1$d  valor: %2$d%n",i,buffer.get(i));
		}
		System.out.println();
		System.out.println("El buffer tiene "+buffer.capacity()+" bytes de capacidad");
		System.out.println("El limite del buffer esta en "+buffer.limit()+" i-esima posicion");
		System.out.println("Estamos en la "+buffer.position()+" posicion del buffer");
		System.out.println("Me quedan "+buffer.remaining()+" posiciones hasta el final del buffer");
		
		

	}

}
