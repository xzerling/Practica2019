/*
 * Systema de administracion de telas y paños.
 * Superintendencia de Maquinas, Planta Nueva Aldea.
 * Arauco 2019 - Practica Profesional.
 */


package prueba1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Álvaro Elgueda Labra - Univerisad de Talca.
 * 
 */

public class Sistema 
{
    private Lector lector;
    private Menu menu;
    private CreaEquipo creador;
    //private ArrayList equipos;
    private Datos datos;
    private Seeder seeder;
    private Flag flags;
    private int opcion;
    private SpreadSheet libro;
    private SimpleDateFormat sdf;

    public Sistema()
    {
        this.lector = new Lector();
        this.menu = new Menu();
       //this.equipos = new ArrayList();
        this.datos = new Datos();
        this.seeder = new Seeder();
        this.flags = new Flag();
        this.creador = new CreaEquipo();
        this.opcion = -1;
        this.libro = new SpreadSheet();
        
        this.sdf = new SimpleDateFormat("dd-MM-yyyy");
    }
    
    private Equipo buscarEquipo(int cod)
    {
        if(this.datos.getActual().size()>0)
        {
            for (int i = 0; i < this.datos.getActual().size(); i++)
            {
                Equipo equipo = (Equipo) this.datos.getActual().get(i);
                if (equipo.getCodigoSap() == cod)
                {
                    return equipo;
                }
                return null;
            }
        }
        else
        {
            System.out.println("No existen maquinas en el registro.");
            System.out.println("");
        }
        return null;
    }
    
    private boolean hayEquipos()
    {
            return this.datos.getActual().size()>0;
    }

    private void listarEquipos()
    {
        if(this.datos.getActual().size()>0)
        {
            for (int i = 0; i < this.datos.getActual().size(); i++)
            {
                int n = i+1;
                System.out.println("Maquina n°"+n+": ");
                Equipo equipo = (Equipo) this.datos.getActual().get(i);
                equipo.print();
                System.out.println("");
            }
        }
        else{
            System.out.println("No existen maquinas en el registro.");
            System.out.println("");
        }
    }
    
    private boolean borrarEquipo(int cod)
    {
        if(this.datos.getActual().size()>0)
        {
            for (int i = 0; i < this.datos.getActual().size(); i++)
            {
                Equipo equipo = this.datos.getActual().get(i);
                if (equipo.getCodInterno() == cod)
                {
                    this.datos.getActual().remove(i);
                }
                return true;
            }
        }
        else
        {
            System.out.println("No existen maquinas en el registro.");
            System.out.println("");
            return false;
        }
        return false;
    }
    
    private void verificarExsistencia(ArrayList<Equipo> actual)
    {
        for (int i = 0; i < actual.size(); i++) 
        {
            if(actual.get(i).getCodInterno() == 0)
            {
                this.flags.setfPickUp(true);
            }
            else if(actual.get(i).getCodInterno() == 1)
            {
                this.flags.setF2daPrensa(true);
            }
            else if(actual.get(i).getCodInterno() == 2)
            {
                this.flags.setF3raSuperior(true);
            }
            else if(actual.get(i).getCodInterno() == 3)
            {
                this.flags.setF3raInferior(true);
            }
            else if(actual.get(i).getCodInterno() == 4)
            {
                this.flags.setF3TelaSup(true);
            }
            else if(actual.get(i).getCodInterno() == 5)
            {
                this.flags.setF3TelaInf(true);
            }
            else if(actual.get(i).getCodInterno() == 6)
            {
                this.flags.setfManta(true);
            }
            else if(actual.get(i).getCodInterno() == 7)
            {
                this.flags.setfTransversal(true);
            }
            else if(actual.get(i).getCodInterno() == 8)
            {
                this.flags.setfExHumedo(true);
            }
            else if(actual.get(i).getCodInterno() == 9)
            {
                this.flags.setfExSeco(true);
            }
            else if(actual.get(i).getCodInterno() == 10)
            {
                this.flags.setfCintaEn(true);
            }
            else if(actual.get(i).getCodInterno() == 11)
            {
                this.flags.setfCHP1(true);
            }
            else if(actual.get(i).getCodInterno() == 12)
            {
                this.flags.setfCHP2(true);
            }
            else if(actual.get(i).getCodInterno() == 13)
            {
                this.flags.setfCHP3(true);
            }
            else if(actual.get(i).getCodInterno() == 14)
            {
                this.flags.setfCHS(true);
            }
            else if(actual.get(i).getCodInterno() == 15)
            {
                this.flags.setfCHT(true);
            }
        }
    }
    
