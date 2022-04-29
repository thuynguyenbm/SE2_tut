package ex2;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book( String author,String title, double price) {
        setTitle(title);
        setAuthor(author);
        setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title)throws IllegalArgumentException {
        if (title.length() < 3)
            throw new IllegalArgumentException("Title not valid");
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws IllegalArgumentException{
        for (int i = 0; i < author.length()-1; i++) {
            if (author.charAt(i) == ' ' && author.charAt(i + 1) > '0' && author.charAt(i + 1) < '9') {
                throw new IllegalArgumentException("Author not valid");
            }
        }
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IllegalArgumentException{
        if (price < 1)
            throw new IllegalArgumentException("Price not valid");
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
