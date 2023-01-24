/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Pedido;
import Classes.Producto;
import Repository.RepositoryDataBase.DataBase;
import Services.PedidoServices;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import org.neodatis.odb.ODB;

/**
 *
 * @author jairo
 */
public class MostrarPedidosController extends javax.swing.JFrame {

    private final PedidoServices pedidoServices;
    private Pedido pedidoSelected;
    private final String PENDIENTE = "Pendiente";
    private final String EN_CURSO = "EN_CURSO";
    private final String LISTO = "LISTO";
     private final String IDENTIFICADOR = "Identificador: ";
      private final String ESTADO_ACTUAL = "Estado actual: ";

    /**
     * Creates new form MostrarPedidosController
     */
    public MostrarPedidosController() {
        this.pedidoServices = new PedidoServices();
        initComponents();
        super.setVisible(true);
        super.setResizable(false);
        jPanelModificar.setVisible(false);
        jPanelModificar.setVisible(true);
        llenarCobox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxPedidos = new javax.swing.JComboBox<>();
        jPanelModificar = new javax.swing.JPanel();
        jLabelIdentificador = new javax.swing.JLabel();
        jLabelEstadoActual = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProductosPedido = new javax.swing.JList<>();
        jButtonAtras = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MOSTRAR PEDIDOS");

        jComboBoxPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPedidosActionPerformed(evt);
            }
        });

        jLabelIdentificador.setText("Identificador");

        jLabelEstadoActual.setText("Estado actual");

        jLabel4.setText("Nuevo estado");

        jScrollPane1.setViewportView(jListProductosPedido);

        javax.swing.GroupLayout jPanelModificarLayout = new javax.swing.GroupLayout(jPanelModificar);
        jPanelModificar.setLayout(jPanelModificarLayout);
        jPanelModificarLayout.setHorizontalGroup(
            jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIdentificador)
                    .addComponent(jLabelEstadoActual)
                    .addGroup(jPanelModificarLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelModificarLayout.setVerticalGroup(
            jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIdentificador)
                .addGap(18, 18, 18)
                .addComponent(jLabelEstadoActual)
                .addGap(18, 18, 18)
                .addGroup(jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxPedidos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(52, 52, 52))
        );

        jButtonAtras.setText("Atras");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonModificar)
                .addGap(18, 18, 18)
                .addComponent(jButtonAtras)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtras)
                    .addComponent(jButtonModificar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        super.dispose();
        Principal principal = new Principal();
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        DataBase dataBase = new DataBase();
        ODB conexion = dataBase.open();
        String nuevoEstado = String.valueOf(jComboBoxEstado.getSelectedItem());
        pedidoServices.upData(conexion, pedidoSelected.getIdPedido(), nuevoEstado);
        dataBase.close(conexion);
        llenarCobox();
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jComboBoxPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPedidosActionPerformed

        pedidoSelected = pedidoServices.getAll().get(jComboBoxPedidos.getSelectedIndex());
        llenarDatos(pedidoSelected);

    }//GEN-LAST:event_jComboBoxPedidosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MostrarPedidosController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarPedidosController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarPedidosController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarPedidosController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarPedidosController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JComboBox<String> jComboBoxPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelEstadoActual;
    private javax.swing.JLabel jLabelIdentificador;
    private javax.swing.JList<String> jListProductosPedido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelModificar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
/**
     * Llena combox con todos los pedidos en la bd
     */
    private void llenarCobox() {
        for (Pedido pedidoBD : pedidoServices.getAll()) {
            jComboBoxPedidos.addItem(pedidoBD.toString());
        }
    }

    /**
     * Llena todos los datos segun el id seleccionado en el combox
     *
     * @param pedido
     */
    private void llenarDatos(Pedido pedido) {
        jLabelIdentificador.setText(IDENTIFICADOR + pedido.getIdPedido());
        jLabelEstadoActual.setText(ESTADO_ACTUAL + pedido.getEstado());
        llenarComboxEstadoNuevo(pedido);
        llenarListaProductosPedido(pedido);
    }

    /**
     * Llena el combobox de las opciones para actualizar el estado
     *
     * @param pedido
     */
    private void llenarComboxEstadoNuevo(Pedido pedido) {
        jComboBoxEstado.removeAllItems();
        switch (pedido.getEstado()) {
            case PENDIENTE:
                jComboBoxEstado.addItem(EN_CURSO);
                break;
            case EN_CURSO:
                jComboBoxEstado.addItem(LISTO);
                break;
        }
    }

    /**
     * Metodo para llenar la lista de productos que pertenecen a un pedido
     *
     * @param pedido pedido de cliente
     */
    private void llenarListaProductosPedido(Pedido pedido) {
        ArrayList<Producto> productosPedido = pedido.getListaPedidos();

        DefaultListModel modelo = new DefaultListModel();
        modelo.removeAllElements();

        for (Producto product : productosPedido) {
            modelo.addElement(product.toString());
        }
        jListProductosPedido.setModel(modelo);
    }

}