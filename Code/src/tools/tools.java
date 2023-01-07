package tools;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JPanel;

public class tools {
    public static void setImage(Component button, int value){
        JButton b = (JButton) button;
        b.setIcon(new ImageIcon("ressources\\"+value+".jpg"));
    }

    public static int convert(int x, int y){
        return (x+1) + y*4;
    }

    public static int[] convert(int i){
        int x, y; 
        y = i/4;
        x = i - (y*4);
        return new int[] {x, y};
    }

    public static void setEnabled(JPanel panel, boolean enabled) {
        Component[] components = panel.getComponents();
        for (Component comp : components) {
            comp.setEnabled(enabled);
        }
    }

    public static void setPartialDisable(JPanel panel) {
        Component[] components = panel.getComponents();
        for (int i = 0; i < components.length; i++) {
            if (i %4 != 0){
                components[i].setEnabled(false);
            }else{
                components[i].setEnabled(true);
            }
        }
    }

}
