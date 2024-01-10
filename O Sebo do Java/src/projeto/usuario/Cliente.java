package projeto.usuario;

import projeto.livros.Livro;

public class Cliente extends Usuario {
    
    private static final long serialVersionUID = 11;
    private Livro[] livrosComprados;
    private int qntdLivros;

    public Cliente(String cpf) {
        super(cpf);
        this.livrosComprados = new Livro[100];
        this.qntdLivros = 0;
    }

    public int getQntdLivros() {
        return this.qntdLivros;
    }

    public Livro[] listarLivrosComprados() {
        Livro[] lista = null;
        if (this.getQntdLivros() > 0) {
            lista = new Livro[this.getQntdLivros()];
            System.arraycopy(this.livrosComprados, 0, lista, 0, this.getQntdLivros());
        }
        return lista;
    }

    public void comprarLivro(Livro novoLivro) {
        this.livrosComprados[qntdLivros] = novoLivro;
        this.qntdLivros++;
    }

}