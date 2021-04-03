package test.beta.v1.components.props;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TextProps extends ComponentProps {
    private Color fontColor = Color.WHITE;
    private Font font = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/BasicallyASansSerif-Regular.ttf"));
    private Float fontSize = 40f;

    public TextProps() throws IOException, FontFormatException {

    }

    public TextProps(Color color, Font font, Float fontSize) throws IOException, FontFormatException {
        this.fontColor = color;
        this.font = font;
        this.fontSize = fontSize;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public void setFontSize(Float fontSize) {
        this.fontSize = fontSize;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public Font getFont() {
        return font;
    }

    public Float getFontSize() {
        return fontSize;
    }
}
