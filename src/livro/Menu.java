package livro;

import java.util.Locale;
import java.util.Scanner;

import livro.controller.LivroController;
import livro.model.Arquivo;
import livro.model.Capa;
import livro.model.Livro;
import livro.model.LivroDigital;
import livro.model.LivroFisico;

public class Menu {
	public static Scanner scanner = new Scanner(System.in);
	static LivroController livroController = new LivroController();

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

		System.out.println("Digite o nome do livro.");
		scanner.nextLine();
		String nomeLivro = scanner.nextLine();
		System.out.println("Digite o nome do Autore.");
		String nomeAutore = scanner.nextLine();
		System.out.println("Qual o estoque desse produto");
		int estoque = scanner.nextInt();
		scanner.nextLine();

		int optionLivro = 1;
		do {
			System.out.println("Selecione a opção sobre livro: \n" + "1 - Livro com Ilustradore e Tradutore\n"
					+ "2 - Livro com Tradure\n" + "3 - Livro com Ilustradore\n"
					+ "4 - Livro sem ilustradore e Tradutore");

			optionLivro = scanner.nextInt();
			scanner.nextLine();
		} while (optionLivro < 1 || optionLivro > 4);

		String nomeIlustradore = "", nomeTradutore = "";
		switch (optionLivro) {
		case 1 -> {
			System.out.println("Digite o nome do Ilustradore");
			nomeIlustradore = scanner.nextLine();
			System.out.println("Digite o nome do Tradutore");
			nomeTradutore = scanner.nextLine();
		}
		case 2 -> {
			System.out.println("Digite o nome do Tradutore");
			nomeTradutore = scanner.nextLine();
		}
		case 3 -> {
			System.out.println("Digite o nome do Ilustradore");
			nomeIlustradore = scanner.nextLine();
		}

		case 4 -> {
			System.out.println("Ok.");
		}
		}

		int tipoLivro = 1;
		do {
			System.out.println("Selecione a opção o tipo de Livro\n" + "1 - Livro físico\n" + "2 - Livro Digital\n");

			tipoLivro = scanner.nextInt();
			scanner.nextLine();
		} while (tipoLivro < 1 || tipoLivro > 2);

		int qtdPaginas = 0, idArquivo, idCapa;
		Arquivo tipoArquivo = null;
		Capa tipoCapa = null;
		switch (tipoLivro) {
		case 1 -> {
			System.out.println("Qual a quantidade páginas do livro?");
			qtdPaginas = scanner.nextInt();
			do {
				System.out.println("Selecione o tipo de capa: \n" + "1 - Brochura\n" + "2 - Capa dura\n");

				idCapa = scanner.nextInt();
				scanner.nextLine();

			} while (idCapa < 1 || idCapa > 2);

			switch (idCapa) {
			case 1:
				tipoCapa = Capa.BROCHURA;
				break;
			case 2:
				tipoCapa = Capa.CAPA_DURA;
				break;
			}
		}
		case 2 -> {
			do {
				System.out.println("Selecione o tipo de arquivo: \n" + "1 - EPUB\n" + "2 - MOBI\n" + "3 - PDF");

				idArquivo = scanner.nextInt();
				scanner.nextLine();

			} while (idArquivo < 1 || idArquivo > 3);

			switch (idArquivo) {
			case 1:
				tipoArquivo = Arquivo.EPUB;
				break;
			case 2:
				tipoArquivo = Arquivo.MOBI;
				break;
			case 3:
				tipoArquivo = Arquivo.PDF;
				break;
			}

		}
		}

