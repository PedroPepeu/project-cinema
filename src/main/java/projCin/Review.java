package projCin;

public class Review {
    private String nome;
    private String origem;
    private String ComentarioCritico;
    private double notas;


    public Review(String nome, String origem, String comentarioCritico) {
        this.nome = nome;
        this.origem = origem;
        ComentarioCritico = comentarioCritico;
    }

    public Review() {
    
    }

    public Review(Movie filme, String critica) {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getComentarioCritico() {
        return ComentarioCritico;
    }

    public void setComentarioCritico(String comentarioCritico) {
        ComentarioCritico = comentarioCritico;
    }

    public double getNotas() {
        return notas;
    }

    public void setNotas(double notas) {
        this.notas = notas;
    }
    
    public void atribuirNota(double notaDada, Movie filme) {
        
        filme.setQuantidadeDeCritidos(filme.getQuantidadeDeCritidos() + 1);

        setNotas(getNotas() + notaDada);
        
        filme.setMedia(notas / filme.getQuantidadeDeCritidos());

      
    }

    public void atribuirCritica(String critica, Movie filme) {
        Review review = new Review(filme, critica);

        filme.setPosiçãoReview(filme.getPosiçãoReview() - 1);
        
        filme.getReview()[filme.getPosiçãoReview()] = review;
    }
    
}
