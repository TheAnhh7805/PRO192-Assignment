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
        BasicDictionary basic = (BasicDictionary) dictionaryDecorator;
        if (word.isEmpty() || meaning.isEmpty()) {
            System.out.println("Word or meaning cannot be left blank!");
            return;
        }
        if (basic.getDictionary().containsKey(word)) {
            System.out.println(word + " already exists in the dictionary!");
            return;
        }
        int startIndex;
        int endIndex;
        if (basic.getDictionary().isEmpty()) {
            startIndex = 0;
            endIndex = meaning.length();
            basic.setData(meaning);
        } else {
            int maxEndIndex = 0;
            for (Word x : basic.getDictionary().values()) {
                if (x.getEndIndex() > maxEndIndex) {
                    maxEndIndex = x.getEndIndex();
                }
            }
            startIndex = maxEndIndex + 1;
            endIndex = startIndex = meaning.length() - 1;
            basic.setData(basic.getData() + meaning);
        }
        basic.getDictionary().put(word, new Word(meaning, startIndex, endIndex));
        System.out.println("Added word:" + word);
    }

}
