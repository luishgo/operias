package operias.coverage;

import java.util.ArrayList;
import java.util.List;

/**
 * A package from the coverage xml file
 * @author soosterwaal
 */
public class CoberturaPackage {

	/**
	 * The name of the package
	 */
	private String name;
	
	/**
	 * The line rate of the package
	 */
	private double lineRate;
	
	/**
	 * The branch rate of the package
	 */
	private double branchRate;
	
	/**
	 * A list of classes within this package
	 */
	private List<CoberturaClass> classes;
	
	/**
	 * Construct a new cobertura package
	 * @param name 	Name of the package
	 * @param lineRate	Line rate of the package
	 * @param branchRate Branch rate of the package
	 */
	public CoberturaPackage(String name, double lineRate, double branchRate) {
		this.name = name;
		this.lineRate = lineRate;
		this.branchRate = branchRate;
		this.classes = new ArrayList<CoberturaClass>();
	}
	
	/**
	 * Add a class to the package
	 * @param _class Cobertura class
	 */
	public void addClass(CoberturaClass _class) {
		classes.add(_class);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the lineRate
	 */
	public double getLineRate() {
		return lineRate;
	}

	/**
	 * @return the branchRate
	 */
	public double getConditionRate() {
		return branchRate;
	}

	/**
	 * @return the classes
	 */
	public List<CoberturaClass> getClasses() {
		return classes;
	}
	
	/**
	 * Get the class in the package with the given name, null otherwise
	 * @param className
	 * @return
	 */
	public CoberturaClass getClass(String className) {
		for(CoberturaClass cClass : classes) {
			if (cClass.getName().equals(className)) {
				return cClass;
			}
		}
		
		return null;
	}
	
	/**
	 * Get the number of relevant line for this package
	 * @return
	 */
	public int getLineCount() {
		int count = 0;
		
		for(CoberturaClass cClass : classes) {
			count += cClass.getLines().size();
		}
		
		return count;
	}

	/**
	 * Get the amount of conditions in this package
	 * @return
	 */
	public int getConditionCount() {
		int count = 0;
		
		for(CoberturaClass cClass : classes) {
			count += cClass.getConditionCount();
		}
		
		return count;
	}
}
