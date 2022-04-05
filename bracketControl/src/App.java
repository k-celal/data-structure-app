import java.util.Scanner;

public class App {
    public static boolean control(String expression) {
        LSAndStack stack = new LSAndStack(expression.length());
        char kr = 0;

        for (int i = 0; i < expression.length(); i++) {
            kr = expression.charAt(i);
            char last;
            if (kr == '(' || kr == '{' || kr == '[') {
                stack.push(kr);
            }
            if (kr == ')' || kr == '}' || kr == ']') {
                last = stack.peek();
                if ((last == '(' && kr == ')') || (last == '{' && kr == '}') || (last == '[' && kr == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        if (stack.Empty()) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter the expression you want to check (output just type q) : ");
            String expression = sc.nextLine();
            if (expression.equals("q")) {
                break;
            } else {
                if (control(expression)) {
                    System.out.println("Hatasız");
                } else {
                    System.out.println("Hatalı");
                }
                control(expression);

            }

        }
        sc.close();
    }

}
