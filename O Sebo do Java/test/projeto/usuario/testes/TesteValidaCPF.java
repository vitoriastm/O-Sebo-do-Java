package projeto.usuario.testes;
    
import projeto.usuario.repo.validador.ValidaCPF;

public class TesteValidaCPF {

    public static void main(String[] args) {
        /* TesteValidaCPF.teste1();
        TesteValidaCPF.teste2();
        TesteValidaCPF.teste3();
        TesteValidaCPF.teste4();
        TesteValidaCPF.teste5();
        TesteValidaCPF.teste6(); */
    }    

    public static void teste1() {
        // Teste 1: CPF inválido com mais de onze dígitos
        String cpf = "111111111111";
        if (!ValidaCPF.validarCPF(cpf)) {
            System.out.println("Teste 1 passou");
        }
    }

    public static void teste2() {
        // Teste 2: CPF inválido com menos de onze dígitos
        String cpf = "111111111";
        if (!ValidaCPF.validarCPF(cpf)) {
            System.out.println("Teste 2 passou");
        }
    }

    public static void teste3() {
        // Teste 3: CPF inválido vazio
        String cpf = "";
        if (!ValidaCPF.validarCPF(cpf)) {
            System.out.println("Teste 3 passou");
        }
    }

    public static void teste4() {
        // Teste 4: CPF inválido com caracteres especiais e letras
        String cpf = "ABC#%";
        if (!ValidaCPF.validarCPF(cpf)) {
            System.out.println("Teste 4 passou");
        }
    }

    public static void teste5() {
        // Teste 5: CPF inválido
        String cpf = "111111111";
        if (!ValidaCPF.validarCPF(cpf)) {
            System.out.println("Teste 5 passou");
        }
    }

    public static void teste6() {
        // Teste 6: CPF válido (fictício)
        String cpf = "68912214209";
        if (ValidaCPF.validarCPF(cpf)) {
            System.out.println("Teste 6 passou");
        }
    }
  
}