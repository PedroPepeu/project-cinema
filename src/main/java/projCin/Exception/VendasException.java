package projCin.Exception;

import java.time.LocalTime;
import projCin.Salas.Movie;

public class VendasException extends Exception {
    private String erroUm;
    private LocalTime horarioDoFilmeMin;
    private LocalTime horarioDoFilmeMax;

    private String erroDois;
    private int linha;
    private int coluna;

    private String erroTres;
    private Movie movie;

    public VendasException(LocalTime horarioDoFilmeMin, LocalTime horarioDoFilmeMax) {
        this.horarioDoFilmeMin = horarioDoFilmeMin;
        this.horarioDoFilmeMax = horarioDoFilmeMax;
        this.erroUm = "Esse filme começa de "+horarioDoFilmeMin+" e termina de "+horarioDoFilmeMax+" tente novamente mais tarde.";
        //throw new VendasException desse erro está sendo executado e funcionando na classe: Room | linha 118
    }

    public VendasException(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.erroDois = "a poltrona da linha " +linha+ " e coluna " +coluna+ " já foi selecionada!";
        //throw new VendasException desse erro está sendo executado e funcionando na classe: MovieTime | linha 171
    }

    public VendasException(Movie movie) {
        this.movie = movie;
        this.erroTres = "O filme "+movie.getName()+ " não esta mais em cartaz!";
        //throw new VendasException desse erro está sendo executado e funcionando na classe: room | linha 114
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

    public LocalTime getHorarioDoFilmeMin() {
        return horarioDoFilmeMin;
    }

    public LocalTime getHorarioDoFilmeMax() {
        return horarioDoFilmeMax;
    }

    
}
