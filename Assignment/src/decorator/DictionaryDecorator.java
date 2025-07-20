package decorator;


import service.BasicDictionary;
import service.DictionaryService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public abstract class DictionaryDecorator implements DictionaryService{
    public DictionaryService dictionaryDecorator;

    public DictionaryDecorator(DictionaryService dictionaryDecorator) {
        this.dictionaryDecorator = dictionaryDecorator;
    }
    
    @Override
    public void addWord(String word, String meaning){
        dictionaryDecorator.addWord(word, meaning);
    }
    
    @Override
    public String lookupWord(String word){
        return dictionaryDecorator.lookupWord(word);
    }
    public BasicDictionary getBasicDictionary(){
        DictionaryService current = dictionaryDecorator;
        while(current instanceof DictionaryDecorator){
            current= ((DictionaryDecorator) current).dictionaryDecorator;
        }
        
        return (BasicDictionary) current;
    }
}
