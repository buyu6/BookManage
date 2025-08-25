package com.hut.io;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String id;
    private String name;
    private String author;
   private int number;
   //type==1时书籍为电子类，type==2时为纸质类
    private int  type;
    public Book() {
    }

    public Book(String author, String id, String name, int number,int type) {
        this.author = author;
        this.id = id;
        this.name = name;
        this.number = number;
        this.type=type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int  getType() {
        return type;
    }

    public void setType(int  type) {
        this.type = type;
    }

    public void lookbook(){
        System.out.println("书籍已展示");
    }
}
