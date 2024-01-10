package projeto.sistema;

import java.io.*;
import projeto.usuario.*;
import projeto.usuario.repo.*;
import projeto.usuario.repo.excecao.*;
import projeto.vendas.repo.*;
import projeto.livros.repo.*;
import com.opencsv.exceptions.CsvValidationException;
import projeto.sistema.arquivos.DiretorioArquivos;

public class GerenciadorLivraria {
    // Classe criada para servir como apoio ao desenvolvimento da interface. Funções
    // serão desenvolvidas aqui como complemento.
    // Testes e exceções também serão desenvolvidos de acordo com a necessidade do
    // programa.

    // Inicializar repositório de livros
    private ArrayClientes repositorioClientes;
    private ArrayFuncionario repositorioFuncionarios;
    private ArrayVendas repositorioVendas;
    private ArrayLivros repositorioLivros;

    // O construtor será utilizado como um método que inicializa o sistema
    public GerenciadorLivraria() {
        this.repositorioClientes = GerenciadorLivraria.desserializarCliente(DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\clientes.bin");
        this.repositorioFuncionarios = GerenciadorLivraria.desserializarFunc(DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\funcionarios.bin");
        this.repositorioVendas = GerenciadorLivraria.desserializarVendas(DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\vendas.bin");
        this.repositorioLivros = GerenciadorLivraria.desserializarLivros(DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\livros.bin");
    }

    public static void cadastraCliente(String cpf) {
        try {
            ArrayClientes repositorioClientes = GerenciadorLivraria.desserializarCliente(DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\clientes.bin");
            repositorioClientes.cadastrarUsuario(new Cliente(cpf));
        } catch (ICException | UCException e){
            System.err.println("Exceção capturada: " + e.getMessage());
        }
    }

    public static void cadastraFuncionario(String cpf, String senha) {
        try {
            ArrayFuncionario repoFuncionario = GerenciadorLivraria.desserializarFunc(DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\funcionarios.bin");
            repoFuncionario.cadastrarUsuario(new Funcionario(cpf, senha));
        } catch (ICException|PException|UCException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
        }
    } 

    public ArrayClientes getRepoCliente() {
        return this.repositorioClientes;
    }

    public ArrayFuncionario getRepoFunc() {
        return this.repositorioFuncionarios;
    }

    public ArrayVendas getRepoVenda() {
        return this.repositorioVendas;
    }

    public ArrayLivros getRepoLivros() {
        return this.repositorioLivros;
    }

    public static ArrayClientes desserializarCliente(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    ArrayClientes newArrayClientes = new ArrayClientes(100);
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
                    out.writeObject(newArrayClientes);
                } catch (IOException e) {
                  e.printStackTrace();
              }
            }

            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();

            if (obj instanceof ArrayClientes) {
                return (ArrayClientes) obj;
            } else {
                System.out.println("Unexpected object type.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayFuncionario desserializarFunc(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    ArrayFuncionario newArrayFunc = new ArrayFuncionario(100);
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
                    out.writeObject(newArrayFunc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            
            if (obj instanceof ArrayFuncionario) {
                return (ArrayFuncionario) obj;
            } else {
                System.out.println("Unexpected object type.");
            }
        } catch (IOException | ClassNotFoundException e) {
              e.printStackTrace();
        }
        return null;
    }

    public static ArrayVendas desserializarVendas(String filePath) {
    try {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                ArrayVendas newArrayVendas = new ArrayVendas(100);
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
                out.writeObject(newArrayVendas);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileInputStream fileIn = new FileInputStream(filePath);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        Object obj = objectIn.readObject();
        
        if (obj instanceof ArrayVendas) {
            return (ArrayVendas) obj;
        } else {
            System.out.println("Unexpected object type.");
        }
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return null;
    }

    public static ArrayLivros desserializarLivros(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                // Ler catalogo aqui
                try {
                    ArrayLivros estoque = new EstoqueLivros(100);
                    ((EstoqueLivros) estoque).lerCatalogo();
                    file.createNewFile();
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
                    out.writeObject(estoque);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (CsvValidationException csve) {
                    System.out.println("erro ao ler dataset");
                }
            }

            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            if (obj instanceof ArrayLivros) {
                return (ArrayLivros) obj;
            } else {
                System.out.println("Unexpected object type.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    return null;
    }

    public static void main(String[] args) {
        GerenciadorLivraria.desserializarCliente(DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\clientes.bin");
        GerenciadorLivraria.desserializarFunc(DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\funcionarios.bin");
        GerenciadorLivraria.desserializarVendas(DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\vendas.bin");
        GerenciadorLivraria.desserializarLivros(DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\livros.bin");

        File arquivoEstoque = new File(DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\livros.bin");

        if (arquivoEstoque.exists() && arquivoEstoque.isFile()) {
            GerenciadorLivraria.desserializarLivros(DiretorioArquivos.getDir() + "\\src\\projeto\\sistema\\arquivos\\livros.bin");
        }
    }

}