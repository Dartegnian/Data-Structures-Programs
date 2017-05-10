import javax.swing.JOptionPane;
import java.util.Stack;

public class DASTRUCFIX{
    public static void main(String[] args){
        Stack<String> rene = new Stack<String>();
        DASTRUCOP operations = new DASTRUCOP();
        Object[] choices = {"Store infix", "Show infix", "Show postfix", "Convert infix to postfix", "Clear storage", "Close"};
        String decision;
        for(;;){
            decision = (String) JOptionPane.showInputDialog(null, "Please choose", "Choices", JOptionPane.PLAIN_MESSAGE, null, choices, "Infix & Postfix");
            if (decision == "Store infix"){
                DASTRUCOP.storeInfix();
                JOptionPane.showMessageDialog(null, "Infix stored!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (decision == "Show infix"){
                if(DASTRUCOP.infixStoreIsEmpty()){
                    JOptionPane.showMessageDialog(null, "No infixes are stored", "None", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, DASTRUCOP.showInfix(), "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if (decision == "Show postfix"){
                if(DASTRUCOP.postfixStoreIsEmpty()){
                    JOptionPane.showMessageDialog(null, "No postfixes are stored", "None", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, DASTRUCOP.showPostfix(), "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if (decision == "Convert infix to postfix"){
                DASTRUCOP.convertToPostfix();
            }
            else if (decision == "Clear storage"){
                DASTRUCOP.clearFixStore();
                if(DASTRUCOP.clearFixStore()){
                    JOptionPane.showMessageDialog(null, "Storage cleared!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if (decision == "Close"){
                System.exit(0);
            }
        }
    }
}