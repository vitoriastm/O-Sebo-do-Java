package projeto.vendas;

import java.io.Serializable;
import projeto.usuario.Cliente;
import projeto.livros.Livro;

public class Venda implements Serializable {
    private static final long serialVersionUID = 31;
    private Cliente cliente;
    private Livro livro;
    private int quantidade;
    private int id;
    private double valorTotal;

    public Venda(Cliente cliente, Livro livro, int quantidade) {
        this.cliente = cliente;
        this.livro = livro;
        this.quantidade = quantidade;
        this.valorTotal = calcularValorTotal();
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Livro getLivro() {
        return this.livro;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int novaID) {
        this.id = novaID;
    }

    public void setQuantidade(int novaQntd) {
        this.quantidade = novaQntd;
    }

    private double calcularValorTotal() {
        return this.quantidade * this.livro.getPreco();
    }
}