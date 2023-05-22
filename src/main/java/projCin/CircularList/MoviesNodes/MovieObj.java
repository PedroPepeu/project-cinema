package projCin.CircularList.MoviesNodes;

public class MovieObj {

    private String name;
    private String summary;
    private int duration; // minutes
    private int ID;

    public MovieObj(String name, String summary, int duration, int ID) {
        this.name = name;
        this.summary = summary;
        this.duration = duration;
        this.ID = ID;
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

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }
    
}