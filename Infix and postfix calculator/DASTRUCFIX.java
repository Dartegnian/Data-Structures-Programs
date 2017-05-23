import javax.swing.JOptionPane;
import java.util.Stack;

public class DASTRUCFIX {
    public static void main(String[] args) {
        String decision;
        DASTRUCOP operations = new DASTRUCOP();
        Stack<String> rene = new Stack<String>();
        Object[] choices = {"Store infix", "Show infix", "Show postfix", "Convert infix to postfix", "Clear storage", "Close"};
        
        for (;;) {
            decision = (String) JOptionPane.showInputDialog(null, "Please choose", "Choices", JOptionPane.PLAIN_MESSAGE, null, choices, "Infix & Postfix");

            if (decision.equals("Store infix")) {
                DASTRUCOP.storeInfix();
                JOptionPane.showMessageDialog(null, "Infix stored!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (decision.equals("Show infix")) {
                if (DASTRUCOP.infixStoreIsEmpty())
                    JOptionPane.showMessageDialog(null, "No infixes are stored", "None", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, DASTRUCOP.showInfix(), "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (decision.equals("Show postfix")) {
                if (DASTRUCOP.postfixStoreIsEmpty())
                    JOptionPane.showMessageDialog(null, "No postfixes are stored", "None", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, DASTRUCOP.showPostfix(), "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (decision.equals("Convert infix to postfix")) {
                DASTRUCOP.convertToPostfix();
            }
            else if (decision.equals("Clear storage")) {
                DASTRUCOP.clearFixStore();
                if (DASTRUCOP.clearFixStore())
                    JOptionPane.showMessageDialog(null, "Storage cleared!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (decision.equals("Close"))
                System.exit(0);
        }
    }
}