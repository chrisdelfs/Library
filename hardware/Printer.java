/*    */ package library.hardware;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTextArea;
/*    */ import javax.swing.border.TitledBorder;
/*    */ import library.interfaces.hardware.IPrinter;
/*    */ 
/*    */ public class Printer extends JFrame implements IPrinter
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private JTextArea textArea;
/*    */   
/*    */   public Printer()
/*    */   {
/* 18 */     setBounds(50, 450, 400, 350);
/* 19 */     setResizable(false);
/* 20 */     setTitle("Printer");
/* 21 */     setDefaultCloseOperation(3);
/*    */     
/*    */ 
/* 24 */     JPanel panel = new JPanel();
/* 25 */     panel.setBorder(new TitledBorder(null, "Printer", 4, 2, null, null));
/* 26 */     panel.setBounds(10, 20, 400, 280);
/* 27 */     getContentPane().add(panel);
/* 28 */     panel.setLayout(null);
/*    */     
/*    */ 
/* 31 */     this.textArea = new JTextArea();
/* 32 */     this.textArea.setEditable(false);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 37 */     JScrollPane scrollPane = new JScrollPane(this.textArea);
/* 38 */     scrollPane.setBounds(10, 20, 375, 280);
/* 39 */     panel.add(scrollPane);
/*    */   }
/*    */   
/*    */   public void print(String printData)
/*    */   {
/* 44 */     this.textArea.setText(printData);
/* 45 */     this.textArea.setCaretPosition(this.textArea.getLineCount());
/*    */   }
/*    */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\hardware\Printer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */