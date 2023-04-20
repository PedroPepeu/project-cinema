package projCin;

public enum EnumProducts {
    PIPOCAP ("Pipoca Pequena", 7.00),
    PIPOCAM ("Pipoca Media", 8.00),
    PIPOCAG ("Pipoca Grande", 9.00),
    COCACOLA250 ("Coca-Cola 250ml", 6.00),
    COCACOLA500 ("Coca-Cola 500ml", 7.00),
    COCACOLA1000 ("Coca-Cola 1000ml", 8.00),
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

}