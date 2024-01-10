package projeto.vendas.repo.excecao;

public class IAException extends Exception {
    private int quantidade;

    public IAException(int quantidade) {
        super("Exceção: A quantidade informada é inválida. [Quantidade informada: " + quantidade + "]");
        this.quantidade = quantidade;
    }

    public int getQntd() {
        return this.quantidade;
    }
    
}