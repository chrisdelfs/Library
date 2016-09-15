/*     */ package library;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import javax.swing.SwingUtilities;
/*     */ import library.daos.BookHelper;
/*     */ import library.daos.BookMapDAO;
/*     */ import library.daos.LoanHelper;
/*     */ import library.daos.LoanMapDAO;
/*     */ import library.daos.MemberHelper;
/*     */ import library.daos.MemberMapDAO;
/*     */ import library.hardware.CardReader;
/*     */ import library.hardware.Display;
/*     */ import library.hardware.Printer;
/*     */ import library.hardware.Scanner;
/*     */ import library.interfaces.IMainListener;
/*     */ import library.interfaces.daos.IBookDAO;
/*     */ import library.interfaces.daos.ILoanDAO;
/*     */ import library.interfaces.daos.IMemberDAO;
/*     */ import library.interfaces.entities.IBook;
/*     */ import library.interfaces.entities.ILoan;
/*     */ import library.interfaces.entities.IMember;
/*     */ import library.panels.MainPanel;
/*     */ 
/*     */ public class Main implements IMainListener
/*     */ {
/*     */   private CardReader reader;
/*     */   private Scanner scanner;
/*     */   private Printer printer;
/*     */   private Display display;
/*     */   private IBookDAO bookDAO;
/*     */   private ILoanDAO loanDAO;
/*     */   private IMemberDAO memberDAO;
/*     */   
/*     */   public Main()
/*     */   {
/*  37 */     this.bookDAO = new BookMapDAO(new BookHelper());
/*  38 */     this.loanDAO = new LoanMapDAO(new LoanHelper());
/*  39 */     this.memberDAO = new MemberMapDAO(new MemberHelper());
/*     */     
/*  41 */     this.reader = new CardReader();
/*  42 */     this.scanner = new Scanner();
/*  43 */     this.printer = new Printer();
/*  44 */     this.display = new Display();
/*     */     
/*  46 */     setupTestData();
/*     */   }
/*     */   
/*     */   public void showGUI()
/*     */   {
/*  51 */     this.reader.setVisible(true);
/*  52 */     this.scanner.setVisible(true);
/*  53 */     this.printer.setVisible(true);
/*  54 */     this.display.setVisible(true);
/*     */   }
/*     */   
/*     */ 
/*     */   public void borrowBooks()
/*     */   {
/*  60 */     final BorrowUC_CTL ctl = new BorrowUC_CTL(this.reader, this.scanner, this.printer, this.display, 
/*  61 */       this.bookDAO, this.loanDAO, this.memberDAO);
/*  62 */     SwingUtilities.invokeLater(new Runnable() {
/*     */       public void run() {
/*  64 */         ctl.initialise();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void setupTestData()
/*     */   {
/*  71 */     IBook[] book = new IBook[15];
/*  72 */     IMember[] member = new IMember[6];
/*     */     
/*  74 */     book[0] = this.bookDAO.addBook("author1", "title1", "callNo1");
/*  75 */     book[1] = this.bookDAO.addBook("author1", "title2", "callNo2");
/*  76 */     book[2] = this.bookDAO.addBook("author1", "title3", "callNo3");
/*  77 */     book[3] = this.bookDAO.addBook("author1", "title4", "callNo4");
/*  78 */     book[4] = this.bookDAO.addBook("author2", "title5", "callNo5");
/*  79 */     book[5] = this.bookDAO.addBook("author2", "title6", "callNo6");
/*  80 */     book[6] = this.bookDAO.addBook("author2", "title7", "callNo7");
/*  81 */     book[7] = this.bookDAO.addBook("author2", "title8", "callNo8");
/*  82 */     book[8] = this.bookDAO.addBook("author3", "title9", "callNo9");
/*  83 */     book[9] = this.bookDAO.addBook("author3", "title10", "callNo10");
/*  84 */     book[10] = this.bookDAO.addBook("author4", "title11", "callNo11");
/*  85 */     book[11] = this.bookDAO.addBook("author4", "title12", "callNo12");
/*  86 */     book[12] = this.bookDAO.addBook("author5", "title13", "callNo13");
/*  87 */     book[13] = this.bookDAO.addBook("author5", "title14", "callNo14");
/*  88 */     book[14] = this.bookDAO.addBook("author5", "title15", "callNo15");
/*     */     
/*  90 */     member[0] = this.memberDAO.addMember("fName0", "lName0", "0001", "email0");
/*  91 */     member[1] = this.memberDAO.addMember("fName1", "lName1", "0002", "email1");
/*  92 */     member[2] = this.memberDAO.addMember("fName2", "lName2", "0003", "email2");
/*  93 */     member[3] = this.memberDAO.addMember("fName3", "lName3", "0004", "email3");
/*  94 */     member[4] = this.memberDAO.addMember("fName4", "lName4", "0005", "email4");
/*  95 */     member[5] = this.memberDAO.addMember("fName5", "lName5", "0006", "email5");
/*     */     
/*  97 */     Calendar cal = Calendar.getInstance();
/*  98 */     Date now = cal.getTime();
/*     */     
/*     */ 
/* 101 */     for (int i = 0; i < 2; i++) {
/* 102 */       ILoan loan = this.loanDAO.createLoan(member[1], book[i]);
/* 103 */       this.loanDAO.commitLoan(loan);
/*     */     }
/* 105 */     cal.setTime(now);
/* 106 */     cal.add(5, 15);
/* 107 */     Date checkDate = cal.getTime();
/* 108 */     this.loanDAO.updateOverDueStatus(checkDate);
/*     */     
/*     */ 
/* 111 */     member[2].addFine(10.0F);
/*     */     
/*     */ 
/* 114 */     for (int i = 2; i < 7; i++) {
/* 115 */       ILoan loan = this.loanDAO.createLoan(member[3], book[i]);
/* 116 */       this.loanDAO.commitLoan(loan);
/*     */     }
/*     */     
/*     */ 
/* 120 */     member[4].addFine(5.0F);
/*     */     
/*     */ 
/* 123 */     for (int i = 7; i < 9; i++) {
/* 124 */       ILoan loan = this.loanDAO.createLoan(member[5], book[i]);
/* 125 */       this.loanDAO.commitLoan(loan);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 133 */     Main main = new Main();
/* 134 */     SwingUtilities.invokeLater(new Runnable() {
/*     */       public void run() {
/* 136 */         Main.this.display.setDisplay(new MainPanel(Main.this), "Main Menu");
/* 137 */         Main.this.showGUI();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */