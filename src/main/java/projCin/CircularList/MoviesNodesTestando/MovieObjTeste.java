package projCin.CircularList.MoviesNodesTestando;

public class MovieObjTeste implements Comparable <MovieObjTeste> {

    private String name;
    private String summary;
    private int duration; // minutes
    private String ID;

    public MovieObjTeste(String name, String summary, int duration, String ID) {
        this.name = name;
        this.summary = summary;
        this.duration = duration;
        this.ID = ID;
    }

    public MovieObjTeste(String name, String ID) {
        this.ID = ID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String toString() {
        return "|nome do filme: " + name + ", resumo do filme: " + summary + ", duração do filme: " + duration + ", ID do filme: " + ID + "|";
    }

    public int compareTo(MovieObjTeste movie) {
        int result;
        result = this.ID.compareTo(movie.ID);
        return result;
    }
    
}
