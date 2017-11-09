/*
 * Licencia pendiente, para cambiar la licencia ir a -> Tools | Templates
 */

package hbm;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Ilich Arredondo
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    private static final ThreadLocal localSession;
    
    static {
        
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception e) {
            System.err.println("Inicializacion de SessionFActory fallida: \n"+e);
            throw new ExceptionInInitializerError(e);
        }
        localSession = new ThreadLocal();
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session getLocalSession() {
        Session session = (Session) localSession.get();
        
        if(session == null) {
            session = sessionFactory.openSession();
            System.out.println("BD Sesion iniciada");
        }
        return session;
    }
    
    public static void closeLocalSession() {
        Session session = (Session) localSession.get();
        if (session != null) session.close();
        localSession.set(null);
        System.out.println("DB Session cerrada\n");
    }
}