package com.example;

public class Pojo {
	private String propiedad;
	private int indice;
	private boolean falso;
	
	public Pojo(String propiedad, int indice, boolean falso) {
		super();
		this.propiedad = propiedad;
		this.indice = indice;
		this.falso = falso;
	}
	

	/*
	 * Son requeridos los getters y setters para poder usarlos en el ObjectMapper 
	 * */

	public String getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public boolean isFalso() {
		return falso;
	}

	public void setFalso(boolean falso) {
		this.falso = falso;
	}
	
	
}
