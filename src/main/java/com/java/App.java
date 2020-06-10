package com.java;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    private static   Set<Integer> cache;
    private static Integer capacity;

    public App() {
    }
    public App(Integer capacity) {
        this.cache =new LinkedHashSet<Integer>(capacity);
        this.capacity = capacity;
    }

    public static Boolean getData(Integer key){
        if (!cache.contains(key)){
            return false;
        }
        else {
            cache.remove(key);
            cache.add(key);
        }return true;
    }
    public static void putData(Integer key){
//        if (cache.contains(key)){
//          cache.remove(key);
//        }
        //else
            if(cache.size()==capacity){
            Integer first= cache.iterator().next();
            cache.remove(first);
        }
        cache.add(key);
    }
    public static void refer(Integer key){
        if (getData(key)==false){

            putData(key);
        }
    }
    public static void display(){
        Iterator<Integer> iterator=cache.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()+" ");
        }
    }

    public static void main(String[] args )
    {
        App ca=new App(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}
