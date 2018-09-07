package com.mycompany.test;

import com.mycompany.controllerimpl.ClienteCtrlImpl;
import com.mycompany.dao.ClienteDAO;
import com.mycompany.model.Cliente;
import java.util.ArrayList;


public class TestCliente {

    static ArrayList<Cliente> list = new ArrayList<>();
    
    public static void main(String[] args) {
       ClienteDAO cldao;
       cldao = new ClienteCtrlImpl();
       
       Cliente cl = new Cliente();
       //cl.setId_cliente("1");
       cl.setNombres_razon_social("Jorgex");
       cl.setTelefono("98754321");
       cl.setCorreo("marcopolo@upeu.edu.pe");
       cl.setDni_ruc("78675645");
       if(cldao.createCliente(cl)){
            System.err.println("insertado");
        }else{
            System.err.println("error al insertar");
        }
    }
    
}
