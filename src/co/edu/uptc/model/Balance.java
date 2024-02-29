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
            System.out.println(222);
            Iterator<String> iterator = fileAll.iterator();
            while (iterator.hasNext()) {
                System.out.println(1111);
                String line = (String) ((String) iterator.next()).split(",")[0];
                System.out.println(line + "s");
                int lineNumber = Integer.parseInt((String) ((String) iterator.next()).split(",")[1]);
                System.out.println(lineNumber + "s");

                       for (int i = 1; i < line.length(); i++) {
                           char character= line.charAt(i);
                           char characterPrevius = line.charAt(i - 1);

                           compareCharacters(character, characterPrevius, lineNumber);
                       }

            }
        }

    }

    private void compareCharacters(char character, char character1, int countLine) {
        if (character == '(' || character == ')' || character == '{' || character == '}' || character == '['
                || character == ']') {
            addCharacter(character, character1, countLine);
            comparePairToRemove(character, character1, countLine);

        }
    }

    private void comparePairToRemove(char character, char character1, int countLine) {
        if (character == ')' && character1 == '(') {
            removeCharacter();
        } else {
            if (character == '}' && character1 == '{') {
                removeCharacter();
            } else {
                if (character == ']' && character1 == '[') {
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

    private void addCharacter(char character, char characterPrevius, int countLine) {
        if (characterPrevius != '/' || characterPrevius != '*' ) {
            readPairs.push(String.valueOf(character));
            numberLine.push(countLine);
        }
    }

    public MyStack<Integer> getNumberLine() {
        return numberLine;
    }
    public MyStack<String> getReadPairs() {
        return readPairs;
    }
}
