package projCin.CircularList.ComidasNodes;

public class FoodCircularLinkedList {

    private FoodNode sentinel;
    private FoodNode next;
    private FoodNode previous;
    private int size;

    public FoodCircularLinkedList() {
        sentinel = new FoodNode(null, 'U', 0, null, null); // sentinel is a null node, the U letter is to add as unique size, so in node null, I added as U ass null
        this.sentinel.setNext(this.sentinel);
        this.sentinel.setPrevious(this.sentinel);
        
        this.size = 0;
    }

    public void addFirst(String name, char size, double price) {
        FoodNode currentHead = this.sentinel.getNext();
        FoodNode newHead = new FoodNode(name, size, price, this.sentinel, currentHead);
        currentHead.setPrevious(newHead);
        this.sentinel.setNext(newHead);
        setSize(size() + 1);
    } // add as first position

    public void addLast(String name, char size, double price) {
        FoodNode currentTail = this.sentinel.getPrevious();
        FoodNode newTail = new FoodNode(name, size, price, currentTail, this.sentinel);
        currentTail.setNext(newTail);
        this.sentinel.setPrevious(newTail);
        setSize(size() + 1);
    } // add as last position

    public void reverse() {
        if(size() < 2) return;

        FoodNode previous = this.sentinel.getNext();
        FoodNode current = previous.getNext();

        while(current != this.sentinel) {
            FoodNode next = current.getNext();
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

    public void delete(FoodNode nodeDelete) {
        if(nodeDelete == this.sentinel) return;

        if(nodeDelete == this.sentinel.getNext()) this.sentinel.setNext(nodeDelete.getNext());

        if(nodeDelete == this.sentinel.getPrevious()) this.sentinel.setPrevious(nodeDelete.getPrevious());

        if(nodeDelete.getPrevious() != this.sentinel) nodeDelete.getPrevious().setNext(nodeDelete.getNext());

        if(nodeDelete.getNext() != this.sentinel) nodeDelete.getNext().setPrevious(nodeDelete.getPrevious());

        setSize(size() - 1);
    } // delete the node

    // public int get(int index) throws Exception {
    //     try {
    //         index = index % size();
    //         FoodNode current = this.sentinel.getNext();
    //         for(int i = 0; i < index; i++) {
    //             current = current.getNext();
    //             if(current == this.sentinel) current = current.getNext();
    //         }
    //         return current.getValue();
    //     } catch (IndexOutOfBoundsException e) {
    //         System.out.println("List is empty");
    //         throw e;
    //     }
    // }

    // public int get(FoodNode currentNode, int index) {
    //     for(int i = 0; i < index; i++) {
    //         currentNode = getSuccessor(currentNode);
    //     }
    //     return currentNode.getValue();
    // }

    public FoodNode getSuccessor(FoodNode currentNode) {
        try {
            if(isEmpty()) throw new IndexOutOfBoundsException("Circular list is empty");
            FoodNode successor = currentNode.getNext();
            if(successor == this.sentinel) successor = successor.getNext();
            return successor;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Circular list is empty");
            throw e;
        }
    } // get the next node

    public FoodNode search(String name) {
        FoodNode current = this.sentinel.getNext();

        while(current != this.sentinel) {
            if(current.getName() == name && current != null) return current;
            current = current.getNext();
        }
        return null;
    } // search for a node from the name (I want to change dor cpf)

    public int size() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return this.sentinel.getNext() == this.sentinel;
    } // if is empty
    
    public FoodNode getNext() {
        return this.next;
    }

    public void setNext(FoodNode next) {
        this.next = next;
    }

    public FoodNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(FoodNode previous) {
        this.previous = previous;
    }

    public FoodNode getTail() {
        return this.sentinel.getPrevious();
    }

    public FoodNode getSentinel() {
        return sentinel;
    }

    public void setSentinel(FoodNode sentinel) {
        this.sentinel = sentinel;
    }

    public FoodNode getHead() {
        return this.sentinel.getNext();
    }
    
}
