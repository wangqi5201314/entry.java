package MyUtil;

import MyJavabean.User;

import java.util.Scanner;

/*
 * @Description: 登录功能
 */

public final class LoginUtil {
    static User input = new User();

    /*
     * @Description: 模拟登录界面 命令行
     */

    public static void loginStart(){
//        刷新flag,表示登录
        ComUtil.flag = 0;


        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎来到图书管理系统,请登录");

//        输入账号
        System.out.print("账号:");
        input.setName(sc.nextLine());

//        输入密码
        System.out.print("密码:");
        input.setPassword(sc.nextLine());

//        选择用户类型
        System.out.print("账号类型(0为普通用户,1为管理员):");
        input.setType(sc.nextInt());

        //TODO  点击"登录"按钮

//        将所有输入的信息传入ComUtil.into()方法,进行空值判断
        ComUtil.isNull(input);
    }


}







