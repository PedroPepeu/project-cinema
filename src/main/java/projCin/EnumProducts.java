package projCin;

public enum EnumProducts {
    PIPOCAP ("p", 7.00),
    PIPOCAM ("m", 8.00),
    PIPOCAG ("g", 9.00),
    COCACOLA250 ("250", 6.00),
    COCACOLA500 ("500", 7.00),
    COCACOLA1000 ("1000", 8.00),
    FRITASINDV ("Fritas Individual", 5.00),
    FRITASDUPL ("Fritas Dupla", 8.00),
    FINI ("Fini", 3.00),
    CHOCOLATE ("Chocolate", 4.00);

    private final String name;
    private final double price;

    private EnumProducts(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return "R$ " + String.valueOf(this.price); 
    }

}
