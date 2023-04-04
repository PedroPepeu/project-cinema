package projCin;

import java.util.Scanner;

/*A classe de sala irá compor uma lista de sessões, a lista têm um tamanho fixo com
uma grade de horário, caso não exista uma sessão em algum horário, aquela sessão
será registrada como nula e não irá aparecer para o usuário;*/

//Para comprar os filmes    
public class Room {

    
    private MovieTime[] movietime;//Chairs at room
    //private Room [][] catalog;
    private Movie [] movie;

    MovieTime horaDoFilme = new MovieTime();
    

    public Room() { 
        this.movie = new Movie[7]; 
    }

    public void sessions(){
        Scanner s = new Scanner(System.in);
        Movie selectMovie = new Movie();
        
        movie[0] = new Movie("08:00 - 10:00","Steven Universe", 20);
        movie[1] = new Movie("10:00 - 12:00","Os 300 de Esparta", 20);
        movie[2] = new Movie("12:00 - 14:00", "Kimetsu no yaiba", 20);
        movie[3] = new Movie("14:00 - 16:00", "Os Incriveis", 20);
        movie[4] = new Movie("16:00 - 18:00", "Ta Dando Onda 2", 20);
        movie[5] = new Movie("18:00 - 20:00", "A voz do silêncio", 20);
        movie[6] = new Movie("20:00 - 22:00", "A Era do Gelo", 20);

        System.out.println("Catalogo do dia:\n");
        System.out.println("  Horário    |     Filme     |    Valor");
        for (int i = 0; i < 7; i++) {
            System.out.print(movie[i]);
    
            System.out.println("\t");
        }

        System.out.println("\nQual o numero do filme deseja comprar o ingresso(de 1 a 7) \n(Para voltar ao menu digite: 0)");
        int chose = s.nextInt();
        System.out.println("Filme: " + movie[chose - 1].getName());

        System.out.println("Quantidade de ingressos: ");
        int quant = s.nextInt();
        selectMovie.details(chose, quant);

        s.close();

    }





}