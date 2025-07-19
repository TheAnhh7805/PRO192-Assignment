package decorator;


import service.BasicDictionary;
import service.DictionaryService;
import model.Word;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class SearchWord extends DictionaryDecorator {

    public SearchWord(DictionaryService dictionaryDecorator) {
        super(dictionaryDecorator);
    }

    @Override
    public String lookupWord(String word) {
        BasicDictionary basic = getBasicDictionary();
        if (word.trim().isEmpty()) {
            return "Word cannot be left blank!";
        }
        Word foundWord = basic.getDictionary().get(word);
        if (foundWord != null) {
            return foundWord.getMeaning();
        } else {
            return word + " does not exist in the dictionary!";
        }
    }
}
