package cn.huiyusheng;

import org.junit.Test;

import java.sql.*;

/**
 * @author 悔余生
 * @ClassName:TestJdbc
 * @Description:TODO
 * @Date 2020/12/7 上午11:40
 * @Version V1.0
 **/
public class TestJdbc {
    //定义MySQL的数据库驱动程序
    public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    //定义MySQL数据库的连接地址
    public static final String DBURL = "jdbc:mysql://localhost:3306/spring";
    //MySQL数据库的连接用户名
    public static final String DBUSER = "root";
    //MySQL数据库的连接密码
    public static final String DBPASS = "123456";

    @Test
    public void test() {
        Connection con = null;
        //数据库查询语句
        String sql = "select count(*) from t_user";
        try {
            //加载驱动程序
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //连接MySQL数据库时，要写上连接的用户名和密码
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            //实例化Statement对象 
            Statement stmt = con.createStatement();
            //执行数据库查询操作
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(con);
        try {
            //关闭数据库
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
