import util.DBConnector;
import util.Login;

public class Main {

    public static void main(String[] args) {
        DBConnector dbConnector = new DBConnector();
        Login login = new Login(dbConnector);

        login.displayLogin();
    }

}
