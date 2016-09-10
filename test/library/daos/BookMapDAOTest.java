
package library.daos;

import java.util.ArrayList;
import java.util.List;
import library.interfaces.daos.IBookHelper;
import library.interfaces.entities.IBook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import stubs.*;



public class BookMapDAOTest {
    IBookHelper helper;
    BookMapDAO bookDAO;
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
        helper = new BookHelperStub();
        bookDAO = new BookMapDAO(helper);
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of addBook method, of class BookMapDAO.
     */
    @Test
    public void testAddBook() {
        //Arrange
        String author = "Joe Bloe";
        String title = "My life as a dog";
        String callNo = "1a";
        //excecute
        //asserts
        IBook result = bookDAO.addBook(author, title, callNo);
        assertNotNull(result);
    }


    @Test
    public void testGetBookByID() {
        //Arrange
        IBook expected = bookDAO.addBook("author", "title", "A1");
        //execute
        //asserts
        IBook result = bookDAO.getBookByID(1);
        assertEquals(expected, result);       
    }

    @Test
    public void testListBooks(){
        //Arrange 
        IBook expected = bookDAO.addBook("auth", "tit", "no1");
        //Execute
        List<IBook> list = bookDAO.listBooks();
        //Assert
        assertTrue(list.contains(expected));        
    }

    /**
     * Test of findBooksByAuthor method, of class BookMapDAO.
     */
    @Test
    public void testFindBooksByAuthor_Should_Work() {
        //Arrange
        String author = "Joe Doe";
        BookMapDAO instance = bookDAO;
        List list;
        //excecute
        IBook expected = instance.addBook("Joe Doe", "Cats life", "BA1");
        list = instance.findBooksByAuthor(author);
        //assert
        assertTrue(list.contains(expected));
    }

 @Test(expected=IllegalArgumentException.class)
    public void testFindBooksByAuthor_Should_Not_Work() throws IllegalArgumentException {
        //Arrange
        String author = "";
        BookMapDAO instance = bookDAO;
        List list;
        //excecute
        IBook expected = instance.addBook("Joe Doe", "Cats life", "BA1");
        list = instance.findBooksByAuthor(author);
        //assert

    }

   
     
    @Test
    public void testFindBooksByTitle_Should_Work() {
        //Arrange
        String title = "Cats life";
        BookMapDAO instance = bookDAO;
        List list;
        //excecute
        IBook expected = instance.addBook("Joe Doe", "Cats life", "BA1");
        list = instance.findBooksByTitle(title);
        //assert
        assertTrue(list.contains(expected));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testFindBooksByTitle_Should_Not_Work() throws IllegalArgumentException {
        //Arrange
        String title = "";
        BookMapDAO instance = bookDAO;
        List list;
        //excecute
        IBook expected = instance.addBook("Joe Doe", "Cats life", "BA1");
        list = instance.findBooksByAuthor(title);
        //assert

    }
    
    @Test
    public void testFindBooksByAuthorTitle() {
        //arrange
        BookStub book1 = mock(BookStub.class);
        when(book1.getAuthor()).thenReturn("John Doe");
        when(book1.getTitle()).thenReturn("Pet Cemetery");
        
        BookStub book2 = mock(BookStub.class);
        when(book2.getAuthor()).thenReturn("John Doe");
        when(book2.getTitle()).thenReturn("Doggos dream");
        
        BookHelperStub helper = mock(BookHelperStub.class);
        when(helper.makeBook("John Doe", "Pet Cemetery", "A1", 1)).thenReturn(book1);
        when(helper.makeBook("John Doe", "Doggos dream", "A2", 2)).thenReturn(book2);
        
        BookMapDAO instance = new BookMapDAO(helper);
        instance.addBook("John Doe", "Pet Cemetery", "A1");
        instance.addBook("John Doe", "Doggos dream", "A2");
        
        List list;
        //excecute
        list = instance.findBooksByAuthorTitle("John Doe", "Pet Cemetery");
        //assert
        assertTrue(list.contains(book1));
        assertFalse(list.contains(book2));
        
        

    }
    
}
