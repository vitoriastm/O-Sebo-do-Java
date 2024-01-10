package projeto.livros.repo.excecao;

import projeto.livros.Livro;

public class LEException extends Exception {
    private Livro livro;

    public LEException(Livro livro) {
        super("Livro ja cadastrado");
        this.livro = livro;
    }
    
    public Livro getLivro() {
        return this.livro;
    }
    
}