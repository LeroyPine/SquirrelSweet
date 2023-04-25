package com.squirrel.java.algorithm.design;

import org.apache.commons.compress.utils.Lists;

import java.util.*;

public class RoundRobin {

    List<String> ipList = Arrays.asList("one", "two");
    List<Integer> partition = Arrays.asList(1, 2, 3, 4);

    public void round() {

        Map<String, List<Integer>> ip2ParMap = new HashMap<>();
        int index = 0;

        for (Integer par : partition) {
            if (index >= ipList.size()) {
                index = 0;
            }
            String ipNode = ipList.get(index);
            List<Integer> nodes = ip2ParMap.get(ipNode);
            if (nodes != null) {
                nodes.add(par);
            } else {
                nodes = new ArrayList<>();
                nodes.add(par);
                ip2ParMap.put(ipNode, nodes);
            }
            index++;
        }
        System.out.println(ip2ParMap);


    }

    public static void main(String[] args) {
        RoundRobin roundRobin = new RoundRobin();
        roundRobin.round();
    }
}
