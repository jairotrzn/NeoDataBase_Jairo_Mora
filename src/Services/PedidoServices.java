/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Consumer.ConsumerPedido;
import Classes.Pedido;
import Repository.PedidoRepository;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;
import org.neodatis.odb.ODB;

/**
 *
 * @author jairo
 */
public class PedidoServices {

    private final PedidoRepository pedidoRepository = new PedidoRepository();
    private final ConsumerPedido rabbitServices = new ConsumerPedido();

    /**
     * Metodo para almacenar en la bd
     *
     * @param orders
     * @throws IOException
     * @throws TimeoutException
     * @throws InterruptedException
     * @throws NullPointerException
     */
    public void save(ArrayList<Pedido> orders) throws IOException, TimeoutException, InterruptedException, NullPointerException {
        System.out.println("Voy a guardar");
        for (Pedido order : orders) {
            pedidoRepository.save(order);
        }
        System.out.println("Prodcutos guardados");
    }

    /**
     * Obtiene el String en formato JSON para enviar a Rabbit
     *
     * @param pedido Objeto que deseamos convertir
     * @return String con formato
     */
    private String obtenerJSON(Pedido pedido) {
        Gson gson = new Gson();
        String pedidoJSON = gson.toJson(pedido);
        return pedidoJSON;
    }

    /**
     * Metodo para obtener todos los pedidos
     *
     * @return ArrayList
     */
    public ArrayList<Pedido> getAll() {
        return pedidoRepository.getAll();
    }

    public ArrayList<Pedido> consumerRabbit() throws IOException, TimeoutException, InterruptedException, NullPointerException {

        return rabbitServices.consumerProducer();

    }

    public void upData(ODB conexion,String id, String nuevoEstado) {
        System.out.println("Estoy en el services");
        Pedido pedido = pedidoRepository.findOneById(conexion,id);
        System.out.println("datos " + pedido.toString());
        pedido.setEstado(nuevoEstado);
        pedidoRepository.upDate(conexion,pedido);
    }

}
