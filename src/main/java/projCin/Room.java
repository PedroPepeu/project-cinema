package projCin;


/*A classe de sala irá compor uma lista de sessões, a lista têm um tamanho fixo com
uma grade de horário, caso não exista uma sessão em algum horário, aquela sessão
será registrada como nula e não irá aparecer para o usuário;*/

//Para comprar os filmes    
public class Room {

    private MovieTime[] movietime;//Chairs at room
    private Room [][] catalog;
    private Movie [][] movie;

    public Room(/*MovieTime[] movietime, Room[][] catalog, Movie[][] movie*/) {
        /*this.movietime = movietime;*/
        //this.catalog = catalog;
        this.movie = new Movie[6][1]; 
        
        //nao ne? Acho q n rola
        movie[0][0] = new Movie("A Era do Gelo 7", 20);
        movie[1][0] = new Movie("Os 500 de Espart0a", 20);
        movie[2][0] = new Movie("Os Simpsons", 20);
        movie[3][0] = new Movie("OS Incriveis 3", 20);
        movie[4][0] = new Movie("Ta Dnado Onda 2", 20);
        movie[5][0] = new Movie("Filme wasd", 20);
        //movie[0][6] = new Movie("A Era do Gelo 7", 20);
    
    }

    public void sessions(){
        for (int i = 0; i < movie.length; i++) {
            
            for (int j = 0; j < movie[0].length; j++) {
                int time = 10;
                System.out.println(time + ":00 - " + (time + 2)  + movie[i][j]);
            }
        }
    }

}
