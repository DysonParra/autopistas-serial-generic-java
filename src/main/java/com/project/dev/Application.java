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
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
 */
package com.project.dev;

import com.project.dev.dummy.serial.generic.client.GenericSerialClient;
import com.project.dev.dummy.serial.generic.client.GenericSerialMessageListener;

/**
 * TODO: Description of {@code Application}.
 *
 * @author Dyson Parra
 * @since 11
 */
public class Application {

    /**
     * Entrada principal del sistema.
     *
     * @param args argumentos de la linea de comandos.
     */
    public static void main(String[] args) {
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
