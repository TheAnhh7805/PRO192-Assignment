
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        DictionaryService basic = new BasicDictionary();
        basic = new AddWord(basic);
        basic = new HandleFile(basic);
        basic = new UserInterface(basic);
        ((UserInterface) basic).run();
    }
    
}
