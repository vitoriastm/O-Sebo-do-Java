package projeto.vendas.repo.excecao;

public class IDException extends Exception {
    private String data;

    public IDException(String data) {
        super("Exceção: A data informada é inválida. [Data informada: " + data + "]");
        this.data = data;
    }

    public String getData() {
        return this.data;
    }
    
}