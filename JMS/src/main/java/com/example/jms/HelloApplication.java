package com.example.jms;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class HelloApplication extends Application {
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

    public class JMSProducer {

        public static void main(String[] args) {
            String brokerUrl = "tcp://localhost:61616";
            String queueName = "UserQueue";

            try {
                ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
                Connection connection = connectionFactory.createConnection();
                connection.start();

                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Destination destination = session.createQueue(queueName);

                MessageProducer producer = session.createProducer(destination);

                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("UserName", "John");
                mapMessage.setLong("Time", System.currentTimeMillis());
                mapMessage.setString("Description", "Sample message from John");

                producer.send(mapMessage);

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}