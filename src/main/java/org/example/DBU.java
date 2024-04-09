package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBU {
    private static String dbURL = "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:init.sql'";
    private static String dbuser = "sa";
    private static String dbpass = "";
    private static String dbURL_2 = "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:init.sql'";
    private static String dbuser_2 = "sa";
    private static String dbpass_2 = "";



    public static Connection getConnection()  {

        /**      String dbURL = null;
         String dbuser = "sa";
         String dbpass = "";

         FileInputStream fis ;
         Properties properties = new Properties();

         try {
         fis = new FileInputStream("src/main/resources/config.properris");
         properties.load(fis);

         dbURL = properties.getProperty("db.host");

         } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
         } catch (IOException e) {
         throw new RuntimeException(e);
         }
         */
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL, dbuser, dbpass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

}
