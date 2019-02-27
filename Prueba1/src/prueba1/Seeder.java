/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Zerling
 */
public class Seeder
{
    private CreaEquipo creador;
    private String bd;
    
    public Seeder()
    {
        this.creador = new CreaEquipo();
        this.bd = "BD.xls";
    }
    
    public Workbook cargarBD() throws FileNotFoundException, IOException
    {
        Workbook libro = new HSSFWorkbook();

        try (FileInputStream file = new FileInputStream(bd))
        {
            libro = new HSSFWorkbook(file);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("error al cargar el archivo: "+e);
        }
        return libro;
    }
    
    public ArrayList<Equipo> cargarArrayActual() throws IOException, ParseException
    {
        ArrayList actual = new ArrayList();
        try (FileInputStream file = new FileInputStream(bd))
        {
            Workbook libro = new HSSFWorkbook(file);
            Sheet hojaActual = libro.getSheetAt(0);
            
            DataFormatter formato = new DataFormatter();
            
            for (int k = 0; k < 16; k++)
            {
                if(hojaActual.getRow(k+1) != null)
                {
                    int l=0;
                    if(hojaActual.getRow(k+1).getCell(l+1) != null)
                    {
                        String pro = formato.formatCellValue(hojaActual.getRow(k+1).getCell(l+1));
                        String fechaI = formato.formatCellValue(hojaActual.getRow(k+1).getCell(l+2));
                        String est = formato.formatCellValue(hojaActual.getRow(k+1).getCell(l+3));
                        int dop = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(k+1).getCell(l+4)));
                        String fechaS = formato.formatCellValue(hojaActual.getRow(k+1).getCell(l+5));
                        int po = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(k+1).getCell(l+6)));

                        actual.add(this.completarEquipo(this.selCreador(k), pro, fechaI, est, dop, fechaS, po, ""));
                    }
                    l=0;
                }
            }
        }
        return actual;
    }
    
    public ArrayList<Equipo> cargarHojas(int cod) throws ParseException, FileNotFoundException, IOException
    {
        ArrayList array = new ArrayList();
        try (FileInputStream file = new FileInputStream(bd))
        {
            Workbook libro = new HSSFWorkbook(file);
            Sheet hoja = libro.getSheetAt(cod+1);
            DataFormatter formato = new DataFormatter();
            for (Row row : hoja)
            {
                if(row.getRowNum()!= 0)
                {
                    /*
                    System.out.println("celda: "+formato.formatCellValue(row.getCell(1)));
                    System.out.println("celda: "+formato.formatCellValue(row.getCell(2)));
                    System.out.println("celda: "+formato.formatCellValue(row.getCell(3)));
                    System.out.println("celda: "+formato.formatCellValue(row.getCell(4)));
                    System.out.println("celda: "+formato.formatCellValue(row.getCell(5)));
                    System.out.println("celda: "+formato.formatCellValue(row.getCell(6)));
                    System.out.println("celda: "+formato.formatCellValue(row.getCell(7)));*/
                    
                    String pro1 = formato.formatCellValue(row.getCell(1));
                    String fechaI1 = formato.formatCellValue(row.getCell(2));
                    String est1 = formato.formatCellValue(row.getCell(3));
                    int dop1 = Integer.parseInt(formato.formatCellValue(row.getCell(4)));
                    String fechaS1 = formato.formatCellValue(row.getCell(5));
                    int po1 = Integer.parseInt(formato.formatCellValue(row.getCell(6)));
                    String cau = formato.formatCellValue(row.getCell(7));
                    array.add(this.completarEquipo(this.selCreador(cod), pro1, fechaI1, est1, dop1, fechaS1, po1, cau));
                }
                else
                {
                }
            }
        }
        return array;
    }
    
    private Equipo selCreador(int i)
    {
        if (i == 0)
        {
            return this.creador.crearPickUp();
        }
        else if (i == 1)
        {
            return this.creador.crear2daPrensa();
        }
        else if (i == 2)
        {
            return this.creador.crear3raSuperior();
        }
        else if (i == 3)
        {
            return this.creador.crear3raInferior();
        }
        else if (i == 4)
        {
            return this.creador.crearTelaSuperior();
        }
        else if (i == 5)
        {
            return this.creador.crearTelaInferior();
        }
        else if (i == 6)
        {
            return this.creador.crearManta();
        }
        else if (i == 7)
        {
            return this.creador.crearCTrnasversal();
        }
        else if (i == 8)
        {
            return this.creador.crearExHumedo();
        }
        else if (i == 9)
        {
            return this.creador.crearExSeco();
        }
        else if (i == 10)
        {
            return this.creador.crearCintaEn();
        }
        else if (i == 11)
        {
            return this.creador.crearCHP1();
        }
        else if (i == 12)
        {
            return this.creador.crearCHP2();
        }
        else if (i == 13)
        {
            return this.creador.crearCHP3();
        }
        else if (i == 14)
        {
            return this.creador.crearCHS();
        }
        else if (i == 15)
        {
            return this.creador.crearCHT();
        }
        return null;
    }
    
    private Equipo completarEquipo(Equipo equipo, String pro, String fechaI, String idcp, int dop, String fechaS, int pop, String cau) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        /*
        System.out.println("nombre: "+equipo.getNombre());
        System.out.println("proveedor: "+pro);
        System.out.println("fechai: "+fechaI);
        System.out.println("fechaS: "+fechaS);
        System.out.println("plan Op: "+pop);*/
        Calendar calI = Calendar.getInstance();
        Calendar calS = Calendar.getInstance();
        try
        {
            Date dI = sdf.parse(fechaI);
            calI.setTime(dI);
            equipo.setFechaIngreso(calI);
        }
        catch(ParseException e)
        {
            equipo.setFechaIngreso(null);
            System.out.println("error en cargar la fecha de Ingreso: "+ e);
        }
        try
        {
            Date dS = sdf.parse(fechaS);
            calS.setTime(dS);
            equipo.setFechaSalida(calS);
        }
        catch(ParseException e)
        {
            equipo.setFechaSalida(null);
            System.out.println("error en cargar la fecha de Salida: "+ e);
        }
        
        equipo.setProveedor(pro);
        equipo.setIdCajaPaño(idcp);
        equipo.setDiasOp(dop);
        equipo.setPlanOperativo(pop);
        equipo.setCausaCambio(cau);
        
      

        return equipo;
    }    
}
