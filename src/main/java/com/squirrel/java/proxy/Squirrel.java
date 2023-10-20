package com.squirrel.java.proxy;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Data
public class Squirrel implements Eat {

    private Integer a;

    private String taskEndDate;

    private String name;
    @Override
    public void eat() {
        System.out.println("小松鼠吃松鼠");
    }



    public static void main(String[] args) {


        System.out.println(Objects.equals(Short.valueOf("1"),(short)1));



        String format = String.format("%s/customer/showings/dealtAccompany?showingsId=%s&businessType=%s&isCompelAccompany=%s&houseId=%s&showingHousePkId=%s",
                "214", "!24", 2, "124", 1241, null);
        System.out.println(format);

        List<Squirrel>  list = new ArrayList<>();
        Squirrel squirrel = new Squirrel();
        squirrel.setTaskEndDate("2022-01-21 15:00");
        Squirrel squirrel1 = new Squirrel();
        squirrel1.setTaskEndDate("2022-01-21 15:10");
        list.add(squirrel1);
        list.add(squirrel);


        String s = list.stream()
                .map(Squirrel::getTaskEndDate)
                .max(Comparator.naturalOrder())
                .orElse(null);
        System.out.println(s);



        SquirrelProxy squirrelProxy = new SquirrelProxy();
        squirrelProxy.setName("");

        Squirrel squirrel2 = new Squirrel();
        BeanUtils.copyProperties(squirrelProxy,squirrel2);

        System.out.println(squirrel2);



    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
