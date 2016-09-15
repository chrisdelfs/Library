/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lowlevelintegration;

import java.util.Date;
import java.util.List;
import java.util.Map;
import library.daos.BookHelper;
import library.daos.BookMapDAO;
import library.entities.Book;
import library.entities.Loan;
import library.entities.Member;
import library.interfaces.entities.EBookState;
import library.interfaces.entities.IBook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chris
 */
public class LowLevelIntegrationHelperBookDAOBook {

    Book book;
    Member member;
    Date date1;
    Date date2;
    Loan loan;
    BookHelper helper;
    BookMapDAO bookDAO;

    public LowLevelIntegrationHelperBookDAOBook() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        book = new Book("auth", "title", "callID", 1);
        member = new Member("fname", "lname", "phone", "email", 1);
        date1 = new Date();
        date2 = new Date();
        loan = new Loan(book, member, date1, date2);
        helper = new BookHelper();
        bookDAO = new BookMapDAO(helper);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testBorrow() {
        //arrange 
        //execute
        book.borrow(loan);
        //assert
        assertEquals(loan, book.getLoan());
        assertFalse(book.getLoan() == null);
    }

    @Test
    public void testReturnBook_Damaged() {
        //arrange
        book.setState(EBookState.ON_LOAN);
        //excecute
        book.returnBook(true);
        //assert
        assertEquals(EBookState.DAMAGED, book.getState());
        assertNull(book.getLoan());
    }

    @Test
    public void testBookMapDAOConstructor() {
        //arrange
        //execute
        //assert
        assertEquals(helper, bookDAO.getBookHelper());
        assertNotNull(bookDAO.getBookMap());
    }

    @Test
    public void testAddBook() {
        //Arrange
        String author = "Joe Bloe";
        String title = "My life as a dog";
        String callNo = "1a";
        //execute
        IBook result = bookDAO.addBook(author, title, callNo);
        //asserts
        assertNotNull(result);
        Map testMap = bookDAO.getBookMap();
        assertTrue(testMap.containsValue(result));
    }

    @Test
    public void testGetBookByID() {
        //Arrange
        IBook expected = book;
        bookDAO.setBookMap(1, expected);
        //execute
        IBook actual = bookDAO.getBookByID(1);
        //asserts
        assertEquals(expected, actual);
    }

    @Test
    public void testFindBooksByAuthor() {
        //Arrange
        String author = "auth";
        BookMapDAO instance = bookDAO;
        List list;
        //execute
        IBook expected = book;
        bookDAO.setBookMap(1, expected);
        list = instance.findBooksByAuthor(author);
        //assert
        assertTrue(list.contains(expected));
    }

    @Test
    public void testFindBooksByTitle() {
        //Arrange
        String title = "title";
        BookMapDAO instance = bookDAO;
        List list;
        //execute
        IBook expected = book;
        bookDAO.setBookMap(1, expected);
        list = instance.findBooksByTitle(title);
        //assert
        assertTrue(list.contains(expected));
    }

    @Test
    public void testFindBooksByAuthorTitle() {
        //arrange
        IBook book2 = new Book("auth", "titl", "callID", 1);
        bookDAO.setBookMap(1, book);
        bookDAO.setBookMap(2, book2);
        List list;
        //execute
        list = bookDAO.findBooksByAuthorTitle("auth", "title");
        //assert
        assertTrue(list.contains(book));
        assertFalse(list.contains(book2));
    }

    @Test
    public void testMakeBook() {
        //arrange
        BookHelper test = new BookHelper();
        //excecute
        IBook actual = test.makeBook("auth", "title", "A1", 1);
        //assert
        assertNotNull(actual);
        assertEquals("auth", actual.getAuthor());
        assertEquals("title", actual.getTitle());
        assertEquals("A1", actual.getCallNumber());
        assertEquals(1, actual.getID());
    }

}
