package JDBCCL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//calling DB from JDBC
public class JdbcTrans {

    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdb",
                    "sairam", "password");
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
