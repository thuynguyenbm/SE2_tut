package ex2;

public class GoldenEditionBook extends Book{

    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public double getPrice() {
        int price = (int)(super.getPrice()*1.3*100);
        return (double)price/100;
    }
}
