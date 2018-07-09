package database.jdbc;

import java.sql.*;

/**
 * PreparedStatement的方式
 */
public class PreparedStatement {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.1.105:3306/school";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "1994";

    public static void main(String[] args){
        Connection connection = null;
        java.sql.PreparedStatement ps = null;

        try{
            //注册JDBC驱动
            Class.forName(JDBC_DRIVER);

            //打开连接
            System.out.println("连接数据库.......");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            //执行查询
            String sql;
            sql = "select sno, cno, degree from score where sno = ? and cno = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, "xxx");
            ps.setString(2, "xxx");

            ResultSet set = ps.executeQuery();

            //打印查询结果
            while(set.next()){
                String sno = set.getString("sno");
                String cno = set.getString("cno");
                String degree = set.getString("degree");

                System.out.print("sno:" + sno);
                System.out.print("，cno：" + cno);
                System.out.print("，degree：" + degree + "\n");
            }

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
