package livro.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import livro.model.Livro;
import livro.repository.LivroRepository;

public class LivroController implements LivroRepository {
	
	private HashMap<Integer, Livro> listaLivros = new HashMap<>();
	int numero = 0;

	@Override
	public Livro procurarPorId(int numero) {
		return listaLivros.get(numero);
	}

	@Override
	public ArrayList<Livro> listarTodos() {
		return new ArrayList<Livro>(listaLivros.values());
	}

	@Override
	public void cadastrar(Livro livro) {
		
		Optional<Livro> livroOp = Optional.ofNullable(livro);
		
		if(livroOp.isEmpty()) {
			System.out.println("Erro ao adicionar livro");
		}else {
			listaLivros.put(livro.getIdLivro(), livro);
			System.out.printf("\nLivro %s cadastrado com sucesso", livro.getNomeLivro());
		}
		
	}

	@Override
	public void atualizar(Livro livro) {
		if(checarLivroExiste(livro) == false) {return;}
		
		listaLivros.replace(livro.getIdLivro(), livro);
		
		System.out.println("Livro atualizado com sucesso");
	}

	@Override
	public void deletar(Livro livro) {
		if(checarLivroExiste(livro) == false) {return;}
		
		listaLivros.remove(livro.getIdLivro());
	}
	
	
	private boolean checarLivroExiste(Livro livro) {
		Optional<Livro> livroOptional = Optional.ofNullable(livro);
		
		if(livroOptional.isEmpty()) {
			System.out.println("Não foi possível, livro nulo.");
			return false;
		}
		
		if(listaLivros.containsKey(livro.getIdLivro()) == false) {
			System.out.println("Não foi possível, livro não existe no estoque.");
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean idExiste (int id) {
		return listaLivros.containsKey(id);
	}


	
	public int numeroControle() {
		return ++numero;
	}
	
	@Override
	public List<Livro> procurarPorNome(String pesquisa){
		List<Livro> resultado = new ArrayList<>();
		

        for (Livro livro : listaLivros.values()) {
            if (livro.getNomeLivro().toLowerCase().contains(pesquisa.toLowerCase())) {
                resultado.add(livro);
            }
        }
        
        
		return resultado;
	}

	

}
