package org.maquina;
/**
 * Esta clase contiene el calculo del cambio, las monedas permitidas y el cambio que tiene la maquina
 * @author Juan Antonio Escribano, Alberto Corral, Alberto Cueva
 * @version 1.0
 */
public class Moneda {
	public static final int CENT10=10, CENT20=20, CENT50=50, EURO1=100, EURO2=200;
	private int cent10=10, cent20=5, cent50=4, euro1=6;


	public int getCent10() {
		return cent10;
	}


	public int getCent20() {
		return cent20;
	}


	public int getCent50() {
		return cent50;
	}


	public int getEuro1() {
		return euro1;
	}

	/**
	 * Este metodo calcula el cambio y lo devuelve
	 * @param dinero Es el dinero que ha introducido el usuario
	 * @return devuele el cambio como un integer
	 * @throws ImporteExactoException esta excepcion salta cuando no hay cambio sufuciente
	 */
	public float calcularCambio(int dinero) throws ImporteExactoException{
		int cambio=dinero-Botella.PRECIO;
		if ((Moneda.CENT10*this.cent10+Moneda.CENT20*this.cent20+Moneda.CENT50*this.cent50+Moneda.EURO1*this.euro1)<cambio)
			throw new ImporteExactoException("|No queda cambio suficiente|");

		/*
		 * Este bucle comprueba la moneda que mejor se adapte al cambio
		 * Comprobando si queda esa moneda en la maquina y si el cambio 
		 * tiene un valor mayor o igual que que la moneda
		 */
		do {
			if (this.euro1>0&&cambio>=Moneda.EURO1) {
				this.euro1--;
				cambio-=Moneda.EURO1;
			}else if (this.cent50>0&&cambio>=Moneda.CENT50) {
				this.cent50--;
				cambio-=Moneda.CENT50;
			}else if (this.cent20>0&&cambio>=Moneda.CENT20) {
				this.cent20--;
				cambio-=Moneda.CENT20;
			}else if (this.cent10>0&&cambio>=Moneda.CENT10) {
				this.cent10--;
				cambio-=Moneda.CENT10;
			}

		} while (cambio!=0);

		return (float)(dinero-Botella.PRECIO)/100;
	}
}
