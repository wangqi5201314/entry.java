package MyUtil;

import MyJavabean.User;

import java.util.Scanner;

/*
 * @Description: 注册功能
 */
public final class RegitUtil {
    static User input = new User();

    /*
     * @Description: 模拟注册界面 命令行
     */

    public static void regitStart() {
//        刷新flag,表示注册
        ComUtil.flag = 1;

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入相关信息进行注册");
        System.out.print("账号:");
        input.setName(sc.nextLine());
        System.out.print("密码:");
        input.setPassword(sc.nextLine());
        System.out.print("账号类型(0为普通用户,1为管理员):");
        input.setType(sc.nextInt());
        //TODO  点击"确定"按钮

//        进入空值判断
        ComUtil.isNull(input);
    }
}