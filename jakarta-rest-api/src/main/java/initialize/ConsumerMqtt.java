
package initialize;

import javax.servlet.annotation.WebListener;
import javax.inject.Inject;
import javax.servlet.ServletContextListener;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

@WebListener
public class ConsumerMqtt implements ServletContextListener {

    private static final String EXCHANGE_NAME = "logs";    

    private static String host = "broker_host";
	private static String broker_host = System.getenv(host);

    public ConsumerMqtt() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(broker_host);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
            Gson gson = new Gson();

			CapteurEnvBusiness nosCapteurs = gson.fromJson(message, CapteurEnvBusiness.class); 

			

			


        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }

}
