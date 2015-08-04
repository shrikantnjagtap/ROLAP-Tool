package dwassignment2;

import java.util.ArrayList;
import java.util.HashMap;

import mdb.Types.TableType;

class X {
	String tableName;
	String tableType;
	String hierarchyLevel;
	String[] columns;
	
	public X(String tableName, String tableType, String hierarchyLevel, String[] columns) {
		this.tableName=tableName;
		this.tableType=tableType;
		this.hierarchyLevel = hierarchyLevel;
		this.columns = columns;
		genearteCode();
	}

	public void genearteCode(){
		
		System.out.println("/* START Table: " + tableName + " */");

		System.out.println("TableSchema " + tableName + " = new TableSchema();");
		System.out.print(tableName + ".setTableName(" ); System.out.print("\"" + tableName +"\""); System.out.print(");\n");
		System.out.println(tableName + ".setTableType(TableType." + tableType + ");");
		System.out.println(tableName + ".setHierarchyLevel(HierarchyLevel." + hierarchyLevel + ");");
		System.out.println();
		for(String col : columns) {
			
			char[] c = col.toCharArray();
			c[0] = (char)((int)c[0]+32);			
			String lowerCol = new String(c);
			
			char[] t = tableName.toCharArray();
			t[0] = (char)((int)t[0]-32);			
			lowerCol += new String(t);
			
			System.out.println("ColumnSchema " + lowerCol + " = new ColumnSchema(\"" + col + "\");");
			System.out.println(tableName + ".getColumns().add(" + lowerCol + ");");
		}
		
		System.out.println("/* END Table: " + tableName + " */\n");

	}
}

public class MetaData {

	/**
	 * @param args
	 */
	public static ArrayList<String> orderedAggregates;
	public static HashMap<String, TableSchema> tableNameToTableSchama;
	
