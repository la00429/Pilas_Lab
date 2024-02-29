package co.edu.uptc.presenter;

import co.edu.uptc.model.Balance;
import co.edu.uptc.persistence.LoadData;

import java.util.Iterator;

public class Presenter {
    private LoadData loadData;
    private Balance balance;

    public Presenter() {
        loadData = new LoadData();
        balance = new Balance();
    }

    public void run (){
        balance.readFile(loadData.readTxt("data/file.java"));
        if (balance.getReadPairs().isEmpty()) {
            System.out.println("The file is balanced");
        }else{
            Iterator<Integer> iterator = balance.getNumberLine().iterator();
            while (iterator.hasNext()) {
                System.out.println("Error in line: " + iterator.next());
            }

        }
    }

    public void loadFile(){
        loadData.readTxt("data/file.java");
        Iterator<String> iterator = loadData.readTxt("data/file.java").iterator();
        while (iterator.hasNext()) {
            System.out.println("Error in line: " + iterator.next());
        }
        System.out.println(loadData.readTxt("data/file.java").toString() + "s");

    }

}
