package projCin.CircularList.MoviesNodesTestando;

public class MovieNodeTeste {
    private MovieObjTeste info;
    private MovieNodeTeste prox;
    private MovieNodeTeste ant;

    public MovieNodeTeste(MovieObjTeste info) {
        this.info = info;
    }

    public MovieObjTeste getInfo() {
        return info;
    }

    public void setInfo(MovieObjTeste info) {
        this.info = info;
    }

    public MovieNodeTeste getProx() {
        return prox;
    }

    public void setProx(MovieNodeTeste prox) {
        this.prox = prox;
    }

    public MovieNodeTeste getAnt() {
        return ant;
    }
    
    public void setAnt(MovieNodeTeste ant) {
        this.ant = ant;
    }

    
}
