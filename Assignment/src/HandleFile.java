
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Acer
 */
public class HandleFile extends DictionaryDecorator {

    public HandleFile(DictionaryService dictionaryDecorator) throws IOException {
        super(dictionaryDecorator);
        loadDictionary();
    }
    
    @Override
    public void addWord(String word, String meaning) {
        dictionaryDecorator.addWord(word, meaning);
        saveDictionary();
    }

    public void loadDictionary(){
        File D = new File("dictionary.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(D))) {
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    dictionaryDecorator.addWord(parts[0].trim(), parts[1].trim());
                }
                System.out.println("Dictionary loaded from file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing dictionary file found. Starting with empty dictionary.");
        } catch (IOException e) {
            System.out.println("Error reading dictionary file: " + e.getMessage());
        }
    }
    
    public void saveDictionary(){
        File D = new File("dictionary.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(D))) {
            for (Word word : ((BasicDictionary)dictionaryDecorator).dictionary.values()){
                bw.write(word.toString());
                bw.newLine();
            }
            System.out.println("Dictionary saved to file.");
        }
        catch (IOException e) {
            System.out.println("Error saving dictionary file: " + e.getMessage());
        }
    }
}
