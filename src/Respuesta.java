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
import java.util.Arrays;

public class Respuesta extends javax.swing.JFrame {

    ArrayList<ArrayList> tablaTransacion,tablaTransacion2;
    String eInicial, eFinal;
    public Respuesta(ArrayList<ArrayList> tbTra , String eI, String eF){
        initComponents();
        tablaTransacion=tbTra;
        eInicial=eI;
        eFinal=eF;
    }
    
    public Respuesta(ArrayList<ArrayList> tbTra, ArrayList<ArrayList> tbTra2 , String eI, String eF){
        initComponents();
        tablaTransacion=tbTra;
        tablaTransacion2=tbTra2;
        eInicial=eI;
        eFinal=eF;
    }
    
    public Respuesta(){
        initComponents();
    }
    
    public boolean estadosFinales(String cEstados, String ax){
        boolean cent=false;
            if(cEstados.length()==2){
               if(ax.equals(cEstados)){
                    cent=true;
                }
            }else if(cEstados.length()+1>2){
                String vec[] = cEstados.split(",");
                String auxV[] = ax.split(",");
                for(int i=0; i<vec.length; i++){
                    for(int b=0;b<auxV.length;b++){
                        if(auxV[b].equals(vec[i])){
                            cent=true;
                            break;
                        }
                    }
                    
                }
            }
        return cent;
    }    
    
    public int buscarEstados(ArrayList<ArrayList> arrayDatos, String aux){
        int intColum=0;
        for(int x=1; x<arrayDatos.size();x++){
            if(arrayDatos.get(x).get(0).equals(aux)){
            intColum=x;
            System.out.println("Valor nuevo celda: "+arrayDatos.get(x).get(0));
            System.out.println("Int celda: "+intColum);
            break;
            }
        }
        return intColum;
    }
    
    public String buscarEpsion(Object cadena){
        String sClausura=(String)cadena;
        if(cadena!=null){
            for(int f=1; f<tablaTransacion.size(); f++){//For para las filas
                int c=tablaTransacion.get(0).size()-1;
                    if(tablaTransacion.get(f).get(0).equals(cadena)){
                        sClausura+=","+buscarEpsion(tablaTransacion.get(f).get(c));
                    }
            }
            
        }else{
            sClausura="";
        }
        return sClausura;
    }
    
    public ArrayList<ArrayList> sacarClausuras(){
        ArrayList<ArrayList> aClausuras= new ArrayList<>();
        String sClausura="";
        System.out.println("Tamaño de las filas: "+tablaTransacion.size());
        System.out.println("Tamaño de las columnas: "+tablaTransacion.get(0).size());
        System.out.println("");
        for(int f=1; f<tablaTransacion.size(); f++){//For para las filas
            sClausura+= tablaTransacion.get(f).get(0);
            ArrayList aRow= new ArrayList<>();
            int c=tablaTransacion.get(0).size()-1;
                if( tablaTransacion.get(f).get(c)!=null && !tablaTransacion.get(f).get(c).equals(sClausura)){
                    sClausura+=","+buscarEpsion(tablaTransacion.get(f).get(c));
                    String[] vec = sClausura.split(",");
                    aRow.addAll(Arrays.asList(vec));
                    for(int d=0; d<aRow.size();d++){
                        System.out.print(aRow.get(d));
                    }
                }
           aClausuras.add(aRow);
           sClausura="";
        }
        
        
      
        return aClausuras;
    }
    public void automata(ArrayList<ArrayList> arrayClausuras, String ch){
        boolean cent=false;
        Object aux= tablaTransacion.get(1).get(0);
        System.out.println("Aux: "+aux);
        for(int c=0;c<ch.length();c++){
            System.out.println("Caracter> "+ch.charAt(c));
            for(int cl=0; cl<tablaTransacion.get(0).size();cl++){
                String aux2=String.valueOf(ch.charAt(c));
                System.out.println("Aux2> "+aux2);
                if(tablaTransacion.get(0).get(cl).equals(aux2)){
                    System.out.println("Entre cl");
                        for(int f=1; f<tablaTransacion.size();f++){
                            if(tablaTransacion.get(f).get(cl)==aux && tablaTransacion.get(f).get(cl)!=null){
                                System.out.println("Estado: "+tablaTransacion.get(f).get(cl));
                                aux=(String) tablaTransacion.get(f).get(cl);
                                break;
                            }
                        }
                }
            }
        }
       
    }
    
