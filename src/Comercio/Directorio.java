package Comercio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JOptionPane;
    
public class Directorio{
    
    TreeMap <Long,Cliente> directorio=new TreeMap<>();
    
    public boolean agregarCliente(long telefono,Cliente cliente) {
        if(!directorio.containsKey(telefono)) {
            directorio.put(telefono,cliente);
            return true;
        } else {
            return false;
        }
    }
    
    
    public Cliente buscarCliente(long telefono) {
        return directorio.get(telefono);
    }
    
    public List<Long> buscarTelefono(String apellido) {
        ArrayList<Long> telefonos= new ArrayList<>();
        
        Set<Long> tel=directorio.keySet();
        
        Iterator<Long> it= tel.iterator();
        
        while(it.hasNext()) {
            Long telefono= it.next();
            Cliente c= directorio.get(telefono);
            if(c.getApellido().equals(apellido))
                telefonos.add(telefono);
        }
        return telefonos;
    }
    
    public List<Cliente> buscarClientes(String ciudad){
        ArrayList<Cliente> clientes = new ArrayList<>();
        Set<Long> tels = directorio.keySet();
        Iterator<Long> it = tels.iterator();
        
        while(it.hasNext()){
            Long telefono = it.next();
            Cliente c = directorio.get(telefono);
            if(c.getCiudad().equals(ciudad)){
                clientes.add(c);
            }
        }
        return clientes;
    }

    public Cliente borrarClientes(long telefono) {
        Cliente clienteABorrar=directorio.remove(telefono);
        
        if(clienteABorrar!=null)
            JOptionPane.showMessageDialog(null, "Cliente Borrado");    
        else 
            JOptionPane.showMessageDialog(null, "No existe un cliente asociado a este telefono");
        
        return clienteABorrar;

    }
}

