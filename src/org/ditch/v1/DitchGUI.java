package org.ditch.v1;

import org.ditch.v1.components.Component;
import org.ditch.v1.components.Text;
import org.ditch.v1.components.props.PositionProps;
import org.ditch.v1.components.props.TextProps;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*TODO: create the class layout
    Class:
        Global Configs
        Methods to Write to Queue
        Main Window Creation Method

 */
public class DitchGUI extends Canvas implements Runnable{
    // * Properties
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    // * Tick/Frame Variables
    private long lastTime = System.nanoTime();
    private double amountOfTicks = 60.0;
    private double ns = 1000000000 / amountOfTicks;
    private double delta = 0;
    private long timer = System.currentTimeMillis();
    private int frames = 0;

    // * GUI Window Thread
    private Thread thread;
    private final List<Component> components = new ArrayList<>();
    private volatile boolean running = false;

    // - Global Variables
    TextProps textProps = new TextProps();

    // - Object Creation
    public DitchGUI() throws IOException, FontFormatException {
        JFrame frame = new JFrame("DitchGUI Window");

        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
    }

    public DitchGUI(String title) throws IOException, FontFormatException {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
        this.start();
    }

    public DitchGUI(int width, int height) throws IOException, FontFormatException {
        JFrame frame = new JFrame("DitchGUI Window");

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
        this.start();
    }

    public DitchGUI(String title, int width, int height) throws IOException, FontFormatException {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
        this.start();
    }

    // - Thread Management
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
        /*
         * OBJECTIVE: MAKE THIS LOOP RUN IN THE MAIN FUNCTION
         */

        while (running) {
            Thread.onSpinWait();
        }

        stop();
    }

    public void renderNextFrame(){
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

        components.clear();
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

        //list things \o/
        try {
            int num = 1;

            for(int i = 0; i < components.size(); i++){
                components.get(i).render(g, new PositionProps(100, 60*num));
                num++;
            }
        } catch (NullPointerException ignored) { /* literally useless */ }

        //end functions to clear caching
        g.dispose();
        bs.show();
    }

    public boolean isRunning() {
        return running;
    }

    public void add(Component component){
        components.add(component);
    }

    // * text methods
    public void addText(String text) throws IOException, FontFormatException {
        Text text1 = new Text(text, textProps);
        components.add(text1);
    }

    public void addText(String text, TextProps textProps) throws IOException, FontFormatException {
        Text text1 = new Text(text, textProps);
        components.add(text1);
    }
}
