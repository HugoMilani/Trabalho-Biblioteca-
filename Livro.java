public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int numPaginas;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumPaginas() { 
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) { 
        this.numPaginas = numPaginas;
    }
}
