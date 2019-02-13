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
import java.util.Calendar;
import java.util.Date;
 
//Librerias de Apache POI.
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
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
    
    // estilo de las celdas con poscion de paños - telas
    private final CellStyle estiloCelda2;
    
    //Arraylist de los equipos
    private ArrayList equipos;
    
    
    Row filaPickUp;
    Row fila2daPrensa;
    Row fila3raSuperior;
    Row fila3raInferior;
    Row filaTelaSup;
    Row filaTelaInf;
    Row filaManta;
    Row filacTransversal;
    Row filaTDAB2;
    Row filaTDAB3;

    public SpreadSheet()
    {
        this.libro = new HSSFWorkbook();
        this.hojaTelas = this.libro.createSheet("Equipos actuales");
        this.estiloTitulo = getEstiloTitulo();
        this.estiloCelda = getEstiloCelda();
        this.estiloCelda2 = getEstiloCelda2();
        this.equipos = new ArrayList();
        //this.anadeFilaEncabezado();
        this.crearPlantilla();
        
        /*
        this.creaFila(0);
        this.creaFila(1);
        this.creaFila(2);
        this.creaFila(3);
        this.creaFila(4);
        this.creaFila(5);
        this.creaFila(6);
        this.creaFila(7);
        */
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
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Estado      ");
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
        this.ajustaColumnas();
        this.crearHojaActual(this.equipos);
        final OutputStream outputStream = new FileOutputStream("Telas.xls");
        try 
        {
            
            libro.write(outputStream);
            outputStream.close();
            
        } 
        catch (Exception e)
        {
            System.out.println("error");
        }
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
        

    public void crearFilas()
    {
        this.filaPickUp = this.getNuevaFila();
        this.fila2daPrensa = this.getNuevaFila();
        this.fila3raSuperior = this.getNuevaFila();
        this.fila3raInferior = this.getNuevaFila();
        this.filaTelaSup = this.getNuevaFila();
        this.filaTelaInf = this.getNuevaFila();
        this.filaManta = this.getNuevaFila();
        this.filacTransversal = this.getNuevaFila();
        this.filaTDAB2 = this.getNuevaFila();
        this.filaTDAB3 = this.getNuevaFila();
        
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
        System.out.println("dias fuera del for: "+equipos.get(0).getDiasOp());
        
        for (int i = 0; i < cantidad; i++)
        {
            codInt = equipos.get(i).getCodInterno();
            prov = equipos.get(i).getProveedor();
            posi = equipos.get(i).getPosi();
            instalado = df.format(equipos.get(i).getFechaIngreso().getTime());
            estado = equipos.get(i).getEstado();
            dOps = equipos.get(i).getDiasOp();
            if(equipos.get(i).getFechaSalida() != null){
            cambio = df.format(equipos.get(i).getFechaSalida().getTime());}
            System.out.println("fecha dentro del for: "+cambio);
            System.out.println("i: "+dOps);
            this.creaFila(codInt, prov, posi, instalado, estado, dOps, cambio);
        }
        return true;
    }
    
    public void crearPlantilla()
    {
        this.anadeFilaEncabezado();
        this.crearFilas();
    }
    
    private void creaFila(int i, String pro, String pos, String inst,
            String est,int dO, String cam)
    {
        if(i == 0)
        {
            this.crearFilaPickup(pro, pos, inst, est, dO, cam);
        }
        if(i == 1)
        {
            this.crearFila2daPrensa(pro, pos, inst, est, dO, cam);
        }
        if(i == 2)
        {
            this.crearFila3raSup(pro, pos, inst, est, dO, cam);
        }
        if(i == 3)
        {
            this.crearFila3raInf(pro, pos, inst, est, dO, cam);
        }
        if(i == 4)
        {
            this.crearFilaTelaSup(pro, pos, inst, est, dO, cam);
        }
        if(i == 5)
        {
            this.crearFilaTelaInf(pro, pos, inst, est, dO, cam);
        }
        if(i == 6)
        {
            this.crearFilaManta(pro, pos, inst, est, dO, cam);
        }
        if(i == 7)
        {
            this.crearFilaCT(pro, pos, inst, est, dO, cam);
        }

    }

    private void crearFilaPickup(String pro, String pos, String inst,
            String est,int dO, String cam) 
    {
        Cell prov = this.filaPickUp.createCell(1);
        Cell posi = this.filaPickUp.createCell(2);
        Cell instalado = this.filaPickUp.createCell(3);
        Cell estado = this.filaPickUp.createCell(4);
        Cell dOps = this.filaPickUp.createCell(5);
        Cell cambio = this.filaPickUp.createCell(6);
        
        prov.setCellStyle(estiloCelda2);
        posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
    }

    private void crearFila2daPrensa(String pro, String pos, String inst,
            String est,int dO, String cam)  
    {
        Cell prov = this.fila2daPrensa.createCell(1);
        Cell posi = this.fila2daPrensa.createCell(2);
        Cell instalado = this.fila2daPrensa.createCell(3);
        Cell estado = this.fila2daPrensa.createCell(4);
        Cell dOps = this.fila2daPrensa.createCell(5);
        Cell cambio = this.fila2daPrensa.createCell(6);
        
        prov.setCellStyle(estiloCelda2);
        posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);       
        
        prov.setCellValue(pro);
        posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
    }

    private void crearFila3raSup(String pro, String pos, String inst,
            String est,int dO, String cam) 
    {
        Cell prov = this.fila3raSuperior.createCell(1);
        Cell posi = this.fila3raSuperior.createCell(2);
        Cell instalado = this.fila3raSuperior.createCell(3);
        Cell estado = this.fila3raSuperior.createCell(4);
        Cell dOps = this.fila3raSuperior.createCell(5);
        Cell cambio = this.fila3raSuperior.createCell(6);
        
        prov.setCellStyle(estiloCelda2);
        posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
    }

    private void crearFila3raInf(String pro, String pos, String inst,
            String est,int dO, String cam) 
    {
        Cell prov = this.fila3raInferior.createCell(1);
        Cell posi = this.fila3raInferior.createCell(2);
        Cell instalado = this.fila3raInferior.createCell(3);
        Cell estado = this.fila3raInferior.createCell(4);
        Cell dOps = this.fila3raInferior.createCell(5);
        Cell cambio = this.fila3raInferior.createCell(6);
        
        prov.setCellStyle(estiloCelda2);
        posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
    }

    private void crearFilaTelaSup(String pro, String pos, String inst,
            String est,int dO, String cam) 
    {
        Cell prov = this.filaTelaSup.createCell(1);
        Cell posi = this.filaTelaSup.createCell(2);
        Cell instalado = this.filaTelaSup.createCell(3);
        Cell estado = this.filaTelaSup.createCell(4);
        Cell dOps = this.filaTelaSup.createCell(5);
        Cell cambio = this.filaTelaSup.createCell(6);
        
        prov.setCellStyle(estiloCelda2);
        posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
    }

    private void crearFilaTelaInf(String pro, String pos, String inst,
            String est,int dO, String cam) 
    {
        Cell prov = this.filaTelaInf.createCell(1);
        Cell posi = this.filaTelaInf.createCell(2);
        Cell instalado = this.filaTelaInf.createCell(3);
        Cell estado = this.filaTelaInf.createCell(4);
        Cell dOps = this.filaTelaInf.createCell(5);
        Cell cambio = this.filaTelaInf.createCell(6);
        
        prov.setCellStyle(estiloCelda2);
        posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
    }

    private void crearFilaManta(String pro, String pos, String inst,
            String est,int dO, String cam) 
    {
        Cell prov = this.filaManta.createCell(1);
        Cell posi = this.filaManta.createCell(2);
        Cell instalado = this.filaManta.createCell(3);
        Cell estado = this.filaManta.createCell(4);
        Cell dOps = this.filaManta.createCell(5);
        Cell cambio = this.filaManta.createCell(6);
        
        prov.setCellStyle(estiloCelda2);
        posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
    }

    private void crearFilaCT(String pro, String pos, String inst,
            String est,int dO, String cam) 
    {
        Cell prov = this.filacTransversal.createCell(1);
        Cell posi = this.filacTransversal.createCell(2);
        Cell instalado = this.filacTransversal.createCell(3);
        Cell estado = this.filacTransversal.createCell(4);
        Cell dOps = this.filacTransversal.createCell(5);
        Cell cambio = this.filacTransversal.createCell(6);
        
        prov.setCellStyle(estiloCelda2);
        posi.setCellStyle(estiloCelda2);
        instalado.setCellStyle(estiloCelda2);
        estado.setCellStyle(estiloCelda2);
        dOps.setCellStyle(estiloCelda2);
        cambio.setCellStyle(estiloCelda2);
        
        prov.setCellValue(pro);
        posi.setCellValue(pos);
        instalado.setCellValue(inst);
        estado.setCellValue(est);
        dOps.setCellValue(dO);
        cambio.setCellValue(cam);
    }


    void setEquipos(ArrayList equipos) 
    {
        this.equipos = equipos;
    }
}
