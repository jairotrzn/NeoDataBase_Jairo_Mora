/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author jairo
 */
public class Pedido {
    private String emailUsuario;
    private String idPedido;
    private String estado;
    private ArrayList<Producto> listaProductos;
    
    public Pedido(String email,String idPedido,ArrayList<Producto> listaProductos){
        this.emailUsuario = email;
        this.idPedido = idPedido;
        this.listaProductos = listaProductos;
        this.estado = "Pendiente";
    }

    public String getIdPedido() {
        return idPedido;
    }

    public ArrayList<Producto> getListaPedidos() {
        return listaProductos;
    }

    public String getEmail() {
        return emailUsuario;
    }

    public void setEmail(String email) {
        this.emailUsuario = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return idPedido + " ------ " + estado ;
    }

    

 
    
    
}
