package org.ditch.v1.components;

import org.ditch.v1.components.props.ComponentProps;
import org.ditch.v1.components.props.PositionProps;

import java.awt.*;
import java.io.IOException;

public abstract class Component {
    public Component(){

    }

    public Component(ComponentProps props){

    }

    public void render(Graphics g, PositionProps position) throws IOException, FontFormatException {

    }
}
