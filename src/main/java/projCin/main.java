package projCin;

public class main {

    public static void main(String[] args) {
        
        Room room = new Room();
        char matriz[][] = new char[10][15];
        MovieTime filminho = new MovieTime(matriz);

        // room.sessions();

        filminho.screen();
    }
    
}
