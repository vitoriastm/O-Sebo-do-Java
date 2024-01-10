package projeto.vendas.repo;

import projeto.usuario.Cliente;
import projeto.livros.Livro;
import projeto.livros.repo.ArrayLivros;
import projeto.vendas.Venda;
import projeto.usuario.repo.ArrayClientes;
import java.io.Serializable;
import projeto.sistema.Serializacao;
import projeto.sistema.arquivos.DiretorioArquivos;

import projeto.vendas.repo.excecao.*;

public class ArrayVendas implements Serializable {
    // Classe utilizada para armazenar e tratar objetos do tipo "Venda
    // Um objeto venda pode até ser criado, mas só sera registrado no sistema se for
    // válido

    private Venda[] vendas;
    private int indice;
    private static final long serialVersionUID = 3;

    public ArrayVendas(int capacidade) {
        this.indice = 0;
        this.vendas = new Venda[capacidade];
    }

    public void gerarVenda(ArrayClientes repoCliente, ArrayLivros repoLivro, Cliente cliente, Livro livro,
        int quantidade)
        throws IAException, IBException, IClException, IDException {
        if (quantidade <= 0) {
            throw new IAException(quantidade);
        } else if (!repoLivro.existe(livro)) {
            throw new IBException(livro);
        } else if (repoCliente.buscarUsuario(cliente.getCPF()) == null) {
            throw new IClException(cliente);
        } else {
            Venda novaVenda = new Venda(cliente, livro, quantidade);
            novaVenda.setID(this.indice + 1);
            this.vendas[this.indice] = novaVenda;
            this.indice++;
            Serializacao.serializar(this, DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\vendas.bin");
        }
    }

    public void cancelarVenda(int id) throws ISException {
        if (!existeVenda(id)) {
            throw new ISException(id);
        } else {
            int pos = this.procurarPos(id);
            for (int i = pos; i < this.quantidadeVendas() - 1; i++) {
                this.vendas[i] = this.vendas[i + 1];
            }
            this.vendas[this.quantidadeVendas() - 1] = null;
            this.indice--;
            Serializacao.serializar(this, DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\vendas.bin");
        }
    }

    public boolean existeVenda(int id) {
        return id != 0 && retornaVenda(id) != null;
    }

    public Venda retornaVenda(int id) {
        for (int i = 0; i < this.quantidadeVendas(); i++) {
            if (vendas[i].getID() == id - 1) {
                return vendas[i];
            }
          }
        return null;
    }

    public int procurarPos(int id) {
        for (int i = 0; i < this.quantidadeVendas(); i++) {
            if (vendas[i].getID() == id - 1) {
                return i;
            }
        }
        return -1;
    }

    public Venda[] obterVendas() {
        Venda[] lista = null;
        if (this.quantidadeVendas() > 0) {
            lista = new Venda[this.quantidadeVendas()];
            System.arraycopy(this.vendas, 0, lista, 0, this.quantidadeVendas());
        }
        return lista;
    }

    public int quantidadeVendas() {
        return this.indice;
    }

}