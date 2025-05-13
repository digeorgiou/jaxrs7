package gr.aueb.cf.schoolapp.service.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


//το JPAHelper μας δινει entity managers

//θελουμε να πετυχουμε να εχουμε εναν entity manager για καθε request, να μην
// μπλεκονται μεταξυ τους

//για καθε request δημιουργειται καινουριο persistence context και ετσι
// εχουμε request scope στον entity manager.

//αυτο κανουν και οι application servers, καλυτερα.
//εδω κανουμε μια απλη υλοποιηση, αλλα οχι για μεγαλη κλιμακα - παραγωγη

public class JPAHelper {
    private static EntityManagerFactory emf;
    //με το Thread Local επιτυγχανουμε να δημιουργειται αλλος em με δικο του
    // χώρο για καθε thread αρα request.
    private static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<>();

    private JPAHelper() {

    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null || !emf.isOpen()) {
            //copy paste το ονομα απο το persistence xml
            emf = Persistence.createEntityManagerFactory("school7DBContext");
        }
        return emf;
    }

    public static EntityManager getEntityManager() {
        EntityManager em = threadLocal.get();
        //αν υπαρχει ο entity manager (ιδιο request) η αν δεν εχει γινει close
        //τοτε γινεται return ο ιδιος em, δεν δημιουργειται καινουριος.
        if (em == null || !em.isOpen())  {
            em = getEntityManagerFactory().createEntityManager();
            threadLocal.set(em);
        }
        return em;
    }

    public static void closeEntityManager() {
        getEntityManager().close();
        threadLocal.remove();
    }

    public static void beginTransaction() {
        getEntityManager().getTransaction().begin();
    }

    public static void commitTransaction() {
        getEntityManager().getTransaction().commit();
    }

    public static void rollbackTransaction() {
        getEntityManager().getTransaction().rollback();
    }

    public static void closeEMF() {
        emf.close();
    }
}
