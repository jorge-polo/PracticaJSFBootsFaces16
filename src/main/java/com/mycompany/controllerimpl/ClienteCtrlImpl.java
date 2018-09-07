package com.mycompany.controllerimpl;

import com.mycompany.configbd.Conexionbd;
import com.mycompany.dao.ClienteDAO;
import com.mycompany.model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteCtrlImpl implements ClienteDAO{
    Conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<Cliente> listDatos;
    public ClienteCtrlImpl() {
        cx = new Conexionbd();
    }

    @Override
    public boolean createCliente(Cliente cl) {
        sql = "INSERT INTO public.cliente( nombres_razon_social, telefono, correo, dni_ruc)"
                +"VALUES('"+cl.getNombres_razon_social()+"','"+cl.getTelefono()+"','"+cl.getCorreo()+"','"+cl.getDni_ruc()+"')";
        
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public ArrayList<Cliente> readCliente() {
        listDatos = new ArrayList<>();
        sql = "SELECT id_cliente, nombre_razon_social , telefono, correo, dni_ruc "
                + "    FROM public.cliente";
        rs = cx.executeQuery(sql);
        try {
            while (rs.next()) {
                    listDatos.add(new Cliente(rs.getNString("id_cliente"),rs.getString("nombres_razon_social"),rs.getString("telefono"),rs.getNString("correo"),rs.getString("dni_ruc")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCtrlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }

    @Override
    public boolean updateCliente(Cliente cl) {
        sql = "UPDATE public.cliente SET"
                +" nombres_razon_social = '"+cl.getNombres_razon_social()+"', telefono = '"+cl.getTelefono()+"', correo = '"+cl.getCorreo()+"' dni_ruc = '"+cl.getDni_ruc()+"'"
                +"WHERE id_cliente = "+cl.getId_cliente()+"";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public boolean deleteCliente(String id) {
        sql = "DELETE FROM public.cliente "
                +"WHERE id_cliente = "+id+"";
        return cx.executeInsertUpdate(sql);
    }
    
}
