package service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public interface DictionaryService {
    void addWord(String word, String meaning);
    String lookupWord(String word);
    void deleteWord(String word);
}
