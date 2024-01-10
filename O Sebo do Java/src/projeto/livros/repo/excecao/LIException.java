package projeto.livros.repo.excecao;

import projeto.livros.Livro;

public class LIException extends Exception {
    private Livro livro;

    public LIException(Livro livro) {
      super("Livro nao cadastrado");
      this.livro = livro;
    }
    
    public Livro getLivro() {
      return this.livro;
    }
    
}