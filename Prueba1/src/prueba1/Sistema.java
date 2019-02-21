/*
 * Systema de administracion de telas y paños.
 * Superintendencia de Maquinas, Planta Nueva Aldea.
 * Arauco 2019 - Practica Profesional.
 */


package prueba1;

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
            if(actual.get(i).getCodInterno() == 1)
            {
                this.flags.setF2daPrensa(true);
            }
            if(actual.get(i).getCodInterno() == 2)
            {
                this.flags.setF3raSuperior(true);
            }
            if(actual.get(i).getCodInterno() == 3)
            {
                this.flags.setF3raInferior(true);
            }
            if(actual.get(i).getCodInterno() == 4)
            {
                this.flags.setF3TelaSup(true);
            }
            if(actual.get(i).getCodInterno() == 5)
            {
                this.flags.setF3TelaInf(true);
            }
            if(actual.get(i).getCodInterno() == 6)
            {
                this.flags.setfManta(true);
            }
            if(actual.get(i).getCodInterno() == 7)
            {
                this.flags.setfTransversal(true);
            }
            if(actual.get(i).getCodInterno() == 8)
            {
                this.flags.setfExHumedo(true);
            }
            if(actual.get(i).getCodInterno() == 9)
            {
                this.flags.setfExSeco(true);
            }
        }
    }

    
    public boolean newInicio() throws ParseException, IOException
    {
        this.menu.ppino();
        this.datos.setActual(this.seeder.cargarArray());
        //this.datos.sethPickUp(this.seeder.cargarhPickUp);
        this.verificarExsistencia(this.datos.getActual());
        
        
        while (opcion != 0)
        {
            this.menu.menuPrincipal();
            System.out.println("");
            System.out.print("Elegir una opción: ");
            System.out.println("");
            this.opcion = this.lector.leerEntero();
            switch(opcion)
            {
                //Salir.
                case 0:
                    this.menu.printExit();
                    break;
                    
                //Registrar un equipo.
                case 1:
                    lector.buffer();

                    System.out.println("Elegir una opción: ");
                    int subOpcion = -1;
                    while(subOpcion != 0)
                    {
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
                                lector.buffer();
                                
                                Equipo pickUp = this.creador.crearPickUp();
                                pickUp = this.completarEquipo(pickUp);
                                this.existeAntiguo(this.datos.getActual());
                                this.datos.getActual().add(pickUp);
                                break;
                                
                             // 2da Prensa  
                            case 2:

                                lector.buffer();
                                
                                Equipo segPrensa = this.creador.crear2daPrensa();
                                segPrensa = this.completarEquipo(segPrensa);
                                this.datos.getActual().add(segPrensa);
                                break;
                                
                            //3ra Superior
                            case 3:
                                
                                lector.buffer();
                                
                                Equipo terSup = this.creador.crear3raSuperior();
                                terSup = this.completarEquipo(terSup);
                                this.datos.getActual().add(terSup);
                                break;
                                
                                
                            //3ra Inferior
                            case 4:
                                
                                lector.buffer();
                                
                                Equipo terInf = this.creador.crear3raInferior();
                                terInf = this.completarEquipo(terInf);
                                this.datos.getActual().add(terInf);
                                break;
                                
                            //Tela Superior
                            case 5:
                                
                                lector.buffer();
                                
                                Equipo telaSup = this.creador.crearTelaSuperior();
                                telaSup = this.completarEquipo(telaSup);
                                this.datos.getActual().add(telaSup);
                                break;
                                
                            //Tela inferior
                            case 6:
                                                                                                
                                lector.buffer();
                                
                                Equipo telaInf = this.creador.crearTelaInferior();
                                telaInf = this.completarEquipo(telaInf);
                                this.datos.getActual().add(telaInf);
                                break;
                                
                            //Manta
                            case 7:
                                                                                                
                                lector.buffer();
                                
                                Equipo manta = this.creador.crearManta();
                                manta = this.completarEquipo(manta);
                                this.datos.getActual().add(manta);
                                break;
                                
                            //C. Transversal
                            case 8:
                                
                                lector.buffer();
                                
                                Equipo cTransversal = this.creador.crearCTrnasversal();
                                cTransversal = this.completarEquipo(cTransversal);
                                this.datos.getActual().add(cTransversal);
                                break;
                                
                            //Extremo Humedo
                            case 9:
                                                                                                
                                lector.buffer();
                                
                                Equipo exHumedo = this.creador.crearExHumedo();
                                exHumedo = this.completarEquipo(exHumedo);
                                this.datos.getActual().add(exHumedo);
                                break;
                                
                            //Extremo Seco
                            case 10:
                                                                                                
                                lector.buffer();
                                
                                Equipo exSeco = this.creador.crearExSeco();
                                exSeco = this.completarEquipo(exSeco);
                                this.datos.getActual().add(exSeco);
                                break;
                        }
                    }
                    break;
                
                // Modificar atributos
                case 2:

                    if (this.hayEquipos() == false)
                    {
                        System.out.println("No existen maquinas en el registro.");
                        System.out.println("");
                        break;
                    }
                    lector.buffer();

                    //this.menu.printModificarEquipo();
                    System.out.print("Elegir una opción: ");
                    int subOpcionM = -1;
                    while(subOpcionM != 0)
                    {
                        this.menu.printModificarEquipo();
                        subOpcion = this.lector.leerEntero();
                        switch(subOpcion)
                        {
                            
                            // Volver al menu anterior
                            case 0:
                                System.out.println("Volviendo al menu principal");
                                break;
                             // PickUp       
                            case 1:

                                lector.buffer();
                             // 2da Prensa  
                            case 2:

                                lector.buffer();
                            //3ra Superior
                            case 3:
                            //3ra Inferior
                            case 4:
                            //Tela Superior
                            case 5:
                            //Tela inferior
                            case 6:
                            //Manta
                            case 7:
                            //C. Transversal
                            case 8:
                            //Nivel TADB2
                            case 9:
                            //Nivel TADB3
                            case 10:


                        }
                    }

                    break;
                    
                //Listar equipos
                case 3:
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
    
    
    private Equipo completarEquipo(Equipo equipo)
    {
        System.out.println("Proveedor: ");
        String pro = this.lector.ingresarTexto();
        //System.out.println("Posi: ");
        //String pos = this.lector.ingresarTexto();
        System.out.println("Fecha de ingreso: ");
        System.out.println("En formato dd-mm-aaaa, ejemplo: 11-02-2019. ");
        String fechaI = this.lector.ingresarTexto();
        System.out.println("Estado: ");
        String est = this.lector.ingresarTexto();
        System.out.println("Proximo Cambio: ");
        System.out.println("En formato dd-mm-aaaa, ejemplo: 11-02-2019. ");
        String fechaS = this.lector.ingresarTexto();
        System.out.println("Plan Operativo (dias): ");
        int pop = this.lector.leerEntero();
        
        
        equipo.setProveedor(pro);
        //equipo.setPosi(pos);
        //equipo.setFechaIngreso(Calendar.getInstance());
        equipo.setEstado(est);
        try
        {
            Date dateI = this.sdf.parse(fechaI);
            Calendar calendarI = Calendar.getInstance();
            calendarI.setTime(dateI);
            equipo.setFechaIngreso(calendarI);
        }
        catch(ParseException e)
        {
            this.menu.printErrorFecha();
            equipo.setFechaSalida(null);
        }
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
        }
        equipo.setPlanOperativo(pop);

        return equipo;
    }
    
    private void volcarDatos_A_Spreadsheet()
    {
        this.libro.setEquipos(this.datos.getActual());
        this.libro.setArrayPickUp(this.datos.gethPickUp());
        System.out.println("tamaño: "+datos.gethPickUp().size());
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
    
    private void existeAntiguo(ArrayList<Equipo> actual)
    {
        for (int i = 0; i < actual.size(); i++) 
        {
            System.out.println("aaa");
            if(actual.get(i).getCodInterno() == 0)
            {
                if(this.flags.isfPickUpTrue() == true)
                {
                    this.datos.gethPickUp().add(this.datos.getActual().get(i));
                    System.out.println("agregado el pickup actual.");
                    this.datos.getActual().remove(i);
                }
            }
            else if(actual.get(i).getCodInterno() == 1)
            {
                if(this.flags.isF2daPrensaTrue()== true)
                {
                    this.datos.getH2daPrensa().add(this.datos.getActual().get(i));
                    this.datos.getActual().remove(i);
                }
            }
            else if(actual.get(i).getCodInterno() == 2)
            {
                if(this.flags.isF3raSuperiorTrue()== true)
                {
                    this.datos.getH3raSuperior().add(this.datos.getActual().get(i));
                    this.datos.getActual().remove(i);
                }
            }
            else if(actual.get(i).getCodInterno() == 3)
            {
                if(this.flags.isF3raInferiorTrue()== true)
                {
                    this.datos.getH3raInferior().add(this.datos.getActual().get(i));
                    this.datos.getActual().remove(i);
                }
            }
            else if(actual.get(i).getCodInterno() == 4)
            {
                if(this.flags.isF3TelaSupTrue()== true)
                {
                    this.datos.getH3TelaSup().add(this.datos.getActual().get(i));
                    this.datos.getActual().remove(i);
                }
            }
            else if(actual.get(i).getCodInterno() == 5)
            {
                if(this.flags.isF3TelaInfTrue()== true)
                {
                    this.datos.getH3TelaInf().add(this.datos.getActual().get(i));
                    this.datos.getActual().remove(i);
                }
            }
            else if(actual.get(i).getCodInterno() == 6)
            {
                if(this.flags.isfMantaTrue()== true)
                {
                    this.datos.gethManta().add(this.datos.getActual().get(i));
                    this.datos.getActual().remove(i);
                }
            }
            else if(actual.get(i).getCodInterno() == 7)
            {
                if(this.flags.isfTransversalTrue()== true)
                {
                    this.datos.gethTransversal().add(this.datos.getActual().get(i));
                    this.datos.getActual().remove(i);
                }
            }
            else if(actual.get(i).getCodInterno() == 8)
            {
                if(this.flags.isfExHumedoTrue()== true)
                {
                    this.datos.gethExHumedo().add(this.datos.getActual().get(i));
                    this.datos.getActual().remove(i);
                }
            }
            else if(actual.get(i).getCodInterno() == 9)
            {
                if(this.flags.isfExSeco()== true)
                {
                    this.datos.gethExSeco().add(this.datos.getActual().get(i));
                    this.datos.getActual().remove(i);
                }
            }
        }
    }
}
          