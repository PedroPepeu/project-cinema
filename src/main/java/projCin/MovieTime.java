package projCin;

import java.util.Random;
import java.util.Scanner;

public class MovieTime {

    private char chairs[][] = new char[10][15];
    private boolean isOcupied[][] = new boolean[10][15];

    public MovieTime() {
        
    }

    public char[][] getChairs() {
        return chairs;
    }

    public void setChairs(char[][] chairs) {
        this.chairs = chairs;
    }

    public boolean[][] getIsOcupied() {
        return isOcupied;
    }

    public void setIsOcupied(boolean[][] isOcupied) {
        this.isOcupied = isOcupied;
    }

    public void screen(String movieName, double tick) {
        
        Random random = new Random();

        int avaliableChairs = 0;

        System.out.println("\n\n" + movieName);
        System.out.println("|Exit|---------------------------------------------------------------|Exit| ");
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 15; j++) {
                int aleat = random.nextInt(2);
                if(aleat == 1){
                    chairs[i][j] = 'X';                
                    isOcupied[i][j] = true;
                } else if(aleat == 0) {
                    chairs[i][j] = ' ';
                    isOcupied[i][j] = false;
                    avaliableChairs++;
                }
                System.out.print(" [" + chairs[i][j] + "] ");
            }
            System.out.println("\t");
        }
        System.out.println("\n||||||||||||||||||||||||||||||     SCREEN    ||||||||||||||||||||||||||||||");

        if(avaliableChairs / tick > 1) {
            chairsOptions(tick);
        } else {
            System.out.println("Lotado");
        }
    }
    
    public void chairsOptions(double tickets) {
        System.out.println("Escolha os assentos disponiveis: ");
        boolean avaliable = false;
        int counter = 0;
        for(int j = 0; j < 10; j++) {
            for(int i = 0; i < 15; i++) {
                if(isOcupied[j][i]) {
                    counter = 0;
                    continue;
                } else {
                    counter++;
                    if(counter == tickets) {
                        System.out.printf("Coluna: %d Linha: %d\n", i + 2 - counter, j + 1);
                        counter = 0;
                        avaliable = true;
                    }
                }
            }
            counter = 0;
        }
        if(avaliable) {
            escolha();
        } else {
            System.out.println("Nao disponivel para este numero de tickets");
        }
        // terminou de escolher a cadeira

    }

    public void escolha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Coluna: ");
        int column = sc.nextInt();
        System.out.println("Linha: ");
        int line = sc.nextInt();
        if(isOcupied[line -1][column - 1]) {
            escolha();
        } else {
            // salvar lugares
        }
        sc.close();
    }
    
    public boolean free(int status) {
        if(status == 0){
            return false;
        }
        return true;
    }

    //classe movietime praticamente feita, falta apenas detalhes
    
}