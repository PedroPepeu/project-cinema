package projCin;

//Para olhar sobre os filmes
//Movies vai entrar qnd for especificar uma sala
public class Movie {

    private String name;
    private int minutes;//
    private String summary; // sinopse
    private double price;

    public Movie() {

    }

    public Movie(String name, int minutes, String summary, double price) {  //fazendo uma sobrecarga de construtures para ter uma com os parametros e outra sem nenhum parametro
        this.name = name;
        this.minutes = minutes;
        this.summary = summary;
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

    
    

    /*public void catalogScreem(){
        Movie[][] catalog = new Movie[7][1];
        Movie[0][0] = new Movie("A Era do Gelo 5", 90, );
        

    }*/
    

}
