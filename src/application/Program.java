package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import actions.Input;
import actions.Menu;
import entities.Hospede;
import exceptions.ValorException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Hospede hospede;

		int opcao;

		do {
			do {
				// Escolher opção
				try {
					Menu.principal();
					opcao = Input.escolherOpcaoMenu();
					break;
				} catch (InputMismatchException e) {
					System.out.println("\n ** Erro! Valor inválido. Tente novamente **\n");
				} catch (ValorException e) {
					System.out.println(e.getMessage());
				}
			} while (true);

			// Pegar opção
			switch (opcao) {
			case 1: {
				int codigo, idade;
				String nome, endereco;

				// Fornecendo valores do hóspede
				do {
					try {
						codigo = Input.codigo();
						break;
					} catch (ValorException e) {
						System.out.println(e.getMessage());
					} catch (InputMismatchException e) {
						System.out.println("\n ** Erro! Apenas valores numéricos são permitidos. Tente novamente **\n");
					}
				} while (true);

				// Nome do hóspede
				do {
					try {
						nome = Input.nome();
						break;
					} catch (ValorException e) {
						System.out.println(e.getMessage());
					}
				} while (true);

				// Endereço do hóspede
				endereco = Input.endereco();

				// Idade do hóspede
				do {
					try {
						idade = Input.idade();
						break;
					} catch (ValorException e) {
						System.out.println(e.getMessage());
					} catch (InputMismatchException e) {
						System.out.println("\n ** Erro! Informe apenas valores numéricos **\n");
					}
				} while (true);
				
				// Instanciando um hóspede
				hospede = new Hospede(codigo, nome, endereco, idade);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}

		} while (Input.continuar().toUpperCase().equals("S"));
		System.out.println("Fim do programa");
		sc.close();
	}
}
