/**
 * EmployeeGUI
 * Employee useres UI
 */

/**
 * @author Raphael Trocino
 * @author Maya 
 * Date: Oct 6 2019
 * Final Project
 */
public class EmployeeGUI extends javax.swing.JFrame {

    /**
     * Constructor
     */
    public EmployeeGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        add = new javax.swing.JMenu();
        addSched = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        viewOrders = new javax.swing.JMenuItem();
        livestock = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Welcome!");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Choose an option from the menu above to continue.");

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        add.setText("Add");

        addSched.setText("Schedule and Livestock");
        addSched.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSchedActionPerformed(evt);
            }
        });
        add.add(addSched);

        jMenuBar1.add(add);

        jMenu2.setText("View");

        viewOrders.setText("Orders");
        viewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrdersActionPerformed(evt);
            }
        });
        jMenu2.add(viewOrders);

        livestock.setText("Livestock");
        livestock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                livestockActionPerformed(evt);
            }
        });
        jMenu2.add(livestock);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(Exit)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action Listener for Add Schedule
     * Creates AddSchedHarLivstck object to add
     * harvest, schedule and livestock into db
     * @param evt event
     */
    private void addSchedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSchedActionPerformed
        AddSchedHarLivstck add = new AddSchedHarLivstck();
        add.main(null);
    }//GEN-LAST:event_addSchedActionPerformed

    /**
     * View Orders Action Listener
     * Views orders
     * @param evt event
     */
    private void viewOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrdersActionPerformed
        View newView = new View();
        Order viewOrders = new Order();
        newView.append(viewOrders);
    }//GEN-LAST:event_viewOrdersActionPerformed

    /**
     * View Livestock Action Listener
     * views livestock from table
     * @param evt event
     */
    private void livestockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_livestockActionPerformed
        View newView = new View();
        Livestock viewLV = new Livestock();
        newView.append(viewLV);
    }//GEN-LAST:event_livestockActionPerformed

    /**
     * Exit program
     * @param evt event
     */
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    /**
     * Main method
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
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JMenu add;
    private javax.swing.JMenuItem addSched;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem livestock;
    private javax.swing.JMenuItem viewOrders;
    // End of variables declaration//GEN-END:variables
}
