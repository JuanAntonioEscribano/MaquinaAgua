package org.maquina;
/**
 * Esta clase define la botella que contiene la maquina 
 * @author Juan Antonio Escribano, Alberto Corral, Alberto Cueva
 * @version 1.0
 */
public class Botella {
	public static final int PRECIO=100;
	private float capacidad=(float) 1.5;


	public float getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}

}
