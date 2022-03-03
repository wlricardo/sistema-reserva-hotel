package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Reserva {

	private List<Hospede> hospedes = new ArrayList<>();
	private Suite suite;
	private Integer qtdDePessoas;
	private Integer qtdDeDias;

	public Reserva() {
	}

	public Reserva(Suite suite, Integer qtdDePessoas, Integer qtdDeDias) {
		super();
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
	public String toString() {
		return "Reserva\n" + "Suite#:" + suite + "\nNúmero de hóspedes: " + qtdDePessoas + "\nQtd de diárias: "
				+ qtdDeDias + "\nHóspedes: " + hospedes + "\n";
	}

	public void imprimirReserva(Reserva r, int dias) {
		System.out.println("Hóspedes:");
		System.out.println("---------");
		for (Hospede h : r.getHospedes()) {
			System.out.println(h.toString());
		}
		System.out.println("Suite:");
		System.out.println("-----");
		System.out.println(r.getSuite().toString());

		System.out.println("Total da estadia:");
		System.out.println("-----------------");
		System.out.println("Total de diárias: " + dias);
		System.out.println("Valor da diária: R$ " + r.getSuite().getValorDaDiaria());
		System.out.println("Total: R$ " + calcularDiaria(r.getSuite(), dias));
	}

	public void imprimirRelatorio(TreeMap<Reserva, Integer> reservas) {
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

	public boolean verificarCapacidade(List<Hospede> hospedes, int capacidade) {
		int numHospedes = hospedesAcimaDoisAnos(hospedes);
		return (numHospedes > capacidade);
	}

	public double calcularDiaria(Suite s, int dias) {
		if (dias > 7) {
			return (0.9 * (s.getValorDaDiaria() * dias));
		}
		return (s.getValorDaDiaria() * dias);
	}
}
