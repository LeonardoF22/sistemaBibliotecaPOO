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
        System.out.println("11 - Desatovar Livro");
        System.out.println("12 - Ativar usuario");
        System.out.println("13 - Desativar usuario");
        System.out.println("0 - Sair");
        System.out.println("Opção desejada:");
    }

    public static Livro cadastrarLivro(Scanner sc){
        System.out.println("Titulo: ");
        String titulo = sc.nextLine();
        while (titulo.isEmpty()){
            System.out.println("Titulo invalido! Digite novamente: ");
            titulo = sc.nextLine();
        }
        System.out.println("Autor: ");
        String autor = sc.nextLine();
        while (autor.isEmpty()){
            System.out.println("Autor invalido! Digite novamente: ");
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
                System.out.println("Genero invalido! Digite novamente: ");
                genero = sc.nextLine();
            }
            generos[i] = genero;
        }
        System.out.println("Ano de publicação: ");
        int anoPublicacao = sc.nextInt();
        while (anoPublicacao <= 0){
            System.out.println("Ano de publicacao invalido! Digite novamente: ");
            anoPublicacao = sc.nextInt();
        }
        System.out.println("Quantidade de paginas: ");
        int quantidadePaginas = sc.nextInt();
        while (quantidadePaginas <= 0){
            System.out.println("Quantidade de paginas invalida! Digite novamente: ");
            quantidadePaginas = sc.nextInt();
        }

        Livro livro = new Livro(titulo, autor, generos, anoPublicacao, quantidadePaginas);

        return livro;
    }

    public static Usuario cadastrarUsuario(Scanner sc){
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        while (nome.isEmpty()){
            System.out.println("Nome invalido digite novamente: ");
            nome = sc.nextLine();
        }
        System.out.println("Idade: ");
        int idade = sc.nextInt();
        while (idade < 12){
            System.out.println("Idade invalida! Digite novamente: ");
            idade = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        while (email.isEmpty()){
            System.out.println("Email invalido! Digite novamente: ");
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
        if(biblioteca.getQuantidadeDeLivros() == 0){
            System.out.println("Nenhum livro cadastrado!");
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
                    System.out.println("Voce escolheu cadastrar um novo livro");
                    biblioteca.cadastrarLivro(cadastrarLivro(sc));
                    break;
                case 2:
                    System.out.println("Voce escolheu cadastrar um novo usuario");
                    biblioteca.cadastrarUsuario(cadastrarUsuario(sc));
                    break;
                case 3:
                    System.out.println("Voce escolheu exibir todos os livros");
                    biblioteca.listarLivros();
                    break;
                case 4:
                    System.out.println("Voce escolheu exibir todos os usuarios");
                    biblioteca.listarUsuarios();
                    break;
                case 5:
                    System.out.println("Voce escolheu emprestar um livro");
                    emprestarLivro(biblioteca, sc);
                    break;
                case 6:
                    System.out.println("Voce escolheu devolver um livro");
                    devolverLivro(biblioteca, sc);
                    break;
                case 7:
                    System.out.println("Voce escolheu exibir todos os livros disponiveis");
                    biblioteca.listarLivrosDisponiveis();
                    break;
                case 8:
                    System.out.println("Voce escolheu listar todos os livros emprestados");
                    biblioteca.listarLivrosEmprestados();
                    break;
                case 9:
                    System.out.println("Voce escolheu listar todos os livros desativados");
                    biblioteca.listarLivrosDesativados();
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (op != 0);
    }
}
