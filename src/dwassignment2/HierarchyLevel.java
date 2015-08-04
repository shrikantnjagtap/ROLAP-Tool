package dwassignment2;

import java.util.ArrayList;

public class HierarchyLevel {

	public static final String Date = "Date";
	public static final String Week = "Week";
	public static final String Month = "Month";
	public static final String Quarter = "Quarter";
	public static final String Semester = "Semester";
	public static final String Year = "Year";
	public static final String All = "All";

	public static final String Product = "Product";
	public static final String SubCategory = "SubCategory";
	public static final String Category = "Category";

	public static final String Customer = "Customer";
	public static final String PostalCode = "PostalCode";
	public static final String City = "City";
	public static final String State = "State";
	public static final String Country = "Country";

	public static final String Region = "Region";
	public static final String Group = "Group";

	public static final ArrayList<String> dateHierarchy = new ArrayList<String>();
	public static final ArrayList<String> productHierarchy = new ArrayList<String>();
	public static final ArrayList<String> customerHierarchy = new ArrayList<String>();
	public static final ArrayList<String> territoryHierarchy = new ArrayList<String>();

	static {
		dateHierarchy.add(Date);
		dateHierarchy.add(Week);
		dateHierarchy.add(Month);
		dateHierarchy.add(Quarter);
		dateHierarchy.add(Semester);
		dateHierarchy.add(Year);
		dateHierarchy.add(All);

		productHierarchy.add(Product);
		productHierarchy.add(SubCategory);
		productHierarchy.add(Category);
		productHierarchy.add(All);

		customerHierarchy.add(Customer);
		customerHierarchy.add(PostalCode);
		customerHierarchy.add(City);
		customerHierarchy.add(State);
		customerHierarchy.add(Country);
		customerHierarchy.add(All);

		territoryHierarchy.add(Region);
		territoryHierarchy.add(Country);
		territoryHierarchy.add(Group);
		territoryHierarchy.add(All);

	}

}