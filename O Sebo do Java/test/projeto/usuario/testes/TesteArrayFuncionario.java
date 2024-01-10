package projeto.usuario.testes;

import projeto.usuario.Funcionario;
import projeto.usuario.repo.ArrayFuncionario;

import projeto.usuario.repo.excecao.*;

public class TesteArrayFuncionario {
    
    public static void main(String[] args) {
        /*
        // Repositorio de funcionario
        ArrayFuncionario funcionarioRepo = new ArrayFuncionario(100);
        // Funcionario fictício (válido)
        String cpf1 = "68912214209";
        String senha1 = "111111";
        Funcionario novoFuncionario1 = new Funcionario(cpf1, senha1);
        // Funcionario fictício (cpf inválido)
        String cpf2 = "111111111";
        String senha2 = "111111";
        Funcionario novoFuncionario2 = new Funcionario (cpf2, senha2);
        // Funcionario fictício (mesmo cpf)
        String senha3 = "111111";
        Funcionario novoFuncionario3 = new Funcionario (cpf1, senha3);
        // Funcionario fictício (senha inválida)
        String cpf4 = "25460333016";
        String senha4 = "11111A";
        Funcionario novoFuncionario4 = new Funcionario (cpf4, senha4);
        
        TesteArrayFuncionario.cadastraUsuarioValido(funcionarioRepo, novoFuncionario1);
        TesteArrayFuncionario.cadastraUsuarioInvalido1(funcionarioRepo, novoFuncionario2);
        TesteArrayFuncionario.cadastraUsuarioInvalido2(funcionarioRepo, novoFuncionario3);
        TesteArrayFuncionario.cadastraUsuarioInvalido3(funcionarioRepo, novoFuncionario4);   
        TesteArrayFuncionario.trocaSenhaInvalida(funcionarioRepo, novoFuncionario4);
        TesteArrayFuncionario.trocaSenhaUsuarioInexistente(funcionarioRepo, cpf2);
        */
    }
    
    public static void cadastraUsuarioValido(ArrayFuncionario repositorio, Funcionario funcionarioTeste) {
        try {
            repositorio.cadastrarUsuario(funcionarioTeste);
        }
        catch (ICException | PException | UCException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
        }
        finally {
            if (repositorio.existeUsuario(funcionarioTeste.getCPF())) {
                System.out.println("Teste 1 passou");
            }
            else {
                System.out.println("Teste 1 não passou");
            }
        }
    }
    
    public static void cadastraUsuarioInvalido1(ArrayFuncionario repositorio, Funcionario funcionarioTeste) {
        try {
            repositorio.cadastrarUsuario(funcionarioTeste);
        }
        catch (ICException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
            System.out.println("Teste 2 passou");
        }
        catch (PException | UCException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
        }
        finally {
        }
    }
    
    public static void cadastraUsuarioInvalido2(ArrayFuncionario repositorio, Funcionario funcionarioTeste) {
        try {
            repositorio.cadastrarUsuario(funcionarioTeste);
        }
        catch (UCException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
            System.out.println("Teste 3 passou");
        }
        catch (ICException | PException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
        }
        finally {
        }
    }
    
    public static void cadastraUsuarioInvalido3(ArrayFuncionario repositorio, Funcionario funcionarioTeste) {
        try {
            repositorio.cadastrarUsuario(funcionarioTeste);
        }
        catch (PException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
            System.out.println("Teste 4 passou");
        }
        catch (ICException |  UCException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
        }
        finally {
        }
    }
    
    public static void trocaSenhaInvalida(ArrayFuncionario repositorio, Funcionario funcionario) {
        try {
            repositorio.setSenha("AAAAA7", funcionario.getCPF());
        }
        catch (PException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
            System.out.println("Teste 5 passou");
        }
        catch (IUException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
        finally {
        }
    }
    
    public static void trocaSenhaUsuarioInexistente(ArrayFuncionario repositorio, String cpf) {
        try {
            repositorio.setSenha("111111", cpf);
        }
        catch (IUException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
            System.out.println("Teste 6 passou");
        }
        catch (PException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
        finally {
        }
    }
}