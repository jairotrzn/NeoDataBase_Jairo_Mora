/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository.RepositoryDataBase;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author jairo
 */
public class DataBase {

    private final String NOMBRE_DB = "Almacen.db";

    /**
     * Abrir sesion con DB
     *
     * @return ODB
     */
    public ODB open() {
        return ODBFactory.open(NOMBRE_DB);
    }

    /**
     * Cerrar session
     *
     * @param session sesion con Db
     */
    public void close(ODB session) {
        session.close();
    }
}
