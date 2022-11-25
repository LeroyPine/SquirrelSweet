package com.squirrel.java.algorithm.design;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squirrel.java.entity.Chain;
import com.squirrel.java.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 构建链
 *
 * @author luobaosong
 * @date 2022/11/19 21:46
 * @description
 **/
@Slf4j
public class BuildChain {

    public static void main(String[] args) {

        List<Chain> chainList = new ArrayList<>();
        Chain chain2 = new Chain(1, 0);
        Chain chain3 = new Chain(2, 1);
        Chain chain4 = new Chain(3, 2);
        Chain chain9 = new Chain(8, 3);
        Chain chain5 = new Chain(4, 2);
        Chain chain6 = new Chain(5, 4);
        Chain chain7 = new Chain(6, 5);
        Chain chain8 = new Chain(7, 6);
        chainList.add(chain8);
        chainList.add(chain2);
        chainList.add(chain3);
        chainList.add(chain4);
        chainList.add(chain5);
        chainList.add(chain6);
        chainList.add(chain9);
        chainList.add(chain7);

        List<List<Integer>> result = getChainList(chainList);
        log.info("result:{}", JSON.toJSONString(result));
    }

    /*
       id
       preId

       1-2-3-4-5
       1-2-6-7-8

       1-2-3-4-5-6-7-8
     */

    public static List<List<Integer>> result = new ArrayList<>();

    public static List<Integer> track = new LinkedList<>();


    private static List<List<Integer>> getChainList(List<Chain> chainList) {

        Set<Integer> depIdSet = chainList.stream().map(Chain::getPreId).collect(Collectors.toSet());

        // 自底向上哈哈
        getChain(chainList, depIdSet);

        return result;
    }

    private static void getChain(List<Chain> chainList, Set<Integer> depIdSet) {
        for (Chain chain : chainList) {
            if (depIdSet.contains(chain.getId())) {
                continue;
            }
            buildChain(chain, chainList);
        }
    }

    private static void buildChain(Chain chain, List<Chain> chainList) {
        track.add(0, chain.getId());
        if (chain.getPreId() == 0) {
            result.add(new ArrayList<>(track));
            track = new LinkedList<>();
            return;
        }
        for (Chain ain : chainList) {
            // 如果有依赖当前节点的那么直接过滤掉
            if (chain.getPreId().equals(ain.getId())) {
                buildChain(ain, chainList);
            }
        }
    }
}