    public void cargarHistorial() throws ParseException, IOException
    {
        this.datos.sethPickUp(this.seeder.cargarHojas(0));
        this.datos.setH2daPrensa(this.seeder.cargarHojas(1));
        this.datos.setH3raSuperior(this.seeder.cargarHojas(2));
        this.datos.setH3raInferior(this.seeder.cargarHojas(3));
        this.datos.setH3TelaSup(this.seeder.cargarHojas(4));
        this.datos.setH3TelaInf(this.seeder.cargarHojas(5));
        this.datos.sethManta(this.seeder.cargarHojas(6));
        this.datos.sethTransversal(this.seeder.cargarHojas(7));
        this.datos.sethExHumedo(this.seeder.cargarHojas(8));
        this.datos.sethExSeco(this.seeder.cargarHojas(9));
        this.datos.sethCintaEn(this.seeder.cargarHojas(10));
        this.datos.sethCHP1(this.seeder.cargarHojas(11));
        this.datos.sethCHP2(this.seeder.cargarHojas(12));
        this.datos.sethCHP3(this.seeder.cargarHojas(13));
        this.datos.sethCHS(this.seeder.cargarHojas(14));
        this.datos.sethCHT(this.seeder.cargarHojas(15));
    }
    
    public boolean newInicio() throws ParseException, IOException
    {
        this.menu.ppino();
        try
        {
        this.datos.setActual(this.seeder.cargarArrayActual());
        this.cargarHistorial();
        //this.datos.sethPickUp(this.seeder.cargarArrayPickUp());
        //this.datos.setH2daPrensa(this.seeder.cargar2daPrensa());
        
        }
        catch(FileNotFoundException e)
        {
            System.out.println("archivo no encontrado");
        }
        //this.datos.sethPickUp(this.seeder.cargarhPickUp);
        this.verificarExsistencia(this.datos.getActual());
        
        
        while (opcion != 0)
        {
            this.verificarExsistencia(this.datos.getActual());
            this.menu.menuPrincipal();

            this.opcion = this.lector.leerEntero();
            switch(opcion)
            {
                //Salir.
                case 0:
                    this.menu.printExit();
                    break;
                    
                //Registrar un equipo.
                case 1:
                    //lector.buffer();

                    //System.out.println("Elegir una opción: ");
                    int subOpcion = -1;
                    while(subOpcion != 0)
                    {
                        this.verificarExsistencia(this.datos.getActual());
                        this.menu.printTipoEquipos();
                        subOpcion = this.lector.leerEntero();
                        switch(subOpcion)
                        {
                            
                            // Volver al menu anterior
                            case 0:
                                System.out.println("Volviendo al menu principal");
                                break;
                             // PickUp       
                            case 1:
                                
                                //this.causaCambio(0);
                                /*
                                if(this.flags.isfPickUp())
                                {
                                    Equipo e = this.encuentraEquipo(0);
                                    e.setCausaCambio(this.causa());
                                }*/
                                this.revisarCausa(0);
                                //this.existeAntiguo(0);
                                Equipo pickUp = this.creador.crearPickUp();
                                pickUp = this.completarEquipo(pickUp);
                                
                                this.datos.getActual().add(pickUp);
                                break;
                                
                             // 2da Prensa  
                            case 2:
                                this.revisarCausa(1);
                                Equipo segPrensa = this.creador.crear2daPrensa();
                                segPrensa = this.completarEquipo(segPrensa);
                                
                                this.datos.getActual().add(segPrensa);
                                break;
                                
                            //3ra Superior
                            case 3:
                                
                                this.revisarCausa(2);
                                Equipo terSup = this.creador.crear3raSuperior();
                                terSup = this.completarEquipo(terSup);
                                
                                this.datos.getActual().add(terSup);
                                break;
                                
                                
                            //3ra Inferior
                            case 4:
                                
                                this.revisarCausa(3);
                                Equipo terInf = this.creador.crear3raInferior();
                                terInf = this.completarEquipo(terInf);
                                this.datos.getActual().add(terInf);
                                break;
                                
                            //Tela Superior
                            case 5:
                                
                                this.revisarCausa(4);
                                Equipo telaSup = this.creador.crearTelaSuperior();
                                telaSup = this.completarEquipo(telaSup);
                                this.datos.getActual().add(telaSup);
                                break;
                                
                            //Tela inferior
                            case 6:
                                
                                this.revisarCausa(5);
                                Equipo telaInf = this.creador.crearTelaInferior();
                                telaInf = this.completarEquipo(telaInf);
                                this.datos.getActual().add(telaInf);
                                break;
                                
                            //Manta
                            case 7:
                                
                                this.revisarCausa(6);      
                                Equipo manta = this.creador.crearManta();
                                manta = this.completarEquipo(manta);
                                this.datos.getActual().add(manta);
                                break;
                                
                            //C. Transversal
                            case 8:
                                
                                this.revisarCausa(7);
                                Equipo cTransversal = this.creador.crearCTrnasversal();
                                cTransversal = this.completarEquipo(cTransversal);
                                this.datos.getActual().add(cTransversal);
                                break;
                                
                            //Extremo Humedo
                            case 9:
                                
                                this.revisarCausa(8); 
                                Equipo exHumedo = this.creador.crearExHumedo();
                                exHumedo = this.completarEquipo(exHumedo);
                                this.datos.getActual().add(exHumedo);
                                break;
                                
                            //Extremo Seco
                            case 10:
                                
                                this.revisarCausa(9); 
                                Equipo exSeco = this.creador.crearExSeco();
                                exSeco = this.completarEquipo(exSeco);
                                this.datos.getActual().add(exSeco);
                                break;
                                
                            //Cinta Enhebrado    
                            case 11:
                                
                                this.revisarCausa(10); 
                                Equipo cintaEn = this.creador.crearCintaEn();
                                cintaEn = this.completarEquipo(cintaEn);
                                this.datos.getActual().add(cintaEn);
                                break;
                        }
                    }
                    break;
                
                // Equipos tipo harneros.
                case 2:
                    
                    int subOpcionM = -1;
                    while(subOpcionM != 0)
                    {
                        this.verificarExsistencia(this.datos.getActual());
                        this.menu.printTipoHarnero();
                        subOpcionM = this.lector.leerEntero();
                        switch(subOpcionM)
                        {
                            
                            // Volver al menu anterior.
                            case 0:
                                System.out.println("Volviendo al menu principal");
                                break;
                                
                             // Canastillo harnero Primario 1.
                            case 1:
                                
                                this.revisarCausa(11);
                                Equipo CHP1 = this.creador.crearCHP1();
                                CHP1 = this.completarEquipo(CHP1);
                                this.datos.getActual().add(CHP1);
                                break;
                                
                            // Canastillo harnero Primario 2.
                            case 2:
                                
                                this.revisarCausa(12);
                                Equipo CHP2 = this.creador.crearCHP2();
                                CHP2 = this.completarEquipo(CHP2);
                                this.datos.getActual().add(CHP2);
                                break;
                                
                            // Canastillo harnero Primario 3.
                            case 3:
                                
                                this.revisarCausa(13);
                                Equipo CHP3 = this.creador.crearCHP3();
                                CHP3 = this.completarEquipo(CHP3);
                                this.datos.getActual().add(CHP3);
                                break;
                                
                            // Canastillo harnero Secundario.
                            case 4:
                                
                                this.revisarCausa(14);
                                Equipo CHS = this.creador.crearCHS();
                                CHS = this.completarEquipo(CHS);
                                this.datos.getActual().add(CHS);
                                break;
                                
                            // Canastillo harnero Terciario.
                            case 5:
                                
                                this.revisarCausa(15);
                                Equipo CHT = this.creador.crearCHT();
                                CHT = this.completarEquipo(CHT);
                                this.datos.getActual().add(CHT);
                                break;
                        }
                    }
                    break;
                    
                //Listar equipos
                case 3:
                    System.out.println("tamaño del actual: "+this.datos.getActual().size());
                    this.listarEquipos();
                    break;
                    
                //Exportar datos a excel
                case 4:
                    this.volcarDatos_A_Spreadsheet();
                    try 
                    {
                        this.libro.generaDocumento();
                        this.menu.printExito();

                    } 
                    catch (IOException e)
                    {
                        this.menu.printError();
                    }
                    break;
                    
                case 5:
                    try 
                    {
                        this.libro.setLibro(this.seeder.cargarBD());
                        this.menu.printExito();

                    } 
                    catch (IOException e)
                    {
                        this.menu.printError();
                    }
                    break;
            }
        }
        return true;
    }
    
