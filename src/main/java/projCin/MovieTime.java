package projCin;

import java.util.Random;

public class MovieTime {

    private char chairs[][] = new char[10][15];

    

    
    public MovieTime() {
        
    }

    public void screen(String movieName) {
        
        Random random = new Random();

        System.out.println("\n\n" + movieName);
        System.out.println("|Exit|---------------------------------------------------------------|Exit| ");
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 15; j++) {
                int aleat = random.nextInt(2);
                if(aleat == 1){
                    chairs[i][j] = 'X';                
                } else if(aleat == 0) {
                    chairs[i][j] = ' ';
                }
                System.out.print(" [" + chairs[i][j] + "] ");
            }
            System.out.println("\t");
        }
        System.out.println("\n||||||||||||||||||||||||||||||     SCREEN    ||||||||||||||||||||||||||||||");
    }
    
    public boolean free(int status) {
        if(status == 0){
            return false;
        }
        return true;
    }

    public char[][] getChairs() {
        return chairs;
    }

    public void setChairs(char[][] chairs) {
        this.chairs = chairs;
    }

    //classe movietime praticamente feita, falta apenas detalhes
    
}
