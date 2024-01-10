package projeto.usuario.repo.validador;

public class ValidaSenha {
    public static boolean validarSenha(String senha) {
        // Verifica se a senha tem exatamente 6 dígitos
        if (senha.length() != 6) {
            return false;
        }

        // Verifica se a senha contém apenas números
        for (char caractere : senha.toCharArray()) {
            if (!Character.isDigit(caractere)) {
                return false;
            }
        }

        // Se passou pelas verificações anteriores, a senha é válida
        return true;
    }
}