    public void AFD(ArrayList<ArrayList> arrayClausuras, String ch){
        boolean cent=false;
        String aux=String.valueOf(tablaTransacion.get(1).get(0));
        System.out.println("Aux: "+aux);
        for(int c=0;c<ch.length();c++){
            System.out.println("Caracter> "+ch.charAt(c));
            String aux2=String.valueOf(ch.charAt(c));
            for(int cl=0; cl<tablaTransacion.get(0).size();cl++){
                if(tablaTransacion.get(0).get(cl).equals(aux2)){
                    System.out.println("Entre cl - Valor col: "+tablaTransacion.get(0).get(cl));
                    for(int f=1; f<tablaTransacion.size();f++){
                        System.out.println(tablaTransacion.get(f).get(0)+ " == "+aux);
                        if(tablaTransacion.get(f).get(cl) != null ){
                            if(String.valueOf(tablaTransacion.get(f).get(0)).equals(aux)){
                                System.out.println("Valor antiguo de aux: "+aux);
                                aux=String.valueOf(tablaTransacion.get(f).get(cl));
                                System.out.println("Valor nuevo de aux: "+aux);
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Estado FINAL: "+aux.toString());
     
    }
    
    public String AFDTraductor(String ch){
        boolean cent=false;
        String traduccion="";
        String aux=String.valueOf(tablaTransacion.get(1).get(0));
        System.out.println("Aux: "+aux);
        for(int c=0;c<ch.length();c++){
            System.out.println("Caracter> "+ch.charAt(c));
            String aux2=String.valueOf(ch.charAt(c));
            for(int cl=0; cl<tablaTransacion.get(0).size();cl++){
                if(tablaTransacion.get(0).get(cl).equals(aux2)){
                    System.out.println("Entre cl - Valor col: "+tablaTransacion.get(0).get(cl));
                    for(int f=1; f<tablaTransacion.size();f++){
                        System.out.println(tablaTransacion.get(f).get(0)+ " == "+aux);
                        if(tablaTransacion.get(f).get(cl) != null ){
                            if(String.valueOf(tablaTransacion.get(f).get(0)).equals(aux)){
                                System.out.println("Valor antiguo de aux: "+aux);
                                
                                    traduccion+=traductor(aux2, aux);
                               
                                aux=String.valueOf(tablaTransacion.get(f).get(cl));
                                
                                System.out.println("Valor nuevo de aux: "+aux);
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Estado FINAL: "+aux.toString());
        return traduccion;
    }
    
    String traductor(String ch,String pos){
        String r="";
        String aux=pos;
                String aux2=ch;
                for(int cl=0; cl<tablaTransacion2.get(0).size();cl++){
                    if(tablaTransacion2.get(0).get(cl).equals(aux2)){
                        for(int f=1; f<tablaTransacion2.size();f++){
                            if(tablaTransacion2.get(f).get(cl) != null){
                                if(String.valueOf(tablaTransacion2.get(f).get(0)).equals(aux)){
                                    r=String.valueOf(tablaTransacion2.get(f).get(cl));
                                    System.out.println("Valor: "+String.valueOf(tablaTransacion2.get(f).get(cl)));
                                    break;
                                }
                            }
                        }
                    }
                }
        return r;
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
        ingresoCadena = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        salida = new javax.swing.JLabel();
        salidaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reconocimiento de Cadenas");

        jLabel1.setText("Cadena de entrada: ");

        ingresoCadena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoCadenaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Resultado");

        salida.setText("La cadena");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(salida))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(salidaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salidaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(ingresoCadena, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ingresoCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresoCadenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoCadenaActionPerformed
        // TODO add your handling code here:
        ArrayList<ArrayList> arrayClausuras = new ArrayList<>();
        AFD(arrayClausuras, ingresoCadena.getText());
        salida.setText("La cadena es reconocida por el autómata produciendo la salida: "+AFDTraductor(ingresoCadena.getText()));
        System.out.println(AFDTraductor(ingresoCadena.getText()));

        
    }//GEN-LAST:event_ingresoCadenaActionPerformed

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
            java.util.logging.Logger.getLogger(Respuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Respuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Respuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Respuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Respuesta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ingresoCadena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel salida;
    private javax.swing.JLabel salidaLabel;
    // End of variables declaration//GEN-END:variables
}
