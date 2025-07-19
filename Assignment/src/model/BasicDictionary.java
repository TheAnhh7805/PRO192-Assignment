package model;


import service.DictionaryService;
import model.Word;
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
    private Map<String, Word> dictionary;
    private String data;

    public BasicDictionary(){
        this.dictionary = new HashMap<>();
        this.data = "";
    }

    public Map<String, Word> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, Word> dictionary) {
        this.dictionary = dictionary;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    @Override
    public void addWord(String word, String meaning) {
        dictionary.put(word.toLowerCase(), new Word(meaning, 0,0));
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
