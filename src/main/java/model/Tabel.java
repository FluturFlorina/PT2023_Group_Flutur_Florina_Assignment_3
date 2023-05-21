package model;

import javax.swing.table.AbstractTableModel;

public class Tabel extends AbstractTableModel
{
    private String[] nume;
    private Object[][] date;
    /**
     * Returns the number of columns in the table.
     *
     * @return the number of columns
     */
    public int getColumnCount()
    {
        return nume.length;
    }
    public int getRowCount()
    {
        return date.length;
    }
    /**
     * Returns the name of the column at the specified index.
     *
     * @param col the index of the column
     * @return the name of the column
     */
    public String getColumnName(int col)
    {
        return nume[col];
    }
    /**
     * Returns the value at the specified cell.
     *
     * @param row the row index
     * @param col the column index
     * @return the value at the cell
     */
    public Object getValueAt(int row,int col)
    {
        return date[row][col];
    }

    public void setData(Object [][] dat)
    {
        this.date=dat;
    }
    public void setColumnNames(String [] names)
    {
        this.nume=names;
    }
}

