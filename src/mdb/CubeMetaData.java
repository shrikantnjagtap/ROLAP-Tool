package mdb;

import java.util.ArrayList;
import java.util.HashMap;


public class CubeMetaData {

	// Name of the fact represented by this cube
	// i.e., DollarSales, QuantitySales
	private String fact;

	// Dimension name to multidimensional array index
	private HashMap<String, ArrayList<String>> dimensionToValues;

	// Dimension name to current hierarchy level index
	// It determines the cube's current granularity level
	// i.e., Time -> Year, Location -> City, Product -> Brand
	private HashMap<String, String> dimensionToHierarchyLevel;

	// Names of the dimensions in this cube
	// It also maintains the order of dimensions in which fact value will be accessed
	// i.e., Cube(Time, Location, Product) -> Cube.get(2012, Rajkot, Apple)
	private ArrayList<String> dimensions;

	// Lengths of multidimensional array axes
	// i.e., (2, 3, 4)
	private int[] dimensionLengths;
	
	public CubeMetaData() {
		
		dimensionToValues = new HashMap<String, ArrayList<String>>();
		dimensionToHierarchyLevel = new HashMap<String, String>();
		dimensions = new ArrayList<String>();
		
	}

	// Getters & Setters
	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}

	public HashMap<String, ArrayList<String>> getDimensionToValues() {
		return dimensionToValues;
	}

	public void setDimensionToValues(
			HashMap<String, ArrayList<String>> dimensionToValues) {
		this.dimensionToValues = dimensionToValues;
	}

	public HashMap<String, String> getDimensionToHierarchyLevel() {
		return dimensionToHierarchyLevel;
	}

	public void setDimensionToHierarchyLevel(
			HashMap<String, String> dimensionToHierarchyLevel) {
		this.dimensionToHierarchyLevel = dimensionToHierarchyLevel;
	}

	public ArrayList<String> getDimensions() {
		return dimensions;
	}

	public void setDimensions(ArrayList<String> dimensions) {
		this.dimensions = dimensions;
	}

	public int[] getDimensionLengths() {
		return dimensionLengths;
	}

	public void setDimensionLengths(int[] dimensionLengths) {
		this.dimensionLengths = dimensionLengths;
	}
	
}
