package MyUtil;

import MyJavabean.Book;
import MyJavabean.User;

import java.sql.*;

/*
 * @Description: 数据库相关功能的工具类
 */
public final class DBUtil {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/libms?characterEncoding=utf8&useSSL=true";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";
    public static String tableName = "Nobody";

    private DBUtil() {
    }

    public static void dbLoginMatch(User input) {
        try {
            // 加载数据库驱动程序
            Class.forName(DRIVER);

            // 建立数据库连接
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 创建 SQL 查询
            String query = "SELECT password FROM " + tableName + " WHERE username = ?";

            // 创建执行 SQL 的语句对象
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // 设置参数
            preparedStatement.setString(1, input.getName());

            // 执行查询并获取结果集
            ResultSet resultSet = preparedStatement.executeQuery();

            // 遍历结果集并输出数据
            if (resultSet.next()) {
                String password = resultSet.getString("password");
                if (!password.equals(input.getPassword())) {
                    System.out.println("密码错误");
                    //TODO:弹出dialog（密码错误）
                } else {
                    switch (ComUtil.flag) {
                        case 0:
                            System.out.println("登录成功");
                            //TODO:弹出dialog（登录成功）
                            //TODO:跳转到主界面
                            break;
                        case 2:
                            System.out.println("账号密码正确");
                            //TODO:弹出dialog（请输入新密码并重复）

                            ModifUtil.modifStart(connection);
                            break;
                        default:
                            System.out.println("数据错误");
                            break;
                    }

                }
            } else {
                System.out.println("账号不存在");
                //TODO:弹出dialog（账号不存在）
            }


            // 关闭连接和相关资源
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dbRegitMatch(User input) {
        try {
            // 加载数据库驱动程序
            Class.forName(DRIVER);

            // 建立数据库连接
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 创建 SQL 查询
            String query = "SELECT password FROM " + tableName + " WHERE username = ?";

            // 创建执行 SQL 的语句对象
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // 设置参数
            preparedStatement.setString(1, input.getName());

            // 执行查询并获取结果集
            ResultSet resultSet = preparedStatement.executeQuery();

            // 遍历结果集并输出数据
            if (resultSet.next()) {
                System.out.println("账号已存在");
                //TODO:弹出dialog（账号已存在）
            } else {
                // 创建 SQL 插入语句
                String queryInsert = "INSERT INTO " + tableName + " (username, password) VALUES (?, ?)";
                // 创建执行 SQL 的语句对象
                preparedStatement = connection.prepareStatement(queryInsert);

                preparedStatement.setString(1, input.getName());
                preparedStatement.setString(2, input.getPassword());

                // 执行插入操作
                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("数据插入成功！");
                } else {
                    System.out.println("数据插入失败。");
                }
            }


            // 关闭连接和相关资源
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dbModifMatch(User input, Connection connection) {
        try {
            // 创建 SQL 查询
            String query = "UPDATE " + tableName + " SET password = ? WHERE username = ?";

            // 创建执行 SQL 的语句对象
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // 设置参数
            preparedStatement.setString(1, input.getPassword());
            preparedStatement.setString(2, input.getName());

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("密码修改成功！");
            } else {
                System.out.println("密码修改失败。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void dbcollectMatch(User user, Book book) {
            int flag=1;
            tableName = "book";
            try {
                // 加载数据库驱动程序
                Class.forName(DRIVER);

                // 建立数据库连接
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                // 创建 SQL 查询
                String query = "SELECT ISBN FROM " + tableName;

                // 创建执行 SQL 的语句对象
                PreparedStatement preparedStatement = connection.prepareStatement(query);


                // 执行查询并获取结果集
                ResultSet resultSet = preparedStatement.executeQuery();

                // 遍历结果集并输出数据
                while (resultSet.next()){
                    if (book.getISBN().equals(resultSet.getString(1))) {
                        System.out.println("该图书已存在");
                        flag=0;
                        break;
                    }
                }

                if (flag==1) {
                    // 创建 SQL 插入语句
                    String queryInsert = "INSERT INTO " + tableName + " (ISBN, Category_number,Name,Category,price,number) VALUES (?,?,?,?,?,?)";
                    // 创建执行 SQL 的语句对象
                    preparedStatement = connection.prepareStatement(queryInsert);

                    preparedStatement.setString(1, book.getISBN());
                    preparedStatement.setString(2, book.getCategory_number());
                    preparedStatement.setString(3, book.getName());
                    preparedStatement.setString(4, book.getCategory());
                    preparedStatement.setFloat(5, book.getPrice());
                    preparedStatement.setInt(6, book.getNumber());

                    // 执行插入操作
                    int rowsInserted = preparedStatement.executeUpdate();

                    if (rowsInserted > 0) {
                        System.out.println("数据插入成功！");
                    } else {
                        System.out.println("数据插入失败。");
                    }
                }
                // 关闭连接和相关资源
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public static void dbSelectBookMatch(User user, Book book,String ISBN) {
        int flag=0;
        tableName = "book";
        try {
            // 加载数据库驱动程序
            Class.forName(DRIVER);

            // 建立数据库连接
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 创建 SQL 查询
            String query = "SELECT ISBN FROM " + tableName;
            String queryinfo = "select * from book where ISBN="+ISBN;
            // 创建执行 SQL 的语句对象
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            PreparedStatement ps = connection.prepareStatement(queryinfo);

            // 执行查询并获取结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet rs = ps.executeQuery();
            rs.next();
            // 遍历结果集并输出数据
            while (resultSet.next()) {
                if (ISBN.equals(resultSet.getString(1))) {
                    System.out.println("已搜寻到该图书,该图书的信息为");
                        System.out.println("ISBN " + rs.getString(1));
                        System.out.println("Category_number " + rs.getString(2));
                        System.out.println("Name " + rs.getString(3));
                        System.out.println("Category " + rs.getString(4));
                        System.out.println("price " + rs.getString(5));
                        System.out.println("number " + rs.getString(6));
                    flag=1;
                    break;
                }
            }
            if (flag==0) {
                System.out.println("未找到该图书");
            }
            // 关闭连接和相关资源
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}