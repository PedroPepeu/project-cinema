package projCin;

import java.util.Scanner;

public class Food {

    private String[] foodList;
    private int head;
    private double total;
    private double soma;

    public Food() {
        this.foodList = new String[5];
        this.head = -1;
        this.total = 0;
        this.soma = 0;
    }

    public void menu() {
        Scanner s = new Scanner(System.in);
        System.out.println("\n\n\n\nSelecione o que deseja adicionar ao carrinho: \n"
                + " 1- Pipoca\n  2- Coca-cola\n  3- Fritas\n  4- Fini\n  5- Chocolate\n  0- Finalizar");
        int button = s.nextInt();
        compra(button);
        s.close();

    }

    public String[] getFoodList() {
        return foodList; // add switch case
    }

    public void setFoodList(String[] foodList) {
        this.foodList = foodList;
    }

    public double getTotal() {
        System.out.println(this.total);
        System.out.println(this.total == total);
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void addFoods(String s1) {
        if (isFull())
            expandArr();
        this.head += 1;
        this.foodList[this.head] = s1;
    }

    private void expandArr() {
        String[] Arr = new String[this.foodList.length + 5];
        for (int i = 0; i < this.foodList.length; i++) {
            Arr[i] = this.foodList[i];
        }
        setFoodList(Arr);
    }

    private boolean isFull() {
        return this.head == this.foodList.length - 1;
    }

    public void compra(int value, EnumPromotionalCoupon ticket){
        this.soma += value * (1 - ticket.getDesconto());
    }

    public void compra(int select) {
        Scanner s = new Scanner(System.in);
        //Buy buying = new Buy();

        int keep = 1;
        while (keep == 1) {
            switch (select) {
                case 1:

                    System.out.println("Tamanho: ");
                    System.out.println("P (R$ 7,00)\n M (R$ 8,00)\n G (R$ 9,00)");
                    char size = s.next().charAt(0);
                    switch (size) {
                        case 'p':
                            System.out.print("Quantidade: ");
                            int quantPP = s.nextInt();
                            total += 7 * quantPP;
                            menu();
                        case 'm':
                            System.out.print("Quantidade: ");
                            int quantPM = s.nextInt();
                            total += 8 * quantPM;
                            menu();
                        case 'g':
                            System.out.print("Quantidade: ");
                            int quantPG = s.nextInt();
                            total += 9 * quantPG;
                            menu();
                        default:
                            System.out.println("Tamanho invalido. Pipoca cancelada.");
                            menu();

                    }

                case 2:

                    System.out.println("Litros: ");
                    System.out.println("250 (R$ 6,00)\n 500 (R$ 7,00)\n 1000 (R$ 8,00)");
                    System.out.println("Litro desejado: ");
                    int litro = s.nextInt();
                    switch (litro) {
                        case 250:
                            System.out.print("Quantidade: ");
                            int quantRP = s.nextInt();
                            total += 6 * quantRP;
                            menu();
                        case 500:
                            System.out.print("Quantidade: ");
                            int quantRM = s.nextInt();
                            total += 7 * quantRM;
                            menu();
                        case 1000:
                            System.out.print("Quantidade: ");
                            int quantRG = s.nextInt();
                            total += 8 * quantRG;
                            menu();
                        default:
                            System.out.println("Tamanho invalido. Coca-cola cancelada.");
                            menu();

                    }

                case 3:
                    System.out.println("1- Porcao individual(R$ 5,00)\n2- Porcao dupla(R$ 8,00)");
                    int portion = s.nextInt();
                    switch (portion) {
                        case 1:
                            System.out.println("Quantidade: ");
                            int quantFI = s.nextInt();
                            total += 5 * quantFI;
                            menu();
                        case 2:
                            System.out.println("Quantidade: ");
                            int quantFD = s.nextInt();
                            total += 8 * quantFD;
                            menu();
                    }

                case 4:
                    System.out.println("Unidade: R$3,00 \nQuantidade: ");
                    int quantFn = s.nextInt();
                    total += 3 * quantFn;
                    menu();

                case 5:
                    System.out.println("Unidade: R$4,00 \nQuantidade: ");
                    int quantCh = s.nextInt();
                    total += 4 * quantCh;
                    menu();

                case 0:
                    keep = 0;
                    buying.menuGeral();
                    

                default:
                    System.out.println("Valor invalido.");
                    keep = 0;
                    menu();
            }
        }
        s.close();
    }

}
