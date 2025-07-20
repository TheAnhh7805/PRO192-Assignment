package decorator;

import service.BasicDictionary;
import service.DictionaryService;
import model.Word;
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

    private static final String FILE_PATH = "dictionary.txt";
    private static final String FILE_DATA = "data.txt";

    public HandleFile(DictionaryService dictionaryDecorator) throws IOException {
        super(dictionaryDecorator);
        loadDictionary();
    }

    public void loadDictionary() {
        File D = new File(FILE_PATH);
        File F = new File(FILE_DATA);
        BasicDictionary basic = getBasicDictionary();
        try (BufferedReader br = new BufferedReader(new FileReader(F))) {
            String data = br.readLine();
            if (data != null && data.startsWith("DATA:")) {
                basic.setData(data.substring(5).trim());
            }
            try (BufferedReader br1 = new BufferedReader(new FileReader(D))) {
                while (true) {
                    String line = br1.readLine();
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
                }
                System.out.println("Dictionary loaded from file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing dictionary file found. Starting with empty dictionary.");
        } catch (IOException e) {
            System.out.println("Error reading dictionary file: " + e.getMessage());
        }
    }

    public void saveDictionary() {
        File D = new File(FILE_PATH);
        BasicDictionary basic = getBasicDictionary();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(D))) {
            for (Map.Entry<String, Word> word : basic.getDictionary().entrySet()) {
                Word tmp = word.getValue();
                bw.write(word.getKey() + ":" + tmp.getStartIndex() + ":" + tmp.getEndIndex());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving dictionary file: " + e.getMessage());
        }
        File F = new File(FILE_DATA);
        try (BufferedWriter bw1 = new BufferedWriter(new FileWriter(F))) {
            bw1.write("DATA:" + basic.getData());
            System.out.println("Dictionary saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving dictionary file: " + e.getMessage());
        }
    }
}
