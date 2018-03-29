package Service.DataBase;

import java.sql.*;

public class Database {
    private Connection conn;
    private Statement stmt;
    private ResultSet rset;

    public Database() {

    }

    public void createConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/words.db");
            stmt = conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getFirstWord() {
        String sqlQuery = "SELECT eng FROM table_words";
        String firstName = null;
        try {
            rset = stmt.executeQuery(sqlQuery);
            firstName = rset.getString("eng");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return firstName;
    }

    private void close() throws SQLException {
        conn.close();
    }
}
