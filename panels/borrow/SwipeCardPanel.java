/*    */ package library.panels.borrow;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.UIManager;
/*    */ import javax.swing.border.TitledBorder;
/*    */ import library.interfaces.IBorrowUIListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SwipeCardPanel
/*    */   extends ABorrowPanel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private JLabel lblErrMesg;
/*    */   
/*    */   public SwipeCardPanel(final IBorrowUIListener listener)
/*    */   {
/* 26 */     setLayout(null);
/* 27 */     setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Borrow Book - Initialized", 4, 2, null, new Color(0, 0, 0)));
/* 28 */     setBounds(12, 23, 460, 640);
/*    */     
/*    */ 
/* 31 */     JLabel lblSwipeCard = new JLabel("Swipe Card Please");
/* 32 */     lblSwipeCard.setHorizontalAlignment(0);
/* 33 */     lblSwipeCard.setFont(new Font("Tahoma", 0, 42));
/* 34 */     lblSwipeCard.setBounds(12, 181, 436, 78);
/* 35 */     add(lblSwipeCard);
/*    */     
/* 37 */     JButton btnCancel = new JButton("Cancel");
/* 38 */     btnCancel.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent arg0) {
/* 40 */         listener.cancelled();
/*    */       }
/* 42 */     });
/* 43 */     btnCancel.setFont(new Font("Tahoma", 0, 14));
/* 44 */     btnCancel.setBounds(170, 320, 127, 35);
/* 45 */     add(btnCancel);
/*    */     
/* 47 */     this.lblErrMesg = new JLabel();
/* 48 */     this.lblErrMesg.setForeground(Color.RED);
/* 49 */     this.lblErrMesg.setFont(new Font("Tahoma", 1, 14));
/* 50 */     this.lblErrMesg.setBounds(12, 592, 434, 29);
/* 51 */     add(this.lblErrMesg);
/*    */   }
/*    */   
/*    */ 
/*    */   public void displayErrorMessage(String errorMesg)
/*    */   {
/* 57 */     this.lblErrMesg.setText(errorMesg);
/*    */   }
/*    */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\panels\borrow\SwipeCardPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */