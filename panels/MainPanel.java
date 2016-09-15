/*    */ package library.panels;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.border.TitledBorder;
/*    */ import library.interfaces.IMainListener;
/*    */ 
/*    */ 
/*    */ public class MainPanel
/*    */   extends JPanel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public MainPanel(final IMainListener listener)
/*    */   {
/* 20 */     setBorder(new TitledBorder(null, "Main Menu", 4, 2, null, null));
/* 21 */     setBounds(500, 50, 470, 680);
/* 22 */     setLayout(null);
/*    */     
/* 24 */     JLabel lblNewLabel = new JLabel("Backwoods Regional Library");
/* 25 */     lblNewLabel.setHorizontalAlignment(0);
/* 26 */     lblNewLabel.setFont(new Font("Tahoma", 0, 26));
/* 27 */     lblNewLabel.setBounds(12, 27, 446, 32);
/* 28 */     add(lblNewLabel);
/*    */     
/* 30 */     JLabel lblSelfServiceSystem = new JLabel("Self Service System");
/* 31 */     lblSelfServiceSystem.setHorizontalAlignment(0);
/* 32 */     lblSelfServiceSystem.setFont(new Font("Tahoma", 0, 26));
/* 33 */     lblSelfServiceSystem.setBounds(12, 61, 446, 32);
/* 34 */     add(lblSelfServiceSystem);
/*    */     
/* 36 */     JButton btnBorrowBooks = new JButton("Borrow Books");
/* 37 */     btnBorrowBooks.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent arg0) {
/* 39 */         listener.borrowBooks();
/*    */       }
/* 41 */     });
/* 42 */     btnBorrowBooks.setFont(new Font("Tahoma", 0, 14));
/* 43 */     btnBorrowBooks.setBounds(141, 138, 155, 37);
/* 44 */     add(btnBorrowBooks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\panels\MainPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */