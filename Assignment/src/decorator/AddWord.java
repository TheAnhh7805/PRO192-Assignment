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
public class AddWord extends DictionaryDecorator {

    public AddWord(DictionaryService dictionaryDecorator) {
        super(dictionaryDecorator);
    }

    @Override
    public void addWord(String word, String meaning) {
        BasicDictionary basic = getBasicDictionary();
        if (word.isEmpty() || meaning.isEmpty()) {
            System.out.println("Word or meaning cannot be left blank!");
            return;
        }
        if (basic.getDictionary().containsKey(word)) {
            System.out.println(word + " already exists in the dictionary!");
            return;
        }
        dictionaryDecorator.addWord(word, meaning);
        System.out.println("Added word:" + word);
    }

}
