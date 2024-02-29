package co.edu.uptc.presenter;

import co.edu.uptc.model.Balance;
import co.edu.uptc.persistence.LoadData;
import co.edu.uptc.view.View;

import java.util.Iterator;
import java.util.Objects;

public class Presenter {
    private LoadData loadData;
    private Balance balance;
    private View view;

    public Presenter() {
        loadData = new LoadData();
        balance = new Balance();
        view = new View();
    }

    public void run (){
        balance.readFile(loadData.readTxt("data/file.java"));
        if (balance.getReadPairs().isEmpty()) {
            view.showMessage(balance.getReadPairs().isEmpty() + "The file is balanced");
        }else{
            Iterator<String> iterator = balance.getReadPairs().iterator();
            Iterator<Integer> iteratorNumber = balance.getNumberLine().iterator();
            while (iterator.hasNext()) {
                view.showMessage("Error: " + iterator.next() + iteratorNumber.next());
            }
        }
    }

}
