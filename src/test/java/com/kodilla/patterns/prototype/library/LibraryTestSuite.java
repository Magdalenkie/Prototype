package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {

        //Given
        Library library = new Library("my library");
        Book book1 = new Book("The Wolf of Wall Street", "Jordan Belfort", LocalDate.of(2007, Month.SEPTEMBER, 25));
        Book book2 = new Book("Catch Me If You Can", "Frank Abagnale", LocalDate.of(1980, Month.JANUARY, 01));
        Book book3 = new Book("Kamienie na szaniec", "Aleksander Kaminski", LocalDate.of(1943, Month.JULY, 15));
        Book book4 = new Book("The Lord of the Rings", "John R. R. Tolkien", LocalDate.of(1954, Month.JULY, 29));

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("my library - shallow copy");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("my library - deep copy");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //When
        library.removeBook(book4);

        //Then
        Assert.assertEquals(3, library.getBooks().size());
        Assert.assertEquals(3, clonedLibrary.getBooks().size());
        Assert.assertEquals(4, deepClonedLibrary.getBooks().size());
    }
}

