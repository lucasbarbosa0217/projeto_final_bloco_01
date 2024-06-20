package livro.repository;

import java.util.ArrayList;

import livro.model.Livro;

public interface LivroRepository {

		public Livro procurarPorId(int numero);
		public ArrayList<Livro> listarTodos();
		public void cadastrar(Livro livro);
		public void atualizar(Livro livro);
		public void deletar(Livro livro);
}

