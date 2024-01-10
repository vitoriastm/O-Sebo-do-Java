package projeto.usuario.repo.excecao;

public class IUException extends Exception {
    private String cpf;

    public IUException(String cpf) {
        super("Exceção: Não existem usuários com o CPF informado. [CPF informado: " + cpf + "]");
        this.cpf = cpf;
    }

    public String getCPF() {
        return this.cpf;
    }
}