package epam;

public class Book {
    private String name;
    private String author;
    private String publisher;
    private int id;
    private int year;
    private int numIfPages;
    private int price;              /* int only */
    private boolean coverType;      /* false = soft cover */

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author, String publisher, int year) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

    public Book(String name, String author, String publisher, int id,
                int year, int numIfPages, float price, String cover) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.id = id;
        this.year = year;
        this.numIfPages = numIfPages;
        setCoverHard(cover);
        setPrice(price);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Название книги: ").append(this.name);
        sb.append("\nАвтор: ").append(this.author);
        sb.append("\nИздательство: ").append(this.publisher);
        sb.append("\nИдентификатор(id): ").append(this.id);
        sb.append("\nГод издания: ").append(this.year);
        sb.append("\nКоличество страниц: ").append(this.numIfPages);
        sb.append("\nЦена: ").append(getPrice());
        sb.append("\nТип обложки: ").append(getCover());
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumIfPages() {
        return numIfPages;
    }

    public void setNumIfPages(int numIfPages) {
        this.numIfPages = numIfPages;
    }

    public float getPrice() {
        return (float) price/100;
    }

    public void setPrice(double price) {
        this.price = (int)(price * 100);
    }

    public String getCover() {
        if (coverType) return "Твёрдая";
        return "Мягкая";
    }

    public void setCoverHard(String coverType) {
        if ("мягкая".equals(coverType) || "Мягкая".equals(coverType)) {
            this.coverType = false;
        }else this.coverType = true;
    }
}
