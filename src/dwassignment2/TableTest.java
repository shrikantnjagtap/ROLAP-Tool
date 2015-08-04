package dwassignment2;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class TableTest extends AbstractTableModel implements TableModelListener  {

	private ResultSet rs;
	private int numrows;
	private int numcols;
	private ResultSetMetaData metadata;
	
    public TableTest(ResultSet rs1) {
        this.rs=rs1;
        try {
        	
            this.metadata = this.rs.getMetaData();
            this.numcols = metadata.getColumnCount();
			this.rs.beforeFirst();
			this.numrows = 0;
	        while (this.rs.next()) {
	            this.numrows++;
	        }
	        this.rs.beforeFirst();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    
    @Override
    public int getRowCount() {
        return numrows;
    }

    @Override
    public int getColumnCount() {
        return numcols;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
    	try {
            this.rs.absolute(rowIndex + 1);
            Object o = this.rs.getObject(columnIndex + 1);
            if (o == null)
                return null;
            else
                return o.toString();
        } catch (SQLException e) {
            return e.toString();
        }
        
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    @Override
    public String getColumnName(int colName) {
    	try {
            return this.metadata.getColumnLabel(colName + 1);
        } catch (SQLException e) {
            return e.toString();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return String.class;
    }
    
    @Override   //if something changed
    public void setValueAt(Object value, int row, int col) {
       
        fireTableCellUpdated(row, col);
    }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        System.out.println(e.getSource());
    }

}
