import java.util.LinkedList;
import javax.swing.JOptionPane;
import java.io.*;

public class DastrucOne {
    public static void main(String[] args) {
        Object[] choices = {"Add", "Remove", "Print", "Clear list", "View list"};
        Object[] finalChoices = {"Go again", "Close"};
        LinkedList <String> lList = new LinkedList<String>();
        String listStr = new String();
        String finalOption;
        String removeditem;
        String outputStr;
        String printWhat;
        String printThis;
        String decision;
        String additem;
        int countR = 0;

        for (;;) {
            decision = (String) JOptionPane.showInputDialog(null, "Please choose", "Choices", JOptionPane.PLAIN_MESSAGE, null, choices, "Choose");

            if (decision.equals("Add")) {
                additem = JOptionPane.showInputDialog("What do you want to add?");
                if (additem.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You can't leave this field empty.", "Empty field", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    lList.add(additem);
                    for (String X : lList) {
                        countR++;
                        listStr += countR + ". " + X + "\n";
                    }
                    JOptionPane.showMessageDialog(null, listStr, "Here is your list", JOptionPane.PLAIN_MESSAGE);
                    listStr = "";
                    countR = 0;
                }
            }
            else if (decision.equals("Remove")) {
                if (lList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You have nothing to remove because you currently don't have any items in your list.", "No items", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    removeditem = (String) JOptionPane.showInputDialog(null, "Please choose an item to remove", "Remove item", JOptionPane.PLAIN_MESSAGE, null, lList.toArray(), "Remove");
                    lList.remove(removeditem);
                    if (lList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You currently don't have any items in your list.", "No items", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        for (String X : lList) {
                            countR++;
                            listStr += countR + ". " + X + "\n";
                        }
                        JOptionPane.showMessageDialog(null, listStr, "Here is your list", JOptionPane.PLAIN_MESSAGE);
                        listStr = "";
                        countR = 0;
                    }
                }
            }
            else if (decision.equals("Print")) {
                printWhat = (String) JOptionPane.showInputDialog(null, "Here are your choices", "Choices", JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Print everything to a file", "Print everything", "Print only one item"}, "Print");
                if (printWhat.equals("Print everything to a file")) {
                    if (lList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You can't print anything because you currently don't have any items in your list.", "No items", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        BufferedWriter bufferedWriter = null;
                        outputStr =
                                "Here is your list" + "\n\n"
                                        + "Number of items in your list: " + lList.size() + "\n"
                                        + "Items in your list:"
                        ;
                        try {
                            FileWriter fileWrite = new FileWriter("Output.txt", true);
                            BufferedWriter bufferedWrite = new BufferedWriter(fileWrite);
                            PrintWriter out = new PrintWriter(bufferedWrite);

                            out.println(outputStr);
                            out.close();
                        }
                        catch (IOException e) {
                        }
                        for (String Z:lList) {
                            try {
                                FileWriter fileWrite = new FileWriter("Output.txt", true);
                                BufferedWriter bufferedWrite = new BufferedWriter(fileWrite);
                                PrintWriter out = new PrintWriter(bufferedWrite);

                                out.println(Z);
                                out.close();
                            }
                            catch (IOException e) {
                            }
                        }
                        try {
                            FileWriter fileWrite = new FileWriter("Output.txt", true);
                            BufferedWriter bufferedWrite = new BufferedWriter(fileWrite);
                            PrintWriter out = new PrintWriter(bufferedWrite);

                            out.println("\n\n");
                            out.close();
                        }
                        catch (IOException e) {
                        }
                        JOptionPane.showMessageDialog(null, "Your list has been printed.\nPlease look for an Output.txt file in the root directory.", "List successfully printed", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else if (printWhat.equals("Print everything")) {
                    if (lList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You can't print anything because you currently don't have any items in your list.", "No items", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        for (String Xman : lList) {
                            System.out.println(Xman);
                        }
                    }
                }
                else if (printWhat.equals("Print only one item")) {
                    if (lList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You can't print anything because you currently don't have any items in your list.", "No items", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        printThis = (String) JOptionPane.showInputDialog(null, "Select an item from the list to print", "Choices", JOptionPane.PLAIN_MESSAGE, null, lList.toArray(), "Print");
                        System.out.println(printThis);
                    }
                }
            }
            else if (decision.equals("Clear list")) {
                if (lList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You have nothing to clear because you currently don't have any items in your list.", "No items", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    lList.clear();
                    JOptionPane.showMessageDialog(null, "Your list has been cleared", "List cleared", JOptionPane.PLAIN_MESSAGE);
                }
            }
            else if (decision.equals("View list")) {
                if (lList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You have nothing to view because you currently don't have any items in your list.", "No items", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    for (String X : lList) {
                        countR++;
                        listStr += countR + ". " + X + "\n";
                    }
                    JOptionPane.showMessageDialog(null, listStr, "Here is your list", JOptionPane.PLAIN_MESSAGE);
                    listStr = "";
                    countR = 0;
                }
            }

            finalOption = (String) JOptionPane.showInputDialog(null, "What do you want to do now?", "Choices", JOptionPane.PLAIN_MESSAGE, null, finalChoices, "Final choices");

            if (finalOption.equals("Close"))
                System.exit(0);
        }
    }
}