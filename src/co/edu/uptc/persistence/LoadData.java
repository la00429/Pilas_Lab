package co.edu.uptc.persistence;

import co.edu.uptc.structures.MyStack;
import co.edu.uptc.structures.SimpleList;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LoadData {
    public MyStack<String> readTxt(String path) {
        MyStack<String>  fileAll = new MyStack<String> ();
        File file = new File(path);
        String line;
        try (BufferedReader process = new BufferedReader(new FileReader(file))) {
            int countLine = 1;
            while ((line = process.readLine()) != null) {
                if (!line.isEmpty()) {
                    fileAll.push(line + "," + countLine);
                }
                countLine++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileAll;

    }
}
