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
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Zerling
 */
public class Seeder
{
    private CreaEquipo creador;
    
    public Seeder()
    {
        this.creador = new CreaEquipo();
    }
    public Workbook cargarBD() throws FileNotFoundException, IOException
    {
        Workbook libro = new HSSFWorkbook();

        try (FileInputStream file = new FileInputStream("BD.xls"))
        {
            libro = new HSSFWorkbook(file);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("error al cargar el archivo: "+e);
        }
        return libro;
    }
    
    public ArrayList<Equipo> cargarArray() throws IOException, ParseException
    {
        ArrayList actual = new ArrayList();
        try (FileInputStream file = new FileInputStream("BD.xls"))
        {
            
            Workbook libro = new HSSFWorkbook(file);
            Sheet hojaActual = libro.getSheetAt(0);
            Sheet hojaHistoricaPickUp = libro.getSheetAt(1);
            Sheet hojaHistorica2daPrensa = libro.getSheetAt(2);
            Sheet hojaHistorica3raSuperior = libro.getSheetAt(3);
            Sheet hojaHistorica3raInferior = libro.getSheetAt(4);
            Sheet hojaHistorica3TelaSup = libro.getSheetAt(5);
            Sheet hojaHistorica3TelaInf = libro.getSheetAt(6);
            Sheet hojaHistoricaManta = libro.getSheetAt(7);
            Sheet hojaHistoricaTransversal = libro.getSheetAt(8);
            Sheet hojaHistoricaExHumedo = libro.getSheetAt(9);
            
            Sheet hojaHistoricaExSeco = libro.getSheetAt(10);
            
            int i = 0;
            int j = 0;
            Iterator iterator = hojaActual.iterator();
            
            DataFormatter formato = new DataFormatter();
            
            String pro = formato.formatCellValue(hojaActual.getRow(i+1).getCell(i+1));
            String fechaI = formato.formatCellValue(hojaActual.getRow(i+1).getCell(i+2));
            String est = formato.formatCellValue(hojaActual.getRow(i+1).getCell(i+3));
            int dop = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(i+1).getCell(i+4)));
            String fechaS = formato.formatCellValue(hojaActual.getRow(i+1).getCell(i+5));
            int po = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(i+1).getCell(i+6)));
            
            actual.add(this.completarEquipo(this.creador.crearPickUp(), pro, fechaI, est, dop, fechaS, po));
            return actual;
            
            
        } 
    }
    
    
    private Equipo completarEquipo(Equipo equipo, String pro, String fechaI, String est, int dop, String fechaS, int pop) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
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
        equipo.setEstado(est);
        equipo.setDiasOp(dop);
        //equipo.setFechaIngreso(calI);
        //equipo.setFechaSalida(calS);
        equipo.setPlanOperativo(pop);
        
      

        return equipo;
    }    
}
