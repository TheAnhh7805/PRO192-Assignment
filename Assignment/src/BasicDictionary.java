
import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class BasicDictionary implements DictionaryService{
    protected Map<String, Word> dictionary;

    public BasicDictionary(){
        dictionary = new HashMap<>();
    }
    
    
    @Override
    public void addWord(String word, String meaning) {
        dictionary.put(word.toLowerCase(), new Word(word, meaning));
    }

    @Override
    public String lookupWord(String word) {
        Word foundWord = dictionary.get(word.toLowerCase());
        if(foundWord != null){
            return foundWord.getMeaning();
        }
        else return word + "not found in dictionary";
    }
    
}
