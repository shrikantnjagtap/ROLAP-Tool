package mdb;

import Opus5.MultiDimensionalArray;

public class Cube {

	private CubeMetaData cubeMetaData;
	private MultiDimensionalArray array;	// Multidimensional array for storing hyper-cubic data

	public Cube() {
	}
	
	public Cube(String fact, int[] dimensionLengths) {

		array = new MultiDimensionalArray(dimensionLengths);
		cubeMetaData = new CubeMetaData();
		cubeMetaData.setFact(fact);
		cubeMetaData.setDimensionLengths(dimensionLengths);
	
	}

	// Set given fact at specified cell position of cube
	public void setFact(int[] indices, Object fact) {
		array.put(indices, fact);
	}
	

	// Getters & Setters
	public MultiDimensionalArray getArray() {
		return array;
	}

	public void setArray(MultiDimensionalArray array) {
		this.array = array;
	}

	public CubeMetaData getCubeMetaData() {
		return cubeMetaData;
	}

	public void setCubeMetaData(CubeMetaData cubeMetaData) {
		this.cubeMetaData = cubeMetaData;
	}


}
