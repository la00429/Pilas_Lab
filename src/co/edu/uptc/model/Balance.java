package co.edu.uptc.model;

import co.edu.uptc.structures.MyStack;
import co.edu.uptc.structures.SimpleList;

import java.util.Iterator;


public class Balance {
    private MyStack<String> readPairs;
    private MyStack<Integer> numberLine;
    private int countLine;

    public Balance() {
        this.readPairs = new MyStack<String>();
        this.numberLine = new MyStack<Integer>();
        this.countLine = 1;
    }

    public void readFile(MyStack<String> fileAll) {
        if (!fileAll.isEmpty()) {
            Iterator<String> iterator = fileAll.iterator();
            while (iterator.hasNext()) {
                String currentLine = iterator.next();
                String line = (String) ((String) currentLine).split(",")[0].replaceAll("\\s", "");
                int lineNumber = Integer.parseInt((String) ((String) currentLine).split(",")[1]);
                generateCharacter(line, lineNumber);
            }
        }
    }


    

    private void generateCharacter(String line, int countLine) {
        for (int i = 1; i < line.length(); i++) {
            char character = line.charAt(i);
            char characterPrevius = line.charAt(i - 1); 
            addCharacter(characterPrevius, character, countLine);
        }
    }

    private void addCharacter(char characterPrevius, char character, int lineNumber){
        if (readPairs.isEmpty()) {
            addCharacter(characterPrevius, countLine);
        }
        compareCharacters(character, characterPrevius, countLine);
        
    }

    private void compareCharacters(char character, char characterPrevius, int countLine) {
        if ((!Character.toString(characterPrevius).equals("/") && !Character.toString(characterPrevius).equals("*"))) {
            addCharacter(character, countLine);
            comparePairToRemove(character, characterPrevius, countLine);
        }
    }

    private void comparePairToRemove(char character, char characterPrevius, int countLine) {
        if (character == ')' && characterPrevius == '(') {
            removeCharacter();
        } else {
            if (character == '}' && characterPrevius == '{') {
                removeCharacter();
            } else {
                if (character == ']' && characterPrevius == '[') {
                    removeCharacter();
                }
            }
        }
    }

    private void removeCharacter() {
        readPairs.pop();
        readPairs.pop();
        numberLine.pop();
        numberLine.pop();
    }

    private void addCharacter(char character, int countLine) {
        if (character == '(' || character == ')' || character == '{' || character == '}' || character == '['
        || character == ']') {  
            readPairs.push(String.valueOf(character));
            numberLine.push(countLine);
        }
    }

    public MyStack<String> getReadPairs() {
        return readPairs;
    }

    public MyStack<Integer> getNumberLine() {
        return numberLine;
    }
}



