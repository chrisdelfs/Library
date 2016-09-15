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
/*     */ public class RestrictedPanel
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
/*     */   
/*     */   public RestrictedPanel(final IBorrowUIListener listener)
/*     */   {
/*  37 */     setLayout(null);
/*  38 */     setBorder(new TitledBorder(null, "Scanning", 4, 2, null, null));
/*  39 */     setBounds(12, 23, 460, 640);
/*     */     
/*  41 */     JPanel panel_2 = new JPanel();
/*  42 */     panel_2.setBorder(new TitledBorder(null, "Current Loan", 4, 2, null, null));
/*  43 */     panel_2.setBounds(10, 289, 434, 242);
/*  44 */     add(panel_2);
/*  45 */     panel_2.setLayout(null);
/*     */     
/*  47 */     JPanel panel_4 = new JPanel();
/*  48 */     panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pending Loan List", 4, 2, null, null));
/*  49 */     panel_4.setBounds(10, 107, 414, 126);
/*  50 */     panel_2.add(panel_4);
/*  51 */     panel_4.setLayout(null);
/*     */     
/*  53 */     JScrollPane pendingLoanListSCL = new JScrollPane();
/*  54 */     pendingLoanListSCL.setBounds(10, 18, 394, 96);
/*  55 */     panel_4.add(pendingLoanListSCL);
/*     */     
/*  57 */     JTextArea pendingLoanListTA = new JTextArea();
/*  58 */     pendingLoanListTA.setFont(new Font("Tahoma", 0, 11));
/*  59 */     pendingLoanListSCL.setViewportView(pendingLoanListTA);
/*     */     
/*  61 */     JPanel panel_5 = new JPanel();
/*  62 */     panel_5.setBorder(new TitledBorder(null, "Current Book", 4, 2, null, null));
/*  63 */     panel_5.setBounds(10, 18, 414, 89);
/*  64 */     panel_2.add(panel_5);
/*  65 */     panel_5.setLayout(null);
/*     */     
/*  67 */     JScrollPane currentBookSCL = new JScrollPane();
/*  68 */     currentBookSCL.setBounds(10, 18, 394, 60);
/*  69 */     panel_5.add(currentBookSCL);
/*     */     
/*  71 */     JTextArea currentBookTA = new JTextArea();
/*  72 */     currentBookTA.setFont(new Font("Tahoma", 0, 11));
/*  73 */     currentBookTA.setEditable(false);
/*  74 */     currentBookSCL.setViewportView(currentBookTA);
/*     */     
/*  76 */     JPanel panel_3 = new JPanel();
/*  77 */     panel_3.setLayout(null);
/*  78 */     panel_3.setBorder(new TitledBorder(null, "Borrower Details", 4, 2, null, null));
/*  79 */     panel_3.setBounds(10, 25, 434, 252);
/*  80 */     add(panel_3);
/*     */     
/*  82 */     JLabel lbl_11 = new JLabel("Id: ");
/*  83 */     lbl_11.setBounds(12, 20, 20, 14);
/*  84 */     panel_3.add(lbl_11);
/*     */     
/*  86 */     this.lblBorrowerId = new JLabel("123");
/*  87 */     this.lblBorrowerId.setForeground(Color.BLUE);
/*  88 */     this.lblBorrowerId.setBackground(Color.LIGHT_GRAY);
/*  89 */     this.lblBorrowerId.setBounds(32, 20, 46, 14);
/*  90 */     panel_3.add(this.lblBorrowerId);
/*     */     
/*  92 */     JLabel label = new JLabel("Name: ");
/*  93 */     label.setBounds(81, 20, 46, 14);
/*  94 */     panel_3.add(label);
/*     */     
/*  96 */     this.lblBorrowerName = new JLabel("Fred Nurke");
/*  97 */     this.lblBorrowerName.setForeground(Color.BLUE);
/*  98 */     this.lblBorrowerName.setBackground(Color.LIGHT_GRAY);
/*  99 */     this.lblBorrowerName.setBounds(126, 21, 156, 14);
/* 100 */     panel_3.add(this.lblBorrowerName);
/*     */     
/* 102 */     JLabel label_2 = new JLabel("Contact:");
/* 103 */     label_2.setBounds(282, 21, 56, 14);
/* 104 */     panel_3.add(label_2);
/*     */     
/* 106 */     this.lblBorrowerContact = new JLabel("02 63384931");
/* 107 */     this.lblBorrowerContact.setForeground(Color.BLUE);
/* 108 */     this.lblBorrowerContact.setBounds(338, 21, 86, 14);
/* 109 */     panel_3.add(this.lblBorrowerContact);
/*     */     
/* 111 */     JPanel panel_6 = new JPanel();
/* 112 */     panel_6.setLayout(null);
/* 113 */     panel_6.setBorder(new TitledBorder(null, "Existing Loans", 4, 2, null, null));
/* 114 */     panel_6.setBounds(10, 112, 414, 129);
/* 115 */     panel_3.add(panel_6);
/*     */     
/* 117 */     JScrollPane existingLoanListSCL = new JScrollPane();
/* 118 */     existingLoanListSCL.setBounds(10, 22, 394, 96);
/* 119 */     panel_6.add(existingLoanListSCL);
/*     */     
/* 121 */     this.existingLoanListTA = new JTextArea();
/* 122 */     this.existingLoanListTA.setFont(new Font("Tahoma", 0, 11));
/* 123 */     this.existingLoanListTA.setEditable(false);
/* 124 */     this.existingLoanListTA.setBackground(new Color(248, 248, 248));
/* 125 */     existingLoanListSCL.setViewportView(this.existingLoanListTA);
/*     */     
/* 127 */     JPanel panel_7 = new JPanel();
/* 128 */     panel_7.setLayout(null);
/* 129 */     panel_7.setBorder(new TitledBorder(null, "Borrowing Restrictions", 4, 2, null, null));
/* 130 */     panel_7.setBounds(10, 46, 414, 66);
/* 131 */     panel_3.add(panel_7);
/*     */     
/* 133 */     this.lblOverdue = new JLabel("");
/* 134 */     this.lblOverdue.setForeground(Color.RED);
/* 135 */     this.lblOverdue.setFont(new Font("Tahoma", 0, 11));
/* 136 */     this.lblOverdue.setBounds(10, 18, 354, 14);
/* 137 */     panel_7.add(this.lblOverdue);
/*     */     
/* 139 */     this.lblFineLimit = new JLabel("");
/* 140 */     this.lblFineLimit.setForeground(Color.RED);
/* 141 */     this.lblFineLimit.setFont(new Font("Tahoma", 0, 11));
/* 142 */     this.lblFineLimit.setBounds(10, 32, 354, 14);
/* 143 */     panel_7.add(this.lblFineLimit);
/*     */     
/* 145 */     this.lblLoanLimit = new JLabel("");
/* 146 */     this.lblLoanLimit.setForeground(Color.RED);
/* 147 */     this.lblLoanLimit.setFont(new Font("Tahoma", 0, 11));
/* 148 */     this.lblLoanLimit.setBounds(10, 46, 354, 14);
/* 149 */     panel_7.add(this.lblLoanLimit);
/*     */     
/* 151 */     this.btnCompleted = new JButton("Completed");
/* 152 */     this.btnCompleted.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 154 */         listener.scansCompleted();
/*     */       }
/* 156 */     });
/* 157 */     this.btnCompleted.setFont(new Font("Tahoma", 0, 14));
/* 158 */     this.btnCompleted.setBounds(69, 544, 127, 35);
/* 159 */     add(this.btnCompleted);
/* 160 */     this.btnCompleted.setEnabled(false);
/*     */     
/* 162 */     this.btnCancel = new JButton("Cancel");
/* 163 */     this.btnCancel.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/* 165 */         listener.cancelled();
/*     */       }
/* 167 */     });
/* 168 */     this.btnCancel.setFont(new Font("Tahoma", 0, 14));
/* 169 */     this.btnCancel.setBounds(271, 544, 127, 35);
/* 170 */     add(this.btnCancel);
/*     */     
/* 172 */     this.lblErrMesg = new JLabel();
/* 173 */     this.lblErrMesg.setForeground(Color.RED);
/* 174 */     this.lblErrMesg.setFont(new Font("Tahoma", 1, 14));
/* 175 */     this.lblErrMesg.setBounds(12, 592, 434, 29);
/* 176 */     add(this.lblErrMesg);
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayMemberDetails(int memberID, String memberName, String memberPhone)
/*     */   {
/* 182 */     this.lblBorrowerId.setText(Integer.valueOf(memberID).toString());
/* 183 */     this.lblBorrowerName.setText(memberName);
/* 184 */     this.lblBorrowerContact.setText(memberPhone);
/*     */   }
/*     */   
/*     */   public void displayOverDueMessage()
/*     */   {
/* 189 */     this.lblOverdue.setText("Borrower has overdue loans");
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayAtLoanLimitMessage()
/*     */   {
/* 195 */     this.lblLoanLimit.setText("Borrower has reached maximum number of borrowed items");
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayOutstandingFineMessage(float amountOwing)
/*     */   {
/* 201 */     this.lblFineLimit.setText(String.format("Borrower has outstanding fines. Amount owing: $%.2f", new Object[] { Float.valueOf(amountOwing) }));
/*     */   }
/*     */   
/*     */ 
/*     */   public void displayOverFineLimitMessage(float amountOwing)
/*     */   {
/* 207 */     this.lblFineLimit.setText(String.format("Borrower has exceeded fine limit. Amount owing: $%.2f", new Object[] { Float.valueOf(amountOwing) }));
/*     */   }
/*     */   
/*     */   public void displayExistingLoan(String loanDetails)
/*     */   {
/* 212 */     this.existingLoanListTA.setText(loanDetails);
/* 213 */     this.existingLoanListTA.setCaretPosition(0);
/*     */   }
/*     */   
/*     */   public void displayErrorMessage(String errorMesg)
/*     */   {
/* 218 */     this.lblErrMesg.setText(errorMesg);
/*     */   }
/*     */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\panels\borrow\RestrictedPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */