package dwassignment2;

import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class ResultTable extends AbstractTableModel implements TableModelListener  {

	    private  List<List> data;
	    private List<String> col;
	   
	    public ResultTable( List<List> data,List<String> col) {
	        this.data=data;
	        this.col=col;
	    }

	    
	    @Override
	    public int getRowCount() {
	        return data.size();
	    }

	    @Override
	    public int getColumnCount() {
	        return col.size();
	    }

	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        
	    		if(data.get(rowIndex).get(columnIndex)==null)
	    			return "";
	    		else
	    			return data.get(rowIndex).get(columnIndex);
	        
	    }
	    @Override
	    public boolean isCellEditable(int rowIndex, int columnIndex)
	    {
	        return false;
	    }
	    @Override
	    public String getColumnName(int colName) {
	        return col.get(colName);
	    	
	    }

	    @Override
	    public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }
	    
	    @Override   //if something changed
	    public void setValueAt(Object value, int row, int col) {
	       
	        data.get(row).set(col,value);
	        fireTableCellUpdated(row, col);
	    }
	    
	    @Override
	    public void tableChanged(TableModelEvent e) {
	        System.out.println(e.getSource());
	    }
	    

}
