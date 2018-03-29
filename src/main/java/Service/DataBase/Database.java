package Service.DataBase;

import Service.Element.Word;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private Connection conn;
    private Statement stmt;
    private ResultSet rset;

    public Database() {

    }

    public void createConnection() {
        final String URL = "jdbc:sqlite:src/main/resources/words.db";
        try {
            conn = DriverManager.getConnection(URL);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getFirstWord() {
        String sqlQuery = "SELECT engWord FROM table_words";
        String firstName = null;
        try {
            rset.beforeFirst();
            // maybe should be called rset.next()
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

    private List<Word> getWords() throws SQLException {
        List<Word> words = new ArrayList<>();
        while (rset.next()) {
            words.add(new Word(
                    rset.getString("engWord"),
                    rset.getString("rusWord"))
            );
        }
        return words;
    }
}
