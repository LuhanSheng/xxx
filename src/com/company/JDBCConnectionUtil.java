package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.sql.*;


public class JDBCConnectionUtil {

    private static final String url = "jdbc:mysql://localhost:3306/student1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    private static final String name = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "0106259685";

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public JDBCConnectionUtil() throws Exception {
    }

    public Connection getConnection() throws Exception {
        Connection connection = threadLocal.get();
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName(name);
                connection = DriverManager.getConnection(url,username,password);
                createTable(connection);
                threadLocal.set(connection);
            } catch (Exception e) {
                /*logger.error("获取JDBC连接出错", e);*/
                throw e;
            }
        }
        return connection;
    }

    static void createTable(Connection c) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS student1 (userName TEXT NOT NULL, password TEXT NOT NULL, studentName TEXT NOT NULL)";
        c.createStatement().executeUpdate(sql);
    }

    public int executeUpdate(String sql) throws Exception {
        Connection connection = null;
        Statement stmt = null;
        int res = 0;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            res = stmt.executeUpdate(sql);

            connection.commit();
            stmt.close();
            connection.close();
            return res;
        } catch (Exception e) {
            /*logger.error("", e);*/
            throw e;
        }
    }
}