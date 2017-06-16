/*
 * Программа "книгохранилище"
 * Читает данные по заданному шаблону из файла либо из консоли,
 * добавляет в список и сортирует по одному из заданных параметров.
 */
package epam;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import static epam.BookLog.log;

public class BookStorage{
    static String pathToBookList = ".\\src\\main\\resources\\BooksList.txt\\";
    private static ArrayList<Book> books;

    public BookStorage(){
        books = new ArrayList<Book>();
    }

    public static void main( String[] args ) {
        log.info("Программа начала работу");
        BookStorage bs = new BookStorage();
//        bs.addBooksFromFIle(pathToBookList, books);
//        bs.sortByAuthor(books, "нов");
//        bs.sortByPublisher(books, "Вилья");
//        bs.sortByYear(books, 2016);
        bs.addBookFromConsole();
        System.out.println(books);
        log.info("Программа завершила работу");
    }

    public void sortByAuthor(ArrayList<Book> list, String name){
        BookComparator comparator = new BookComparator(BookParams.AUTHOR);
        Collections.sort(list, comparator);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAuthor().contains(name)) {
                System.out.println(list.get(i));
                System.out.println();
            }
        }
    }

    public void sortByPublisher(ArrayList<Book> list, String name) {
        BookComparator comparator = new BookComparator(BookParams.PUBLISHER);
        Collections.sort(list, comparator);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPublisher().contains(name)) {
                System.out.println(list.get(i));
                System.out.println();
            }
        }
    }

    public void sortByYear(ArrayList<Book> list, Integer year){
        BookComparator comparator = new BookComparator(BookParams.YEAR);
        Collections.sort(list, comparator);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getYear() >= year) {
                System.out.println(list.get(i));
                System.out.println();
            }
        }
    }

    void addBooksFromFIle(String filepath, ArrayList<Book> storage) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filepath));
            while (reader.ready()) {
                String[] str = reader.readLine().split("(, )");
                if (str.length == 8) {
                    addBookWith8params(str, storage);
                } else if (str.length == 4) {
                    addBookWith4params(str, storage);
                } else if (str.length == 2) {
                    addBookWith2params(str, storage);
                }
            }
            reader.close();
        } catch (IOException e) {
            log.error("Ошибка имени файла " + e.getMessage(), e);
            e.printStackTrace();
        }
    }

    void addBookFromConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] params;
        System.out.println("Чтобы добавить книгу в хранилище ведите книжные данные. \n" +
                            "Если не знаете - нажмите Enter.");
        System.out.println("Возможны три варианта:\n" +
                            "1 - 'Имя, Автор'\n" +
                            "2 - 'Имя, Автор, Издательство, Год издания'\n" +
                            "3 - 'Имя, Автор, Издательство, id, Год издания," +
                                " Количество страниц, Цена, Тип обложки. ' ");
        System.out.println();
        System.out.println("Введите данные как указано в шаблоне:");
        String str = "";
        try {
            str = reader.readLine();
            params = str.split("(, )");
            reader.close();

            if (params.length == 2) {
                addBookWith2params(params, books);
            }else if (params.length == 4){
                addBookWith4params(params, books);
            }else if (params.length == 8) {
                addBookWith8params(params, books);
            }else throw new IOException();
        } catch (IOException e) {
            System.out.println("Ошибка ввода данных.");
            log.error("Ошибка ввода данных при чтении из консоли. Ввод:  " + str);
        }
    }

    void addBookWith2params(String[] arr, ArrayList<Book> list) {
        list.add(new Book(arr[0], arr[1]));
    }

    void addBookWith4params(String[] arr, ArrayList<Book> list) {
        list.add(new Book(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]) ) );
    }

    void addBookWith8params(String[] arr, ArrayList<Book> list) {
        list.add(new Book(arr[0],arr[1],arr[2],Integer.parseInt(arr[3]),
                    Integer.parseInt(arr[4]),Integer.parseInt(arr[5]),
                    Float.parseFloat(arr[6]),(arr[7]) ) );
    }
}

