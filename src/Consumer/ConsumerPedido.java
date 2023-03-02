/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumer;

import Classes.Pedido;
import com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author jairo
 */
public class ConsumerPedido {

    private final String QUEUE_NAME = "PEDIDO";
    private final String HOST = "localhost";
    private String message;
    private final ArrayList<Pedido> pedidosRabit = new ArrayList<>();
    private final String ESTADO_PENDIENTE = "Pendiente";

    /**
     * Metodo que lee la cola del Rabbitmq
     *
     * @return String con los datos leiidos
     * @throws IOException
     * @throws TimeoutException
     * @throws InterruptedException
     */
    public ArrayList<Pedido> consumerProducer() throws IOException, TimeoutException, InterruptedException, NullPointerException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        try {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    message = new String(body, "UTF-8");
                    Pedido pedido = new Gson().fromJson(message, Pedido.class);
                    pedido.setEstado(ESTADO_PENDIENTE);
                    pedidosRabit.add(pedido);
                }
            };

            channel.basicConsume(QUEUE_NAME, true, consumer);
            Thread.sleep(1500);
        } finally {
            channel.close();
            connection.close();
        }
        return pedidosRabit;

    }

}
