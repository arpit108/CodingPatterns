package linkedlistproblems;

public class LinkedList {
    int data;
    LinkedList next;

    public LinkedList(int data, LinkedList next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
