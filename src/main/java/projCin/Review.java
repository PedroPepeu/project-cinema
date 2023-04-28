package main.java.projCin;

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

    public void atribuirNota(double notaDada, Movie filme) {

        

        filme.setMedia(notaDada / filme.getQuantCrit());
        
        //while(filme.review)
        for (int i = filme.getQuantCrit(); i <= 0; i--) {
            filme.getReview();
            filme.setReview(null);
        }



    }

    public void atribuirCritica(String critica, Movie filme) {
        Review review = new Review(filme, critica);

        filme.setPosiçãoReview(filme.getPosiçãoReview() - 1);
        
        filme.getReview()[filme.getPosiçãoReview()] = review;
    }

}