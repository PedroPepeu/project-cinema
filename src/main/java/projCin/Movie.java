package projCin;

public class Movie {

    private String name;
    private int seconds;
    private String summary; // sinopse
    private double price;

    public Movie() {

    }

    public Movie(String name, int seconds, String summary, double price) {  //fazendo uma sobrecarga de construtures para ter uma com os parametros e outra sem nenhum parametro
        this.name = name;
        this.seconds = seconds;
        this.summary = summary;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
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

    

}
