/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Classes.Pedido;
import Repository.RepositoryDataBase.DataBase;
import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author jairo
 */
public class PedidoRepository {

    private final DataBase dataBase = new DataBase();

    /**
     * Metodo para guardar pedidos en la BD
     *
     * @param pedido
     */
    public void save(Pedido pedido) {
        ODB conexion = dataBase.open();
        conexion.store(pedido);
        dataBase.close(conexion);
    }

    /**
     * Metodo para obtener todos los pedidos en la BD
     *
     * @return ArrayList con los pedidos
     */
    public ArrayList<Pedido> getAll() {
        ArrayList<Pedido> pedidiosBD = new ArrayList<>();
        ODB conexion = dataBase.open();
        Objects<Pedido> listaPedidos = conexion.getObjects(Pedido.class);
        while (listaPedidos.hasNext()) {
            pedidiosBD.add(listaPedidos.next());
        }
        dataBase.close(conexion);
        return pedidiosBD;
    }

    /**
     * Metodo para encontar un pedido en la BD por su id
     *
     * @param conexion conexion ODB
     * @param id
     * @return
     */
    public Pedido findOneById(ODB conexion, String id) {
        System.out.println("el id es " + id);
        IQuery query = new CriteriaQuery(Pedido.class, Where.equal("idPedido", id));
        return (Pedido) conexion.getObjects(query).getFirst();
    }

    /**
     * Metodo para upDate un pedido
     *
     * @param conexion conexion ODB
     * @param pedido clase pedido que se va a aactualizar
     */
    public void upDate(ODB conexion, Pedido pedido) {
        conexion.store(pedido);
        conexion.commit();
    }
}
