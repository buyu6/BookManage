package com.hut.io;

public class Ebook extends Book{
    public Ebook() {
    }
    public Ebook(String author, String id, String name, int number, int type) {
        super(author, id, name, number, type);
    }

    @Override
    public void  lookbook(){
        System.out.println("该类书籍为电子类书籍");
    }
    public void download(){
        System.out.println("该类书籍下载完成");
    }
}
