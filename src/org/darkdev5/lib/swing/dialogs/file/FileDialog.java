package org.darkdev5.lib.swing.dialogs.file;

import lombok.Getter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public @Getter class FileDialog {
    private final String title;
    private final String startPath;

    private final int fileDialogType;
    private final boolean multipleSelection;

    private final List<FileNameExtensionFilter> filters;

    private FileDialog(FileDialogBuilder fileDialogBuilder) {
        this.title = fileDialogBuilder.title;
        this.startPath = fileDialogBuilder.startPath;

        this.fileDialogType = fileDialogBuilder.fileDialogType;
        this.multipleSelection = fileDialogBuilder.multipleSelection;

        this.filters = fileDialogBuilder.filters;
    }

    /**
     * Open dialog to select files.
     *
     * @return The paths of selected files from the user.
     */
    public List<File> open() {
        JFileChooser fileChooser = new JFileChooser();
        List<File> selectedFiles = new ArrayList<>();

        fileChooser.setCurrentDirectory(new File(startPath));
        fileChooser.setDialogTitle(title);
        fileChooser.setMultiSelectionEnabled(multipleSelection);
        fileChooser.setFileSelectionMode(fileDialogType);

        filters.forEach(fileChooser::addChoosableFileFilter);

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            if (multipleSelection) {
                selectedFiles.addAll(Arrays.asList(fileChooser.getSelectedFiles()));
            } else {
                selectedFiles.add(fileChooser.getSelectedFile());
            }
        }

        return selectedFiles;
    }

    /**
     * Open dialog to save files.
     *
     * @return The paths of selected files from the user.
     */
    public List<File> save() {
        JFileChooser fileChooser = new JFileChooser();
        List<File> selectedFiles = new ArrayList<>();

        fileChooser.setCurrentDirectory(new File(startPath));
        fileChooser.setDialogTitle(title);
        fileChooser.setMultiSelectionEnabled(multipleSelection);
        fileChooser.setFileSelectionMode(fileDialogType);

        filters.forEach(fileChooser::addChoosableFileFilter);

        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            if (multipleSelection) {
                selectedFiles.addAll(Arrays.asList(fileChooser.getSelectedFiles()));
            } else {
                selectedFiles.add(fileChooser.getSelectedFile());
            }
        }

        return selectedFiles;
    }


    /**
     * @author darkDev5
     * @version 1.0
     * @since 17
     */
    public static class FileDialogBuilder {
        private String title;
        private String startPath;

        private int fileDialogType;
        private boolean multipleSelection;

        private List<FileNameExtensionFilter> filters;

        public FileDialogBuilder() {
            this.title = "Select";
            this.startPath = System.getProperty("user.home");

            this.fileDialogType = JFileChooser.FILES_AND_DIRECTORIES;
            this.multipleSelection = false;

            this.filters = new ArrayList<>();
        }

        public FileDialogBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public FileDialogBuilder setStartPath(String startPath) {
            this.startPath = startPath;
            return this;
        }

        public FileDialogBuilder setFileDialogType(int fileDialogType) {
            this.fileDialogType = fileDialogType;
            return this;
        }

        public FileDialogBuilder setMultipleSelection(boolean multipleSelection) {
            this.multipleSelection = multipleSelection;
            return this;
        }

        public FileDialogBuilder setFilters(List<FileNameExtensionFilter> filters) {
            this.filters = filters;
            return this;
        }

        /**
         * Build new file dialog by properties that user want.
         *
         * @return Build file dialog and return it.
         */
        public FileDialog build() {
            return new FileDialog(this);
        }
    }
}
