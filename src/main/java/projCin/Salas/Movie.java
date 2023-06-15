package projCin.Salas;

import java.util.Scanner;

import projCin.CircularList.MoviesNodesTestando.MovieCLLTeste;
import projCin.CircularList.MoviesNodesTestando.MovieNodeTeste;
import projCin.CircularList.MoviesNodesTestando.MovieObjTeste;
import projCin.ComidaCompras.Buy;
import projCin.Enum.EnumRooms;
import java.time.LocalTime;

//Para olhar sobre os filmes
//Movies vai entrar qnd for especificar uma sala
public class Movie {

    private String name;
    private int minutes = 120;//
    private int tempMin = 8;
    private int tempMax = 10;
    private String summary; // sinopse
    private double price = 20.00;
    private Review[] review = new Review[100]; // atributo que o prof pediu para criar
    private int quantCrit = 0; 
    private int posiçãoReview = 100;
    private double media;


    MovieTime mt = new MovieTime();
    Room room = new Room();

    public Movie() {

    }
    
    public Movie(String name){
        this.name = name;

    }

    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public MovieTime getMt() {
        return mt;
    }
    public void setMt(MovieTime mt) {
        this.mt = mt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Review[] getReview() {
        return review;
    }

    public void setReview(Review[] review) {
        this.review = review;
    }

    public int getQuantCrit() {
        return quantCrit;
    }

    public void setQuantCrit(int quantCrit) {
        this.quantCrit = quantCrit;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public int getPosiçãoReview() {
        return posiçãoReview;
    }

    public void setPosiçãoReview(int posiçãoReview) {
        this.posiçãoReview = posiçãoReview;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public Movie(String name, int minutes, String summary, double price) {  //fazendo uma sobrecarga de construtures para ter uma com os parametros e outra sem nenhum parametro
        this.name = name;
        this.minutes = minutes;
        this.summary = summary;
        this.price = price;
    }

    public Movie(int tempMin, int tempMax, String name, double price) {  //fazendo outra sobrecarga para colocar na classe Room
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.name = name;
        this.price = price;
    }

    public String toString(MovieObjTeste name) {
        LocalTime horarioDoFilmeMin = LocalTime.of(tempMin, 00);
        LocalTime horarioDoFilmeMax = LocalTime.of(tempMax, 00);
        return "HORÁRIO: "+horarioDoFilmeMin+"  -  "+horarioDoFilmeMax+"  FILME: " + name.getName() + " VALOR: " + price + " RS ";
    }

    

    public double decision(int option){

        switch (option){
            case 1:    
                return EnumRooms.SALA_COMUM.getmultiplicadorDasSalas();
            case 2:
                return EnumRooms.SALA_3D.getmultiplicadorDasSalas();
            case 3:
                return EnumRooms.SALA_XD.getmultiplicadorDasSalas();
            case 4:
                return EnumRooms.SALA_XD3D.getmultiplicadorDasSalas();
            default:
                return EnumRooms.SALA_COMUM.getmultiplicadorDasSalas();
            
        }
        
    }

    public void details(int movieNumber, double numOfPeople, MovieCLLTeste filmes){
        Scanner s = new Scanner(System.in);

        Buy buy = new Buy();

        MovieObjTeste vet[] = new MovieObjTeste[7];
        String nomeDoFilme;
        String summary;
        int sala;
        int i = 0;
        MovieNodeTeste aux;

        aux = filmes.getPrimeiro();
        do {
            vet[i] = aux.getInfo();
            aux = aux.getProx();
            i++;
        } while (aux != filmes.getPrimeiro());
        


        switch (movieNumber){
            case 1:
                
                System.out.print(vet[0]);

                System.out.println("\nEscolha uma das salas disponíveis: \n 1- " + EnumRooms.SALA_COMUM + "\n 2- " + EnumRooms.SALA_3D + "\n 3- " + EnumRooms.SALA_XD + "\n 4- " + EnumRooms.SALA_XD3D + "\n");
                sala = s.nextInt();
                

                System.out.println("Total: R$ " + (getPrice() * numOfPeople * decision(sala)));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople * decision(sala)));
                mt.screen(vet[0].getName(), numOfPeople);
                break;
                
                

            case 2:
                
                
                System.out.println(vet[1]);

                System.out.println("\nEscolha uma das salas disponíveis: \n 1- " + EnumRooms.SALA_COMUM + "\n 2- " + EnumRooms.SALA_3D + "\n 3- " + EnumRooms.SALA_XD + "\n 4- " + EnumRooms.SALA_XD3D + "\n");
                sala = s.nextInt();
                

                System.out.println("Total: R$ " + (getPrice() * numOfPeople * decision(sala)));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople * decision(sala)));
                mt.screen(vet[1].getName(), numOfPeople);
                break;

                

            case 3:
            
                System.out.println(vet[2]);

                System.out.println("\nEscolha uma das salas disponíveis: \n 1- " + EnumRooms.SALA_COMUM + "\n 2- " + EnumRooms.SALA_3D + "\n 3- " + EnumRooms.SALA_XD + "\n 4- " + EnumRooms.SALA_XD3D + "\n");
                sala = s.nextInt();

                System.out.println("Total: R$ " + (getPrice() * numOfPeople * decision(sala)));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople * decision(sala)));
                mt.screen(vet[2].getName(), numOfPeople);
                break;
                
                
            case 4:
                
                System.out.println(vet[3]);
                
                System.out.println("\nEscolha uma das salas disponíveis: \n 1- " + EnumRooms.SALA_COMUM + "\n 2- " + EnumRooms.SALA_3D + "\n 3- " + EnumRooms.SALA_XD + "\n 4- " + EnumRooms.SALA_XD3D + "\n");
                sala = s.nextInt();


                System.out.println("Total: R$ " + (getPrice() * numOfPeople * decision(sala)));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople * decision(sala)));
                mt.screen(vet[3].getName(), numOfPeople);
                break;
                
                

            case 5:
                
                System.out.println(vet[4]);
                
                System.out.println("\nEscolha uma das salas disponíveis: \n 1- " + EnumRooms.SALA_COMUM + "\n 2- " + EnumRooms.SALA_3D + "\n 3- " + EnumRooms.SALA_XD + "\n 4- " + EnumRooms.SALA_XD3D + "\n");
                sala = s.nextInt();

                System.out.println("Total: R$ " + (getPrice() * numOfPeople * decision(sala)));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople * decision(sala)));
                mt.screen(vet[4].getName(), numOfPeople);
                break;
                


            case 6:
                
                 System.out.println(vet[5]);
                
                System.out.println("\nEscolha uma das salas disponíveis: \n 1- " + EnumRooms.SALA_COMUM + "\n 2- " + EnumRooms.SALA_3D + "\n 3- " + EnumRooms.SALA_XD + "\n 4- " + EnumRooms.SALA_XD3D + "\n");
                sala = s.nextInt();

                System.out.println("Total: R$ " + (getPrice() * numOfPeople * decision(sala)));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople * decision(sala)));
                mt.screen(vet[5].getName(), numOfPeople);
                break;
                

            case 7:
                
                System.out.println(vet[6]);
                
                System.out.println("\nEscolha uma das salas disponíveis: \n 1- " + EnumRooms.SALA_COMUM + "\n 2- " + EnumRooms.SALA_3D + "\n 3- " + EnumRooms.SALA_XD + "\n 4- " + EnumRooms.SALA_XD3D + "\n");
                sala = s.nextInt();

                System.out.println("Total: R$ " + (getPrice() * numOfPeople * decision(sala)));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople * decision(sala)));
                mt.screen(vet[6].getName(), numOfPeople);
                break;  

        }
       
    }
    
    public String movieName(int decision) {
        String name = null;
        
        switch(decision) {
            case 1:
                name = "Steven Universe";
                break;
            case 2:
                name = "Os 300 de Esparta";
                break;
            case 3:
                name = "Kimetsu no yaiba";
                break;
            case 4:
                name = "Os Incriveis";
                break;
            case 5:
                name = "Ta Dando Onda 2";
                break;
            case 6:
                name = "A voz do silêncio";
                break;
            case 7:
                name = "A era do Gelo";
                break;
        }

        return name;
    }

}