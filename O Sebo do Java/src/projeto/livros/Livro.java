package projeto.livros;

import java.io.Serializable;

public class Livro implements Serializable {
    private static final long serialVersionUID = 41;
    private String titulo;
    private String autor;
    private int paginas;
    private int preco;
      
    public Livro(String titulo, String autor, int paginas, int preco) {
      this.titulo = titulo;
      this.autor = autor;
      this.paginas = paginas;
      this.preco = preco;
    }
    
    public String getTitulo() {
      return this.titulo;
    }
    
    public String getAutor() {
      return this.autor;
    }
    
    public int getPreco() {
      return this.preco;
    }
    
    public int getPaginas() {
      return this.paginas;
    }
    
}