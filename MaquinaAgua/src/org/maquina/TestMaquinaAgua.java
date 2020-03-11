package org.maquina;

import java.io.IOException;
import java.util.Scanner;

/**
 * Esta clase es la que tiene la entrada del programa
 * @author Juan Antonio Escribano, Alberto Corral, Alberto Cueva
 * @version 1.0
 */
public class TestMaquinaAgua {

	public static void main(String[] args)throws MonedaNoValidaException {
		Maquina maquina = new Maquina();

		Scanner sc = new Scanner(System.in);
		boolean bucle=true;
		do {
			int opcion;
			System.out.print("\n::::::::::::::::::::::::::::::::::::::::::\n::\t\t\t\t\t::"
					+ "\n:: \t+------------------------+\t::\n:: \t|Cantidad de botellas: "+maquina.getNumBotella()+"|");
			System.out.println("\t::\n:: \t+------------------------+\t::\n::\t\t\t\t\t:: \n::\t1.-Comprar botella.\t "
					+ "\t::\n::\t2.-Ver cambio disponible.\t::\n::\t3.-Salir.\t\t\t::"
					+"\n::\t\t\t\t\t::\n::::::::::::::::::::::::::::::::::::::::::\n");
			opcion=sc.nextInt();

			switch (opcion) {
			case 1:
				boolean bucleCompra=true;
				int dinero=0;
				do {
					try {
						float moneda;
						System.out.println("Introduce 0 para irte al menú.");
						System.out.print("Introduce moneda (monedas validas: 10 cent, 20 cent, 50 cent, 1 euro, 2 euros):");
						moneda=sc.nextFloat();
						if (moneda==0)break;
						// Si la moneda introducida es euro lo pasa a centimo
						if (moneda==1||moneda==2)moneda=moneda*100;
						//Comprueba que la moneda introducida es una de las permitidas, en caso de que no lo sea salta la excepcion
						if (!(moneda==Moneda.CENT10||moneda==Moneda.CENT20||moneda==Moneda.CENT50||moneda==Moneda.EURO1||moneda==Moneda.EURO2))
							throw new MonedaNoValidaException("Esa moneda no es valida");
						//Acumulamos las monedas hasta que llegue a un euro o se pase
						dinero+=moneda;
						//Cuando el dinero introducido sea un euro o mas llama al metodo comprarBotella de la clase maquina y cierra el bucle de la compra
						// Si la maquina esta vacia salta la excepcion MaquinaVacia
						if (dinero<100)System.out.println("\n|Dinero introducido: " + (float)dinero/100 +" " + (dinero!=1?"euros":"euro")+"|\n");
						else  {
							maquina.comprarBotella(dinero);
							bucleCompra=false;
						}
					} catch (MaquinaVaciaException e) {
						System.out.println(e.getMessage());
					}



				} while (bucleCompra);
				break;
			case 2:
				System.out.println(maquina.visualizarCambio());
				try {
					System.in.read();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				bucle=false;
				break;
			default:
				System.out.println("Por favor elija una de las opciones marcadas.");
			}
		} while (bucle);
		sc.close();
	}

}
