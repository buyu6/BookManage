package com.hut.io;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.Scanner;
public class BookSystem {
    public static void main(String[] args) {
        //创建一个列表用来存储数据
        ArrayList<Book> list = new ArrayList<>();
        //对循环进行标记使其使用break可以直接跳出循环
        loop:
        //循环使该过程可以重复进行
        while (true) {
            //主菜单：
            System.out.println("------------------------欢迎来到HUT图书管理系统------------------------");
            System.out.println("1.添加图书");
            System.out.println("2.搜索图书");
            System.out.println("3.更新图书");
            System.out.println("4.删除图书");
            System.out.println("5.展示所有图书");
            System.out.println("6.退出");
            System.out.println("7.下载该图书");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的操作：");
            String n = sc.next();
            switch (n) {
                case "1" -> addBook(list);
                case "2" -> searchBook(list);
                case "3" -> updateBook(list);
                case "4" -> removeBook(list);
                case "5" ->displayBook(list);
                case "6" -> {
                    System.out.println("退出成功");
                    break loop;
                }
                case "7" -> downloadbook(list);
                default -> System.out.println("没有这个选项，请您重新选择");
            }
        }
    }
    //添加书籍
    public static void addBook(ArrayList<Book> list) {
        Scanner sc = new Scanner(System.in);//键盘录入
        System.out.println("请输入添加书籍的ISBN：");
        String id = sc.next();
        //判断该书籍之前是否添加过
        boolean flag=false;
        flag=judgeBook(list,id);
        //添加过的情况
        if(flag) {
            System.out.println("已有相同的ISBN书籍，请重新操作");
            return;
        }
        //未添加时：
        System.out.println("请输入添加书籍的名字：");
        String name = sc.next();
        System.out.println("请输入添加书籍的作者：");
        String author = sc.next();
        System.out.println("请输入书籍的数量：");
        int number = sc.nextInt();
        System.out.println("请输入书籍的种类");
        int type = sc.nextInt();
        Book book = new Book(author, id, name, number,type);
        list.add(book);
        System.out.println("恭喜您，该书籍添加成功");
    }
//删除书籍
    public static void removeBook(ArrayList<Book> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的书籍的ISBN：");
        String id = sc.next();
        //求出要删除书籍的id
        int t=index(list,id);
        //未查询到时
        if(t==-1){
            System.out.println("未找到指定书籍，请重新操作");
            return;
        }
        //查找到时
        else{
            list.remove(t);
            System.out.println("删除成功");
        }
    }
//展示所有书籍
    public static void displayBook(ArrayList<Book> list) {
        if (list.size() == 0) {
            System.out.println("当前无信息，请添加后再次查询");
            return;
        }
        //表头
        System.out.println("ISBN\t\tname\tauthor\tnumber\ttype");
        for (int i = 0; i < list.size(); i++) {
            Book book = list.get(i);
            System.out.println(book.getId() + "\t\t" + book.getName() + "\t" + book.getAuthor() + "\t" + book.getNumber()+"\t" + book.getType());
        }
    }
//更新书库
    public static void updateBook(ArrayList<Book> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要更新书籍的ISBN码：");
        String id = sc.next();
        int t=index(list,id);
        if(t!=-1){
          Book book = list.get(t);
            System.out.println("请输入改变的数量：");
            int number=sc.nextInt()+book.getNumber();
            book.setNumber(number);
            System.out.println("更新完成");
            //如果改变之后数量小于0了要进行删除操作
            if(number<=0){
                list.remove(t);
            }
            return;
        }
        System.out.println("未找到该书籍，请重新操作");
    }
    //搜索书籍
public static void searchBook(ArrayList<Book> list){
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入要查询的书籍的ISBN码：");
    String id = sc.next();
    int t=index(list,id);
    if(t==-1){
        System.out.println("未查询到相关书籍，请核对后重新操作");
        return;
    }
    else{
        System.out.println("ISBN\t\tname\tauthor\tnumber\ttype");
        Book book=list.get(t);
        System.out.println(book.getId() + "\t\t" + book.getName() + "\t" + book.getAuthor() + "\t" + book.getNumber()+"\t"+book.getType());
        if(book.getType()==1){
            Ebook ebook=new Ebook();
            ebook.lookbook();
        }
        else{
            Paperbook   paperbook=new Paperbook();
            paperbook.lookbook();
        }
        return;
    }
}
//判断书库中是否存在该书籍
    public static boolean judgeBook(ArrayList<Book> list, String id) {
       /* for (int i = 0; i < list.size(); i++) {
            Book book = list.get(i);
            String idl = book.getId();
            if (idl.equals(id)) {
                return true;
            }
        }*/
        if(index(list,id)==-1){
            return false;
        }
        else{
            return true;
        }
    }
    //得到要查找书籍的位置
    public static int index(ArrayList<Book> list, String id){
        for (int i = 0; i < list.size(); i++) {
            Book book = list.get(i);
            String idl = book.getId();
            if (idl.equals(id)) {
            return i;
            }
        }
        return -1;
    }
    //下载书籍（电子书可下，纸质书籍不可下载）
    public static void downloadbook(ArrayList<Book> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要下载的ISBN码：");
        String id = sc.next();
        int t=index(list,id);
        if(t==-1){
            System.out.println("未查询到相关书籍");
        }
        else{
            Book book = list.get(t);
            if(book.getType()==1){
            Ebook ebook=new Ebook();
            ebook.download();
            }
            else{
                System.out.println("这本书是非电子类书籍，无法下载");
            }
        }
    }
}