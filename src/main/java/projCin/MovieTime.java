package projCin;

import java.util.Random;

//Sessão fisica do cinema
public class MovieTime {

    public char chairs[][];

    Random random = new Random();

    public MovieTime(char[][] vet) {
        this.chairs = new char[10][15];
    }

    public MovieTime() {
        
    }
    

    /*public fillingOut(){
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                random.nextInt(2);
            }
        }
    }*/

    public void screen(){
        
        System.out.println("|Exit|---------------------------------------------------|Exit|");
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 15; j++) {
                double aleat = random.nextInt(2);
                if(aleat == 1){
                    chairs[i][j] = '#';                
                }
                System.out.print(" [" + chairs[i][j] + "] ");
            }
        }
        System.out.println();
        System.out.println("||||||||||||||||||||||||||||||Screen||||||||||||||||||||||||||||||");
    }
    
    public boolean free(int status){
        if(status == 0){
            return false;
        }
        return true;
    }

    
}
