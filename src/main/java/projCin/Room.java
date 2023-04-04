package projCin;

import java.util.Scanner;

public class Room {

    private MovieTime[] movietime;// Chairs at room
    private Room[][] catalog;
    private Movie[] movie;
    private int escolhaFilme;

    public Room() {
        this.movie = new Movie[7];
    }
    public void sessions() {

        movie[0] = new Movie("08:00 - 10:00", "Steven Universe", 20);
        movie[1] = new Movie("10:00 - 12:00", "Os 500 de Esparta", 20);
        movie[2] = new Movie("12:00 - 14:00", "Kimetsu no yaiba", 20);
        movie[3] = new Movie("14:00 - 16:00", "OS Incriveis 3", 20);
        movie[4] = new Movie("16:00 - 18:00", "Ta Dando Onda 2", 20);
        movie[5] = new Movie("18:00 - 20:00", "A voz do silêncio", 20);
        movie[6] = new Movie("20:00 - 22:00", "A Era do Gelo 7", 20);

        System.out.println("  Horário    |     Filme     |    Valor");
        for (int i = 0; i < 7; i++) {
            System.out.print(movie[i]);

            System.out.println("\t");
        }
    }

    public boolean existeFilme() {
        if (escolhaFilme > 7 || escolhaFilme < 1) {
            return false;
        }
        return true;

    }

    public void escolherFilme() {
        Scanner input = new Scanner(System.in);

        System.out.println("\ndigite de '1' a '7' para escolher o filme desejado: ");
        
        do {

            
            escolhaFilme = input.nextInt();

            switch (escolhaFilme) {

                case 1: {
                    System.out.println(movie[0]);
                    break;
                }

                case 2: {
                    System.out.println(movie[1]);
                    break;
                }

                case 3: {
                    System.out.println(movie[2]);
                    break;
                }

                case 4: {
                    System.out.println(movie[3]);
                    break;
                }

                case 5: {
                    System.out.println(movie[4]);
                    break;
                }

                case 6: {
                    System.out.println(movie[5]);
                    break;
                }

                case 7: {
                    System.out.println(movie[6]);
                    break;
                }
                default: {
                    System.out.println("Valor invalido, digite novamente entre os valores '1' e '7'");
                    break;
                } // falta testar e otimizar um pouco
            }

        } while (existeFilme() == false);
    }

}