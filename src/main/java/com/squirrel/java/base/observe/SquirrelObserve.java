package com.squirrel.java.base.observe;

public class SquirrelObserve extends Observe {

    public SquirrelObserve(Subject subject) {
        this.subject = subject;
        this.subject.addObserve(this);
    }

    @Override
    protected void action() {
        System.out.println("我观察到你了  兄嘚:" + this.subject.getState());

    }
}
