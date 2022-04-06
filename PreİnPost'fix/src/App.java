package src;



import java.util.Scanner;

public class App {
    public static String reverse(String expression) {
        Character[] chr = new Character[expression.length()];
        String newEx = "";
        for(int i = expression.length()-1 ; i>=0 ; i--){
            newEx+=expression.charAt(i);
        }
        for (int i = 0; i < chr.length; i++) {
            if(newEx.charAt(i)=='(')
            {
                chr[i]=')';
            }
            else if(newEx.charAt(i)==')')
            {
                chr[i]='(';
            }
            else{
                chr[i]=newEx.charAt(i);
            }
        }
        newEx="";
        for (int i = 0; i < chr.length; i++) {
            newEx+=chr[i];
        }
        
        return newEx;
    }

    public static int primacy(char kr) {
        switch (kr) {
            case '+': 
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^' :
                return 3;
        }
        return -1;
    }
    public static String infixToPrefix(String expression) {
        expression=reverse(expression);
        StackWithLS lStack = new StackWithLS(expression.length());
        String pstfix = "";
        char kr=0;

        for(int i=0 ; i<expression.length();i++){
            kr=expression.charAt(i);
            if(kr=='('){
                lStack.push(kr);
            }
            else if(kr==')'){
                while(lStack.peek() != '('){
                    pstfix += lStack.pop();
                }
                lStack.pop();
            }
            else if(primacy(kr)>0){
                while(!lStack.Empty() && (primacy((char)lStack.peek())>= primacy(kr))){
                    pstfix=pstfix+lStack.pop();
                }
                lStack.push(kr);
            }else{
                pstfix=pstfix+kr;
            }

        }
        while (!lStack.Empty()) {
            pstfix+=lStack.pop();
            
        }

        return reverse(pstfix);
    }
    public static String infixToPostfix(String expression) {
        StackWithLS lStack = new StackWithLS(expression.length());
        String pstfix = "";
        char kr=0;

        for(int i=0 ; i<expression.length();i++){
            kr=expression.charAt(i);
            if(kr=='('){
                lStack.push(kr);
            }
            else if(kr==')'){
                while(lStack.peek() != '('){
                    pstfix += lStack.pop();
                }
                lStack.pop();
            }
            else if(primacy(kr)>0){
                while(!lStack.Empty() && (primacy(lStack.peek())>= primacy(kr))){
                    pstfix=pstfix+lStack.pop();
                }
                lStack.push(kr);
            }else{
                pstfix=pstfix+kr;
            }

        }
        while (!lStack.Empty()) {
            pstfix+=lStack.pop();
            
        }
        return pstfix;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String 	expression ;
        while (true) {
           System.out.print("Please select your process\n1-)infixToPostfix\n2-)infixToPostfix\nq-)Exit\nSelect : "); 
           String select = sc.nextLine();
            if(select.equals("q")){
                break;
            }else if(select.equals("1")){
                System.out.println("Please enter the expression you want to translate into postfix.");
                expression=sc.nextLine();
                System.out.println(infixToPostfix(expression));
                

            }
            else if(select.equals("2")){
                System.out.println("Please enter the expression you want to translate into prefix.");
                expression=sc.nextLine();
                System.out.println(infixToPrefix(expression));
               
            }
        }
        sc.close();
    }
}

