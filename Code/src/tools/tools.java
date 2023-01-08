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

    public static int[] convert(int x, int y){
        // second value corresponds to current player or neighbor
        // 1: current player, 2: neighbor
        if (x < 4) {
            return new int[] {x + y*4, 1};
        }else{
            return new int[] {x*y, 2};
        }
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

    public static void setPartialDisable(JPanel panel, int indexplayer) {
        Component[] components = panel.getComponents();
        int columnShifter= (indexplayer > 2) ? 1 : 0;

        // top matrix: make left column accessible
            for (int i = 0; i < components.length; i++) {
                if ((i+columnShifter)%4 != 0){
                    components[i].setEnabled(false);
                }else{
                    components[i].setEnabled(true);
                }
            }
    }
}
