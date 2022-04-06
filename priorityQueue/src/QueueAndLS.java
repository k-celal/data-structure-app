package Queue.QueueWithLS;

public class QueueAndLS {
    public Node frontNode;
    public Node rearNode;
    public int counter;
    public int counter2;
    public int size;    
    
    public QueueAndLS(int size) {
        this.size = size;
        counter = 0;
        frontNode = null;
        rearNode = null;
    }

    public boolean Full(){
        return (counter == size);

    }

    public boolean Empty() {
        return (counter==0);
    }
    public void sortQueue(int priority ,String sdata){
        if(Full()){
            System.out.println("Queue is full");
        }
        else{
            Node newNode = new Node(priority,sdata);
            if(frontNode ==null){
                frontNode=newNode;
                rearNode=newNode;
                counter++;
                return;
            }
            Node tempNode = frontNode;
            if(newNode.priority<tempNode.priority){
                newNode.next=tempNode;
                frontNode=newNode;
                counter++;
                return;
            }
            if(rearNode.priority<newNode.priority){
                rearNode.next=newNode;
                rearNode=newNode;
                counter++;
                return;
            }
            while(newNode.priority > tempNode.next.priority && tempNode.next != null){
                tempNode=tempNode.next;
            }
            newNode.next=tempNode.next;
            tempNode.next=newNode;
            counter++;

            
        }
    }
    public void enQueue(int data){
        if(Full())
        {
            System.out.println("Queue is Full!!!");
        }
        else
        {
            Node newNode = new Node(data);
            if(frontNode==null)
            {
                frontNode=newNode;
                rearNode=newNode;
                counter++;
            }
            else
            {
                rearNode.next=newNode;
                rearNode=newNode;
                counter++;
            }
        }

    }
    public void deQueue(){
        if(Empty())
        {
            System.out.println("Queue is Empty!!!");
        }
        else
        {
            System.out.println(frontNode.sdata);
            frontNode = frontNode.next;
            counter--;
        }
    }
    public void Peek(){
        if(Empty())
        {
            System.out.println("Queue is Empty!!!");
        }
        else
        {
            System.out.println("Peek : " + frontNode.sdata);
        }

    }
    public int Size(){
        return counter;
    }
}
