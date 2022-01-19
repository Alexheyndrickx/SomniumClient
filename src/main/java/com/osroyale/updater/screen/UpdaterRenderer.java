package com.osroyale.updater.screen;

import com.osroyale.Client;
import com.osroyale.GraphicsBuffer;
import com.osroyale.Raster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.DataBufferInt;

/**
 * Handles the rendering of the updater screen.
 */
public class UpdaterRenderer implements ActionListener {

    /**
     * The client instance.
     */
    private final Client client;

    /**
     * The graphics object to draw to.
     */
    private final Graphics graphics;

    /**
     * The screen to render.
     */
    public UpdateComponent screen;

    private final Timer timer = new Timer(25, this);

    /**
     * Constructs a new {@code UpdateRenderer}.
     *
     * @param client the client instance
     */
    public UpdaterRenderer(Client client, Graphics graphics) {
        this.client = client;
        this.graphics = graphics;
    }

    /**
     * Sets the next screen.
     */
    public void setScreen(UpdateComponent screen) {
        this.screen = screen;
        screen.setup(client);
        int[] raster = ((DataBufferInt) screen.getImage().getRaster().getDataBuffer()).getData();
        Client.updaterScreenIP = new GraphicsBuffer(765, 503, raster, client.getGameComponent());
        Client.updaterScreenIP.initDrawingArea();
        timer.restart();
    }

    private void process() {
        if (screen != null)
            screen.process();
    }

    private void render() {
        if (screen != null && Client.updaterScreenIP != null) {
            Raster.reset(new Color(38, 38, 38));
            screen.render(client);

            if (Client.updaterScreenIP != null && graphics != null)
                Client.updaterScreenIP.drawGraphics(graphics, 0, 0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        process();
        render();
    }

    public void finish() {
        timer.stop();
    }


}
