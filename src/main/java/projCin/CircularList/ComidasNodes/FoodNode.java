package projCin.CircularList.ComidasNodes;

public class FoodNode {
    
    private FoodObj food; // food object
    private FoodNode previous; // prev Node
    private FoodNode next; // next Node

    public FoodNode(FoodObj food, FoodNode previous, FoodNode next) {
        this.food = food;
        this.next = next;
        this.previous = previous;
    }

    public void setPrevious(FoodNode previous) {
        this.previous = previous;
    }

    public FoodNode getPrevious() {
        return this.previous;
    }

    public void setNext(FoodNode next) {
        this.next = next;
    }

    public FoodNode getNext() {
        return this.next;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public FoodObj getFood() {
        return this.food;
    }

    public void setFood(FoodObj food) {
        this.food = food;
    }

}
