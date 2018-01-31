/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random.password.generator;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.LocalDateTime;
/**
 *
 * @author Shivang Srivastava
 */
public class generator extends javax.swing.JFrame {

    /**
     * Creates new form generator
     */
    public generator() {
        initComponents();
    }
    int counter = 1;
    public int pseudo_random()
    {
        counter ++;
        long val;
        int sec = LocalDateTime.now().getSecond() ;
        int min = LocalDateTime.now().getMinute() ;
        int hour = LocalDateTime.now().getHour() ;
        int date = LocalDateTime.now().getDayOfMonth() ;
        int month = LocalDateTime.now().getMonthValue() ;
        int year = LocalDateTime.now().getYear() ;
        
        Double t;
        val = hour * 19 + min * 170 + sec * 13 ;
        val = val + counter;
        int v = (sec * year) + (month * min) + (hour * date);
        counter = counter + v;
        if(val % 2 == 0)
            counter = counter * 10;
        else
            counter = counter / 10;
        
        switch(v % 7)
        {
            case 0: t = (Math.sqrt(val)) ;
                    val = t.intValue();
            case 1: val = val * month ;
            case 2: t = Math.exp(val);
                    t = val * t ;
                    val = t.intValue() ;
            case 3: val = val - date * min + sec * hour ;
            case 4: t = Math.pow(val%year + month, year%date + month * 2) ;
                    val = t.intValue();
            case 5: val = val - 59 + date + sec - hour * year + month * min ;
            default: val = val * val ;
        }
        sec = LocalDateTime.now().getSecond() ;
        switch(sec % 5)
        {
            case 0: v = v * 100 + counter;
                counter = counter + sec;
            case 1: v = v / 10 + counter;
                counter = counter + sec;
            case 2: v = v * 100 + counter;
                counter = counter + sec;
            case 3: v = v * 10 + counter;
                counter = counter + sec;
            default: v = v / 10 + counter;
                counter = counter + sec;
        }
        sec = LocalDateTime.now().getSecond() ;
        switch(sec % 5)
        {
            case 0: v = v * 10 + counter;
                counter = counter + sec;
            case 1: v = v / 10 + counter;
                counter = counter + sec;
            case 2: v = v * 10 + counter;
                counter = counter + sec;
            case 3: v = v + counter;
                counter = counter + sec;
            default: v = v / 10 + counter;
                counter = counter + sec;
        }
        counter = Math.abs(counter);
        v = (int) v;
        return Math.abs(v);
    }

    public char lower_char()
    {
        char c;
        int i = pseudo_random() % 25;
        c = (char)(i+'a') ;
        return c;
    }
    
    public char upper_char()
    {
        char c;
        int i = pseudo_random() % 25;
        c = (char)(i+'A') ;
        return c;
    }
    
    public char digit_char()
    {
        char c;
        int i = pseudo_random() % 10;
        c = (char)(i+'0') ;
        return c;
    }
    
    public char special_char()
    {
        char c;
        int n = pseudo_random() % 4;
        int i=0;
        switch(n)
        {
            case 0: i = pseudo_random() % 14;
                    i = i + 33;
                break;
            case 1: i = pseudo_random() % 6;
                    i = i + 58;
                break;
            case 2: i = pseudo_random() % 5;
                    i = i + 91;
                break;
            case 3: i = pseudo_random() % 3;
                    i = i + 123;
        }
        c = (char)(i) ;
        return c;
    }
    
    public String password()
    {
        String s="";
        int length = pseudo_random();
        length = length%21 + 12;
        int lc = 0, uc = 0, dg = 0, sp = 0;
        s = s + lower_char();
        lc++;
        for(int i=2; i<length ; i++)
        {
            int n= pseudo_random();
            System.out.println(n+" " + counter);
            n = n % 4 +1;
            if(n == 1)
            {
                s = s + lower_char();
                lc++;
            }
            else if( n == 2)
            {
                s = s + upper_char();
                uc++;
            }
            else if(n == 3)
            {
                s = s + digit_char();
                dg++;
            }
            else
            {
                s = s +special_char();
                sp++;
            }
        }
        s = s + upper_char();
        uc++;
        /*
        if(lc<2)
        {
            int n = pseudo_random() % (length-1) + 1;
            
        }
          */      
        return s;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        textfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textfield.setEditable(false);
        textfield.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Random Password Generator");

        jButton2.setText("Copy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(174, 174, 174))
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        textfield.setText(password());
    }//GEN-LAST:event_jButton1ActionPerformed

    private static Clipboard getSystemClipboard()
    {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Clipboard systemClipboard = defaultToolkit.getSystemClipboard();

        return systemClipboard;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Clipboard clipboard = getSystemClipboard();
        clipboard.setContents(new StringSelection(textfield.getText()), null);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new generator().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField textfield;
    // End of variables declaration//GEN-END:variables
}
