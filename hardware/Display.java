/*    */ package library.hardware;
/*    */ 
/*    */ import java.awt.CardLayout;
/*    */ import java.awt.Container;
/*    */ import java.io.PrintStream;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ import library.interfaces.hardware.IDisplay;
/*    */ 
/*    */ public class Display extends JFrame implements IDisplay
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private JPanel current;
/*    */   
/*    */   public Display()
/*    */   {
/* 17 */     setTitle("Display");
/* 18 */     setBounds(500, 50, 470, 680);
/* 19 */     setDefaultCloseOperation(3);
/* 20 */     getContentPane().setLayout(new CardLayout(0, 0));
/*    */   }
/*    */   
/*    */ 
/*    */   public JPanel getDisplay()
/*    */   {
/* 26 */     return this.current;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setDisplay(JPanel panel, String id)
/*    */   {
/* 32 */     getContentPane().add(panel, id);
/* 33 */     CardLayout cardLayout = (CardLayout)getContentPane().getLayout();
/* 34 */     cardLayout.show(getContentPane(), id);
/* 35 */     if (this.current != null) {
/* 36 */       System.out.println("Display.setDisplay: removing current");
/* 37 */       cardLayout.removeLayoutComponent(this.current);
/*    */     }
/* 39 */     this.current = panel;
/*    */   }
/*    */ }


/* Location:              C:\Users\Chris\Documents\NetBeansProjects\Asg3\ITC515_NewLibrary_Java.jar!\library\hardware\Display.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */