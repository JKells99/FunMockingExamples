package com.keyin.bookrecsystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookRecommenderTest {
    List<Book> books;

    BookCatalog bookCatalog;
    BookRecommender bookRecommender;


    @BeforeEach
    void setUp() {
        bookCatalog = mock(BookCatalog.class); // assign to the class field
        bookRecommender = new BookRecommender(bookCatalog); // assign to the class field

        books = List.of(
                new Book(1,"RED","Author 1", "Fiction"),
                new Book(2,"BLUE","Author 2", "Fiction"),
                new Book(3,"Killing Floor","Author 3", "Fiction/Thriller"),
                new Book(4,"The Hunger Games","Author 4", "Fiction"),
                new Book(5,"The Da Vinci Code","Author 5", "Fiction/Thriller"),
                new Book(6,"The Fault in Our Stars","Author 6", "Fiction"),
                new Book(7,"The Great Gatsby","Author 7", "Fiction"),
                new Book(8,"The Catcher in the Rye","Author 8", "HS Book"),
                new Book(9,"The Alchemist","Author 9", "Fiction"),
                new Book(10,"The Hobbit","Author 10", "Non Fiction")
        );


        when(bookCatalog.getAllBooks()).thenReturn(books);

    }


    @Test
    public void recommendRandomFictionBook(){

        Book rec = bookRecommender.recommendByGenre("Fiction");

        System.out.println("Recommended Book: " + rec.getTitle());


        assertEquals("Fiction", rec.getGenre());
        assertNotEquals("Non Fiction", rec.getGenre());
        assertNotEquals("Fiction/Thriller", rec.getGenre());
        assertNotEquals("HS Book", rec.getGenre());
    }
    @Test
    public void recommendRandomFictionThrillerBook(){

        Book rec = bookRecommender.recommendByGenre("Fiction/Thriller");

        System.out.println("Recommended Book: " + rec.getTitle());

        assertEquals("Fiction/Thriller", rec.getGenre());
        assertNotEquals("Non Fiction", rec.getGenre());
        assertNotEquals("Fiction", rec.getGenre());
        assertNotEquals("HS Book", rec.getGenre());
    }
    @Test
    public void recommendBookWithWrongGenreError(){

        Assertions.assertThrows(RuntimeException.class, () -> {
            bookRecommender.recommendByGenre("Yes By");
        });
    }


}
