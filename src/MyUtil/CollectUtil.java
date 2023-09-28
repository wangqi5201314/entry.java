package MyUtil;

import MyJavabean.Book;
import MyJavabean.User;

public class CollectUtil {
    public static void CollectStart(User user, Book book) {
        if (user.getType() == 1) {
            DBUtil.dbcollectMatch(user,book);
        }else {
            System.out.println("您不是管理员,无权限进行此操作");
        }
    }
}
