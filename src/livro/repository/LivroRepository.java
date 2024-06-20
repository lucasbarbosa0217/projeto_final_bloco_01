package livro.repository;

import java.util.ArrayList;
import java.util.List;

import livro.model.Livro;

public interface LivroRepository {

		public Livro procurarPorId(int numero);
		public ArrayList<Livro> listarTodos();
		public void cadastrar(Livro livro);
		public void atualizar(Livro livro);
		public void deletar(Livro livro);
		public boolean idExiste(int id);
		public List<Livro> procurarPorNome(String termo);
}

