package com.fizzbuzz.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fizz_buzz_transacciones")
public class FizzBuzzTransacciones {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private int minimo;
	private int maximo;
	private String resultado;
	private Date fecha;
	
	public FizzBuzzTransacciones() {
		super();
	}
	
	public FizzBuzzTransacciones(int minimo, int maximo, String resultado, Date fecha) {
		this.minimo = minimo;
		this.maximo = maximo;
		this.resultado = resultado;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "FizzBuzzTransacciones [id=" + id + ", minimo=" + minimo + ", maximo=" + maximo + ", resultado="
				+ resultado + ", fecha=" + fecha + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + maximo;
		result = prime * result + minimo;
		result = prime * result + ((resultado == null) ? 0 : resultado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FizzBuzzTransacciones other = (FizzBuzzTransacciones) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (maximo != other.maximo)
			return false;
		if (minimo != other.minimo)
			return false;
		if (resultado == null) {
			if (other.resultado != null)
				return false;
		} else if (!resultado.equals(other.resultado))
			return false;
		return true;
	}
	
}
