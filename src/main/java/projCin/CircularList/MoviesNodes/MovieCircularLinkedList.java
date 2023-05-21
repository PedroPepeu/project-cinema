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

    public void addFirst(Integer value) {
        MovieNode currentHead = this.sentinel.getNext();
        MovieNode newHead = new MovieNode(null, this.sentinel, currentHead);
        currentHead.setPrevious(newHead);
        this.sentinel.setNext(newHead);
        setSize(size() + 1);
    } // add in first position

    public void addLast(Integer value) {
        MovieNode currentTail = this.sentinel.getPrevious();
        MovieNode newTail = new MovieNode(null, currentTail, this.sentinel);
        currentTail.setNext(newTail);
        this.sentinel.setPrevious(newTail);
        setSize(size() + 1);
    } // add in last position

    public void reverse() {
        if(size() < 2) return;

        MovieNode previous = this.sentinel.getNext();
        MovieNode current = previous.getNext();

        while(current != this.sentinel) {
            MovieNode next = current.getNext();
            current.setNext(previous);
            current.setPrevious(next);
            previous = current;
            current = next;
        }

        this.sentinel.getNext().setPrevious(this.sentinel.getNext().getNext());
        this.sentinel.getNext().setNext(this.sentinel);
        
        this.sentinel.setPrevious(this.sentinel.getNext());
        this.sentinel.setNext(previous);
    } // reverse the LinkedList

    public void delete(MovieNode nodeDelete) {
        if(nodeDelete == this.sentinel) return;

        if(nodeDelete == this.sentinel.getNext()) this.sentinel.setNext(nodeDelete.getNext());

        if(nodeDelete == this.sentinel.getPrevious()) this.sentinel.setPrevious(nodeDelete.getPrevious());

        if(nodeDelete.getPrevious() != this.sentinel) nodeDelete.getPrevious().setNext(nodeDelete.getNext());

        if(nodeDelete.getNext() != this.sentinel) nodeDelete.getNext().setPrevious(nodeDelete.getPrevious());

        setSize(size() - 1);
    } // delete a node

    public String get(int index) throws Exception {
        try {
            index = index % size();
            MovieNode current = this.sentinel.getNext();
            for(int i = 0; i < index; i++) {
                current = current.getNext();
                if(current == this.sentinel) current = current.getNext();
            }
            return current.getMovie().getName();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("List is empty");
            throw e;
        }
    } // do not need to use

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

    public MovieNode search(String elem) {
        MovieNode current = this.sentinel.getNext();

        while(current != this.sentinel) {
            if(current.getMovie().getName().equals(elem)) return current;
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
