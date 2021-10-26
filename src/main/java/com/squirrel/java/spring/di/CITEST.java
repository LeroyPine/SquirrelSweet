package com.squirrel.java.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CITEST {

    @Autowired
    private List<DITest> s;

}
