/*    */ package library.hardware;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Container;
/*    */ import java.awt.Font;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.awt.event.KeyAdapter;
/*    */ import java.awt.event.KeyEvent;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextField;
/*    */ import javax.swing.border.TitledBorder;
/*    */ import library.interfaces.hardware.ICardReader;
/*    */ import library.interfaces.hardware.ICardReaderListener;
/*    */ 
/*    */ public class CardReader extends JFrame implements ICardReader
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private JTextField textField;
/*    */   private JButton btnReadCard;
/*    */   private ICardReaderListener listener;
/*    */   
/*    */   public CardReader()
/*    */   {
/* 28 */     setTitle("Card Reader");
/* 29 */     setBounds(50, 50, 400, 200);
/* 30 */     setDefaultCloseOperation(3);
/*    */     
/* 32 */     JPanel panel = new JPanel();
/* 33 */     panel.setBorder(new TitledBorder(null, "Card Reader", 4, 2, null, null));
/* 34 */     panel.setBounds(10, 10, 400, 200);
/* 35 */     getContentPane().add(panel);
/* 36 */     panel.setLayout(null);
/*    */     
/* 38 */     final JLabel lblErrorMesg = new JLabel("");
/* 39 */     lblErrorMesg.setForeground(Color.RED);
/* 40 */     lblErrorMesg.setBounds(12, 21, 358, 16);
/* 41 */     panel.add(lblErrorMesg);
/*    */     
/* 43 */     JLabel lblNewLabel = new JLabel("Enter Member Id:");
/* 44 */     lblNewLabel.setBounds(30, 50, 150, 25);
/* 45 */     panel.add(lblNewLabel);
/* 46 */     lblNewLabel.setFont(new Font("Tahoma", 0, 14));
/*    */     
/* 48 */     this.textField = new JTextField();
/* 49 */     this.textField.addKeyListener(new KeyAdapter()
/*    */     {
/*    */       public void keyPressed(KeyEvent arg0) {
/* 52 */         lblErrorMesg.setText("");
/*    */       }
/* 54 */     });
/* 55 */     this.textField.setBounds(190, 50, 150, 25);
/* 56 */     panel.add(this.textField);
/* 57 */     this.textField.setFont(new Font("Tahoma", 0, 14));
/* 58 */     this.textField.setColumns(10);
/* 59 */     this.textField.setEditable(false);
/*    */     
/* 61 */     this.btnReadCard = new JButton("Swipe Card");
/* 62 */     this.btnReadCard.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent arg0) {
/* 64 */         if (CardReader.this.listener == null) {
/* 65 */           throw new RuntimeException("CardReader: listener is null");
/*    */         }
/* 67 */         String text = CardReader.this.textField.getText();
/*    */         try {
/* 69 */           int memberId = new Integer(text).intValue();
/* 70 */           if (memberId <= 0) {
/* 71 */             throw new NumberFormatException();
/*    */           }
/* 73 */           CardReader.this.listener.cardSwiped(memberId);
/*    */         }
/*    */         catch (NumberFormatException e)
/*    */         {
/* 77 */           lblErrorMesg.setText("Member Id must be a positive intger");
/*    */         }
/* 79 */         CardReader.this.textField.setText("");
/*    */       }
/* 81 */     });
/* 82 */     this.btnReadCard.setFont(new Font("Tahoma", 0, 14));
/* 83 */     this.btnReadCard.setBounds(121, 88, 150, 40);
/* 84 */     this.btnReadCard.setEnabled(false);
/* 85 */     panel.add(this.btnReadCard);
/*    */   }
/*    */   
/*    */ 
/*    */   public void setEnabled(boolean enabled)
/*    */   {
/* 91 */     this.btnReadCard.setEnabled(enabled);
/* 92 */     this.textField.setEditable(enabled);
/*    */   }
/*    */   
/*    */ 
/*    */   public void addListener(ICardReaderListener listener)
/*    */   {
/* 98 */     this.listener = listener;
/*    */   }
/*    */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\hardware\CardReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */