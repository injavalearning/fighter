package database.jdbc;

import java.math.BigDecimal;
import java.sql.*;

/**
 * PreparedStatement的方式
 * 一个PreparedStatement是从java.sql.connection对象和所提供的sql字符串得到的，sql字符串中包含问号(?)，
 * 这些问号标明变量的位置，然后通过PreparedStatement的set方法提供变量的值，最后执行语句
 */
public class PreparedStatementDemo {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.1.105:3306/school";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "1994";

    public static void main(String[] args){
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            //注册JDBC驱动
            Class.forName(JDBC_DRIVER);

            //打开连接
            System.out.println("连接数据库.......");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql;

            //执行查询
            sql = "select sno, cno, degree from score where sno = ? and cno = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, "103");
            ps.setString(2, "3-105");
            ResultSet set = ps.executeQuery();

            //打印查询结果
            while(set.next()){
                String sno = set.getString("sno");
                String cno = set.getString("cno");
                BigDecimal degree = set.getBigDecimal("degree");

                System.out.print("sno:" + sno);
                System.out.print("，cno：" + cno);
                System.out.print("，degree：" + degree + "\n");
            }


            //执行插入
            sql = "insert into score (sno, cno, degree) values (?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, "101");
            ps.setString(2, "3-245");
            ps.setBigDecimal(3, new BigDecimal(81));
            ps.executeUpdate();

            //关闭连接
            set.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("goodbye");
        }
    }
}
