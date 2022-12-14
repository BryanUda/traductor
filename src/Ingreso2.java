/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author midaro99
 */
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Ingreso2 extends javax.swing.JFrame {

    DefaultTableModel modelo, modelo2;
    ArrayList arrayAlfabeto= new ArrayList();
    ArrayList arrayAlfabeto2= new ArrayList();
    String eInicial, eFinal;
    ArrayList<ArrayList> tablaDatos, tablaDatos2; //Variable donde se guardan la tabla de transiccion
    public Ingreso2() {
        initComponents();
    }
    
    public Ingreso2(ArrayList aL) {
        initComponents();
        arrayAlfabeto = aL;
    }
    
    public Ingreso2(ArrayList aL, ArrayList aL2) {
        initComponents();
        arrayAlfabeto = aL;
        arrayAlfabeto2 = aL2;
    }
    
    public String[] separar(String aE){
        String[] row = new String[arrayAlfabeto.size()];
        row[0]=aE;
        /*for(int i=0; i<arrayAlfabeto.size(); i++){
            row[1]="";
        }*/
        return row;
    }
    
    public ArrayList<ArrayList> crearTabla(){
        ArrayList<ArrayList> tablaDatosTransiciones = new ArrayList<>();
        ArrayList row = new ArrayList();
        int fila = tablaTransiciones.getRowCount();
        int columna = tablaTransiciones.getColumnCount();
        String encabezado = "";
        int i;
        String valores="";
        for(int a=0; a < columna; a++){
            row.add(tablaTransiciones.getColumnName(a));
        }
        tablaDatosTransiciones.add(row);
        //System.out.println("Encabezado: "+ encabezado);
        for(int a=0; a < fila; a++){
           ArrayList row2 = new ArrayList();
           for (i = 0; i < columna; i++) {
                row2.add(tablaTransiciones.getValueAt(a, i));
           }
           tablaDatosTransiciones.add(row2);
        }
        //mostrar 
        for(int a=0; a < tablaDatosTransiciones.size(); a++){
           for (i = 0; i < tablaDatosTransiciones.get(a).size(); i++) {
                System.out.print(tablaDatosTransiciones.get(a).get(i)+" ");
           }
            System.out.println("");
        }
        return tablaDatosTransiciones;
    }
    
    public ArrayList<ArrayList> crearTablaTraductor(){
        ArrayList<ArrayList> tablaDatosTransiciones = new ArrayList<>();
        ArrayList row = new ArrayList();
        int fila = tablaTransiciones2.getRowCount();
        int columna = tablaTransiciones2.getColumnCount();
        String encabezado = "";
        int i;
        String valores="";
        for(int a=0; a < columna; a++){
            row.add(tablaTransiciones2.getColumnName(a));
        }
        tablaDatosTransiciones.add(row);
        //System.out.println("Encabezado: "+ encabezado);
        for(int a=0; a < fila; a++){
           ArrayList row2 = new ArrayList();
           for (i = 0; i < columna; i++) {
                row2.add(tablaTransiciones2.getValueAt(a, i));
           }
           tablaDatosTransiciones.add(row2);
        }
        //mostrar 
        for(int a=0; a < tablaDatosTransiciones.size(); a++){
           for (i = 0; i < tablaDatosTransiciones.get(a).size(); i++) {
                System.out.print(tablaDatosTransiciones.get(a).get(i)+" ");
           }
            System.out.println("");
        }
        return tablaDatosTransiciones;
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
        ingresoEstados = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ingEsInicial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ingEsFinal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTransiciones = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTransiciones2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingreso");

        jLabel1.setText("Ingresar el conjunto de estados:");

        ingresoEstados.setToolTipText("Ejemplo: P0,P1,P2...");
        ingresoEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoEstadosActionPerformed(evt);
            }
        });

        jLabel2.setText("Tabla de transici??n de estados:");

        jLabel3.setText("Ingresar el estado inicial:");

        ingEsInicial.setEditable(false);
        ingEsInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingEsInicialActionPerformed(evt);
            }
        });

        jLabel4.setText("Ingresar el estado final:");

        ingEsFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingEsFinalActionPerformed(evt);
            }
        });

        tablaTransiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaTransiciones.setEnabled(false);
        jScrollPane1.setViewportView(tablaTransiciones);

        jButton1.setText("Continuar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ingresar Tabla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tablaTransiciones2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaTransiciones2.setEnabled(false);
        jScrollPane2.setViewportView(tablaTransiciones2);

        jLabel5.setText("Tabla de traducci??n:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(ingresoEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(ingEsFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingEsInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jButton2)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ingresoEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(31, 31, 31)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ingEsInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ingEsFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresoEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoEstadosActionPerformed
        // TODO add your handling code here:
        tablaTransiciones.setEnabled(true);
        tablaTransiciones2.setEnabled(true);
        String sEstados = ingresoEstados.getText();
        String[] aEstados = sEstados.split(","); //ARRAY QUE CONTIENE TODAS LOS ESTADOS 
        modelo = new DefaultTableModel();
        modelo.addColumn("E/A");
        modelo2 = new DefaultTableModel();
        modelo2.addColumn("E/A");
        for(int i=0; i<arrayAlfabeto.size(); i++){
            modelo2.addColumn(String.valueOf(arrayAlfabeto.get(i)));
            modelo.addColumn(String.valueOf(arrayAlfabeto.get(i)));
        }

        for(int i=0; i<aEstados.length; i++){
            System.out.println("Valor: "+aEstados[i]);
            modelo.addRow(separar(aEstados[i]));
            modelo2.addRow(separar(aEstados[i]));
        }
        this.tablaTransiciones.setModel(modelo);
        this.tablaTransiciones2.setModel(modelo2);
    }//GEN-LAST:event_ingresoEstadosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tablaDatos=crearTabla();
        tablaDatos2=crearTablaTraductor();
        ingEsInicial.setEditable(true);
        System.out.println("TABLA DE TRANSICION");
        for(int i=0; i<tablaDatos.size(); i++){
            for(int b=0; b<tablaDatos.get(i).size(); b++){
                System.out.print(tablaDatos.get(i).get(b));
            }
            System.out.println("");
        }
        System.out.println("TABLA DE TRAdUCCION");
        for(int i=0; i<tablaDatos2.size(); i++){
            for(int b=0; b<tablaDatos2.get(i).size(); b++){
                System.out.println(tablaDatos2.get(i).get(b));
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ingEsInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingEsInicialActionPerformed
        // TODO add your handling code here:
        eInicial=ingEsFinal.getText();
        ingEsFinal.setEditable(true);
    }//GEN-LAST:event_ingEsInicialActionPerformed

    private void ingEsFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingEsFinalActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ingEsFinalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        eFinal=ingEsFinal.getText();
        this.setVisible(false);
        Respuesta obj = new Respuesta(tablaDatos,tablaDatos2, eInicial, eFinal);
        obj.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Ingreso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingreso1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ingEsFinal;
    private javax.swing.JTextField ingEsInicial;
    private javax.swing.JTextField ingresoEstados;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaTransiciones;
    private javax.swing.JTable tablaTransiciones2;
    // End of variables declaration//GEN-END:variables
}
