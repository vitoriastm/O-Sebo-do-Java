package projeto.usuario.testes;

import projeto.usuario.repo.validador.ValidaSenha;

public class TesteValidaSenha {
    
    public static void main(String[] args) {
        /* TesteValidaSenha.teste1();
        TesteValidaSenha.teste2();
        TesteValidaSenha.teste3();
        TesteValidaSenha.teste4();
        TesteValidaSenha.teste5(); */
    }
    
    public static void teste1() {
        // Testa senha com apenas letras e caracteres especiais
        String senha = "AA%%&&";
        if (!ValidaSenha.validarSenha(senha)) {
            System.out.println("Teste 1 passou");
        } else {
            System.out.println("Teste 1 não passou");
        }
    }
    
    public static void teste2() {
        // Testa senha com mais de seis dígitos
        String senha = "1111111";
        if (!ValidaSenha.validarSenha(senha)) {
            System.out.println("Teste 2 passou");
        } else {
            System.out.println("Teste 2 não passou");
        }
    }
    
    public static void teste3() {
        // Testa senha com menos de seis dígitos
        String senha = "1111";
        if (!ValidaSenha.validarSenha(senha)) {
            System.out.println("Teste 3 passou");
        }
        else {
            System.out.println("Teste 3 não passou");
        }
    }
    
    public static void teste4() {
        // Testa senha com dígitos e letras (com tamanho correto)
        String senha = "11111A";
        if (!ValidaSenha.validarSenha(senha)) {
            System.out.println("Teste 4 passou");
        }
        else {
            System.out.println("Teste 4 não passou");
        }
    }
        
    public static void teste5() {
        // Testa uma senha que atende as condições
        String senha = "112233";
        if (ValidaSenha.validarSenha(senha)) {
            System.out.println("Teste 5 passou");
        }
        else {
            System.out.println("Teste 5 não passou");
        }
    }
    
}
    