package com.osroyale.login.impl;

import com.osroyale.Client;

public class LoginRenderThread extends Thread {
    private boolean stillRunning;
    private Client client;

    public LoginRenderThread(Client client) {
        this.client = client;
        stillRunning = true;
    }

    @Override
    public void run() {
        while (stillRunning)
        {
            try {
                client.loginRenderer.display();
                Thread.sleep(10);
            } catch (Exception e) {
                //Fuck'em
            }
            //client.loginRenderer.click(); //NO - BAD. DO NOT IMPLEMENT THIS LINE.
        }
    }

    public void stopRendering() {
        stillRunning = false;
    }
}
