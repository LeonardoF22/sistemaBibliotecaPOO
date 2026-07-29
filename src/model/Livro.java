package model;

public class Livro {
    private String titulo;
    private String autor;
    private String[] generos;
    private int anoPublicacao;
    private int paginas;
    private boolean emprestado;
    private boolean ativo;

    public Livro(String titulo, String autor, String[] generos, int anoPublicacao, int paginas){
        if(titulo.isEmpty() || autor.isEmpty() || generos.length == 0 || anoPublicacao <= 0 || paginas <= 0){
            System.out.println("Livro não cadastrado devido a dados incorretos!!!");
            ativo = false;
            return;
        }

        this.titulo = titulo;
        this.autor = autor;
        this.generos = generos;
        this.anoPublicacao = anoPublicacao;
        this.paginas = paginas;
        emprestado = false;
        ativo = true;
    }

    public void exibirLivro(){
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Generos: ");
        for(String genero : generos){
            System.out.print(genero);
        }
        System.out.println("Ano de publicação: " + anoPublicacao);
        System.out.println("Paginas: " + paginas);
        System.out.println("Emprestado: " + emprestado);
        System.out.println("Ativo: " + ativo);
    }

    public void desativarLivro(){
        if(!ativo){
            System.out.println("O livro já está desativado!!!");
            return;
        }
        if(emprestado){
            System.out.println("O livro está emprestado!!!");
            return;
        }
        ativo = false;
        System.out.println("Livro desativado com sucesso.");
    }

    public void ativarLivro(){
        if(ativo){
            System.out.println("O livro já está ativado!!!");
            return;
        }
        ativo = true;
        System.out.println("Livro ativado com sucesso.");
    }

    public boolean emprestar(){
        if(!ativo){
            System.out.println("Livro indisponivel!!!");
            return false;
        }
        if(emprestado){
            System.out.println("Esse livro já está emprestado!!!");
            return false;
        }
        emprestado = true;
        System.out.println("Livro emprestado com sucesso.");
        return true;
    }

    public void devolver(){
        if(!ativo){
            System.out.println("Livro indisponivel!!!");
            return;
        }
        if(!emprestado){
            System.out.println("O livro não foi emprestado!!!");
            return;
        }
        emprestado = false;
        System.out.println("Livro devolvido com sucesso!");
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String[] getGeneros() {
        return generos;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getPaginas() {
        return paginas;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public boolean isAtivo() {
        return ativo;
    }
}

