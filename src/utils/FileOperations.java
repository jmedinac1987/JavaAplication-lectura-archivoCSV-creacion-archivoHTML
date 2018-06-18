/*
 * @date: 18 de Junio de 2018
 * @user: Jorge Andrés Medina Castro
 * @description: esta clase permite leer un documento .csv (archivo delimitado por comas), retorna resultados de una busqueda y crea un documento nuevo con 
                 extensión .html
 */
package utils;

import layouts.HtmlTemplate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FileOperations {

    //Atributos 
    private FileInputStream openFile = null;
    private DataInputStream inputData = null;
    private String separador = ";";

    public BufferedReader bufferReaderFile(String path) {

        try {
            // Abrimos el archivo
            this.openFile = new FileInputStream(path);

            // Creamos el objeto de entrada
            this.inputData = new DataInputStream(this.openFile);

            // Creamos el Buffer de Lectura
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(this.inputData));

            return bufferReader;//retorna el buffer de lectura 

        } catch (FileNotFoundException e) {
            System.err.println("Exception: " + e.getMessage());
            return null;
        }

    }

    public void closeParametersBufferedReader() {
        try {
            openFile.close();
            inputData.close();
        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void createHtmlFile(JTable tablaParametro) {

        String url = "E:\\datosCSV.html";//ruta donde se crea el archivo 
        String html = HtmlTemplate.htmlHeader();

        for (int i = 0; i < tablaParametro.getRowCount(); i++) {
            html += "<tr>\n"
                    + "<td>" + tablaParametro.getValueAt(i, 0) + "</td>\n"
                    + "<td>" + tablaParametro.getValueAt(i, 1) + "</td>\n"
                    + "<td>" + tablaParametro.getValueAt(i, 2) + "</td>\n"
                    + "<td>" + tablaParametro.getValueAt(i, 3) + "</td>\n"
                    + "<td>" + tablaParametro.getValueAt(i, 4) + "</td>\n"
                    + "<td>" + tablaParametro.getValueAt(i, 5) + "</td>\n"
                    + "</tr>";
        }

        html += HtmlTemplate.htmlFooter();

        File file = new File(url);//crea el archivo archivo si no existe de lo contrario lo sobreescribe

        try {

            BufferedWriter bufferWritter = new BufferedWriter(new FileWriter(file));
            bufferWritter.write(html);//ingresa la información al archivo 
            bufferWritter.close();//cierra la edición 

            Runtime.getRuntime().exec("cmd /c start " + url);//abre el archivo creado

        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }

    }

    public JTable passValuesToaTable(JTable tablaParametro, String path) {

        try {

            BufferedReader bufferReader = bufferReaderFile(path);//buffer para lectura del archivo .csv            
            DefaultTableModel tableModel = new DefaultTableModel();//se crea un objeto para el modelo de la tabla 

            //Encabezados de la tabla            
            tableModel.addColumn("Código Tiquete");
            tableModel.addColumn("Código Ciudad");
            tableModel.addColumn("Ciudad Destino");
            tableModel.addColumn("Fecha Salida");
            tableModel.addColumn("Fecha LLegada");
            tableModel.addColumn("Placa");

            String line = bufferReader.readLine();

            while (line != null) {//Cicl para leer línea a línea

                // Separa la línea leída con el separador definido previamente
                String[] fields = line.split(String.valueOf(this.separador));

                //System.out.println(Arrays.toString(fields));
                tableModel.addRow(fields);//agrega la línea al modelo de la tabla

                line = bufferReader.readLine();//lee nuevamente el fichero
            }

            tablaParametro.setModel(tableModel);//La tabla recibe el modelo creado 

            closeParametersBufferedReader();//cierra openFile e inputFile 

            return tablaParametro;//retorna la tabla con los valores

        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
            return null;
        }
    }

    public JTable filterTableByCode(JTable tablaParametro, String path, String code) throws IOException {

        if (!code.equalsIgnoreCase("Buscar por código de ciudad") || code.isEmpty()) {
            try {

                BufferedReader bufferReader = bufferReaderFile(path);//buffer para lectura del archivo .csv            
                DefaultTableModel tableModel = new DefaultTableModel();//se crea un objeto para el modelo de la tabla 

                //Encabezados de la tabla            
                tableModel.addColumn("Código Tiquete");
                tableModel.addColumn("Código Ciudad");
                tableModel.addColumn("Ciudad Destino");
                tableModel.addColumn("Fecha Salida");
                tableModel.addColumn("Fecha LLegada");
                tableModel.addColumn("Placa");

                String line = bufferReader.readLine();

                while (line != null) {//Cicl para leer línea a línea

                    // Separa la línea leída con el separador definido previamente
                    String[] fields = line.split(String.valueOf(this.separador));

                    //System.out.println(Arrays.toString(fields));
                    if (fields[1].equalsIgnoreCase(code)) {
                        tableModel.addRow(fields);//agrega la línea al modelo de la tabla
                    }

                    line = bufferReader.readLine();//lee nuevamente el fichero
                }

                tablaParametro.setModel(tableModel);//La tabla recibe el modelo creado 

                closeParametersBufferedReader();//cierra openFile e inputFile 

                return tablaParametro;//retorna la tabla con los valores

            } catch (IOException e) {
                System.err.println("Exception: " + e.getMessage());
                return null;
            }

        } else {
            return passValuesToaTable(tablaParametro, path);
        }
    }
}
