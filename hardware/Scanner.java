/*     */ package library.hardware;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.border.TitledBorder;
/*     */ import library.interfaces.hardware.IScanner;
/*     */ import library.interfaces.hardware.IScannerListener;
/*     */ 
/*     */ public class Scanner
/*     */   extends JFrame
/*     */   implements IScanner
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private JTextField textField;
/*     */   private JButton btnScan;
/*     */   private IScannerListener listener;
/*     */   
/*     */   public Scanner()
/*     */   {
/*  30 */     setTitle("Scanner");
/*  31 */     setBounds(50, 250, 400, 200);
/*  32 */     setDefaultCloseOperation(3);
/*     */     
/*     */ 
/*  35 */     JPanel panel = new JPanel();
/*  36 */     panel.setBorder(new TitledBorder(null, "Scanner", 4, 2, null, null));
/*  37 */     panel.setBounds(10, 10, 400, 200);
/*  38 */     getContentPane().add(panel);
/*  39 */     panel.setLayout(null);
/*     */     
/*  41 */     final JLabel lblErrorMesg = new JLabel("");
/*  42 */     lblErrorMesg.setForeground(Color.RED);
/*  43 */     lblErrorMesg.setBounds(12, 21, 358, 16);
/*  44 */     panel.add(lblErrorMesg);
/*     */     
/*  46 */     JLabel lblNewLabel = new JLabel("Enter Book Barcode: ");
/*  47 */     lblNewLabel.setFont(new Font("Tahoma", 0, 14));
/*  48 */     lblNewLabel.setBounds(30, 50, 150, 25);
/*  49 */     panel.add(lblNewLabel);
/*     */     
/*  51 */     this.textField = new JTextField();
/*  52 */     this.textField.addKeyListener(new KeyAdapter()
/*     */     {
/*     */       public void keyPressed(KeyEvent arg0) {
/*  55 */         lblErrorMesg.setText("");
/*     */       }
/*  57 */     });
/*  58 */     this.textField.setBounds(190, 50, 150, 25);
/*  59 */     panel.add(this.textField);
/*  60 */     this.textField.setColumns(10);
/*  61 */     this.textField.setEditable(false);
/*     */     
/*  63 */     this.btnScan = new JButton("Scan Book Barcode");
/*  64 */     this.btnScan.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/*  66 */         if (Scanner.this.listener == null) {
/*  67 */           throw new RuntimeException("Scanner: listener is null");
/*     */         }
/*  69 */         String text = Scanner.this.textField.getText();
/*     */         try {
/*  71 */           int barcode = new Integer(text).intValue();
/*  72 */           if (barcode <= 0) {
/*  73 */             throw new NumberFormatException();
/*     */           }
/*  75 */           Scanner.this.listener.bookScanned(barcode);
/*     */         }
/*     */         catch (NumberFormatException e)
/*     */         {
/*  79 */           lblErrorMesg.setText("Book barcode must be a positive intger");
/*     */         }
/*  81 */         Scanner.this.textField.setText("");
/*     */       }
/*  83 */     });
/*  84 */     this.btnScan.setFont(new Font("Tahoma", 0, 14));
/*  85 */     this.btnScan.setBounds(85, 88, 215, 39);
/*  86 */     panel.add(this.btnScan);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEnabled(boolean enabled)
/*     */   {
/*  93 */     this.btnScan.setEnabled(enabled);
/*  94 */     this.textField.setEditable(enabled);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addListener(IScannerListener listener)
/*     */   {
/* 100 */     this.listener = listener;
/*     */   }
/*     */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\hardware\Scanner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */