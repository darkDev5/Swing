package org.darkdev5.lib.swing.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class WindowUtils {

    /**
     * Set window to the center of the screen.
     *
     * @param window The window you want to change its position.
     */
    public static void setWindowCenter(Window window) {
        window.setLocationRelativeTo(null);
    }

    /**
     * Enables a special key for closing the window.
     *
     * @param frame   The JFrame window.
     * @param keyCode The key code from KeyEvent class that you want to make window close by.
     */
    public static void setWindowCloseByKey(JFrame frame, int keyCode) {
        frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(keyCode, 0), "Cancel");

        frame.getRootPane().getActionMap().put("Cancel", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    /**
     * Enables a special key for closing the window.
     *
     * @param dialog  The JDialog window.
     * @param keyCode The key code from KeyEvent class that you want to make window close by.
     */
    public static void setWindowCloseByKey(JDialog dialog, int keyCode) {
        dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(keyCode, 0), "Cancel");

        dialog.getRootPane().getActionMap().put("Cancel", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
    }

    /**
     * You can move window almost from anywhere on the window itself.
     * Even you can move window from the components in the window.
     *
     * @param window The window you want to move.
     */
    public static void moveWindowByMouse(Window window) {
        Point point = new Point();

        window.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                point.x = e.getX();
                point.y = e.getY();
            }
        });


        window.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = window.getLocation();
                window.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
            }
        });
    }

    /**
     * Set all the components text direction of window to right or left.
     *
     * @param window      The window you want to access its components.
     * @param orientation The text orientation of the components in the window.
     */
    public static void setWindowComponentsTextDirection(Window window, ComponentOrientation orientation) {
        Arrays.asList(window.getComponents()).forEach((cmp) -> {
            cmp.applyComponentOrientation(orientation);
        });
    }
}
