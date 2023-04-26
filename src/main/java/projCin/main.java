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

    public static String options() {
        return "Digite: 1 se Normal\n" +
               "Digite: 2 se Estudante\n" +
               "Digite: 3 se Critico\n";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        options();
        
        int decision = sc.nextInt();

        switch(decision) {
            case 1:
                
            case 2:

            case 3:
        }

        sc.close();
    }
    
}
