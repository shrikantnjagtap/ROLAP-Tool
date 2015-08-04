
package dwassignment2;

import gudusoft.gsqlparser.EDbVendor;
import gudusoft.gsqlparser.TBaseType;
import gudusoft.gsqlparser.TCustomSqlStatement;
import gudusoft.gsqlparser.TGSqlParser;
import gudusoft.gsqlparser.nodes.TGroupBy;
import gudusoft.gsqlparser.nodes.TGroupByItemList;
import gudusoft.gsqlparser.nodes.TJoin;
import gudusoft.gsqlparser.nodes.TJoinItem;
import gudusoft.gsqlparser.nodes.TResultColumn;
import gudusoft.gsqlparser.nodes.TTable;
import gudusoft.gsqlparser.stmt.TSelectSqlStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import mdb.Types.TableType;

public class AggregateCmdBuilder {

	private String sqlQuery;
	
	
	private String finalQuery;	
	private String resultQuery;
	private HashMap<String, String> aliasMap;
	private boolean aggregation_used=false;
	private String status=new String();
	private List<String> columnNames;

	public List<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}

	public String getSqlQuery() {
		return sqlQuery;
	}

	public void setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
	}
	
	public AggregateCmdBuilder(String cmd)
	{
		setSqlQuery(cmd);
		
		aliasMap=new  HashMap<>();
	}
	public String getAggregatedQuery()
	{
		TGSqlParser sqlparser = new TGSqlParser(EDbVendor.dbvmysql);
		
		sqlparser.sqltext = getSqlQuery();
		
		int ret = sqlparser.parse();
		
		if (ret == 0){
			for(int i=0;i<sqlparser.sqlstatements.size();i++){
				
				//analyzeStmt(sqlparser.sqlstatements.get(i));
				analyzeStmt(sqlparser.sqlstatements.get(i));
				System.out.println("");
		}
		}
		else{
			System.out.println(sqlparser.getErrormessage());
		}
		
		/*	---------------------------------------------------------------------------------- */
		if(aggregation_used==false)
		{
                    finalQuery=sqlQuery;
                    
		}
		else
		{
                    finalQuery=resultQuery;
		}
		
		return finalQuery;
	}
	
	protected  void analyzeStmt(TCustomSqlStatement stmt){
		switch(stmt.sqlstatementtype){
		case sstselect:
			analyzeSelectStmt((TSelectSqlStatement)stmt);
			break;
		case sstupdate:
			break;
		case sstcreatetable:
			break;
		case sstaltertable:
			break;
		case sstcreateview:
			break;
		default:
			System.out.println(stmt.sqlstatementtype.toString());
		}
		
		
		/*   important	*/
		for (int i = 0; i < stmt.getStatements().size(); i++) {
			analyzeStmt(stmt.getStatements().get(i));
		}
		
	}
	
	protected  void analyzeSelectStmt(TSelectSqlStatement pStmt){
		
		//System.out.println("\nSelect statement:");
		resultQuery=new String();
		
		HashMap<String, List<String>> inputTableMap=new HashMap<String, List<String>>();  //it is set up to be sent for aggregate metadata query
		
		
        TTable t ;
        for(int i=0;i<pStmt.tables.size();i++){
        	t = pStmt.tables.getTable(i);
        	System.out.println(t.toString()+" "+t.getAliasClause());
        	
        	 //	storing the alias onto a map
        	if(t.getAliasClause()==null)
        	{
        		aliasMap.put(t.toString(),t.toString() );
        		
        	}
        	else
        	{
        		aliasMap.put(t.toString(),t.getAliasClause().toString());
        		//now search the group by clause to find the column associated with this table
        		// group by
        		if (pStmt.getGroupByClause() != null) {
        			//System.out.printf("\ngroup by: \n\t%s\n", pStmt.getGroupByClause().toString());
        			//WhereCondition w=new WhereCondition(pStmt.getGroupByClause().getGROUP());
        			//System.out.println("----------------"+pStmt.getGroupByClause().getItems());
        			TGroupBy tg=pStmt.getGroupByClause();
        			TGroupByItemList l=tg.getItems();
        			
        			List<String> gbColNames=new ArrayList<String>();
        			
        			for(int j=0; j<l.size();j++)
        			{
        				//System.out.println(l.elementAt(j).getStartToken());
        				//System.out.println(l.elementAt(j).getEndToken());
        				if(l.elementAt(j).getStartToken().toString().equals(t.getAliasClause().toString()))
        				{
        					gbColNames.add(l.elementAt(j).getEndToken().toString());
        				}
        				
        			}
        			inputTableMap.put(t.toString(), gbColNames);
        		}
	
        	}
        }


       
        //-----------------------------------------------------------------------------------------
        //  	call outputTableMap which gives the hashmap<tbl name, metadata>
        String joinQuery=new String();
        HashMap<String, TableSchema> finalTableMap=outputTableMap(inputTableMap);
        if(finalTableMap.size()==0 || finalTableMap==null) //use base query
        {
        	
        }
        else //USE THE AGGREAGATED FACT TABLE
        {
        	String aggrFactTable=null;
        	String baseFactTable=null;
        	//GET THE AGGREGATED FACT TABLE
        	for (Map.Entry<String, TableSchema> entryInput : finalTableMap.entrySet()){

        		//System.out.println(entryInput.getKey()+" - " + entryInput.getValue().getTableName());
        		if(entryInput.getValue().getTableType()==TableType.AggregatedFactTable)
        		{
        			aggrFactTable=entryInput.getValue().getTableName();
        			baseFactTable=entryInput.getKey();
        			break;
        		}
        	}
        	
        	//JOIN QUERY REWRITE
        	joinQuery=joinQuery.concat(" FROM "+aggrFactTable+ " "+aliasMap.get(baseFactTable));
        	
        	for (Map.Entry<String, TableSchema> entryInput : finalTableMap.entrySet()){
        		if(entryInput.getValue().getTableType()==TableType.AggregatedFactTable){
        			
        		}
        		else
        		{
        			joinQuery=joinQuery.concat(" INNER JOIN "+entryInput.getValue().getTableName()+" "+aliasMap.get(entryInput.getKey())+" ON ");
        			joinQuery=joinQuery.concat(aliasMap.get(entryInput.getKey())+"."+entryInput.getValue().getPrimaryKeys().get(0).getColumnName()+"=");
        			if(entryInput.getValue().getPrimaryKeys().get(0).getColumnName().equalsIgnoreCase("Datekey"))
        			{
        				joinQuery=joinQuery.concat(aliasMap.get(baseFactTable)+"."+"orderdatekey");
        			}
        			else
        			{
        				joinQuery=joinQuery.concat(aliasMap.get(baseFactTable)+"."+entryInput.getValue().getPrimaryKeys().get(0).getColumnName());
        			}
        		}
        	}
                //System.out.println(joinQuery);
        //------------------------------------------------------------------------------------------
        resultQuery=resultQuery.concat("SELECT");
        for (int i = 0; i < pStmt.getResultColumnList().size(); i++) {
			TResultColumn resultColumn = pStmt.getResultColumnList().getResultColumn(i);
			//System.out.printf("\tColumn: %s, Alias: %s\n", resultColumn.getExpr().toString(),
				//		(resultColumn.getAliasClause() == null) ? "" : resultColumn
					//			.getAliasClause().toString());
			
			resultQuery=resultQuery.concat(" "+resultColumn.getExpr().toString()+" "+
					((resultColumn.getAliasClause() == null) ? "" : resultColumn.getAliasClause().toString()));
			if(pStmt.getResultColumnList().size()-1!=i){
				resultQuery=resultQuery.concat(",");
			}
		}
        
        resultQuery=resultQuery.concat(joinQuery);
        
        // where clause
        if (pStmt.getWhereClause() != null) {
     			//System.out.printf("\nwhere clause: \n\t%s\n", pStmt.getWhereClause().getCondition().toString());
        	resultQuery=resultQuery.concat(" "+pStmt.getWhereClause().toString());
     	}
		// group by
		if (pStmt.getGroupByClause() != null) {
			//System.out.printf("\ngroup by: \n\t%s\n", pStmt.getGroupByClause().toString());
			resultQuery=resultQuery.concat(" "+ pStmt.getGroupByClause().toString());
		}
		
		
		aggregation_used=true;
        }

    }

	private HashMap<String, TableSchema> outputTableMap(HashMap<String, List<String>> inputTableMap) 
	{
		// TODO Auto-generated method stub
		// Hashmap to return details of replacement tables
		HashMap<String, TableSchema> resultTablesMap = null;
		MetaData.init();
		
		TableSchema aggregateTable=new TableSchema();
		// list of aggregated fact tables
		for (String tempTableName : MetaData.orderedAggregates) {
			resultTablesMap = new HashMap<String, TableSchema>();
			aggregateTable = MetaData.tableNameToTableSchama.get(tempTableName);
			// get referenced dimension tables
			HashSet<TableSchema> foreignTableSet = aggregateTable.getReferencedTables();

			// check with inputHashMap for replacement
			for (TableSchema entryReferenced : foreignTableSet) {
				// list of input tables
				for (Map.Entry<String, List<String>> entryInput : inputTableMap.entrySet()) {
					//check if it is base fact table
					if(MetaData.tableNameToTableSchama.get(entryInput.getKey().toLowerCase()).getTableType()==TableType.BaseFactTable) {
						resultTablesMap.put(entryInput.getKey(),
								aggregateTable);
					}
					//check for referenced dimension table
					else{
						if (entryInput.getValue().size() == 0) {
							// check for base dimensional table is present or
							// not
							if (entryInput.getKey().equalsIgnoreCase(
									entryReferenced.getTableName())) {
								resultTablesMap.put(entryInput.getKey(),
										entryReferenced);
							}
						} else {
							int columnCount=0;
							for (String inputColName : entryInput.getValue()) {
								for (ColumnSchema column : entryReferenced
										.getColumns()) {
									// check for columnname is present in list
									// of
									// referened table
									if (inputColName.equalsIgnoreCase(column
											.getColumnName())) {
										// TableSchema tempTableForReplacement =
										// validateDetails();
										
										columnCount++;
									}

									else {
										// look for next aggregate fact table
									}

								}
							}
							if(columnCount==entryInput.getValue().size()){
								// add to outputTableMap
								resultTablesMap.put(
										entryInput.getKey(),
										entryReferenced);
							}
						}
					}
				}
			}
			if(resultTablesMap.size()==inputTableMap.size()){
				
				//resultTablesMap.put(aggregateTable.getTableName(), aggregateTable);
				return resultTablesMap;

			}

		}

		return null;

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
