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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
 
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
    private Workbook libro;

    // las hojas de calculo
    private final Sheet hojaActual;
    private final Sheet hojaHistoricaPickUp;
    private final Sheet hojaHistorica2daPrensa;
    private final Sheet hojaHistorica3raSuperior;
    private final Sheet hojaHistorica3raInferior;
    private final Sheet hojaHistorica3TelaSup;
    private final Sheet hojaHistorica3TelaInf;
    private final Sheet hojaHistoricaManta;
    private final Sheet hojaHistoricaTransversal;
    private final Sheet hojaHistoricaExHumedo;
    private final Sheet hojaHistoricaExSeco;
    private final Sheet hojaHistoricaCintaEn;
    private final Sheet hojaHistoricaCHP1;
    private final Sheet hojaHistoricaCHP2;
    private final Sheet hojaHistoricaCHP3;
    private final Sheet hojaHistoricaCHS;
    private final Sheet hojaHistoricaCHT;

    // estilo de las celdas del encabezado (con el nombre de las columnas)
    private final CellStyle estiloTitulo;

    // estilo de las celdas con poscion de paños - telas
    private final CellStyle estiloCelda;
    
    // estilo de las celdas con poscion de paños - telas
    private final CellStyle estiloCelda2;
    
    //Arraylist de los equipos
    private ArrayList equipos;
    private ArrayList arrayPickUp;
    private ArrayList array2daPrensa;
    private ArrayList array3raSuperior;
    private ArrayList array3raInferior;
    private ArrayList array3TelaSup;
    private ArrayList array3TelaInf;
    private ArrayList arrayManta;
    private ArrayList arrayTransversal;
    private ArrayList arrayExHumedo;
    private ArrayList arrayExSeco;
    private ArrayList arrayCintaEn;
    private ArrayList arrayCHP1;
    private ArrayList arrayCHP2;
    private ArrayList arrayCHP3;
    private ArrayList arrayCHS;
    private ArrayList arrayCHT;
    
    
    Row filaPickUp;
    Row fila2daPrensa;
    Row fila3raSuperior;
    Row fila3raInferior;
    Row filaTelaSup;
    Row filaTelaInf;
    Row filaManta;
    Row filacTransversal;
    Row filaExHumedo;
    Row filaExSeco;
    Row filaCintaEn;
    Row filaCHP1;
    Row filaCHP2;
    Row filaCHP3;
    Row filaCHS;
    Row filaCHT;

    public SpreadSheet()
    {
        this.libro = new HSSFWorkbook();
        this.hojaActual = this.libro.createSheet("Equipos actuales");
        this.hojaHistoricaPickUp = this.libro.createSheet("Historial de PickUp");
        this.hojaHistorica2daPrensa = this.libro.createSheet("Historial 2da Prensa");
        this.hojaHistorica3raSuperior = this.libro.createSheet("Historial 3ra Superior");
        this.hojaHistorica3raInferior = this.libro.createSheet("Historial 3ra Inferior");
        this.hojaHistorica3TelaSup = this.libro.createSheet("Historial Tela Superior");
        this.hojaHistorica3TelaInf = this.libro.createSheet("Historial Tela Inferior");
        this.hojaHistoricaManta = this.libro.createSheet("Historial Manta");
        this.hojaHistoricaTransversal = this.libro.createSheet("Historial C. Transversal");
        this.hojaHistoricaExHumedo = this.libro.createSheet("Historial Extremo Humedo");
        this.hojaHistoricaExSeco = this.libro.createSheet("Historial Extremo Seco");
        this.hojaHistoricaCintaEn = this.libro.createSheet("Historial Cinta Enhebrado");
        this.hojaHistoricaCHP1 = this.libro.createSheet("Historial CHP1");
        this.hojaHistoricaCHP2 = this.libro.createSheet("Historial CHP2");
        this.hojaHistoricaCHP3 = this.libro.createSheet("Historial CHP3");
        this.hojaHistoricaCHS = this.libro.createSheet("Historial CHS");
        this.hojaHistoricaCHT = this.libro.createSheet("Historial CHT");
        this.estiloTitulo = getEstiloTitulo();
        this.estiloCelda = getEstiloCelda();
        this.estiloCelda2 = getEstiloCelda2();
        this.equipos = new ArrayList();
        this.arrayPickUp = new ArrayList();
        
        this.crearPlantilla();

    }

    public Workbook getLibro() {
        return libro;
    }

    public void setLibro(Workbook libro) {
        this.libro = libro;
    }

    public ArrayList getArrayPickUp() {
        return arrayPickUp;
    }

    public void setArrayPickUp(ArrayList arrayPickUp) {
        this.arrayPickUp = arrayPickUp;
    }

    public ArrayList getArray2daPrensa() {
        return array2daPrensa;
    }

    public void setArray2daPrensa(ArrayList array2daPrensa) {
        this.array2daPrensa = array2daPrensa;
    }

    public ArrayList getArray3raSuperior() {
        return array3raSuperior;
    }

    public void setArray3raSuperior(ArrayList array3raSuperior) {
        this.array3raSuperior = array3raSuperior;
    }

    public ArrayList getArray3raInferior() {
        return array3raInferior;
    }

    public void setArray3raInferior(ArrayList array3raInferior) {
        this.array3raInferior = array3raInferior;
    }

    public ArrayList getArray3TelaSup() {
        return array3TelaSup;
    }

    public void setArray3TelaSup(ArrayList array3TelaSup) {
        this.array3TelaSup = array3TelaSup;
    }

    public ArrayList getArray3TelaInf() {
        return array3TelaInf;
    }

    public void setArray3TelaInf(ArrayList array3TelaInf) {
        this.array3TelaInf = array3TelaInf;
    }

    public ArrayList getArrayManta() {
        return arrayManta;
    }

    public void setArrayManta(ArrayList arrayManta) {
        this.arrayManta = arrayManta;
    }

    public ArrayList getArrayTransversal() {
        return arrayTransversal;
    }

    public void setArrayTransversal(ArrayList arrayTransversal) {
        this.arrayTransversal = arrayTransversal;
    }

    public ArrayList getArrayExHumedo() {
        return arrayExHumedo;
    }

    public void setArrayExHumedo(ArrayList arrayExHumedo) {
        this.arrayExHumedo = arrayExHumedo;
    }

    public ArrayList getArrayExSeco() {
        return arrayExSeco;
    }

    public void setArrayExSeco(ArrayList arrayExSeco) {
        this.arrayExSeco = arrayExSeco;
    }

    public ArrayList getArrayCintaEn() {
        return arrayCintaEn;
    }

    public void setArrayCintaEn(ArrayList arrayCintaEn) {
        this.arrayCintaEn = arrayCintaEn;
    }

    public ArrayList getArrayCHP1() {
        return arrayCHP1;
    }

    public void setArrayCHP1(ArrayList arrayCHP1) {
        this.arrayCHP1 = arrayCHP1;
    }

    public ArrayList getArrayCHP2() {
        return arrayCHP2;
    }

    public void setArrayCHP2(ArrayList arrayCHP2) {
        this.arrayCHP2 = arrayCHP2;
    }

    public ArrayList getArrayCHP3() {
        return arrayCHP3;
    }

    public void setArrayCHP3(ArrayList arrayCHP3) {
        this.arrayCHP3 = arrayCHP3;
    }

    public ArrayList getArrayCHS() {
        return arrayCHS;
    }

    public void setArrayCHS(ArrayList arrayCHS) {
        this.arrayCHS = arrayCHS;
    }

    public ArrayList getArrayCHT() {
        return arrayCHT;
    }

    public void setArrayCHT(ArrayList arrayCHT) {
        this.arrayCHT = arrayCHT;
    }
    
    
    // crea la fila y celdas del encabezado con el nombre de las columnas
    private void anadeFilaEncabezado()
    {
        final Row filaEncabezado = getNuevaFila(this.hojaActual);
        final Row filaEncabezado0 = getNuevaFila(this.hojaHistoricaPickUp);
        final Row filaEncabezado1 = getNuevaFila(this.hojaHistorica2daPrensa);
        final Row filaEncabezado2 = getNuevaFila(this.hojaHistorica3raSuperior);
        final Row filaEncabezado3 = getNuevaFila(this.hojaHistorica3raInferior);
        final Row filaEncabezado4 = getNuevaFila(this.hojaHistorica3TelaSup);
        final Row filaEncabezado5 = getNuevaFila(this.hojaHistorica3TelaInf);
        final Row filaEncabezado6 = getNuevaFila(this.hojaHistoricaManta);
        final Row filaEncabezado7 = getNuevaFila(this.hojaHistoricaTransversal);
        final Row filaEncabezado8 = getNuevaFila(this.hojaHistoricaExHumedo);
        final Row filaEncabezado9 = getNuevaFila(this.hojaHistoricaExSeco);
        final Row filaEncabezado10 = getNuevaFila(this.hojaHistoricaCintaEn);
        final Row filaEncabezado11 = getNuevaFila(this.hojaHistoricaCHP1);
        final Row filaEncabezado12 = getNuevaFila(this.hojaHistoricaCHP2);
        final Row filaEncabezado13 = getNuevaFila(this.hojaHistoricaCHP3);
        final Row filaEncabezado14 = getNuevaFila(this.hojaHistoricaCHS);
        final Row filaEncabezado15 = getNuevaFila(this.hojaHistoricaCHT);
        int numeroCelda = 0;
        
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Plan Operativo   ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado0, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado0, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado0, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado0, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado0, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado0, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado0, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado0, numeroCelda++, "Causa de cambio    ");
       
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado1, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado1, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado1, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado1, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado1, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado1, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado1, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado1, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado3, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado3, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado3, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado3, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado3, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado3, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado3, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado3, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado4, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado4, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado4, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado4, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado4, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado4, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado4, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado4, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado5, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado5, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado5, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado5, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado5, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado5, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado5, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado5, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado6, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado6, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado6, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado6, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado6, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado6, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado6, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado6, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado7, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado7, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado7, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado7, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado7, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado7, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado7, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado7, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado8, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado8, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado8, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado8, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado8, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado8, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado8, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado8, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado9, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado9, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado9, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado9, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado9, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado9, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado9, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado9, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado10, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado10, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado10, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado10, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado10, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado10, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado10, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado10, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado11, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado11, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado11, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado11, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado11, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado11, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado11, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado11, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado12, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado12, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado12, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado12, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado12, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado12, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado12, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado12, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado13, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado13, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado13, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado13, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado13, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado13, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado13, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado13, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado14, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado14, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado14, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado14, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado14, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado14, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado14, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado14, numeroCelda++, "Causa de cambio    ");
        
        numeroCelda = 0;

        creaCeldaEncabezado(filaEncabezado15, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado15, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado15, numeroCelda++, "Instalado   ");
        creaCeldaEncabezado(filaEncabezado15, numeroCelda++, "Codigo Caja");
        creaCeldaEncabezado(filaEncabezado15, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado15, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado15, numeroCelda++, "Plan Operativo");
        creaCeldaEncabezado(filaEncabezado15, numeroCelda++, "Causa de cambio    ");

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
        
    private Row getNuevaFila(Sheet hoja)
    {
        return hoja.createRow(hoja.getPhysicalNumberOfRows());
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
    
    private CellStyle getEstiloCelda2() 
    {
        final CellStyle cellStyle = libro.createCellStyle();
        Font font = libro.createFont();
        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
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
        this.ajustaColumnas(this.hojaActual);
        this.ajustaColumnas(this.hojaHistoricaPickUp);
        this.ajustaColumnas(this.hojaHistorica2daPrensa);
        
        this.ajustaColumnas(this.hojaHistorica3raSuperior);
        this.ajustaColumnas(this.hojaHistorica3raInferior);
        this.ajustaColumnas(this.hojaHistorica3TelaSup);
        this.ajustaColumnas(this.hojaHistorica3TelaInf);
        this.ajustaColumnas(this.hojaHistoricaManta);
        this.ajustaColumnas(this.hojaHistoricaTransversal);
        this.ajustaColumnas(this.hojaHistoricaExHumedo);
        this.ajustaColumnas(this.hojaHistoricaExSeco);
        this.ajustaColumnas(this.hojaHistoricaCintaEn);
        this.ajustaColumnas(this.hojaHistoricaCHP1);
        this.ajustaColumnas(this.hojaHistoricaCHP2);
        this.ajustaColumnas(this.hojaHistoricaCHP3);
        this.ajustaColumnas(this.hojaHistoricaCHS);
        this.ajustaColumnas(this.hojaHistoricaCHT);
        this.crearHojaActual(this.equipos);
        this.crearHojaPickUp(this.arrayPickUp);
        this.crearHoja2daPrensa(this.array2daPrensa);
        this.crearHoja3raSup(this.array3raSuperior);
        this.crearHoja3raInf(this.array3raInferior);
        this.crearHojaTelaSup(this.array3TelaSup);
        this.crearHojaTelaInf(this.array3TelaInf);
        this.crearHojaManta(this.arrayManta);
        this.crearHojaTransversal(this.arrayTransversal);
        this.crearHojaExHum(this.arrayExHumedo);
        this.crearHojaExSec(this.arrayExSeco);
        this.crearHojaCintaEn(this.arrayCintaEn);
        this.crearHojaCHP1(this.arrayCHP1);
        this.crearHojaCHP2(this.arrayCHP2);
        this.crearHojaCHP3(this.arrayCHP3);
        this.crearHojaCHS(this.arrayCHS);
        this.crearHojaCHT(this.arrayCHT);
        //Row fila = this.crearHojaPickUp();
        final OutputStream outputStream = new FileOutputStream("BD.xls");
        System.out.println("nuevo bd creado");
        try 
        {
            System.out.println("escrito");
            libro.write(outputStream);
            outputStream.close();
            
        } 
        catch (Exception e)
        {
            //this.hojaHistoricaPickUp.removeRow(fila);
            System.out.println("error");
        }
        System.out.println("retornando el stream");
        return outputStream;

    }
    
    
        
    private void ajustaColumnas(Sheet hoja)
    {
        final short numeroColumnas = hoja.getRow(0).getLastCellNum();
        for (int i = 0; i < numeroColumnas; i++) 
        {
            hoja.autoSizeColumn(i);
        }
    }
    
    private Row crearHojaPickUp()
    {
        Row fila = this.getNuevaFila(this.hojaHistoricaPickUp);
        Cell pickup = fila.createCell(0);
        pickup.setCellStyle(estiloCelda);
        pickup.setCellValue("Pick up");
        this.crearHojaPickUp(this.arrayPickUp);
        return fila;
    }
        

    public void crearFilas()
    {
        this.filaPickUp = this.getNuevaFila(this.hojaActual);
        this.fila2daPrensa = this.getNuevaFila(this.hojaActual);
        this.fila3raSuperior = this.getNuevaFila(this.hojaActual);
        this.fila3raInferior = this.getNuevaFila(this.hojaActual);
        this.filaTelaSup = this.getNuevaFila(this.hojaActual);
        this.filaTelaInf = this.getNuevaFila(this.hojaActual);
        this.filaManta = this.getNuevaFila(this.hojaActual);
        this.filacTransversal = this.getNuevaFila(this.hojaActual);
        this.filaExHumedo = this.getNuevaFila(this.hojaActual);
        this.filaExSeco = this.getNuevaFila(this.hojaActual);
        this.filaCintaEn = this.getNuevaFila(this.hojaActual);
        this.filaCHP1 = this.getNuevaFila(this.hojaActual);
        this.filaCHP2 = this.getNuevaFila(this.hojaActual);
        this.filaCHP3 = this.getNuevaFila(this.hojaActual);
        this.filaCHS = this.getNuevaFila(this.hojaActual);
        this.filaCHT = this.getNuevaFila(this.hojaActual);
        
        Cell Pickup = filaPickUp.createCell(0);
        Cell segundaPrensa = fila2daPrensa.createCell(0);
        Cell terceraSuperior = fila3raSuperior.createCell(0);
        Cell terceraInferior = fila3raInferior.createCell(0);
        Cell telaSup = filaTelaSup.createCell(0);
        Cell telaInf = filaTelaInf.createCell(0);
        Cell manta = filaManta.createCell(0);
        Cell cTransversal = filacTransversal.createCell(0);
        Cell exHumedo = filaExHumedo.createCell(0);
        Cell exSeco = filaExSeco.createCell(0);
        Cell cintaEn = filaCintaEn.createCell(0);
        Cell chp1 = filaCHP1.createCell(0);
        Cell chp2 = filaCHP2.createCell(0);
        Cell chp3 = filaCHP3.createCell(0);
        Cell chs = filaCHS.createCell(0);
        Cell cht = filaCHT.createCell(0);
        
        Pickup.setCellStyle(estiloCelda);
        segundaPrensa.setCellStyle(estiloCelda);
        terceraSuperior.setCellStyle(estiloCelda);
        terceraInferior.setCellStyle(estiloCelda);
        telaSup.setCellStyle(estiloCelda);
        telaInf.setCellStyle(estiloCelda);
        manta.setCellStyle(estiloCelda);
        cTransversal.setCellStyle(estiloCelda);
        exHumedo.setCellStyle(estiloCelda);
        exSeco.setCellStyle(estiloCelda);
        cintaEn.setCellStyle(estiloCelda);
        chp1.setCellStyle(estiloCelda);
        chp2.setCellStyle(estiloCelda);
        chp3.setCellStyle(estiloCelda);
        chs.setCellStyle(estiloCelda);
        cht.setCellStyle(estiloCelda);
        
        Pickup.setCellValue("Pick up");
        segundaPrensa.setCellValue("2da Prensa");
        terceraSuperior.setCellValue("3ra Superior");
        terceraInferior.setCellValue("3ra Inferior");
        telaSup.setCellValue("Tela Superior");
        telaInf.setCellValue("Tela Inferior");
        manta.setCellValue("Manta");
        cTransversal.setCellValue("C. Transversal");
        exHumedo.setCellValue("Tela Extremo Humedo");
        exSeco.setCellValue("Tela Extremo Seco");
        cintaEn.setCellValue("Cinta Enhebrado");
        chp1.setCellValue("CHP1");
        chp2.setCellValue("CHP2");
        chp3.setCellValue("CHP3");
        chs.setCellValue("CHS");
        cht.setCellValue("CHT");

    }
    
    public boolean crearHojaActual(ArrayList<Equipo> equipos)
    {
        //System.out.println("creando hoja actual");
        //this.crearFilas();
        int cantidad = equipos.size();
        int codInt;
        String prov = "";
        String posi = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;

        
        for (int i = 0; i < cantidad; i++)
        {
            //System.out.println("nombre: "+equipos.get(i).getNombre());
            equipos.get(i).actualizarDiasOp();
            codInt = equipos.get(i).getCodInterno();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            this.creaFila(codInt, prov, posi, instalado, idcp, dOps, cambio, pop, "");
        }
        return true;
    }
    
    public void crearHojaPickUp(ArrayList<Equipo> equipos)
    {
        
        
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        
        for (int i = 0; i < cantidad; i++)
        {
            //System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            System.out.println("Causa: "+equipos.get(i).getCausaCambio());
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistoricaPickUp.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("Pick up");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");

            
        }
    }
    
    public void crearHoja2daPrensa(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistorica2daPrensa.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("2da Prensa");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }
    }
    public void crearHoja3raSup(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistorica3raSuperior.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("3ra Superior");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }
    }
    public void crearHoja3raInf(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistorica3raInferior.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("3ra Inferior");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }
    }
    public void crearHojaTelaSup(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistorica3TelaSup.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("Tela Superior");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }
    }
    public void crearHojaTelaInf(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistorica3TelaInf.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("Tela Inferior");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }
    }
    
    public void crearHojaManta(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistoricaManta.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("Manta");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }
    }
    
    public void crearHojaTransversal(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistoricaTransversal.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("C. Transversal");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }
    }
    public void crearHojaExHum(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistoricaExHumedo.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("Tela Extremo Humedo");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }
    }
    public void crearHojaExSec(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistoricaExSeco.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("Tela Extremo Seco");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }
    }
    public void crearHojaCintaEn(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistoricaCintaEn.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("Cinta Enhebrado");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }
    }
    public void crearHojaCHP1(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistoricaCHP1.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("CHP1");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }
    }
    
    public void crearHojaCHP2(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistoricaCHP2.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("CHP2");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }

    }
    
    public void crearHojaCHP3(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistoricaCHP3.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("CHP3");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }

    }
    
    public void crearHojaCHS(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistoricaCHS.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("CHS");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }

    }
    
    public void crearHojaCHT(ArrayList<Equipo> equipos)
    {
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String idcp = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        String causa = "";
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            idcp = equipos.get(i).getIdCajaPaño();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            causa = equipos.get(i).getCausaCambio();
            

            Row fila = this.hojaHistoricaCHT.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("CHT");
            this.crearFilaHPickup(fila, prov, instalado, idcp, dOps, cambio, pop, causa);
            //System.out.println("fila creada");
        }

    }
    
    
    
    public void crearPlantilla()
    {
        this.anadeFilaEncabezado();
        this.crearFilas();
    }
    
    private void creaFila(int i, String pro, String pos, String inst,
            String est,int dO, String cam, int pop, String causaCambio)
    {
        if(i == 0)
        {
            this.crearFilaPickup(pro, inst, est, dO, cam, pop);
        }
        if(i == 1)
        {
            this.crearFila2daPrensa(pro, inst, est, dO, cam, pop);
        }
        if(i == 2)
        {
            this.crearFila3raSup(pro, inst, est, dO, cam, pop);
        }
        if(i == 3)
        {
            this.crearFila3raInf(pro, inst, est, dO, cam, pop);
        }
        if(i == 4)
        {
            this.crearFilaTelaSup(pro, inst, est, dO, cam, pop);
        }
        if(i == 5)
        {
            this.crearFilaTelaInf(pro, inst, est, dO, cam, pop);
        }
        if(i == 6)
        {
            this.crearFilaManta(pro, inst, est, dO, cam, pop);
        }
        if(i == 7)
        {
            this.crearFilaCT(pro, inst, est, dO, cam, pop);
        }
        if(i == 8)
        {
            this.crearFilaExHum(pro, inst, est, dO, cam, pop);
        }
        if(i == 9)
        {
            this.crearFilaExSec(pro, inst, est, dO, cam, pop);
        }
        if(i == 10)
        {
            this.crearFilaCintaEn(pro, inst, est, dO, cam, pop);
        }
        if(i == 11)
        {
            this.crearFilaCHP1(pro, inst, est, dO, cam, pop);
        }
        if(i == 12)
        {
            this.crearFilaCHP2(pro, inst, est, dO, cam, pop);
        }
        if(i == 13)
        {
            this.crearFilaCHP3(pro, inst, est, dO, cam, pop);
        }
        if(i == 14)
        {
            this.crearFilaCHS(pro, inst, est, dO, cam, pop);
        }
        if(i == 15)
        {
            this.crearFilaCHT(pro, inst, est, dO, cam, pop);
        }
    }

    private void crearFilaPickup(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.filaPickUp.createCell(i);
        ////Cell posi = this.filaPickUp.createCell(i+1);
        Cell instalado = this.filaPickUp.createCell(i+1);
        Cell estado = this.filaPickUp.createCell(i+2);
        Cell dOps = this.filaPickUp.createCell(i+3);
        Cell cambio = this.filaPickUp.createCell(i+4);
        Cell planOp = this.filaPickUp.createCell(i+5);
        //Cell causa = this.filaPickUp.createCell(i+6);
        
        prov.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        //causa.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
        //causa.setCellValue(causaCambio);
    }
    
        private void crearFilaHPickup(Row fila, String pro, String inst,
            String est,int dO, String cam, int pop, String causa) 
    {
        int i = 1;
        Cell prov = fila.createCell(i);
        ////Cell posi = fila.createCell(i+1);
        Cell instalado = fila.createCell(i+1);
        Cell estado = fila.createCell(i+2);
        Cell dOps = fila.createCell(i+3);
        Cell cambio = fila.createCell(i+4);
        Cell planOp = fila.createCell(i+5);
        Cell causas = fila.createCell(i+6);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        causas.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
        causas.setCellValue(causa);
    }

    private void crearFila2daPrensa(String pro, String inst,
            String est,int dO, String cam, int pop)  
    {
        int i = 1;
        Cell prov = this.fila2daPrensa.createCell(i);
        //Cell posi = this.fila2daPrensa.createCell(2);
        Cell instalado = this.fila2daPrensa.createCell(i+1);
        Cell estado = this.fila2daPrensa.createCell(i+2);
        Cell dOps = this.fila2daPrensa.createCell(i+3);
        Cell cambio = this.fila2daPrensa.createCell(i+4);
        Cell planOp = this.fila2daPrensa.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);    
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }

    private void crearFila3raSup(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.fila3raSuperior.createCell(i);
        //Cell posi = this.fila3raSuperior.createCell(2);
        Cell instalado = this.fila3raSuperior.createCell(i+1);
        Cell estado = this.fila3raSuperior.createCell(i+2);
        Cell dOps = this.fila3raSuperior.createCell(i+3);
        Cell cambio = this.fila3raSuperior.createCell(i+4);
        Cell planOp = this.fila3raSuperior.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }

    private void crearFila3raInf(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.fila3raInferior.createCell(i);
        //Cell posi = this.fila3raInferior.createCell(2);
        Cell instalado = this.fila3raInferior.createCell(i+1);
        Cell estado = this.fila3raInferior.createCell(1+2);
        Cell dOps = this.fila3raInferior.createCell(i+3);
        Cell cambio = this.fila3raInferior.createCell(i+4);
        Cell planOp = this.fila3raInferior.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }

    private void crearFilaTelaSup(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.filaTelaSup.createCell(i);
        //Cell posi = this.filaTelaSup.createCell(2);
        Cell instalado = this.filaTelaSup.createCell(i+1);
        Cell estado = this.filaTelaSup.createCell(i+2);
        Cell dOps = this.filaTelaSup.createCell(i+3);
        Cell cambio = this.filaTelaSup.createCell(i+4);
        Cell planOp = this.filaTelaSup.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }

    private void crearFilaTelaInf(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.filaTelaInf.createCell(i);
        //Cell posi = this.filaTelaInf.createCell(i+1);
        Cell instalado = this.filaTelaInf.createCell(i+1);
        Cell estado = this.filaTelaInf.createCell(i+2);
        Cell dOps = this.filaTelaInf.createCell(i+3);
        Cell cambio = this.filaTelaInf.createCell(i+4);
        Cell planOp = this.filaTelaInf.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }

    private void crearFilaManta(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.filaManta.createCell(i);
        //Cell posi = this.filaManta.createCell(2);
        Cell instalado = this.filaManta.createCell(i+1);
        Cell estado = this.filaManta.createCell(i+2);
        Cell dOps = this.filaManta.createCell(i+3);
        Cell cambio = this.filaManta.createCell(i+4);
        Cell planOp = this.filaManta.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }

    private void crearFilaCT(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.filacTransversal.createCell(1);
        //Cell posi = this.filacTransversal.createCell(2);
        Cell instalado = this.filacTransversal.createCell(i+1);
        Cell estado = this.filacTransversal.createCell(i+2);
        Cell dOps = this.filacTransversal.createCell(i+3);
        Cell cambio = this.filacTransversal.createCell(i+4);
        Cell planOp = this.filacTransversal.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }
    
        private void crearFilaExHum(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.filaExHumedo.createCell(1);
        //Cell posi = this.filaExHumedo.createCell(2);
        Cell instalado = this.filaExHumedo.createCell(i+1);
        Cell estado = this.filaExHumedo.createCell(i+2);
        Cell dOps = this.filaExHumedo.createCell(i+3);
        Cell cambio = this.filaExHumedo.createCell(i+4);
        Cell planOp = this.filaExHumedo.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }
        
    private void crearFilaExSec(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.filaExSeco.createCell(1);
        //Cell posi = this.filaExSeco.createCell(2);
        Cell instalado = this.filaExSeco.createCell(i+1);
        Cell estado = this.filaExSeco.createCell(i+2);
        Cell dOps = this.filaExSeco.createCell(i+3);
        Cell cambio = this.filaExSeco.createCell(i+4);
        Cell planOp = this.filaExSeco.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }
    private void crearFilaCintaEn(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.filaCintaEn.createCell(1);
        //Cell posi = this.filaCintaEn.createCell(2);
        Cell instalado = this.filaCintaEn.createCell(i+1);
        Cell estado = this.filaCintaEn.createCell(i+2);
        Cell dOps = this.filaCintaEn.createCell(i+3);
        Cell cambio = this.filaCintaEn.createCell(i+4);
        Cell planOp = this.filaCintaEn.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }
    private void crearFilaCHP1(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.filaCHP1.createCell(1);
        //Cell posi = this.filaCHP1.createCell(2);
        Cell instalado = this.filaCHP1.createCell(i+1);
        Cell estado = this.filaCHP1.createCell(i+2);
        Cell dOps = this.filaCHP1.createCell(i+3);
        Cell cambio = this.filaCHP1.createCell(i+4);
        Cell planOp = this.filaCHP1.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }
    
    private void crearFilaCHP2(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.filaCHP2.createCell(1);
        //Cell posi = this.filaCHP2.createCell(2);
        Cell instalado = this.filaCHP2.createCell(i+1);
        Cell estado = this.filaCHP2.createCell(i+2);
        Cell dOps = this.filaCHP2.createCell(i+3);
        Cell cambio = this.filaCHP2.createCell(i+4);
        Cell planOp = this.filaCHP2.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }
    
    private void crearFilaCHP3(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.filaCHP3.createCell(1);
        //Cell posi = this.filaCHP3.createCell(2);
        Cell instalado = this.filaCHP3.createCell(i+1);
        Cell estado = this.filaCHP3.createCell(i+2);
        Cell dOps = this.filaCHP3.createCell(i+3);
        Cell cambio = this.filaCHP3.createCell(i+4);
        Cell planOp = this.filaCHP3.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }
    
    private void crearFilaCHS(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.filaCHS.createCell(1);
        //Cell posi = this.filaCHS.createCell(2);
        Cell instalado = this.filaCHS.createCell(i+1);
        Cell estado = this.filaCHS.createCell(i+2);
        Cell dOps = this.filaCHS.createCell(i+3);
        Cell cambio = this.filaCHS.createCell(i+4);
        Cell planOp = this.filaCHS.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }
    
    private void crearFilaCHT(String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = this.filaCHT.createCell(1);
        //Cell posi = this.filaCHT.createCell(2);
        Cell instalado = this.filaCHT.createCell(i+1);
        Cell estado = this.filaCHT.createCell(i+2);
        Cell dOps = this.filaCHT.createCell(i+3);
        Cell cambio = this.filaCHT.createCell(i+4);
        Cell planOp = this.filaCHT.createCell(i+5);
        
        prov.setCellStyle(estiloCelda2);
        //posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        planOp.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        //posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
        planOp.setCellValue(pop);
    }
    

    void setEquipos(ArrayList equipos) 
    {
        this.equipos = equipos;
    }
    
}
