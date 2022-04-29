package to_dos.abstract_factory;

/* Create RoundedShapeFactory class extending AbstractFactory to generate 
 * object of concrete class based on given information. 
 */

public class RoundedShapeFactory extends AbstractFactory {
	// TO-DO: Implement the getShape() method
	@Override
	public Shape getShape(String shapeType) {
		/*
		 * check for the shape type is equal to 'Rectangle' or 'Square' (ignore case)
		 * then return the corresponding type
		 */
		if (shapeType.equalsIgnoreCase("Rectangle"))
			return new Rectangle();
		else {
			if (shapeType.equalsIgnoreCase("Square"))
				return new Square();
			else return null;
		}
	}
}