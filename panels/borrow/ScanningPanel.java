/*     */ package library.panels.borrow;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.border.TitledBorder;
/*     */ import library.interfaces.IBorrowUIListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScanningPanel
/*     */   extends ABorrowPanel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private JLabel lblBorrowerId;
/*     */   private JLabel lblBorrowerName;
/*     */   private JLabel lblBorrowerContact;
/*     */   private JLabel lblOverdue;
/*     */   private JLabel lblLoanLimit;
/*     */   private JLabel lblFineLimit;
/*     */   private JButton btnCompleted;
/*     */   private JButton btnCancel;
/*     */   private JTextArea existingLoanListTA;
/*     */   private JLabel lblErrMesg;
/*     */   private JTextArea currentBookTA;
/*     */   private JTextArea pendingLoanListTA;
/*     */   
/*     */   public ScanningPanel(final IBorrowUIListener listener)
/*     */   {
/*  39 */     setLayout(null);
/*  40 */     setBorder(new TitledBorder(null, "Scanning", 4, 2, null, null));
/*  41 */     setBounds(12, 23, 460, 640);
/*     */     
/*  43 */     JPanel panel_2 = new JPanel();
/*  44 */     panel_2.setBorder(new TitledBorder(null, "Current Loan", 4, 2, null, null));
/*  45 */     panel_2.setBounds(10, 289, 434, 242);
/*  46 */     add(panel_2);
/*  47 */     panel_2.setLayout(null);
/*     */     
/*  49 */     JPanel panel_4 = new JPanel();
/*  50 */     panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pending Loan List", 4, 2, null, null));
/*  51 */     panel_4.setBounds(10, 107, 414, 126);
/*  52 */     panel_2.add(panel_4);
/*  53 */     panel_4.setLayout(null);
/*     */     
/*  55 */     JScrollPane pendingLoanListSCL = new JScrollPane();
/*  56 */     pendingLoanListSCL.setBounds(10, 18, 394, 96);
/*  57 */     panel_4.add(pendingLoanListSCL);
/*     */     
/*  59 */     this.pendingLoanListTA = new JTextArea();
/*  60 */     this.pendingLoanListTA.setFont(new Font("Tahoma", 0, 11));
/*  61 */     pendingLoanListSCL.setViewportView(this.pendingLoanListTA);
/*     */     
/*  63 */     JPanel panel_5 = new JPanel();
/*  64 */     panel_5.setBorder(new TitledBorder(null, "Current Book", 4, 2, null, null));
/*  65 */     panel_5.setBounds(10, 18, 414, 89);
/*  66 */     panel_2.add(panel_5);
/*  67 */     panel_5.setLayout(null);
/*     */     
/*  69 */     JScrollPane currentBookSCL = new JScrollPane();
/*  70 */     currentBookSCL.setBounds(10, 18, 394, 60);
/*  71 */     panel_5.add(currentBookSCL);
/*     */     
/*  73 */     this.currentBookTA = new JTextArea();
/*  74 */     this.currentBookTA.setFont(new Font("Tahoma", 0, 11));
/*  75 */     this.currentBookTA.setEditable(false);
/*  76 */     currentBookSCL.setViewportView(this.currentBookTA);
/*     */     
/*  78 */     JPanel panel_3 = new JPanel();
/*  79 */     panel_3.setLayout(null);
/*  80 */     panel_3.setBorder(new TitledBorder(null, "Borrower Details", 4, 2, null, null));
/*  81 */     panel_3.setBounds(10, 25, 434, 252);
/*  82 */     add(panel_3);
/*     */     
/*  84 */     JLabel lbl_11 = new JLabel("Id: ");
/*  85 */     lbl_11.setBounds(12, 20, 20, 14);
/*  86 */     panel_3.add(lbl_11);
/*     */     
/*  88 */     this.lblBorrowerId = new JLabel("123");
/*  89 */     this.lblBorrowerId.setForeground(Color.BLUE);
/*  90 */     this.lblBorrowerId.setBackground(Color.LIGHT_GRAY);
/*  91 */     this.lblBorrowerId.setBounds(32, 20, 46, 14);
/*  92 */     panel_3.add(this.lblBorrowerId);
/*     */     
/*  94 */     JLabel label = new JLabel("Name: ");
/*  95 */     label.setBounds(81, 20, 46, 14);
/*  96 */     panel_3.add(label);
/*     */     
/*  98 */     this.lblBorrowerName = new JLabel("Fred Nurke");
/*  99 */     this.lblBorrowerName.setForeground(Color.BLUE);
/* 100 */     this.lblBorrowerName.setBackground(Color.LIGHT_GRAY);
/* 101 */     this.lblBorrowerName.setBounds(126, 21, 156, 14);
/* 102 */     panel_3.add(this.lblBorrowerName);
/*     */     
/* 104 */     JLabel label_2 = new JLabel("Contact:");
/* 105 */     label_2.setBounds(282, 21, 56, 14);
/* 106 */     panel_3.add(label_2);
/*     */     
/* 108 */     this.lblBorrowerContact = new JLabel("02 63384931");
/* 109 */     this.lblBorrowerContact.setForeground(Color.BLUE);
/* 110 */     this.lblBorrowerContact.setBounds(338, 21, 86, 14);
/* 111 */     panel_3.add(this.lblBorrowerContact);
/*     */     
/* 113 */     JPanel panel_6 = new JPanel();
/* 114 */     panel_6.setLayout(null);
/* 115 */     panel_6.setBorder(new TitledBorder(null, "Existing Loans", 4, 2, null, null));
/* 116 */     panel_6.setBounds(10, 112, 414, 129);
/* 117 */     panel_3.add(panel_6);
/*     */     
/* 119 */     JScrollPane existingLoanListSCL = new JScrollPane();
/* 120 */     existingLoanListSCL.setBounds(10, 22, 394, 96);
/* 121 */     panel_6.add(existingLoanListSCL);
/*     */     
/* 123 */     this.existingLoanListTA = new JTextArea();
/* 124 */     this.existingLoanListTA.setFont(new Font("Tahoma", 0, 11));
/* 125 */     this.existingLoanListTA.setEditable(false);
/* 126 */     this.existingLoanListTA.setBackground(new Color(248, 248, 248));
/* 127 */     existingLoanListSCL.setViewportView(this.existingLoanListTA);
/*     */     
/* 129 */     JPanel panel_7 = new JPanel();
/* 130 */     panel_7.setLayout(null);
/* 131 */     panel_7.setBorder(new TitledBorder(null, "Borrowing Restrictions", 4, 2, null, null));
/* 132 */     panel_7.setBounds(10, 46, 414, 66);
/* 133 */     panel_3.add(panel_7);
/*     */     
/* 135 */     this.lblOverdue = new JLabel("");
/* 136 */     this.lblOverdue.setForeground(Color.RED);
/* 137 */     this.lblOverdue.setFont(new Font("Tahoma", 0, 11));
/* 138 */     this.lblOverdue.setBounds(10, 18, 354, 14);
/* 139 */     panel_7.add(this.lblOverdue);
/*     */     
/* 141 */     this.lblFineLimit = new JLabel("");
/* 142 */     this.lblFineLimit.setForeground(Color.RED);
/* 143 */     this.lblFineLimit.setFont(new Font("Tahoma", 0, 11));
/* 144 */     this.lblFineLimit.setBounds(10, 32, 354, 14);
/* 145 */     panel_7.add(this.lblFineLimit);
/*     */     
/* 147 */     this.lblLoanLimit = new JLabel("");
/* 148 */     this.lblLoanLimit.setForeground(Color.RED);
/* 149 */     this.lblLoanLimit.setFont(new Font("Tahoma", 0, 11));
/* 150 */     this.lblLoanLimit.setBounds(10, 46, 354, 14);
/* 151 */     panel_7.add(this.lblLoanLimit);
/*     */     
/* 153 */     this.btnCompleted = new JButton("Completed");
/* 154 */     this.btnCompleted.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 156 */         listener.scansCompleted();
/*     */       }
/* 158 */     });
/* 159 */     this.btnCompleted.setFont(new Font("Tahoma", 0, 14));
/* 160 */     this.btnCompleted.setBounds(69, 544, 127, 35);
/* 161 */     add(this.btnCompleted);
/*     */     
/* 163 */     this.btnCancel = new JButton("Cancel");
/* 164 */     this.btnCancel.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/* 166 */         listener.cancelled();
/*     */       }
/* 168 */     });
/* 169 */     this.btnCancel.setFont(new Font("Tahoma", 0, 14));
/* 170 */     this.btnCancel.setBounds(271, 544, 127, 35);
/* 171 */     add(this.btnCancel);
/*     */     
/* 173 */     this.lblErrMesg = new JLabel();
/* 174 */     this.lblErrMesg.setForeground(Color.RED);
/* 175 */     this.lblErrMesg.setFont(new Font("Tahoma", 1, 14));
/* 176 */     this.lblErrMesg.setBounds(12, 592, 434, 29);
/* 177 */     add(this.lblErrMesg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void displayMemberDetails(int memberID, String memberName, String memberPhone)
/*     */   {
/* 184 */     this.lblBorrowerId.setText(Integer.valueOf(memberID).toString());
/* 185 */     this.lblBorrowerName.setText(memberName);
/* 186 */     this.lblBorrowerContact.setText(memberPhone);
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayExistingLoan(String loanDetails)
/*     */   {
/* 192 */     insertStringInTA(loanDetails, this.existingLoanListTA, true);
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayOutstandingFineMessage(float amountOwing)
/*     */   {
/* 198 */     this.lblFineLimit.setText(String.format("Borrower has outstanding fines. Amount owing: $%.2f", new Object[] { Float.valueOf(amountOwing) }));
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayScannedBookDetails(String bookDetails)
/*     */   {
/* 204 */     this.currentBookTA.setText(bookDetails);
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayPendingLoan(String loanDetails)
/*     */   {
/* 210 */     this.pendingLoanListTA.setText(loanDetails);
/*     */   }
/*     */   
/*     */   private void insertStringInTA(String string, JTextArea ta, boolean append) {
/* 214 */     StringBuilder bld = new StringBuilder();
/* 215 */     if (append) {
/* 216 */       bld.append(ta.getText());
/*     */     }
/* 218 */     if (bld.length() > 0) {
/* 219 */       bld.append("\n\n");
/*     */     }
/* 221 */     bld.append(string);
/* 222 */     ta.setText(bld.toString());
/* 223 */     ta.setCaretPosition(0);
/*     */   }
/*     */   
/*     */   public void displayErrorMessage(String errorMesg)
/*     */   {
/* 228 */     this.lblErrMesg.setText(errorMesg);
/*     */   }
/*     */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\panels\borrow\ScanningPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */