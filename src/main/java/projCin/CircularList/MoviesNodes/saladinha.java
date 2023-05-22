package projCin.CircularList.MoviesNodes;

import java.util.Scanner;

public class saladinha {

    public static void main(String[] args) {
        MovieCircularLinkedList MCLL = new MovieCircularLinkedList();
        Scanner sc = new Scanner(System.in);
        int n = 3;

        while(n > 0) {
            String name = sc.nextLine();
            String sumary = sc.nextLine();
            int dur = sc.nextInt();
            MCLL.addFirst(name, sumary, dur);
            String jumpline = sc.nextLine();
            n--;
        }

        n = 3;
        MovieNode movien = MCLL.getSentinel().getNext();
        while(n > 0) {
            System.out.printf("%s, %s, %d minutos\n", movien.getMovie().getName(), movien.getMovie().getSummary(), movien.getMovie().getDuration());
            movien = movien.getNext();
            n--;
        }

    }
    
}
