package projCin.Salas;

import java.util.Scanner;
import projCin.ComidaCompras.Buy;
import projCin.Exception.VendasException;
import java.time.LocalTime;


/*A classe de sala irá compor uma lista de sessões, a lista têm um tamanho fixo com
uma grade de horário, caso não exista uma sessão em algum horário, aquela sessão
será registrada como nula e não irá aparecer para o usuário;*/

//Para comprar os filmes    
public class Room {

    
    private MovieTime[] movietime;//Chairs at room
    //private Room [][] catalog;
    private Movie [] movie;
    private boolean disponibilidadeDoFilme;

    MovieTime horaDoFilme = new MovieTime();

    public Room() { 
        this.movie = new Movie[7]; 
    }

    public MovieTime[] getMovietime() {
        return movietime;
    }

    public void setMovietime(MovieTime[] movietime) {
        this.movietime = movietime;
    }

    public Movie[] getMovie() {
        return movie;
    }

    public void setMovie(Movie[] movie) {
        this.movie = movie;
    }

    public MovieTime getHoraDoFilme() {
        return horaDoFilme;
    }

    public void setHoraDoFilme(MovieTime horaDoFilme) {
        this.horaDoFilme = horaDoFilme;
    }

    public boolean isDisponibilidadeDoFilme() {
        return disponibilidadeDoFilme;
    }

    public void setDisponibilidadeDoFilme(boolean disponibilidadeDoFilme) {
        this.disponibilidadeDoFilme = disponibilidadeDoFilme;
    }

    public void sessions(){
        Buy buy = new Buy();
        Scanner s = new Scanner(System.in);
        Movie selectMovie = new Movie();
        
        movie[0] = new Movie(8,10,"Steven Universe", 20);
        movie[1] = new Movie(10, 12,"Os 300 de Esparta", 20);
        movie[2] = new Movie(12, 14, "Kimetsu no yaiba", 20);
        movie[3] = new Movie(14, 16, "Os Incriveis", 20);
        movie[4] = new Movie(16, 18, "Ta Dando Onda 2", 20);
        movie[5] = new Movie(18, 20, "A voz do silêncio", 20);
        movie[6] = new Movie(20, 22, "A Era do Gelo", 20);

        System.out.println("Catalogo do dia:\n");
        System.out.println("  Horário    |     Filme     |    Valor");
        for (int i = 0; i < 7; i++) {
            System.out.print(movie[i].toString());
    
            System.out.println("\t");
        }

        System.out.println("\nQual o numero do filme deseja comprar o ingresso(de 1 a 7) \n(Para voltar ao menu digite: 0)");
        int chose = s.nextInt();

        LocalTime horaAtual = LocalTime.now();
        LocalTime horarioDoFilmeMin = LocalTime.of(movie[chose - 1].getTempMin(), 00);
        LocalTime horarioDoFilmeMax = LocalTime.of(movie[chose - 1].getTempMax(), 00);
    
        if (horaAtual.isBefore(horarioDoFilmeMin) || horaAtual.isAfter(horarioDoFilmeMax)) {
            System.out.println("Esse filme começa de "+horarioDoFilmeMin+" e termina de "+horarioDoFilmeMax+" tente novamente mais tarde.");
            return; //FAZER A EXCEPTION
        }

        try {

        if(chose == 0){
            buy.menuGeral();
        }
        if(chose < 0 || chose > 7){
            System.out.println("Escolha não permitida, tente novamente");
        }else{
            //Se o filme não estiver disponivel, settar o boolean para false
            setDisponibilidadeDoFilme(true);
            if (disponibilidadeDoFilme == false) {
                throw new VendasException(movie[chose - 1]);
            }

            System.out.println("Filme: " + movie[chose - 1].getName());

            System.out.println("Quantidade de ingressos: ");
            int quant = s.nextInt();
            selectMovie.details(chose, quant);
        }

    } catch (VendasException e) {
        System.out.println(e.getErroTres());
    }
}

    public void amostraDeFilmes() {
        movie[0] = new Movie(8,10,"Steven Universe", 20);
        movie[1] = new Movie(10, 12,"Os 300 de Esparta", 20);
        movie[2] = new Movie(12, 14, "Kimetsu no yaiba", 20);
        movie[3] = new Movie(14, 16, "Os Incriveis", 20);
        movie[4] = new Movie(16, 18, "Ta Dando Onda 2", 20);
        movie[5] = new Movie(18, 20, "A voz do silêncio", 20);
        movie[6] = new Movie(20, 22, "A Era do Gelo", 20);


        System.out.println("Catalogo do dia:\n");
        System.out.println("  Horário    |     Filme     |    Valor");
        for (int i = 0; i < 7; i++) {
            System.out.print(movie[i].toString());
    
            System.out.println("\t");
        }
    }

    public void movieChoice() {
        System.out.println("\nQual o numero do filme deseja comprar o ingresso(de 1 a 7) \n(Para voltar ao menu digite: 0)");
    }

    public void movieSelection(int choice) {
        System.out.println("Filme: " + movie[choice - 1].getName());
    }

    public void ticketsQuantity() {
        System.out.println("Quantidade de ingressos: ");
    }

}