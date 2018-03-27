package Service.DataBase;

import java.sql.*;

public class DatabaseCheck {
    private Connection conn;
    private Statement stmt;
    private ResultSet rset;

    public DatabaseCheck() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database.db");
            stmt = conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getFirstName() {
        String sqlQuery = "SELECT name FROM temp_table";
        String firstName = null;
        try {
            rset = stmt.executeQuery(sqlQuery);
            firstName = rset.getString("name");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return firstName;
    }

    private void close() throws SQLException {
        conn.close();
    }
}
