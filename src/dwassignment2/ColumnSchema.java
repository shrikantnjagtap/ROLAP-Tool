package dwassignment2;

public class ColumnSchema {
	private String columnName;

	public ColumnSchema() {

	}

	public ColumnSchema(String columnName) {
		this.columnName=columnName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
}
