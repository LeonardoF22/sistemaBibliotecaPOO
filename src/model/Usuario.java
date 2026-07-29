package model;

public class Usuario {
    private String nome;
    private int idade;
    private String email;
    private int quantidadeEmprestimos;
    private boolean ativo;
    private Livro[] livrosEmprestados = new Livro[3];

    public Usuario(String nome, int idade, String email){
        if(nome.isEmpty() || idade < 12 || email.isEmpty()){
            System.out.println("Cadastro incompleto devido a falta de dados ou idade inválida!!!");
            ativo = false;
            return;
        }
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        quantidadeEmprestimos = 0;
        ativo = true;
    }

    public void emprestarLivro(Livro livro){
        if(!ativo){
            System.out.println("Usuario desativado!!!");
            return;
        }
        if(quantidadeEmprestimos >= 3){
            System.out.println("Quantidade maxima de livros emprestados!!!");
            return;
        }
        if(livro.emprestar()){
            livrosEmprestados[quantidadeEmprestimos] = livro;
            quantidadeEmprestimos++;
        }
    }

    public void ativarUsuario(){
        if(ativo){
            System.out.println("O usuario ja está ativo!!!");
            return;
        }
        ativo = true;
        System.out.println("Usuario ativado com sucesso.");
    }

    public void desativarUsuario(){
        if(!ativo){
            System.out.println("O usuario ja está desativado!!!");
            return;
        }
        if(quantidadeEmprestimos > 0){
            System.out.println("O usuario ainda possui livros em emprestimo!!!");
            return;
        }
        ativo = false;
        System.out.println("Usuario desativado com sucesso.");
    }

    public void exibirInformacoes(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Email: " + email);
        System.out.println("Quantidade de emprestimos: " + quantidadeEmprestimos);
        System.out.println("Livros emprestados: ");
        for (int i = 0; i < quantidadeEmprestimos; i++) {
            System.out.println("    Titulo: " + livrosEmprestados[i].getTitulo());
        }
        System.out.println("Ativo: " + ativo);
    }
}
