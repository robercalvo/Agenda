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
    
    private final EntityManagerFactory emf;
    private EntityManager em;
    
    public AgendaDAO()
    {
        emf = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
    }
    /**
     * Almacen un contacto en nuestra agenda
     * @param c contacto que deseamos guardar
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    public void guardar(Contacto c) throws NullPointerException,IllegalArgumentException
    {
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
    public List<Contacto>getContactos()
    {
        List<Contacto> listAgenda=null;
        em = emf.createEntityManager();
        Query q =em.createQuery("SELECT C FROM Contacto c");
        listAgenda = q.getResultList();
        em.close();
        return listAgenda;
    }
    /**
     * Obtiene el primer contacto que coincida con el nombre     * 
     * @param nombre Nombre del usuario que deseamos buscar
     * @return 
     */
    public Contacto getContacto(String nombre)
    {
        if(nombre.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        em = emf.createEntityManager();
        Contacto c = null;
        Query q = em.createNamedQuery("Contacto.BuscarPorNOmbre");
        q.setParameter("nombre",nombre);
        List <Contacto> contactos = q.getResultList();
        if(contactos!=null)
        {
            c=contactos.get(0);
        }      
        return c;
    }
    /**
     * Elemina todos los contactos que tengan un determinado nombre
     * @param nombre del contacto a eliminar
     * 
     * @return <ul><li>n si es posible realizar la eliminicación</li>
     * <li>0 Si no se puede realizar el borrado</li></ul>
     */
    public int borrar(String nombre)
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
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Contacto.BorraPorNombre");
        q.setParameter("nombre",nombre);
        estado=q.executeUpdate();
        em.close();
        return estado;
    }
}
