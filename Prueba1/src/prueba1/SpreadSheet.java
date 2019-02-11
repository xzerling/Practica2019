/*
 * Sistema de administracion de telas y paños.
 * Superintendencia de Maquinas, Planta Nueva Aldea.
 * Arauco 2019 - Practica Profesional.
 *
 * Álvaro Elgueda Labra - Univerisad de Talca.
 */

package prueba1;

//Librerias para el manejo de archivos.
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
 
//Librerias de Apache POI.
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Álvaro Elgueda Labra - Univerisad de Talca.
 * 
 */

public final class SpreadSheet 
{
    // documento con las hojas de calculo
    private final Workbook libro;

    // la hoja de calculo
    private final Sheet hojaTelas;

    // estilo de las celdas del encabezado (con el nombre de las columnas)
    private final CellStyle estiloTitulo;

    // estilo de las celdas con poscion de paños - telas
    private final CellStyle estiloCelda;

    public SpreadSheet()
    {
        this.libro = new HSSFWorkbook();
        this.hojaTelas = this.libro.createSheet("Equipos actuales");
        this.estiloTitulo = getEstiloTitulo();
        this.estiloCelda = getEstiloCelda();
        //this.anadeFilaEncabezado();
        this.crearPlantilla();
    }
    
    // crea la fila y celdas del encabezado con el nombre de las columnas
    private void anadeFilaEncabezado()
    {
        final Row filaEncabezado = getNuevaFila();
        int numeroCelda = 0;
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Posi");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Instalado");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Estado");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Proximo cambio");
        
        

        /*this.anadeTiemposPiloto();
        this.anadeTiemposPiloto();
        this.anadeTiemposPiloto();
        this.anadeTiemposPiloto();*/
    }
        
    private CellStyle getEstiloTitulo()
    {
        final CellStyle cellStyle = libro.createCellStyle();
        Font font = libro.createFont();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        cellStyle.setFont(font);
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);

        return cellStyle;
    }
        
    private Row getNuevaFila()
    {
        return hojaTelas.createRow(hojaTelas.getPhysicalNumberOfRows());
    }

    private void creaCeldaEncabezado(Row filaEncabezado, int numeroCelda, String valor)
    {
        final Cell celdaEncabezado = filaEncabezado.createCell(numeroCelda);
        celdaEncabezado.setCellValue(valor);
        celdaEncabezado.setCellStyle(estiloTitulo);
    }
        
    private CellStyle getEstiloCelda()
    {
        final CellStyle cellStyle = libro.createCellStyle();
        Font font = libro.createFont();
        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        cellStyle.setFont(font);
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        return cellStyle;
    }

    public OutputStream generaDocumento() throws IOException
    {
        this.ajustaColumnas();
        final OutputStream outputStream = new FileOutputStream("Telas.xls");
        libro.write(outputStream);
        outputStream.close();
        return outputStream;
    }
        
    private void ajustaColumnas()
    {
        final short numeroColumnas = hojaTelas.getRow(0).getLastCellNum();
        for (int i = 0; i < numeroColumnas; i++) 
        {
                hojaTelas.autoSizeColumn(i);
        }
    }
        
    public void anadeTiemposPiloto()
    {
        final Row fila = getNuevaFila();
        
        final Cell celdaPos = fila.createCell(0);
        final Cell celdaProveedor = fila.createCell(1);
        final Cell celdaPosi = fila.createCell(2);
        final Cell celdaInstalado = fila.createCell(3);
        final Cell celdaEstado = fila.createCell(4);
        final Cell celdaDop = fila.createCell(5);
        final Cell celdaCambio = fila.createCell(6);
        
        
        celdaPos.setCellStyle(estiloCelda);
        celdaPos.setCellValue("Pick up");
        celdaProveedor.setCellValue("Valmet");
        celdaPosi.setCellValue("2220");
        celdaInstalado.setCellValue("11-10-2018");
        celdaEstado.setCellValue("Normal");
        celdaDop.setCellValue("67");
        celdaCambio.setCellValue("08-02-2019");

        /*generaFormulaSumaTiempos(fila);
        generaFormulaMediaTiempos(fila);
        generaFormulaMejorTiempo(fila);*/
    }
    
    public void crearFilas()
    {
        Row filaPickUp = this.getNuevaFila();
        Row fila2daPrensa = this.getNuevaFila();
        Row fila3raSuperior = this.getNuevaFila();
        Row fila3raInferior = this.getNuevaFila();
        Row filaTelaSup = this.getNuevaFila();
        Row filaTelaInf = this.getNuevaFila();
        Row filaManta = this.getNuevaFila();
        Row filacTransversal = this.getNuevaFila();
        Row filaTDAB2 = this.getNuevaFila();
        Row filaTDAB3 = this.getNuevaFila();
        
        Cell Pickup = filaPickUp.createCell(0);
        Cell segundaPrensa = fila2daPrensa.createCell(0);
        Cell terceraSuperior = fila3raSuperior.createCell(0);
        Cell terceraInferior = fila3raInferior.createCell(0);
        Cell telaSup = filaTelaSup.createCell(0);
        Cell telaInf = filaTelaInf.createCell(0);
        Cell manta = filaManta.createCell(0);
        Cell cTransversal = filacTransversal.createCell(0);
        Cell tdab2 = filaTDAB2.createCell(0);
        Cell tdab3 = filaTDAB3.createCell(0);
        
        Pickup.setCellStyle(estiloCelda);
        segundaPrensa.setCellStyle(estiloCelda);
        terceraSuperior.setCellStyle(estiloCelda);
        terceraInferior.setCellStyle(estiloCelda);
        telaSup.setCellStyle(estiloCelda);
        telaInf.setCellStyle(estiloCelda);
        manta.setCellStyle(estiloCelda);
        cTransversal.setCellStyle(estiloCelda);
        tdab2.setCellStyle(estiloCelda);
        tdab3.setCellStyle(estiloCelda);
        
        Pickup.setCellValue("Pick up");
        segundaPrensa.setCellValue("2da Prensa");
        terceraSuperior.setCellValue("3ra Superior");
        terceraInferior.setCellValue("3ra Inferior");
        telaSup.setCellValue("Tela Superior");
        telaInf.setCellValue("Tela Inferior");
        manta.setCellValue("Manta");
        cTransversal.setCellValue("C. Transversal");
        tdab2.setCellValue("Nivel TADB 2");
        tdab3.setCellValue("Nivel TADB 3");
        
    }
    
    public void crearPlantilla()
    {
        this.anadeFilaEncabezado();
        this.crearFilas();
    }
}
