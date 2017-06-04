import greenfoot.*;
import java.awt.font.FontRenderContext;
import java.awt.Color;
import java.awt.Graphics2D;

public class Text extends Actor
{
    public Text(int length) {
        GreenfootImage txtImg = new GreenfootImage(length * 14, 16);
        txtImg.setColor(greenfoot.Color.BLACK);
        setImage(txtImg);
    }

    public Text(String text)  {
        this (text.length());
        setText(text);
    }

    public void setText(String text) {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text, 2, 12);
    }

    public void setLocation(int x, int y){
        super.setLocation(x + getImage().getWidth() / 2, y);
    }
}
