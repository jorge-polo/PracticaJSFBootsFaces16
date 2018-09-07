package com.mycompany.dao;

import com.mycompany.model.ClienteDireccion;
import java.util.ArrayList;


public interface ClienteDireccionDAO {
    public boolean createClienteDireccion(ClienteDireccion cld);
    public ArrayList<ClienteDireccion> readClienteDireccion();
    public boolean updateClienteDireccion(ClienteDireccion cld);
    public boolean deleteClienteDireccion(String id);
}
