package Queue.QueueWithLS;

public class Node {
    public int priority;
    public String sdata;
    public Node next;

    public Node(int priority , String sdata) {
        this.priority = priority;
        this.sdata= sdata;
        next=null;
    }
        
}
