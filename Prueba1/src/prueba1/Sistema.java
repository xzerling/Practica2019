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
                Equipo equipo = (Equipo) this.datos.getActual().get(i);
                if (equipo.getCodigoSap() == cod)
                {
                    this.datos.getActual().remove(equipo);
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
        }
    }

    
    public boolean newInicio() throws ParseException, IOException
    {
        this.menu.ppino();
        try
        {
        this.datos.setActual(this.seeder.cargarArrayActual());
        this.datos.sethPickUp(this.seeder.cargarArrayPickUp());
        this.datos.setH2daPrensa(this.seeder.cargar2daPrensa());
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
                                //lector.buffer();
                                
                                //this.causaCambio(0);
                                this.existeAntiguo(0);
                                Equipo pickUp = this.creador.crearPickUp();
                                pickUp = this.completarEquipo(pickUp);
                                
                                this.datos.getActual().add(pickUp);
                                break;
                                
                             // 2da Prensa  
                            case 2:
                                System.out.println("opcion 2 seleccionada");
                                //lector.buffer();
                                //this.causaCambio(1);
                                System.out.println("pas+o causa cambio");
                                Equipo segPrensa = this.creador.crear2daPrensa();
                                segPrensa = this.completarEquipo(segPrensa);
                                this.existeAntiguo(1);
                                this.datos.getActual().add(segPrensa);
                                break;
                                
                            //3ra Superior
                            case 3:
                                
                                //lector.buffer();
                                
                                //this.causaCambio(2);
                                Equipo terSup = this.creador.crear3raSuperior();
                                terSup = this.completarEquipo(terSup);
                                this.existeAntiguo(2);
                                this.datos.getActual().add(terSup);
                                break;
                                
                                
                            //3ra Inferior
                            case 4:
                                
                                //lector.buffer();
                                
                                this.causaCambio(3);
                                Equipo terInf = this.creador.crear3raInferior();
                                terInf = this.completarEquipo(terInf);
                                this.existeAntiguo(3);
                                this.datos.getActual().add(terInf);
                                break;
                                
                            //Tela Superior
                            case 5:
                                
                                //lector.buffer();
                                
                                this.causaCambio(4);
                                Equipo telaSup = this.creador.crearTelaSuperior();
                                telaSup = this.completarEquipo(telaSup);
                                this.existeAntiguo(4);
                                this.datos.getActual().add(telaSup);
                                break;
                                
                            //Tela inferior
                            case 6:
                                                                                                
                                //lector.buffer();
                                
                                Equipo telaInf = this.creador.crearTelaInferior();
                                telaInf = this.completarEquipo(telaInf);
                                this.existeAntiguo(5);
                                this.datos.getActual().add(telaInf);
                                break;
                                
                            //Manta
                            case 7:
                                                                                                
                                //lector.buffer();
                                
                                Equipo manta = this.creador.crearManta();
                                manta = this.completarEquipo(manta);
                                this.existeAntiguo(6);
                                this.datos.getActual().add(manta);
                                break;
                                
                            //C. Transversal
                            case 8:
                                
                                //lector.buffer();
                                
                                Equipo cTransversal = this.creador.crearCTrnasversal();
                                cTransversal = this.completarEquipo(cTransversal);
                                this.existeAntiguo(7);
                                this.datos.getActual().add(cTransversal);
                                break;
                                
                            //Extremo Humedo
                            case 9:
                                                                                                
                                //lector.buffer();
                                
                                Equipo exHumedo = this.creador.crearExHumedo();
                                exHumedo = this.completarEquipo(exHumedo);
                                this.existeAntiguo(8);
                                this.datos.getActual().add(exHumedo);
                                break;
                                
                            //Extremo Seco
                            case 10:
                                                                                                
                                //lector.buffer();
                                
                                Equipo exSeco = this.creador.crearExSeco();
                                exSeco = this.completarEquipo(exSeco);
                                this.existeAntiguo(9);
                                this.datos.getActual().add(exSeco);
                                break;
                                
                            //Cinta Enhebrado    
                            case 11:
                                //lector.buffer();
                                
                                Equipo cintaEn = this.creador.crearCintaEn();
                                cintaEn = this.completarEquipo(cintaEn);
                                this.existeAntiguo(10);
                                this.datos.getActual().add(cintaEn);
                                break;
                        }
                    }
                    break;
                
                // Modificar atributos
                case 2:
                    /*
                    if (this.hayEquipos() == false)
                    {
                        System.out.println("No existen maquinas en el registro.");
                        System.out.println("");
                        break;
                    }*/
                    //lector.buffer();

                    //this.menu.printModificarEquipo();
                    //this.menu.printTipoHarnero();
                    //System.out.print("Elegir una opción: ");
                    int subOpcionM = -1;
                    while(subOpcionM != 0)
                    {
                        //this.menu.printModificarEquipo();
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
                                //lector.buffer();
                                
                                Equipo CHP1 = this.creador.crearCHP1();
                                CHP1 = this.completarEquipo(CHP1);
                                this.existeAntiguo(11);
                                this.datos.getActual().add(CHP1);
                                break;
                                
                            // Canastillo harnero Primario 2.
                            case 2:
                                
                                //lector.buffer();
                                
                                Equipo CHP2 = this.creador.crearCHP2();
                                CHP2 = this.completarEquipo(CHP2);
                                this.existeAntiguo(12);
                                this.datos.getActual().add(CHP2);
                                break;
                                
                            // Canastillo harnero Primario 3.
                            case 3:
                                
                                //lector.buffer();
                                
                                Equipo CHP3 = this.creador.crearCHP3();
                                CHP3 = this.completarEquipo(CHP3);
                                this.existeAntiguo(13);
                                this.datos.getActual().add(CHP3);
                                break;
                                
                            // Canastillo harnero Secundario.
                            case 4:
                                //lector.buffer();
                                
                                Equipo CHS = this.creador.crearCHS();
                                CHS = this.completarEquipo(CHS);
                                this.existeAntiguo(14);
                                this.datos.getActual().add(CHS);
                                break;
                                
                            // Canastillo harnero Terciario.
                            case 5:
                                //lector.buffer();
                                
                                Equipo CHT = this.creador.crearCHT();
                                CHT = this.completarEquipo(CHT);
                                this.existeAntiguo(15);
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
    
    private String causaCambio(int i)
    {
        //lector.buffer();
        String causa = "Sin causa";
        for (int j = 0; j < this.datos.getActual().size(); j++)
        {
            if(this.datos.getActual().get(j).getCodInterno() == i)
            {
                this.menu.printCausaCambio();
                int o = this.lector.leerEntero();

                switch (o) {
                    case 1:
                        causa = "Plan Operativo.";
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
            }
        }

        return causa;
    }
    
    
    private Equipo completarEquipo(Equipo equipo)
    {
        
        System.out.print("Proveedor: ");
        String pro = this.lector.ingresarTexto();
        System.out.println("paso el proveedor");
        //System.out.println("Posi: ");
        //String pos = this.lector.ingresarTexto();
        System.out.println("Fecha de ingreso: ");
        System.out.println("En formato dd-mm-aaaa, ejemplo: 11-02-2019. ");
        String fechaI = this.lector.ingresarTexto();
        System.out.print("ID Caja Paño: ");
        String idcp = this.lector.ingresarTexto();
        System.out.print("Plan Operativo en dias: ");
        int pop = this.lector.leerEntero();
        System.out.print("Fecha de Salida agregada automaticamente: ");
        //System.out.println("En formato dd-mm-aaaa, ejemplo: 11-02-2019. ");
        //String fechaS = this.lector.ingresarTexto();

        
        
        equipo.setProveedor(pro);
        //equipo.setPosi(pos);
        //equipo.setFechaIngreso(Calendar.getInstance());
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
        /*
        try
        {
            Date dateS = this.sdf.parse(fechaS);
            Calendar calendarS = Calendar.getInstance();
            calendarS.setTime(dateS);
            equipo.setFechaSalida(calendarS);
        }
        catch(ParseException e)
        {
            this.menu.printErrorFecha();
            equipo.setFechaSalida(null);
        }*/
        

        return equipo;
    }
    
    private void volcarDatos_A_Spreadsheet()
    {
        this.libro.setEquipos(this.datos.getActual());
        this.libro.setArrayPickUp(this.datos.gethPickUp());
        //System.out.println("tamaño del pickup historico: "+datos.gethPickUp().size());
        this.libro.setArray2daPrensa(this.datos.getH2daPrensa());
        this.libro.setArray3raSuperior(this.datos.getH3raSuperior());
        this.libro.setArray3raInferior(this.datos.getH3raInferior());
        this.libro.setArray3TelaSup(this.datos.getH3TelaSup());
        this.libro.setArray3TelaInf(this.datos.getH3TelaInf());
        this.libro.setArrayManta(this.datos.gethManta());
        this.libro.setArrayTransversal(this.datos.gethTransversal());
        this.libro.setArrayExHumedo(this.datos.gethExHumedo());
        this.libro.setArrayExSeco(this.datos.gethExSeco());
    }
    
    private void existeAntiguo(int codigo)
    {
        //ArrayList<Equipo> actual = this.datos.getActual();
        System.out.println("tamaño this.datos.getActual(): "+this.datos.getActual().size());
        for (int i = 0; i < this.datos.getActual().size(); i++) 
        {
            //System.out.println("aaa");
            if(this.datos.getActual().get(i).getCodInterno() == codigo && flags.isfPickUp() == true)
            {
                this.datos.getActual().get(i).setCausaCambio(this.causaCambio(i));
                this.datos.gethPickUp().add(this.datos.getActual().get(i));
                System.out.println("agregado el pickup this.datos.getActual().");
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                this.datos.getActual().remove(i);
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && flags.isF2daPrensa()== true)
            {
                this.datos.getH2daPrensa().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                this.datos.getActual().remove(i);               
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isF3raSuperior()== true)
            {
                this.datos.getH3raSuperior().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                this.datos.getActual().remove(i);
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isF3raInferior()== true)
            {
                this.datos.getH3raInferior().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                this.datos.getActual().remove(i);
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isF3TelaSup()== true)
            {
                this.datos.getH3TelaSup().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                this.datos.getActual().remove(i);
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isF3TelaInf()== true)
            {
                this.datos.getH3TelaInf().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                this.datos.getActual().remove(i);
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isfManta()== true)
            {
                this.datos.gethManta().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                this.datos.getActual().remove(i);
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isfTransversal()== true)
            {
                this.datos.gethTransversal().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                this.datos.getActual().remove(i);
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isfExHumedo()== true)
            {
                this.datos.gethExHumedo().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                this.datos.getActual().remove(i);
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isfExSeco()== true)
            {
                this.datos.gethExSeco().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                this.datos.getActual().remove(i);
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isfCintaEn() == true)
            {
                this.datos.gethCintaEn().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isfCHP1()== true)
            {
                this.datos.gethCHP1().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isfCHP2()== true)
            {
                this.datos.gethCHP2().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isfCHP3()== true)
            {
                this.datos.gethCHP3().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isfCHS()== true)
            {
                this.datos.gethCHS().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
            }
            else if(this.datos.getActual().get(i).getCodInterno() == codigo && this.flags.isfCHT()== true)
            {
                this.datos.gethCHT().add(this.datos.getActual().get(i));
                System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
            }   
            /*
            switch (actual.get(i).getCodInterno()) {
                case 0:
                    if(this.flags.isfPickUp() == true)
                    {
                        this.datos.gethPickUp().add(this.datos.getActual().get(i));
                        System.out.println("agregado el pickup actual.");
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                        this.datos.getActual().remove(i);
                        
                    }   break;
                case 1:
                    if(this.flags.isF2daPrensa()== true)
                    {
                        this.datos.getH2daPrensa().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                        this.datos.getActual().remove(i);
                    }   break;
                case 2:
                    if(this.flags.isF3raSuperior()== true)
                    {
                        this.datos.getH3raSuperior().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                        this.datos.getActual().remove(i);
                    }   break;
                case 3:
                    if(this.flags.isF3raInferior()== true)
                    {
                        this.datos.getH3raInferior().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                        this.datos.getActual().remove(i);
                    }   break;
                case 4:
                    if(this.flags.isF3TelaSup()== true)
                    {
                        this.datos.getH3TelaSup().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                        this.datos.getActual().remove(i);
                    }   break;
                case 5:
                    if(this.flags.isF3TelaInf()== true)
                    {
                        this.datos.getH3TelaInf().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                        this.datos.getActual().remove(i);
                    }   break;
                case 6:
                    if(this.flags.isfManta()== true)
                    {
                        this.datos.gethManta().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                        this.datos.getActual().remove(i);
                    }   break;
                case 7:
                    if(this.flags.isfTransversal()== true)
                    {
                        this.datos.gethTransversal().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                        this.datos.getActual().remove(i);
                    }   break;
                case 8:
                    if(this.flags.isfExHumedo()== true)
                    {
                        this.datos.gethExHumedo().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                        this.datos.getActual().remove(i);
                    }   break;
                case 9:
                    if(this.flags.isfExSeco()== true)
                    {
                        this.datos.gethExSeco().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                        this.datos.getActual().remove(i);
                    }   break;
                case 10:
                    if(this.flags.isfCintaEn() == true)
                    {
                        this.datos.gethCintaEn().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                    }   break;
                case 11:
                    if(this.flags.isfCHP1()== true)
                    {
                        this.datos.gethCHP1().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                    }   break;
                case 12:
                    if(this.flags.isfCHP2()== true)
                    {
                        this.datos.gethCHP2().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                    }   break;
                case 13:
                    if(this.flags.isfCHP3()== true)
                    {
                        this.datos.gethCHP3().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                    }   break;
                case 14:
                    if(this.flags.isfCHS()== true)
                    {
                        this.datos.gethCHS().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                    }   break;
                case 15:
                    if(this.flags.isfCHT()== true)
                    {
                        this.datos.gethCHT().add(this.datos.getActual().get(i));
                        System.out.println("Eliminando el equipo: "+this.datos.getActual().get(i).getNombre());
                    }   break;
                default:
                    break;
            }*/
        }
    }

}
          