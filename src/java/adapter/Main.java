package adapter;

public class Main {

    public static void main(String[] args) {
        AreaCalculator areaCalculator = new AreaCalculator();
        Shape square = new Square(10);
        System.out.println(square.calculateArea());

        Rectangle rectangle = new Rectangle(10, 20);
        Shape myRectangle = new RectangleAdapter(rectangle);
        System.out.println(myRectangle.calculateArea());

        System.out.println(areaCalculator.calculateArea(myRectangle));
    }
}