	static {
		orderedAggregates=new ArrayList<String>();
		tableNameToTableSchama=new HashMap<String, TableSchema>();
	}
	
	
	/*public static void main(String[] args) {*/
	public void initmain(String[] args) {
		// TODO Auto-generated method stub
//		init();
		
		X x = new X("agg1_salesamount_city", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"CityKey", "OrderDateKey", "ProductKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg1_salesamount_country", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"CountryKey", "OrderDateKey", "ProductKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg1_salesamount_day", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"OrderDateKey", "ProductKey", "CustomerKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg1_salesamount_month", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"MonthKey", "ProductKey", "CustomerKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg1_salesamount_postalcode", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"PostalCodeKey", "OrderDateKey", "ProductKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg1_salesamount_product", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"Product", "OrderDateKey", "CustomerKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg1_salesamount_productcategory", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"ProductCategoryKey", "OrderDateKey", "CustomerKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg1_salesamount_productsubcategory", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"ProductSubcategoryKey", "OrderDateKey", "CustomerKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg1_salesamount_quarter", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"QuarterKey", "ProductKey", "CustomerKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg1_salesamount_salesterritory", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"OrderDateKey", "ProductKey", "CustomerKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg1_salesamount_salesterritory_country", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"OrderDateKey", "ProductKey", "CustomerKey", "SalesTerritorycountryKey", "SalesAmount"});
		x = new X("agg1_salesamount_salesterritory_group", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"OrderDateKey", "ProductKey", "CustomerKey", "SalesTerritorygroupKey", "SalesAmount"});
		x = new X("agg1_salesamount_semester", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"SemesterKey", "ProductKey", "CustomerKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg1_salesamount_state", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"StateKey", "OrderDateKey", "ProductKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg1_salesamount_week", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"WeekKey", "ProductKey", "CustomerKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg1_salesamount_year", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"YearKey", "ProductKey", "CustomerKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg2_salesamount_day_city", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"OrderDateKey", "CityKey", "ProductKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg2_salesamount_month_city", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"MonthKey", "CityKey", "ProductKey", "SalesTerritoryKey", "SalesAmount"});
		x = new  X("agg2_salesamount_month_country", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"MonthKey", "CountryKey", "ProductKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg2_salesamount_month_state", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"StateKey", "MonthKey", "ProductKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg2_salesamount_quarter_country", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"QuarterKey", "CountryKey", "ProductKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg2_salesamount_year_city", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"YearKey", "CityKey", "ProductKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("agg2_salesamount_year_country", TableType.AggregatedFactTable.toString(), HierarchyLevel.All, new String[] {"YearKey", "CountryKey", "ProductKey", "SalesTerritoryKey", "SalesAmount"});
		x = new X("dim_currency", TableType.BaseDimensionTable.toString(), HierarchyLevel.All, new String[] {"CurrencyKey", "CurrencyAlternateKey", "CurrencyName"});
		x = new X("dim_customer", TableType.BaseDimensionTable.toString(), HierarchyLevel.Customer, new String[] {"CustomerKey", "CustomerAlternateKey", "Title", "FirstName", "MiddleName", "LastName", "NameStyle", "BirthDate", "MaritalStatus", "Suffix", "Gender", "EmailAddress", "YearlyIncome", "TotalChildren", "NumberChildrenAtHome", "EnglishEducation", "SpanishEducation", "FrenchEducation", "EnglishOccupation", "SpanishOccupation", "FrenchOccupation", "HouseOwnerFlag", "NumberCarsOwned", "AddressLine1", "AddressLine2", "City", "StateProvinceCode", "StateProvinceName", "CountryRegionCode", "EnglishCountryRegionName", "SpanishCountryRegionName", "FrenchCountryRegionName", "PostalCode", "SalesTerritoryKey", "IpAddressLocator", "Phone", "DateFirstPurchase", "CommuteDistance"});
		x = new X("dim_date", TableType.BaseDimensionTable.toString(), HierarchyLevel.Date, new String[] {"DateKey", "FullDateAlternateKey", "DayNumberOfWeek", "EnglishDayNameOfWeek", "SpanishDayNameOfWeek", "FrenchDayNameOfWeek", "DayNumberOfMonth", "DayNumberOfYear", "WeekNumberOfYear", "EnglishMonthName", "SpanishMonthName", "FrenchMonthName", "MonthNumberOfYear", "CalendarQuarter", "CalendarYear", "CalendarSemester", "FiscalQuarter", "FiscalYear", "FiscalSemester"});
		x = new X("dim_product", TableType.BaseDimensionTable.toString(), HierarchyLevel.Product, new String[] {"ProductKey", "ProductAlternateKey", "ProductSubcategoryKey", "WeightUnitMeasureCode", "SizeUnitMeasureCode", "EnglishProductName", "SpanishProductName", "FrenchProductName", "StandardCost", "FinishedGoodsFlag", "Color", "SafetyStockLevel", "ReorderPoint", "ListPrice", "Size", "SizeRange", "Weight", "DaysToManufacture", "ProductLine", "DealerPrice", "Class", "Style", "ModelName", "LargePhoto", "EnglishDescription", "FrenchDescription", "ChineseDescription", "ArabicDescription", "HebrewDescription", "ThaiDescription", "GermanDescription", "JapaneseDescription", "TurkishDescription", "StartDate", "EndDate", "Status"});
		x = new X("dim_productcategory", TableType.ShrunkenDimensionTable.toString(), HierarchyLevel.Category, new String[] {"ProductCategoryKey", "ProductCategoryAlternateKey", "EnglishProductCategoryName", "SpanishProductCategoryName", "FrenchProductCategoryName"});
		x = new X("dim_productsubcategory", TableType.ShrunkenDimensionTable.toString(), HierarchyLevel.SubCategory, new String[] {"ProductSubcategoryKey", "ProductSubcategoryAlternateKey", "EnglishProductSubcategoryName", "SpanishProductSubcategoryName", "FrenchProductSubcategoryName", "ProductCategoryKey"});
		x = new X("dim_promotion", TableType.BaseDimensionTable.toString(), HierarchyLevel.All, new String[] {"PromotionKey", "PromotionAlternateKey", "EnglishPromotionName", "SpanishPromotionName", "FrenchPromotionName", "DiscountPct", "EnglishPromotionType", "SpanishPromotionType", "FrenchPromotionType", "EnglishPromotionCategory", "SpanishPromotionCategory", "FrenchPromotionCategory", "StartDate", "EndDate", "MinQty", "MaxQty"});
		x = new X("dim_salesterritory", TableType.BaseDimensionTable.toString(), HierarchyLevel.Region, new String[] {"SalesTerritoryKey", "SalesTerritoryAlternateKey", "SalesTerritoryRegion", "SalesTerritoryCountry", "SalesTerritoryGroup", "SalesTerritoryImage"});
		x = new X("fact_internetsales", TableType.BaseFactTable.toString(), HierarchyLevel.All, new String[] {"ProductKey", "OrderDateKey", "DueDateKey", "ShipDateKey", "CustomerKey", "PromotionKey", "CurrencyKey", "SalesTerritoryKey", "SalesOrderNumber", "SalesOrderLineNumber", "RevisionNumber", "OrderQuantity", "UnitPrice", "ExtendedAmount", "UnitPriceDiscountPct", "DiscountAmount", "ProductStandardCost", "TotalProductCost", "SalesAmount", "TaxAmt", "Freight", "CarrierTrackingNumber", "CustomerPONumber", "OrderDate", "DueDate", "ShipDate"});
		x = new X("shr_dimcustomer_city", TableType.ShrunkenDimensionTable.toString(), HierarchyLevel.City, new String[] {"CityKey", "City", "StateProvinceCode", "StateProvinceName", "CountryRegionCode", "EnglishCountryRegionName", "SpanishCountryRegionName", "FrenchCountryRegionName", "SalesTerritoryKey", "IpAddressLocator"});
		x = new X("shr_dimcustomer_country", TableType.ShrunkenDimensionTable.toString(), HierarchyLevel.Country, new String[] {"CountryKey", "CountryRegionCode", "EnglishCountryRegionName", "SpanishCountryRegionName", "FrenchCountryRegionName", "SalesTerritoryKey", "IpAddressLocator"});
		x = new X("shr_dimcustomer_postalcode", TableType.ShrunkenDimensionTable.toString(), HierarchyLevel.PostalCode, new String[] {"PostalCodeKey", "PostalCode", "City", "StateProvinceCode", "StateProvinceName", "CountryRegionCode", "EnglishCountryRegionName", "SpanishCountryRegionName", "FrenchCountryRegionName", "SalesTerritoryKey", "IpAddressLocator"});
		x = new X("shr_dimcustomer_state", TableType.ShrunkenDimensionTable.toString(), HierarchyLevel.State, new String[] {"StateKey", "StateProvinceCode", "StateProvinceName", "CountryRegionCode", "EnglishCountryRegionName", "SpanishCountryRegionName", "FrenchCountryRegionName", "SalesTerritoryKey", "IpAddressLocator"});
		x = new X("shr_dimdate_month", TableType.ShrunkenDimensionTable.toString(), HierarchyLevel.Month, new String[] {"MonthKey", "EnglishMonthName", "SpanishMonthName", "FrenchMonthName", "MonthNumberOfYear", "CalendarQuarter", "CalendarYear", "CalendarSemester", "FiscalQuarter", "FiscalYear", "FiscalSemester"});
		x = new X("shr_dimdate_quarter", TableType.ShrunkenDimensionTable.toString(), HierarchyLevel.Quarter, new String[] {"QuarterKey", "CalendarQuarter", "CalendarYear", "CalendarSemester", "FiscalQuarter", "FiscalYear", "FiscalSemester"});
		x = new X("shr_dimdate_semester", TableType.ShrunkenDimensionTable.toString(), HierarchyLevel.Semester, new String[] {"SemesterKey", "CalendarYear", "CalendarSemester", "FiscalYear", "FiscalSemester"});
		x = new X("shr_dimdate_week", TableType.ShrunkenDimensionTable.toString(), HierarchyLevel.Week, new String[] {"WeekKey", "WeekNumberOfYear", "EnglishMonthName", "SpanishMonthName", "FrenchMonthName", "MonthNumberOfYear", "CalendarQuarter", "CalendarYear", "CalendarSemester", "FiscalQuarter", "FiscalYear", "FiscalSemester"});
		x = new X("shr_dimdate_year", TableType.ShrunkenDimensionTable.toString(), HierarchyLevel.Year, new String[] {"YearKey", "CalendarYear", "FiscalYear"});
		x = new X("shr_dimsalesterritory_country", TableType.ShrunkenDimensionTable.toString(), HierarchyLevel.Country, new String[] {"SalesTerritoryCountryKey", "SalesTerritoryCountry", "SalesTerritoryGroup", "SalesTerritoryImage"});
		x = new X("shr_dimsalesterritory_group", TableType.ShrunkenDimensionTable.toString(), HierarchyLevel.Group, new String[] {"SalesTerritoryGroupKey", "SalesTerritoryGroup", "SalesTerritoryImage"});
		
	}

	public static void init() {

		/* START Table: agg1_salesamount_city */
		TableSchema agg1_salesamount_city = new TableSchema();
		agg1_salesamount_city.setTableName("agg1_salesamount_city");
		agg1_salesamount_city.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_city.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema cityKeyAgg1_salesamount_city = new ColumnSchema("CityKey");
		agg1_salesamount_city.getColumns().add(cityKeyAgg1_salesamount_city);
		ColumnSchema orderDateKeyAgg1_salesamount_city = new ColumnSchema("OrderDateKey");
		agg1_salesamount_city.getColumns().add(orderDateKeyAgg1_salesamount_city);
		ColumnSchema productKeyAgg1_salesamount_city = new ColumnSchema("ProductKey");
		agg1_salesamount_city.getColumns().add(productKeyAgg1_salesamount_city);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_city = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_city.getColumns().add(salesTerritoryKeyAgg1_salesamount_city);
		ColumnSchema salesAmountAgg1_salesamount_city = new ColumnSchema("SalesAmount");
		agg1_salesamount_city.getColumns().add(salesAmountAgg1_salesamount_city);
		/* END Table: agg1_salesamount_city */

		/* START Table: agg1_salesamount_country */
		TableSchema agg1_salesamount_country = new TableSchema();
		agg1_salesamount_country.setTableName("agg1_salesamount_country");
		agg1_salesamount_country.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_country.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema countryKeyAgg1_salesamount_country = new ColumnSchema("CountryKey");
		agg1_salesamount_country.getColumns().add(countryKeyAgg1_salesamount_country);
		ColumnSchema orderDateKeyAgg1_salesamount_country = new ColumnSchema("OrderDateKey");
		agg1_salesamount_country.getColumns().add(orderDateKeyAgg1_salesamount_country);
		ColumnSchema productKeyAgg1_salesamount_country = new ColumnSchema("ProductKey");
		agg1_salesamount_country.getColumns().add(productKeyAgg1_salesamount_country);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_country = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_country.getColumns().add(salesTerritoryKeyAgg1_salesamount_country);
		ColumnSchema salesAmountAgg1_salesamount_country = new ColumnSchema("SalesAmount");
		agg1_salesamount_country.getColumns().add(salesAmountAgg1_salesamount_country);
		/* END Table: agg1_salesamount_country */

		/* START Table: agg1_salesamount_day */
		TableSchema agg1_salesamount_day = new TableSchema();
		agg1_salesamount_day.setTableName("agg1_salesamount_day");
		agg1_salesamount_day.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_day.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema orderDateKeyAgg1_salesamount_day = new ColumnSchema("OrderDateKey");
		agg1_salesamount_day.getColumns().add(orderDateKeyAgg1_salesamount_day);
		ColumnSchema productKeyAgg1_salesamount_day = new ColumnSchema("ProductKey");
		agg1_salesamount_day.getColumns().add(productKeyAgg1_salesamount_day);
		ColumnSchema customerKeyAgg1_salesamount_day = new ColumnSchema("CustomerKey");
		agg1_salesamount_day.getColumns().add(customerKeyAgg1_salesamount_day);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_day = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_day.getColumns().add(salesTerritoryKeyAgg1_salesamount_day);
		ColumnSchema salesAmountAgg1_salesamount_day = new ColumnSchema("SalesAmount");
		agg1_salesamount_day.getColumns().add(salesAmountAgg1_salesamount_day);
		/* END Table: agg1_salesamount_day */

		/* START Table: agg1_salesamount_month */
		TableSchema agg1_salesamount_month = new TableSchema();
		agg1_salesamount_month.setTableName("agg1_salesamount_month");
		agg1_salesamount_month.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_month.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema monthKeyAgg1_salesamount_month = new ColumnSchema("MonthKey");
		agg1_salesamount_month.getColumns().add(monthKeyAgg1_salesamount_month);
		ColumnSchema productKeyAgg1_salesamount_month = new ColumnSchema("ProductKey");
		agg1_salesamount_month.getColumns().add(productKeyAgg1_salesamount_month);
		ColumnSchema customerKeyAgg1_salesamount_month = new ColumnSchema("CustomerKey");
		agg1_salesamount_month.getColumns().add(customerKeyAgg1_salesamount_month);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_month = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_month.getColumns().add(salesTerritoryKeyAgg1_salesamount_month);
		ColumnSchema salesAmountAgg1_salesamount_month = new ColumnSchema("SalesAmount");
		agg1_salesamount_month.getColumns().add(salesAmountAgg1_salesamount_month);
		/* END Table: agg1_salesamount_month */

		/* START Table: agg1_salesamount_postalcode */
		TableSchema agg1_salesamount_postalcode = new TableSchema();
		agg1_salesamount_postalcode.setTableName("agg1_salesamount_postalcode");
		agg1_salesamount_postalcode.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_postalcode.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema postalCodeKeyAgg1_salesamount_postalcode = new ColumnSchema("PostalCodeKey");
		agg1_salesamount_postalcode.getColumns().add(postalCodeKeyAgg1_salesamount_postalcode);
		ColumnSchema orderDateKeyAgg1_salesamount_postalcode = new ColumnSchema("OrderDateKey");
		agg1_salesamount_postalcode.getColumns().add(orderDateKeyAgg1_salesamount_postalcode);
		ColumnSchema productKeyAgg1_salesamount_postalcode = new ColumnSchema("ProductKey");
		agg1_salesamount_postalcode.getColumns().add(productKeyAgg1_salesamount_postalcode);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_postalcode = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_postalcode.getColumns().add(salesTerritoryKeyAgg1_salesamount_postalcode);
		ColumnSchema salesAmountAgg1_salesamount_postalcode = new ColumnSchema("SalesAmount");
		agg1_salesamount_postalcode.getColumns().add(salesAmountAgg1_salesamount_postalcode);
		/* END Table: agg1_salesamount_postalcode */

		/* START Table: agg1_salesamount_product */
		TableSchema agg1_salesamount_product = new TableSchema();
		agg1_salesamount_product.setTableName("agg1_salesamount_product");
		agg1_salesamount_product.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_product.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema productAgg1_salesamount_product = new ColumnSchema("Product");
		agg1_salesamount_product.getColumns().add(productAgg1_salesamount_product);
		ColumnSchema orderDateKeyAgg1_salesamount_product = new ColumnSchema("OrderDateKey");
		agg1_salesamount_product.getColumns().add(orderDateKeyAgg1_salesamount_product);
		ColumnSchema customerKeyAgg1_salesamount_product = new ColumnSchema("CustomerKey");
		agg1_salesamount_product.getColumns().add(customerKeyAgg1_salesamount_product);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_product = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_product.getColumns().add(salesTerritoryKeyAgg1_salesamount_product);
		ColumnSchema salesAmountAgg1_salesamount_product = new ColumnSchema("SalesAmount");
		agg1_salesamount_product.getColumns().add(salesAmountAgg1_salesamount_product);
		/* END Table: agg1_salesamount_product */

		/* START Table: agg1_salesamount_productcategory */
		TableSchema agg1_salesamount_productcategory = new TableSchema();
		agg1_salesamount_productcategory.setTableName("agg1_salesamount_productcategory");
		agg1_salesamount_productcategory.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_productcategory.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema productCategoryKeyAgg1_salesamount_productcategory = new ColumnSchema("ProductCategoryKey");
		agg1_salesamount_productcategory.getColumns().add(productCategoryKeyAgg1_salesamount_productcategory);
		ColumnSchema orderDateKeyAgg1_salesamount_productcategory = new ColumnSchema("OrderDateKey");
		agg1_salesamount_productcategory.getColumns().add(orderDateKeyAgg1_salesamount_productcategory);
		ColumnSchema customerKeyAgg1_salesamount_productcategory = new ColumnSchema("CustomerKey");
		agg1_salesamount_productcategory.getColumns().add(customerKeyAgg1_salesamount_productcategory);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_productcategory = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_productcategory.getColumns().add(salesTerritoryKeyAgg1_salesamount_productcategory);
		ColumnSchema salesAmountAgg1_salesamount_productcategory = new ColumnSchema("SalesAmount");
		agg1_salesamount_productcategory.getColumns().add(salesAmountAgg1_salesamount_productcategory);
		/* END Table: agg1_salesamount_productcategory */

		/* START Table: agg1_salesamount_productsubcategory */
		TableSchema agg1_salesamount_productsubcategory = new TableSchema();
		agg1_salesamount_productsubcategory.setTableName("agg1_salesamount_productsubcategory");
		agg1_salesamount_productsubcategory.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_productsubcategory.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema productSubcategoryKeyAgg1_salesamount_productsubcategory = new ColumnSchema("ProductSubcategoryKey");
		agg1_salesamount_productsubcategory.getColumns().add(productSubcategoryKeyAgg1_salesamount_productsubcategory);
		ColumnSchema orderDateKeyAgg1_salesamount_productsubcategory = new ColumnSchema("OrderDateKey");
		agg1_salesamount_productsubcategory.getColumns().add(orderDateKeyAgg1_salesamount_productsubcategory);
		ColumnSchema customerKeyAgg1_salesamount_productsubcategory = new ColumnSchema("CustomerKey");
		agg1_salesamount_productsubcategory.getColumns().add(customerKeyAgg1_salesamount_productsubcategory);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_productsubcategory = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_productsubcategory.getColumns().add(salesTerritoryKeyAgg1_salesamount_productsubcategory);
		ColumnSchema salesAmountAgg1_salesamount_productsubcategory = new ColumnSchema("SalesAmount");
		agg1_salesamount_productsubcategory.getColumns().add(salesAmountAgg1_salesamount_productsubcategory);
		/* END Table: agg1_salesamount_productsubcategory */

		/* START Table: agg1_salesamount_quarter */
		TableSchema agg1_salesamount_quarter = new TableSchema();
		agg1_salesamount_quarter.setTableName("agg1_salesamount_quarter");
		agg1_salesamount_quarter.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_quarter.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema quarterKeyAgg1_salesamount_quarter = new ColumnSchema("QuarterKey");
		agg1_salesamount_quarter.getColumns().add(quarterKeyAgg1_salesamount_quarter);
		ColumnSchema productKeyAgg1_salesamount_quarter = new ColumnSchema("ProductKey");
		agg1_salesamount_quarter.getColumns().add(productKeyAgg1_salesamount_quarter);
		ColumnSchema customerKeyAgg1_salesamount_quarter = new ColumnSchema("CustomerKey");
		agg1_salesamount_quarter.getColumns().add(customerKeyAgg1_salesamount_quarter);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_quarter = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_quarter.getColumns().add(salesTerritoryKeyAgg1_salesamount_quarter);
		ColumnSchema salesAmountAgg1_salesamount_quarter = new ColumnSchema("SalesAmount");
		agg1_salesamount_quarter.getColumns().add(salesAmountAgg1_salesamount_quarter);
		/* END Table: agg1_salesamount_quarter */

		/* START Table: agg1_salesamount_salesterritory */
		TableSchema agg1_salesamount_salesterritory = new TableSchema();
		agg1_salesamount_salesterritory.setTableName("agg1_salesamount_salesterritory");
		agg1_salesamount_salesterritory.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_salesterritory.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema orderDateKeyAgg1_salesamount_salesterritory = new ColumnSchema("OrderDateKey");
		agg1_salesamount_salesterritory.getColumns().add(orderDateKeyAgg1_salesamount_salesterritory);
		ColumnSchema productKeyAgg1_salesamount_salesterritory = new ColumnSchema("ProductKey");
		agg1_salesamount_salesterritory.getColumns().add(productKeyAgg1_salesamount_salesterritory);
		ColumnSchema customerKeyAgg1_salesamount_salesterritory = new ColumnSchema("CustomerKey");
		agg1_salesamount_salesterritory.getColumns().add(customerKeyAgg1_salesamount_salesterritory);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_salesterritory = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_salesterritory.getColumns().add(salesTerritoryKeyAgg1_salesamount_salesterritory);
		ColumnSchema salesAmountAgg1_salesamount_salesterritory = new ColumnSchema("SalesAmount");
		agg1_salesamount_salesterritory.getColumns().add(salesAmountAgg1_salesamount_salesterritory);
		/* END Table: agg1_salesamount_salesterritory */

		/* START Table: agg1_salesamount_salesterritory_country */
		TableSchema agg1_salesamount_salesterritory_country = new TableSchema();
		agg1_salesamount_salesterritory_country.setTableName("agg1_salesamount_salesterritory_country");
		agg1_salesamount_salesterritory_country.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_salesterritory_country.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema orderDateKeyAgg1_salesamount_salesterritory_country = new ColumnSchema("OrderDateKey");
		agg1_salesamount_salesterritory_country.getColumns().add(orderDateKeyAgg1_salesamount_salesterritory_country);
		ColumnSchema productKeyAgg1_salesamount_salesterritory_country = new ColumnSchema("ProductKey");
		agg1_salesamount_salesterritory_country.getColumns().add(productKeyAgg1_salesamount_salesterritory_country);
		ColumnSchema customerKeyAgg1_salesamount_salesterritory_country = new ColumnSchema("CustomerKey");
		agg1_salesamount_salesterritory_country.getColumns().add(customerKeyAgg1_salesamount_salesterritory_country);
		ColumnSchema salesTerritorycountryKeyAgg1_salesamount_salesterritory_country = new ColumnSchema("SalesTerritorycountryKey");
		agg1_salesamount_salesterritory_country.getColumns().add(salesTerritorycountryKeyAgg1_salesamount_salesterritory_country);
		ColumnSchema salesAmountAgg1_salesamount_salesterritory_country = new ColumnSchema("SalesAmount");
		agg1_salesamount_salesterritory_country.getColumns().add(salesAmountAgg1_salesamount_salesterritory_country);
		/* END Table: agg1_salesamount_salesterritory_country */

		/* START Table: agg1_salesamount_salesterritory_group */
		TableSchema agg1_salesamount_salesterritory_group = new TableSchema();
		agg1_salesamount_salesterritory_group.setTableName("agg1_salesamount_salesterritory_group");
		agg1_salesamount_salesterritory_group.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_salesterritory_group.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema orderDateKeyAgg1_salesamount_salesterritory_group = new ColumnSchema("OrderDateKey");
		agg1_salesamount_salesterritory_group.getColumns().add(orderDateKeyAgg1_salesamount_salesterritory_group);
		ColumnSchema productKeyAgg1_salesamount_salesterritory_group = new ColumnSchema("ProductKey");
		agg1_salesamount_salesterritory_group.getColumns().add(productKeyAgg1_salesamount_salesterritory_group);
		ColumnSchema customerKeyAgg1_salesamount_salesterritory_group = new ColumnSchema("CustomerKey");
		agg1_salesamount_salesterritory_group.getColumns().add(customerKeyAgg1_salesamount_salesterritory_group);
		ColumnSchema salesTerritorygroupKeyAgg1_salesamount_salesterritory_group = new ColumnSchema("SalesTerritorygroupKey");
		agg1_salesamount_salesterritory_group.getColumns().add(salesTerritorygroupKeyAgg1_salesamount_salesterritory_group);
		ColumnSchema salesAmountAgg1_salesamount_salesterritory_group = new ColumnSchema("SalesAmount");
		agg1_salesamount_salesterritory_group.getColumns().add(salesAmountAgg1_salesamount_salesterritory_group);
		/* END Table: agg1_salesamount_salesterritory_group */

		/* START Table: agg1_salesamount_semester */
		TableSchema agg1_salesamount_semester = new TableSchema();
		agg1_salesamount_semester.setTableName("agg1_salesamount_semester");
		agg1_salesamount_semester.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_semester.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema semesterKeyAgg1_salesamount_semester = new ColumnSchema("SemesterKey");
		agg1_salesamount_semester.getColumns().add(semesterKeyAgg1_salesamount_semester);
		ColumnSchema productKeyAgg1_salesamount_semester = new ColumnSchema("ProductKey");
		agg1_salesamount_semester.getColumns().add(productKeyAgg1_salesamount_semester);
		ColumnSchema customerKeyAgg1_salesamount_semester = new ColumnSchema("CustomerKey");
		agg1_salesamount_semester.getColumns().add(customerKeyAgg1_salesamount_semester);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_semester = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_semester.getColumns().add(salesTerritoryKeyAgg1_salesamount_semester);
		ColumnSchema salesAmountAgg1_salesamount_semester = new ColumnSchema("SalesAmount");
		agg1_salesamount_semester.getColumns().add(salesAmountAgg1_salesamount_semester);
		/* END Table: agg1_salesamount_semester */

		/* START Table: agg1_salesamount_state */
		TableSchema agg1_salesamount_state = new TableSchema();
		agg1_salesamount_state.setTableName("agg1_salesamount_state");
		agg1_salesamount_state.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_state.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema stateKeyAgg1_salesamount_state = new ColumnSchema("StateKey");
		agg1_salesamount_state.getColumns().add(stateKeyAgg1_salesamount_state);
		ColumnSchema orderDateKeyAgg1_salesamount_state = new ColumnSchema("OrderDateKey");
		agg1_salesamount_state.getColumns().add(orderDateKeyAgg1_salesamount_state);
		ColumnSchema productKeyAgg1_salesamount_state = new ColumnSchema("ProductKey");
		agg1_salesamount_state.getColumns().add(productKeyAgg1_salesamount_state);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_state = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_state.getColumns().add(salesTerritoryKeyAgg1_salesamount_state);
		ColumnSchema salesAmountAgg1_salesamount_state = new ColumnSchema("SalesAmount");
		agg1_salesamount_state.getColumns().add(salesAmountAgg1_salesamount_state);
		/* END Table: agg1_salesamount_state */

		/* START Table: agg1_salesamount_week */
		TableSchema agg1_salesamount_week = new TableSchema();
		agg1_salesamount_week.setTableName("agg1_salesamount_week");
		agg1_salesamount_week.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_week.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema weekKeyAgg1_salesamount_week = new ColumnSchema("WeekKey");
		agg1_salesamount_week.getColumns().add(weekKeyAgg1_salesamount_week);
		ColumnSchema productKeyAgg1_salesamount_week = new ColumnSchema("ProductKey");
		agg1_salesamount_week.getColumns().add(productKeyAgg1_salesamount_week);
		ColumnSchema customerKeyAgg1_salesamount_week = new ColumnSchema("CustomerKey");
		agg1_salesamount_week.getColumns().add(customerKeyAgg1_salesamount_week);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_week = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_week.getColumns().add(salesTerritoryKeyAgg1_salesamount_week);
		ColumnSchema salesAmountAgg1_salesamount_week = new ColumnSchema("SalesAmount");
		agg1_salesamount_week.getColumns().add(salesAmountAgg1_salesamount_week);
		/* END Table: agg1_salesamount_week */

		/* START Table: agg1_salesamount_year */
		TableSchema agg1_salesamount_year = new TableSchema();
		agg1_salesamount_year.setTableName("agg1_salesamount_year");
		agg1_salesamount_year.setTableType(TableType.AggregatedFactTable);
		agg1_salesamount_year.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema yearKeyAgg1_salesamount_year = new ColumnSchema("YearKey");
		agg1_salesamount_year.getColumns().add(yearKeyAgg1_salesamount_year);
		ColumnSchema productKeyAgg1_salesamount_year = new ColumnSchema("ProductKey");
		agg1_salesamount_year.getColumns().add(productKeyAgg1_salesamount_year);
		ColumnSchema customerKeyAgg1_salesamount_year = new ColumnSchema("CustomerKey");
		agg1_salesamount_year.getColumns().add(customerKeyAgg1_salesamount_year);
		ColumnSchema salesTerritoryKeyAgg1_salesamount_year = new ColumnSchema("SalesTerritoryKey");
		agg1_salesamount_year.getColumns().add(salesTerritoryKeyAgg1_salesamount_year);
		ColumnSchema salesAmountAgg1_salesamount_year = new ColumnSchema("SalesAmount");
		agg1_salesamount_year.getColumns().add(salesAmountAgg1_salesamount_year);
		/* END Table: agg1_salesamount_year */

		/* START Table: agg2_salesamount_day_city */
		TableSchema agg2_salesamount_day_city = new TableSchema();
		agg2_salesamount_day_city.setTableName("agg2_salesamount_day_city");
		agg2_salesamount_day_city.setTableType(TableType.AggregatedFactTable);
		agg2_salesamount_day_city.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema orderDateKeyAgg2_salesamount_day_city = new ColumnSchema("OrderDateKey");
		agg2_salesamount_day_city.getColumns().add(orderDateKeyAgg2_salesamount_day_city);
		ColumnSchema cityKeyAgg2_salesamount_day_city = new ColumnSchema("CityKey");
		agg2_salesamount_day_city.getColumns().add(cityKeyAgg2_salesamount_day_city);
		ColumnSchema productKeyAgg2_salesamount_day_city = new ColumnSchema("ProductKey");
		agg2_salesamount_day_city.getColumns().add(productKeyAgg2_salesamount_day_city);
		ColumnSchema salesTerritoryKeyAgg2_salesamount_day_city = new ColumnSchema("SalesTerritoryKey");
		agg2_salesamount_day_city.getColumns().add(salesTerritoryKeyAgg2_salesamount_day_city);
		ColumnSchema salesAmountAgg2_salesamount_day_city = new ColumnSchema("SalesAmount");
		agg2_salesamount_day_city.getColumns().add(salesAmountAgg2_salesamount_day_city);
		/* END Table: agg2_salesamount_day_city */

		/* START Table: agg2_salesamount_month_city */
		TableSchema agg2_salesamount_month_city = new TableSchema();
		agg2_salesamount_month_city.setTableName("agg2_salesamount_month_city");
		agg2_salesamount_month_city.setTableType(TableType.AggregatedFactTable);
		agg2_salesamount_month_city.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema monthKeyAgg2_salesamount_month_city = new ColumnSchema("MonthKey");
		agg2_salesamount_month_city.getColumns().add(monthKeyAgg2_salesamount_month_city);
		ColumnSchema cityKeyAgg2_salesamount_month_city = new ColumnSchema("CityKey");
		agg2_salesamount_month_city.getColumns().add(cityKeyAgg2_salesamount_month_city);
		ColumnSchema productKeyAgg2_salesamount_month_city = new ColumnSchema("ProductKey");
		agg2_salesamount_month_city.getColumns().add(productKeyAgg2_salesamount_month_city);
		ColumnSchema salesTerritoryKeyAgg2_salesamount_month_city = new ColumnSchema("SalesTerritoryKey");
		agg2_salesamount_month_city.getColumns().add(salesTerritoryKeyAgg2_salesamount_month_city);
		ColumnSchema salesAmountAgg2_salesamount_month_city = new ColumnSchema("SalesAmount");
		agg2_salesamount_month_city.getColumns().add(salesAmountAgg2_salesamount_month_city);
		/* END Table: agg2_salesamount_month_city */

		/* START Table: agg2_salesamount_month_country */
		TableSchema agg2_salesamount_month_country = new TableSchema();
		agg2_salesamount_month_country.setTableName("agg2_salesamount_month_country");
		agg2_salesamount_month_country.setTableType(TableType.AggregatedFactTable);
		agg2_salesamount_month_country.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema monthKeyAgg2_salesamount_month_country = new ColumnSchema("MonthKey");
		agg2_salesamount_month_country.getColumns().add(monthKeyAgg2_salesamount_month_country);
		ColumnSchema countryKeyAgg2_salesamount_month_country = new ColumnSchema("CountryKey");
		agg2_salesamount_month_country.getColumns().add(countryKeyAgg2_salesamount_month_country);
		ColumnSchema productKeyAgg2_salesamount_month_country = new ColumnSchema("ProductKey");
		agg2_salesamount_month_country.getColumns().add(productKeyAgg2_salesamount_month_country);
		ColumnSchema salesTerritoryKeyAgg2_salesamount_month_country = new ColumnSchema("SalesTerritoryKey");
		agg2_salesamount_month_country.getColumns().add(salesTerritoryKeyAgg2_salesamount_month_country);
		ColumnSchema salesAmountAgg2_salesamount_month_country = new ColumnSchema("SalesAmount");
		agg2_salesamount_month_country.getColumns().add(salesAmountAgg2_salesamount_month_country);
		/* END Table: agg2_salesamount_month_country */

		/* START Table: agg2_salesamount_month_state */
		TableSchema agg2_salesamount_month_state = new TableSchema();
		agg2_salesamount_month_state.setTableName("agg2_salesamount_month_state");
		agg2_salesamount_month_state.setTableType(TableType.AggregatedFactTable);
		agg2_salesamount_month_state.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema stateKeyAgg2_salesamount_month_state = new ColumnSchema("StateKey");
		agg2_salesamount_month_state.getColumns().add(stateKeyAgg2_salesamount_month_state);
		ColumnSchema monthKeyAgg2_salesamount_month_state = new ColumnSchema("MonthKey");
		agg2_salesamount_month_state.getColumns().add(monthKeyAgg2_salesamount_month_state);
		ColumnSchema productKeyAgg2_salesamount_month_state = new ColumnSchema("ProductKey");
		agg2_salesamount_month_state.getColumns().add(productKeyAgg2_salesamount_month_state);
		ColumnSchema salesTerritoryKeyAgg2_salesamount_month_state = new ColumnSchema("SalesTerritoryKey");
		agg2_salesamount_month_state.getColumns().add(salesTerritoryKeyAgg2_salesamount_month_state);
		ColumnSchema salesAmountAgg2_salesamount_month_state = new ColumnSchema("SalesAmount");
		agg2_salesamount_month_state.getColumns().add(salesAmountAgg2_salesamount_month_state);
		/* END Table: agg2_salesamount_month_state */

		/* START Table: agg2_salesamount_quarter_country */
		TableSchema agg2_salesamount_quarter_country = new TableSchema();
		agg2_salesamount_quarter_country.setTableName("agg2_salesamount_quarter_country");
		agg2_salesamount_quarter_country.setTableType(TableType.AggregatedFactTable);
		agg2_salesamount_quarter_country.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema quarterKeyAgg2_salesamount_quarter_country = new ColumnSchema("QuarterKey");
		agg2_salesamount_quarter_country.getColumns().add(quarterKeyAgg2_salesamount_quarter_country);
		ColumnSchema countryKeyAgg2_salesamount_quarter_country = new ColumnSchema("CountryKey");
		agg2_salesamount_quarter_country.getColumns().add(countryKeyAgg2_salesamount_quarter_country);
		ColumnSchema productKeyAgg2_salesamount_quarter_country = new ColumnSchema("ProductKey");
		agg2_salesamount_quarter_country.getColumns().add(productKeyAgg2_salesamount_quarter_country);
		ColumnSchema salesTerritoryKeyAgg2_salesamount_quarter_country = new ColumnSchema("SalesTerritoryKey");
		agg2_salesamount_quarter_country.getColumns().add(salesTerritoryKeyAgg2_salesamount_quarter_country);
		ColumnSchema salesAmountAgg2_salesamount_quarter_country = new ColumnSchema("SalesAmount");
		agg2_salesamount_quarter_country.getColumns().add(salesAmountAgg2_salesamount_quarter_country);
		/* END Table: agg2_salesamount_quarter_country */

		/* START Table: agg2_salesamount_year_city */
		TableSchema agg2_salesamount_year_city = new TableSchema();
		agg2_salesamount_year_city.setTableName("agg2_salesamount_year_city");
		agg2_salesamount_year_city.setTableType(TableType.AggregatedFactTable);
		agg2_salesamount_year_city.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema yearKeyAgg2_salesamount_year_city = new ColumnSchema("YearKey");
		agg2_salesamount_year_city.getColumns().add(yearKeyAgg2_salesamount_year_city);
		ColumnSchema cityKeyAgg2_salesamount_year_city = new ColumnSchema("CityKey");
		agg2_salesamount_year_city.getColumns().add(cityKeyAgg2_salesamount_year_city);
		ColumnSchema productKeyAgg2_salesamount_year_city = new ColumnSchema("ProductKey");
		agg2_salesamount_year_city.getColumns().add(productKeyAgg2_salesamount_year_city);
		ColumnSchema salesTerritoryKeyAgg2_salesamount_year_city = new ColumnSchema("SalesTerritoryKey");
		agg2_salesamount_year_city.getColumns().add(salesTerritoryKeyAgg2_salesamount_year_city);
		ColumnSchema salesAmountAgg2_salesamount_year_city = new ColumnSchema("SalesAmount");
		agg2_salesamount_year_city.getColumns().add(salesAmountAgg2_salesamount_year_city);
		/* END Table: agg2_salesamount_year_city */

		/* START Table: agg2_salesamount_year_country */
		TableSchema agg2_salesamount_year_country = new TableSchema();
		agg2_salesamount_year_country.setTableName("agg2_salesamount_year_country");
		agg2_salesamount_year_country.setTableType(TableType.AggregatedFactTable);
		agg2_salesamount_year_country.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema yearKeyAgg2_salesamount_year_country = new ColumnSchema("YearKey");
		agg2_salesamount_year_country.getColumns().add(yearKeyAgg2_salesamount_year_country);
		ColumnSchema countryKeyAgg2_salesamount_year_country = new ColumnSchema("CountryKey");
		agg2_salesamount_year_country.getColumns().add(countryKeyAgg2_salesamount_year_country);
		ColumnSchema productKeyAgg2_salesamount_year_country = new ColumnSchema("ProductKey");
		agg2_salesamount_year_country.getColumns().add(productKeyAgg2_salesamount_year_country);
		ColumnSchema salesTerritoryKeyAgg2_salesamount_year_country = new ColumnSchema("SalesTerritoryKey");
		agg2_salesamount_year_country.getColumns().add(salesTerritoryKeyAgg2_salesamount_year_country);
		ColumnSchema salesAmountAgg2_salesamount_year_country = new ColumnSchema("SalesAmount");
		agg2_salesamount_year_country.getColumns().add(salesAmountAgg2_salesamount_year_country);
		/* END Table: agg2_salesamount_year_country */

		/* START Table: dim_currency */
		TableSchema dim_currency = new TableSchema();
		dim_currency.setTableName("dim_currency");
		dim_currency.setTableType(TableType.BaseDimensionTable);
		dim_currency.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema currencyKeyDim_currency = new ColumnSchema("CurrencyKey");
		dim_currency.getColumns().add(currencyKeyDim_currency);
		ColumnSchema currencyAlternateKeyDim_currency = new ColumnSchema("CurrencyAlternateKey");
		dim_currency.getColumns().add(currencyAlternateKeyDim_currency);
		ColumnSchema currencyNameDim_currency = new ColumnSchema("CurrencyName");
		dim_currency.getColumns().add(currencyNameDim_currency);
		/* END Table: dim_currency */

		/* START Table: dim_customer */
		TableSchema dim_customer = new TableSchema();
		dim_customer.setTableName("dim_customer");
		dim_customer.setTableType(TableType.BaseDimensionTable);
		dim_customer.setHierarchyLevel(HierarchyLevel.Customer);

		ColumnSchema customerKeyDim_customer = new ColumnSchema("CustomerKey");
		dim_customer.getColumns().add(customerKeyDim_customer);
		ColumnSchema customerAlternateKeyDim_customer = new ColumnSchema("CustomerAlternateKey");
		dim_customer.getColumns().add(customerAlternateKeyDim_customer);
		ColumnSchema titleDim_customer = new ColumnSchema("Title");
		dim_customer.getColumns().add(titleDim_customer);
		ColumnSchema firstNameDim_customer = new ColumnSchema("FirstName");
		dim_customer.getColumns().add(firstNameDim_customer);
		ColumnSchema middleNameDim_customer = new ColumnSchema("MiddleName");
		dim_customer.getColumns().add(middleNameDim_customer);
		ColumnSchema lastNameDim_customer = new ColumnSchema("LastName");
		dim_customer.getColumns().add(lastNameDim_customer);
		ColumnSchema nameStyleDim_customer = new ColumnSchema("NameStyle");
		dim_customer.getColumns().add(nameStyleDim_customer);
		ColumnSchema birthDateDim_customer = new ColumnSchema("BirthDate");
		dim_customer.getColumns().add(birthDateDim_customer);
		ColumnSchema maritalStatusDim_customer = new ColumnSchema("MaritalStatus");
		dim_customer.getColumns().add(maritalStatusDim_customer);
		ColumnSchema suffixDim_customer = new ColumnSchema("Suffix");
		dim_customer.getColumns().add(suffixDim_customer);
		ColumnSchema genderDim_customer = new ColumnSchema("Gender");
		dim_customer.getColumns().add(genderDim_customer);
		ColumnSchema emailAddressDim_customer = new ColumnSchema("EmailAddress");
		dim_customer.getColumns().add(emailAddressDim_customer);
		ColumnSchema yearlyIncomeDim_customer = new ColumnSchema("YearlyIncome");
		dim_customer.getColumns().add(yearlyIncomeDim_customer);
		ColumnSchema totalChildrenDim_customer = new ColumnSchema("TotalChildren");
		dim_customer.getColumns().add(totalChildrenDim_customer);
		ColumnSchema numberChildrenAtHomeDim_customer = new ColumnSchema("NumberChildrenAtHome");
		dim_customer.getColumns().add(numberChildrenAtHomeDim_customer);
		ColumnSchema englishEducationDim_customer = new ColumnSchema("EnglishEducation");
		dim_customer.getColumns().add(englishEducationDim_customer);
		ColumnSchema spanishEducationDim_customer = new ColumnSchema("SpanishEducation");
		dim_customer.getColumns().add(spanishEducationDim_customer);
		ColumnSchema frenchEducationDim_customer = new ColumnSchema("FrenchEducation");
		dim_customer.getColumns().add(frenchEducationDim_customer);
		ColumnSchema englishOccupationDim_customer = new ColumnSchema("EnglishOccupation");
		dim_customer.getColumns().add(englishOccupationDim_customer);
		ColumnSchema spanishOccupationDim_customer = new ColumnSchema("SpanishOccupation");
		dim_customer.getColumns().add(spanishOccupationDim_customer);
		ColumnSchema frenchOccupationDim_customer = new ColumnSchema("FrenchOccupation");
		dim_customer.getColumns().add(frenchOccupationDim_customer);
		ColumnSchema houseOwnerFlagDim_customer = new ColumnSchema("HouseOwnerFlag");
		dim_customer.getColumns().add(houseOwnerFlagDim_customer);
		ColumnSchema numberCarsOwnedDim_customer = new ColumnSchema("NumberCarsOwned");
		dim_customer.getColumns().add(numberCarsOwnedDim_customer);
		ColumnSchema addressLine1Dim_customer = new ColumnSchema("AddressLine1");
		dim_customer.getColumns().add(addressLine1Dim_customer);
		ColumnSchema addressLine2Dim_customer = new ColumnSchema("AddressLine2");
		dim_customer.getColumns().add(addressLine2Dim_customer);
		ColumnSchema cityDim_customer = new ColumnSchema("City");
		dim_customer.getColumns().add(cityDim_customer);
		ColumnSchema stateProvinceCodeDim_customer = new ColumnSchema("StateProvinceCode");
		dim_customer.getColumns().add(stateProvinceCodeDim_customer);
		ColumnSchema stateProvinceNameDim_customer = new ColumnSchema("StateProvinceName");
		dim_customer.getColumns().add(stateProvinceNameDim_customer);
		ColumnSchema countryRegionCodeDim_customer = new ColumnSchema("CountryRegionCode");
		dim_customer.getColumns().add(countryRegionCodeDim_customer);
		ColumnSchema englishCountryRegionNameDim_customer = new ColumnSchema("EnglishCountryRegionName");
		dim_customer.getColumns().add(englishCountryRegionNameDim_customer);
		ColumnSchema spanishCountryRegionNameDim_customer = new ColumnSchema("SpanishCountryRegionName");
		dim_customer.getColumns().add(spanishCountryRegionNameDim_customer);
		ColumnSchema frenchCountryRegionNameDim_customer = new ColumnSchema("FrenchCountryRegionName");
		dim_customer.getColumns().add(frenchCountryRegionNameDim_customer);
		ColumnSchema postalCodeDim_customer = new ColumnSchema("PostalCode");
		dim_customer.getColumns().add(postalCodeDim_customer);
		ColumnSchema salesTerritoryKeyDim_customer = new ColumnSchema("SalesTerritoryKey");
		dim_customer.getColumns().add(salesTerritoryKeyDim_customer);
		ColumnSchema ipAddressLocatorDim_customer = new ColumnSchema("IpAddressLocator");
		dim_customer.getColumns().add(ipAddressLocatorDim_customer);
		ColumnSchema phoneDim_customer = new ColumnSchema("Phone");
		dim_customer.getColumns().add(phoneDim_customer);
		ColumnSchema dateFirstPurchaseDim_customer = new ColumnSchema("DateFirstPurchase");
		dim_customer.getColumns().add(dateFirstPurchaseDim_customer);
		ColumnSchema commuteDistanceDim_customer = new ColumnSchema("CommuteDistance");
		dim_customer.getColumns().add(commuteDistanceDim_customer);
		/* END Table: dim_customer */

		/* START Table: dim_date */
		TableSchema dim_date = new TableSchema();
		dim_date.setTableName("dim_date");
		dim_date.setTableType(TableType.BaseDimensionTable);
		dim_date.setHierarchyLevel(HierarchyLevel.Date);

		ColumnSchema dateKeyDim_date = new ColumnSchema("DateKey");
		dim_date.getColumns().add(dateKeyDim_date);
		ColumnSchema fullDateAlternateKeyDim_date = new ColumnSchema("FullDateAlternateKey");
		dim_date.getColumns().add(fullDateAlternateKeyDim_date);
		ColumnSchema dayNumberOfWeekDim_date = new ColumnSchema("DayNumberOfWeek");
		dim_date.getColumns().add(dayNumberOfWeekDim_date);
		ColumnSchema englishDayNameOfWeekDim_date = new ColumnSchema("EnglishDayNameOfWeek");
		dim_date.getColumns().add(englishDayNameOfWeekDim_date);
		ColumnSchema spanishDayNameOfWeekDim_date = new ColumnSchema("SpanishDayNameOfWeek");
		dim_date.getColumns().add(spanishDayNameOfWeekDim_date);
		ColumnSchema frenchDayNameOfWeekDim_date = new ColumnSchema("FrenchDayNameOfWeek");
		dim_date.getColumns().add(frenchDayNameOfWeekDim_date);
		ColumnSchema dayNumberOfMonthDim_date = new ColumnSchema("DayNumberOfMonth");
		dim_date.getColumns().add(dayNumberOfMonthDim_date);
		ColumnSchema dayNumberOfYearDim_date = new ColumnSchema("DayNumberOfYear");
		dim_date.getColumns().add(dayNumberOfYearDim_date);
		ColumnSchema weekNumberOfYearDim_date = new ColumnSchema("WeekNumberOfYear");
		dim_date.getColumns().add(weekNumberOfYearDim_date);
		ColumnSchema englishMonthNameDim_date = new ColumnSchema("EnglishMonthName");
		dim_date.getColumns().add(englishMonthNameDim_date);
		ColumnSchema spanishMonthNameDim_date = new ColumnSchema("SpanishMonthName");
		dim_date.getColumns().add(spanishMonthNameDim_date);
		ColumnSchema frenchMonthNameDim_date = new ColumnSchema("FrenchMonthName");
		dim_date.getColumns().add(frenchMonthNameDim_date);
		ColumnSchema monthNumberOfYearDim_date = new ColumnSchema("MonthNumberOfYear");
		dim_date.getColumns().add(monthNumberOfYearDim_date);
		ColumnSchema calendarQuarterDim_date = new ColumnSchema("CalendarQuarter");
		dim_date.getColumns().add(calendarQuarterDim_date);
		ColumnSchema calendarYearDim_date = new ColumnSchema("CalendarYear");
		dim_date.getColumns().add(calendarYearDim_date);
		ColumnSchema calendarSemesterDim_date = new ColumnSchema("CalendarSemester");
		dim_date.getColumns().add(calendarSemesterDim_date);
		ColumnSchema fiscalQuarterDim_date = new ColumnSchema("FiscalQuarter");
		dim_date.getColumns().add(fiscalQuarterDim_date);
		ColumnSchema fiscalYearDim_date = new ColumnSchema("FiscalYear");
		dim_date.getColumns().add(fiscalYearDim_date);
		ColumnSchema fiscalSemesterDim_date = new ColumnSchema("FiscalSemester");
		dim_date.getColumns().add(fiscalSemesterDim_date);
		/* END Table: dim_date */

		/* START Table: dim_product */
		TableSchema dim_product = new TableSchema();
		dim_product.setTableName("dim_product");
		dim_product.setTableType(TableType.BaseDimensionTable);
		dim_product.setHierarchyLevel(HierarchyLevel.Product);

		ColumnSchema productKeyDim_product = new ColumnSchema("ProductKey");
		dim_product.getColumns().add(productKeyDim_product);
		ColumnSchema productAlternateKeyDim_product = new ColumnSchema("ProductAlternateKey");
		dim_product.getColumns().add(productAlternateKeyDim_product);
		ColumnSchema productSubcategoryKeyDim_product = new ColumnSchema("ProductSubcategoryKey");
		dim_product.getColumns().add(productSubcategoryKeyDim_product);
		ColumnSchema weightUnitMeasureCodeDim_product = new ColumnSchema("WeightUnitMeasureCode");
		dim_product.getColumns().add(weightUnitMeasureCodeDim_product);
		ColumnSchema sizeUnitMeasureCodeDim_product = new ColumnSchema("SizeUnitMeasureCode");
		dim_product.getColumns().add(sizeUnitMeasureCodeDim_product);
		ColumnSchema englishProductNameDim_product = new ColumnSchema("EnglishProductName");
		dim_product.getColumns().add(englishProductNameDim_product);
		ColumnSchema spanishProductNameDim_product = new ColumnSchema("SpanishProductName");
		dim_product.getColumns().add(spanishProductNameDim_product);
		ColumnSchema frenchProductNameDim_product = new ColumnSchema("FrenchProductName");
		dim_product.getColumns().add(frenchProductNameDim_product);
		ColumnSchema standardCostDim_product = new ColumnSchema("StandardCost");
		dim_product.getColumns().add(standardCostDim_product);
		ColumnSchema finishedGoodsFlagDim_product = new ColumnSchema("FinishedGoodsFlag");
		dim_product.getColumns().add(finishedGoodsFlagDim_product);
		ColumnSchema colorDim_product = new ColumnSchema("Color");
		dim_product.getColumns().add(colorDim_product);
		ColumnSchema safetyStockLevelDim_product = new ColumnSchema("SafetyStockLevel");
		dim_product.getColumns().add(safetyStockLevelDim_product);
		ColumnSchema reorderPointDim_product = new ColumnSchema("ReorderPoint");
		dim_product.getColumns().add(reorderPointDim_product);
		ColumnSchema listPriceDim_product = new ColumnSchema("ListPrice");
		dim_product.getColumns().add(listPriceDim_product);
		ColumnSchema sizeDim_product = new ColumnSchema("Size");
		dim_product.getColumns().add(sizeDim_product);
		ColumnSchema sizeRangeDim_product = new ColumnSchema("SizeRange");
		dim_product.getColumns().add(sizeRangeDim_product);
		ColumnSchema weightDim_product = new ColumnSchema("Weight");
		dim_product.getColumns().add(weightDim_product);
		ColumnSchema daysToManufactureDim_product = new ColumnSchema("DaysToManufacture");
		dim_product.getColumns().add(daysToManufactureDim_product);
		ColumnSchema productLineDim_product = new ColumnSchema("ProductLine");
		dim_product.getColumns().add(productLineDim_product);
		ColumnSchema dealerPriceDim_product = new ColumnSchema("DealerPrice");
		dim_product.getColumns().add(dealerPriceDim_product);
		ColumnSchema classDim_product = new ColumnSchema("Class");
		dim_product.getColumns().add(classDim_product);
		ColumnSchema styleDim_product = new ColumnSchema("Style");
		dim_product.getColumns().add(styleDim_product);
		ColumnSchema modelNameDim_product = new ColumnSchema("ModelName");
		dim_product.getColumns().add(modelNameDim_product);
		ColumnSchema largePhotoDim_product = new ColumnSchema("LargePhoto");
		dim_product.getColumns().add(largePhotoDim_product);
		ColumnSchema englishDescriptionDim_product = new ColumnSchema("EnglishDescription");
		dim_product.getColumns().add(englishDescriptionDim_product);
		ColumnSchema frenchDescriptionDim_product = new ColumnSchema("FrenchDescription");
		dim_product.getColumns().add(frenchDescriptionDim_product);
		ColumnSchema chineseDescriptionDim_product = new ColumnSchema("ChineseDescription");
		dim_product.getColumns().add(chineseDescriptionDim_product);
		ColumnSchema arabicDescriptionDim_product = new ColumnSchema("ArabicDescription");
		dim_product.getColumns().add(arabicDescriptionDim_product);
		ColumnSchema hebrewDescriptionDim_product = new ColumnSchema("HebrewDescription");
		dim_product.getColumns().add(hebrewDescriptionDim_product);
		ColumnSchema thaiDescriptionDim_product = new ColumnSchema("ThaiDescription");
		dim_product.getColumns().add(thaiDescriptionDim_product);
		ColumnSchema germanDescriptionDim_product = new ColumnSchema("GermanDescription");
		dim_product.getColumns().add(germanDescriptionDim_product);
		ColumnSchema japaneseDescriptionDim_product = new ColumnSchema("JapaneseDescription");
		dim_product.getColumns().add(japaneseDescriptionDim_product);
		ColumnSchema turkishDescriptionDim_product = new ColumnSchema("TurkishDescription");
		dim_product.getColumns().add(turkishDescriptionDim_product);
		ColumnSchema startDateDim_product = new ColumnSchema("StartDate");
		dim_product.getColumns().add(startDateDim_product);
		ColumnSchema endDateDim_product = new ColumnSchema("EndDate");
		dim_product.getColumns().add(endDateDim_product);
		ColumnSchema statusDim_product = new ColumnSchema("Status");
		dim_product.getColumns().add(statusDim_product);
		/* END Table: dim_product */

		/* START Table: dim_productcategory */
		TableSchema dim_productcategory = new TableSchema();
		dim_productcategory.setTableName("dim_productcategory");
		dim_productcategory.setTableType(TableType.ShrunkenDimensionTable);
		dim_productcategory.setHierarchyLevel(HierarchyLevel.Category);

		ColumnSchema productCategoryKeyDim_productcategory = new ColumnSchema("ProductCategoryKey");
		dim_productcategory.getColumns().add(productCategoryKeyDim_productcategory);
		ColumnSchema productCategoryAlternateKeyDim_productcategory = new ColumnSchema("ProductCategoryAlternateKey");
		dim_productcategory.getColumns().add(productCategoryAlternateKeyDim_productcategory);
		ColumnSchema englishProductCategoryNameDim_productcategory = new ColumnSchema("EnglishProductCategoryName");
		dim_productcategory.getColumns().add(englishProductCategoryNameDim_productcategory);
		ColumnSchema spanishProductCategoryNameDim_productcategory = new ColumnSchema("SpanishProductCategoryName");
		dim_productcategory.getColumns().add(spanishProductCategoryNameDim_productcategory);
		ColumnSchema frenchProductCategoryNameDim_productcategory = new ColumnSchema("FrenchProductCategoryName");
		dim_productcategory.getColumns().add(frenchProductCategoryNameDim_productcategory);
		/* END Table: dim_productcategory */

		/* START Table: dim_productsubcategory */
		TableSchema dim_productsubcategory = new TableSchema();
		dim_productsubcategory.setTableName("dim_productsubcategory");
		dim_productsubcategory.setTableType(TableType.ShrunkenDimensionTable);
		dim_productsubcategory.setHierarchyLevel(HierarchyLevel.SubCategory);

		ColumnSchema productSubcategoryKeyDim_productsubcategory = new ColumnSchema("ProductSubcategoryKey");
		dim_productsubcategory.getColumns().add(productSubcategoryKeyDim_productsubcategory);
		ColumnSchema productSubcategoryAlternateKeyDim_productsubcategory = new ColumnSchema("ProductSubcategoryAlternateKey");
		dim_productsubcategory.getColumns().add(productSubcategoryAlternateKeyDim_productsubcategory);
		ColumnSchema englishProductSubcategoryNameDim_productsubcategory = new ColumnSchema("EnglishProductSubcategoryName");
		dim_productsubcategory.getColumns().add(englishProductSubcategoryNameDim_productsubcategory);
		ColumnSchema spanishProductSubcategoryNameDim_productsubcategory = new ColumnSchema("SpanishProductSubcategoryName");
		dim_productsubcategory.getColumns().add(spanishProductSubcategoryNameDim_productsubcategory);
		ColumnSchema frenchProductSubcategoryNameDim_productsubcategory = new ColumnSchema("FrenchProductSubcategoryName");
		dim_productsubcategory.getColumns().add(frenchProductSubcategoryNameDim_productsubcategory);
		ColumnSchema productCategoryKeyDim_productsubcategory = new ColumnSchema("ProductCategoryKey");
		dim_productsubcategory.getColumns().add(productCategoryKeyDim_productsubcategory);
		/* END Table: dim_productsubcategory */

		/* START Table: dim_promotion */
		TableSchema dim_promotion = new TableSchema();
		dim_promotion.setTableName("dim_promotion");
		dim_promotion.setTableType(TableType.BaseDimensionTable);
		dim_promotion.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema promotionKeyDim_promotion = new ColumnSchema("PromotionKey");
		dim_promotion.getColumns().add(promotionKeyDim_promotion);
		ColumnSchema promotionAlternateKeyDim_promotion = new ColumnSchema("PromotionAlternateKey");
		dim_promotion.getColumns().add(promotionAlternateKeyDim_promotion);
		ColumnSchema englishPromotionNameDim_promotion = new ColumnSchema("EnglishPromotionName");
		dim_promotion.getColumns().add(englishPromotionNameDim_promotion);
		ColumnSchema spanishPromotionNameDim_promotion = new ColumnSchema("SpanishPromotionName");
		dim_promotion.getColumns().add(spanishPromotionNameDim_promotion);
		ColumnSchema frenchPromotionNameDim_promotion = new ColumnSchema("FrenchPromotionName");
		dim_promotion.getColumns().add(frenchPromotionNameDim_promotion);
		ColumnSchema discountPctDim_promotion = new ColumnSchema("DiscountPct");
		dim_promotion.getColumns().add(discountPctDim_promotion);
		ColumnSchema englishPromotionTypeDim_promotion = new ColumnSchema("EnglishPromotionType");
		dim_promotion.getColumns().add(englishPromotionTypeDim_promotion);
		ColumnSchema spanishPromotionTypeDim_promotion = new ColumnSchema("SpanishPromotionType");
		dim_promotion.getColumns().add(spanishPromotionTypeDim_promotion);
		ColumnSchema frenchPromotionTypeDim_promotion = new ColumnSchema("FrenchPromotionType");
		dim_promotion.getColumns().add(frenchPromotionTypeDim_promotion);
		ColumnSchema englishPromotionCategoryDim_promotion = new ColumnSchema("EnglishPromotionCategory");
		dim_promotion.getColumns().add(englishPromotionCategoryDim_promotion);
		ColumnSchema spanishPromotionCategoryDim_promotion = new ColumnSchema("SpanishPromotionCategory");
		dim_promotion.getColumns().add(spanishPromotionCategoryDim_promotion);
		ColumnSchema frenchPromotionCategoryDim_promotion = new ColumnSchema("FrenchPromotionCategory");
		dim_promotion.getColumns().add(frenchPromotionCategoryDim_promotion);
		ColumnSchema startDateDim_promotion = new ColumnSchema("StartDate");
		dim_promotion.getColumns().add(startDateDim_promotion);
		ColumnSchema endDateDim_promotion = new ColumnSchema("EndDate");
		dim_promotion.getColumns().add(endDateDim_promotion);
		ColumnSchema minQtyDim_promotion = new ColumnSchema("MinQty");
		dim_promotion.getColumns().add(minQtyDim_promotion);
		ColumnSchema maxQtyDim_promotion = new ColumnSchema("MaxQty");
		dim_promotion.getColumns().add(maxQtyDim_promotion);
		/* END Table: dim_promotion */

		/* START Table: dim_salesterritory */
		TableSchema dim_salesterritory = new TableSchema();
		dim_salesterritory.setTableName("dim_salesterritory");
		dim_salesterritory.setTableType(TableType.BaseDimensionTable);
		dim_salesterritory.setHierarchyLevel(HierarchyLevel.Region);

		ColumnSchema salesTerritoryKeyDim_salesterritory = new ColumnSchema("SalesTerritoryKey");
		dim_salesterritory.getColumns().add(salesTerritoryKeyDim_salesterritory);
		ColumnSchema salesTerritoryAlternateKeyDim_salesterritory = new ColumnSchema("SalesTerritoryAlternateKey");
		dim_salesterritory.getColumns().add(salesTerritoryAlternateKeyDim_salesterritory);
		ColumnSchema salesTerritoryRegionDim_salesterritory = new ColumnSchema("SalesTerritoryRegion");
		dim_salesterritory.getColumns().add(salesTerritoryRegionDim_salesterritory);
		ColumnSchema salesTerritoryCountryDim_salesterritory = new ColumnSchema("SalesTerritoryCountry");
		dim_salesterritory.getColumns().add(salesTerritoryCountryDim_salesterritory);
		ColumnSchema salesTerritoryGroupDim_salesterritory = new ColumnSchema("SalesTerritoryGroup");
		dim_salesterritory.getColumns().add(salesTerritoryGroupDim_salesterritory);
		ColumnSchema salesTerritoryImageDim_salesterritory = new ColumnSchema("SalesTerritoryImage");
		dim_salesterritory.getColumns().add(salesTerritoryImageDim_salesterritory);
		/* END Table: dim_salesterritory */

		/* START Table: fact_internetsales */
		TableSchema fact_internetsales = new TableSchema();
		fact_internetsales.setTableName("fact_internetsales");
		fact_internetsales.setTableType(TableType.BaseFactTable);
		fact_internetsales.setHierarchyLevel(HierarchyLevel.All);

		ColumnSchema productKeyFact_internetsales = new ColumnSchema("ProductKey");
		fact_internetsales.getColumns().add(productKeyFact_internetsales);
		ColumnSchema orderDateKeyFact_internetsales = new ColumnSchema("OrderDateKey");
		fact_internetsales.getColumns().add(orderDateKeyFact_internetsales);
		ColumnSchema dueDateKeyFact_internetsales = new ColumnSchema("DueDateKey");
		fact_internetsales.getColumns().add(dueDateKeyFact_internetsales);
		ColumnSchema shipDateKeyFact_internetsales = new ColumnSchema("ShipDateKey");
		fact_internetsales.getColumns().add(shipDateKeyFact_internetsales);
		ColumnSchema customerKeyFact_internetsales = new ColumnSchema("CustomerKey");
		fact_internetsales.getColumns().add(customerKeyFact_internetsales);
		ColumnSchema promotionKeyFact_internetsales = new ColumnSchema("PromotionKey");
		fact_internetsales.getColumns().add(promotionKeyFact_internetsales);
		ColumnSchema currencyKeyFact_internetsales = new ColumnSchema("CurrencyKey");
		fact_internetsales.getColumns().add(currencyKeyFact_internetsales);
		ColumnSchema salesTerritoryKeyFact_internetsales = new ColumnSchema("SalesTerritoryKey");
		fact_internetsales.getColumns().add(salesTerritoryKeyFact_internetsales);
		ColumnSchema salesOrderNumberFact_internetsales = new ColumnSchema("SalesOrderNumber");
		fact_internetsales.getColumns().add(salesOrderNumberFact_internetsales);
		ColumnSchema salesOrderLineNumberFact_internetsales = new ColumnSchema("SalesOrderLineNumber");
		fact_internetsales.getColumns().add(salesOrderLineNumberFact_internetsales);
		ColumnSchema revisionNumberFact_internetsales = new ColumnSchema("RevisionNumber");
		fact_internetsales.getColumns().add(revisionNumberFact_internetsales);
		ColumnSchema orderQuantityFact_internetsales = new ColumnSchema("OrderQuantity");
		fact_internetsales.getColumns().add(orderQuantityFact_internetsales);
		ColumnSchema unitPriceFact_internetsales = new ColumnSchema("UnitPrice");
		fact_internetsales.getColumns().add(unitPriceFact_internetsales);
		ColumnSchema extendedAmountFact_internetsales = new ColumnSchema("ExtendedAmount");
		fact_internetsales.getColumns().add(extendedAmountFact_internetsales);
		ColumnSchema unitPriceDiscountPctFact_internetsales = new ColumnSchema("UnitPriceDiscountPct");
		fact_internetsales.getColumns().add(unitPriceDiscountPctFact_internetsales);
		ColumnSchema discountAmountFact_internetsales = new ColumnSchema("DiscountAmount");
		fact_internetsales.getColumns().add(discountAmountFact_internetsales);
		ColumnSchema productStandardCostFact_internetsales = new ColumnSchema("ProductStandardCost");
		fact_internetsales.getColumns().add(productStandardCostFact_internetsales);
		ColumnSchema totalProductCostFact_internetsales = new ColumnSchema("TotalProductCost");
		fact_internetsales.getColumns().add(totalProductCostFact_internetsales);
		ColumnSchema salesAmountFact_internetsales = new ColumnSchema("SalesAmount");
		fact_internetsales.getColumns().add(salesAmountFact_internetsales);
		ColumnSchema taxAmtFact_internetsales = new ColumnSchema("TaxAmt");
		fact_internetsales.getColumns().add(taxAmtFact_internetsales);
		ColumnSchema freightFact_internetsales = new ColumnSchema("Freight");
		fact_internetsales.getColumns().add(freightFact_internetsales);
		ColumnSchema carrierTrackingNumberFact_internetsales = new ColumnSchema("CarrierTrackingNumber");
		fact_internetsales.getColumns().add(carrierTrackingNumberFact_internetsales);
		ColumnSchema customerPONumberFact_internetsales = new ColumnSchema("CustomerPONumber");
		fact_internetsales.getColumns().add(customerPONumberFact_internetsales);
		ColumnSchema orderDateFact_internetsales = new ColumnSchema("OrderDate");
		fact_internetsales.getColumns().add(orderDateFact_internetsales);
		ColumnSchema dueDateFact_internetsales = new ColumnSchema("DueDate");
		fact_internetsales.getColumns().add(dueDateFact_internetsales);
		ColumnSchema shipDateFact_internetsales = new ColumnSchema("ShipDate");
		fact_internetsales.getColumns().add(shipDateFact_internetsales);
		/* END Table: fact_internetsales */

		/* START Table: shr_dimcustomer_city */
		TableSchema shr_dimcustomer_city = new TableSchema();
		shr_dimcustomer_city.setTableName("shr_dimcustomer_city");
		shr_dimcustomer_city.setTableType(TableType.ShrunkenDimensionTable);
		shr_dimcustomer_city.setHierarchyLevel(HierarchyLevel.City);

		ColumnSchema cityKeyShr_dimcustomer_city = new ColumnSchema("CityKey");
		shr_dimcustomer_city.getColumns().add(cityKeyShr_dimcustomer_city);
		ColumnSchema cityShr_dimcustomer_city = new ColumnSchema("City");
		shr_dimcustomer_city.getColumns().add(cityShr_dimcustomer_city);
		ColumnSchema stateProvinceCodeShr_dimcustomer_city = new ColumnSchema("StateProvinceCode");
		shr_dimcustomer_city.getColumns().add(stateProvinceCodeShr_dimcustomer_city);
		ColumnSchema stateProvinceNameShr_dimcustomer_city = new ColumnSchema("StateProvinceName");
		shr_dimcustomer_city.getColumns().add(stateProvinceNameShr_dimcustomer_city);
		ColumnSchema countryRegionCodeShr_dimcustomer_city = new ColumnSchema("CountryRegionCode");
		shr_dimcustomer_city.getColumns().add(countryRegionCodeShr_dimcustomer_city);
		ColumnSchema englishCountryRegionNameShr_dimcustomer_city = new ColumnSchema("EnglishCountryRegionName");
		shr_dimcustomer_city.getColumns().add(englishCountryRegionNameShr_dimcustomer_city);
		ColumnSchema spanishCountryRegionNameShr_dimcustomer_city = new ColumnSchema("SpanishCountryRegionName");
		shr_dimcustomer_city.getColumns().add(spanishCountryRegionNameShr_dimcustomer_city);
		ColumnSchema frenchCountryRegionNameShr_dimcustomer_city = new ColumnSchema("FrenchCountryRegionName");
		shr_dimcustomer_city.getColumns().add(frenchCountryRegionNameShr_dimcustomer_city);
		ColumnSchema salesTerritoryKeyShr_dimcustomer_city = new ColumnSchema("SalesTerritoryKey");
		shr_dimcustomer_city.getColumns().add(salesTerritoryKeyShr_dimcustomer_city);
		ColumnSchema ipAddressLocatorShr_dimcustomer_city = new ColumnSchema("IpAddressLocator");
		shr_dimcustomer_city.getColumns().add(ipAddressLocatorShr_dimcustomer_city);
		/* END Table: shr_dimcustomer_city */

		/* START Table: shr_dimcustomer_country */
		TableSchema shr_dimcustomer_country = new TableSchema();
		shr_dimcustomer_country.setTableName("shr_dimcustomer_country");
		shr_dimcustomer_country.setTableType(TableType.ShrunkenDimensionTable);
		shr_dimcustomer_country.setHierarchyLevel(HierarchyLevel.Country);

		ColumnSchema countryKeyShr_dimcustomer_country = new ColumnSchema("CountryKey");
		shr_dimcustomer_country.getColumns().add(countryKeyShr_dimcustomer_country);
		ColumnSchema countryRegionCodeShr_dimcustomer_country = new ColumnSchema("CountryRegionCode");
		shr_dimcustomer_country.getColumns().add(countryRegionCodeShr_dimcustomer_country);
		ColumnSchema englishCountryRegionNameShr_dimcustomer_country = new ColumnSchema("EnglishCountryRegionName");
		shr_dimcustomer_country.getColumns().add(englishCountryRegionNameShr_dimcustomer_country);
		ColumnSchema spanishCountryRegionNameShr_dimcustomer_country = new ColumnSchema("SpanishCountryRegionName");
		shr_dimcustomer_country.getColumns().add(spanishCountryRegionNameShr_dimcustomer_country);
		ColumnSchema frenchCountryRegionNameShr_dimcustomer_country = new ColumnSchema("FrenchCountryRegionName");
		shr_dimcustomer_country.getColumns().add(frenchCountryRegionNameShr_dimcustomer_country);
		ColumnSchema salesTerritoryKeyShr_dimcustomer_country = new ColumnSchema("SalesTerritoryKey");
		shr_dimcustomer_country.getColumns().add(salesTerritoryKeyShr_dimcustomer_country);
		ColumnSchema ipAddressLocatorShr_dimcustomer_country = new ColumnSchema("IpAddressLocator");
		shr_dimcustomer_country.getColumns().add(ipAddressLocatorShr_dimcustomer_country);
		/* END Table: shr_dimcustomer_country */

		/* START Table: shr_dimcustomer_postalcode */
		TableSchema shr_dimcustomer_postalcode = new TableSchema();
		shr_dimcustomer_postalcode.setTableName("shr_dimcustomer_postalcode");
		shr_dimcustomer_postalcode.setTableType(TableType.ShrunkenDimensionTable);
		shr_dimcustomer_postalcode.setHierarchyLevel(HierarchyLevel.PostalCode);

		ColumnSchema postalCodeKeyShr_dimcustomer_postalcode = new ColumnSchema("PostalCodeKey");
		shr_dimcustomer_postalcode.getColumns().add(postalCodeKeyShr_dimcustomer_postalcode);
		ColumnSchema postalCodeShr_dimcustomer_postalcode = new ColumnSchema("PostalCode");
		shr_dimcustomer_postalcode.getColumns().add(postalCodeShr_dimcustomer_postalcode);
		ColumnSchema cityShr_dimcustomer_postalcode = new ColumnSchema("City");
		shr_dimcustomer_postalcode.getColumns().add(cityShr_dimcustomer_postalcode);
		ColumnSchema stateProvinceCodeShr_dimcustomer_postalcode = new ColumnSchema("StateProvinceCode");
		shr_dimcustomer_postalcode.getColumns().add(stateProvinceCodeShr_dimcustomer_postalcode);
		ColumnSchema stateProvinceNameShr_dimcustomer_postalcode = new ColumnSchema("StateProvinceName");
		shr_dimcustomer_postalcode.getColumns().add(stateProvinceNameShr_dimcustomer_postalcode);
		ColumnSchema countryRegionCodeShr_dimcustomer_postalcode = new ColumnSchema("CountryRegionCode");
		shr_dimcustomer_postalcode.getColumns().add(countryRegionCodeShr_dimcustomer_postalcode);
		ColumnSchema englishCountryRegionNameShr_dimcustomer_postalcode = new ColumnSchema("EnglishCountryRegionName");
		shr_dimcustomer_postalcode.getColumns().add(englishCountryRegionNameShr_dimcustomer_postalcode);
		ColumnSchema spanishCountryRegionNameShr_dimcustomer_postalcode = new ColumnSchema("SpanishCountryRegionName");
		shr_dimcustomer_postalcode.getColumns().add(spanishCountryRegionNameShr_dimcustomer_postalcode);
		ColumnSchema frenchCountryRegionNameShr_dimcustomer_postalcode = new ColumnSchema("FrenchCountryRegionName");
		shr_dimcustomer_postalcode.getColumns().add(frenchCountryRegionNameShr_dimcustomer_postalcode);
		ColumnSchema salesTerritoryKeyShr_dimcustomer_postalcode = new ColumnSchema("SalesTerritoryKey");
		shr_dimcustomer_postalcode.getColumns().add(salesTerritoryKeyShr_dimcustomer_postalcode);
		ColumnSchema ipAddressLocatorShr_dimcustomer_postalcode = new ColumnSchema("IpAddressLocator");
		shr_dimcustomer_postalcode.getColumns().add(ipAddressLocatorShr_dimcustomer_postalcode);
		/* END Table: shr_dimcustomer_postalcode */

		/* START Table: shr_dimcustomer_state */
		TableSchema shr_dimcustomer_state = new TableSchema();
		shr_dimcustomer_state.setTableName("shr_dimcustomer_state");
		shr_dimcustomer_state.setTableType(TableType.ShrunkenDimensionTable);
		shr_dimcustomer_state.setHierarchyLevel(HierarchyLevel.State);

		ColumnSchema stateKeyShr_dimcustomer_state = new ColumnSchema("StateKey");
		shr_dimcustomer_state.getColumns().add(stateKeyShr_dimcustomer_state);
		ColumnSchema stateProvinceCodeShr_dimcustomer_state = new ColumnSchema("StateProvinceCode");
		shr_dimcustomer_state.getColumns().add(stateProvinceCodeShr_dimcustomer_state);
		ColumnSchema stateProvinceNameShr_dimcustomer_state = new ColumnSchema("StateProvinceName");
		shr_dimcustomer_state.getColumns().add(stateProvinceNameShr_dimcustomer_state);
		ColumnSchema countryRegionCodeShr_dimcustomer_state = new ColumnSchema("CountryRegionCode");
		shr_dimcustomer_state.getColumns().add(countryRegionCodeShr_dimcustomer_state);
		ColumnSchema englishCountryRegionNameShr_dimcustomer_state = new ColumnSchema("EnglishCountryRegionName");
		shr_dimcustomer_state.getColumns().add(englishCountryRegionNameShr_dimcustomer_state);
		ColumnSchema spanishCountryRegionNameShr_dimcustomer_state = new ColumnSchema("SpanishCountryRegionName");
		shr_dimcustomer_state.getColumns().add(spanishCountryRegionNameShr_dimcustomer_state);
		ColumnSchema frenchCountryRegionNameShr_dimcustomer_state = new ColumnSchema("FrenchCountryRegionName");
		shr_dimcustomer_state.getColumns().add(frenchCountryRegionNameShr_dimcustomer_state);
		ColumnSchema salesTerritoryKeyShr_dimcustomer_state = new ColumnSchema("SalesTerritoryKey");
		shr_dimcustomer_state.getColumns().add(salesTerritoryKeyShr_dimcustomer_state);
		ColumnSchema ipAddressLocatorShr_dimcustomer_state = new ColumnSchema("IpAddressLocator");
		shr_dimcustomer_state.getColumns().add(ipAddressLocatorShr_dimcustomer_state);
		/* END Table: shr_dimcustomer_state */

		/* START Table: shr_dimdate_month */
		TableSchema shr_dimdate_month = new TableSchema();
		shr_dimdate_month.setTableName("shr_dimdate_month");
		shr_dimdate_month.setTableType(TableType.ShrunkenDimensionTable);
		shr_dimdate_month.setHierarchyLevel(HierarchyLevel.Month);

		ColumnSchema monthKeyShr_dimdate_month = new ColumnSchema("MonthKey");
		shr_dimdate_month.getColumns().add(monthKeyShr_dimdate_month);
		ColumnSchema englishMonthNameShr_dimdate_month = new ColumnSchema("EnglishMonthName");
		shr_dimdate_month.getColumns().add(englishMonthNameShr_dimdate_month);
		ColumnSchema spanishMonthNameShr_dimdate_month = new ColumnSchema("SpanishMonthName");
		shr_dimdate_month.getColumns().add(spanishMonthNameShr_dimdate_month);
		ColumnSchema frenchMonthNameShr_dimdate_month = new ColumnSchema("FrenchMonthName");
		shr_dimdate_month.getColumns().add(frenchMonthNameShr_dimdate_month);
		ColumnSchema monthNumberOfYearShr_dimdate_month = new ColumnSchema("MonthNumberOfYear");
		shr_dimdate_month.getColumns().add(monthNumberOfYearShr_dimdate_month);
		ColumnSchema calendarQuarterShr_dimdate_month = new ColumnSchema("CalendarQuarter");
		shr_dimdate_month.getColumns().add(calendarQuarterShr_dimdate_month);
		ColumnSchema calendarYearShr_dimdate_month = new ColumnSchema("CalendarYear");
		shr_dimdate_month.getColumns().add(calendarYearShr_dimdate_month);
		ColumnSchema calendarSemesterShr_dimdate_month = new ColumnSchema("CalendarSemester");
		shr_dimdate_month.getColumns().add(calendarSemesterShr_dimdate_month);
		ColumnSchema fiscalQuarterShr_dimdate_month = new ColumnSchema("FiscalQuarter");
		shr_dimdate_month.getColumns().add(fiscalQuarterShr_dimdate_month);
		ColumnSchema fiscalYearShr_dimdate_month = new ColumnSchema("FiscalYear");
		shr_dimdate_month.getColumns().add(fiscalYearShr_dimdate_month);
		ColumnSchema fiscalSemesterShr_dimdate_month = new ColumnSchema("FiscalSemester");
		shr_dimdate_month.getColumns().add(fiscalSemesterShr_dimdate_month);
		/* END Table: shr_dimdate_month */

		/* START Table: shr_dimdate_quarter */
		TableSchema shr_dimdate_quarter = new TableSchema();
		shr_dimdate_quarter.setTableName("shr_dimdate_quarter");
		shr_dimdate_quarter.setTableType(TableType.ShrunkenDimensionTable);
		shr_dimdate_quarter.setHierarchyLevel(HierarchyLevel.Quarter);

		ColumnSchema quarterKeyShr_dimdate_quarter = new ColumnSchema("QuarterKey");
		shr_dimdate_quarter.getColumns().add(quarterKeyShr_dimdate_quarter);
		ColumnSchema calendarQuarterShr_dimdate_quarter = new ColumnSchema("CalendarQuarter");
		shr_dimdate_quarter.getColumns().add(calendarQuarterShr_dimdate_quarter);
		ColumnSchema calendarYearShr_dimdate_quarter = new ColumnSchema("CalendarYear");
		shr_dimdate_quarter.getColumns().add(calendarYearShr_dimdate_quarter);
		ColumnSchema calendarSemesterShr_dimdate_quarter = new ColumnSchema("CalendarSemester");
		shr_dimdate_quarter.getColumns().add(calendarSemesterShr_dimdate_quarter);
		ColumnSchema fiscalQuarterShr_dimdate_quarter = new ColumnSchema("FiscalQuarter");
		shr_dimdate_quarter.getColumns().add(fiscalQuarterShr_dimdate_quarter);
		ColumnSchema fiscalYearShr_dimdate_quarter = new ColumnSchema("FiscalYear");
		shr_dimdate_quarter.getColumns().add(fiscalYearShr_dimdate_quarter);
		ColumnSchema fiscalSemesterShr_dimdate_quarter = new ColumnSchema("FiscalSemester");
		shr_dimdate_quarter.getColumns().add(fiscalSemesterShr_dimdate_quarter);
		/* END Table: shr_dimdate_quarter */

		/* START Table: shr_dimdate_semester */
		TableSchema shr_dimdate_semester = new TableSchema();
		shr_dimdate_semester.setTableName("shr_dimdate_semester");
		shr_dimdate_semester.setTableType(TableType.ShrunkenDimensionTable);
		shr_dimdate_semester.setHierarchyLevel(HierarchyLevel.Semester);

		ColumnSchema semesterKeyShr_dimdate_semester = new ColumnSchema("SemesterKey");
		shr_dimdate_semester.getColumns().add(semesterKeyShr_dimdate_semester);
		ColumnSchema calendarYearShr_dimdate_semester = new ColumnSchema("CalendarYear");
		shr_dimdate_semester.getColumns().add(calendarYearShr_dimdate_semester);
		ColumnSchema calendarSemesterShr_dimdate_semester = new ColumnSchema("CalendarSemester");
		shr_dimdate_semester.getColumns().add(calendarSemesterShr_dimdate_semester);
		ColumnSchema fiscalYearShr_dimdate_semester = new ColumnSchema("FiscalYear");
		shr_dimdate_semester.getColumns().add(fiscalYearShr_dimdate_semester);
		ColumnSchema fiscalSemesterShr_dimdate_semester = new ColumnSchema("FiscalSemester");
		shr_dimdate_semester.getColumns().add(fiscalSemesterShr_dimdate_semester);
		/* END Table: shr_dimdate_semester */

		/* START Table: shr_dimdate_week */
		TableSchema shr_dimdate_week = new TableSchema();
		shr_dimdate_week.setTableName("shr_dimdate_week");
		shr_dimdate_week.setTableType(TableType.ShrunkenDimensionTable);
		shr_dimdate_week.setHierarchyLevel(HierarchyLevel.Week);

		ColumnSchema weekKeyShr_dimdate_week = new ColumnSchema("WeekKey");
		shr_dimdate_week.getColumns().add(weekKeyShr_dimdate_week);
		ColumnSchema weekNumberOfYearShr_dimdate_week = new ColumnSchema("WeekNumberOfYear");
		shr_dimdate_week.getColumns().add(weekNumberOfYearShr_dimdate_week);
		ColumnSchema englishMonthNameShr_dimdate_week = new ColumnSchema("EnglishMonthName");
		shr_dimdate_week.getColumns().add(englishMonthNameShr_dimdate_week);
		ColumnSchema spanishMonthNameShr_dimdate_week = new ColumnSchema("SpanishMonthName");
		shr_dimdate_week.getColumns().add(spanishMonthNameShr_dimdate_week);
		ColumnSchema frenchMonthNameShr_dimdate_week = new ColumnSchema("FrenchMonthName");
		shr_dimdate_week.getColumns().add(frenchMonthNameShr_dimdate_week);
		ColumnSchema monthNumberOfYearShr_dimdate_week = new ColumnSchema("MonthNumberOfYear");
		shr_dimdate_week.getColumns().add(monthNumberOfYearShr_dimdate_week);
		ColumnSchema calendarQuarterShr_dimdate_week = new ColumnSchema("CalendarQuarter");
		shr_dimdate_week.getColumns().add(calendarQuarterShr_dimdate_week);
		ColumnSchema calendarYearShr_dimdate_week = new ColumnSchema("CalendarYear");
		shr_dimdate_week.getColumns().add(calendarYearShr_dimdate_week);
		ColumnSchema calendarSemesterShr_dimdate_week = new ColumnSchema("CalendarSemester");
		shr_dimdate_week.getColumns().add(calendarSemesterShr_dimdate_week);
		ColumnSchema fiscalQuarterShr_dimdate_week = new ColumnSchema("FiscalQuarter");
		shr_dimdate_week.getColumns().add(fiscalQuarterShr_dimdate_week);
		ColumnSchema fiscalYearShr_dimdate_week = new ColumnSchema("FiscalYear");
		shr_dimdate_week.getColumns().add(fiscalYearShr_dimdate_week);
		ColumnSchema fiscalSemesterShr_dimdate_week = new ColumnSchema("FiscalSemester");
		shr_dimdate_week.getColumns().add(fiscalSemesterShr_dimdate_week);
		/* END Table: shr_dimdate_week */

		/* START Table: shr_dimdate_year */
		TableSchema shr_dimdate_year = new TableSchema();
		shr_dimdate_year.setTableName("shr_dimdate_year");
		shr_dimdate_year.setTableType(TableType.ShrunkenDimensionTable);
		shr_dimdate_year.setHierarchyLevel(HierarchyLevel.Year);

		ColumnSchema yearKeyShr_dimdate_year = new ColumnSchema("YearKey");
		shr_dimdate_year.getColumns().add(yearKeyShr_dimdate_year);
		ColumnSchema calendarYearShr_dimdate_year = new ColumnSchema("CalendarYear");
		shr_dimdate_year.getColumns().add(calendarYearShr_dimdate_year);
		ColumnSchema fiscalYearShr_dimdate_year = new ColumnSchema("FiscalYear");
		shr_dimdate_year.getColumns().add(fiscalYearShr_dimdate_year);
		/* END Table: shr_dimdate_year */

		/* START Table: shr_dimsalesterritory_country */
		TableSchema shr_dimsalesterritory_country = new TableSchema();
		shr_dimsalesterritory_country.setTableName("shr_dimsalesterritory_country");
		shr_dimsalesterritory_country.setTableType(TableType.ShrunkenDimensionTable);
		shr_dimsalesterritory_country.setHierarchyLevel(HierarchyLevel.Country);

		ColumnSchema salesTerritoryCountryKeyShr_dimsalesterritory_country = new ColumnSchema("SalesTerritoryCountryKey");
		shr_dimsalesterritory_country.getColumns().add(salesTerritoryCountryKeyShr_dimsalesterritory_country);
		ColumnSchema salesTerritoryCountryShr_dimsalesterritory_country = new ColumnSchema("SalesTerritoryCountry");
		shr_dimsalesterritory_country.getColumns().add(salesTerritoryCountryShr_dimsalesterritory_country);
		ColumnSchema salesTerritoryGroupShr_dimsalesterritory_country = new ColumnSchema("SalesTerritoryGroup");
		shr_dimsalesterritory_country.getColumns().add(salesTerritoryGroupShr_dimsalesterritory_country);
		ColumnSchema salesTerritoryImageShr_dimsalesterritory_country = new ColumnSchema("SalesTerritoryImage");
		shr_dimsalesterritory_country.getColumns().add(salesTerritoryImageShr_dimsalesterritory_country);
		/* END Table: shr_dimsalesterritory_country */

		/* START Table: shr_dimsalesterritory_group */
		TableSchema shr_dimsalesterritory_group = new TableSchema();
		shr_dimsalesterritory_group.setTableName("shr_dimsalesterritory_group");
		shr_dimsalesterritory_group.setTableType(TableType.ShrunkenDimensionTable);
		shr_dimsalesterritory_group.setHierarchyLevel(HierarchyLevel.Group);

		ColumnSchema salesTerritoryGroupKeyShr_dimsalesterritory_group = new ColumnSchema("SalesTerritoryGroupKey");
		shr_dimsalesterritory_group.getColumns().add(salesTerritoryGroupKeyShr_dimsalesterritory_group);
		ColumnSchema salesTerritoryGroupShr_dimsalesterritory_group = new ColumnSchema("SalesTerritoryGroup");
		shr_dimsalesterritory_group.getColumns().add(salesTerritoryGroupShr_dimsalesterritory_group);
		ColumnSchema salesTerritoryImageShr_dimsalesterritory_group = new ColumnSchema("SalesTerritoryImage");
		shr_dimsalesterritory_group.getColumns().add(salesTerritoryImageShr_dimsalesterritory_group);
		/* END Table: shr_dimsalesterritory_group */


		/* START Adding Primary keys to tables */

		agg1_salesamount_city.getPrimaryKeys().add(cityKeyAgg1_salesamount_city);
		agg1_salesamount_city.getPrimaryKeys().add(orderDateKeyAgg1_salesamount_city);
		agg1_salesamount_city.getPrimaryKeys().add(productKeyAgg1_salesamount_city);
		agg1_salesamount_city.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_city);
		agg1_salesamount_country.getPrimaryKeys().add(countryKeyAgg1_salesamount_country);
		agg1_salesamount_country.getPrimaryKeys().add(orderDateKeyAgg1_salesamount_country);
		agg1_salesamount_country.getPrimaryKeys().add(productKeyAgg1_salesamount_country);
		agg1_salesamount_country.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_country);
		agg1_salesamount_day.getPrimaryKeys().add(customerKeyAgg1_salesamount_day);
		agg1_salesamount_day.getPrimaryKeys().add(orderDateKeyAgg1_salesamount_day);
		agg1_salesamount_day.getPrimaryKeys().add(productKeyAgg1_salesamount_day);
		agg1_salesamount_day.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_day);
		agg1_salesamount_month.getPrimaryKeys().add(customerKeyAgg1_salesamount_month);
		agg1_salesamount_month.getPrimaryKeys().add(monthKeyAgg1_salesamount_month);
		agg1_salesamount_month.getPrimaryKeys().add(productKeyAgg1_salesamount_month);
		agg1_salesamount_month.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_month);
		agg1_salesamount_postalcode.getPrimaryKeys().add(orderDateKeyAgg1_salesamount_postalcode);
		agg1_salesamount_postalcode.getPrimaryKeys().add(postalCodeKeyAgg1_salesamount_postalcode);
		agg1_salesamount_postalcode.getPrimaryKeys().add(productKeyAgg1_salesamount_postalcode);
		agg1_salesamount_postalcode.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_postalcode);
		agg1_salesamount_product.getPrimaryKeys().add(customerKeyAgg1_salesamount_product);
		agg1_salesamount_product.getPrimaryKeys().add(orderDateKeyAgg1_salesamount_product);
		agg1_salesamount_product.getPrimaryKeys().add(productAgg1_salesamount_product);
		agg1_salesamount_product.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_product);
		agg1_salesamount_productcategory.getPrimaryKeys().add(customerKeyAgg1_salesamount_productcategory);
		agg1_salesamount_productcategory.getPrimaryKeys().add(orderDateKeyAgg1_salesamount_productcategory);
		agg1_salesamount_productcategory.getPrimaryKeys().add(productCategoryKeyAgg1_salesamount_productcategory);
		agg1_salesamount_productcategory.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_productcategory);
		agg1_salesamount_productsubcategory.getPrimaryKeys().add(customerKeyAgg1_salesamount_productsubcategory);
		agg1_salesamount_productsubcategory.getPrimaryKeys().add(orderDateKeyAgg1_salesamount_productsubcategory);
		agg1_salesamount_productsubcategory.getPrimaryKeys().add(productSubcategoryKeyAgg1_salesamount_productsubcategory);
		agg1_salesamount_productsubcategory.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_productsubcategory);
		agg1_salesamount_quarter.getPrimaryKeys().add(customerKeyAgg1_salesamount_quarter);
		agg1_salesamount_quarter.getPrimaryKeys().add(productKeyAgg1_salesamount_quarter);
		agg1_salesamount_quarter.getPrimaryKeys().add(quarterKeyAgg1_salesamount_quarter);
		agg1_salesamount_quarter.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_quarter);
		agg1_salesamount_salesterritory.getPrimaryKeys().add(customerKeyAgg1_salesamount_salesterritory);
		agg1_salesamount_salesterritory.getPrimaryKeys().add(orderDateKeyAgg1_salesamount_salesterritory);
		agg1_salesamount_salesterritory.getPrimaryKeys().add(productKeyAgg1_salesamount_salesterritory);
		agg1_salesamount_salesterritory.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_salesterritory);
		agg1_salesamount_salesterritory_country.getPrimaryKeys().add(customerKeyAgg1_salesamount_salesterritory_country);
		agg1_salesamount_salesterritory_country.getPrimaryKeys().add(orderDateKeyAgg1_salesamount_salesterritory_country);
		agg1_salesamount_salesterritory_country.getPrimaryKeys().add(productKeyAgg1_salesamount_salesterritory_country);
		agg1_salesamount_salesterritory_country.getPrimaryKeys().add(salesTerritorycountryKeyAgg1_salesamount_salesterritory_country);
		agg1_salesamount_salesterritory_group.getPrimaryKeys().add(customerKeyAgg1_salesamount_salesterritory_group);
		agg1_salesamount_salesterritory_group.getPrimaryKeys().add(orderDateKeyAgg1_salesamount_salesterritory_group);
		agg1_salesamount_salesterritory_group.getPrimaryKeys().add(productKeyAgg1_salesamount_salesterritory_group);
		agg1_salesamount_salesterritory_group.getPrimaryKeys().add(salesTerritorygroupKeyAgg1_salesamount_salesterritory_group);
		agg1_salesamount_semester.getPrimaryKeys().add(customerKeyAgg1_salesamount_semester);
		agg1_salesamount_semester.getPrimaryKeys().add(productKeyAgg1_salesamount_semester);
		agg1_salesamount_semester.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_semester);
		agg1_salesamount_semester.getPrimaryKeys().add(semesterKeyAgg1_salesamount_semester);
		agg1_salesamount_state.getPrimaryKeys().add(orderDateKeyAgg1_salesamount_state);
		agg1_salesamount_state.getPrimaryKeys().add(productKeyAgg1_salesamount_state);
		agg1_salesamount_state.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_state);
		agg1_salesamount_state.getPrimaryKeys().add(stateKeyAgg1_salesamount_state);
		agg1_salesamount_week.getPrimaryKeys().add(customerKeyAgg1_salesamount_week);
		agg1_salesamount_week.getPrimaryKeys().add(productKeyAgg1_salesamount_week);
		agg1_salesamount_week.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_week);
		agg1_salesamount_week.getPrimaryKeys().add(weekKeyAgg1_salesamount_week);
		agg1_salesamount_year.getPrimaryKeys().add(customerKeyAgg1_salesamount_year);
		agg1_salesamount_year.getPrimaryKeys().add(productKeyAgg1_salesamount_year);
		agg1_salesamount_year.getPrimaryKeys().add(salesTerritoryKeyAgg1_salesamount_year);
		agg1_salesamount_year.getPrimaryKeys().add(yearKeyAgg1_salesamount_year);
		agg2_salesamount_day_city.getPrimaryKeys().add(cityKeyAgg2_salesamount_day_city);
		agg2_salesamount_day_city.getPrimaryKeys().add(orderDateKeyAgg2_salesamount_day_city);
		agg2_salesamount_day_city.getPrimaryKeys().add(productKeyAgg2_salesamount_day_city);
		agg2_salesamount_day_city.getPrimaryKeys().add(salesTerritoryKeyAgg2_salesamount_day_city);
		agg2_salesamount_month_city.getPrimaryKeys().add(cityKeyAgg2_salesamount_month_city);
		agg2_salesamount_month_city.getPrimaryKeys().add(monthKeyAgg2_salesamount_month_city);
		agg2_salesamount_month_city.getPrimaryKeys().add(productKeyAgg2_salesamount_month_city);
		agg2_salesamount_month_city.getPrimaryKeys().add(salesTerritoryKeyAgg2_salesamount_month_city);
		agg2_salesamount_month_country.getPrimaryKeys().add(countryKeyAgg2_salesamount_month_country);
		agg2_salesamount_month_country.getPrimaryKeys().add(monthKeyAgg2_salesamount_month_country);
		agg2_salesamount_month_country.getPrimaryKeys().add(productKeyAgg2_salesamount_month_country);
		agg2_salesamount_month_country.getPrimaryKeys().add(salesTerritoryKeyAgg2_salesamount_month_country);
		agg2_salesamount_month_state.getPrimaryKeys().add(monthKeyAgg2_salesamount_month_state);
		agg2_salesamount_month_state.getPrimaryKeys().add(productKeyAgg2_salesamount_month_state);
		agg2_salesamount_month_state.getPrimaryKeys().add(salesTerritoryKeyAgg2_salesamount_month_state);
		agg2_salesamount_month_state.getPrimaryKeys().add(stateKeyAgg2_salesamount_month_state);
		agg2_salesamount_quarter_country.getPrimaryKeys().add(countryKeyAgg2_salesamount_quarter_country);
		agg2_salesamount_quarter_country.getPrimaryKeys().add(productKeyAgg2_salesamount_quarter_country);
		agg2_salesamount_quarter_country.getPrimaryKeys().add(quarterKeyAgg2_salesamount_quarter_country);
		agg2_salesamount_quarter_country.getPrimaryKeys().add(salesTerritoryKeyAgg2_salesamount_quarter_country);
		agg2_salesamount_year_city.getPrimaryKeys().add(cityKeyAgg2_salesamount_year_city);
		agg2_salesamount_year_city.getPrimaryKeys().add(productKeyAgg2_salesamount_year_city);
		agg2_salesamount_year_city.getPrimaryKeys().add(salesTerritoryKeyAgg2_salesamount_year_city);
		agg2_salesamount_year_city.getPrimaryKeys().add(yearKeyAgg2_salesamount_year_city);
		agg2_salesamount_year_country.getPrimaryKeys().add(countryKeyAgg2_salesamount_year_country);
		agg2_salesamount_year_country.getPrimaryKeys().add(productKeyAgg2_salesamount_year_country);
		agg2_salesamount_year_country.getPrimaryKeys().add(salesTerritoryKeyAgg2_salesamount_year_country);
		agg2_salesamount_year_country.getPrimaryKeys().add(yearKeyAgg2_salesamount_year_country);
		dim_currency.getPrimaryKeys().add(currencyKeyDim_currency);
		dim_customer.getPrimaryKeys().add(customerKeyDim_customer);
		dim_date.getPrimaryKeys().add(dateKeyDim_date);
		dim_product.getPrimaryKeys().add(productKeyDim_product);
		dim_product.getPrimaryKeys().add(productSubcategoryKeyDim_product);
		dim_productcategory.getPrimaryKeys().add(productCategoryKeyDim_productcategory);
		dim_productsubcategory.getPrimaryKeys().add(productCategoryKeyDim_productsubcategory);
		dim_productsubcategory.getPrimaryKeys().add(productSubcategoryKeyDim_productsubcategory);
		dim_promotion.getPrimaryKeys().add(promotionKeyDim_promotion);
		dim_salesterritory.getPrimaryKeys().add(salesTerritoryKeyDim_salesterritory);
		fact_internetsales.getPrimaryKeys().add(currencyKeyFact_internetsales);
		fact_internetsales.getPrimaryKeys().add(customerKeyFact_internetsales);
		fact_internetsales.getPrimaryKeys().add(dueDateKeyFact_internetsales);
		fact_internetsales.getPrimaryKeys().add(orderDateKeyFact_internetsales);
		fact_internetsales.getPrimaryKeys().add(productKeyFact_internetsales);
		fact_internetsales.getPrimaryKeys().add(promotionKeyFact_internetsales);
		fact_internetsales.getPrimaryKeys().add(salesOrderLineNumberFact_internetsales);
		fact_internetsales.getPrimaryKeys().add(salesOrderNumberFact_internetsales);
		fact_internetsales.getPrimaryKeys().add(salesTerritoryKeyFact_internetsales);
		fact_internetsales.getPrimaryKeys().add(shipDateKeyFact_internetsales);
		shr_dimcustomer_city.getPrimaryKeys().add(cityKeyShr_dimcustomer_city);
		shr_dimcustomer_country.getPrimaryKeys().add(countryKeyShr_dimcustomer_country);
		shr_dimcustomer_postalcode.getPrimaryKeys().add(postalCodeKeyShr_dimcustomer_postalcode);
		shr_dimcustomer_state.getPrimaryKeys().add(stateKeyShr_dimcustomer_state);
		shr_dimdate_month.getPrimaryKeys().add(monthKeyShr_dimdate_month);
		shr_dimdate_quarter.getPrimaryKeys().add(quarterKeyShr_dimdate_quarter);
		shr_dimdate_semester.getPrimaryKeys().add(semesterKeyShr_dimdate_semester);
		shr_dimdate_week.getPrimaryKeys().add(weekKeyShr_dimdate_week);
		shr_dimdate_year.getPrimaryKeys().add(yearKeyShr_dimdate_year);
		shr_dimsalesterritory_country.getPrimaryKeys().add(salesTerritoryCountryKeyShr_dimsalesterritory_country);
		shr_dimsalesterritory_group.getPrimaryKeys().add(salesTerritoryGroupKeyShr_dimsalesterritory_group);

		/* END Adding Primary keys to tables */
		
		/* START Adding FK keys to tables */

		HashMap<TableSchema, ColumnSchema> inShr_dimcustomer_cityCityKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inDim_dateDateKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inDim_productProductKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inDim_salesterritorySalesTerritoryKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inShr_dimcustomer_countryCountryKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inDim_customerCustomerKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inShr_dimdate_monthMonthKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inShr_dimcustomer_postalcodePostalCodeKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inDim_productcategoryProductCategoryKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inDim_productsubcategoryProductSubcategoryKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inShr_dimdate_quarterQuarterKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inShr_dimsalesterritory_countrySalesTerritoryCountryKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inShr_dimsalesterritory_groupSalesTerritoryGroupKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inShr_dimdate_semesterSemesterKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inShr_dimcustomer_stateStateKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inShr_dimdate_weekWeekKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inShr_dimdate_yearYearKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inDim_currencyCurrencyKey = new HashMap<TableSchema, ColumnSchema>();
		HashMap<TableSchema, ColumnSchema> inDim_promotionPromotionKey = new HashMap<TableSchema, ColumnSchema>();

		inShr_dimcustomer_cityCityKey.put(shr_dimcustomer_city, cityKeyShr_dimcustomer_city);
		inDim_dateDateKey.put(dim_date, dateKeyDim_date);
		inDim_productProductKey.put(dim_product, productKeyDim_product);
		inDim_salesterritorySalesTerritoryKey.put(dim_salesterritory, salesTerritoryKeyDim_salesterritory);
		inShr_dimcustomer_countryCountryKey.put(shr_dimcustomer_country, countryKeyShr_dimcustomer_country);
		inDim_customerCustomerKey.put(dim_customer, customerKeyDim_customer);
		inShr_dimdate_monthMonthKey.put(shr_dimdate_month, monthKeyShr_dimdate_month);
		inShr_dimcustomer_postalcodePostalCodeKey.put(shr_dimcustomer_postalcode, postalCodeKeyShr_dimcustomer_postalcode);
		inDim_productcategoryProductCategoryKey.put(dim_productcategory, productCategoryKeyDim_productcategory);
		inDim_productsubcategoryProductSubcategoryKey.put(dim_productsubcategory, productSubcategoryKeyDim_productsubcategory);
		inShr_dimdate_quarterQuarterKey.put(shr_dimdate_quarter, quarterKeyShr_dimdate_quarter);
		inShr_dimsalesterritory_countrySalesTerritoryCountryKey.put(shr_dimsalesterritory_country, salesTerritoryCountryKeyShr_dimsalesterritory_country);
		inShr_dimsalesterritory_groupSalesTerritoryGroupKey.put(shr_dimsalesterritory_group, salesTerritoryGroupKeyShr_dimsalesterritory_group);
		inShr_dimdate_semesterSemesterKey.put(shr_dimdate_semester, semesterKeyShr_dimdate_semester);
		inShr_dimcustomer_stateStateKey.put(shr_dimcustomer_state, stateKeyShr_dimcustomer_state);
		inShr_dimdate_weekWeekKey.put(shr_dimdate_week, weekKeyShr_dimdate_week);
		inShr_dimdate_yearYearKey.put(shr_dimdate_year, yearKeyShr_dimdate_year);
		inDim_currencyCurrencyKey.put(dim_currency, currencyKeyDim_currency);
		inDim_promotionPromotionKey.put(dim_promotion, promotionKeyDim_promotion);

		agg1_salesamount_city.getForeignKeyToForeignTable().put(cityKeyAgg1_salesamount_city, inShr_dimcustomer_cityCityKey);
		agg1_salesamount_city.getForeignKeyToForeignTable().put(orderDateKeyAgg1_salesamount_city, inDim_dateDateKey);
		agg1_salesamount_city.getForeignKeyToForeignTable().put(productKeyAgg1_salesamount_city, inDim_productProductKey);
		agg1_salesamount_city.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_city, inDim_salesterritorySalesTerritoryKey);
		agg1_salesamount_country.getForeignKeyToForeignTable().put(countryKeyAgg1_salesamount_country, inShr_dimcustomer_countryCountryKey);
		agg1_salesamount_country.getForeignKeyToForeignTable().put(orderDateKeyAgg1_salesamount_country, inDim_dateDateKey);
		agg1_salesamount_country.getForeignKeyToForeignTable().put(productKeyAgg1_salesamount_country, inDim_productProductKey);
		agg1_salesamount_country.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_country, inDim_salesterritorySalesTerritoryKey);
		agg1_salesamount_day.getForeignKeyToForeignTable().put(orderDateKeyAgg1_salesamount_day, inDim_dateDateKey);
		agg1_salesamount_day.getForeignKeyToForeignTable().put(customerKeyAgg1_salesamount_day, inDim_customerCustomerKey);
		agg1_salesamount_day.getForeignKeyToForeignTable().put(productKeyAgg1_salesamount_day, inDim_productProductKey);
		agg1_salesamount_day.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_day, inDim_salesterritorySalesTerritoryKey);
		agg1_salesamount_month.getForeignKeyToForeignTable().put(monthKeyAgg1_salesamount_month, inShr_dimdate_monthMonthKey);
		agg1_salesamount_month.getForeignKeyToForeignTable().put(customerKeyAgg1_salesamount_month, inDim_customerCustomerKey);
		agg1_salesamount_month.getForeignKeyToForeignTable().put(productKeyAgg1_salesamount_month, inDim_productProductKey);
		agg1_salesamount_month.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_month, inDim_salesterritorySalesTerritoryKey);
		agg1_salesamount_postalcode.getForeignKeyToForeignTable().put(postalCodeKeyAgg1_salesamount_postalcode, inShr_dimcustomer_postalcodePostalCodeKey);
		agg1_salesamount_postalcode.getForeignKeyToForeignTable().put(orderDateKeyAgg1_salesamount_postalcode, inDim_dateDateKey);
		agg1_salesamount_postalcode.getForeignKeyToForeignTable().put(productKeyAgg1_salesamount_postalcode, inDim_productProductKey);
		agg1_salesamount_postalcode.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_postalcode, inDim_salesterritorySalesTerritoryKey);
		agg1_salesamount_product.getForeignKeyToForeignTable().put(productAgg1_salesamount_product, inDim_productProductKey);
		agg1_salesamount_product.getForeignKeyToForeignTable().put(orderDateKeyAgg1_salesamount_product, inDim_dateDateKey);
		agg1_salesamount_product.getForeignKeyToForeignTable().put(customerKeyAgg1_salesamount_product, inDim_customerCustomerKey);
		agg1_salesamount_product.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_product, inDim_salesterritorySalesTerritoryKey);
		agg1_salesamount_productcategory.getForeignKeyToForeignTable().put(productCategoryKeyAgg1_salesamount_productcategory, inDim_productcategoryProductCategoryKey);
		agg1_salesamount_productcategory.getForeignKeyToForeignTable().put(orderDateKeyAgg1_salesamount_productcategory, inDim_dateDateKey);
		agg1_salesamount_productcategory.getForeignKeyToForeignTable().put(customerKeyAgg1_salesamount_productcategory, inDim_customerCustomerKey);
		agg1_salesamount_productcategory.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_productcategory, inDim_salesterritorySalesTerritoryKey);
		agg1_salesamount_productsubcategory.getForeignKeyToForeignTable().put(productSubcategoryKeyAgg1_salesamount_productsubcategory, inDim_productsubcategoryProductSubcategoryKey);
		agg1_salesamount_productsubcategory.getForeignKeyToForeignTable().put(orderDateKeyAgg1_salesamount_productsubcategory, inDim_dateDateKey);
		agg1_salesamount_productsubcategory.getForeignKeyToForeignTable().put(customerKeyAgg1_salesamount_productsubcategory, inDim_customerCustomerKey);
		agg1_salesamount_productsubcategory.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_productsubcategory, inDim_salesterritorySalesTerritoryKey);
		agg1_salesamount_quarter.getForeignKeyToForeignTable().put(quarterKeyAgg1_salesamount_quarter, inShr_dimdate_quarterQuarterKey);
		agg1_salesamount_quarter.getForeignKeyToForeignTable().put(customerKeyAgg1_salesamount_quarter, inDim_customerCustomerKey);
		agg1_salesamount_quarter.getForeignKeyToForeignTable().put(productKeyAgg1_salesamount_quarter, inDim_productProductKey);
		agg1_salesamount_quarter.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_quarter, inDim_salesterritorySalesTerritoryKey);
		agg1_salesamount_salesterritory_country.getForeignKeyToForeignTable().put(orderDateKeyAgg1_salesamount_salesterritory_country, inDim_dateDateKey);
		agg1_salesamount_salesterritory_country.getForeignKeyToForeignTable().put(customerKeyAgg1_salesamount_salesterritory_country, inDim_customerCustomerKey);
		agg1_salesamount_salesterritory_country.getForeignKeyToForeignTable().put(productKeyAgg1_salesamount_salesterritory_country, inDim_productProductKey);
		agg1_salesamount_salesterritory_country.getForeignKeyToForeignTable().put(salesTerritorycountryKeyAgg1_salesamount_salesterritory_country, inShr_dimsalesterritory_countrySalesTerritoryCountryKey);
		agg1_salesamount_salesterritory_group.getForeignKeyToForeignTable().put(orderDateKeyAgg1_salesamount_salesterritory_group, inDim_dateDateKey);
		agg1_salesamount_salesterritory_group.getForeignKeyToForeignTable().put(customerKeyAgg1_salesamount_salesterritory_group, inDim_customerCustomerKey);
		agg1_salesamount_salesterritory_group.getForeignKeyToForeignTable().put(productKeyAgg1_salesamount_salesterritory_group, inDim_productProductKey);
		agg1_salesamount_salesterritory_group.getForeignKeyToForeignTable().put(salesTerritorygroupKeyAgg1_salesamount_salesterritory_group, inShr_dimsalesterritory_groupSalesTerritoryGroupKey);
		agg1_salesamount_salesterritory.getForeignKeyToForeignTable().put(orderDateKeyAgg1_salesamount_salesterritory, inDim_dateDateKey);
		agg1_salesamount_salesterritory.getForeignKeyToForeignTable().put(customerKeyAgg1_salesamount_salesterritory, inDim_customerCustomerKey);
		agg1_salesamount_salesterritory.getForeignKeyToForeignTable().put(productKeyAgg1_salesamount_salesterritory, inDim_productProductKey);
		agg1_salesamount_salesterritory.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_salesterritory, inDim_salesterritorySalesTerritoryKey);
		agg1_salesamount_semester.getForeignKeyToForeignTable().put(semesterKeyAgg1_salesamount_semester, inShr_dimdate_semesterSemesterKey);
		agg1_salesamount_semester.getForeignKeyToForeignTable().put(customerKeyAgg1_salesamount_semester, inDim_customerCustomerKey);
		agg1_salesamount_semester.getForeignKeyToForeignTable().put(productKeyAgg1_salesamount_semester, inDim_productProductKey);
		agg1_salesamount_semester.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_semester, inDim_salesterritorySalesTerritoryKey);
		agg1_salesamount_state.getForeignKeyToForeignTable().put(stateKeyAgg1_salesamount_state, inShr_dimcustomer_stateStateKey);
		agg1_salesamount_state.getForeignKeyToForeignTable().put(orderDateKeyAgg1_salesamount_state, inDim_dateDateKey);
		agg1_salesamount_state.getForeignKeyToForeignTable().put(productKeyAgg1_salesamount_state, inDim_productProductKey);
		agg1_salesamount_state.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_state, inDim_salesterritorySalesTerritoryKey);
		agg1_salesamount_week.getForeignKeyToForeignTable().put(weekKeyAgg1_salesamount_week, inShr_dimdate_weekWeekKey);
		agg1_salesamount_week.getForeignKeyToForeignTable().put(customerKeyAgg1_salesamount_week, inDim_customerCustomerKey);
		agg1_salesamount_week.getForeignKeyToForeignTable().put(productKeyAgg1_salesamount_week, inDim_productProductKey);
		agg1_salesamount_week.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_week, inDim_salesterritorySalesTerritoryKey);
		agg1_salesamount_year.getForeignKeyToForeignTable().put(yearKeyAgg1_salesamount_year, inShr_dimdate_yearYearKey);
		agg1_salesamount_year.getForeignKeyToForeignTable().put(customerKeyAgg1_salesamount_year, inDim_customerCustomerKey);
		agg1_salesamount_year.getForeignKeyToForeignTable().put(productKeyAgg1_salesamount_year, inDim_productProductKey);
		agg1_salesamount_year.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg1_salesamount_year, inDim_salesterritorySalesTerritoryKey);
		agg2_salesamount_day_city.getForeignKeyToForeignTable().put(cityKeyAgg2_salesamount_day_city, inShr_dimcustomer_cityCityKey);
		agg2_salesamount_day_city.getForeignKeyToForeignTable().put(orderDateKeyAgg2_salesamount_day_city, inDim_dateDateKey);
		agg2_salesamount_day_city.getForeignKeyToForeignTable().put(productKeyAgg2_salesamount_day_city, inDim_productProductKey);
		agg2_salesamount_day_city.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg2_salesamount_day_city, inDim_salesterritorySalesTerritoryKey);
		agg2_salesamount_month_city.getForeignKeyToForeignTable().put(cityKeyAgg2_salesamount_month_city, inShr_dimcustomer_cityCityKey);
		agg2_salesamount_month_city.getForeignKeyToForeignTable().put(monthKeyAgg2_salesamount_month_city, inShr_dimdate_monthMonthKey);
		agg2_salesamount_month_city.getForeignKeyToForeignTable().put(productKeyAgg2_salesamount_month_city, inDim_productProductKey);
		agg2_salesamount_month_city.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg2_salesamount_month_city, inDim_salesterritorySalesTerritoryKey);
		agg2_salesamount_month_country.getForeignKeyToForeignTable().put(countryKeyAgg2_salesamount_month_country, inShr_dimcustomer_countryCountryKey);
		agg2_salesamount_month_country.getForeignKeyToForeignTable().put(monthKeyAgg2_salesamount_month_country, inShr_dimdate_monthMonthKey);
		agg2_salesamount_month_country.getForeignKeyToForeignTable().put(productKeyAgg2_salesamount_month_country, inDim_productProductKey);
		agg2_salesamount_month_country.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg2_salesamount_month_country, inDim_salesterritorySalesTerritoryKey);
		agg2_salesamount_month_state.getForeignKeyToForeignTable().put(stateKeyAgg2_salesamount_month_state, inShr_dimcustomer_stateStateKey);
		agg2_salesamount_month_state.getForeignKeyToForeignTable().put(monthKeyAgg2_salesamount_month_state, inShr_dimdate_monthMonthKey);
		agg2_salesamount_month_state.getForeignKeyToForeignTable().put(productKeyAgg2_salesamount_month_state, inDim_productProductKey);
		agg2_salesamount_month_state.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg2_salesamount_month_state, inDim_salesterritorySalesTerritoryKey);
		agg2_salesamount_quarter_country.getForeignKeyToForeignTable().put(countryKeyAgg2_salesamount_quarter_country, inShr_dimcustomer_countryCountryKey);
		agg2_salesamount_quarter_country.getForeignKeyToForeignTable().put(quarterKeyAgg2_salesamount_quarter_country, inShr_dimdate_quarterQuarterKey);
		agg2_salesamount_quarter_country.getForeignKeyToForeignTable().put(productKeyAgg2_salesamount_quarter_country, inDim_productProductKey);
		agg2_salesamount_quarter_country.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg2_salesamount_quarter_country, inDim_salesterritorySalesTerritoryKey);
		agg2_salesamount_year_city.getForeignKeyToForeignTable().put(cityKeyAgg2_salesamount_year_city, inShr_dimcustomer_cityCityKey);
		agg2_salesamount_year_city.getForeignKeyToForeignTable().put(yearKeyAgg2_salesamount_year_city, inShr_dimdate_yearYearKey);
		agg2_salesamount_year_city.getForeignKeyToForeignTable().put(productKeyAgg2_salesamount_year_city, inDim_productProductKey);
		agg2_salesamount_year_city.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg2_salesamount_year_city, inDim_salesterritorySalesTerritoryKey);
		agg2_salesamount_year_country.getForeignKeyToForeignTable().put(countryKeyAgg2_salesamount_year_country, inShr_dimcustomer_countryCountryKey);
		agg2_salesamount_year_country.getForeignKeyToForeignTable().put(yearKeyAgg2_salesamount_year_country, inShr_dimdate_yearYearKey);
		agg2_salesamount_year_country.getForeignKeyToForeignTable().put(productKeyAgg2_salesamount_year_country, inDim_productProductKey);
		agg2_salesamount_year_country.getForeignKeyToForeignTable().put(salesTerritoryKeyAgg2_salesamount_year_country, inDim_salesterritorySalesTerritoryKey);
		dim_product.getForeignKeyToForeignTable().put(productSubcategoryKeyDim_product, inDim_productsubcategoryProductSubcategoryKey);
		dim_productsubcategory.getForeignKeyToForeignTable().put(productCategoryKeyDim_productsubcategory, inDim_productcategoryProductCategoryKey);
		fact_internetsales.getForeignKeyToForeignTable().put(currencyKeyFact_internetsales, inDim_currencyCurrencyKey);
		fact_internetsales.getForeignKeyToForeignTable().put(customerKeyFact_internetsales, inDim_customerCustomerKey);
		fact_internetsales.getForeignKeyToForeignTable().put(orderDateKeyFact_internetsales, inDim_dateDateKey);
		fact_internetsales.getForeignKeyToForeignTable().put(dueDateKeyFact_internetsales, inDim_dateDateKey);
		fact_internetsales.getForeignKeyToForeignTable().put(shipDateKeyFact_internetsales, inDim_dateDateKey);
		fact_internetsales.getForeignKeyToForeignTable().put(productKeyFact_internetsales, inDim_productProductKey);
		fact_internetsales.getForeignKeyToForeignTable().put(promotionKeyFact_internetsales, inDim_promotionPromotionKey);
		fact_internetsales.getForeignKeyToForeignTable().put(salesTerritoryKeyFact_internetsales, inDim_salesterritorySalesTerritoryKey);

		/* END Adding FK keys to tables */
		
		/* START Adding Navigation keys from base fact to aggr fact tables */
		
		/* END Adding Navigation keys from base fact to aggr fact tables */

		// TODO: Add map from tableName to tableSchama
		//HashMap<String, TableSchema> tableNameToTableSchama = new HashMap<String, TableSchema>();

		tableNameToTableSchama.put("agg1_salesamount_city", agg1_salesamount_city);
		tableNameToTableSchama.put("agg1_salesamount_country", agg1_salesamount_country);
		tableNameToTableSchama.put("agg1_salesamount_day", agg1_salesamount_day);
		tableNameToTableSchama.put("agg1_salesamount_month", agg1_salesamount_month);
		tableNameToTableSchama.put("agg1_salesamount_postalcode", agg1_salesamount_postalcode);
		tableNameToTableSchama.put("agg1_salesamount_product", agg1_salesamount_product);
		tableNameToTableSchama.put("agg1_salesamount_productcategory", agg1_salesamount_productcategory);
		tableNameToTableSchama.put("agg1_salesamount_productsubcategory", agg1_salesamount_productsubcategory);
		tableNameToTableSchama.put("agg1_salesamount_quarter", agg1_salesamount_quarter);
		tableNameToTableSchama.put("agg1_salesamount_salesterritory", agg1_salesamount_salesterritory);
		tableNameToTableSchama.put("agg1_salesamount_salesterritory_country", agg1_salesamount_salesterritory_country);
		tableNameToTableSchama.put("agg1_salesamount_salesterritory_group", agg1_salesamount_salesterritory_group);
		tableNameToTableSchama.put("agg1_salesamount_semester", agg1_salesamount_semester);
		tableNameToTableSchama.put("agg1_salesamount_state", agg1_salesamount_state);
		tableNameToTableSchama.put("agg1_salesamount_week", agg1_salesamount_week);
		tableNameToTableSchama.put("agg1_salesamount_year", agg1_salesamount_year);
		tableNameToTableSchama.put("agg2_salesamount_day_city", agg2_salesamount_day_city);
		tableNameToTableSchama.put("agg2_salesamount_month_city", agg2_salesamount_month_city);
		tableNameToTableSchama.put("agg2_salesamount_month_country", agg2_salesamount_month_country);
		tableNameToTableSchama.put("agg2_salesamount_month_state", agg2_salesamount_month_state);
		tableNameToTableSchama.put("agg2_salesamount_quarter_country", agg2_salesamount_quarter_country);
		tableNameToTableSchama.put("agg2_salesamount_year_city", agg2_salesamount_year_city);
		tableNameToTableSchama.put("agg2_salesamount_year_country", agg2_salesamount_year_country);
		tableNameToTableSchama.put("dim_currency", dim_currency);
		tableNameToTableSchama.put("dim_customer", dim_customer);
		tableNameToTableSchama.put("dim_date", dim_date);
		tableNameToTableSchama.put("dim_product", dim_product);
		tableNameToTableSchama.put("dim_productcategory", dim_productcategory);
		tableNameToTableSchama.put("dim_productsubcategory", dim_productsubcategory);
		tableNameToTableSchama.put("dim_promotion", dim_promotion);
		tableNameToTableSchama.put("dim_salesterritory", dim_salesterritory);
		tableNameToTableSchama.put("fact_internetsales", fact_internetsales);
		tableNameToTableSchama.put("shr_dimcustomer_city", shr_dimcustomer_city);
		tableNameToTableSchama.put("shr_dimcustomer_country", shr_dimcustomer_country);
		tableNameToTableSchama.put("shr_dimcustomer_postalcode", shr_dimcustomer_postalcode);
		tableNameToTableSchama.put("shr_dimcustomer_state", shr_dimcustomer_state);
		tableNameToTableSchama.put("shr_dimdate_month", shr_dimdate_month);
		tableNameToTableSchama.put("shr_dimdate_quarter", shr_dimdate_quarter);
		tableNameToTableSchama.put("shr_dimdate_semester", shr_dimdate_semester);
		tableNameToTableSchama.put("shr_dimdate_week", shr_dimdate_week);
		tableNameToTableSchama.put("shr_dimdate_year", shr_dimdate_year);
		tableNameToTableSchama.put("shr_dimsalesterritory_country", shr_dimsalesterritory_country);
		tableNameToTableSchama.put("shr_dimsalesterritory_group", shr_dimsalesterritory_group);
		
		
		
		// TODO: No need to add explicit map from baseFactTableName to aggregatedFactTableName
		
		// TODO: List of base dimensions
		ArrayList<TableSchema> baseDimensions = new ArrayList<TableSchema>();
		
		baseDimensions.add(dim_customer);
		baseDimensions.add(dim_date);
		baseDimensions.add(dim_product);
		baseDimensions.add(dim_salesterritory);

		// TODO: List of base fact tables
		ArrayList<TableSchema> baseFacts = new ArrayList<TableSchema>();
		
		baseFacts.add(fact_internetsales);
		
		// TODO: List of shrunken dimensions
		ArrayList<TableSchema> shrunkenDimensions = new ArrayList<TableSchema>();
		
		shrunkenDimensions.add(shr_dimcustomer_city);
		shrunkenDimensions.add(shr_dimcustomer_country);
		shrunkenDimensions.add(shr_dimcustomer_postalcode);
		shrunkenDimensions.add(shr_dimcustomer_state);
		shrunkenDimensions.add(shr_dimdate_month);
		shrunkenDimensions.add(shr_dimdate_quarter);
		shrunkenDimensions.add(shr_dimdate_semester);
		shrunkenDimensions.add(shr_dimdate_week);
		shrunkenDimensions.add(shr_dimdate_year);
		shrunkenDimensions.add(shr_dimsalesterritory_country);
		shrunkenDimensions.add(shr_dimsalesterritory_group);
		shrunkenDimensions.add(dim_productcategory);
		shrunkenDimensions.add(dim_productsubcategory);

		// TODO: List of aggregated fact tables
		ArrayList<TableSchema> aggregatedFacts = new ArrayList<TableSchema>();

		aggregatedFacts.add(agg1_salesamount_city);
		aggregatedFacts.add(agg1_salesamount_country);
		aggregatedFacts.add(agg1_salesamount_day);
		aggregatedFacts.add(agg1_salesamount_month);
		aggregatedFacts.add(agg1_salesamount_postalcode);
		aggregatedFacts.add(agg1_salesamount_product);
		aggregatedFacts.add(agg1_salesamount_productcategory);
		aggregatedFacts.add(agg1_salesamount_productsubcategory);
		aggregatedFacts.add(agg1_salesamount_quarter);
		aggregatedFacts.add(agg1_salesamount_salesterritory);
		aggregatedFacts.add(agg1_salesamount_salesterritory_country);
		aggregatedFacts.add(agg1_salesamount_salesterritory_group);
		aggregatedFacts.add(agg1_salesamount_semester);
		aggregatedFacts.add(agg1_salesamount_state);
		aggregatedFacts.add(agg1_salesamount_week);
		aggregatedFacts.add(agg1_salesamount_year);
		aggregatedFacts.add(agg2_salesamount_day_city);
		aggregatedFacts.add(agg2_salesamount_month_city);
		aggregatedFacts.add(agg2_salesamount_month_country);
		aggregatedFacts.add(agg2_salesamount_month_state);
		aggregatedFacts.add(agg2_salesamount_quarter_country);
		aggregatedFacts.add(agg2_salesamount_year_city);
		aggregatedFacts.add(agg2_salesamount_year_country);

		// TODO: Add getNumberOfWays() in which an aggregated fact table is created
		
		// TODO: Add Map from aggregated fact table name to record count (table size)
		/*HashMap<String, Integer> aggregatedFactTableNameToSize = new HashMap<String, Integer>();

		aggregatedFactTableNameToSize.put("agg1_salesamount_city", DatabaseHandler.countRecords("agg1_salesamount_city"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_country", DatabaseHandler.countRecords("agg1_salesamount_country"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_day", DatabaseHandler.countRecords("agg1_salesamount_day"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_month", DatabaseHandler.countRecords("agg1_salesamount_month"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_postalcode", DatabaseHandler.countRecords("agg1_salesamount_postalcode"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_product", DatabaseHandler.countRecords("agg1_salesamount_product"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_productcategory", DatabaseHandler.countRecords("agg1_salesamount_productcategory"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_productsubcategory", DatabaseHandler.countRecords("agg1_salesamount_productsubcategory"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_quarter", DatabaseHandler.countRecords("agg1_salesamount_quarter"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_salesterritory", DatabaseHandler.countRecords("agg1_salesamount_salesterritory"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_salesterritory_country", DatabaseHandler.countRecords("agg1_salesamount_salesterritory_country"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_salesterritory_group", DatabaseHandler.countRecords("agg1_salesamount_salesterritory_group"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_semester", DatabaseHandler.countRecords("agg1_salesamount_semester"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_state", DatabaseHandler.countRecords("agg1_salesamount_state"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_week", DatabaseHandler.countRecords("agg1_salesamount_week"));
		aggregatedFactTableNameToSize.put("agg1_salesamount_year", DatabaseHandler.countRecords("agg1_salesamount_year"));
		aggregatedFactTableNameToSize.put("agg2_salesamount_day_city", DatabaseHandler.countRecords("agg2_salesamount_day_city"));
		aggregatedFactTableNameToSize.put("agg2_salesamount_month_city", DatabaseHandler.countRecords("agg2_salesamount_month_city"));
		aggregatedFactTableNameToSize.put("agg2_salesamount_month_country", DatabaseHandler.countRecords("agg2_salesamount_month_country"));
		aggregatedFactTableNameToSize.put("agg2_salesamount_month_state", DatabaseHandler.countRecords("agg2_salesamount_month_state"));
		aggregatedFactTableNameToSize.put("agg2_salesamount_quarter_country", DatabaseHandler.countRecords("agg2_salesamount_quarter_country"));
		aggregatedFactTableNameToSize.put("agg2_salesamount_year_city", DatabaseHandler.countRecords("agg2_salesamount_year_city"));
		aggregatedFactTableNameToSize.put("agg2_salesamount_year_country", DatabaseHandler.countRecords("agg2_salesamount_year_country"));*/
		//aggregatedFactTableNameToSize.put("fact_internetsales", DatabaseHandler.countRecords("fact_internetsales"));

		//ArrayList<String> orderedAggregates=new ArrayList<String>();
		orderedAggregates.add("agg2_salesamount_year_country");
		orderedAggregates.add("agg2_salesamount_quarter_country");
		orderedAggregates.add("agg2_salesamount_month_country");
		orderedAggregates.add("agg2_salesamount_month_state");
		orderedAggregates.add("agg2_salesamount_year_city");
		orderedAggregates.add("agg1_salesamount_productcategory");
		orderedAggregates.add("agg2_salesamount_month_city");
		orderedAggregates.add("agg1_salesamount_country");
		orderedAggregates.add("agg1_salesamount_productsubcategory");
		orderedAggregates.add("agg1_salesamount_state");
		orderedAggregates.add("agg1_salesamount_quarter");
		orderedAggregates.add("agg2_salesamount_day_city");
		orderedAggregates.add("agg1_salesamount_year");
		orderedAggregates.add("agg1_salesamount_semester");
		orderedAggregates.add("agg1_salesamount_month");
		orderedAggregates.add("agg1_salesamount_week");
		orderedAggregates.add("agg1_salesamount_product");
		orderedAggregates.add("agg1_salesamount_day");
		orderedAggregates.add("agg1_salesamount_salesterritory_group");
		orderedAggregates.add("agg1_salesamount_salesterritory_country");
		orderedAggregates.add("agg1_salesamount_salesterritory");
		orderedAggregates.add("agg1_salesamount_postalcode");
		orderedAggregates.add("agg1_salesamount_city");
	}

	
	
/*	public static void genearteTable(TableSchema table,String tableName, TableType tableType, String hierarchyLevel, String[] columns){
	
		
		table.setTableName(tableName);
		table.setTableType(tableType);
		table.setHierarchyLevel(hierarchyLevel);
		dimDate.getColumns().add(dateKey);
		
		ColumnSchema dateKey = new ColumnSchema("DateKey");
		System.out.println("TableSchema " + tableName + " = new TableSchema();");
		
	}
*/



}
