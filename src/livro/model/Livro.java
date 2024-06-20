package livro.model;

public abstract class Livro {
	private int idLivro;
	private String nomeLivro;
	private String nomeAutore;
	private String nomeTradutore = "";
	private String nomeIlustradore = "";
	private int estoque;

	public Livro(int idLivro, String nomeLivro, String nomeAutore, String nomeTradutore, String nomeIlustradore,
			int estoque) {
		super();
		this.idLivro = idLivro;
		this.nomeLivro = nomeLivro;
		this.nomeAutore = nomeAutore;
		this.nomeTradutore = nomeTradutore;
		this.nomeIlustradore = nomeIlustradore;
		this.estoque = estoque;
	}

	// Livro sem tradutoer e Ilustradore
	public Livro(int idLivro, String nomeLivro, String nomeAutore, int estoque) {
		super();
		this.idLivro = idLivro;
		this.nomeLivro = nomeLivro;
		this.nomeAutore = nomeAutore;
		this.estoque = estoque;
	}

	// Livro sem tradutore
	public Livro(int idLivro, String nomeLivro, String nomeAutore, String nomeIlustradore, int estoque) {
		super();
		this.idLivro = idLivro;
		this.nomeLivro = nomeLivro;
		this.nomeAutore = nomeAutore;
		this.nomeIlustradore = nomeIlustradore;
		this.estoque = estoque;
	}

	// Livro sem ilustradore
	public Livro(int idLivro, String nomeLivro, String nomeAutore, int estoque, String nomeTradutore) {
		super();
		this.idLivro = idLivro;
		this.nomeLivro = nomeLivro;
		this.nomeAutore = nomeAutore;
		this.nomeTradutore = nomeTradutore;
		this.estoque = estoque;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getNomeAutore() {
		return nomeAutore;
	}

	public void setNomeAutore(String nomeAutore) {
		this.nomeAutore = nomeAutore;
	}

	public String getNomeTradutore() {
		return nomeTradutore;
	}

	public void setNomeTradutore(String nomeTradutore) {
		this.nomeTradutore = nomeTradutore;
	}

	public String getNomeIlustradore() {
		return nomeIlustradore;
	}

	public void setNomeIlustradore(String nomeIlustradore) {
		this.nomeIlustradore = nomeIlustradore;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", nomeLivro=" + nomeLivro + ", nomeAutore=" + nomeAutore
				+ ", nomeTradutore=" + nomeTradutore + ", nomeIlustradore=" + nomeIlustradore + ", estoque=" + estoque
				+ ", ";
	}
	
	public void vender() throws Exception {
		if(this.estoque > 0) {
			this.estoque--;
		}else {
			throw new Exception("Livro sem estoque!");
		}
	}

}
