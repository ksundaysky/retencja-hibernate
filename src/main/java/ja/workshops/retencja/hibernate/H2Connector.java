package ja.workshops.retencja.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


class H2Connector {

    private static SessionFactory sessionFactory;

    static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            try {

                // konfiguracja polega na wporwadznieu ustawien do mapy Properties <Environment.VARIABLE, String_Value>
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.h2.Driver");
                settings.put(Environment.URL, "");
                settings.put(Environment.USER, "");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
                settings.put(Environment.SHOW_SQL, "");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);
//            TODO Add entities classes here
//            configuration.addAnnotatedClass()
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build(); // budowanie serwisu rejestracyjnego
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            return sessionFactory;
        }
        return sessionFactory;
    }

}
