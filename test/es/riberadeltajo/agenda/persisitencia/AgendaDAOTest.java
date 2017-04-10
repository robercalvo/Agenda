
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
    AgendaDAO agenda;   
    @Before
    public void setUp()
    {        
        agenda = new AgendaDAO();
    }
    @Test
    public void testGuardar()
    {
        System.out.println("Guardar");
        Contacto c = new  Contacto();
        c.setNombre("Juanjo");        
        agenda.guardar(c);        
    }
    @Test(expected = RollbackException.class)
    public void testGuardarRepetido()
    {
        System.out.println("guardar repetido");
        Contacto c = new Contacto();
        c.setNombre("juanjo");
        agenda.guardar(c);
        Contacto b = new Contacto();
        b.setNombre("juanjo");
        agenda.guardar(b);
    }
    @Test
    public void testBuscarContacto()
    {
        Contacto c = new Contacto();
        c.setNombre("Elena");
        agenda.guardar(c);
        assertEquals(c,agenda.getContacto("Elena"));
        assertNull(agenda.getContacto("asfdaf"));
    }    
    @Test
    public void testTodosContactos()
    {
        Contacto c = new Contacto();
        c.setNombre("Angel");
        assertNotNull(agenda.getContactos());
    }
    @Test
    public void testBorraContacto()
    {
        Contacto c = new Contacto();
        c.setNombre("miguel");
        agenda.guardar(c);
        assertEquals(1,agenda.borrar("miguel"));
        assertEquals(0,agenda.borrar("miguel"));
        
    }
}
