package livros.model;

public class LivroDigital extends Livro{

	private Arquivo tipoArquivo;
	
	public LivroDigital(int idLivro, String nomeLivro, String nomeAutore, String nomeTradutore, String nomeIlustradore,
			int estoque, Arquivo tipoArquivo) {
		super(idLivro, nomeLivro, nomeAutore, nomeTradutore, nomeIlustradore, estoque);
		this.setTipoArquivo(tipoArquivo);
	}
	
	
	//Sem ilustradore e Tradutore
	public LivroDigital(int idLivro, String nomeLivro, String nomeAutore,
			int estoque, Arquivo tipoArquivo) {
		super(idLivro, nomeLivro, nomeAutore, estoque);
		this.setTipoArquivo(tipoArquivo);
	}
	
	
	//Sem tradutore
	public LivroDigital(int idLivro, String nomeLivro, String nomeAutore, String nomeIlustradore,
			int estoque, Arquivo tipoArquivo) {
		super(idLivro, nomeLivro, nomeAutore, nomeIlustradore, estoque);
		this.setTipoArquivo(tipoArquivo);
	}
	
	//Sem Ilustradore
	public LivroDigital(int idLivro, String nomeLivro, String nomeAutore, 
			int estoque, String nomeTradutore, Arquivo tipoArquivo) {
		super(idLivro, nomeLivro, nomeAutore,  estoque, nomeTradutore);
		this.setTipoArquivo(tipoArquivo);
	}

	public Arquivo getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(Arquivo tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

}
