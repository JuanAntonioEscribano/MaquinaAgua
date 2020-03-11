package org.maquina;

import java.io.IOException;

/**
 * Esta clase define la maquina tiene el numero de botella que contiene y las monedas
 * @author Juan Antonio Escribano, Alberto Corral, Alberto Cueva
 * @version 1.0
 */
public class Maquina {
	private int numBotella=10;
	private Moneda moneda=new Moneda();



	public int getNumBotella() {
		return numBotella;
	}

	public void comprarBotella(int dinero) throws MaquinaVaciaException{
		if (this.numBotella==0) throw new MaquinaVaciaException("|No quedan botellas de agua|\n|Tu cambio: "+(float)dinero/100+"\n");
		try {
			if (dinero>100) {
				System.out.println("\t|Tu cambio: "+moneda.calcularCambio(dinero));
				this.numBotella--;
				System.out.println("|Compra realizada|");
				System.in.read();
			}else {
				this.numBotella--;
				System.out.println("|Compra realizada|");
				System.in.read();
			}
		} catch (ImporteExactoException| IOException e) {
			System.out.println(e.getMessage());
		}
	}
/** 
 * @return Devuelve la cantidad de monedas que tiene la maquina y el cambio total que tiene 
 */
	public String visualizarCambio() {
		return "::::::::::::::::::::::::::::::::::::::::::\n::\t\t\t\t\t::"
				+ "\n::\tMonedas de 10 centimos: "+moneda.getCent10()+"\t::\n::\tMonedas de 20 centimos: "+moneda.getCent20()+"\t::\n::\tMonedas de 50 centimos: "
				+moneda.getCent50()+"\t::\n::\tMonedas de 1 euro: "+moneda.getEuro1()+"\t\t::\n::\t\t\t\t\t::\n::\t+------------------+\t\t::\n::"
				+ "\t|Cambio Total: "+(float)(Moneda.CENT10*moneda.getCent10()+Moneda.CENT20*moneda.getCent20()
				+Moneda.CENT50*moneda.getCent50()+Moneda.EURO1*moneda.getEuro1())/100+"|\t\t::\n::\t+------------------+\t\t::\n::\t\t\t\t\t::"
				+ " \n::::::::::::::::::::::::::::::::::::::::::";
	}
}
