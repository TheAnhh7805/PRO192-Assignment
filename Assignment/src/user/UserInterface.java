package user;


import decorator.DictionaryDecorator;
import decorator.HandleFile;
import service.DictionaryService;
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

    private final Scanner sc;

    public UserInterface(DictionaryService dictionaryDecorator) {
        super(dictionaryDecorator);
        this.sc = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("=== Dictionary Program ===");
            System.out.println("1. Add word");
            System.out.println("2. Search word");
            System.out.println("3. Exit");
            System.out.print("Select function (1-3): ");
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
                    System.out.println(lookupWord(word1));
                    break;
                case 3:
                    System.out.println("Exit!");
                    DictionaryService current = dictionaryDecorator;
                    while (current instanceof DictionaryDecorator) {
                        if (current instanceof HandleFile) {
                            ((HandleFile) current).saveDictionary();
                            break;
                        }
                        current = ((DictionaryDecorator) current).dictionaryDecorator;
                    }
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

}
