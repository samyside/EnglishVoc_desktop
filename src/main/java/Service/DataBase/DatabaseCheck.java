package Service.DataBase;

import java.sql.*;

public class DatabaseCheck {
    private Connection conn;
    private Statement stmt;
    private ResultSet rset;
    private String sqlQuery;

    public DatabaseCheck() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database.db");
            sqlQuery = "SELECT name, password FROM temp_table";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }




    private void close() throws SQLException {
        conn.close();
    }
}
