package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import actions.Input;
import actions.Mensagem;
import entities.Hospede;
import entities.Reserva;
import entities.Suite;
import exceptions.ReservaException;
import exceptions.ValorException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Reserva reserva = new Reserva();

		int opcao;

		do {
			do {
				// Escolher opção
				try {
					Mensagem.principal();
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
				List<Hospede> hospedes = new ArrayList<Hospede>();
				Hospede hospede = null;
				Suite suite = null;
				int numeroDeHospedes = 0;

				do {
					try {
						// Verificação do número de hóspedes
						numeroDeHospedes = Input.qtdHospedes();
						Mensagem.cadastrarHospedes();
						break;
					} catch (InputMismatchException e) {
						System.out.println("\n   ** Erro ! Informe apenas valores numéricos **\n");
					} catch (ValorException e) {
						System.out.println(e.getMessage());
					}
				} while (true);

				/*
				 * Fornecendo dados do hóspede
				 */
				for (int i = 0; i < numeroDeHospedes; i++) {

					// Códiugo do hóspede
					int codigo;
					do {
						try {
							codigo = Input.codigo();
							break;
						} catch (ValorException e) {
							System.out.println(e.getMessage());
						} catch (InputMismatchException e) {
							System.out.println(
									"\n ** Erro! Apenas valores numéricos são permitidos. Tente novamente **\n");
						}
					} while (true);
					// Nome do hóspede
					String nome;
					do {
						try {
							nome = Input.nome();
							break;
						} catch (ValorException e) {
							System.out.println(e.getMessage());
						}
					} while (true);

					// Endereço do hóspede
					String endereco;
					endereco = Input.endereco();
					// Idade do hóspede
					int idade;
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
					hospedes.add(hospede);
				}

				/*
				 * Fornecendo dados da suite
				 */

				// Número da suite
				int numero;
				do {
					try {
						numero = Input.numero();
						break;
					} catch (ValorException e) {
						System.out.println(e.getMessage());
					} catch (InputMismatchException e) {
						System.out.println("\n ** Erro! Informe apenas valores numéricos **\n");
					}
				} while (true);

				// Tipo
				String tipo;
				tipo = Input.tipo();

				// Capacidade
				int capacidade;
				do {
					try {
						capacidade = Input.capacidade(hospedes);
						break;
					} catch (ValorException e) {
						System.out.println(e.getMessage());
					} catch (ReservaException e) {
						System.out.println(e.getMessage());
					} catch (InputMismatchException e) {
						System.out.println("\n ** Erro! Informe apenas valores numéricos **\n");
					}

				} while (true);

				// Valor da diária
				double valorDaDiaria;
				do {
					try {
						valorDaDiaria = Input.valorDaDiaria();
						break;
					} catch (ValorException e) {
						System.out.println(e.getMessage());
					}
				} while (true);

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: ");
			}

		} while (Input.continuar().toUpperCase().equals("S"));
		System.out.println("Fim do programa");
		sc.close();
	}
}
