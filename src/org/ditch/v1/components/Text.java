package org.ditch.v1.components;

import org.ditch.v1.components.props.PositionProps;
import org.ditch.v1.components.props.TextProps;

import java.awt.*;
import java.io.IOException;

public class Text extends Component {
    private TextProps props;
    private String value;

    public Text(String value, TextProps props) throws IOException, FontFormatException {
        super(props);
        this.value = value;
        this.props = props;
    }

    public void render(Graphics g, PositionProps pos) throws IOException, FontFormatException {
        //set font options
        Font fontRaw = props.getFont();
        Font font = fontRaw.deriveFont(props.getFontSize());

        g.setColor(props.getFontColor());
        g.setFont(font);

        g.drawString(value, pos.getX(), pos.getY());
    }

    public void setProps(TextProps props) {
        this.props = props;
    }

    public TextProps getProps() {
        return props;
    }
}
