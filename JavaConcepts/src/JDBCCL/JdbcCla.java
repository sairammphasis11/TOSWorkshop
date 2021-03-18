package JDBCCL;

import java.sql.*;

//Creating a JDBC Class and calling the db
public class JdbcCla {

    public static void main(String[] args) throws SQLException {

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdb",
                "sairam","password");
        /*DatabaseMetaData db =connection.getMetaData();
        ResultSet rs = db.getTables(null,null,null,new String[] {"table"});
        while(rs.next()){
            System.out.println(rs.getString(3));
        }*/
        CallableStatement cstat= connection.prepareCall("{call getPhoneNmbr(?)}");
        cstat.setString(1,"sai");
        cstat.execute();
        System.out.println(cstat.getString(1));

    }
}
