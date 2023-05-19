package projCin.Salas;

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

        filme.setQuantCrit(filme.getQuantCrit() + 1);

        setNotas(getNotas() + notaDada);
        
        filme.setMedia(notas / filme.getQuantCrit());

    }

    private final String  outOfBounds = "Limite de criticas atingidos";
    public void atribuirCritica(String critica, Movie filme) {
        
        try {
            Review review = new Review(filme, critica);
        
            Review []vet = filme.getReview();
            
            vet[filme.getPosiçãoReview() - 1] = review;
    
            filme.setReview(vet);
    
            filme.setPosiçãoReview(filme.getPosiçãoReview() - 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(outOfBounds);
        }
        
        
    }


}