package com.mycompany.controllerimpl;

import com.mycompany.configbd.Conexionbd;
import com.mycompany.dao.ClienteDireccionDAO;
import com.mycompany.model.ClienteDireccion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDireccionCtrlImpl implements ClienteDireccionDAO{
    Conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<ClienteDireccion> listDatos;
    public ClienteDireccionCtrlImpl() {
        cx = new Conexionbd();
    }

    @Override
    public boolean createClienteDireccion(ClienteDireccion cld) {
        sql = "INSERT INTO public.cliente_direccion( direccion, id_cliente)"
                +"VALUES('"+cld.getDireccion()+"','"+cld.getId_cliente()+"')";
        
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public ArrayList<ClienteDireccion> readClienteDireccion() {
        listDatos = new ArrayList<>();
        sql = "SELECT id_cliente_direccion, direccion , id_cliente "
                + "    FROM public.cliente_direccion";
        rs = cx.executeQuery(sql);
        try {
            while (rs.next()) {
                    listDatos.add(new ClienteDireccion(rs.getNString("id_cliente_direccion"),rs.getString("direccion"),rs.getString("id_cliente")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDireccionCtrlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }

    @Override
    public boolean updateClienteDireccion(ClienteDireccion cld) {
        sql = "UPDATE public.cliente_direccion SET"
                +" direccion = '"+cld.getDireccion()+"', id_cliente = '"+cld.getId_cliente()+"'"
                +"WHERE id_cliente_direccion = "+cld.getId_cliente_direccion()+"";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public boolean deleteClienteDireccion(String id) {
        sql = "DELETE FROM public.cliente_direccion "
                +"WHERE id_cliente_direccion = "+id+"";
        return cx.executeInsertUpdate(sql);
    }

    
}
