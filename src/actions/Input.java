package actions;

import java.util.Scanner;

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
	public static String continuar() {
		System.out.print("Deseja continuar [S/N] ? : ");
		return new Scanner(System.in).nextLine();
	}
}
