package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import actions.Input;
import actions.Menu;
import exceptions.ValorException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		do {
			do {
				try {
					Menu.principal();
					int opcao = Input.escolherOpcaoMenu();
					break;
				} catch (InputMismatchException e) {
					System.out.println("\n ** Erro! Valor inválido. Tente novamente **\n");
				} catch (ValorException e) {
					System.out.println(e.getMessage());
				}

			} while (true);
		} while (Input.continuar().toUpperCase().equals("S"));

		sc.close();
	}
}
