package projeto.usuario.testes;

import projeto.usuario.Cliente;

public class TesteCliente {
    
    public static void main(String[] args) {
        // TesteCliente.compraLivro();
    }
    
    public static void compraLivro() {
        Cliente novoCliente = new Cliente("111111111");
        //Livro livro1 = new Livro("titulo1");
        //Livro livro2 = new Livro("titulo2");
        //Livro livro3 = new Livro("titulo3");
        // O CPF pode ser inválido pois o teste só vai ser executado ao cadastrá-lo no sistema
        // Talvez se torne interessante colocar o teste na classe cliente?
        //novoCliente.comprarLivro(livro1);
        //novoCliente.comprarLivro(livro2);
        //novoCliente.comprarLivro(livro3);
        System.out.println(novoCliente.getQntdLivros());
        for(int i = 0; i < novoCliente.getQntdLivros(); i++) {
            System.out.println((novoCliente.listarLivrosComprados()[i]).getTitulo());
        }
    }
}