package projeto.vendas.repo.excecao;

public class ISException extends Exception {
    private int id;

    public ISException(int id) {
        super("Exceção: A venda informada é inválida. [ID de venda informado: " + id + "]");
        this.id = id;
    }

    public int getID() {
        return this.id;
    }
    
}