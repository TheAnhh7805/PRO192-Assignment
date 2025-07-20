/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

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
    
    public void deleteWord(String word){
        BasicDictionary basic = getBasicDictionary();
        if(word == null || word.trim().isEmpty()){
            System.out.println("Word cannot be left blank!");
            return;
        }
        if(!basic.getDictionary().containsKey(word.toLowerCase())){
            System.out.println(word+" does not exist in the dictionary!");
        }
    }
    
}
