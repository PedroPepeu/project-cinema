package projCin;

import java.util.Scanner;

//Para olhar sobre os filmes
//Movies vai entrar qnd for especificar uma sala
public class Movie {

    private String name;
    private int minutes = 120;//
    private String timeInString;
    private String summary; // sinopse
    private double price = 20.00;

    Room room = new Room();
    MovieTime mt = new MovieTime();
    

    public Movie() {

    }
    public Movie(String name){
        this.name = name;

    }

    public Movie(String name, int minutes, String summary, double price) {  //fazendo uma sobrecarga de construtures para ter uma com os parametros e outra sem nenhum parametro
        this.name = name;
        this.minutes = minutes;
        this.summary = summary;
        this.price = price;
    }

    public Movie(String timeInString, String name, double price) {  //fazendo outra sobrecarga para colocar na classe Room
        this.timeInString = timeInString;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getTimeInString() {
        return timeInString;
    }

    public void setTimeInString(String timeInString) {
        this.timeInString = timeInString;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return " "  + timeInString + ", " + name + ", " + price + " ";
    }

    public void details(int movieNumber, double numOfPeople){

        Buy buy = new Buy();
        
        Scanner s = new Scanner(System.in);
        String nomeDoFilme;
        String summary;
        switch (movieNumber){
            case 1:
                
                nomeDoFilme = "Steven Universe";
                System.out.println(nomeDoFilme);
                summary = "\nA série segue as aventuras de Steven, um garoto que herdou uma poderosa missão e,"
                 + "junto de seus amigos Garnet, Amethyst e Pearl, precisarão proteger o mundo de certas ameaças."
                 + " Enquanto Steven tenta descobrir como usar sua herança, ele passa seus dias na Beach City se " 
                 +"divertindo com seus amigos.\n";

                setSummary(summary);
                System.out.println(getSummary());    
                System.out.println("Duracao: " + getMinutes() + " minutos");
                
                
                System.out.println("Total: R$ " + (getPrice() * numOfPeople));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople));
                mt.screen(nomeDoFilme, numOfPeople);
                break;
                
                

            case 2:
                
                nomeDoFilme ="Os 300 de Esparta";
                System.out.println(nomeDoFilme);
                summary = "O enredo gira em torno do Rei Leónidas (Gerard Butler), que lidera 300 espartanos" 
                + " na batalha contra o ''deus-rei'' Xerxes I (Rodrigo Santoro) da Pérsia e o seu exército "
                + "invasor com mais de 30 mil soldados. Enquanto a batalha acontece, a Rainha Gorgo (Lena Headey)" 
                + " tenta encontrar apoio para o seu marido em Esparta.";
                setSummary(summary);
                System.out.println(getSummary());    
                System.out.println("Duracao: " + getMinutes() + " minutos");
                
            
                System.out.println("Total: R$ " + (getPrice() * numOfPeople));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople));
                mt.screen(nomeDoFilme, numOfPeople);
                break;

                

            case 3:
                
                nomeDoFilme = "Kimetsu no yaiba";
                System.out.println(nomeDoFilme);
                summary = "Dois jovens espadachins embarcam em um trem com a missão de derrotar um demônio" 
                + " que tem atormentado as pessoas.";
                setSummary(summary);
                System.out.println(getSummary());    
                System.out.println("Duracao: " + getMinutes() + " minutos");
                
            
                System.out.println("Total: R$ " + (getPrice() * numOfPeople));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople));
                mt.screen(nomeDoFilme, numOfPeople);
                break;
                
                
            case 4:
                
                nomeDoFilme = "Os Incriveis";
                System.out.println(nomeDoFilme);
                summary = "Depois do governo banir o uso de superpoderes, o maior herói do planeta, o Sr. Incrível" 
                + ", vive de forma pacata com sua família. Apesar de estar feliz com a vida doméstica, o Sr. Incrível " 
                + "ainda sente falta dos tempos em que viveu como super-herói, e sua grande chance de entrar em ação " 
                + "novamente surge quando um velho inimigo volta a atacar. Só que agora ele precisa contar com a ajuda"
                 + " de toda a família para vencer o vilão.";
                setSummary(summary);
                System.out.println(getSummary());    
                System.out.println("Duracao: " + getMinutes() + " minutos");
                
            
                System.out.println("Total: R$ " + (getPrice() * numOfPeople));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople));
                mt.screen(nomeDoFilme, numOfPeople);
                break;
                
                

            case 5:
                
                nomeDoFilme = "Ta Dando Onda 2";
                System.out.println(nomeDoFilme);
                summary = "Cody Maverick está com fome de um novo desafio: ele convence o Hang 5," 
                + " um grupo infame de surfistas, a deixá-lo se juntar a eles em sua viagem a um"
                + " misterioso e lendário pico do surfe.";
                setSummary(summary);
                System.out.println(getSummary());    
                System.out.println("Duracao: " + getMinutes() + " minutos");
                
            
                System.out.println("Total: R$ " + (getPrice() * numOfPeople));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople));
                mt.screen(nomeDoFilme, numOfPeople);
                break;
                


            case 6:
                
                nomeDoFilme = "A voz do silêncio";
                System.out.println(nomeDoFilme);
                summary = "Uma estudante com problemas de audição sofre com o bullying dos colegas"
                 + " e decide mudar de escola. Anos mais tarde, um dos rapazes que a importunavam" 
                 + " resolve se redimir.";
                setSummary(summary);
                System.out.println(getSummary());    
                System.out.println("Duracao: " + getMinutes() + " minutos");
                
            
                System.out.println("Total: R$ " + (getPrice() * numOfPeople));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople));
                mt.screen(nomeDoFilme, numOfPeople);
                break;
                

            case 7:
                
                nomeDoFilme = "A Era do Gelo";
                System.out.println(nomeDoFilme);
                summary = "Vinte mil anos atrás, num mundo coberto de gelo, o mamute Manfred e" 
                + " a preguiça Sid resgatam um bebê humano órfão. Agora, os dois vão enfrentar muitas" 
                + " aventuras até devolver o filhote de gente à sua tribo, que migrou para um novo" 
                + " acampamento.";
                setSummary(summary);
                System.out.println(getSummary());    
                System.out.println("Duracao: "+getMinutes() + " minutos");
                
            
                System.out.println("Total: R$ " + (getPrice() * numOfPeople));
                buy.setTotal(buy.getTotal() + (getPrice() * numOfPeople));
                mt.screen(nomeDoFilme, numOfPeople);
                break;
                

                
            case 0: 
                room.sessions();
                break;

            

        }
        s.close();
    }
    

}