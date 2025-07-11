
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Acer
 */
public class UserInterface extends DictionaryDecorator {

    private Scanner sc;

    public UserInterface(DictionaryService dictionaryDecorator) {
        super(dictionaryDecorator);
        this.sc = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("=== Dictionary Program ===");
            System.out.println("1. Add word");
            System.out.println("2. Remove word");
            System.out.println("3. Exit");
            System.out.print("Select function (1-6): ");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number from 1 to 3!");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Enter word: ");
                    String word = sc.nextLine().trim();
                    System.out.println("Enter meaning: ");
                    String meaning = sc.nextLine().trim();
                    addWord(word, meaning);
                    break;
                case 2:
                    System.out.println("Enter word: ");
                    String word1 = sc.nextLine();
                    lookupWord(word1);
                    break;
                case 3:
                    System.out.println("Exit!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

}
