package actions;

public abstract class Menu {

	public static void principal() {
		System.out.println("\n--------------------------------------");
		System.out.println("           HOTEL 123 L�GUAS			  ");
		System.out.println(" Sistema de Gerenciamento de Reservas ");
		System.out.println("--------------------------------------\n");
		System.out.println("Escolha uma op��o:");
		System.out.println("[1] Cadastrar h�spedes");
		System.out.println("[2] Remover h�spedes");
		System.out.println("[3] Relat�rio");
		System.out.println("[0] Sair");
		System.out.print("> ");
	}
}