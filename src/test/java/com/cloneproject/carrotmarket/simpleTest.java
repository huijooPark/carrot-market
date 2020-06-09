package com.cloneproject.carrotmarket;

import com.cloneproject.carrotmarket.component.GenerationCertNumber;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

public class simpleTest {

    @Test
    public void testA(){
        System.out.println("TestA");
    }

    @Test
    public void testBbbbb(){
        System.out.println("---");
        System.out.println("TestB");
    }

    @Test
    public void testC(){
        System.out.println("TestC");
    }

    @Test
    public void 랜덤키생성_테스트(){

        GenerationCertNumber gr = new GenerationCertNumber();
        System.out.println(gr.executeGenerate());
    }
}
