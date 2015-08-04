/*
 *	Example: Sales Fact Cube
 *
 *	Dimensions = { Time, Location, Product }
 *
 *	Cube [2][3][4] = { { 2012, 2013 }, { Ahmedabad, Rajkot, Surat }, { Apple, Nokia, Samsung, Sony } }
 *
 *	Dimension Hierarchy (from highest level to lowest level):
 *
 *	(1) Time = { All Times -> Year -> Quarter -> Month -> Week -> Day -> Hour -> TimeId }
 *
 *	(2) Location = { All Locations -> Country -> Region -> State -> Zone -> District -> City -> LocationId }
 *
 *	(3) Product = { All Products -> Department -> Category -> SubCategory -> Brand -> Color -> ProductId }
 * 
*/

package mdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {

	public static Cube salesCube;

	public static void init() {

		// Create necessary directories
		Commons.createDirectory(Types.MDB_DIR);

		GlobalMetaData.dimensionToHierarchy = new HashMap<String, ArrayList<String>>();
		salesCube = new Cube("Sales", new int[] { 2, 3, 4 });

		// Time dimension hierarchy
		ArrayList<String> timeHierarchy = new ArrayList<String>();
		timeHierarchy.add("All");
		timeHierarchy.add("Year");
		timeHierarchy.add("Quarter");
		timeHierarchy.add("Month");
		timeHierarchy.add("Week");
		timeHierarchy.add("Day");
		timeHierarchy.add("Hour");
		timeHierarchy.add("TimeId");

		// Location dimension hierarchy
		ArrayList<String> locationHierarchy = new ArrayList<String>();
		locationHierarchy.add("All");
		locationHierarchy.add("Country");
		locationHierarchy.add("Region");
		locationHierarchy.add("State");
		locationHierarchy.add("Zone");
		locationHierarchy.add("District");
		locationHierarchy.add("City");
		locationHierarchy.add("LocationId");

		// Product dimension hierarchy
		ArrayList<String> productHierarchy = new ArrayList<String>();
		productHierarchy.add("All");
		productHierarchy.add("Department");
		productHierarchy.add("Category");
		productHierarchy.add("SubCategory");
		productHierarchy.add("Brand");
		productHierarchy.add("Color");
		productHierarchy.add("ProductId");

		GlobalMetaData.dimensionToHierarchy.put("Time", timeHierarchy);
		GlobalMetaData.dimensionToHierarchy.put("Location", locationHierarchy);
		GlobalMetaData.dimensionToHierarchy.put("Product", productHierarchy);
		
		ArrayList<String> timeValues = new ArrayList<String>();
		timeValues.add("2012");
		timeValues.add("2013");

		ArrayList<String> locationValues = new ArrayList<String>();
		locationValues.add("Ahmedabad");
		locationValues.add("Rajkot");
		locationValues.add("Surat");

		ArrayList<String> productValues = new ArrayList<String>();
		productValues.add("Apple");
		productValues.add("Nokia");
		productValues.add("Samsung");
		productValues.add("Sony");

		salesCube.getCubeMetaData().getDimensionToValues().put("Time", timeValues);
		salesCube.getCubeMetaData().getDimensionToValues().put("Location", locationValues);
		salesCube.getCubeMetaData().getDimensionToValues().put("Product", productValues);

		salesCube.getCubeMetaData().getDimensionToHierarchyLevel().put("Time", "Year");
		salesCube.getCubeMetaData().getDimensionToHierarchyLevel().put("Location", "City");
		salesCube.getCubeMetaData().getDimensionToHierarchyLevel().put("Product", "Brand");
		
		salesCube.getCubeMetaData().getDimensions().add("Time");
		salesCube.getCubeMetaData().getDimensions().add("Location");
		salesCube.getCubeMetaData().getDimensions().add("Product");
		
		// Fill some sample data into salesCube
		Random randomGenerator = new Random();
		for(int i=0; i<2; i++) {

			for(int j=0; j<3; j++) {

				for(int k=0; k<4; k++) {
					
					salesCube.getArray().put(new int[] { i, j, k }, randomGenerator.nextInt(1000));
					
				}

			}

		}
	
	}
	
	public static void main(String[] args) {

		init();
		System.out.println("MDB Initialized...");
		
		Utils.serializeMDB(salesCube);
		System.out.println("MDB Persisted...");

		// Sample dice operation
		HashMap<String, ArrayList<String>> criteria = new HashMap<String, ArrayList<String>>();

		ArrayList<String> productValues = new ArrayList<String>();
		productValues.add("Nokia");
		productValues.add("Sony");

		ArrayList<String> locationValues = new ArrayList<String>();
		locationValues.add("Ahmedabad");
		
		criteria.put("Product", productValues);
		criteria.put("Location", locationValues);
		
		Utils.dice(salesCube, criteria);
	
	}

}
