import MyJavabean.Book;
import MyJavabean.User;
import MyUtil.*;

import java.sql.SQLException;
import java.text.ParseException;

/*
 * @Description: 进入页面
 */
public class entry {
    public static void main(String[] args) throws SQLException, ParseException {
        //进入登录页面
//        LoginUtil.loginStart();

        //注册功能
//        RegitUtil.regitStart();

        //修改密码
//        ModifUtil.modifReady();
        User user=new User("阿伟","123",1);//数据库连不上将就用这个
        Book book=new Book();
//        book.collect(user);//录入
        book.select(user);//根据ISBN查询书
//        }
    }
/*
更新日志:版本3.0
更新人:王琦
更新内容:管理员的录入和ISBN查书功能
 */

}
