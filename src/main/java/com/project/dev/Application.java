/*
 * @fileoverview    {Application}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementación realizada.
 * @version 2.0     Documentación agregada.
 */
package com.project.dev;

import com.project.dev.dummy.serial.generic.client.GenericSerialClient;
import com.project.dev.dummy.serial.generic.client.GenericSerialMessageListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * TODO: Definición de {@code Application}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {

    /**
     * TODO: Definición de {@code main}.
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * TODO: Definición de {@code run}.
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("START");
        GenericSerialClient serialClient = new GenericSerialClient("COM3", 9600, 8, 1, 0);
        serialClient.setOnMessageListener(new GenericSerialMessageListener() {
            @Override
            public void onMessage(String message) {
            }

            @Override
            public void onResponse(String response) {
                System.out.println("<" + response.replaceAll("\n", "") + ">");
                int weight = Integer.parseInt(response.substring(3).replaceAll("[a-zA-Z]|\\s", ""));
                System.out.println("'" + weight + "'");
            }
        });

        new Thread(serialClient).start();
        System.out.println("END.");
        //System.exit(0);
    }
}
