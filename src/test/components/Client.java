package test.components;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

public class Client extends Canvas implements Runnable{
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    private Thread thread;
    private boolean running = false;

    public Client(){
        new Window(WIDTH, HEIGHT, "test", this);
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        /*
         * OBJECTIVE: MAKE THIS LOOP RUN IN THE MAIN FUNCTION
         */
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1){
                tick();
                delta--;
            }
            if(running){
                try {
                    render();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (FontFormatException e) {
                    e.printStackTrace();
                }
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }

        stop();
    }

    private void tick(){

    }

    private void render() throws IOException, FontFormatException {
        //create buffer strategy
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        //setup graphics settings
        Graphics gRaw = bs.getDrawGraphics();
        Graphics2D g = (Graphics2D)gRaw;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHints(rh);

        //set bg color
        g.setColor(new Color(10, 10, 10));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //set font options
        Font fontRaw = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/BasicallyASansSerif-Regular.ttf"));
        Font font = fontRaw.deriveFont(70f);

        g.setColor(Color.white);
        g.setFont(font);

        //actual functions here
        g.drawString("fishy has firetruck with brother", 100, 100);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Client();
    }

    //TODO: create a unwrapper function to simplfy gu=i cration

}
