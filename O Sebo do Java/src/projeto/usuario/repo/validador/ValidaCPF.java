package projeto.usuario.repo.validador;

public class ValidaCPF {
    public static boolean validarCPF(String CPF) {
        if (CPF == null)
          return false;

        // Verifica se o CPF possui 11 dígitos
        if (CPF.length() != 11)
            return false;

        // Remove caracteres não numéricos
        CPF = CPF.replaceAll("[^0-9]", "");

        // Considera-se erro CPFs formados por uma sequência de números iguais
        if (CPF.matches("(\\d)\\1{10}"))
            return false;

        char digito1, digito2;
        int soma, i, r, num, pesoAtribuido;

        // Cálculo do 1o. Dígito Verificador
        soma = 0;
        pesoAtribuido = 10;
        for (i = 0; i < 9; i++) {
            num = Character.getNumericValue(CPF.charAt(i));
            soma = soma + (num * pesoAtribuido);
            pesoAtribuido = pesoAtribuido - 1;
        }

        r = 11 - (soma % 11);

        // Convertendo o resultado do cálculo (r) para o caractere correspondente na
        // tabela ASCII
        // Adicionando 48 ao resultado para obter o código ASCII do dígito numérico
        digito1 = (char) (r + 48);

        // Se o resultado do módulo for 10 ou 11, o dígito é representado por '0'
        if ((r == 10) || (r == 11)) {
            digito1 = '0';
        }

        // Cálculo do 2o. Dígito Verificador
        soma = 0;
        pesoAtribuido = 11;
        for (i = 0; i < 10; i++) {
            num = Character.getNumericValue(CPF.charAt(i));
            soma = soma + (num * pesoAtribuido);
            pesoAtribuido = pesoAtribuido - 1;
        }

        r = 11 - (soma % 11);

        // Convertendo o resultado do cálculo (r) para o caractere correspondente na
        // tabela ASCII
        // Adicionando 48 ao resultado para obter o código ASCII do dígito numérico
        digito2 = (char) (r + 48);

        // Se o resultado do módulo for 10 ou 11, o dígito é representado por '0'
        if ((r == 10) || (r == 11)) {
            digito2 = '0';
        }

        // Verifica se os dígitos calculados conferem com os dígitos informados.
        return (digito1 == CPF.charAt(9)) && (digito2 == CPF.charAt(10));
    }
    
}
