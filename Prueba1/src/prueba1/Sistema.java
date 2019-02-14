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
    private ArrayList equipos;
    private int opcion;
    private SpreadSheet hoja;
    private SimpleDateFormat sdf;

    public Sistema()
    {
        this.lector = new Lector();
        this.menu = new Menu();
        this.equipos = new ArrayList();
        this.creador = new CreaEquipo();
        this.opcion = -1;
        this.hoja = new SpreadSheet();
        this.sdf = new SimpleDateFormat("dd-MM-yyyy");
    }
    
    
    
    private Equipo buscarEquipo(int cod)
    {
        if(this.equipos.size()>0)
        {
            for (int i = 0; i < this.equipos.size(); i++)
            {
                Equipo equipo = (Equipo) this.equipos.get(i);
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
            return this.equipos.size()>0;
    }

    private void listarEquipos()
    {
        if(this.equipos.size()>0)
        {
            for (int i = 0; i < this.equipos.size(); i++)
            {
                int n = i+1;
                System.out.println("Maquina n°"+n+": ");
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
                if (equipo.getCodigoSap() == cod)
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

    
    public boolean newInicio() throws ParseException
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
                                this.equipos.add(pickUp);
                                break;
                                
                             // 2da Prensa  
                            case 2:

                                lector.buffer();
                                
                                Equipo segPrensa = this.creador.crear2daPrensa();
                                segPrensa = this.completarEquipo(segPrensa);
                                this.equipos.add(segPrensa);
                                break;
                                
                            //3ra Superior
                            case 3:
                                
                                lector.buffer();
                                
                                Equipo terSup = this.creador.crear3raSuperior();
                                terSup = this.completarEquipo(terSup);
                                this.equipos.add(terSup);
                                break;
                                
                                
                            //3ra Inferior
                            case 4:
                                
                                lector.buffer();
                                
                                Equipo terInf = this.creador.crear3raInferior();
                                terInf = this.completarEquipo(terInf);
                                this.equipos.add(terInf);
                                break;
                                
                            //Tela Superior
                            case 5:
                                
                                                                
                                lector.buffer();
                                
                                Equipo telaSup = this.creador.crearTelaSuperior();
                                telaSup = this.completarEquipo(telaSup);
                                this.equipos.add(telaSup);
                                break;
                                
                            //Tela inferior
                            case 6:
                                
                                                                                                
                                lector.buffer();
                                
                                Equipo telaInf = this.creador.crearTelaInferior();
                                telaInf = this.completarEquipo(telaInf);
                                this.equipos.add(telaInf);
                                break;
                                
                            //Manta
                            case 7:
                                
                                                                                                
                                lector.buffer();
                                
                                Equipo manta = this.creador.crearManta();
                                manta = this.completarEquipo(manta);
                                this.equipos.add(manta);
                                break;
                                
                            //C. Transversal
                            case 8:
                                
                                                                                                
                                lector.buffer();
                                
                                Equipo cTransversal = this.creador.crearCTrnasversal();
                                cTransversal = this.completarEquipo(cTransversal);
                                this.equipos.add(cTransversal);
                                break;
                                
                            //Nivel TADB2
                            case 9:
                                
                                                                                                
                                lector.buffer();
                                
                                Equipo nTADB2 = this.creador.crearNivelTADB2();
                                nTADB2 = this.completarEquipo(nTADB2);
                                this.equipos.add(nTADB2);
                                break;
                                
                            //Nivel TADB3
                            case 10:
                                
                                                                                                
                                lector.buffer();
                                
                                Equipo nTADB3 = this.creador.crearNivelTADB3();
                                nTADB3 = this.completarEquipo(nTADB3);
                                this.equipos.add(nTADB3);
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
                    this.hoja.setEquipos(this.equipos);
                    try 
                    {
                        this.hoja.generaDocumento();
                        this.menu.printExito();

                    } 
                    catch (IOException e)
                    {
                        this.menu.printError();
                    }
            }
        }
        return true;
    }
    
    
    private Equipo completarEquipo(Equipo equipo)
    {
        
        
        System.out.println("Proveedor: ");
        String pro = this.lector.ingresarTexto();
        System.out.println("Posi: ");
        String pos = this.lector.ingresarTexto();
        System.out.println("Fecha ingresada automaticamete al dia de hoy.");
        System.out.println("Estado: ");
        String est = this.lector.ingresarTexto();
        System.out.println("Proximo Cambio: ");
        System.out.println("En formato dd-mm-aaaa, ejemplo: 11-02-2019. ");
        String fecha = this.lector.ingresarTexto();
        
        
        equipo.setProveedor(pro);
        equipo.setPosi(pos);
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
        
        
        return equipo;
    }


    /************DEPRECADO********************/

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
                                        modEqpCod.setCodigoSap(nvoCod);
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
                        this.hoja.setEquipos(this.equipos);
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
          