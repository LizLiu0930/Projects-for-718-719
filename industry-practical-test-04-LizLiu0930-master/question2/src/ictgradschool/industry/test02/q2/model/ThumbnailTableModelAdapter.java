package ictgradschool.industry.test02.q2.model;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class ThumbnailTableModelAdapter extends AbstractTableModel implements ThumbnailListener{

    private static final String[] COLUMN_NAMES = {"Image", "Name"};

    public ThumbnailList _adaptee;

    public ThumbnailTableModelAdapter(ThumbnailList thumbnails) {

        // TODO Implement this
        _adaptee = thumbnails;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Thumbnail thumbnail = _adaptee.get(columnIndex);
        // TODO Implement this
        return thumbnail;
    }

    @Override
    public int getRowCount() {

        // TODO Implement this
        return _adaptee.size();
    }

    @Override
    public int getColumnCount() {

        // TODO Implement this
        return COLUMN_NAMES.length;
    }

    /**
     * Sets the table up to display images in its first column, and Strings in its second column.
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ImageIcon.class;
            case 1:
                return String.class;
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * Sets the table up with the correct column names.
     */
    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public void thumbnailAdded(ThumbnailList list) {

    }

    @Override
    public void thumbnailListCleared(ThumbnailList list) {

    }
}
