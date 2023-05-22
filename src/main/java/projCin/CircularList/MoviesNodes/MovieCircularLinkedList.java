package projCin.CircularList.MoviesNodes;

public class MovieCircularLinkedList {

    private MovieNode sentinel;
    private MovieNode next;
    private MovieNode previous;
    private int size;

    public MovieCircularLinkedList() {
        sentinel = new MovieNode(null, null, null);
        this.sentinel.setNext(this.sentinel);
        this.sentinel.setPrevious(this.sentinel);
        
        this.size = 0;
    }

    public void addFirst(String name, String summary, int duration, int ID) {
        MovieObj currentMovie = new MovieObj(name, summary, duration, ID);
        MovieNode currentHead = this.sentinel.getNext();
        MovieNode newHead = new MovieNode(currentMovie, this.sentinel, currentHead);
        currentHead.setPrevious(newHead);
        this.sentinel.setNext(newHead);
        setSize(size() + 1);
    } // add in first position

    public void addLast(String name, String summary, int duration, int ID) {
        MovieObj currentMovie = new MovieObj(name, summary, duration, ID);
        MovieNode currentTail = this.sentinel.getPrevious();
        MovieNode newTail = new MovieNode(currentMovie, currentTail, this.sentinel);
        currentTail.setNext(newTail);
        this.sentinel.setPrevious(newTail);
        setSize(size() + 1);
    } // add in last position

    public void delete(MovieNode nodeDelete) {
        if(nodeDelete == this.sentinel) return;

        if(nodeDelete == this.sentinel.getNext()) this.sentinel.setNext(nodeDelete.getNext());

        if(nodeDelete == this.sentinel.getPrevious()) this.sentinel.setPrevious(nodeDelete.getPrevious());

        if(nodeDelete.getPrevious() != this.sentinel) nodeDelete.getPrevious().setNext(nodeDelete.getNext());

        if(nodeDelete.getNext() != this.sentinel) nodeDelete.getNext().setPrevious(nodeDelete.getPrevious());

        setSize(size() - 1);
    } // delete a node

    public MovieNode getSuccessor(MovieNode currentNode) {
        try {
            if(isEmpty()) throw new IndexOutOfBoundsException("Circular list is empty");
            MovieNode successor = currentNode.getNext();
            if(successor == this.sentinel) successor = successor.getNext();
            return successor;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Circular list is empty");
            throw e;
        }
    } // return the next node

    // MCLL.delete(MCLL.search(os 3 rian pepeu e marone))

    public MovieNode search(int elem) {
        MovieNode current = this.sentinel.getNext();

        while(current != this.sentinel) {
            if(current.getMovie().getID() == elem) return current;
            current = current.getNext();
        }
        return null;
    } // search for an node from the movie name, I want to change for some code, qnt de letras

    public int size() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return this.sentinel.getNext() == this.sentinel;
    } // boolean if the node is empty
    
    public MovieNode getNext() {
        return this.next;
    }

    public void setNext(MovieNode next) {
        this.next = next;
    }

    public MovieNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(MovieNode previous) {
        this.previous = previous;
    }

    public MovieNode getTail() {
        return this.sentinel.getPrevious();
    }

    public MovieNode getSentinel() {
        return sentinel;
    }

    public void setSentinel(MovieNode sentinel) {
        this.sentinel = sentinel;
    }

    public MovieNode getHead() {
        return this.sentinel.getNext();
    }
    
}
