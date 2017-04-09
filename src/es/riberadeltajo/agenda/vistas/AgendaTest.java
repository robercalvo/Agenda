package es.riberadeltajo.agenda.vistas;

import es.riberadeltajo.agenda.entidades.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Realización de pruebas
 * @author Juanjo Acuña
 * @since 1.0
 * @version 1.0
 */
public class AgendaTest 
{   
    public static void main(String args[])
    {
        //TODO Codigo de pruebas
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("AgendaPU2");
        EntityManager em = emf.createEntityManager();
        Contacto c = new Contacto();
        c.setNombre("Juanjo");        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        
    }
}
