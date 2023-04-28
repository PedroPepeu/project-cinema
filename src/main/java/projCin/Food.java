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

    public void menuPresentation() {
        System.out.println("\n\n\n\nSelecione o que deseja adicionar ao carrinho: \n"
                + " 1- Pipoca\n  2- Coca-cola\n  3- Fritas\n  4- Fini\n  5- Chocolate\n  0- Finalizar");
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

    //sobrecarga
    public void compra(int value, EnumPromotionalCoupon ticket){
        this.soma += value * (1 - ticket.getDesconto());
    }

    public void compra(int select) {
        Scanner s = new Scanner(System.in);
        Buy buying = new Buy();

        int keep = 1;
        while (keep == 1) {
            switch (select) {
                case 1:
                    System.out.println("Tamanho \n" + EnumProducts.PIPOCAP.getName() + " (" + EnumProducts.PIPOCAP.getPrice() + " R$) \n"
                                       + EnumProducts.PIPOCAM.getName() + " (" + EnumProducts.PIPOCAM.getPrice() + " R$) \n" 
                                       + EnumProducts.PIPOCAG.getName() + " (" + EnumProducts.PIPOCAG.getPrice() + " R$) ");
                    System.out.println("\nGRANA PERDIDA ---> "+ this.total + " R$\n");     
                    System.out.println(" 'p' para pequena, 'm' para média e 'g' para grande: ");             
                    char size = s.next().charAt(0); 

                    switch (size) {
                        case 'p':
                            System.out.print("Quantidade: ");
                            int quantPP = s.nextInt();
                            total += EnumProducts.PIPOCAP.getPrice() * quantPP;
                            menu();
                        case 'm':
                            System.out.print("Quantidade: ");
                            int quantPM = s.nextInt();
                            total += EnumProducts.PIPOCAM.getPrice() * quantPM;
                            menu();
                        case 'g':
                            System.out.print("Quantidade: ");
                            int quantPG = s.nextInt();
                            total += EnumProducts.PIPOCAG.getPrice() * quantPG;
                            menu();
                        default:
                            System.out.println("Tamanho invalido. Pipoca cancelada.");
                            menu();

                    }

                case 2:

                    
                    System.out.println("Litros \n" + EnumProducts.COCACOLA250.getName() +" (" + EnumProducts.COCACOLA250.getPrice() + " R$) \n"
                                       + EnumProducts.COCACOLA500.getName() + " (" + EnumProducts.COCACOLA500.getPrice() + " R$) \n"
                                       + EnumProducts.COCACOLA1000.getName() + " (" +EnumProducts.COCACOLA1000.getPrice() + " R$)" );
                    System.out.println("\nGRANA PERDIDA ---> "+ this.total + " R$\n");     
                    System.out.println("digite 250, 500 ou 1000: ");                                        
                    int litro = s.nextInt();

                    switch (litro) {
                        case 250:
                            System.out.print("Quantidade: ");
                            int quantRP = s.nextInt();
                            total += EnumProducts.COCACOLA250.getPrice() * quantRP;
                            menu();
                        case 500:
                            System.out.print("Quantidade: ");
                            int quantRM = s.nextInt();
                            total += EnumProducts.COCACOLA500.getPrice() * quantRM;
                            menu();
                        case 1000:
                            System.out.print("Quantidade: ");
                            int quantRG = s.nextInt();
                            total += EnumProducts.COCACOLA1000.getPrice() * quantRG;
                            menu();
                        default:
                            System.out.println("Tamanho invalido. Coca-cola cancelada.");
                            menu();

                    }

                case 3:
                    System.out.println("1- " + EnumProducts.FRITASINDV.getName() + " (" + EnumProducts.FRITASINDV.getPrice() + " R$) \n"
                                       +"2- " + EnumProducts.FRITASDUPL.getName() + " (" + EnumProducts.FRITASDUPL.getPrice() + " R$)");
                    System.out.println("\nGRANA PERDIDA ---> "+ this.total + " R$\n");     
                    System.out.println("Digite 1 para individual ou 2 para dupla: ");
                    int portion = s.nextInt();

                    switch (portion) {
                        case 1:
                            System.out.println("Quantidade: ");
                            int quantFI = s.nextInt();
                            total += EnumProducts.FRITASINDV.getPrice() * quantFI;
                            menu();
                        case 2:
                            System.out.println("Quantidade: ");
                            int quantFD = s.nextInt();
                            total += EnumProducts.FRITASDUPL.getPrice() * quantFD;
                            menu();
                        default:
                            System.out.println("Número invalido");
                            menu();

                    }

                case 4:
                    System.out.println(EnumProducts.FINI.getName() + " (" + EnumProducts.FINI.getPrice() + " R$)");
                    System.out.println("\nGRANA PERDIDA ---> "+ this.total + " R$\n");    
                    System.out.println("Digite a quantidade de finis: ");
                    int quantFn = s.nextInt();

                    total += EnumProducts.FINI.getPrice() * quantFn;
                    menu();

                case 5:
                    System.out.println(EnumProducts.CHOCOLATE.getName() + " (" +EnumProducts.CHOCOLATE.getPrice() + " R$)");
                    System.out.println("\nGRANA PERDIDA ---> "+ this.total + " R$\n");     
                    System.out.println("Digite a quantidade de chocolates: ");
                    int quantCh = s.nextInt();

                    total += EnumProducts.CHOCOLATE.getPrice() * quantCh;
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