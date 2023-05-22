package projCin.Exception;

import projCin.Salas.Movie;

public class VendasException extends Exception {
    private String erroUm;

    private String erroDois;
    private int linha;
    private int coluna;

    private String erroTres;
    private Movie movie;

    public VendasException(String erroUm) {
        //como vai ser feito o erro de um bilhete que já passou o horário do filme??
    }

    public VendasException(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.erroDois = "a poltrona da linha " +linha+ " e coluna " +coluna+ " já foi selecionada!";
        //throw new VendasException desse erro está sendo executado e funcionando na classe: MovieTime | linha 168
    }

    public VendasException(Movie movie) {
        this.movie = movie;
        this.erroTres = "O filme "+movie+ "não esta mais em cartaz!";
        //throw new VendasException desse erro está sendo executado e funcionando na classe: room | linha 83
    }

    public String getErroUm() {
        return erroUm;
    }

    public String getErroDois() {
        return erroDois;
    }

    public String getErroTres() {
        return erroTres;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }


}
