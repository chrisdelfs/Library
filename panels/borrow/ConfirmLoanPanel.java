/*    */ package library.panels.borrow;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTextArea;
/*    */ import javax.swing.border.TitledBorder;
/*    */ import library.interfaces.IBorrowUIListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfirmLoanPanel
/*    */   extends ABorrowPanel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private JTextArea loanListTA;
/*    */   
/*    */   public ConfirmLoanPanel(final IBorrowUIListener listener)
/*    */   {
/* 24 */     setLayout(null);
/* 25 */     setBorder(new TitledBorder(null, "Confirm Loans", 4, 2, null, null));
/* 26 */     setBounds(12, 23, 460, 640);
/*    */     
/* 28 */     JPanel panel = new JPanel();
/* 29 */     panel.setBorder(new TitledBorder(null, "Current Loan List", 4, 2, null, null));
/* 30 */     panel.setBounds(12, 24, 415, 496);
/* 31 */     add(panel);
/* 32 */     panel.setLayout(null);
/*    */     
/* 34 */     JScrollPane scrollPane = new JScrollPane();
/* 35 */     scrollPane.setBounds(10, 20, 395, 463);
/* 36 */     panel.add(scrollPane);
/*    */     
/* 38 */     this.loanListTA = new JTextArea();
/* 39 */     this.loanListTA.setEditable(false);
/* 40 */     scrollPane.setViewportView(this.loanListTA);
/*    */     
/* 42 */     JButton btnReject = new JButton("Reject");
/* 43 */     btnReject.setFont(new Font("Tahoma", 0, 14));
/* 44 */     btnReject.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent arg0) {
/* 46 */         listener.loansRejected();
/*    */       }
/* 48 */     });
/* 49 */     btnReject.setBounds(173, 533, 115, 35);
/* 50 */     add(btnReject);
/*    */     
/* 52 */     JButton btnConfirm = new JButton("Confirm");
/* 53 */     btnConfirm.setFont(new Font("Tahoma", 0, 14));
/* 54 */     btnConfirm.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 56 */         listener.loansConfirmed();
/*    */       }
/* 58 */     });
/* 59 */     btnConfirm.setBounds(30, 533, 115, 35);
/* 60 */     add(btnConfirm);
/*    */     
/* 62 */     JButton button = new JButton("Cancel");
/* 63 */     button.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent arg0) {
/* 65 */         listener.cancelled();
/*    */       }
/* 67 */     });
/* 68 */     button.setFont(new Font("Tahoma", 0, 14));
/* 69 */     button.setBounds(312, 533, 115, 35);
/* 70 */     add(button);
/*    */   }
/*    */   
/*    */ 
/*    */   public void displayConfirmingLoan(String loanDetails)
/*    */   {
/* 76 */     this.loanListTA.setText(loanDetails);
/* 77 */     this.loanListTA.setCaretPosition(0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\panels\borrow\ConfirmLoanPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */