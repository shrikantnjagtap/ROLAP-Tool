package mdb;

import java.io.File;
import java.util.ArrayList;

public class Types {

	// Target storage directory name (relative to user's home directory) for the multidimensional database
	public static final String MDB_DIR = System.getProperty("user.home") + File.separator + "DW_MDB" + File.separator;
	
	// OLAP operations
	public static enum Operation {
		RollUp, DrillDown, Slice, Dice
	}

	// Logical connectives
	public static enum Operator {
		AND, OR
	}

	public static enum TableType {
		BaseFactTable, AggregatedFactTable, BaseDimensionTable, ShrunkenDimensionTable
	}

	public static enum HierarchyLevel {
		DateHierarchyLevel
	}

	public static enum DateHierarchyLevel {
		Date, Week, Month, Quarter, Semester, Year, All
	}
	
}
