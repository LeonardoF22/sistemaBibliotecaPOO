package model;

public class Biblioteca {
    private Livro[] livrosCadastrados = new Livro[100];
    private Usuario[] usuariosCadastrados = new Usuario[100];
    private int quantidadeDeLivros;
    private int quantidadeDeUsuarios;

    public Biblioteca(){
        quantidadeDeLivros = 0;
        quantidadeDeUsuarios = 0;
    }
    public void cadastrarLivro(Livro livro){
        livrosCadastrados[quantidadeDeLivros] = livro;
        quantidadeDeLivros++;
    }

    public void cadastrarUsuario(Usuario usuario){
        usuariosCadastrados[quantidadeDeUsuarios] = usuario;
        quantidadeDeUsuarios++;
    }

    public boolean haLivrosCadastrados(){
        if(livrosCadastrados[0] == null){
            System.out.println("Nenhum livro cadastrado no sistema!");
            return false;
        }
        return true;
    }

    public void exibirLivro(int idLivro){
        if(!haLivrosCadastrados()){
            return;
        }
        livrosCadastrados[idLivro].exibirLivro();
    }

    public void listarLivros(){
        if(!haLivrosCadastrados()){
            return;
        }
        for (int i = 0; i < quantidadeDeLivros; i++) {
            if(livrosCadastrados[i] == null){
                return;
            }
            System.out.println("ID: " + i);
            livrosCadastrados[i].exibirLivro();
        }
    }

    public void listarLivrosDisponiveis(){
        if(!haLivrosCadastrados()){
            return;
        }
        System.out.println("Livros disponiveis");
        for (int i = 0; i < quantidadeDeLivros; i++) {
            if(livrosCadastrados[i].isAtivo() && !livrosCadastrados[i].isEmprestado()){
                System.out.println("ID: " + i);
                livrosCadastrados[i].exibirLivro();
            }
        }
    }

    public void listarLivrosEmprestados(){
        if(!haLivrosCadastrados()){
            return;
        }
        System.out.println("Livros emprestados");
        for (int i = 0; i < quantidadeDeLivros; i++) {
            if(livrosCadastrados[i].isAtivo() && livrosCadastrados[i].isEmprestado()){
                System.out.println("ID: " + i);
                livrosCadastrados[i].exibirLivro();
            }
        }
    }

    public void listarLivrosDesativados(){
        if(!haLivrosCadastrados()){
            return;
        }
        System.out.println("Livros desativados");
        for (int i = 0; i < quantidadeDeLivros; i++) {
            if(!livrosCadastrados[i].isAtivo()){
                System.out.println("ID: " + i);
                livrosCadastrados[i].exibirLivro();
            }
        }
    }

    public boolean haUsuariosCadastrados(){
        if(usuariosCadastrados[0] == null) {
            System.out.println("Nenhum usuario cadastrado no sistema!");
            return false;
        }
        return true;
    }

    public void exibirUsuario(int idUsuario){
        if(!haUsuariosCadastrados()){
            return;
        }
        usuariosCadastrados[idUsuario].exibirInformacoes();
    }

    public void listarUsuarios(){
        if(!haUsuariosCadastrados()){
            return;
        }
        for (int i = 0; i < quantidadeDeUsuarios; i++) {
            if(usuariosCadastrados[i] == null){
                return;
            }
            System.out.println("ID: " + i);
            usuariosCadastrados[i].exibirInformacoes();
        }
    }

    public void listarUsuariosDesativados() {
        if(!haUsuariosCadastrados()){
            return;
        }
        for (int i = 0; i < quantidadeDeUsuarios; i++) {
            if(!usuariosCadastrados[i].isAtivo()){
                System.out.println("ID: " + i);
                usuariosCadastrados[i].exibirInformacoes();
            }
        }
    }

    public void listarUsuariosAtivados(){
        if(!haUsuariosCadastrados()){
            return;
        }
        for (int i = 0; i < quantidadeDeUsuarios; i++) {
            if(usuariosCadastrados[i].isAtivo()){
                System.out.println("ID: " + i);
                usuariosCadastrados[i].exibirInformacoes();
            }
        }
    }

    public void emprestarLivro(int idUsuario, int idLivro){
        usuariosCadastrados[idUsuario].emprestarLivro(livrosCadastrados[idLivro]);
    }

    public void devolverLivro(int idUsuario, int idLivro){
        usuariosCadastrados[idUsuario].devolverLivro(livrosCadastrados[idLivro]);
    }

    public void ativarLivro(int idLivro){
        livrosCadastrados[idLivro].ativarLivro();
    }

    public void desativarLivro(int idLivro){
        livrosCadastrados[idLivro].desativarLivro();
    }

    public void ativarUsuario(int idUsuario){
        usuariosCadastrados[idUsuario].ativarUsuario();
    }

    public void desativarUsuario(int idUsuario){
        usuariosCadastrados[idUsuario].desativarUsuario();
    }


    public int getQuantidadeDeLivros() {
        return quantidadeDeLivros;
    }

    public int getQuantidadeDeUsuarios() {
        return quantidadeDeUsuarios;
    }
}
