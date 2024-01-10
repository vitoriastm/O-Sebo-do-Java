package projeto.usuario.repo;

import projeto.usuario.repo.excecao.ICException;
import projeto.usuario.repo.excecao.IUException;
import projeto.usuario.repo.excecao.PException;
import projeto.usuario.repo.excecao.UCException;

import projeto.usuario.Usuario;
import projeto.usuario.repo.validador.ValidaCPF;

public interface IRepo {

    public void cadastrarUsuario(Usuario novoUsuario) throws ICException, PException, UCException;

    public void removerUsuario(String cpf) throws IUException;

    public boolean existeUsuario(String cpf);

    public Usuario buscarUsuario(String cpf);

    public int posicaoUsuario(String cpf);

    public Usuario[] listarUsuarios();

    public int getTamanho();

    public default boolean validarCPF(String cpf) {
        return ValidaCPF.validarCPF(cpf);
    }

}