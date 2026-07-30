import model.Biblioteca;
import model.Livro;
import model.Usuario;

import java.util.Scanner;

public class main {
    public static void exibirMenu(){
        System.out.println("Menu de opções");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Cadastrar usuario");
        System.out.println("3 - Listar livros");
        System.out.println("4 - Listar usuarios");
        System.out.println("5 - Emprestar livro");
        System.out.println("6 - Devolver livro");
        System.out.println("7 - Livros disponiveis");
        System.out.println("8 - Livros emprestados");
        System.out.println("9 - Livros desativados");
        System.out.println("10 - Ativar livro");
        System.out.println("11 - Desativar Livro");
        System.out.println("12 - Ativar usuario");
        System.out.println("13 - Desativar usuario");
        System.out.println("0 - Sair");
        System.out.println("Opção desejada:");
    }

    public static Livro cadastrarLivro(Scanner sc){
        System.out.println("Titulo: ");
        String titulo = sc.nextLine();
        while (titulo.isEmpty()){
            System.out.println("Titulo inválido! Digite novamente: ");
            titulo = sc.nextLine();
        }
        System.out.println("Autor: ");
        String autor = sc.nextLine();
        while (autor.isEmpty()){
            System.out.println("Autor inválido! Digite novamente: ");
            autor = sc.nextLine();
        }
        System.out.println("Quantos generos deseja cadastrar: ");
        int qtdeGeneros = sc.nextInt();
        while (qtdeGeneros <= 0){
            System.out.println("A quantidade de generos deve ser positiva! Digite novamente: ");
            qtdeGeneros = sc.nextInt();
        }
        sc.nextLine();
        String[] generos = new String[qtdeGeneros];
        for (int i = 0; i < qtdeGeneros; i++) {
            System.out.println("Digite o genero: ");
            String genero = sc.nextLine();
            while (genero.isEmpty()){
                System.out.println("Genero inválido! Digite novamente: ");
                genero = sc.nextLine();
            }
            generos[i] = genero;
        }
        System.out.println("Ano de publicação: ");
        int anoPublicacao = sc.nextInt();
        while (anoPublicacao <= 0){
            System.out.println("Ano de publicacao inválido! Digite novamente: ");
            anoPublicacao = sc.nextInt();
        }
        System.out.println("Quantidade de paginas: ");
        int quantidadePaginas = sc.nextInt();
        while (quantidadePaginas <= 0){
            System.out.println("Quantidade de paginas inválida! Digite novamente: ");
            quantidadePaginas = sc.nextInt();
        }

        Livro livro = new Livro(titulo, autor, generos, anoPublicacao, quantidadePaginas);
        return livro;
    }

