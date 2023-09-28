package MyJavabean;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import MyUtil.CollectUtil;
import MyUtil.DBUtil;
import MyUtil.DateUtil;
import MyUtil.SelectBookUtile;

public class Book {

    Scanner sc=new Scanner(System.in);
    DateUtil dateUtil=new DateUtil();
    private static final int max_number=4;

    private static String ISBN;//编号和数量英文都只能想到number，头疼
    private static String category_number;
    private static String name;
    private static String category;
    private static float price;
    //    private String status;//入藏，外借，内阅，馆藏，基藏
    private static int number;
    private static String[] borrower=new String[max_number];
    private static Date[] date=new Date[max_number];
    User user=null;
    public Book() {
    }

    public Book(String ISBN, String category_number, String name, String category, float price, int number, String[] borrower, Date[] date) {
        this.ISBN = ISBN;
        this.category_number = category_number;
        this.name = name;
        this.category = category;
        this.price = price;
        this.number = number;
        this.borrower = borrower;
        this.date = date;
    }




    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getCategory_number() {
        return category_number;
    }
    public void setCategory_number(String category_number) {
        this.category_number = category_number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getBorrower() {
        return Arrays.toString(borrower);
    }
    public void setBorrower(String[] borrower) {
        this.borrower = borrower;
    }
    public void setBorrower(int index,String borrower){
        this.borrower[index]=borrower;
    }
    public String getDate() {
        return Arrays.toString(date);
    }
    public void setDate(Date[] date) {
        this.date = date;
    }
    public void setDate(int index,Date date) {
        this.date[index]=date;
    }
    public String toString() {
        return "Book{ISBN = " + this.getISBN() + ", category_number = " + this.getCategory_number() + ", name = " + this.getName() + ", category = " + this.getCategory() + ", price = " + this.getPrice() + ", number = " + this.getNumber() + ", borrower = " + this.getBorrower() + ", date = " + this.getDate() + "}";
    }
    //新书录入（建表时不止这些字段）
    public void collect(User user){
        System.out.println("请按顺序录入新书（编号、分类编号、书名、分类名、价格、数量，一行一行输入）");
        this.change(0);
        this.change(1);
        this.change(2);
        this.change(3);
        this.change(4);
        this.change(5);
        sc.nextLine();
        CollectUtil.CollectStart(user,this);
        /*这里修改代码，录入新书（编号、分类编号、书名、分类名、价格、数量）*/
    }
    //查询书籍（单次查询全部信息）
    public void select(User user) {//根据编号查询书籍

        /*这里修改代码，查数据库并传给下面的构造方法里*/
        System.out.println("请输入要查询的书籍编号");
        String ISBN=sc.nextLine();
        SelectBookUtile.SelectStart(user,this,ISBN);
        //System.out.println(this.toString());
    }
    //变更信息（用户、管理员共用），用change()变更属性值并修改数据库
    public void change(int number){
        switch (number){//根据数字编号调用set方法,对应修改编号、分类编号、书名、分类名、价格等

            /*下面添加代码，用book属性值改数据库内数据*/
            case 0:this.setISBN(sc.nextLine());/**/break;//编号
            case 1:this.setCategory_number(sc.nextLine());/**/break;//分类编号
            case 2:this.setName(sc.nextLine());/**/break;//书名
            case 3:this.setCategory(sc.nextLine());/**/break;//分类名
            case 4:this.setPrice(sc.nextFloat());/**/break;//价格
            case 5:this.setNumber(sc.nextInt());/**/break;//数量
            //case 6:book.setBorrower(sc.nextLine().split(" "));break;//借书人，用空格隔开
        }
    }
    //借书
    public void borrow(String userName) throws ParseException {
        this.select(user);
        boolean flag=false;
        for (int i = 0; i < this.getNumber()&&i<max_number; i++) {
            if(this.borrower[i]==null){
                flag=true;
                this.setBorrower(i,userName);
                this.setDate(i,dateUtil.toDate(dateUtil.getReturnDate()));
                /*这里添加代码，修改数据库borrower和date*/
                break;
            }
        }
        if (flag)System.out.println("借书成功");
        else System.out.println("无剩余图书");
    }
    public void showAll(){
        System.out.println(this.toString());
    }
    public void show(){}
}
