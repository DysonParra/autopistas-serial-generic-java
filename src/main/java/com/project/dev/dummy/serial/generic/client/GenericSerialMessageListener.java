/*
 * @fileoverview    {GenericSerialMessageListener}
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
package com.project.dev.dummy.serial.generic.client;

/**
 * TODO: Definición de {@code GenericSerialMessageListener}.
 *
 * @author Dyson Parra
 * @since 11
 */
public abstract class GenericSerialMessageListener {

    /**
     * TODO: Definición de {@code onMessage}.
     *
     * @param message
     */
    public abstract void onMessage(String message);

    /**
     * TODO: Definición de {@code onResponse}.
     *
     * @param response
     */
    public abstract void onResponse(String response);

}
