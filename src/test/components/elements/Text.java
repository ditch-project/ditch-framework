package test.components.elements;

public class Text {
    private String text;
    private int font;
    private int positionX;
    private int positionY;

    public Text(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void render(){

    }
}
