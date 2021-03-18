package JDBCCL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTrans {

    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdb",
                    "sairam", "password");
        /*DatabaseMetaData db =connection.getMetaData();
        ResultSet rs = db.getTables(null,null,null,new String[] {"table"});
        while(rs.next()){
            System.out.println(rs.getString(3));
        }*/
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            CallableStatement cstat = connection.prepareCall("{call getPhoneNmbr(?)}");
            cstat.setString(1, "sai");
            cstat.execute();
            System.out.println(cstat.getString(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
