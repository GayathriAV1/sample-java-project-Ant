// Example Java class with a SQL injection vulnerability
public class DatabaseService {
    public void executeQuery(String userInput) {
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
        // Execute the query (this is vulnerable to SQL injection)
        // ...
    }
}
