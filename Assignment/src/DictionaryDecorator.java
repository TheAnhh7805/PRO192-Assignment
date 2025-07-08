/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public abstract class DictionaryDecorator implements DictionaryService{
    protected DictionaryService dictionaryDecorator;

    public DictionaryDecorator(DictionaryService dictionaryDecorator) {
        this.dictionaryDecorator = dictionaryDecorator;
    }
    
}
