package com.mycompany.test;

import com.mycompany.controllerimpl.ClienteDireccionCtrlImpl;
import com.mycompany.dao.ClienteDireccionDAO;
import com.mycompany.model.ClienteDireccion;
import java.util.ArrayList;


public class TestClienteDireccion {

    static ArrayList<ClienteDireccion> list = new ArrayList<>();
    
    public static void main(String[] args) {
       ClienteDireccionDAO clddao;
       clddao = new ClienteDireccionCtrlImpl();
       
       ClienteDireccion cld = new ClienteDireccion();
       cld.setDireccion("Jr:Rosales");
       cld.setId_cliente("1");
       if(clddao.createClienteDireccion(cld)){
            System.err.println("insertado");
        }else{
            System.err.println("error al insertar");
        }
    }
    
}
