package MyUtil;

import MyJavabean.Book;
import MyJavabean.User;

public class SelectBookUtile {
    public static void SelectStart(User user, Book book,String ISBN) {
        if (user.getType() == 1) {
            DBUtil.dbSelectBookMatch(user,book,ISBN);
        }else {
            System.out.println("您不是管理员,无权限进行此操作");
        }
    }
}
