package com.squirrel.java.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParent {


    public static void main(String[] args) {
        GenerateParent parent = new GenerateParent();
        parent.generateParenthesis(2);
    }

    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(new StringBuilder(),n,n);
        return res;
    }

    private void backtrack(StringBuilder sb,int cntl,int cntr){
        if(cntr<cntl) return;
        if(cntl<0||cntr<0) return;

        if(cntl==0&&cntr==0){
            res.add(sb.toString());
            return;
        }

        sb.append('(');
        backtrack(sb,cntl-1,cntr);
        sb.deleteCharAt(sb.length()-1);

        sb.append(')');
        backtrack(sb,cntl,cntr-1);
        sb.deleteCharAt(sb.length()-1);
    }
}