    public static Usuario cadastrarUsuario(Scanner sc){
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        while (nome.isEmpty()){
            System.out.println("Nome inválido digite novamente: ");
            nome = sc.nextLine();
        }
        System.out.println("Idade: ");
        int idade = sc.nextInt();
        while (idade < 12){
            System.out.println("Idade inválida! Digite novamente: ");
            idade = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        while (email.isEmpty()){
            System.out.println("Email inválido! Digite novamente: ");
            email = sc.nextLine();
        }

        Usuario usuario = new Usuario(nome, idade, email);
        return usuario;
    }

    public static void emprestarLivro(Biblioteca biblioteca, Scanner sc){
        if(!biblioteca.haUsuariosCadastrados()){
            return;
        }
        if(biblioteca.getQuantidadeDeLivros() == 0){
            System.out.println("Nenhum livro cadastrado!");
            return;
        }
        biblioteca.listarUsuarios();
        System.out.println("Qual usuario vai emprestrar um livro: ");
        int idUsuario = sc.nextInt();
        while (idUsuario < 0 || idUsuario >= biblioteca.getQuantidadeDeUsuarios()){
            System.out.println("Usuario invalido! Digite novamente: ");
            idUsuario = sc.nextInt();
        }
        biblioteca.listarLivros();
        System.out.println("Qual livro o usuario deseja: ");
        int idLivro = sc.nextInt();
        while (idLivro < 0 || idLivro >= biblioteca.getQuantidadeDeLivros()){
            System.out.println("Livro invalido! Digite novamente: ");
            idLivro = sc.nextInt();
        }

        biblioteca.emprestarLivro(idUsuario, idLivro);
    }

    public static void devolverLivro(Biblioteca biblioteca, Scanner sc){
        if(!biblioteca.haUsuariosCadastrados()){
            return;
        }
        biblioteca.listarUsuarios();
        System.out.println("Qual usuario vai devolver um livro: ");
        int idUsuario = sc.nextInt();
        while (idUsuario < 0 || idUsuario >= biblioteca.getQuantidadeDeUsuarios()){
            System.out.println("Usuario invalido! Digite novamente: ");
            idUsuario = sc.nextInt();
        }

        biblioteca.exibirUsuario(idUsuario);
        System.out.println("Qual livro o usuario vai devolver: ");
        int idLivro = sc.nextInt();
        biblioteca.devolverLivro(idUsuario,idLivro);

    }

    public static void ativarLivro(Biblioteca biblioteca, Scanner sc){
        if(!biblioteca.haLivrosCadastrados()){
            return;
        }
        biblioteca.listarLivrosDesativados();
        System.out.println("Qual livro deseja ativar: ");
        int idLivro = sc.nextInt();
        while(idLivro < 0 || idLivro >= biblioteca.getQuantidadeDeLivros()){
            System.out.println("Livro invalido! Digite novamente: ");
            idLivro = sc.nextInt();
        }
        biblioteca.ativarLivro(idLivro);
    }

    public static void desativarLivro(Biblioteca biblioteca, Scanner sc){
        if(!biblioteca.haLivrosCadastrados()){
            return;
        }
        biblioteca.listarLivrosDisponiveis();
        System.out.println("Qual livro deseja desativar: ");
        int idLivro = sc.nextInt();
        while(idLivro < 0 || idLivro >= biblioteca.getQuantidadeDeLivros()){
            System.out.println("Livro invalido! Digite novamente: ");
            idLivro = sc.nextInt();
        }
        biblioteca.desativarLivro(idLivro);
    }

    public static void ativarUsuario(Biblioteca biblioteca, Scanner sc){
        if(!biblioteca.haUsuariosCadastrados()){
            return;
        }
        biblioteca.listarUsuariosDesativados();
        System.out.println("Qual usuario deseja ativar: ");
        int idUsuario = sc.nextInt();
        while (idUsuario < 0 || idUsuario >= biblioteca.getQuantidadeDeUsuarios()){
            System.out.println("Usuario invalido! Digite novamente: ");
            idUsuario = sc.nextInt();
        }
        biblioteca.ativarUsuario(idUsuario);
    }

    public static void desativarUsuario(Biblioteca biblioteca, Scanner sc){
        if(!biblioteca.haUsuariosCadastrados()){
            return;
        }
        biblioteca.listarUsuariosAtivados();
        System.out.println("Qual usuario deseja desativar: ");
        int idUsuario = sc.nextInt();
        while(idUsuario < 0 || idUsuario >= biblioteca.getQuantidadeDeUsuarios()){
            System.out.println("Usuario invalido! Digite novamente: ");
            idUsuario = sc.nextInt();
        }
        biblioteca.desativarUsuario(idUsuario);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int op;
        do{
            exibirMenu();
            op = sc.nextInt();
            sc.nextLine();
            switch (op){
                case 0:
                    System.out.println("Encerrando o sistema");
                    break;
                case 1:
                    biblioteca.cadastrarLivro(cadastrarLivro(sc));
                    break;
                case 2:
                    biblioteca.cadastrarUsuario(cadastrarUsuario(sc));
                    break;
                case 3:
                    biblioteca.listarLivros();
                    break;
                case 4:
                    biblioteca.listarUsuarios();
                    break;
                case 5:
                    emprestarLivro(biblioteca, sc);
                    break;
                case 6:
                    devolverLivro(biblioteca, sc);
                    break;
                case 7:
                    biblioteca.listarLivrosDisponiveis();
                    break;
                case 8:
                    biblioteca.listarLivrosEmprestados();
                    break;
                case 9:
                    biblioteca.listarLivrosDesativados();
                    break;
                case 10:
                    ativarLivro(biblioteca, sc);
                    break;
                case 11:
                    desativarLivro(biblioteca, sc);
                    break;
                case 12:
                    ativarUsuario(biblioteca, sc);
                    break;
                case 13:
                    desativarUsuario(biblioteca, sc);
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (op != 0);
    }
}
