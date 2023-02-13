package org.darkdev5.lib.swing.list;

import javax.swing.*;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class ListUtils {

    public static <E> void clear(JList<E> list) {
        DefaultListModel<E> model = (DefaultListModel) list.getModel();
        model.removeAllElements();

        list.setModel(model);
    }

    /**
     * Add new element to end of the list.
     *
     * @param list The list you want to add element into.
     * @param item The new item that is a String.
     * @param <E>  JList uses generic model to manipulate items in it.
     */
    public static <E> void add(JList<E> list, String item) {
        ListModel<E> listModel = list.getModel();
        DefaultListModel defaultListModel = new DefaultListModel();

        for (int j = 0; j < listModel.getSize(); j++) {
            defaultListModel.addElement(listModel.getElementAt(j));
        }

        defaultListModel.addElement(item);
        list.setModel(defaultListModel);
    }

    /**
     * Removes an element from the list.
     *
     * @param list  The list you want to remove element from.
     * @param index The position of that element in the list.
     * @param <E>   JList uses generic model to manipulate items in it.
     */
    public static <E> void remove(JList<E> list, int index) {
        ((DefaultListModel<E>) list.getModel()).remove(index);
    }
}
