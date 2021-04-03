package test.beta.v1;

import test.beta.v1.components.props.TextProps;

import java.awt.*;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException, FontFormatException {
        DitchGUI gui = new DitchGUI();
        gui.start();

        TextProps textProps = new TextProps();
        textProps.setFontColor(Color.BLUE);

        while(gui.isRunning()){
            gui.addText("text", textProps);

            gui.renderNextFrame();
        }
    }
}
