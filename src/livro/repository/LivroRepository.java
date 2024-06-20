package livro.repository;

import livros.model.Livro;

public interface LivroRepository {

		public void procurarPorId(int numero);
		public void listarTodos();
		public void cadastrar(Livro livro);
		public void atualizar(Livro livro);
		public void deletar(int numero);
		public void vender(Livro livro);
}

