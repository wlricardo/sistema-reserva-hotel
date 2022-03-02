package actions;

import java.util.Scanner;

import entities.Hospede;
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
}
