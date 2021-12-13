package com.squirrel.java.parse;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class ParseJson {

    List<Category> categories;
    List<Node> nodes;
    List<Link> links;

    ParseJson parseJson;

    ParseJson() {
    }

    public static void main(String[] args) {

        ParseJson parseJson = JSON.parseObject("", ParseJson.class);
        Map<Integer, String> map = parseJson.getNodes().stream().collect(Collectors.toMap(Node::getIndex, Node::getName));
        List<Link> ans = new ArrayList<>();
        parseJson.getLinks().forEach(s -> ans.add(Link.builder().source(s.getSource()).target(s.getTarget()).sourceName(map.get(s.getSource())).targetName(map.get(s.getTarget())).build()));

        ans.forEach(s -> {
            System.out.println(s.getSourceName() + "--->" + s.getTargetName());
        });


    }
}

@Data
class Category {
    Integer index;
    String name;
    String base;
}

@Data
class Node {
    Integer index;
    String name;
    Integer category;
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Link {
    String sourceName;
    String targetName;
    Integer source;
    Integer target;
}

