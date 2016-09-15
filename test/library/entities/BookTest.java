package library.entities;

import library.interfaces.entities.EBookState;
import library.interfaces.entities.ILoan;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BookTest {

    Book sut_;

    public BookTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        sut_ = new Book("author", "title", "A1", 1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstuctor() {
        //arrange
        Book test = new Book("Joe Doe", "Joes Life", "A1", 1);
        //execute
        //assert
        assertEquals("Joe Doe", test.getAuthor());
        assertEquals("Joes Life", test.getTitle());
        assertEquals("A1", test.getCallNumber());
        assertEquals(1, test.getID());
        assertEquals(null, test.getLoan());
        assertEquals(EBookState.AVAILABLE, test.getState());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContructor_Bad_Parameters() {
        //arrange
        //execute
        Book test = new Book("", "heh", "ee", -1);
        fail("should not have created book");
    }

    @Test
    public void testBorrow() {
        //arrange
        ILoan loan = mock(ILoan.class);
        //excecute
        sut_.borrow(loan);
        //assert
        assertNotNull(sut_.getLoan());
        assertEquals(EBookState.ON_LOAN, sut_.getState());
    }

    @Test(expected = RuntimeException.class)
    public void testBorrow_In_Incorrect_State() {
        //arrange
        ILoan loan = mock(ILoan.class);
        sut_.setState(EBookState.DAMAGED);
        //execute
        sut_.borrow(loan);
        fail("should of thrown runtime exception");
    }

    @Test
    public void testReturnBook_Damaged() {
        //arrange
        sut_.setState(EBookState.ON_LOAN);
        //excecute
        sut_.returnBook(true);
        //assert
        assertEquals(EBookState.DAMAGED, sut_.getState());
        assertNull(sut_.getLoan());
    }

    @Test
    public void testReturnBook_Not_Damaged() {
        //arrange
        sut_.setState(EBookState.ON_LOAN);
        //excecute
        sut_.returnBook(false);
        //assert
        assertEquals(EBookState.AVAILABLE, sut_.getState());
        assertNull(sut_.getLoan());
    }

    @Test(expected = RuntimeException.class)
    public void testReturnBook_In_Available() {
        //arrange
        sut_.setState(EBookState.AVAILABLE);
        //excecute
        sut_.returnBook(false);
        //assert
        fail("Book was returned in available state");
    }

    @Test
    public void testLose_When_State_OnLoan() {
        //arrange
        sut_.setState(EBookState.ON_LOAN);
        //excecute
        sut_.lose();
        //assert
        assertEquals(EBookState.LOST, sut_.getState());
    }

    @Test(expected = RuntimeException.class)
    public void testLose_When_State_Not_OnLoan() {
        //arrange
        sut_.setState(EBookState.AVAILABLE);
        //excecute
        sut_.lose();
        //assert
        fail("Was lost when available");
    }

    @Test
    public void testRepair_When_State_Damaged() {
        //arrange
        sut_.setState(EBookState.DAMAGED);
        //excecute
        sut_.repair();
        //assert
        assertEquals(EBookState.AVAILABLE, sut_.getState());
    }

    @Test(expected = RuntimeException.class)
    public void testRepair_When_State_Not_Damaged() {
        //arrange
        sut_.setState(EBookState.AVAILABLE);
        //excecute
        sut_.lose();
        //assert
        fail("Was repaired when available");
    }

    @Test
    public void testDispose_When_State_Damaged() {
        //arrange
        sut_.setState(EBookState.DAMAGED);
        //excecute
        sut_.dispose();
        //assert
        assertEquals(EBookState.DISPOSED, sut_.getState());
    }

    @Test(expected = RuntimeException.class)
    public void testDispose_When_OnLoan() {
        //arrange
        sut_.setState(EBookState.ON_LOAN);
        //excecute
        sut_.dispose();
        //assert
        fail("Was repaired when available");
    }

}
