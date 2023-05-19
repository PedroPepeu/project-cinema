package projCin.CircularList.MoviesNodes;

public class MovieNode {

    private MovieObj movie;
    private MovieNode previous;
    private MovieNode next;

    public MovieNode(MovieObj movie, MovieNode previous, MovieNode next) {
        this.movie = movie;
        this.next = next;
        this.previous = previous;
    }

    public void setPrevious(MovieNode previous) {
        this.previous = previous;
    }

    public MovieNode getPrevious() {
        return this.previous;
    }

    public void setNext(MovieNode next) {
        this.next = next;
    }

    public MovieNode getNext() {
        return this.next;
    }

    public MovieObj getMovie() {
        return movie;
    }

    public void setMovie(MovieObj movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return movie.getName();
    }
    
}
