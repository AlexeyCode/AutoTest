
import org.junit.jupiter.api.*;

import java.sql.*;


public class JDBCTest {

    @BeforeAll
    static void setUp(){
        String userName = "root";
        String password = "Vjqcnfrfy1";
        String connectionUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement()){
            statement.execute("insert into client (FirstName) values ('bagga')");
            System.out.println("We are connected");
            ResultSet resultSet = statement.executeQuery("select * from client");
            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    void testSome(){
        System.out.println("test");
    }

    @AfterAll
    static void tearDown(){
        String userName = "root";
        String password = "Vjqcnfrfy1";
        String connectionUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement()){
            statement.execute("delete from client where FirstName='Bagga'");
            System.out.println("Disconnecting");
            ResultSet resultSet = statement.executeQuery("select * from client");
            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
