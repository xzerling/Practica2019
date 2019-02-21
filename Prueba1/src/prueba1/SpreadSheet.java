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
    
    // crea la fila y celdas del encabezado con el nombre de las columnas
    private void anadeFilaEncabezado()
    {
        final Row filaEncabezado = getNuevaFila(this.hojaActual);
        final Row filaEncabezado2 = getNuevaFila(this.hojaHistoricaPickUp);
        int numeroCelda = 0;
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Instalado");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Estado      ");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Plan Operativo");
        numeroCelda = 0;
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Posición paños - telas");
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Proveedor");
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Instalado");
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Estado      ");
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Días de operacion");
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Proximo cambio");
        creaCeldaEncabezado(filaEncabezado2, numeroCelda++, "Plan Operativo");

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
        this.crearHojaActual(this.equipos);
        this.crearHojaPickUp(this.arrayPickUp);
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
        pickup.setCellValue("PickUp");
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
        
        Cell Pickup = filaPickUp.createCell(0);
        Cell segundaPrensa = fila2daPrensa.createCell(0);
        Cell terceraSuperior = fila3raSuperior.createCell(0);
        Cell terceraInferior = fila3raInferior.createCell(0);
        Cell telaSup = filaTelaSup.createCell(0);
        Cell telaInf = filaTelaInf.createCell(0);
        Cell manta = filaManta.createCell(0);
        Cell cTransversal = filacTransversal.createCell(0);
        Cell Humedo = filaExHumedo.createCell(0);
        Cell Seco = filaExSeco.createCell(0);
        
        Pickup.setCellStyle(estiloCelda);
        segundaPrensa.setCellStyle(estiloCelda);
        terceraSuperior.setCellStyle(estiloCelda);
        terceraInferior.setCellStyle(estiloCelda);
        telaSup.setCellStyle(estiloCelda);
        telaInf.setCellStyle(estiloCelda);
        manta.setCellStyle(estiloCelda);
        cTransversal.setCellStyle(estiloCelda);
        Humedo.setCellStyle(estiloCelda);
        Seco.setCellStyle(estiloCelda);
        
        Pickup.setCellValue("Pick up");
        segundaPrensa.setCellValue("2da Prensa");
        terceraSuperior.setCellValue("3ra Superior");
        terceraInferior.setCellValue("3ra Inferior");
        telaSup.setCellValue("Tela Superior");
        telaInf.setCellValue("Tela Inferior");
        manta.setCellValue("Manta");
        cTransversal.setCellValue("C. Transversal");
        Humedo.setCellValue("Tela Extremo Humedo");
        Seco.setCellValue("Tela Extremo Seco");
        
    }
    
    public boolean crearHojaActual(ArrayList<Equipo> equipos)
    {
        //System.out.println("creando hoja actual");
        int cantidad = equipos.size();
        int codInt;
        String prov = "";
        String posi = "";
        String instalado = "";
        String estado = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        
        for (int i = 0; i < cantidad; i++)
        {
            equipos.get(i).actualizarDiasOp();
            codInt = equipos.get(i).getCodInterno();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            estado = equipos.get(i).getEstado();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            this.creaFila(codInt, prov, posi, instalado, estado, dOps, cambio, pop);
        }
        return true;
    }
    
    public void crearHojaPickUp(ArrayList<Equipo> equipos)
    {
        
        
        int cantidad = equipos.size();
        String prov = "";
        String instalado = "";
        String estado = "";
        int dOps;
        String cambio = "";
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int pop;
        for (int i = 0; i < cantidad; i++)
        {
            System.out.println("i: "+i);
            equipos.get(i).actualizarDiasOp();
            prov = equipos.get(i).getProveedor();
            //posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            estado = equipos.get(i).getEstado();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            //equipos.get(i).print();
            pop = equipos.get(i).getPlanOperativo();
            

            Row fila = this.hojaHistoricaPickUp.createRow(i+1);
            Cell pickup = fila.createCell(0);
            pickup.setCellStyle(estiloCelda);
            pickup.setCellValue("PickUp");
            this.crearFilaHPickup(fila, prov, instalado, estado, dOps, cambio, pop);
            System.out.println("fila creada");

            
        }
    }
    
    
    public void crearPlantilla()
    {
        this.anadeFilaEncabezado();
        this.crearFilas();
    }
    
    private void creaFila(int i, String pro, String pos, String inst,
            String est,int dO, String cam, int pop)
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
    
        private void crearFilaHPickup(Row fila, String pro, String inst,
            String est,int dO, String cam, int pop) 
    {
        int i = 1;
        Cell prov = fila.createCell(i);
        ////Cell posi = fila.createCell(i+1);
        Cell instalado = fila.createCell(i+1);
        Cell estado = fila.createCell(i+2);
        Cell dOps = fila.createCell(i+3);
        Cell cambio = fila.createCell(i+4);
        Cell planOp = fila.createCell(i+5);
        
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


    void setEquipos(ArrayList equipos) 
    {
        this.equipos = equipos;
    }
    
}
