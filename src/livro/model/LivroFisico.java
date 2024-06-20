package livro.model;

public class LivroFisico extends Livro {

	

	private Capa tipoCapa;
	private int qtdPaginas;

	public LivroFisico(int idLivro, String nomeLivro, String nomeAutore, String nomeTradutore, String nomeIlustradore,
			int estoque, Capa tipoCapa, int qtdPaginas) {
		super(idLivro, nomeLivro, nomeAutore, nomeTradutore, nomeIlustradore, estoque);
		this.tipoCapa = tipoCapa;
		this.qtdPaginas = qtdPaginas;
	}

	// Sem ilustradore e tradutore
	public LivroFisico(int idLivro, String nomeLivro, String nomeAutore, int estoque, Capa tipoCapa,
			int qtdPaginas) {
		super(idLivro, nomeLivro, nomeAutore, estoque);
		this.tipoCapa = tipoCapa;
		this.qtdPaginas = qtdPaginas;
	}

	// Sem tradutore
	public LivroFisico(int idLivro, String nomeLivro, String nomeAutore, String nomeIlustradore, int estoque,
			Capa tipoCapa, int qtdPaginas) {
		super(idLivro, nomeLivro, nomeAutore, nomeIlustradore, estoque);
		this.tipoCapa = tipoCapa;
		this.qtdPaginas = qtdPaginas;
	}

	// Sem ilustradore
	public LivroFisico(int idLivro, String nomeLivro, String nomeAutore, int estoque, String nomeTradutore,
			Capa tipoCapa, int qtdPaginas) {
		super(idLivro, nomeLivro, nomeAutore, estoque, nomeTradutore);
		this.tipoCapa = tipoCapa;
		this.qtdPaginas = qtdPaginas;
	}

	public Capa getTipoCapa() {
		return tipoCapa;
	}

	public void setTipoCapa(Capa tipoCapa) {
		this.tipoCapa = tipoCapa;
	}

	public int getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}
	
	@Override
	public String toString() {
		String retorno = super.toString();
		return  retorno + "tipoCapa=" + tipoCapa + ", qtdPaginas=" + qtdPaginas + "]";
	}

}
