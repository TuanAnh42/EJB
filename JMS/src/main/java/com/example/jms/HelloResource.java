package com.example.jms;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
    import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Date;

    public class JMSConsumer {

        public static void main(String[] args) {
            String brokerUrl = "tcp://localhost:61616";
            String queueName = "UserQueue";

            try {
                ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
                Connection connection = connectionFactory.createConnection();
                connection.start();

                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Destination destination = session.createQueue(queueName);

                MessageConsumer consumer = session.createConsumer(destination);

                Message message = consumer.receive();
                if (message instanceof MapMessage) {
                    MapMessage mapMessage = (MapMessage) message;
                    String userName = mapMessage.getString("UserName");
                    long time = mapMessage.getLong("Time");
                    String description = mapMessage.getString("Description");

                    System.out.println("Received Message:");
                    System.out.println("UserName: " + userName);
                    System.out.println("Time: " + new Date(time));
                    System.out.println("Description: " + description);
                }

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}