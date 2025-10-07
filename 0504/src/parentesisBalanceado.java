import java.util.Stack;
import java.util.*;
public class parentesisBalanceado {
    static void parentesis(String s){
        Stack<Character> stack = new Stack<Character>();
        char[] char1 = s.toCharArray();
        for(int i = 0; i < char1.length; i++){
            stack.push(char1[i]);
        }
        if(stack.peek() == '('){
            stack.pop();
            if(stack.empty() || stack.peek() != ')'){
                System.out.println("NO");
            }
        }
        else if(stack.peek() == '{'){
            stack.pop();
            if(stack.empty() || stack.peek() != '}'){
                System.out.println("NO");
            }
        }
        else if(stack.peek() == '['){
            stack.pop();
            if(stack.empty() || stack.peek() != ']'){
                System.out.println("NO");
            }
        }
        else{
            System.out.println("YES");
        }
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        parentesis(s);
    }
}