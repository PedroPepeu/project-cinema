package projCin;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double nota;
    
        Buy compra = new Buy();

        Movie movie = new Movie();

        compra.menuGeral();

        Review review = new Review();

        do {

            nota = input.nextDouble();

            review.atribuirNota(nota, movie);

            
        } while(true);

        
    }
    
    
}
