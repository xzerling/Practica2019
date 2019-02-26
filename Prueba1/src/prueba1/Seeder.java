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
import org.apache.poi.ss.usermodel.Cell;
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
            /*Sheet hojaHistorica2daPrensa = libro.getSheetAt(2);
            Sheet hojaHistorica3raSuperior = libro.getSheetAt(3);
            Sheet hojaHistorica3raInferior = libro.getSheetAt(4);
            Sheet hojaHistorica3TelaSup = libro.getSheetAt(5);
            Sheet hojaHistorica3TelaInf = libro.getSheetAt(6);
            Sheet hojaHistoricaManta = libro.getSheetAt(7);
            Sheet hojaHistoricaTransversal = libro.getSheetAt(8);
            Sheet hojaHistoricaExHumedo = libro.getSheetAt(9);
            
            Sheet hojaHistoricaExSeco = libro.getSheetAt(10);*/
            
            int i = 0;
            int j = 0;
            //Iterator iterator = hojaActual.iterator();
            
            DataFormatter formato = new DataFormatter();
            for (int k = 0; k < 17; k++)
            {
                //System.out.println("fila "+k);
                for (int l = 0; l < 8; l++) 
                {
                    //System.out.println("celda : "+formato.formatCellValue(hojaActual.getRow(k).getCell(l)));
                }
                
            }
            
            //System.out.println("celda 1: "+formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1)));
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));

                actual.add(this.completarEquipo(this.creador.crearPickUp(), pro, fechaI, est, dop, fechaS, po));
            }
            
            j=j+1;
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
            String pro2 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
            String fechaI2 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
            String est2 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
            int dop2 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
            /*
            System.out.println("celda 1: "+formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1)));
            System.out.println("celda 2: "+formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2)));
            System.out.println("celda 3: "+formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3)));
            System.out.println("celda 4: "+formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
            System.out.println("celda 5: "+formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5)));*/
            String fechaS2 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
            int po2 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));
            
            actual.add(this.completarEquipo(this.creador.crear2daPrensa(), pro2, fechaI2, est2, dop2, fechaS2, po2));
            }
            
            
            j=j+1;
            //System.out.println("3ra sup: "+hojaActual.getRow(j+1).getCell(i+1));
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));


                actual.add(this.completarEquipo(this.creador.crear3raSuperior(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }
            
            j=j+1;
            //System.out.println("j: "+j);
            //System.out.println("3ra inf: "+formato.formatCellValue(hojaActual.getRow(j+1).getCell(i)));
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));

                actual.add(this.completarEquipo(this.creador.crear3raInferior(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }
            j=j+1;
            //System.out.println("Telasup: "+formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1)));
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));
            
                actual.add(this.completarEquipo(this.creador.crearTelaSuperior(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }
            
            j=j+1;
            //System.out.println("Telainf: "+formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1)));
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));

                actual.add(this.completarEquipo(this.creador.crearTelaInferior(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }
            
            j=j+1;
            //System.out.println("celda 1: "+formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1)));
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));

                actual.add(this.completarEquipo(this.creador.crearManta(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }
            
            j=j+1;
            //System.out.println("celda 1: "+formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1)));
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));

                actual.add(this.completarEquipo(this.creador.crearCTrnasversal(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }
            
            j=j+1;
            //System.out.println("celda 1: "+formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1)));
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));

                actual.add(this.completarEquipo(this.creador.crearExHumedo(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }
            
            j=j+1;
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));

                actual.add(this.completarEquipo(this.creador.crearExSeco(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }
            
            j=j+1;
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));

                actual.add(this.completarEquipo(this.creador.crearCintaEn(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }
            
            j=j+1;
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));

                actual.add(this.completarEquipo(this.creador.crearCHP1(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }
            
            j=j+1;
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));

                actual.add(this.completarEquipo(this.creador.crearCHP2(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }
            
            j=j+1;
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));

                actual.add(this.completarEquipo(this.creador.crearCHP3(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }
            
            j=j+1;
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));

                actual.add(this.completarEquipo(this.creador.crearCHS(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }
            
            j=j+1;
            if(hojaActual.getRow(j+1) != null && hojaActual.getRow(j+1).getCell(i+1)!= null)
            {
                String pro3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+1));
                String fechaI3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+2));
                String est3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+3));
                int dop3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+4)));
                String fechaS3 = formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+5));
                int po3 = Integer.parseInt(formato.formatCellValue(hojaActual.getRow(j+1).getCell(i+6)));

                actual.add(this.completarEquipo(this.creador.crearCHT(), pro3, fechaI3, est3, dop3, fechaS3, po3));
            }

        }
        return actual;
    }
    
    public ArrayList<Equipo> cargarArrayPickUp() throws IOException, ParseException
    {
        ArrayList pickUp = new ArrayList();
        try (FileInputStream file = new FileInputStream(bd))
        {
            Workbook libro = new HSSFWorkbook(file);
            Sheet hojaHistoricaPickUp = libro.getSheetAt(1);
            DataFormatter formato = new DataFormatter();
            for (Row row : hojaHistoricaPickUp)
            {
                if(row.getRowNum()!= 0)
                {
                    //System.out.println("cargando los pickups");
                    String pro1 = formato.formatCellValue(row.getCell(1));
                    String fechaI1 = formato.formatCellValue(row.getCell(2));
                    String est1 = formato.formatCellValue(row.getCell(3));
                    int dop1 = Integer.parseInt(formato.formatCellValue(row.getCell(4)));
                    String fechaS1 = formato.formatCellValue(row.getCell(5));
                    int po1 = Integer.parseInt(formato.formatCellValue(row.getCell(6)));
                    pickUp.add(this.completarEquipo(this.creador.crearPickUp(), pro1, fechaI1, est1, dop1, fechaS1, po1));
                }
                else
                {
                    //System.out.println("hola");
                }
            }
        }
        return pickUp;
    }
    
    public ArrayList<Equipo> cargar2daPrensa() throws IOException, ParseException
    {
        //System.out.println("***************cargando 2da prensa*******************");
        ArrayList array = new ArrayList();
        try (FileInputStream file = new FileInputStream(bd))
        {
            Workbook libro = new HSSFWorkbook(file);
            Sheet hojaHistoricaPickUp = libro.getSheetAt(2);
            DataFormatter formato = new DataFormatter();
            for (Row row : hojaHistoricaPickUp)
            {
                if(row.getRowNum()!= 0)
                {
                    String pro1 = formato.formatCellValue(row.getCell(1));
                    String fechaI1 = formato.formatCellValue(row.getCell(2));
                    String est1 = formato.formatCellValue(row.getCell(3));
                    int dop1 = Integer.parseInt(formato.formatCellValue(row.getCell(4)));
                    String fechaS1 = formato.formatCellValue(row.getCell(5));
                    //System.out.println("fechaS en cargar: "+fechaS1);
                    int po1 = Integer.parseInt(formato.formatCellValue(row.getCell(6)));
                    array.add(this.completarEquipo(this.creador.crear2daPrensa(), pro1, fechaI1, est1, dop1, fechaS1, po1));
                }
                else
                {
                    //System.out.println("hola");
                }
            }
        }
        return array;
    }
    
    
    private Equipo completarEquipo(Equipo equipo, String pro, String fechaI, String idcp, int dop, String fechaS, int pop) throws ParseException
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
        //equipo.setFechaIngreso(calI);
        //equipo.setFechaSalida(calS);
        equipo.setPlanOperativo(pop);
        
      

        return equipo;
    }    
}
