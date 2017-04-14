
package es.riberadeltajo.agenda.persisitencia;

import es.riberadeltajo.agenda.entidades.Contacto;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.RollbackException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * @author Juanjo Acuña
 */

public class AgendaDAOTest
{       
    @Before
    public void setUp()
    {        
        
    }
    @Test
    public void testGuardar()
    {
        System.out.println("Guardar");
        Contacto c = new  Contacto();
        c.setNombre("Juanjo");        
        AgendaDAO.guardar(c);        
    }
    @Test(expected = RollbackException.class)
    public void testGuardarRepetido()
    {
        System.out.println("guardar repetido");
        Contacto c = new Contacto();
        c.setNombre("juanjo");
        AgendaDAO.guardar(c);
        Contacto b = new Contacto();
        b.setNombre("juanjo");
        AgendaDAO.guardar(b);
    }
    @Test
    public void testBuscarContacto()
    {
        Contacto c = new Contacto();
        c.setNombre("Elena");
        AgendaDAO.guardar(c);
        assertEquals(c,AgendaDAO.getContacto("Elena"));
        assertNull(AgendaDAO.getContacto("asfdaf"));
    }    
    @Test
    public void testTodosContactos()
    {
        Contacto c = new Contacto();
        c.setNombre("Angel");
        assertNotNull(AgendaDAO.getContactos());
    }
    @Test
    public void testBorraContacto()
    {
        Contacto c = new Contacto();
        c.setNombre("miguel");
        AgendaDAO.guardar(c);
        assertEquals(1,AgendaDAO.borrar("miguel"));
        assertEquals(0,AgendaDAO.borrar("miguel"));
        
    }
}
