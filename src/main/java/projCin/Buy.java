package projCin;

import java.util.Scanner;

public class Buy {

    public String food;
    public double price;
    public double total;
    public Ticket ticket; // need to create an ticket and sync with the movie
    

    MovieTime physicalRoom = new MovieTime();
    Movie catalog = new Movie();
    Room buyingScreem = new Room(); //go firsh to catalog and before to buyingScreem
    Food snack = new Food();
    
    Scanner s = new Scanner(System.in);

    public Buy(String food, double price, double total, Ticket ticket) {
        this.food = food;
        this.price = price;
        this.total = total;
        this.ticket = ticket;
    }

    public Buy() {

    }

    public double totalPrice() {
        
        return 0.0;
    }

    public String[] itemsBought() {
        return snack.getFoodList();
        //set variables for all foods and get how many times they were summoned(use counters at food to get it)
        //or just show how manny foods were bought
    }


    public void menu() {
        System.out.println("Bem vindo! \nSelecione o que deseja:\n" + 
        "1- Catalogo de filmes \n2- Lanche");
        
        int decision = s.nextInt();
        if(decision == 1){
            //catalog.    mostrar os filmes e liberar o detalhamento de um deles a partir da escolha
        }else if(decision == 2){
            snack.menu();
        }else{
            System.out.println("Opcao invalida. Retornando para o menu.\n");
            menu();
        }

    }
    
    public void confirmation() {

    }

}
