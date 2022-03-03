package actions;

import java.util.List;
import java.util.Scanner;

import entities.Hospede;
import entities.Reserva;
import exceptions.ReservaException;
import exceptions.ValorException;

public class Input {

	@SuppressWarnings("resource")
	public static int escolherOpcaoMenu() {
		int op = new Scanner(System.in).nextInt();
		if (op < 0 || op > 3) {
			throw new ValorException("\n ** Erro! Forneça valores entre [0-3] **\n");
		}
		return op;
	}

	@SuppressWarnings("resource")
	public static String nome() {
		String nome = new Scanner(System.in).nextLine();
		if (nome.equals(null)) {
			throw new ValorException("\n ** Erro! O nome não pode ser vazio. Tente novamente **\n");
		}
		return nome;
	}

	@SuppressWarnings("resource")
	public static String continuar() {
		System.out.print("Deseja continuar [S/N] ? : ");
		return new Scanner(System.in).nextLine();
	}

	@SuppressWarnings("resource")
	public static int codigo() {
		int cod = new Scanner(System.in).nextInt();
		if (cod == 0) {
			throw new ValorException("\n ** Erro! O código não pode ser nulo. Tente novamente ** \n");
		}
		return cod;
	}

	@SuppressWarnings("resource")
	public static String endereco() {
		return new Scanner(System.in).nextLine();
	}

	@SuppressWarnings("resource")
	public static int idade() {
		int idade = new Scanner(System.in).nextInt();
		if (idade == 0) {
			throw new ValorException("\n ** Erro! A idade não pode ser nula. Tente novamente **\n");
		}
		return idade;
	}

	@SuppressWarnings("resource")
	public static int numero() {
		int numero = new Scanner(System.in).nextInt();
		if (numero == 0) {
			throw new ValorException("\n ** Erro! O núemro da suite não pode ser nulo. Tente novamente **\n");
		}
		return numero;
	}

	@SuppressWarnings("resource")
	public static String tipo() {
		return new Scanner(System.in).nextLine();
	}

	@SuppressWarnings("resource")
	public static int capacidade(List<Hospede> lista) {
		Reserva r = new Reserva();

		System.out.println("Capacidade da suite: ");
		int capacidade = new Scanner(System.in).nextInt();
		if (capacidade == 0) {
			throw new ValorException(" ** Erro! Forneça um valor maior que zero. Tente novamente **\n");
		}
		if (!r.verificarCapacidade(lista, capacidade)) {
			throw new ReservaException(
					"\n Erro! O número de hóspedes supera a capacidade da suite. Tente novamente **\n");
		}
		return capacidade;
	}

	@SuppressWarnings("resource")
	public static int qtdHospedes() {
		int qtd = new Scanner(System.in).nextInt();
		if (qtd == 0) {
			throw new ValorException(" ** Erro! Forneça um valor maior que zero. Tente novamente **\n");
		}
		return qtd;
	}

	public static double valorDaDiaria() {
		@SuppressWarnings("resource")
		double valor = new Scanner(System.in).nextDouble();
		if (valor == 0.0 || valor < 0.0) {
			throw new ValorException(" ** Erro! Forneça um valor maior que zero. Tente novamente **\n");
		}
		return valor;
	}
}
