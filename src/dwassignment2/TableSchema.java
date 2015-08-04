package dwassignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import mdb.Types.TableType;

public class TableSchema {
	private String tableName;
	private ArrayList<ColumnSchema> columns;
	private ArrayList<ColumnSchema> primaryKeys;
	private HashMap<ColumnSchema,HashMap<TableSchema, ColumnSchema>> foreignKeyToForeignTable;
	private HashMap<ColumnSchema,HashMap<TableSchema, ColumnSchema>> navigationKeyToTargetTable;
	private TableType tableType;
	private String hierarchyLevel;
	
	public TableSchema(){
		columns=new ArrayList<ColumnSchema>();
		primaryKeys=new ArrayList<ColumnSchema>();
		foreignKeyToForeignTable=new HashMap<ColumnSchema,HashMap<TableSchema, ColumnSchema>>();
		navigationKeyToTargetTable=new HashMap<ColumnSchema,HashMap<TableSchema, ColumnSchema>>();
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public ArrayList<ColumnSchema> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<ColumnSchema> columns) {
		this.columns = columns;
	}

	public ArrayList<ColumnSchema> getPrimaryKeys() {
		return primaryKeys;
	}

	public void setPrimaryKeys(ArrayList<ColumnSchema> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}

	public HashMap<ColumnSchema, HashMap<TableSchema, ColumnSchema>> getForeignKeyToForeignTable() {
		return foreignKeyToForeignTable;
	}

	public void setForeignKeyToForeignTable(
			HashMap<ColumnSchema, HashMap<TableSchema, ColumnSchema>> foreignKeyToForeignTable) {
		this.foreignKeyToForeignTable = foreignKeyToForeignTable;
	}

	public HashMap<ColumnSchema, HashMap<TableSchema, ColumnSchema>> getNavigationKeyToTargetTable() {
		return navigationKeyToTargetTable;
	}

	public void setNavigationKeyToTargetTable(
			HashMap<ColumnSchema, HashMap<TableSchema, ColumnSchema>> navigationKeyToTargetTable) {
		this.navigationKeyToTargetTable = navigationKeyToTargetTable;
	}

	public TableType getTableType() {
		return tableType;
	}

	public void setTableType(TableType tableType) {
		this.tableType = tableType;
	}

	public String getHierarchyLevel() {
		return hierarchyLevel;
	}

	public void setHierarchyLevel(String hierarchyLevel) {
		this.hierarchyLevel = hierarchyLevel;
	}

	// This method applies to only aggregated fact tables
	// It returns a number of ways in which this aggregated fact table is created
	public int getNumberOfWays() {

		HashSet<TableSchema> foreignTableSet = new HashSet<TableSchema>();
		
		for(HashMap<TableSchema, ColumnSchema> foreignTableToColumn : foreignKeyToForeignTable.values()) {
			foreignTableSet.addAll(foreignTableToColumn.keySet());
		}

		return foreignTableSet.size();
	}

	public HashSet<TableSchema> getReferencedTables() {

		HashSet<TableSchema> foreignTableSet = new HashSet<TableSchema>();
		
		for(HashMap<TableSchema, ColumnSchema> foreignTableToColumn : foreignKeyToForeignTable.values()) {
			foreignTableSet.addAll(foreignTableToColumn.keySet());
		}

		return foreignTableSet;
	}

}
