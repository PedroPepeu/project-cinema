package projCin.CircularList.ComidasNodes;

public class FoodNode {
    
    private String name;
    private char size;
    private double price;
    private FoodNode previous;
    private FoodNode next;

    public FoodNode(String name, char size, double price, FoodNode previous, FoodNode next) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.next = next;
        this.previous = previous;
    }

    public void setPrevious(FoodNode previous) {
        this.previous = previous;
    }

    public FoodNode getPrevious() {
        return this.previous;
    }

    public void setNext(FoodNode next) {
        this.next = next;
    }

    public FoodNode getNext() {
        return this.next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
