/*
 * @date: 18 de Junio de 2018
 * @user: Jorge Andrés Medina Castro
 * @description: crea una estructura html
 */
package layouts;

public class HtmlTemplate {

    public static String htmlHeader()
    {   
        String html = "<!DOCTYPE html>\n" +
                    "<html lang='en'>\n" +
                    "<head>\n" +
                    "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">        \n" +
                    "    \n" +
                    "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\" crossorigin=\"anonymous\">\n" +
                    "    \n" +
                    "    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.0.13/css/all.css\" integrity=\"sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp\" crossorigin=\"anonymous\">\n" +
                    "    \n" +
                    "    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/1.10.18/css/jquery.dataTables.css\">\n" +
                    "    \n" +
                    "    <title>Archivo Creado con Java</title>\n" +
                    "</head>\n" +
                    "<body>                \n" +
                    "    <nav class=\"navbar navbar-dark bg-primary\">\n" +
                    "            <a href=\"#\" class=\"navbar-brand\">Datos Archivo .csv</a>\n" +
                    "    </nav>	\n" +
                    "            \n" +
                    "    <div class=\"container\" style=\"padding-top: 20px;\">\n" +                    
                    "        <div class=\"table-responsive\">\n" +
                    "            <table class=\"table\" id=\"crud\">\n" +
                    "                <thead class=\"thead-dark\" style=\"text-align: center;\">\n" +
                    "                    <tr>\n" +
                    "                        <th>Código Tiquete</th>\n" +
                    "                        <th>Código Ciudad</th>\n" +
                    "                        <th>Ciudad Destino</th>\n" +
                    "                        <th>Fecha Salida</th>\n" +
                    "                        <th>Fecha LLegada</th>\n" +
                    "                        <th>Placa</th>\n" +
                    "                    </tr>\n" +
                    "                </thead>\n" +
                    "                <tbody style=\"text-align: center;\">";
        return html;
    } 
    
    public static String htmlFooter()
    {
        String html = " </tbody>\n" +
                    "            </table>          \n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "    <br />\n" +
                    "    \n" +
                    "    <footer>\n" +
                    "        <p class=\"text-center\" style=\"color: black;\">&copy; 2018 Archivo Creado desde la aplicación ReadFileAndCreateHTML.java</p>\n" +
                    "    </footer>\n" +
                    "    \n" +
                    "    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" +
                    "    <script type=\"text/javascript\" charset=\"utf8\" src=\"https://cdn.datatables.net/1.10.18/js/jquery.dataTables.js\"></script>\n" +
                    "    <script>\n" +
                    "        $(document).ready( function () {\n" +
                    "            $('#crud').DataTable({\n" +
                    "                language: {\n" +
                    "                            \"decimal\": \"\",\n" +
                    "                            \"emptyTable\": \"No hay información\",\n" +
                    "                            \"info\": \"Mostrando _START_ a _END_ de _TOTAL_ Entradas\",\n" +
                    "                            \"infoEmpty\": \"Mostrando 0 to 0 of 0 Entradas\",\n" +
                    "                            \"infoFiltered\": \"(Filtrado de _MAX_ total entradas)\",\n" +
                    "                            \"infoPostFix\": \"\",\n" +
                    "                            \"thousands\": \",\",\n" +
                    "                            \"lengthMenu\": \"Mostrar _MENU_ Entradas\",\n" +
                    "                            \"loadingRecords\": \"Cargando...\",\n" +
                    "                            \"processing\": \"Procesando...\",\n" +
                    "                            \"search\": \"Buscar:\",\n" +
                    "                            \"zeroRecords\": \"Sin resultados encontrados\",\n" +
                    "                \"paginate\": {\n" +
                    "                            \"first\": \"Primero\",\n" +
                    "                            \"last\": \"Ultimo\",\n" +
                    "                            \"next\": \"Siguiente\",\n" +
                    "                            \"previous\": \"Anterior\"\n" +
                    "                            }\n" +
                    "                }\n" +
                    "            });\n" +
                    "        } );\n" +
                    "    </script>\n" +
                    "</body>\n" +
                    "</html>";
        return html;
    } 
    
}
