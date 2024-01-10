package projeto.usuario.repo;

import java.io.Serializable;

import projeto.usuario.Usuario;
import projeto.usuario.Cliente;
import projeto.sistema.Serializacao;
import projeto.sistema.arquivos.DiretorioArquivos;

import projeto.usuario.repo.excecao.ICException;
import projeto.usuario.repo.excecao.PException;
import projeto.usuario.repo.excecao.UCException;
import projeto.usuario.repo.excecao.IUException;

public class ArrayClientes implements IRepo, Serializable {

    private Cliente[] clientes;
    private int indice;
    private static final long serialVersionUID = 1;

    public ArrayClientes(int capacidade) {
        this.indice = 0;
        this.clientes = new Cliente[capacidade];
    }

    @Override
    public void cadastrarUsuario(Usuario novoUsuario) throws ICException, PException, UCException {
    }

    public void cadastrarUsuario(Cliente novoCliente) throws ICException, UCException {
        String cpfFunc = novoCliente.getCPF();
        if (this.existeUsuario(cpfFunc) == true) {
            throw new UCException(cpfFunc);
        } else if (!this.validarCPF(cpfFunc)) {
            throw new ICException(cpfFunc);
        } else {
            this.clientes[this.indice] = novoCliente;
            this.indice++;
            Serializacao.serializar(this, DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\clientes.bin");
        }
    }

    @Override
    public void removerUsuario(String cpf) throws IUException {
        if (!this.existeUsuario(cpf)) {
            throw new IUException(cpf);
        } else {
            int pos = this.posicaoUsuario(cpf);
            for (int i = pos; i < this.getTamanho() - 1; i++) {
                this.clientes[i] = this.clientes[i + 1];
            }
            this.clientes[this.getTamanho() - 1] = null;
            this.indice--;
            Serializacao.serializar(this, DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\clientes.bin");
        }
    }

    @Override
    public boolean existeUsuario(String cpf) {
        return cpf != null && buscarUsuario(cpf) != null;
    }

    @Override
    public Cliente buscarUsuario(String cpf) {
        for (int i = 0; i < this.getTamanho(); i++) {
            if (clientes[i].getCPF().equals(cpf)) {
                return clientes[i];
            }
        }
        return null;
    }

    @Override
    public int posicaoUsuario(String cpf) {
        for (int i = 0; i < this.getTamanho(); i++) {
            if (clientes[i].getCPF().equals(cpf)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Cliente[] listarUsuarios() {
        Cliente[] lista = null;
        if (this.getTamanho() > 0) {
            lista = new Cliente[this.getTamanho()];
            System.arraycopy(this.clientes, 0, lista, 0, this.getTamanho());
        }
        return lista;
    }

    @Override
    public int getTamanho() {
        return this.indice;
    }
  
}