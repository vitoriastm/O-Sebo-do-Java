package projeto.vendas.testes;

import projeto.vendas.repo.validador.ValidaData;

public class TesteValidaData {

    public static void main(String[] args) {
        /* TesteValidaData.teste1();
        TesteValidaData.teste2();
        TesteValidaData.teste3();
        TesteValidaData.teste4();
        TesteValidaData.teste5(); */
    }

    public static void teste1() {
        // Data válida
        String data = "07/05/2023";
        if (ValidaData.validarData(data)) {
            System.out.println("Teste 1 passou");
        } else {
            System.out.println("Teste 1 não passou");
        }
    }

    public static void teste2() {
        // Data inválida (mês inválido)
        String data = "01/30/2023";
        if (!ValidaData.validarData(data)) {
            System.out.println("Teste 2 passou");
        } else {
            System.out.println("Teste 2 não passou");
        }
    }

    public static void teste3() {
        // Data inválida (formato inválido)
        String data = "12012023";
        if (!ValidaData.validarData(data)) {
            System.out.println("Teste 3 passou");
        } else {
            System.out.println("Teste 3 não passou");
        }
    }

    public static void teste4() {
        // Data inválida (formato inválido)
        String data = "2023";
        if (!ValidaData.validarData(data)) {
            System.out.println("Teste 4 passou");
        } else {
            System.out.println("Teste 4 não passou");
        }
    }

    public static void teste5() {
        // Data inválida (formato inválido)
        String data = "AA&&AA";
        if (!ValidaData.validarData(data)) {
            System.out.println("Teste 5 passou");
        } else {
            System.out.println("Teste 5 não passou");
        }
    }

}