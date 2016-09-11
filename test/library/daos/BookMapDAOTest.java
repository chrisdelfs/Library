package library.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import library.interfaces.daos.IBookHelper;
import library.interfaces.entities.IBook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookMapDAOTest {

    IBookHelper helper;
    BookMapDAO bookDAO;
    IBook book;

    public BookMapDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        book = mock(IBook.class);
        when(book.getAuthor()).thenReturn("Joe Doe");
        when(book.getTitle()).thenReturn("Cats life");
        helper = mock(IBookHelper.class);
        when(helper.makeBook(anyString(), anyString(), anyString(), anyInt())).thenReturn(book);
        bookDAO = new BookMapDAO(helper);
    }

    @After
    public void tearDown() {

    }
     @Test
    public void testConstructor() {
        //arrange
        //execute
        BookMapDAO test = new BookMapDAO(helper);
        //assert
        assertNotNull(test.getBookMap());
        assertEquals(helper, test.getBookHelper());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_When_Helper_Null() {
        //arrange
        IBookHelper nullHelper = null;
        //execute
        BookMapDAO test = new BookMapDAO(nullHelper);
        //assert
        fail("worked with null helper");
    }
     @Test
    public void testConstructor_With_HashMap() {
        //arrange
        IBook book = mock(IBook.class);
        Map expected = new HashMap<Integer, IBook>();
        expected.put(5, book);
        //execute
        BookMapDAO test = new BookMapDAO(helper, expected);
        //assert
        Map actual = test.getBookMap();
        assertEquals(actual, expected);
        
        
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
    public void testListBooks() {
        //Arrange 
        IBook expected = book;
        bookDAO.setBookMap(1, expected);
        //Execute
        List<IBook> list = bookDAO.listBooks();
        //Assert
        assertTrue(list.contains(expected));
    }

    @Test
    public void testFindBooksByAuthor_Should_Work() {
        //Arrange
        String author = "Joe Doe";
        BookMapDAO instance = bookDAO;
        List list;
        //execute
       IBook expected = book;
        bookDAO.setBookMap(1, expected);
        list = instance.findBooksByAuthor(author);
        //assert
        assertTrue(list.contains(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindBooksByAuthor_Should_Not_Work() throws IllegalArgumentException {
        //Arrange
        String author = "";
        BookMapDAO instance = bookDAO;
        List list;
        //execute
        IBook expected = book;
        bookDAO.setBookMap(1, expected);
        list = instance.findBooksByAuthor(author);
        //assert
        fail("should of thrown illegal argument exception");

    }

    @Test
    public void testFindBooksByTitle_Should_Work() {
        //Arrange
        String title = "Cats life";
        BookMapDAO instance = bookDAO;
        List list;
        //execute
        IBook expected = book;
        bookDAO.setBookMap(1, expected);
        list = instance.findBooksByTitle(title);
        //assert
        assertTrue(list.contains(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindBooksByTitle_Should_Not_Work() throws IllegalArgumentException {
        //Arrange
        String title = "";
        BookMapDAO instance = bookDAO;
        List list;
        //execute
        IBook expected = book;
        bookDAO.setBookMap(1, expected);
        list = instance.findBooksByAuthor(title);
        //assert

    }

    @Test
    public void testFindBooksByAuthorTitle() {
        //arrange
        IBook book1 = mock(IBook.class);
        when(book1.getAuthor()).thenReturn("John Doe");
        when(book1.getTitle()).thenReturn("Pet Cemetery");

        IBook book2 = mock(IBook.class);
        when(book2.getAuthor()).thenReturn("John Doe");
        when(book2.getTitle()).thenReturn("Doggos dream");

        IBookHelper helper = mock(IBookHelper.class);
        when(helper.makeBook("John Doe", "Pet Cemetery", "A1", 1)).thenReturn(book1);
        when(helper.makeBook("John Doe", "Doggos dream", "A2", 2)).thenReturn(book2);

        BookMapDAO instance = new BookMapDAO(helper);
        instance.addBook("John Doe", "Pet Cemetery", "A1");
        instance.addBook("John Doe", "Doggos dream", "A2");

        List list;
        //execute
        list = instance.findBooksByAuthorTitle("John Doe", "Pet Cemetery");
        //assert
        assertTrue(list.contains(book1));
        assertFalse(list.contains(book2));

    }

}
