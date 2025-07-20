/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

import java.util.HashMap;
import java.util.Map;
import model.Word;
import service.BasicDictionary;
import service.DictionaryService;

/**
 *
 * @author Acer
 */
public class DeleteWord extends DictionaryDecorator{
    
    public DeleteWord(DictionaryService dictionaryDecorator) {
        super(dictionaryDecorator);
    }
    
    @Override
    public void deleteWord(String word){
        BasicDictionary basic = getBasicDictionary();
        if(word == null || word.trim().isEmpty()){
            System.out.println("Word cannot be left blank!");
            return;
        }
        if(!basic.getDictionary().containsKey(word.toLowerCase())){
            System.out.println(word+" does not exist in the dictionary!");
            return;
        }
        basic.getDictionary().remove(word.toLowerCase());
        StringBuilder newData = new StringBuilder();
        Map<String, Word> newDictionary = new HashMap<>();
        int currentIndex = 0;
        for (Map.Entry<String, Word> entry : basic.getDictionary().entrySet()) {
            String meaning  = entry.getValue().getMeaning();
            int startIndex = currentIndex;
            newData.append(meaning);
            currentIndex += meaning.length();
            int endIndex = currentIndex;
            newDictionary.put(entry.getKey(), new Word(meaning, startIndex, endIndex));
        }
        basic.setData(newData.toString());
        basic.setDictionary(newDictionary);
        DictionaryService current = this;
        while (current instanceof DictionaryDecorator) {
            if (current instanceof HandleFile) {
                ((HandleFile) current).saveDictionary();
                break;
            }
            current = ((DictionaryDecorator) current).dictionaryDecorator;
        }
        System.out.println("Delete "+ word +" in the dictionary!");
    }
    
}
