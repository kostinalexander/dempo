package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class TestMethod {


//   TestMethod static int size=20;
//
//    StringListImpl stringList1 = new StringListImpl(size);
//     StringListImpl stringList = new StringListImpl(size);

     StringListImpl stringListImpl = new StringListImpl();


    @Test
    public void addTest() {
    stringListImpl.add("hello");
    stringListImpl.add("ваалд");
        Assertions.assertEquals(2,stringListImpl.getSize());
    String s = stringListImpl.add("hello");
    Assertions.assertEquals(s,"hello");
   }

    private StringList stringList;

    @BeforeEach
    public void setUp() {
        stringList = new StringListImpl();
    }
    @Test
    public void testAdd() {
        String item = "Hello";
        String result = stringList.add(item);
        Assertions.assertEquals(item,result);
    }
    @Test
    public void indexTestAdd(){
        int index = 0;
        String item = "hello";
        String result = stringList.add(index,item);
        Assertions.assertEquals(stringList.get(index),stringList.add(index,item));
    }


    @Test
    public void testAdd_NullItem() {
        String item = null;
        Assertions.assertThrows(ValidateItemExeption.class, () -> stringList.add(item));
    }

    @Test
    public void testRemove(){
        String item = "hello";
        String result = stringList.add(item);
        String result1 = stringList.remove(item);
        Assertions.assertEquals(item,result1);
    }
    @Test
    public void testRemove_Negative(){
        String item = null;
        Assertions.assertThrows(ValidateItemExeption.class,()->stringList.remove(item));
    }

    @Test
    public void testSet(){
        String item = "helo";
        int index = 0;
        String result = stringList.add(index,item);
        String result1  = stringList.set(index,"Hello");
        Assertions.assertEquals(stringList.get(index),"Hello");
    }
    @Test
    public void testSet_Negative(){
        int index=0;
        String item = null;
        Assertions.assertThrows(ValidateItemExeption.class,()->stringList.set(index,item));
    }




}

