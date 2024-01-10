package projeto.usuario;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
 
    public String cpf;

    public Usuario(String cpf) {
        this.cpf = cpf;
    }

    public String getCPF() {
        return this.cpf;
    }

}