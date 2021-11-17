package com.squirrel.java.base.observe;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observe> observeList = new ArrayList<>();

    private int state;


    public void setState(int state) {
        this.state = state;
        notifyObserve(observeList);
    }

    private void notifyObserve(List<Observe> observeList) {
        for (Observe observe : observeList) {
            observe.action();
        }
    }

    // 监听者

    public void addObserve(Observe observe) {
        observeList.add(observe);
    }


    public List<Observe> getObserveList() {
        return observeList;
    }

    public void setObserveList(List<Observe> observeList) {
        this.observeList = observeList;
    }

    public int getState() {
        return state;
    }
}
