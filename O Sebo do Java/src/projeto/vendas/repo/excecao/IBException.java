package projeto.vendas.repo.excecao;

import projeto.livros.Livro;

public class IBException extends Exception {
    private Livro livro;

    public IBException(Livro livro) {
        super("Exceção: O livro informado é inválido. [Livro informado: " + livro + "]");
        this.livro = livro;
    }

    public Livro getLivro() {
        return this.livro;
    }
  
}