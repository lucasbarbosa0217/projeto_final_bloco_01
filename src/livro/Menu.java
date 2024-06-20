package livro;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
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

		inicializar();
		do {
			exibirMenu();
			System.out.println("Escolha a opção do Menu.");
			option = scanner.nextInt();
			scanner.nextLine();

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
				venderLivro();
				aperteEnter();
				break;
			case 6:

				buscarLivroPorNome();
				aperteEnter();
				break;

			case 7:
				buscarLivroPorId();
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

	private static void buscarLivroPorNome() {
		System.out.println("Digite sua pesquisa:");
		String termoPesquisa = scanner.nextLine();

		List<Livro> resultado = livroController.buscarLivroNome(termoPesquisa);

		if (resultado.isEmpty()) {
			System.out.println("Pesquisa não teve resultados.");
			return;
		}

		resultado.forEach(livro -> {
			System.out.println(livro);
		});

	}

	public static void exibirMenu() {
		System.out.println("\n=============================================");
		System.out.println("             Livraria Gerações               ");
		System.out.println("=============================================");
		System.out.printf("%-45s%n", "1 - Adicionar livro no estoque");
		System.out.printf("%-45s%n", "2 - Ver lista de livros no Estoque");
		System.out.printf("%-45s%n", "3 - Atualizar livro no estoque");
		System.out.printf("%-45s%n", "4 - Apagar livro do estoque");
		System.out.printf("%-45s%n", "5 - Vender livro");
		System.out.printf("%-45s%n", "6 - Buscar livro por nome");
		System.out.printf("%-45s%n", "7 - Buscar livro por id");
		System.out.printf("%-45s%n", "0 - Fechar programa");
		System.out.printf("%-45s%n", "=============================================\n");
	}

	private static void adicionarLivro() {
		System.out.println("\nAdicionar um Livro.");

		Livro novoLivro = inputsLivro(livroController.numeroControle());

		livroController.cadastrar(novoLivro);
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

		Livro updLivro = inputsLivro(idLivro);

		livroController.atualizar(updLivro);

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

	private static Livro inputsLivro(int idLivro) {

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
				return new LivroFisico(idLivro, nomeLivro, nomeAutore, nomeTradutore, nomeIlustradore, estoque,
						tipoCapa, qtdPaginas);
			} else if (optionLivro == 2) {

				return new LivroFisico(idLivro, nomeLivro, nomeAutore, estoque, nomeTradutore, tipoCapa, qtdPaginas);
			} else if (optionLivro == 3) {
				return new LivroFisico(idLivro, nomeLivro, nomeAutore, nomeIlustradore, estoque, tipoCapa, qtdPaginas);
			} else if (optionLivro == 4) {
				return new LivroFisico(idLivro, nomeLivro, nomeAutore, estoque, tipoCapa, qtdPaginas);
			}
		} else if (tipoLivro == 2) {
			if (optionLivro == 1) {
				return new LivroDigital(idLivro, nomeLivro, nomeAutore, nomeTradutore, nomeIlustradore, estoque,
						tipoArquivo);
			} else if (optionLivro == 2) {
				return new LivroDigital(idLivro, nomeLivro, nomeAutore, estoque, nomeTradutore, tipoArquivo);
			} else if (optionLivro == 3) {
				return new LivroDigital(idLivro, nomeLivro, nomeAutore, nomeIlustradore, estoque, tipoArquivo);
			} else if (optionLivro == 4) {
				return new LivroDigital(idLivro, nomeLivro, nomeAutore, estoque, tipoArquivo);
			} else {
				System.out.println("Aconteceu algum erro ao criar um livro.");
			}
		} else {
			return null;
		}
		return null;

	}

	private static void venderLivro() {
		System.out.println("\nVender um livro");

		listarLivros();
		System.out.println("Digite o ID do livro que deseja vender. Digite 0 para Cancelar");
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

		Livro livro = livroController.procurarPorId(idLivro);

		try {
			livro.vender();
			System.out.println("Livro vendido!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void aperteEnter() {
		System.out.println("\nPressione Enter para continuar...");
		@SuppressWarnings("unused")
		String continuar = scanner.nextLine();
	}

	private static void inicializar() {
		LivroFisico livro1 = new LivroFisico(livroController.numeroControle(), "Dom Casmurro", "Machado de Assis",
				"Fulano Silva", "Ciclano Pereira", 50, Capa.CAPA_DURA, 256);
		livroController.cadastrar(livro1);

		LivroFisico livro2 = new LivroFisico(livroController.numeroControle(), "Memórias Póstumas de Brás Cubas",
				"Machado de Assis", 40, "Beltrano Souza", Capa.BROCHURA, 192);
		livroController.cadastrar(livro2);

		LivroFisico livro3 = new LivroFisico(livroController.numeroControle(), "Quincas Borba", "Machado de Assis",
				"Ciclano Pereira", 30, Capa.CAPA_DURA, 304);
		livroController.cadastrar(livro3);

		LivroFisico livro4 = new LivroFisico(livroController.numeroControle(), "O Alienista", "Machado de Assis", 20,
				Capa.BROCHURA, 128);
		livroController.cadastrar(livro4);

		LivroDigital livro5 = new LivroDigital(livroController.numeroControle(), "Dom Casmurro", "Machado de Assis",
				"Fulano Silva", "Ciclano Pereira", 50, Arquivo.EPUB);
		livroController.cadastrar(livro5);

		LivroDigital livro6 = new LivroDigital(livroController.numeroControle(), "Memórias Póstumas de Brás Cubas",
				"Machado de Assis", 40, "Beltrano Souza", Arquivo.PDF);
		livroController.cadastrar(livro6);

		LivroDigital livro7 = new LivroDigital(livroController.numeroControle(), "Quincas Borba", "Machado de Assis",
				"Ciclano Pereira", 30, Arquivo.EPUB);
		livroController.cadastrar(livro7);

		LivroDigital livro8 = new LivroDigital(livroController.numeroControle(), "O Alienista", "Machado de Assis", 20,
				Arquivo.PDF);
		livroController.cadastrar(livro8);

	}
	
	private static void buscarLivroPorId() {
		System.out.println("\nBuscar livro por ID.");
		System.out.println("Digite um id");
		int idLivro = scanner.nextInt();
		scanner.nextLine();
		
		Optional<Livro> livroOp = Optional.ofNullable(livroController.procurarPorId(idLivro));
		
		if(livroOp.isEmpty()) {
			System.out.println("Este livro não existe no registro");
			return;
		}
		
		System.out.println(livroOp.get());
		
	}
}
