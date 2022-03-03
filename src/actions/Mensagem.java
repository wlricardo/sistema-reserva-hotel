package actions;

public abstract class Mensagem {

	public static void principal() {
		System.out.println("\n--------------------------------------");
		System.out.println("           HOTEL 123 LÉGUAS			  ");
		System.out.println(" Sistema de Gerenciamento de Reservas ");
		System.out.println("--------------------------------------\n");
		System.out.println("Escolha uma opção:");
		System.out.println("[1] Cadastrar hóspedes");
		System.out.println("[2] Remover hóspedes");
		System.out.println("[3] Relatório");
		System.out.println("[0] Sair");
		System.out.print("> ");
	}

	public static void cadastrarHospedes() {
		System.out.println("\n-------------------------");
		System.out.println(" Cadastrado dos hóspedes ");
		System.out.println("-------------------------");
	}
}