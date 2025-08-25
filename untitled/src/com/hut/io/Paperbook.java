package com.hut.io;

public class Paperbook extends Book{
    public Paperbook() {
    }

    public Paperbook(String author, String id, String name, int number, int type) {
        super(author, id, name, number, type);
    }

    @Override
    public void lookbook(){
        System.out.println("该类书籍为纸质书籍");
    }
}
