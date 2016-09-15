/*    */ package library.panels.borrow;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.border.TitledBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CompletedPanel
/*    */   extends ABorrowPanel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public CompletedPanel()
/*    */   {
/* 16 */     setLayout(null);
/* 17 */     setBorder(new TitledBorder(null, "Completed", 4, 2, null, null));
/* 18 */     setBounds(12, 23, 460, 640);
/*    */     
/*    */ 
/* 21 */     JLabel lblCancelled = new JLabel("Borrowing Completed");
/* 22 */     lblCancelled.setHorizontalAlignment(0);
/* 23 */     lblCancelled.setFont(new Font("Tahoma", 0, 36));
/* 24 */     lblCancelled.setBounds(12, 181, 436, 78);
/* 25 */     add(lblCancelled);
/*    */   }
/*    */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\panels\borrow\CompletedPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */