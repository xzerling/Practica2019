/*
 * Sistema de administracion de telas y paños.
 * Superintendencia de Maquinas, Planta Nueva Aldea.
 * Arauco 2019 - Practica Profesional.
 */


package prueba1;

import java.io.IOException;
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
    private ArrayList equipos;
    private int opcion;
    private SpreadSheet hoja;

    public Sistema()
    {
        this.lector = new Lector();
        this.menu = new Menu();
        this.equipos = new ArrayList();
        this.opcion = -1;
        this.hoja = new SpreadSheet();
    }
    
    public boolean inicio()
    {
        while (opcion != 0)
        {
            this.menu.mainMenu();
            System.out.println("");
            System.out.print("Elegir una opción: ");
            System.out.println("");
            this.opcion = this.lector.leerEntero();
            switch(opcion)
            {
                case 0:
                    this.menu.printExit();
                    break;
                case 1:
                    //this.menu.printIngresarEquipo();
                    lector.buffer();
                    
                    System.out.println("Nombre del equipo: ");
                    String nombre = this.lector.ingresarTexto();
                    System.out.println("codigo: ");
                    int codigo = this.lector.leerEntero();
                    System.out.println("Tipo: ");
                    String tipo = this.lector.ingresarTexto();
                    System.out.println("descripcion: ");
                    String descripcion = this.lector.ingresarTexto();
                    System.out.println("fecha de ingreso: ");
                    Calendar fechai = Calendar.getInstance();
                    System.out.println("fecha actual ingresada por defecto.");
                    
                    Equipo equipo = new Equipo(codigo, nombre, tipo, descripcion, fechai);
                    this.equipos.add(equipo);
                    break;
                    
                case 2:
                    
                    if (this.hayEquipos() == false)
                    {
                        System.out.println("No existen maquinas en el registro.");
                        System.out.println("");
                        break;
                    }
                    lector.buffer();
                    
                    //this.menu.printModificarEquipo();
                    int subOpcion = -1;
                    while(subOpcion != 0)
                    {
                        this.menu.printModificarEquipo();
                        subOpcion = this.lector.leerEntero();
                        switch(subOpcion)
                        {
                            case 0:
                                System.out.println("Volviendo al menu principal");
                                break;
                                
                            case 1:
                                
                                lector.buffer();
                                
                                System.out.println("Escriba el codigo del equipo a modificar.");
                                int tmpCodName = this.lector.leerEntero();
                                lector.buffer();
                                Equipo modEqpName = this.buscarEquipo(tmpCodName);
                                if (modEqpName != null)
                                    {
                                        System.out.println("Escriba el nuevo nombre a asignar.");
                                        String nvoNombre = this.lector.ingresarTexto();
                                        modEqpName.setNombre(nvoNombre);
                                        System.out.println("nombre Modificado");
                                        break;
                                    }
                                else
                                {
                                    System.out.println("Equipo no encontrado, revisar codigo");
                                    break;
                                }
                                
                            case 2:
                                
                                lector.buffer();
                                
                                System.out.println("Escriba el codigo del equipo a modificar.");
                                int tmpCodCod = this.lector.leerEntero();
                                lector.buffer();
                                Equipo modEqpCod = this.buscarEquipo(tmpCodCod);
                                if (modEqpCod != null)
                                    {
                                        System.out.println("Escriba el nuevo nombre a asignar.");
                                        int nvoCod = this.lector.leerEntero();
                                        modEqpCod.setCodigoZap(nvoCod);
                                        break;
                                    }
                                else
                                {
                                    System.out.println("Equipo no encontrado, revisar codigo");
                                    break;
                                }
                                
                            case 3:
                                
                                lector.buffer();
                                
                                System.out.println("Escriba el codigo del equipo a modificar.");
                                int tmpCodDes = this.lector.leerEntero();
                                lector.buffer();
                                Equipo modEqpDes = this.buscarEquipo(tmpCodDes);
                                if (modEqpDes != null)
                                    {
                                        System.out.println("Escriba la nueva descripcion a asignar.");
                                        String nvaDesc = this.lector.ingresarTexto();
                                        modEqpDes.setDescripcion(nvaDesc);
                                        break;
                                    }
                                else
                                {
                                    System.out.println("Equipo no encontrado, revisar codigo");
                                    break;
                                }
                        }
                    }
                    
                    break;
                    
                case 3:
                    lector.buffer();
                    System.out.println("Escriba el codigo del equipo a eliminar");
                    int codE = this.lector.leerEntero();
                    this.lector.buffer();
                    if (this.borrarEquipo(codE) == true)
                    {
                        System.out.println("Eliminado con exito.");
                    }
                    else
                    {
                        System.out.println("Error en eliminar el equipo.");
                    }
                    break;
                    
                case 4:
                    this.listarEquipos();
                    break;
                    
                case 6:
                    try 
                    {
                        this.hoja.generaDocumento();
                    } 
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
            }
        }
        return true;
    }
    
    private Equipo buscarEquipo(int cod)
    {
        if(this.equipos.size()>0)
        {
            for (int i = 0; i < this.equipos.size(); i++)
            {
                Equipo equipo = (Equipo) this.equipos.get(i);
                if (equipo.getCodigoZap() == cod)
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
            return this.equipos.size()>0;
    }

    private void listarEquipos()
    {
        if(this.equipos.size()>0)
        {
            for (int i = 0; i < this.equipos.size(); i++)
            {
                System.out.println("Maquina "+i+1+": ");
                Equipo equipo = (Equipo) this.equipos.get(i);
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
        if(this.equipos.size()>0)
        {
            for (int i = 0; i < this.equipos.size(); i++)
            {
                Equipo equipo = (Equipo) this.equipos.get(i);
                if (equipo.getCodigoZap() == cod)
                {
                    this.equipos.remove(equipo);
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
    
    public Equipo crearPickUp()
    {
        Equipo pickUp = new Equipo();
        pickUp.setCodigoZap(334560);
        pickUp.setNombre("Pick Up");
        pickUp.setDescripcion("Paño Pick up");
        pickUp.setTag("noTag");
        
        return pickUp;
    }
    
    public Equipo crear2daPrensa()
    {
        Equipo equipo = new Equipo();
        equipo.setCodigoZap(334561);
        equipo.setNombre("2da Prensa");
        equipo.setDescripcion("Paño segunda prensa");
        equipo.setTag("noTag");
        
        return equipo;
    }
    
    public Equipo crear2raSuperior()
    {
        Equipo equipo = new Equipo();
        equipo.setCodigoZap(334561);
        equipo.setNombre("2da Prensa");
        equipo.setDescripcion("Paño segunda prensa");
        equipo.setTag("noTag");
        
        return equipo;
    }
    
    public boolean newInicio()
    {
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
                    //this.menu.printIngresarEquipo();
                    lector.buffer();

                    //this.menu.printModificarEquipo();
                    System.out.print("Elegir una opción: ");
                    int subOpcion = -1;
                    while(subOpcion != 0)
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
                                break;
                        }
                    }
                        break;
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

                case 3:
                    lector.buffer();
                    System.out.println("Escriba el codigo del equipo a eliminar");
                    int codE = this.lector.leerEntero();
                    this.lector.buffer();
                    if (this.borrarEquipo(codE) == true)
                    {
                        System.out.println("Eliminado con exito.");
                    }
                    else
                    {
                        System.out.println("Error en eliminar el equipo.");
                    }
                    break;

                case 4:
                    this.listarEquipos();
                    break;

                case 6:
                    try 
                    {
                        this.hoja.generaDocumento();
                    } 
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
            }
        }
        return true;
    }
    
    
}
          