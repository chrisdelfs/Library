package library.daos;

import library.interfaces.entities.IBook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookHelperTest {

    public BookHelperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMakeBook() {
        //arrange
        BookHelper sut_ = new BookHelper();
        //excecute
        IBook actual = sut_.makeBook("auth", "title", "A1", 1);
        //assert
        assertNotNull(actual);

    }

}
