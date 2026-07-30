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

    public void listarLivros(){
        if(livrosCadastrados[0] == null){
            System.out.println("Nenhum livro cadastrado no sistema!");
            return;
        }
        for(Livro livro : livrosCadastrados){
            if(livro == null){
                return;
            }
            livro.exibirLivro();
        }
    }

    public void listarUsuarios(){
        if(usuariosCadastrados[0] == null){
            System.out.println("Nenhum usuario cadastrado no sistema!");
            return;
        }
        for(Usuario usuario : usuariosCadastrados){
            if(usuario == null){
                return;
            }
            usuario.exibirInformacoes();
        }
    }
}
