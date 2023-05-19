package projCin.ComidaCompras;

import projCin.Salas.MovieTime;
import projCin.Salas.Room;

public class Ticket{
    
    private String user;
    private int[] CPF;
    private Room room;
    private MovieTime movietime;
    private String movie;
    private double valor;
    private String chair;

    public Ticket() {
        
    }

    public Ticket(String user, int[] CPF, Room room, MovieTime movietime, String movie, double valor, String chair) { //fazendo uma sobrecarga de construtures para ter uma com os parametros e outra sem nenhum parametro
        this.user = user;
        this.CPF = CPF;
        this.room = room;
        this.movietime = movietime;
        this.movie = movie;
        this.valor = valor;
        this.chair = chair;
    }



    public String getUser() { 
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int[] getCPF() {
        return CPF;
    }

    public void setCPF(int[] CPF) {
        this.CPF = CPF;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public MovieTime getMovietime() {
        return movietime;
    }

    public void setMovietime(MovieTime movietime) {
        this.movietime = movietime;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getChair() {
        return chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    

}