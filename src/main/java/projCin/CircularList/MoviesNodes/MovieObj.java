package projCin.CircularList.MoviesNodes;

public class MovieObj {

    private String name;
    private String summary;
    private int duration;

    public MovieObj(String name, String summary, int duration) {
        this.name = name;
        this.summary = summary;
        this.duration = duration;
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
    
}
