package service;


import java.util.HashMap;
import java.util.Map;
import model.Word;

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
    private StringBuilder data;

    public BasicDictionary(){
        this.dictionary = new HashMap<>();
        this.data = new StringBuilder();
    }

    public Map<String, Word> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, Word> dictionary) {
        this.dictionary = dictionary;
    }

    public StringBuilder getData() {
        return data;
    }

    public void setData(String data) {
        this.data = new StringBuilder(data);
    }
    
    
    @Override
    public void addWord(String word, String meaning) {
        int startIndex = data.length();
        data.append(meaning);
        int endIndex = data.length();
        dictionary.put(word.toLowerCase(), new Word(meaning, startIndex,endIndex));
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
