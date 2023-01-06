package tools;

import java.awt.Component;
import javax.swing.JPanel;

public class JPanelExtensions{

    public static void setEnabled(JPanel panel, boolean enabled) {
        // TODO Auto-generated method stub
        Component[] components = panel.getComponents();
        for (Component comp : components) {
            comp.setEnabled(enabled);
        }
    }
}
