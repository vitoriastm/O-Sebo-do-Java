package projeto.usuario.testes;

import projeto.usuario.Funcionario;

public class TesteFuncionario {
    
    public static void main(String[] args) {
        //TesteFuncionario.trocaSenha();
    }
    
    public static void trocaSenha() {
        Funcionario funcExemplo = new Funcionario("111111111", "111111");
        String novaSenha = "121212";
        funcExemplo.setNewSenha(novaSenha);
        if (funcExemplo.getSenha().equals(novaSenha)) {
            System.out.println("Teste 1 passou");
        }
        else {
            System.out.println("Teste 1 não passou");
        }
    }
    
}