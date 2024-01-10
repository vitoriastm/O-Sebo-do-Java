package projeto.livros.repo;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import projeto.livros.Livro;
import java.util.Random;
import projeto.livros.repo.excecao.LEException;
import projeto.sistema.arquivos.DiretorioArquivos;

public class EstoqueLivros extends ArrayLivros {
    // Por questão de simplicidade, não será controlada a quantidade de livros disponíveis, apenas se existem no catálogo

    String filePath = (DiretorioArquivos.getDir() + "\\src\\projeto\\livros\\dataset\\books.csv");
    int colunasParaLer = 3;

    public EstoqueLivros(int tamanho) {
        super(tamanho); 
        //'tamanho' espacos para livros do dataset, 'tamanho' espacos para livros a serem inseridos
    }

    public void lerCatalogo() throws CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            Random rand = new Random();
            String[] cabecalho = reader.readNext();
            String[] proximaLinha;
            int indice = 0;
            while ((proximaLinha = reader.readNext()) != null && indice < tamanho) {
                if (proximaLinha.length >= colunasParaLer) {
                    String titulo = proximaLinha[1];
                    String autor = proximaLinha[2];
                    int paginas = Integer.parseInt(proximaLinha[7]);
                    int preco = (paginas*(1+(rand.nextInt(10)-5)/10))/10;

                    this.inserir(new Livro(titulo, autor, paginas, preco));
                    ++indice;
                    System.out.println(indice);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LEException le) {
            System.out.println("livro ja cadastrado");
        }
    }
    
}
