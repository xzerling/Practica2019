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

    
    public boolean newInicio() throws ParseException, IOException
    {
        this.menu.ppino();
        this.datos.setActual(this.seeder.cargarArray());
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
                    this.libro.setEquipos(this.datos.getActual());
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
        System.out.println("Fecha ingresada automaticamete al dia de hoy.");
        System.out.println("Estado: ");
        String est = this.lector.ingresarTexto();
        System.out.println("Proximo Cambio: ");
        System.out.println("En formato dd-mm-aaaa, ejemplo: 11-02-2019. ");
        String fecha = this.lector.ingresarTexto();
        System.out.println("Plan Operativo (dias): ");
        int pop = this.lector.leerEntero();
        
        
        equipo.setProveedor(pro);
        //equipo.setPosi(pos);
        equipo.setFechaIngreso(Calendar.getInstance());
        equipo.setEstado(est);
        try
        {
            Date date = this.sdf.parse(fecha);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            equipo.setFechaSalida(calendar);
        }
        catch(ParseException e)
        {
            this.menu.printErrorFecha();
            equipo.setFechaSalida(null);
        }
        equipo.setPlanOperativo(pop);

        return equipo;
    }
}
          