import java.util.ArrayList;
import java.util.Scanner;

//This class is created to help myself streamline my future coding projects.
//By creating this class, it eliminates the need to create scanners other places

//To use this class it is required to create an instance of this class.
//This can fx look like the following:
//TextUI ui = new TextUI();
//After this, it is possible to call these methods via the following syntax: ui.methodName(parameters);

public class TextUI {
    Scanner scan = new Scanner(System.in);

    public String promptText(String msg) {
        System.out.println(msg);
        return scan.nextLine();
    }

    public int promptNumeric(String msg) {
        System.out.println(msg);
        return scan.nextInt();
    }

    public void displayList(ArrayList<String> list, String msg, boolean numbered) {
        int count = 0;
        System.out.println(msg);
        for (int i = 0; i < list.size(); i++) {
            String s = numbered ? i + 1 + ". " + list.get(i) : list.get(i);
            System.out.println(s);
        }
    }

    public ArrayList<String> promptChoice(ArrayList<String> options, int limit, String msg) {
        ArrayList<String> choices = new ArrayList<>();
        while(choices.size() < limit) {
            int input = this.promptNumeric(msg);
            if (input > 0 && input <= options.size()) {
                String choice = options.get(input - 1);
                choices.add(choice);
            } else {
                System.out.println("Input not found in list");
            }
        }
        return choices;
    }
}