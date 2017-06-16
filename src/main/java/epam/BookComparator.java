package epam;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    private BookParams paramList;

    public BookComparator(BookParams paramList){
        setParamList(paramList);
    }

    public void setParamList(BookParams paramList){
        if (paramList == null) {
            throw new NullPointerException("Не задан параметр сортировки.");
        }
        this.paramList = paramList;
    }

    BookParams getParamList(){
        return paramList;
    }

    public int compare(Book one, Book two){
        switch (paramList) {
            case AUTHOR:
                return one.getAuthor().compareTo(two.getAuthor());
            case PUBLISHER:
                return one.getPublisher().compareTo(two.getPublisher());
            case YEAR:
                return one.getYear() - two.getYear();
            default:
                throw new EnumConstantNotPresentException(BookParams.class, paramList.name());
        }
    }
}