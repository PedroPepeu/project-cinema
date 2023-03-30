package projCin;

public class Buy {

    private String food;
    private double price;
    private double total;
    private Ticket ticket; // need to create an ticket and sync with the movie

    public Buy() {
        
    }

    public Buy(String food, double price, double total, Ticket ticket) { //fazendo uma sobrecarga de construtures para ter uma com os parametros e outra sem nenhum parametro
        this.food = food;
        this.price = price;
        this.total = total;
        this.ticket = ticket;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double totalPrice() {

    }

    public String[] itemsBought() {

    }

    public double menu() {

    }
    
    public void confirmation() {

    }

}
