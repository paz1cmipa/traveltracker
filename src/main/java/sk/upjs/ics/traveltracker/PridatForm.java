package sk.upjs.ics.traveltracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class PridatForm extends javax.swing.JDialog {

     VyletDao vyletDao = VyletDaoFactory.INSTANCE.getVyletDao();
    
    public PridatForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
          setLocationRelativeTo(null);
        krajinaComboBox.setEditable(true);
        krajinaComboBox.addActionListener(krajinaComboBox);
        AutoCompleteDecorator.decorate(krajinaComboBox);
        List<String> zoznamKrajin = dajVsetkyKrajiny();
        String krajina;
        krajinaComboBox.addItem(" ");
        for(int i=0; i<zoznamKrajin.size(); i++){
            krajina = zoznamKrajin.get(i);
            krajinaComboBox.addItem(krajina);
        }
       
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KrajinaLabel = new javax.swing.JLabel();
        krajinaComboBox = new javax.swing.JComboBox();
        mestoLabel = new javax.swing.JLabel();
        mestoTextField = new javax.swing.JTextField();
        pamiatkaLabel = new javax.swing.JLabel();
        pamiatkaTextField = new javax.swing.JTextField();
        datumLabel = new javax.swing.JLabel();
        datumDatePicker = new org.jdesktop.swingx.JXDatePicker();
        stornoButton = new javax.swing.JButton();
        pridatButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        KrajinaLabel.setText("Krajina:");

        mestoLabel.setText("Mesto:");

        pamiatkaLabel.setText("Pamiatka:");

        datumLabel.setText("Dátum:");

        stornoButton.setText("Storno");
        stornoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stornoButtonActionPerformed(evt);
            }
        });

        pridatButton.setText("Pridať");
        pridatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KrajinaLabel)
                    .addComponent(mestoLabel)
                    .addComponent(pamiatkaLabel)
                    .addComponent(datumLabel))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(krajinaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mestoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(pridatButton)
                            .addGap(18, 18, 18)
                            .addComponent(stornoButton))
                        .addComponent(datumDatePicker, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pamiatkaTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KrajinaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(krajinaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mestoLabel)
                    .addComponent(mestoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pamiatkaLabel)
                    .addComponent(pamiatkaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datumLabel)
                    .addComponent(datumDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pridatButton)
                    .addComponent(stornoButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
       public List<String> dajVsetkyKrajiny(){
        String[] lokaly = Locale.getISOCountries();
        List<String> krajiny = new ArrayList<String>();
        for (String kodKrajiny: lokaly){
            Locale lokal = new Locale ("",kodKrajiny);
            krajiny.add(lokal.getDisplayCountry());
        }
        
        return krajiny;
      }
    
    
    private void pridatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatButtonActionPerformed
        Vylet vylet = new Vylet();
        vylet.setKrajina((String) krajinaComboBox.getSelectedItem());
        vylet.setMesto(mestoTextField.getText());
        vylet.setPrirodna_a_kulturna_pamiatka(pamiatkaTextField.getText());
        if(datumDatePicker.getDate() != null){
            Date datum = datumDatePicker.getDate();
            vylet.setDatum(datum);
        }
        vyletDao.pridat(vylet);
        this.setVisible(false);
        
    }//GEN-LAST:event_pridatButtonActionPerformed

    private void stornoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stornoButtonActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_stornoButtonActionPerformed

    
  
    
    
    
    
    
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PridatForm dialog = new PridatForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel KrajinaLabel;
    private org.jdesktop.swingx.JXDatePicker datumDatePicker;
    private javax.swing.JLabel datumLabel;
    private javax.swing.JComboBox krajinaComboBox;
    private javax.swing.JLabel mestoLabel;
    private javax.swing.JTextField mestoTextField;
    private javax.swing.JLabel pamiatkaLabel;
    private javax.swing.JTextField pamiatkaTextField;
    private javax.swing.JButton pridatButton;
    private javax.swing.JButton stornoButton;
    // End of variables declaration//GEN-END:variables
}
