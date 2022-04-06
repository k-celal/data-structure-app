package Queue.QueueWithLS;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the size of the queue you want to create : ");
        int size = sc.nextInt();
        sc.nextLine();
        QueueAndLS qLs = new QueueAndLS(size);

        while(true){
            System.out.print("Please select your process\n1-)enQueue\n2-)deQueue\n3-)Empty\n4-)Full\nSelect : ");
            String select = sc.next();
            if(select.equals("q"))
            {
                break;
            }
            else if(select.equals("1"))
            {
                System.out.print("Please enQueue elements string data : ");
                String sdata = sc.next();
                
                System.out.print("Please enQueue elements priority : ");
                int priority = sc.nextInt();
                sc.nextLine();
                qLs.sortQueue(priority,sdata);
            }
            else if(select.equals("2"))
            {
                qLs.deQueue();
            }
            else if(select.equals("3")){
                if(qLs.Empty())
                {
                    System.out.println("Queue is empty");
                }
                else{
                    System.out.println("Queue is not empty");
                }
            }
            else if(select.equals("4")){
                if(qLs.Full())
                {
                    System.err.println("Queue is Full");
                }
                else{
                    System.out.println("Queue is not Full");
                }
            }
            else{
                System.out.println("Mistake wrong choice");
            }
        }
        sc.close(); 
    }
    
}
