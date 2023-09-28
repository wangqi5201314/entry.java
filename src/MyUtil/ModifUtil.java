package MyUtil;

import MyJavabean.User;

import java.sql.Connection;
import java.util.Scanner;

/*
 * @Description: 修改密码功能
 */
public final class ModifUtil {
    static User input = new User();

    /*
     * @Description: 模拟界面 命令行
     */

    public static void modifReady(){
//        刷新flag,表示修改密码
        ComUtil.flag = 2;

//        先进入确定账号密码无误界面
        Scanner sc=new Scanner(System.in);
        System.out.println("请准备好相关信息方便你修改密码");
        System.out.print("账号:");
        input.setName(sc.nextLine());
        System.out.print("密码:");
        input.setPassword(sc.nextLine());
        System.out.print("账号类型(0为普通用户,1为管理员):");
        input.setType(sc.nextInt());
        //TODO 点击"确定"按钮

//        进入空值判断
        ComUtil.isNull(input);

    }

    public static void modifStart(Connection connection){
        Scanner sc=new Scanner(System.in);

        //        进入输入新密码并重复界面
        System.out.println("请输入新的密码并重复");
        System.out.println("账号:"+input.getName());
        System.out.print("新密码:");
        String newPassword=sc.nextLine();
        System.out.print("重复:");
        String repPassword=sc.nextLine();
        if (!newPassword.equals(repPassword)){
            System.out.println("两次密码输入不匹配");
        }else {
            input.setPassword(newPassword);
            DBUtil.dbModifMatch(input,connection);
        }
    }
}
