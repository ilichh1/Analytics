/*
 * Licencia pendiente, para cambiar la licencia ir a -> Tools | Templates
 */

package dao;

import hbm.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Click;

/**
 *
 * @author Ilich Arredondo
 */
public class ClickDAO {
    
    Session session;
    
    public ClickDAO() {
        session = HibernateUtil.getLocalSession();
    }
    
    public List<Click> getAllClicks() {
        return (List<Click>) this.session.createCriteria(Click.class).list();
    }
    
    public boolean saveClick(Click click) {
        try {
            Transaction transaction = session.beginTransaction();
            session.save(click);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error guardando en la BD:\n"+e);
            return false;
        }
        return true;
    }

}