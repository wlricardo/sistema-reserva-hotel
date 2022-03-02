package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Reserva {

	private Suite suite;
	private Integer qtdDePessoas;
	private Integer qtdDeDias;
	private List<Hospede> hospedes = new ArrayList<>();
	private HashMap<Suite, List<Hospede>> hospedesDaSuite = new HashMap<>();
	private HashMap<HashMap<Suite, List<Hospede>>, Integer> reservas = new HashMap<>();

	public Reserva() {
	}

	public Reserva(Suite suite, Integer qtdDePessoas, Integer qtdDeDias) {
		this.suite = suite;
		this.qtdDePessoas = qtdDePessoas;
		this.qtdDeDias = qtdDeDias;
	}

	public Suite getSuite() {
		return suite;
	}

	public void setSuite(Suite suite) {
		this.suite = suite;
	}

	public Integer getQtdDePessoas() {
		return qtdDePessoas;
	}

	public void setQtdDePessoas(Integer qtdDePessoas) {
		this.qtdDePessoas = qtdDePessoas;
	}

	public Integer getQtdDeDias() {
		return qtdDeDias;
	}

	public void setQtdDeDias(Integer qtdDeDias) {
		this.qtdDeDias = qtdDeDias;
	}

	public List<Hospede> getHospedes() {
		return hospedes;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.suite);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Reserva other = (Reserva) obj;
		return Objects.equals(this.suite, other.suite);
	}

	@Override
	public String toString() {
		return "Reserva\n" + "Suite#:" + suite + "\nNúmero de hóspedes: " + qtdDePessoas + "\nQtd de diárias: "
				+ qtdDeDias + "\nHóspedes: " + hospedes + "\n";
	}

	public void imprimirReserva(HashMap<Suite, List<Hospede>> hospedesDaSuite, int dias) {
		System.out.println("Hóspedes:");
		System.out.println("---------");
		for (Suite s : hospedesDaSuite.keySet()) {
			for (Hospede h : hospedesDaSuite.get(s)) {
				System.out.println(h.toString());
			}
			System.out.println("Suite:");
			System.out.println("-----");
			System.out.println(s.toString());

			System.out.println("");
			System.out.println("Total da estadia:");
			System.out.println("-----------------");
			System.out.println("Total de diárias: " + dias);
			System.out.println("Valor da diária: R$ " + s.getValorDaDiaria());
			System.out.println("Total: R$ " + calcularDiaria(s, dias));
		}
	}

	public void imprimirRelatorio(HashMap<HashMap<Suite, List<Hospede>>, Integer> reservas) {
		double total = 0.0;
		double diaria = 0.0;

		for (HashMap<Suite, List<Hospede>> lista : reservas.keySet()) {
			for (Suite s : lista.keySet()) {
				System.out.println("Hóspedes da Suite #" + s.getNumero() + ":");
				for (Hospede h : lista.get(s)) {
					System.out.println(h.toString());
				}
				System.out.println("Dados da suíte:");
				System.out.println(s.toString());

				System.out.println("Total da estadia:");
				System.out.println("Total de diárias: " + reservas.get(lista));
				diaria = s.getValorDaDiaria();
				System.out.println("Valor da diária: R$ " + diaria);
				System.out.println("Total: R$ " + calcularDiaria(s, reservas.get(lista)));
				total += diaria;
			}
		}
		System.out.println("Total em diárias: R$ " + total);
	}

	public int hospedesAcimaDoisAnos(List<Hospede> lista) {
		int total = 0;
		for (Hospede h : lista) {
			if (h.getIdade() > 2) {
				total++;
			}
		}
		return total;
	}

	public boolean verificarCapacidade(Suite suite, List<Hospede> hospedes) {
		int numHospedes = hospedesAcimaDoisAnos(hospedes);
		return (numHospedes > suite.getCapacidade());
	}

	public double calcularDiaria(Suite s, int dias) {
		if (dias > 7) {
			return (0.9 * (s.getValorDaDiaria() * dias));
		}
		return (s.getValorDaDiaria() * dias);
	}
}
