package projeto.usuario.repo.excecao;

public class UCException extends Exception {
    private String cpf;

    public UCException(String cpf) {
        super("Exceção: CPF já utilizado. [CPF informado: " + cpf + "]");
        this.cpf = cpf;
    }

    public String getCPF() {
        return this.cpf;
    }
}