/*
package FuncLogin;

import DBoperate.DB;

public class Customer extends User {
    public Customer(String name) {
        setName(name);
    }

    @Override
    public boolean isExist(String name) {
        if (DB.isExist_Customer(name)) {
            return true
                    ;*/
/*这里改写代码，查用户数据库，查到返回true，否则返回false*//*

        }
        return false;
    }

    @Override
    public boolean isPass(String password) {
        readPassword();
        return this.password.equals(password);
    }

    @Override
    public void readPassword() {
        */
/*这里添加代码，把数据库中对应密码赋值给该对象*//*

    }

    @Override
    public void addAccount(String name, String password) {
        if (isExist(this.name)) {
            System.out.println("该账号已存在");
            */
/*这里添加代码，弹出dialog（账号已存在）*//*

        } else {
            DB.regist_Customer(name, password);
            System.out.println("注册成功");
            */
/*这里添加代码，向用户数据库添加账户（账号名、密码），并弹出dialog（注册成功）*//*

        }
    }
}*/
