/*    */ package library.panels.borrow;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.border.TitledBorder;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CancelledPanel
/*    */   extends ABorrowPanel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public CancelledPanel()
/*    */   {
/* 16 */     setLayout(null);
/* 17 */     setBorder(new TitledBorder(null, "Cancelled", 4, 2, null, null));
/* 18 */     setBounds(12, 23, 460, 640);
/*    */     
/* 20 */     JLabel lblCancelled = new JLabel("Cancelled");
/* 21 */     lblCancelled.setHorizontalAlignment(0);
/* 22 */     lblCancelled.setFont(new Font("Tahoma", 0, 42));
/* 23 */     lblCancelled.setBounds(12, 187, 436, 78);
/* 24 */     add(lblCancelled);
/*    */   }
/*    */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\panels\borrow\CancelledPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */