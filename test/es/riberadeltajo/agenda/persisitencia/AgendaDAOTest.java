
package es.riberadeltajo.agenda.persisitencia;

import es.riberadeltajo.agenda.entidades.Contacto;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Juanjo Acuña
 */
public class AgendaDAOTest
{
    AgendaDAO instance;
    public AgendaDAOTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
        instance = new AgendaDAO();
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of guardar method, of class AgendaDAO.
     */
    @Test
    public void testGuardar()
    {
        System.out.println("Guardar");
        Contacto c = new  Contacto();
        c.setNombre("Juanjo");        
        instance.guardar(c);        
    }
    @Test
    public void testObtenerTodos()
    {   
        System.out.println("Obtener todos los datos");
        List <Contacto> l = instance.getContactos();
        assertNotNull(l);
    }    
    @Test
    public void testBuscarPorNombre()
    {   System.out.println("Buscar por nombre");
        assertNotNull(instance.getContacto("Juanjo"));
    }
    @Test
    public void testBorrarPorNombre()
    {
        System.out.println("Borrar por nombre");
        assertEquals(0, instance.borrar("Juanjo"));
    }
}
