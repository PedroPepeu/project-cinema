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


    public void menuGeral() {
        System.out.println("Bem vindo! \nSelecione o que deseja:\n" + 
        "1- Catalogo de filmes \n2- Lanche\n");
        
        int decision = s.nextInt();
        if(decision == 1){
            buyingScreem.sessions(); //catalog.    mostrar os filmes e liberar o detalhamento de um deles a partir da escolha
        }else if(decision == 2){
            snack.menu();
        }else{
            System.out.println("Opcao invalida. Retornando para o menu.\n");
            menuGeral();
        }

    }

    /*public void choosingOpinton(String decision){
        switch (decision){
            case "Steven Universe":
                physicalRoom.screen(decision);
<<<<<<< HEAD
            case "Os 300 de Esparta":
                physicalRoom.screen(decision);
=======

            case "Os 300 de Esparta":
                physicalRoom.screen(decision);

>>>>>>> 4f788d66add7b66d775d11a0b65c6a3db0cfde50
            case "Kimetsu no yaiba":
                physicalRoom.screen(decision);
                
            case "Os Incriveis 3":
                physicalRoom.screen(decision);
<<<<<<< HEAD
            case "Ta Dando Onda 2":
                physicalRoom.screen(decision);
            case "A voz do silêncio":
                physicalRoom.screen(decision);
            case "A Era do Gelo 7":
                physicalRoom.screen(decision);
            case "menu":
                
                
=======

            case "Ta Dando Onda 2":
                physicalRoom.screen(decision);

            case "A voz do silêncio":
                physicalRoom.screen(decision);

            case "A Era do Gelo 7":
                physicalRoom.screen(decision);

            case "menu":
                


                

>>>>>>> 4f788d66add7b66d775d11a0b65c6a3db0cfde50
        }
    }*/
    
    public void confirmation() {

    }

}