package com.hellojava.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.hellojava.akka.logging.LoggingSource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

/**
 * @description: com.hellojava.akka.AkkaApp
 * @author: Liu Ran
 * @date: 7/28/23 15:42
 */
public class AkkaApp {
    public static void main(String[] args) throws IOException {
        ActorSystem system = ActorSystem.create("log-system");

        try {
            ActorRef logging = system.actorOf(LoggingSource.props(), "logging-source");
            System.out.println("First: " + logging);


            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String command = sc.next();
                System.out.println(command);
                logging.tell(command, ActorRef.noSender());
            }
        } finally {
            system.terminate();
        }
    }
}
