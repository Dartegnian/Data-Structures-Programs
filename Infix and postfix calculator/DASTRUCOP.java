import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.Stack;

public class DASTRUCOP{
    private static LinkedList <String> infixStore = new LinkedList<String>();
    private static LinkedList <String> postfixStore = new LinkedList<String>();
    private static String infix;

    private static boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
    }

    private static boolean isLowerPrecedence(char op1, char op2){
        switch (op1) {
            case '+':
            case '-':
                return !(op2 == '+' || op2 == '-');

            case '*':
            case '/':
                return op2 == '^' || op2 == '(';

            case '^':
                return op2 == '(';

            case '(':
                return true;

            default:
                return false;
        }
    }
    public static String convertToPostfix(String infix){
        Stack<Character> stack = new Stack<Character>();
        StringBuffer postfix = new StringBuffer(infix.length());
        char c;

        for(int i = 0; i < infix.length(); i++){
            c = infix.charAt(i);

            if (!isOperator(c)) postfix.append(c);
            else{
                if(c == ')'){
                    while (!stack.isEmpty() && stack.peek() != '('){
                        postfix.append(stack.pop());
                    }
                    if(!stack.isEmpty())stack.pop();
                }
                else{
                    if(!stack.isEmpty() && !isLowerPrecedence(c, stack.peek())) stack.push(c);
                    else {
                        while(!stack.isEmpty() && isLowerPrecedence(c, stack.peek())){
                            Character pop = stack.pop();
                            if (c != '(') postfix.append(pop);
                            else c = pop;
                        }
                        stack.push(c);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
    public static String storeInfix(){
        infix = JOptionPane.showInputDialog("What do you want to add?");
        infixStore.add(infix);
        return null;
    }
    public static String showInfix(){
        return infixStore.get(0);
    }
    public static String showPostfix(){
        return postfixStore.get(0);
    }
    public static String convertToPostfix(){
        if(infixStore.isEmpty()){
            JOptionPane.showMessageDialog(null, "No infixes are stored", "Empty", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            infix = infixStore.get(0);
            postfixStore.add(convertToPostfix(infixStore.get(0)));
            JOptionPane.showMessageDialog(null, "Infix converted!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    public static boolean infixStoreIsEmpty(){
        return infixStore.isEmpty();
    }
    public static boolean clearFixStore(){
        infixStore.clear();
        postfixStore.clear();
        return infixStore.isEmpty() && postfixStore.isEmpty();
    }
    public static boolean postfixStoreIsEmpty(){
        return postfixStore.isEmpty();
    }
}