
package sk.upjs.ics.traveltracker;

import java.util.*;
import javax.swing.JComboBox;


public class PridatForm extends javax.swing.JFrame {
    
     VyletDao vyletDao = new MySQLVyletDao();
  
    public PridatForm() {
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        krajinaTextField = new javax.swing.JTextField();
        mestoTextField = new javax.swing.JTextField();
        destinaciaTextField = new javax.swing.JTextField();
        krajinaLabel = new javax.swing.JLabel();
        mestoLabel = new javax.swing.JLabel();
        pamiatkaLabel = new javax.swing.JLabel();
        PridatButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        krajinaLabel.setText("krajina");

        mestoLabel.setText("mesto");

        pamiatkaLabel.setText("pamiatka");

        PridatButton.setText("Pridať");
        PridatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PridatButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PridatButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mestoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(destinaciaTextField)
                            .addComponent(krajinaTextField))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(krajinaLabel)
                            .addComponent(mestoLabel)
                            .addComponent(pamiatkaLabel))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(krajinaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(krajinaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mestoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mestoLabel))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinaciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pamiatkaLabel))
                .addGap(18, 18, 18)
                .addComponent(PridatButton)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PridatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PridatButtonActionPerformed
        Vylet vylet = new Vylet();
        vylet.setKrajina(krajinaTextField.getText());
        vylet.setMesto(mestoTextField.getText());
        vylet.setPrirodna_a_kulturna_pamiatka(destinaciaTextField.getText());
        
        vyletDao.pridat(vylet);
    }//GEN-LAST:event_PridatButtonActionPerformed
   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PridatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PridatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PridatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PridatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PridatForm().setVisible(true);
            }
        });
    }
    
   // JComboBox krajinaComboBox = new JComboBox<String>();
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PridatButton;
    private javax.swing.JTextField destinaciaTextField;
    private javax.swing.JLabel krajinaLabel;
    private javax.swing.JTextField krajinaTextField;
    private javax.swing.JLabel mestoLabel;
    private javax.swing.JTextField mestoTextField;
    private javax.swing.JLabel pamiatkaLabel;
    // End of variables declaration//GEN-END:variables
}
