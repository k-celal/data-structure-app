package src;

public class LSAndStack {

    public Node topNode;
    public int size;
    public int counter = 0;

    public LSAndStack(int size) {
        this.size = size;
        topNode=null;
    }
    
    public boolean  Empty() {
        return  topNode==null;
    }
    public boolean Full() {
        return (counter == size);
    }
    public void Display() {
        if(Empty())
        {
            System.out.println("Stack is empty!!!");
        }
        else
        {
            Node temp = topNode;
            while(temp != null)
            {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
        
    }
    public void push(char data) {
        if(Full())
        {
            System.out.println("Stack is full!!!");
        }
        else
        {
            Node newNode = new Node(data);
            if(topNode==null)
            {
                topNode = newNode;
                return;
            }
            newNode.next=topNode;
            topNode=newNode;
            counter++;
        }
    }
    public char pop(){
        if(Empty())
        {
            return 0;
           
        }
        else
        {
            char temp =topNode.data;
            topNode=topNode.next;
            counter--;
            return temp;
        }

    }
    public char peek()
    {
        if(Empty())
        {
            return 0;
        }
        else
        {
            return topNode.data;
        }
    }   
    public void search(char data){
        Node temp = topNode;
        int counter2=0;
        while(temp!=null)
        {
            if(temp.data==data)
            {
                System.out.println(counter2);
                return;
            }
            else{
                temp = temp.next;
                counter2++;
            }
            
        }
        System.out.println("Not Found!!!");

    }
    public void Control()
    {

    }

    public int sizeOf() {
        return 0;
    }
}
