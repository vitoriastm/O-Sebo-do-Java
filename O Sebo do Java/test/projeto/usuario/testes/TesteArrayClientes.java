package projeto.usuario.testes;

import projeto.usuario.Cliente;
import projeto.usuario.repo.ArrayClientes;

import projeto.usuario.repo.excecao.*;

public class TesteArrayClientes {
    
    public static void main(String[] args) {
        /* 
        // Repositorio de cliente
        ArrayClientes clienteRepo = new ArrayClientes(100);
        // Cliente fictício (válido)
        String cpf1 = "68912214209";
        Cliente novoCliente1 = new Cliente(cpf1);
        // Cliente fictício (cpf inválido)
        String cpf2 = "111111111";
        Cliente novoCliente2 = new Cliente(cpf2);
        // Cliente fictício (mesmo cpf)
        Cliente novoCliente3 = new Cliente(cpf1);
        // Cliente fictício (não cadastrado no sistema)
        Cliente novoCliente4 = new Cliente(cpf2);
        TesteArrayClientes.cadastraUsuarioValido(clienteRepo, novoCliente1);
        TesteArrayClientes.cadastraUsuarioInvalido1(clienteRepo, novoCliente2);
        TesteArrayClientes.cadastraUsuarioInvalido2(clienteRepo, novoCliente3);
        TesteArrayClientes.removeUsuarioInexistente(clienteRepo, novoCliente4);
        TesteArrayClientes.removeUsuarioValido(clienteRepo, novoCliente1); */
    }
    
    public static void cadastraUsuarioValido(ArrayClientes repositorio, Cliente clienteTeste) {
        try {
            repositorio.cadastrarUsuario(clienteTeste);
        }
        catch (ICException | UCException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
        }
        finally {
            if (repositorio.existeUsuario(clienteTeste.getCPF())) {
                System.out.println("Teste 1 passou");
            }
            else {
                System.out.println("Teste 1 não passou");
            }
        }
    }
    
    public static void cadastraUsuarioInvalido1(ArrayClientes repositorio, Cliente clienteTeste) {
        try {
            repositorio.cadastrarUsuario(clienteTeste);
        }
        catch (ICException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
            System.out.println("Teste 2 passou");
        }
        catch (UCException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
        }
        finally {
        }
    }
    
    public static void cadastraUsuarioInvalido2(ArrayClientes repositorio, Cliente clienteTeste) {
        try {
            repositorio.cadastrarUsuario(clienteTeste);
        }
        catch (UCException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
            System.out.println("Teste 3 passou");
        }
        catch (ICException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
        }
        finally {
        }
    }
    
    public static void removeUsuarioInexistente(ArrayClientes repositorio, Cliente clienteTeste) {
        try {
            repositorio.removerUsuario(clienteTeste.getCPF());
        }
        catch (IUException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
            System.out.println("Teste 4 passou");
        }
        finally {
        }
    }
    
    public static void removeUsuarioValido(ArrayClientes repositorio, Cliente clienteTeste) {
        int tamanhoInicial = repositorio.getTamanho();
        try {
            repositorio.removerUsuario(clienteTeste.getCPF());
        }
        catch (IUException e) {
            System.err.println("Exceção capturada: " + e.getMessage());
        }
        finally {
            boolean teste1 = !repositorio.existeUsuario(clienteTeste.getCPF());
            boolean teste2 = repositorio.buscarUsuario(clienteTeste.getCPF()) == null;
            boolean teste3 = repositorio.getTamanho() == (tamanhoInicial - 1);
            if (teste1 && teste2 && teste3) {
                System.out.println("Teste 5 passou");
            }
            else {
                System.out.println("Teste 5 não passou");
            }
        }
    }
    
}