package entities;

import java.util.Objects;

public class Suite {

	private Integer numero;
	private String tipo;
	private Integer capacidade;
	private Double valorDaDiaria;

	public Suite() {
	}

	public Suite(Integer numero, String tipo, Integer capacidade, Double valorDaDiaria) {
		this.numero = numero;
		this.tipo = tipo;
		this.capacidade = capacidade;
		this.valorDaDiaria = valorDaDiaria;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Double getValorDaDiaria() {
		return valorDaDiaria;
	}

	public void setValorDaDiaria(Double valorDaDiaria) {
		this.valorDaDiaria = valorDaDiaria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suite other = (Suite) obj;
		return Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "Suite #: " + numero 
				+ "Tipo: " + tipo 
				+ "Capacidade: " + capacidade 
				+ "Valor da diária: R$ " + valorDaDiaria 
				+ "\n";
	}
}