    private Equipo encuentraEquipo(int codigo)
    {
        for (int i = 0; i < this.datos.getActual().size(); i++)
        {
            if (this.datos.getActual().get(i).getCodInterno() == codigo)
            {
                Equipo e = this.datos.getActual().get(i);
                //e.setCausaCambio(this.causa());
                return e;
            }
        }
        return null;
    }
    
    private void revisarCausa(int cod)
    {
        
        if (cod == 0)
        {
            if(this.flags.isfPickUp())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.gethPickUp().add(e);
                /*System.out.println("******************************************");
                System.out.println("agregado el pickup this.datos.getActual().");
                System.out.println("Eliminando el equipo: "+e.getNombre());
                //System.out.println(this.borrarEquipo(cod));
                System.out.println("******************************************");*/
            }
        }
        else if (cod == 1)
        {
            if(this.flags.isF2daPrensa())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.getH2daPrensa().add(e);
            }
        }
        else if (cod == 2)
        {
            if(this.flags.isF3raSuperior())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.getH3raSuperior().add(e);
            }
        }
        else if (cod == 3)
        {
            if(this.flags.isF3raInferior())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.getH3raInferior().add(e);
            }           
        }
        else if (cod == 4)
        {
            if(this.flags.isF3TelaSup())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.getH3TelaSup().add(e);
            }     
        }
        else if (cod == 5)
        {
             if(this.flags.isF3TelaInf())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.getH3TelaInf().add(e);
            }                
        }
        else if (cod == 6)
        {
            if(this.flags.isfManta())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.gethManta().add(e);
            }                 
        }
        else if (cod == 7)
        {
            if(this.flags.isfTransversal())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.gethTransversal().add(e);
            }                 
        }
        else if (cod == 8)
        {
            if(this.flags.isfExHumedo())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.gethExHumedo().add(e);
            }                 
        }
        else if (cod == 9)
        {
            if(this.flags.isfExSeco())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.gethExSeco().add(e);
            }                 
        }
        else if (cod == 10)
        {
            if(this.flags.isfCintaEn())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.gethCintaEn().add(e);
            }                 
        }
        else if (cod == 11)
        {
            if(this.flags.isfCHP1())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.gethCHP1().add(e);
            }                 
        }
        else if (cod == 12)
        {
            if(this.flags.isfCHP2())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.gethCHP2().add(e);
            }                 
        }
        else if (cod == 13)
        {
            if(this.flags.isfCHP3())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.gethCHP3().add(e);
            }                 
        }
        else if (cod == 14)
        {
            if(this.flags.isfCHS())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.gethCHS().add(e);
            }                 
        }
        else if (cod == 15)
        {
            if(this.flags.isfCHT())
            {
                Equipo e = this.encuentraEquipo(cod);
                this.datos.getActual().remove(e);
                e.setCausaCambio(this.causa());
                this.datos.gethCHT().add(e);
            }                 
        }
    }
    
    private String causa()
    {
        String causa = "Sin causa";
        this.menu.printCausaCambio();
        int o = this.lector.leerEntero();

        switch (o) {
            case 1:
                causa = "Plan Operativo.";
                //this.encuentraEquipo(i);
                return causa;
            case 2:
                causa = "Oportunidad Operativa";
                return causa;
            case 3:
                causa = "Daño en el Equipo";
                return causa;
            case 4:
                causa = "Otro";
                return causa;
            default:
                break;
        }
        return causa;
    }
    
    private Equipo completarEquipo(Equipo equipo)
    {
        
        System.out.print("Proveedor: ");
        String pro = this.lector.ingresarTexto();
        System.out.println("Fecha de ingreso: ");
        System.out.println("En formato dd-mm-aaaa, ejemplo: 11-02-2019. ");
        String fechaI = this.lector.ingresarTexto();
        System.out.print("ID Caja Paño: ");
        String idcp = this.lector.ingresarTexto();
        System.out.print("Plan Operativo en dias: ");
        int pop = this.lector.leerEntero();

        
        equipo.setProveedor(pro);
        equipo.setIdCajaPaño(idcp);
        try
        {
            Date dateI = this.sdf.parse(fechaI);
            Calendar calendarI = Calendar.getInstance();
            calendarI.setTime(dateI);
            equipo.setFechaIngreso(calendarI);
            
            Calendar calendarS = Calendar.getInstance();
            calendarS.setTime(dateI);
            calendarS.add(Calendar.DATE, pop);
            System.out.print("Fecha de Salida agregada automaticamente: ");
            System.out.println(calendarS.getTime());
            equipo.setFechaSalida(calendarS);
            
        }
        catch(ParseException e)
        {
            this.menu.printErrorFecha();
            equipo.setFechaIngreso(null);
            equipo.setFechaSalida(null);
        }

        equipo.setPlanOperativo(pop);
        return equipo;
    }
    
    private void volcarDatos_A_Spreadsheet()
    {
        this.libro.setEquipos(this.datos.getActual());
        this.libro.setArrayPickUp(this.datos.gethPickUp());
        this.libro.setArray2daPrensa(this.datos.getH2daPrensa());
        this.libro.setArray3raSuperior(this.datos.getH3raSuperior());
        this.libro.setArray3raInferior(this.datos.getH3raInferior());
        this.libro.setArray3TelaSup(this.datos.getH3TelaSup());
        this.libro.setArray3TelaInf(this.datos.getH3TelaInf());
        this.libro.setArrayManta(this.datos.gethManta());
        this.libro.setArrayTransversal(this.datos.gethTransversal());
        this.libro.setArrayExHumedo(this.datos.gethExHumedo());
        this.libro.setArrayExSeco(this.datos.gethExSeco());
        this.libro.setArrayCintaEn(this.datos.gethCintaEn());
        this.libro.setArrayCHP1(this.datos.gethCHP1());
        this.libro.setArrayCHP2(this.datos.gethCHP2());
        this.libro.setArrayCHP3(this.datos.gethCHP3());
        this.libro.setArrayCHS(this.datos.gethCHS());
        this.libro.setArrayCHT(this.datos.gethCHT());
    }
    
}