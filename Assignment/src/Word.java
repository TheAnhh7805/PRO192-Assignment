/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class Word {
    private String meaning;
    private int startIndex;
    private int endIndex;

    public Word(String meaning, int startIndex, int endIndex) {
        this.meaning = meaning;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }
    
    

    public String getMeaning() {
        return meaning;
    }

    @Override
    public String toString() {
        return startIndex + ":" + endIndex ;
    }


}
