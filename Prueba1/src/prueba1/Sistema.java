/*
 * Sistema de administracion de telas y paños.
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
        this.opcion = -1;
        this.hoja = new SpreadSheet();
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
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
    
    public Equipo crear3raSuperior()
    {
        Equipo equipo = new Equipo();
        equipo.setCodigoZap(0);
        equipo.setNombre("3ra Superior");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crear3raInferior()
    {
        Equipo equipo = new Equipo();
        equipo.setCodigoZap(0);
        equipo.setNombre("3ra Inferior");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crearTelaSuperior()
    {
        Equipo equipo = new Equipo();
        equipo.setCodigoZap(0);
        equipo.setNombre("Tela Superior");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crearTelaInferior()
    {
        Equipo equipo = new Equipo();
        equipo.setCodigoZap(0);
        equipo.setNombre("Tela Inferior");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crearManta()
    {
        Equipo equipo = new Equipo();
        equipo.setCodigoZap(0);
        equipo.setNombre("Manta");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crearCTrnasversal()
    {
        Equipo equipo = new Equipo();
        equipo.setCodigoZap(0);
        equipo.setNombre("C. Transversal");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crearNivelTADB2()
    {
        Equipo equipo = new Equipo();
        equipo.setCodigoZap(0);
        equipo.setNombre("Nivel TADB2");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crearNivelTADB()
    {
        Equipo equipo = new Equipo();
        equipo.setCodigoZap(0);
        equipo.setNombre("Nivel TADB3");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
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

                    System.out.print("Elegir una opción: ");
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
                                System.out.println("Proveedor: ");
                                String proveedor = this.lector.ingresarTexto();
                                pickUp.setProveedor(proveedor);
                                String posi = this.lector.ingresarTexto();
                                pickUp.setPosi(posi);
                                System.out.println("Fecha ingresada automaticamete al dia de hoy.");
                                pickUp.setFechaIngreso(Calendar.getInstance());
                                System.out.println("Estado: ");
                                String estado = this.lector.ingresarTexto();
                                pickUp.setEstado(estado);
                                
                                System.out.println("Proximo Cambio: ");
                                System.out.println("En formato dd/mm/aaaa. ");
                                String fecha = this.lector.ingresarTexto();
                                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                Date date = this.sdf.parse(fecha);
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(date);
                                pickUp.setFechaSalida(calendar);
                                break;
                                
                                
                                       
                                
                                
                                
                             // 2da Prensa  
                            case 2:

                                lector.buffer();
                                
                                Equipo segPrensa = this.creador.crear2daPrensa();
                                System.out.println("Proveedor: ");
                                String proveedor2 = this.lector.ingresarTexto();
                                segPrensa.setProveedor(proveedor2);
                                String posi2 = this.lector.ingresarTexto();
                                segPrensa.setPosi(posi2);
                                System.out.println("Fecha ingresada automaticamete al dia de hoy.");
                                segPrensa.setFechaIngreso(Calendar.getInstance());
                                System.out.println("Estado: ");
                                String estado2 = this.lector.ingresarTexto();
                                segPrensa.setEstado(estado2);
                                
                                System.out.println("Proximo Cambio: ");
                                System.out.println("En formato dd/mm/aaaa. ");
                                String fecha2 = this.lector.ingresarTexto();
                                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                Date date2 = this.sdf.parse(fecha2);
                                Calendar calendar2 = Calendar.getInstance();
                                calendar2.setTime(date2);
                                segPrensa.setFechaSalida(calendar2);
                                break;
                                
                            //3ra Superior
                            case 3:
                                
                                lector.buffer();
                                
                                Equipo terSup = this.creador.crear3raSuperior();
                                System.out.println("Proveedor: ");
                                String proveedor3 = this.lector.ingresarTexto();
                                terSup.setProveedor(proveedor3);
                                String posi3 = this.lector.ingresarTexto();
                                terSup.setPosi(posi3);
                                System.out.println("Fecha ingresada automaticamete al dia de hoy.");
                                terSup.setFechaIngreso(Calendar.getInstance());
                                System.out.println("Estado: ");
                                String estado3 = this.lector.ingresarTexto();
                                terSup.setEstado(estado3);
                                
                                System.out.println("Proximo Cambio: ");
                                System.out.println("En formato dd/mm/aaaa. ");
                                String fecha3 = this.lector.ingresarTexto();
                                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                Date date3 = this.sdf.parse(fecha3);
                                Calendar calendar3 = Calendar.getInstance();
                                calendar3.setTime(date3);
                                terSup.setFechaSalida(calendar3);
                                break;
                                
                                
                            //3ra Inferior
                            case 4:
                                
                                lector.buffer();
                                
                                Equipo terInf = this.creador.crear3raInferior();
                                System.out.println("Proveedor: ");
                                String proveedor4 = this.lector.ingresarTexto();
                                terInf.setProveedor(proveedor4);
                                String posi4 = this.lector.ingresarTexto();
                                terInf.setPosi(posi4);
                                System.out.println("Fecha ingresada automaticamete al dia de hoy.");
                                terInf.setFechaIngreso(Calendar.getInstance());
                                System.out.println("Estado: ");
                                String estado4 = this.lector.ingresarTexto();
                                terInf.setEstado(estado4);
                                
                                System.out.println("Proximo Cambio: ");
                                System.out.println("En formato dd/mm/aaaa. ");
                                String fecha4 = this.lector.ingresarTexto();
                                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                Date date4 = this.sdf.parse(fecha4);
                                Calendar calendar4 = Calendar.getInstance();
                                calendar4.setTime(date4);
                                terInf.setFechaSalida(calendar4);
                                break;
                                
                            //Tela Superior
                            case 5:
                                
                                                                
                                lector.buffer();
                                
                                Equipo telaSup = this.creador.crearTelaSuperior();
                                System.out.println("Proveedor: ");
                                String proveedor5 = this.lector.ingresarTexto();
                                telaSup.setProveedor(proveedor5);
                                String posi5 = this.lector.ingresarTexto();
                                telaSup.setPosi(posi5);
                                System.out.println("Fecha ingresada automaticamete al dia de hoy.");
                                telaSup.setFechaIngreso(Calendar.getInstance());
                                System.out.println("Estado: ");
                                String estado5 = this.lector.ingresarTexto();
                                telaSup.setEstado(estado5);
                                
                                System.out.println("Proximo Cambio: ");
                                System.out.println("En formato dd/mm/aaaa. ");
                                String fecha5 = this.lector.ingresarTexto();
                                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                Date date5 = this.sdf.parse(fecha5);
                                Calendar calendar5 = Calendar.getInstance();
                                calendar5.setTime(date5);
                                telaSup.setFechaSalida(calendar5);
                                break;
                                
                            //Tela inferior
                            case 6:
                                
                                                                                                
                                lector.buffer();
                                
                                Equipo telaInf = this.creador.crearTelaInferior();
                                System.out.println("Proveedor: ");
                                String proveedor6 = this.lector.ingresarTexto();
                                telaInf.setProveedor(proveedor6);
                                String posi6 = this.lector.ingresarTexto();
                                telaInf.setPosi(posi6);
                                System.out.println("Fecha ingresada automaticamete al dia de hoy.");
                                telaInf.setFechaIngreso(Calendar.getInstance());
                                System.out.println("Estado: ");
                                String estado6 = this.lector.ingresarTexto();
                                telaInf.setEstado(estado6);
                                
                                System.out.println("Proximo Cambio: ");
                                System.out.println("En formato dd/mm/aaaa. ");
                                String fecha6 = this.lector.ingresarTexto();
                                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                Date date6 = this.sdf.parse(fecha6);
                                Calendar calendar6 = Calendar.getInstance();
                                calendar6.setTime(date6);
                                telaInf.setFechaSalida(calendar6);
                                break;
                                
                            //Manta
                            case 7:
                                
                                                                                                
                                lector.buffer();
                                
                                Equipo manta = this.creador.crearManta();
                                System.out.println("Proveedor: ");
                                String proveedor7 = this.lector.ingresarTexto();
                                manta.setProveedor(proveedor7);
                                String posi7 = this.lector.ingresarTexto();
                                manta.setPosi(posi7);
                                System.out.println("Fecha ingresada automaticamete al dia de hoy.");
                                manta.setFechaIngreso(Calendar.getInstance());
                                System.out.println("Estado: ");
                                String estado7 = this.lector.ingresarTexto();
                                manta.setEstado(estado7);
                                
                                System.out.println("Proximo Cambio: ");
                                System.out.println("En formato dd/mm/aaaa. ");
                                String fecha7 = this.lector.ingresarTexto();
                                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                Date date7 = this.sdf.parse(fecha7);
                                Calendar calendar7 = Calendar.getInstance();
                                calendar7.setTime(date7);
                                manta.setFechaSalida(calendar7);
                                break;
                                
                            //C. Transversal
                            case 8:
                                
                                                                                                
                                lector.buffer();
                                
                                Equipo cTransversal = this.creador.crearCTrnasversal();
                                System.out.println("Proveedor: ");
                                String proveedor8 = this.lector.ingresarTexto();
                                cTransversal.setProveedor(proveedor8);
                                String posi8 = this.lector.ingresarTexto();
                                cTransversal.setPosi(posi8);
                                System.out.println("Fecha ingresada automaticamete al dia de hoy.");
                                cTransversal.setFechaIngreso(Calendar.getInstance());
                                System.out.println("Estado: ");
                                String estado8 = this.lector.ingresarTexto();
                                cTransversal.setEstado(estado8);
                                
                                System.out.println("Proximo Cambio: ");
                                System.out.println("En formato dd/mm/aaaa. ");
                                String fecha8 = this.lector.ingresarTexto();
                                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                Date date8 = this.sdf.parse(fecha8);
                                Calendar calendar8 = Calendar.getInstance();
                                calendar8.setTime(date8);
                                cTransversal.setFechaSalida(calendar8);
                                break;
                                
                            //Nivel TADB2
                            case 9:
                                
                                                                                                
                                lector.buffer();
                                
                                Equipo nTADB2 = this.creador.crearNivelTADB2();
                                System.out.println("Proveedor: ");
                                String proveedor9 = this.lector.ingresarTexto();
                                nTADB2.setProveedor(proveedor9);
                                String posi9 = this.lector.ingresarTexto();
                                nTADB2.setPosi(posi9);
                                System.out.println("Fecha ingresada automaticamete al dia de hoy.");
                                nTADB2.setFechaIngreso(Calendar.getInstance());
                                System.out.println("Estado: ");
                                String estado9 = this.lector.ingresarTexto();
                                nTADB2.setEstado(estado9);
                                
                                System.out.println("Proximo Cambio: ");
                                System.out.println("En formato dd/mm/aaaa. ");
                                String fecha9 = this.lector.ingresarTexto();
                                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                Date date9 = this.sdf.parse(fecha9);
                                Calendar calendar9 = Calendar.getInstance();
                                calendar9.setTime(date9);
                                nTADB2.setFechaSalida(calendar9);
                                break;
                                
                            //Nivel TADB3
                            case 10:
                                
                                                                                                
                                lector.buffer();
                                
                                Equipo nTADB3 = this.creador.crearNivelTADB3();
                                System.out.println("Proveedor: ");
                                String proveedor10 = this.lector.ingresarTexto();
                                nTADB3.setProveedor(proveedor10);
                                String posi10 = this.lector.ingresarTexto();
                                nTADB3.setPosi(posi10);
                                System.out.println("Fecha ingresada automaticamete al dia de hoy.");
                                nTADB3.setFechaIngreso(Calendar.getInstance());
                                System.out.println("Estado: ");
                                String estado10 = this.lector.ingresarTexto();
                                nTADB3.setEstado(estado10);
                                
                                System.out.println("Proximo Cambio: ");
                                System.out.println("En formato dd/mm/aaaa. ");
                                String fecha10 = this.lector.ingresarTexto();
                                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                Date date10 = this.sdf.parse(fecha10);
                                Calendar calendar10 = Calendar.getInstance();
                                calendar10.setTime(date10);
                                nTADB3.setFechaSalida(calendar10);
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
          