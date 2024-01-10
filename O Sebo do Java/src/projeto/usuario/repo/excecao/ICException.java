package projeto.usuario.repo.excecao;

public class ICException extends Exception {
    private String cpf;

    public ICException(String cpf) {
        super("Exceção: CPF inválido. [CPF informado: " + cpf + "]");
        this.cpf = cpf;
    }

    public String getCPF() {
        return this.cpf;
    }
    
}