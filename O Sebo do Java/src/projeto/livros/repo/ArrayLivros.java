package projeto.livros.repo;

import projeto.livros.Livro;
import projeto.livros.repo.excecao.*;
import java.io.Serializable;

public class ArrayLivros implements Serializable {
    private static final long serialVersionUID = 4;
    protected Livro[] livros;
    protected int indice;
    protected int tamanho;

    public ArrayLivros(int tamanho) {
        this.livros = new Livro[tamanho];
        this.indice = 0;
        this.tamanho = tamanho;
    }

    public void inserir(Livro livro) throws LEException{
        if (this.indice == this.tamanho) {
            Livro[] copia = new Livro[this.tamanho*2];
            System.arraycopy(this.livros, 0, copia, 0, this.tamanho);
            this.livros = copia;
        }
        if (!this.existe(livro)) {
            this.livros[this.indice] = livro;
            this.indice++;    
        }
        else throw new LEException(livro);
    }

    public void remover(Livro livro) throws LIException{
        if (this.existe(livro)) {
            int posicao = this.buscar(livro);
            this.livros[posicao] = this.livros[this.indice--];
        }
        else throw new LIException(livro);
    }

    public int buscar(Livro livro) {
        for (int i = 0; i < this.indice; i++) {
            if ((this.livros[i].getTitulo()).equals(livro.getTitulo()) && this.livros[i].getPaginas() == livro.getPaginas()) {
                return i;
            }
        }
        return -1;
    }


    public boolean existe(Livro livro) {
        return this.buscar(livro) != -1;
    }

    public Livro livro(int indice) {
        return this.livros[indice];
    }

    public int getIndice() {
        return this.indice;
    }

}
