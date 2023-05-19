package projCin.CircularList.UsersNodes;

public class UsersCircularLinkedList {

    private UserNode sentinel;
    private UserNode next;
    private UserNode previous;
    private int size;

    public UsersCircularLinkedList() {
        sentinel = new UserNode(null, null, null);
        this.sentinel.setNext(this.sentinel);
        this.sentinel.setPrevious(this.sentinel);
        
        this.size = 0;
    }

    public void addFirst(Integer value) {
        UserNode currentHead = this.sentinel.getNext();
        UserNode newHead = new UserNode(null, this.sentinel, currentHead);
        currentHead.setPrevious(newHead);
        this.sentinel.setNext(newHead);
        setSize(size() + 1);
    }

    public void addLast(Integer value) {
        UserNode currentTail = this.sentinel.getPrevious();
        UserNode newTail = new UserNode(value, currentTail, this.sentinel);
        currentTail.setNext(newTail);
        this.sentinel.setPrevious(newTail);
        setSize(size() + 1);
    }

    public void reverse() {
        if(size() < 2) return;

        UserNode previous = this.sentinel.getNext();
        UserNode current = previous.getNext();

        while(current != this.sentinel) {
            UserNode next = current.getNext();
            current.setNext(previous);
            current.setPrevious(next);
            previous = current;
            current = next;
        }

        this.sentinel.getNext().setPrevious(this.sentinel.getNext().getNext());
        this.sentinel.getNext().setNext(this.sentinel);
        
        this.sentinel.setPrevious(this.sentinel.getNext());
        this.sentinel.setNext(previous);
    }

    public void delete(UserNode nodeDelete) {
        if(nodeDelete == this.sentinel) return;

        if(nodeDelete == this.sentinel.getNext()) this.sentinel.setNext(nodeDelete.getNext());

        if(nodeDelete == this.sentinel.getPrevious()) this.sentinel.setPrevious(nodeDelete.getPrevious());

        if(nodeDelete.getPrevious() != this.sentinel) nodeDelete.getPrevious().setNext(nodeDelete.getNext());

        if(nodeDelete.getNext() != this.sentinel) nodeDelete.getNext().setPrevious(nodeDelete.getPrevious());

        setSize(size() - 1);
    }

    public boolean isOrdered(boolean ascending) {
        UserNode currentNode = this.sentinel.getNext();

        while(currentNode.getNext() != this.sentinel) {
            if(ascending) {
                if(currentNode.getValue() > currentNode.getNext().getValue()) return false;
            } else {
                if(currentNode.getValue() < currentNode.getNext().getValue()) return false;
            }
            currentNode = currentNode.getNext();
        }
        return true;
    }

    public boolean isEquals(UsersCircularLinkedList otherList) {

        if(otherList.size() != size()) return false;

        UserNode myListCurrent = this.sentinel.getNext();
        UserNode otherListCurrent = otherList.sentinel.getNext();

        while(myListCurrent != this.sentinel) {
            if(myListCurrent.getValue() != otherListCurrent.getValue()) return false; 
            myListCurrent = myListCurrent.getNext();
            otherListCurrent = otherListCurrent.getNext();
        }

        return true;
    }

    public int get(int index) throws Exception {
        try {
            index = index % size();
            UserNode current = this.sentinel.getNext();
            for(int i = 0; i < index; i++) {
                current = current.getNext();
                if(current == this.sentinel) current = current.getNext();
            }
            return current.getValue();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("List is empty");
            throw e;
        }
    }

    public int get(UserNode currentNode, int index) {
        for(int i = 0; i < index; i++) {
            currentNode = getSuccessor(currentNode);
        }
        return currentNode.getValue();
    }

    public UserNode getSuccessor(UserNode currentNode) {
        try {
            if(isEmpty()) throw new IndexOutOfBoundsException("Circular list is empty");
            UserNode successor = currentNode.getNext();
            if(successor == this.sentinel) successor = successor.getNext();
            return successor;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Circular list is empty");
            throw e;
        }
    }

    public UserNode search(int elem) {
        UserNode current = this.sentinel.getNext();

        while(current != this.sentinel) {
            if(current.getValue() == elem) return current;
            current = current.getNext();
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return this.sentinel.getNext() == this.sentinel;
    }
    
    public UserNode getNext() {
        return this.next;
    }

    public void setNext(UserNode next) {
        this.next = next;
    }

    public UserNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(UserNode previous) {
        this.previous = previous;
    }

    public UserNode getTail() {
        return this.sentinel.getPrevious();
    }

    public UserNode getSentinel() {
        return sentinel;
    }

    public void setSentinel(UserNode sentinel) {
        this.sentinel = sentinel;
    }

    public UserNode getHead() {
        return this.sentinel.getNext();
    }

}
