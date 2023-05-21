public class FoodObj {

    private String name;
    private char size;
    private double price;

    public FoodObj(String name, char size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSize() {
        return this.size;
    }

    public void setSize(char Size) {
        this.size = size;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
