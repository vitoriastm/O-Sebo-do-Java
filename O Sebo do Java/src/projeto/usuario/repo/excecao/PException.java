package projeto.usuario.repo.excecao;

public class PException extends Exception {
    private String senha;

    public PException(String senha) {
        super("Exceção: Senha inválida.");
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }
}