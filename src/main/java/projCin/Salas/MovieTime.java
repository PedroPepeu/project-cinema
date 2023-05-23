package projCin.Salas;

import java.util.Random;
import java.util.Scanner;
import projCin.Exception.VendasException;

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

    public void screen(String movieName, double tickets) {

        Random random = new Random();

        int avaliableChairs = 0;

        System.out.println("\n\n" + movieName);
        System.out.println("|Exit|---------------------------------------------------------------|Exit| ");
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 15; j++) {
                int aleat = random.nextInt(2);
                if (aleat == 1) {
                    chairs[i][j] = 'X';
                    isOcupied[i][j] = true;
                    System.out.print(ANSI_RED + " [" + chairs[i][j] + "] " + ANSI_RESET);
                } else if (aleat == 0) {
                    chairs[i][j] = ' ';
                    isOcupied[i][j] = false;
                    avaliableChairs++;
                    System.out.print(ANSI_GREEN + " [" + chairs[i][j] + "] " + ANSI_RESET);
                }
                // System.out.print(" [" + chairs[i][j] + "] ");
            }
            System.out.println("\t");
        }
        System.out.println("\n||||||||||||||||||||||||||||||     SCREEN    ||||||||||||||||||||||||||||||");

        if (avaliableChairs / tickets > 1) {
            chairsOptions(tickets);
        } else {
            System.out.println("Lotado");
        }
    }

    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_RESET = "\u001B[0m";

    public int showChairs(String movieName) {
        Random random = new Random();

        int avaliableChairs = 0;

        System.out.println("\n\n" + movieName);
        System.out.println(ANSI_YELLOW + "|Exit|---------------------------------------------------------------|Exit| "
                + ANSI_RESET);
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 15; j++) {
                int aleat = random.nextInt(2);
                if (aleat == 1) {
                    chairs[i][j] = 'X';
                    isOcupied[i][j] = true;
                    System.out.print(ANSI_RED + " [" + chairs[i][j] + "] " + ANSI_RESET);
                } else if (aleat == 0) {
                    chairs[i][j] = ' ';
                    isOcupied[i][j] = false;
                    avaliableChairs++;
                    System.out.print(ANSI_GREEN + " [" + chairs[i][j] + "] " + ANSI_RESET);
                }
                // System.out.print(" [" + chairs[i][j] + "] ");
            }
            System.out.println("\t");
        }
        System.out.println(ANSI_YELLOW + "\n||||||||||||||||||||||||||||||     SCREEN    ||||||||||||||||||||||||||||||"
                + ANSI_RESET);

        return avaliableChairs;
    }

    public void chairsOptions(double tickets) {
        System.out.println("Escolha os assentos disponiveis: ");
        boolean avaliable = false;
        int counter = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 15; i++) {
                if (isOcupied[j][i]) {
                    counter = 0;
                    continue;
                } else {
                    counter++;
                    if (counter == tickets) {
                        System.out.printf("Coluna: %d Linha: %d\n", i + 2 - counter, j + 1);
                        counter = 0;
                        avaliable = true;
                    }
                }
            }
            counter = 0;
        }
        if (avaliable) {
            escolha();
        } else {
            System.out.println("Nao disponivel para este numero de tickets"); //fazer exception aqui?
        }
        // terminou de escolher a cadeira

    }

    public boolean showChairsOptions(double tickets) {
        System.out.println("Escolha os assentos disponiveis: ");
        boolean avaliable = false;
        int counter = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 15; i++) {
                if (isOcupied[j][i]) {
                    counter = 0;
                    continue;
                } else {
                    counter++;
                    if (counter == tickets) {
                        System.out.printf("Coluna: %d Linha: %d\n", i + 2 - counter, j + 1);
                        counter = 0;
                        avaliable = true;
                    }
                }
            }
            counter = 0;
        }
        return avaliable;
    }

    public void escolha() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Coluna: ");
            int column = sc.nextInt();
            System.out.println("Linha: ");
            int line = sc.nextInt();

            if (isOcupied[line - 1][column - 1]) {
                throw new VendasException(line - 1, column - 1);

            } else {
                // salvar lugares
            }
        } catch (VendasException e) {
            System.out.println(e.getErroDois()); //erro de se a pessoa escolher uma cadeira que já foi escolhida
        }

    }

    public boolean free(int status) {
        if (status == 0) {
            return false;
        }
        return true;
    }

    // classe movietime praticamente feita, falta apenas detalhes

}