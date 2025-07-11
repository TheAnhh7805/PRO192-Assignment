
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

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
    
    public void loadDictionary(){
        File D = new File("dictionary.txt");
        BasicDictionary basic = (BasicDictionary)dictionaryDecorator;
        try (BufferedReader br = new BufferedReader(new FileReader(D))) {
            String data = br.readLine();
            if(data != null && data.startsWith("DATA:")){
                basic.setData(data.substring(5).trim());
            }
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] parts = line.split(":", 3);
                if (parts.length == 3) {
                    String word = parts[0].trim();
                    int startIndex = Integer.parseInt(parts[1].trim());
                    int endIndex = Integer.parseInt(parts[2].trim());
                    String meaning = basic.getData().substring(startIndex, endIndex);
                    basic.getDictionary().put(word, new Word(meaning, startIndex, endIndex));
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
        BasicDictionary basic = (BasicDictionary)dictionaryDecorator;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(D))) {
            bw.write("DATA:"+ basic.getData());
            for (Map.Entry<String, Word> word : basic.getDictionary().entrySet()){
                bw.write(word.getKey() + ":" + word.toString());
                bw.newLine();
            }
            System.out.println("Dictionary saved to file.");
        }
        catch (IOException e) {
            System.out.println("Error saving dictionary file: " + e.getMessage());
        }
    }
}
