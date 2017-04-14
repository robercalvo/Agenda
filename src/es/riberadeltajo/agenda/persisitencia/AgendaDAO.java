/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.riberadeltajo.agenda.persisitencia;

import es.riberadeltajo.agenda.entidades.Contacto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Clase utilizada para realizar operaciones CRUD sobre la base de datos
 * @author Juanjo Acuña
 * @since 1.0
 */
public class AgendaDAO 
{
    private static final String UNIDAD_PERSISTENCIA="AgendaPU2";    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    
    /**
     * Almacen un contacto en nuestra agenda
     * @param c contacto que deseamos guardar
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    public static void guardar(Contacto c) throws NullPointerException,IllegalArgumentException
    {
        emf = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
        if(c==null)
        {            
            throw new NullPointerException();
        }
        if(c.getNombre().isEmpty())
        {
            throw new IllegalArgumentException();
        }        
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();              
    }
    /**
     * Obtiene todos los caontactos almacenados en la agenda
     * @return un objeto List con los contactos
     */
    public static List<Contacto>getContactos()
    {
        emf = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
        List<Contacto> listAgenda=null;
        em = emf.createEntityManager();
        Query q =em.createQuery("SELECT c FROM Contacto c");
        listAgenda = q.getResultList();
        em.close();
        return listAgenda;
    }
    /**
     * Obtiene un contacto a traves del campo clave     * 
     * @param nombre Nombre del usuario que deseamos buscar
     * @return 
     */
    public static  Contacto getContacto(String nombre)
    {
        if(nombre.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        emf = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
        em = emf.createEntityManager();        
        Contacto c= em.find(Contacto.class, nombre);                      
        em.close();
        return c;
    }
    /**
     * Elimina un contacto a traves de su nombre
     * @param nombre del contacto a eliminar     * 
     * @return <ul><li>1 si es posible realizar la eliminicación</li>
     * <li>0 Si no se puede realizar el borrado</li></ul>
     */
    public static int borrar(String nombre)
    {
        if(nombre==null)
        {
            throw new NullPointerException();
        }
        if(nombre.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        int estado=0;
        emf = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Contacto c = em.find(Contacto.class, nombre);
        if(c!=null)
        {
            em.remove(c);
            em.getTransaction().commit();
            estado++;
        }        
        em.close();
        return estado;
    }
}
