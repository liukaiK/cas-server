package com.unicom.smartcity.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;

public class DataSource {

    private Log log = LogFactory.getLog(this.getClass());

    {

        System.out.println("123123123123");
    }

    static {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/cas_server?createDatabaseIfNotExist=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            String username = "root";
            String password = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "select * from oauth_client_details";
            ResultSet resultSet = statement.executeQuery(sql);
            int row = resultSet.getRow();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
