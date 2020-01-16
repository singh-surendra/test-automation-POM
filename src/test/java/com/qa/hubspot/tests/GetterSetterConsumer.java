package com.qa.hubspot.tests;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GetterSetterConsumer {



   @Test
   public void testGettersSetters(){

        GettersSetters gettersSetters = new GettersSetters();
        gettersSetters.setAge(45);
        gettersSetters.setBreed("Desi Dog");
        gettersSetters.setColor("Black");
        System.out.println("Breed is"+gettersSetters.getBreed());
        System.out.println("Age is"+gettersSetters.getAge());
        System.out.println("Color  is"+gettersSetters.getColor());

    }

    @Test

    public void test(){


        ArrayList<String> a1= new ArrayList<>();
        a1.add("test");
       a1.add("tssfg");

        ArrayList<String> a2= new ArrayList<>();
        a1.add("fgfretyerd");
        a1.add("gerhre");

        a1.addAll(a2);

        Iterator<String> itr= a1.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

    }

    @Test
    public void test2(){


        ArrayList<String> a1= new ArrayList<>();
        a1.add("test");
        a1.add("tssfg");

        a1.forEach(str-> System.out.println(str));

    }

    @Test
    public void test3(){

        String s = "I want to   walk my dog";
        StringTokenizer tokenizer = new StringTokenizer(s);

        while(tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println("You entered string "+s);


    }


}
