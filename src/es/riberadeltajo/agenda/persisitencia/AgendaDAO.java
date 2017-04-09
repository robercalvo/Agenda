/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.riberadeltajo.agenda.persisitencia;

import es.riberadeltajo.agenda.entidades.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase utilizada para realizar operaciones CRUD sobre la base de datos
 * @author Juanjo Acuña
 * @since 1.0
 */
public class AgendaDAO 
{
    private static final String UNIDAD_PERSISTENCIA="AgendaPU2";
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public AgendaDAO()
    {
        emf = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
    }
    /**
     * Almacen un contacto en nuestra agenda
     * @param c contacto que deseamos guardar
     */
    public void guardar(Contacto c)
    {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();              
    }
            
}
