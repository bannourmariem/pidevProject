package tn.esprit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDataBase {

    private static MyDataBase instance ;

    private final String URL="jdbc:mysql://localhost:3306/integproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USERNAME ="root";
    private final String PASSWORD ="";
    private Connection cnx ;

    private MyDataBase (){

        try {
            this.cnx = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("  " +
                    "Connected ... ");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(" ___ Connection Failed ___");
        }
    }


    public static MyDataBase getInstance() {
        if(instance == null)
            instance = new MyDataBase();

        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}
