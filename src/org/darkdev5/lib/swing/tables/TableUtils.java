package org.darkdev5.lib.swing.tables;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class TableUtils {

    /**
     * Set the size of specific column in the table.
     *
     * @param table       The table you want to change a column in it.
     * @param columnIndex The position of that column from table.
     * @param width       The new width you want to set for that column.
     */
    public static void setColumnWidth(JTable table, int columnIndex, int width) {
        table.getColumnModel().getColumn(columnIndex).setPreferredWidth(width);
    }

    public static void setColumnHeaderPosition(JTable table, int alignment) {
    }

    /**
     * Clears the entire of table.
     *
     * @param table        The table you want to clear.
     * @param clearColumns Enable this if you want to clear the entire table with even columns.
     */
    public static void clear(JTable table, boolean clearColumns) {
        if (clearColumns) {
            table.setModel(new DefaultTableModel());
        } else {
            DefaultTableModel dm = (DefaultTableModel) table.getModel();

            while (dm.getRowCount() > 0) {
                dm.removeRow(0);
            }
        }
    }

    /**
     * Sort entire table by a specific column
     *
     * @param table       The table you want to sort all of its data.
     * @param sortOrder    The sort order is ascending or descending.
     * @param columnIndex Select the position of the column in the table.
     */
    public static void sort(JTable table, SortOrder sortOrder, int columnIndex) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(columnIndex, sortOrder));

        sorter.setSortKeys(sortKeys);
    }
}
