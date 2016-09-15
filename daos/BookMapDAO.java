/*     */ package library.daos;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import library.interfaces.daos.IBookDAO;
/*     */ import library.interfaces.daos.IBookHelper;
/*     */ import library.interfaces.entities.IBook;
/*     */ 
/*     */ public class BookMapDAO implements IBookDAO
/*     */ {
/*     */   private int nextId;
/*     */   private Map<Integer, IBook> bookMap;
/*     */   private IBookHelper helper;
/*     */   
/*     */   public BookMapDAO(IBookHelper helper)
/*     */   {
/*  20 */     if (helper == null) {
/*  21 */       throw new IllegalArgumentException(String.format("BookDAO : constructor : helper cannot be null.", new Object[0]));
/*     */     }
/*  23 */     this.nextId = 1;
/*  24 */     this.helper = helper;
/*  25 */     this.bookMap = new HashMap();
/*     */   }
/*     */   
/*     */   public BookMapDAO(IBookHelper helper, Map<Integer, IBook> bookMap) {
/*  29 */     this(helper);
/*  30 */     if (helper == null) {
/*  31 */       throw new IllegalArgumentException(String.format("BookDAO : constructor : bookMap cannot be null.", new Object[0]));
/*     */     }
/*  33 */     this.bookMap = bookMap;
/*     */   }
/*     */   
/*     */   public IBook addBook(String author, String title, String callNo)
/*     */   {
/*  38 */     int id = getNextId();
/*  39 */     IBook book = this.helper.makeBook(author, title, callNo, id);
/*  40 */     this.bookMap.put(Integer.valueOf(id), book);
/*  41 */     return book;
/*     */   }
/*     */   
/*     */   public IBook getBookByID(int id)
/*     */   {
/*  46 */     if (this.bookMap.containsKey(Integer.valueOf(id))) {
/*  47 */       return (IBook)this.bookMap.get(Integer.valueOf(id));
/*     */     }
/*  49 */     return null;
/*     */   }
/*     */   
/*     */   public List<IBook> listBooks()
/*     */   {
/*  54 */     List<IBook> list = new ArrayList(this.bookMap.values());
/*  55 */     return Collections.unmodifiableList(list);
/*     */   }
/*     */   
/*     */   public List<IBook> findBooksByAuthor(String author)
/*     */   {
/*  60 */     if ((author == null) || (author.isEmpty())) {
/*  61 */       throw new IllegalArgumentException(
/*  62 */         String.format("BookDAO : findBooksByAuthor : author cannot be null or blank", new Object[0]));
/*     */     }
/*  64 */     List<IBook> list = new ArrayList();
/*  65 */     for (IBook b : this.bookMap.values()) {
/*  66 */       if (author.equals(b.getAuthor())) {
/*  67 */         list.add(b);
/*     */       }
/*     */     }
/*  70 */     return Collections.unmodifiableList(list);
/*     */   }
/*     */   
/*     */   public List<IBook> findBooksByTitle(String title)
/*     */   {
/*  75 */     if ((title == null) || (title.isEmpty())) {
/*  76 */       throw new IllegalArgumentException(
/*  77 */         String.format("BookDAO : findBooksByAuthor : author cannot be null or blank", new Object[0]));
/*     */     }
/*  79 */     List<IBook> list = new ArrayList();
/*  80 */     for (IBook b : this.bookMap.values()) {
/*  81 */       if (title.equals(b.getTitle())) {
/*  82 */         list.add(b);
/*     */       }
/*     */     }
/*  85 */     return Collections.unmodifiableList(list);
/*     */   }
/*     */   
/*     */   public List<IBook> findBooksByAuthorTitle(String author, String title)
/*     */   {
/*  90 */     if ((title == null) || (title.isEmpty()) || (author == null) || (author.isEmpty())) {
/*  91 */       throw new IllegalArgumentException(
/*  92 */         String.format("BookDAO : findBooksByAuthor : author and title cannot be null or blank", new Object[0]));
/*     */     }
/*  94 */     List<IBook> list = new ArrayList();
/*  95 */     for (IBook b : this.bookMap.values()) {
/*  96 */       if ((author.equals(b.getAuthor())) && (title.equals(b.getTitle()))) {
/*  97 */         list.add(b);
/*     */       }
/*     */     }
/* 100 */     return Collections.unmodifiableList(list);
/*     */   }
/*     */   
/*     */   private int getNextId() {
/* 104 */     return this.nextId++;
/*     */   }
/*     */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\daos\BookMapDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */