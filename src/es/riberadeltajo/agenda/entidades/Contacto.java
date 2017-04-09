
package es.riberadeltajo.agenda.entidades;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Representa un contacto dentro de la agenda
 * @author Juanjo Acuña
 * @version 1.0
 * @since 1.0
 */
@Entity
public class Contacto implements Comparable
{    
    public enum TIPO{AMIGO,FAMILA,TRABAJO,OTROS};
    @Id
    @javax.persistence.GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Column(name="ID")
    private Long id;
    private String nombre;
    private String apellidos;
    private TIPO tipo;
    private String telefono;
    private String email;

    //<editor-fold defaultstate="collapsed" desc="GETTER/SETTER">
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getApellidos()
    {
        return apellidos;
    }
    
    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }
    
    public TIPO getTipo()
    {
        return tipo;
    }
    
    public void setTipo(TIPO tipo)
    {
        this.tipo = tipo;
    }
    
    public String getTelefono()
    {
        return telefono;
    }
    
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EQUAL/HASHCODE/COMPARETO">
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contacto other = (Contacto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    /**
     * Compara dos objetos del tipo Contacto
     * 
     * @param t Objeto con la que se compara     * 
     * @return 
     * <ul>
     * <li>-1 si es menor que el pasado por parametro</li>
     * <li>-0 si son iguales</li>
     * <li>1 si es mayor que el pasado por parametro</li>
     * </ul>
     */
    @Override
    public int compareTo(Object t)
    {
        Contacto c = (Contacto)t;
        if(c==null || c.getNombre()==null)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            return this.getNombre().compareTo(c.getNombre());
        }        
    }
//</editor-fold>   

}
