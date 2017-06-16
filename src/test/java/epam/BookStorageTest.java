package epam;

//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
import org.junit.*;
import java.util.ArrayList;

public class BookStorageTest  {
    private BookStorage bookStorage;
    private ArrayList<Book> books;

    @Before
    public void initializer() {
        bookStorage = new BookStorage();
        books = new ArrayList<Book>();
    }

    @Test
    public void addBookFromFileTest() {
        String file = BookStorage.pathToBookList;
        bookStorage.addBooksFromFIle(file, books);
        boolean expected = !books.isEmpty();
        Assert.assertTrue("Хранилище не заполнено из файла.", expected);
    }

    @Ignore("следует вынести чтение консоли в отдельный метод")
    @Test
    public void addBookFromConsoleTest() {
        boolean expected = !books.isEmpty();
        bookStorage.addBookFromConsole();
        Assert.assertTrue("Хранилище не заполнено из консоли.", expected);
    }

    @Test
    public void addBookWith2ParamsTest(){
        String[] str = "Изучаем Java, К.Сьерра".split(", ");
        bookStorage.addBookWith2params(str, books);
        Assert.assertNotNull(books.get(0).getName());
        Assert.assertNotNull(books.get(0).getAuthor());
    }

    @Test
    public void addBookWith4ParamsTest(){
        String[] str = "Изучаем Java, К.Сьерра, O'Reilly, 2017".split(", ");
        bookStorage.addBookWith4params(str, books);
        Assert.assertNotNull(books.get(0).getName());
        Assert.assertNotNull(books.get(0).getAuthor());
        Assert.assertNotNull(books.get(0).getPublisher());
        Assert.assertNotNull(books.get(0).getYear());
    }

    @Test
    public void addBookWith8ParamsTest(){
        String[] str = "Изучаем Java, К.Сьерра, O'Reilly, 004, 2017, 720, 34.49, true".split(", ");
        bookStorage.addBookWith8params(str, books);
        Assert.assertNotNull(books.get(0).getName());
        Assert.assertNotNull(books.get(0).getAuthor());
        Assert.assertNotNull(books.get(0).getPublisher());
        Assert.assertNotNull(books.get(0).getId());
        Assert.assertNotNull(books.get(0).getYear());
        Assert.assertNotNull(books.get(0).getNumIfPages());
        Assert.assertNotNull(books.get(0).getPrice());
        Assert.assertNotNull(books.get(0).getCover());
    }
}
