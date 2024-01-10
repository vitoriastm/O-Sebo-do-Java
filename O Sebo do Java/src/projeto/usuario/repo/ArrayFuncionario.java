package projeto.usuario.repo;

import projeto.sistema.Serializacao;
import projeto.usuario.Usuario;
import projeto.usuario.Funcionario;
import projeto.usuario.repo.validador.ValidaSenha;
import java.io.*;
import projeto.sistema.arquivos.DiretorioArquivos;

import projeto.usuario.repo.excecao.ICException;
import projeto.usuario.repo.excecao.PException;
import projeto.usuario.repo.excecao.UCException;
import projeto.usuario.repo.excecao.IUException;

public class ArrayFuncionario implements IRepo, Serializable {

    private Funcionario[] funcionarios;
    private int indice;
    private static final long serialVersionUID = 2;

    public ArrayFuncionario(int capacidade) {
      this.indice = 0;
      this.funcionarios = new Funcionario[capacidade];
    }

    @Override
    public void cadastrarUsuario(Usuario novoUsuario) throws ICException, PException, UCException {
    }

    public void cadastrarUsuario(Funcionario novoFuncionario) throws ICException, PException, UCException {
        String cpfFunc = novoFuncionario.getCPF();
        String senhaFunc = novoFuncionario.getSenha();
        if (this.existeUsuario(cpfFunc) == true) {
            throw new UCException(cpfFunc);
        } else if (!this.validarCPF(cpfFunc)) {
            throw new ICException(cpfFunc);
        } else if (!this.validarSenha(senhaFunc)) {
            throw new PException(senhaFunc);
        } else {
            this.funcionarios[this.indice] = novoFuncionario;
            this.indice++;
            Serializacao.serializar(this, DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\funcionarios.bin");
        }
    }

    @Override
    public void removerUsuario(String cpf) throws IUException {
        if (!this.existeUsuario(cpf)) {
            throw new IUException(cpf);
        } else {
            int pos = this.posicaoUsuario(cpf);
            for (int i = pos; i < this.getTamanho() - 1; i++) {
                this.funcionarios[i] = this.funcionarios[i + 1];
            }
            this.funcionarios[this.getTamanho() - 1] = null;
            this.indice--;
            Serializacao.serializar(this, DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\funcionarios.bin");
        }
    }

    @Override
    public boolean existeUsuario(String cpf) {
        return cpf != null && buscarUsuario(cpf) != null;
    }

    @Override
    public Funcionario buscarUsuario(String cpf) {
        for (int i = 0; i < this.getTamanho(); i++) {
            if (funcionarios[i].getCPF().equals(cpf)) {
                return funcionarios[i];
            }
        }
        return null;
    }

    @Override
    public int posicaoUsuario(String cpf) {
        for (int i = 0; i < this.getTamanho(); i++) {
            if (funcionarios[i].getCPF().equals(cpf)) {
                return i;
            }
          }
        return -1;
    }

    @Override
    public Funcionario[] listarUsuarios() {
        Funcionario[] lista = null;
        if (this.getTamanho() > 0) {
            lista = new Funcionario[this.getTamanho()];
            System.arraycopy(this.funcionarios, 0, lista, 0, this.getTamanho());
        }
        return lista;
    }

    @Override
    public int getTamanho() {
        return this.indice;
    }

    public boolean validarSenha(String senha) {
        return ValidaSenha.validarSenha(senha);
    }

    public void setSenha(String novaSenha, String cpf) throws PException, IUException {
        if (!this.validarSenha(novaSenha)) {
            throw new PException(novaSenha);
        } else if (!this.existeUsuario(cpf)) {
            throw new IUException(cpf);
        } else {
            buscarUsuario(cpf).setNewSenha(novaSenha);
        }
    }

}