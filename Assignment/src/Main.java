
import user.UserInterface;
import decorator.HandleFile;
import decorator.AddWord;
import decorator.DeleteWord;
import decorator.SearchWord;
import service.BasicDictionary;
import service.DictionaryService;
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
        DictionaryService basic = new BasicDictionary();
        basic = new HandleFile(basic);
        basic = new AddWord(basic);
        basic = new SearchWord(basic);
        basic = new DeleteWord(basic);
        basic = new UserInterface(basic);
        
        ((UserInterface) basic).run();
    }
    
}
