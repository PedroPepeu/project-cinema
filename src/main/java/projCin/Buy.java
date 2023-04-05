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

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public MovieTime getPhysicalRoom() {
        return physicalRoom;
    }

    public void setPhysicalRoom(MovieTime physicalRoom) {
        this.physicalRoom = physicalRoom;
    }

    public Movie getCatalog() {
        return catalog;
    }

    public void setCatalog(Movie catalog) {
        this.catalog = catalog;
    }

    public Room getBuyingScreem() {
        return buyingScreem;
    }

    public void setBuyingScreem(Room buyingScreem) {
        this.buyingScreem = buyingScreem;
    }

    public Food getSnack() {
        return snack;
    }

    public void setSnack(Food snack) {
        this.snack = snack;
    }

    public Scanner getS() {
        return s;
    }

    public void setS(Scanner s) {
        this.s = s;
    }

    public double totalPrice() {
        return getTotal();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
            System.out.println("Ingresso Comprado");
        }else if(decision == 2){
            snack.menu();
        }else{
            System.out.println("Opcao invalida. Retornando para o menu.\n");
            menuGeral();
        }

    }

    public void confirmation() {

    }

}