package projeto.vendas.repo.excecao;

import projeto.usuario.Cliente;

public class IClException extends Exception {
    private Cliente cliente;

    public IClException(Cliente cliente) {
        super("Exceção: O cliente informado é inválido. [CPF do cliente informada: " + cliente.getCPF() + "]");
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
    
}