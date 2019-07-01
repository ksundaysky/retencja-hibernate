package ja.workshops.retencja.hibernate;

public class App {
    public static void main(String[] args) {
        H2Connector.getSessionFactory().getCurrentSession();
    }
}
