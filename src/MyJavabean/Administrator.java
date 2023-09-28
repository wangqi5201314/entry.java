/*
package FuncLogin;

import DBoperate.DB;

public class Administrator extends User {
    public Administrator(String name) {
        setName(name);
    }

    @Override
    public boolean isExist(String name) {
        if (DB.isExist_Manager(name)) {
            return true;
        }
        return false;
        */
/*这里改写代码，查管理员数据库，查到返回true，否则返回false*//*

    }

    @Override
    public boolean isPass(String password) {
        readPassword();
        return this.password.equals(password);
    }

    @Override
    public void readPassword() {
        */
/*这里添加代码，把管理员数据库中对应密码赋值给该对象*//*

    }

    @Override
    public void addAccount(String name, String password) {
        if (isExist(this.name)) {*/
/*这里添加代码，弹出dialog（账号已存在）*//*

            System.out.println("该账号已存在");
        } else {
            */
/*这里添加代码，向管理员数据库添加账户（账号名、密码），并弹出dialog（注册成功）*//*

            DB.regist_Administrator(name, password);
            System.out.println("注册成功");
        }
    }
}*/
