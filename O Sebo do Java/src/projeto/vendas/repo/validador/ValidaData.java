package projeto.vendas.repo.validador;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidaData {

    public static boolean validarData(String dataString) {
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataString, formato);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

}
