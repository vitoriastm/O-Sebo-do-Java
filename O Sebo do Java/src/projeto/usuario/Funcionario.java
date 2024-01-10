package projeto.usuario;

public class Funcionario extends Usuario {

    private String senha;
    private static final long serialVersionUID = 21;

    public Funcionario(String cpf, String senha) {
        super(cpf);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setNewSenha(String novaSenha) {
        this.senha = novaSenha;
    }

}