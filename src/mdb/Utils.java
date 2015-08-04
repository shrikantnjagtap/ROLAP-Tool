package mdb;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

public class Utils {

	// Load MDB from Star Schema RDB
	public static void loadMDB() {

		
		
	}
	
	// Persist specified cube to an XML file
	public static void serializeMDB(Cube cube) {

		ArrayList<Cube> cubes = new ArrayList<Cube>();
		cubes.add(cube);
		
		serializeMDB(cubes);
		
	}
	
	// Persist specified cubes to XML files
	public static void serializeMDB(ArrayList<Cube> cubes) {

		String targetDirectory = Types.MDB_DIR + Commons.getUniqueName();

		// Create a new directory
		Commons.createDirectory(targetDirectory);

		PersistenceStrategy strategy = new FilePersistenceStrategy(new File(targetDirectory));
		List<Cube> list = new XmlArrayList(strategy);

		for(Cube cube : cubes) {
			list.add(cube);
		}
		
	}
	
	// Get indices of specified dimension members in a cube
	public static HashMap<String, ArrayList<Integer>> getDimensionToMemberIndices(Cube cube, HashMap<String, ArrayList<String>> arg) {

		// Determine the target indices of dimensions values in this arg
		// corresponding to the given cube's dimension values
		HashMap<String, ArrayList<String>> dimensionToMemberValues = new HashMap<String, ArrayList<String>>(cube.getCubeMetaData().getDimensionToValues());

		// Replace the values of those keys which also appear in arg
		dimensionToMemberValues.putAll(arg);
		
		HashMap<String, ArrayList<Integer>> result = new HashMap<String, ArrayList<Integer>>();

		for(String dimension : dimensionToMemberValues.keySet()) {

			result.put(dimension, new ArrayList<Integer>());
			
			for(String value : dimensionToMemberValues.get(dimension)) {
				
				result.get(dimension).add(cube.getCubeMetaData().getDimensionToValues().get(dimension).indexOf(value));
				
			}
			
		}
		
		return result;
	}

	public static Cube dice(Cube cube, HashMap<String, ArrayList<String>> criteria) {

		int[] dimensionLengths = {};
		Cube result = new Cube("SubCube", dimensionLengths);
		HashMap<String, ArrayList<Integer>> dimensionToMemberIndices = getDimensionToMemberIndices(cube, criteria);
		
		ArrayList<Integer> lengths = new ArrayList<Integer>();

		for(String dimension : cube.getCubeMetaData().getDimensions()) {

			lengths.add(dimensionToMemberIndices.get(dimension).size());
			
		}
		
//		lengths.toA
		
		
		
		
		return result;
	}


}
