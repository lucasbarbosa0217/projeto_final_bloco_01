package livro;

import java.util.Locale;
import java.util.Scanner;

public class Menu {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		int option = 1;

		do {
			exibirMenu();
			System.out.println("Escolha a opção do Menu.");
			option = scanner.nextInt();
			
			switch (option) {
			case 1:
				adicionarLivro();
				aperteEnter();
				break;
			case 2:
				listarLivros();
				aperteEnter();
				break;
			case 3:
				atualizarLivro();
				aperteEnter();
				break;
			case 4:
				apagarLivro();
				aperteEnter();
				break;
			case 5:
				cadastrarUsuario();
				aperteEnter();

				break;
			case 6:
				venderLivro();
				aperteEnter();
				break;
			case 0:
				System.out.println("Fechando a loja...");
				break;
			default:
				System.out.println("Opção inválida. Por favor, tente novamente.");
			}
		} while (option != 0);

		scanner.close();

	}
	
	public static void exibirMenu() {
		System.out.println("\n=============================================");
		System.out.println("             Livraria Gerações               ");
		System.out.println("=============================================");
		System.out.printf("%-45s%n", "1 - Adicionar livro no estoque");
		System.out.printf("%-45s%n", "2 - Ver lista de livros no Estoque");
		System.out.printf("%-45s%n", "3 - Atualizar livro no estoque");
		System.out.printf("%-45s%n", "4 - Apagar livro do estoque");
		System.out.printf("%-45s%n", "5 - Cadastrar Usuário");
		System.out.printf("%-45s%n", "6 - Vender livro para um usuário");
		System.out.printf("%-45s%n", "0 - Fechar programa");
		System.out.printf("%-45s%n", "=============================================\n");
	}

	private static void adicionarLivro() {
		System.out.println("\nAdicionar um Livro.");
	}
	
	private static void listarLivros() {
		System.out.println("\nListar todos livros no estoque.");
	}
	
	private static void atualizarLivro() {
		System.out.println("\nAtualizar um livro do estoque.");
	}

	
	private static void apagarLivro() {
		System.out.println("\nApagar um livro do estoque.");
	}

	private static void cadastrarUsuario() {
		System.out.println("\nCadastrar um usuário.");
	}
	
	private static void venderLivro() {
		System.out.println("\nVender um livro para um usuário.");
	}

	private static void aperteEnter() {
		System.out.println("Pressione Enter para continuar...");
		scanner.nextLine();
		@SuppressWarnings("unused")
		String continuar = scanner.nextLine();
	}
}