		if (tipoLivro == 1) {
			if (optionLivro == 1) {
				livroController.cadastrar(new LivroFisico(livroController.numeroControle(), nomeLivro, nomeAutore,
						nomeTradutore, nomeIlustradore, estoque, tipoCapa, qtdPaginas));
			} else if (optionLivro == 2) {
				livroController.cadastrar(new LivroFisico(livroController.numeroControle(), nomeLivro, nomeAutore,
						estoque, nomeTradutore, tipoCapa, qtdPaginas));
			} else if (optionLivro == 3) {
				livroController.cadastrar(new LivroFisico(livroController.numeroControle(), nomeLivro, nomeAutore,
						nomeIlustradore, estoque, tipoCapa, qtdPaginas));
			} else if (optionLivro == 4) {
				livroController.cadastrar(new LivroFisico(livroController.numeroControle(), nomeLivro, nomeAutore,
						estoque, tipoCapa, qtdPaginas));
			}
		} else if (tipoLivro == 2) {
			if (optionLivro == 1) {
				livroController.cadastrar(new LivroDigital(livroController.numeroControle(), nomeLivro, nomeAutore,
						nomeTradutore, nomeIlustradore, estoque, tipoArquivo));
			} else if (optionLivro == 2) {
				livroController.cadastrar(new LivroDigital(livroController.numeroControle(), nomeLivro, nomeAutore,
						estoque, nomeTradutore, tipoArquivo));
			} else if (optionLivro == 3) {
				livroController.cadastrar(new LivroDigital(livroController.numeroControle(), nomeLivro, nomeAutore,
						nomeIlustradore, estoque, tipoArquivo));
			} else if (optionLivro == 4) {
				livroController.cadastrar(new LivroDigital(livroController.numeroControle(), nomeLivro, nomeAutore,
						estoque, tipoArquivo));
			} else {
				System.out.println("Aconteceu algum erro ao criar um livro.");
			}
		}

	}

	private static void listarLivros() {
		System.out.println("\nListar todos livros no estoque.");

		livroController.listarTodos().forEach((livro) -> {
			System.out.println(livro);
		});
	}

	private static void atualizarLivro() {
		System.out.println("\nAtualizar um livro do estoque.");

		listarLivros();
		System.out.println("Digite o ID do livro que deseja atualizar. Digite 0 para Cancelar");
		int idLivro = 1;

		do {
			idLivro = scanner.nextInt();
			scanner.nextLine();
			if (idLivro == 0) {
				return;
			}
		} while (livroController.idExite(idLivro) == false);

		if (idLivro == 0) {
			System.out.println("Cancelando operação");
			return;
		}

		System.out.println("Iniciando processo de atualização");

		System.out.println("Digite o nome do livro.");
		String nomeLivro = scanner.nextLine();
		System.out.println("Digite o nome do Autore.");
		String nomeAutore = scanner.nextLine();
		System.out.println("Qual o estoque desse produto");
		int estoque = scanner.nextInt();
		scanner.nextLine();

		int optionLivro = 1;
		do {
			System.out.println("Selecione a opção sobre livro: \n" + "1 - Livro com Ilustradore e Tradutore\n"
					+ "2 - Livro com Tradure\n" + "3 - Livro com Ilustradore\n"
					+ "4 - Livro sem ilustradore e Tradutore");

			optionLivro = scanner.nextInt();
			scanner.nextLine();
		} while (optionLivro < 1 || optionLivro > 4);

		String nomeIlustradore = "", nomeTradutore = "";
		switch (optionLivro) {
		case 1 -> {
			System.out.println("Digite o nome do Ilustradore");
			nomeIlustradore = scanner.nextLine();
			System.out.println("Digite o nome do Tradutore");
			nomeTradutore = scanner.nextLine();
		}
		case 2 -> {
			System.out.println("Digite o nome do Tradutore");
			nomeTradutore = scanner.nextLine();
		}
		case 3 -> {
			System.out.println("Digite o nome do Ilustradore");
			nomeIlustradore = scanner.nextLine();
		}

		case 4 -> {
			System.out.println("Ok.");
		}
		}

		int tipoLivro = 1;
		do {
			System.out.println("Selecione a opção o tipo de Livro\n" + "1 - Livro físico\n" + "2 - Livro Digital\n");

			tipoLivro = scanner.nextInt();
			scanner.nextLine();
		} while (tipoLivro < 1 || tipoLivro > 2);

		int qtdPaginas = 0, idArquivo, idCapa;
		Arquivo tipoArquivo = null;
		Capa tipoCapa = null;
		switch (tipoLivro) {
		case 1 -> {
			System.out.println("Qual a quantidade páginas do livro?");
			qtdPaginas = scanner.nextInt();
			do {
				System.out.println("Selecione o tipo de capa: \n" + "1 - Brochura\n" + "2 - Capa dura\n");

				idCapa = scanner.nextInt();
				scanner.nextLine();

			} while (idCapa < 1 || idCapa > 2);

			switch (idCapa) {
			case 1:
				tipoCapa = Capa.BROCHURA;
				break;
			case 2:
				tipoCapa = Capa.CAPA_DURA;
				break;
			}
		}
		case 2 -> {
			do {
				System.out.println("Selecione o tipo de arquivo: \n" + "1 - EPUB\n" + "2 - MOBI\n" + "3 - PDF");

				idArquivo = scanner.nextInt();
				scanner.nextLine();

			} while (idArquivo < 1 || idArquivo > 3);

			switch (idArquivo) {
			case 1:
				tipoArquivo = Arquivo.EPUB;
				break;
			case 2:
				tipoArquivo = Arquivo.MOBI;
				break;
			case 3:
				tipoArquivo = Arquivo.PDF;
				break;
			}

		}
		}

		if (tipoLivro == 1) {
			if (optionLivro == 1) {
				livroController.atualizar(new LivroFisico(idLivro, nomeLivro, nomeAutore, nomeTradutore,
						nomeIlustradore, estoque, tipoCapa, qtdPaginas));
			} else if (optionLivro == 2) {
				livroController.atualizar(
						new LivroFisico(idLivro, nomeLivro, nomeAutore, estoque, nomeTradutore, tipoCapa, qtdPaginas));
			} else if (optionLivro == 3) {
				livroController.atualizar(new LivroFisico(idLivro, nomeLivro, nomeAutore, nomeIlustradore, estoque,
						tipoCapa, qtdPaginas));
			} else if (optionLivro == 4) {
				livroController
						.atualizar(new LivroFisico(idLivro, nomeLivro, nomeAutore, estoque, tipoCapa, qtdPaginas));
			}
		} else if (tipoLivro == 2) {
			if (optionLivro == 1) {
				livroController.atualizar(new LivroDigital(idLivro, nomeLivro, nomeAutore, nomeTradutore,
						nomeIlustradore, estoque, tipoArquivo));
			} else if (optionLivro == 2) {
				livroController.atualizar(
						new LivroDigital(idLivro, nomeLivro, nomeAutore, estoque, nomeTradutore, tipoArquivo));
			} else if (optionLivro == 3) {
				livroController.atualizar(
						new LivroDigital(idLivro, nomeLivro, nomeAutore, nomeIlustradore, estoque, tipoArquivo));
			} else if (optionLivro == 4) {
				livroController.atualizar(new LivroDigital(idLivro, nomeLivro, nomeAutore, estoque, tipoArquivo));
			} else {
				System.out.println("Aconteceu algum erro ao criar um livro.");
			}
		}

	}

	private static void apagarLivro() {
		System.out.println("\nApagar um livro do estoque.");

		listarLivros();
		System.out.println("Digite o ID do livro que deseja apagar. Digite 0 para Cancelar");
		int idLivro = 1;

		do {
			idLivro = scanner.nextInt();
			scanner.nextLine();
			if (idLivro == 0) {
				return;
			}

		} while (livroController.idExite(idLivro) == false);

		if (idLivro == 0) {
			System.out.println("Cancelando operação");
			return;
		}

		System.out.println("Iniciando processo de remoção");

		livroController.deletar(livroController.procurarPorId(idLivro));
	}

	private static void cadastrarUsuario() {
		System.out.println("\nCadastrar um usuário.");
		// Parte da branch Features
	}

	private static void venderLivro() {
		System.out.println("\nVender um livro para um usuário.");
		// PArte da branch features
	}

	private static void aperteEnter() {
		System.out.println("\nPressione Enter para continuar...");
		@SuppressWarnings("unused")
		String continuar = scanner.nextLine();
	}
}
