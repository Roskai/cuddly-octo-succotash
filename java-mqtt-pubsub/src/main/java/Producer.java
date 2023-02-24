import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.TimeUnit; 

import com.google.gson.Gson; 

public class Producer {

	private static final String TOPIC_ENV = "Env";
	private static final String ROUTING_KEY = "#my_route";

	private static String host = "broker_host";
	private static String broker_host = System.getenv(host);

	public static void main(String[] argv) throws Exception {
		
		int hour =1; 

		System.out.println(broker_host);

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(broker_host);
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.exchangeDeclare(TOPIC_ENV, "fanout");

			for (int i=1; i<=24; i++){
                

			EnvironmentCaptor obj = new EnvironmentCaptor(hour); 
			
			Gson gson = new Gson();
			String message = gson.toJson(obj);

			System.out.println("Routing key : " + ROUTING_KEY + " ; message : " + obj.toString());

			channel.basicPublish(TOPIC_ENV, ROUTING_KEY, null, message.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + obj.toString() + "'");

			    try{
                    TimeUnit.SECONDS.sleep(3);
                }catch (Exception e){
                    System.out.println("erreur sleep");
                }
			hour = hour+1;
			}
		}
	}

}
