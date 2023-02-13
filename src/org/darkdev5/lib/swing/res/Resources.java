package org.darkdev5.lib.swing.res;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class Resources {

    /**
     * You can set or change a component icon and load from resources.
     *
     * @param component The component you want to change its icon.
     * @param path      The icon path in your resources.
     */
    public static void setComponentIcon(Component component, String path) {
        setComponentIcon(component, path, 20, 20);
    }

    /**
     * You can set or change a component icon and load from resources.
     *
     * @param component The component you want to change its icon.
     * @param path      The icon path in your resources.
     * @param x         The width of icon.
     * @param y         The height of icon.
     */
    public static void setComponentIcon(Component component, String path, int x, int y) {
        ImageIcon i = new ImageIcon((Objects.requireNonNull(Resources.class.getResource(path))));
        Image image = i.getImage();

        Image newImg = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
        i = new ImageIcon(newImg);

        if (component instanceof JMenuItem) {
            ((JMenuItem) component).setIcon(i);
        } else if (component instanceof JButton) {
            ((JButton) component).setIcon(i);
        } else if (component instanceof JLabel) {
            ((JLabel) component).setIcon(i);
        } else if (component instanceof JToggleButton) {
            ((JToggleButton) component).setIcon(i);
        }
    }
}
