package com.cloneproject.carrotmarket;

import com.cloneproject.carrotmarket.component.GenerationCertNumber;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.mapstruct.Mapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class simpleTest {

    @Test
    public void testA(){
        System.out.println("TestA");
    }

    @Test
    public void 공백및숫자가아닌경우확인(){
        System.out.println("공백및숫자가아닌경우확인()");

        List<Map<String,String>> ls = new ArrayList<>();

        Map<String,String> map1 = new HashMap<>();
        map1.put("col1","aaa");
        map1.put("col2","col222");
        map1.put("col3","1");
        ls.add(map1);

        Map<String,String> map2 = new HashMap<>();
        map2.put("col1","aaa");
        map2.put("col2","col222");
        map2.put("col3","df");
        ls.add(map2);

        System.out.println(ls.toString());


        for (Map<String,String > map:
             ls) {
            if( "".equals(map.get("col3")) || String.valueOf(map.get("col3")) == null ){
                System.out.println("수량은 숫자만 가능합니다.");
            }

            try{
                Integer.parseInt(map.get("col3"));
            }catch (NumberFormatException ne){
                System.out.println("숫자가 아닙니다");
            }
        }

    }

    @Test
    public void LIST_MAP확인(){
        System.out.println("LIST_MAP확인()");

        List<Map<String,Integer>> ls = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for (int i=0 ; i < 10 ; i ++) {
            map.put("index",i);
            ls.add(map);
        }

        System.out.println("=== for 밖에 선언된 MAP new 10회 반복==== ");
        System.out.println(ls);


        ls.clear();

        Map<String,Integer> map1=null;
        for (int i=0 ; i < 10 ; i ++) {
            map1 = new HashMap<>();
            map1.put("index",i);
            ls.add(map1);
        }

        System.out.println("=== for 안에 선언된 MAP new 10회 반복==== ");
        System.out.println(ls);

    }

    @Test
    public void testC() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("TestC");
        ArrayList list = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            list.add(new Integer(i));
        }
        Field f = ArrayList.class.getDeclaredField("elementData");
        f.setAccessible(true);
        int capacity = ((Object[]) f.get(list)).length;
        System.out.format("List size: %d, Capacity: %d", list.size(),capacity);

    }

    @Test
    public void 랜덤키생성_테스트(){

        GenerationCertNumber gr = new GenerationCertNumber();
        System.out.println(gr.executeGenerate());
    }

    @Test
    public void map키중복_테스트(){
        Map<String,String> map1=new HashMap<>();
        Map<String,String> map2=new HashMap<>();

        map1.put("1","1");
        map1.put("2","1");
        map1.put("3","1");
        map1.put("4","1");
        map1.put("5","1");

        map2.put("1","3");
        map2.put("2","3");
        map2.put("3","");
        map2.put("4","3");
        map2.put("5","");
        map2.put("6","");
        map2.put("7","3");

        map2.putAll(map1);

        System.out.println(map2);

    }
}
