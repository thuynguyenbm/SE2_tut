package to_dos.abstract_factory;

/* Create the AbstractFactoryTest class which uses the FactoryProducer
 * to get AbstractFactory in order to get factories
 * of concrete classes by passing an information such as type.
 */

public class AbstractFactoryTest {
    //TO-DO: Implement the main() method for testing purpose
    public static void main(String[] args) {
        // get shape factory
        ShapeFactory factory = new ShapeFactory();
        // get an object of Shape Rectangle
        Rectangle rectangle = new Rectangle();
        // call draw method of Shape Rectangle
        rectangle.draw();
        // get an object of Shape Square
        Square square = new Square();
        // call draw method of Shape Square
        square.draw();
        // get rounded shape factory
        RoundedShapeFactory factory1 = new RoundedShapeFactory();
        // get an object of Rounded Shape Rectangle
        RoundedRectangle rectangle1 = new RoundedRectangle();
        // call draw method of Rounded Shape Rectangle
        rectangle1.draw();
        // get an object of Rounded Shape Square
        RoundedSquare square1 = new RoundedSquare();
        // call draw method of Rounded Shape Square
        square1.draw();
    }
}