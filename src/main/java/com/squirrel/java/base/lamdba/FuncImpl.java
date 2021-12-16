package com.squirrel.java.base.lamdba;

import java.util.Arrays;

public class FuncImpl {


    public void Fuc1(Fuc fuc) {


    }

    public static void main(String[] args) {

        FuncImpl im = new FuncImpl();
        im.Fuc1(() -> {System.out.println("asf");return "艹";});


    }
}
