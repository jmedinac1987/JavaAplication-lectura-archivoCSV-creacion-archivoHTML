/*
ALUMNOS: Héctor Iván Rincón Ramirez, Jorge Andrés Medina Castro
FECHA: 29/08/2015
OBSERVACIONES: JFrameInterno que mostrara el contenido de un archivo .txt previamente seleccionado
 */
package views;
//Se importan librerias necesarias 

import com.placeholder.PlaceHolder;
import utils.FileOperations;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.IOException;

public class InternalReadFile extends javax.swing.JInternalFrame {

    /**
     * Creates new form InternalLeerArchivo
     */
    public InternalReadFile() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblRuta = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableResults = new javax.swing.JTable();
        inputQuery = new javax.swing.JTextField();
        btnFilterQuery = new javax.swing.JButton();
        btnHtml = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cargar Archivo .CSV");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Cargar Archivo .csv");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setToolTipText("");

        lblRuta.setToolTipText("");

        tableResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo 1", "Titulo 2", "Titulo 3", "Titulo 4", "Titulo 5", "Titulo 6"
            }
        ));
        tableResults.setEnabled(false);
        jScrollPane2.setViewportView(tableResults);

        inputQuery.setEditable(false);
        inputQuery.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnFilterQuery.setText("Buscar");
        btnFilterQuery.setToolTipText("Si el campo de buscar esta vacio y se preciona este botón la tabla se llenara con la totalidad de los registros del archivo .csv");
        btnFilterQuery.setEnabled(false);
        btnFilterQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterQueryActionPerformed(evt);
            }
        });

        btnHtml.setText("Html");
        btnHtml.setToolTipText("Crea un archivo html con la información de la tabla");
        btnHtml.setEnabled(false);
        btnHtml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHtmlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRuta))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFilterQuery)
                        .addGap(18, 18, 18)
                        .addComponent(btnHtml)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblRuta)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton1)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilterQuery)
                    .addComponent(btnHtml))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //Objeto de tipo FileDialog para usar la ventana emergente de windows (explorar de archivos) 
        FileDialog objDirectorioArchivo = new FileDialog(new Frame(), title, FileDialog.LOAD);

        //Se usa el método setVisible para mostrar en pantalla el cuadro de dialogo donde el usuario seleccionara el archivo
        objDirectorioArchivo.setVisible(true);

        //Se crea una variable de tipo String que almacenara el Directorio y el nombre del archivo que selecciona el usuario 
        String path = objDirectorioArchivo.getDirectory() + objDirectorioArchivo.getFile();
        
        FileOperations fileOperations = new FileOperations();

        //Se muestra en patalla la ruta del archivo seleccionado 
        lblRuta.setText(path);
        
        try {
            if (!path.equalsIgnoreCase("nullnull")) {
                
                inputQuery.setEditable(true);//Se activa el input
                placeHoldersInputs();//placeHolder de los inputs
                btnFilterQuery.setEnabled(true);//se activa el boton buscar  
                btnHtml.setEnabled(true);
                tableResults.setEnabled(true);
                fileOperations.passValuesToaTable(tableResults, path);//Hace el llenado de la tabla utilizando el método passValuesToaTable 
                
            }else{
                inputQuery.setEditable(false);//Se bloquea la edición el input
                btnFilterQuery.setEnabled(false);//se inhabilita el boton buscar                
                btnHtml.setEnabled(false);
                tableResults.setEnabled(false);
            }            
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnFilterQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterQueryActionPerformed
        
        FileOperations fileOperations = new FileOperations();
        
        try {
            //Hace el llenado de la tabla utilizando el método filterTableByCode
            fileOperations.filterTableByCode(tableResults, lblRuta.getText(), inputQuery.getText());
        } catch (IOException e) {
            
            System.out.println("Exception: " + e.getMessage());
        }
    }//GEN-LAST:event_btnFilterQueryActionPerformed

    private void btnHtmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHtmlActionPerformed
        FileOperations fileOPerations = new FileOperations();
        try {
            fileOPerations.createHtmlFile(tableResults);            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnHtmlActionPerformed
    
    public void placeHoldersInputs() {
        PlaceHolder holder;
        holder = new PlaceHolder(inputQuery, "Buscar por código de ciudad");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilterQuery;
    private javax.swing.JButton btnHtml;
    private javax.swing.JTextField inputQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JTable tableResults;
    // End of variables declaration//GEN-END:variables
}
