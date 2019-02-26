/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

/**
 *
 * @author Zerling
 */
public class CreaEquipo 
{

    public CreaEquipo()
    {
    }
    
    public Equipo crearPickUp()
    {
        Equipo pickUp = new Equipo();
        pickUp.setCodInterno(0);
        pickUp.setCodigoSap(334560);
        pickUp.setNombre("Pick Up");
        
        return pickUp;
    }
    
    public Equipo crear2daPrensa()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(1);
        equipo.setCodigoSap(334561);
        equipo.setNombre("2da Prensa");
        
        return equipo;
    }
    
    public Equipo crear3raSuperior()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(2);
        equipo.setCodigoSap(0);
        equipo.setNombre("3ra Superior");
        
        return equipo;
    }
    public Equipo crear3raInferior()
    {
        Equipo equipo = new Equipo();
        equipo.setCodigoSap(0);
        equipo.setCodInterno(3);
        equipo.setNombre("3ra Inferior");
        
        return equipo;
    }
    public Equipo crearTelaSuperior()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(4);
        equipo.setCodigoSap(0);
        equipo.setNombre("Tela Superior");
        
        return equipo;
    }
    public Equipo crearTelaInferior()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(5);
        equipo.setCodigoSap(0);
        equipo.setNombre("Tela Inferior");
        
        return equipo;
    }
    public Equipo crearManta()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(6);
        equipo.setCodigoSap(0);
        equipo.setNombre("Manta");
        
        return equipo;
    }
    public Equipo crearCTrnasversal()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(7);
        equipo.setCodigoSap(0);
        equipo.setNombre("C. Transversal");
        
        return equipo;
    }
    public Equipo crearExHumedo()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(8);
        equipo.setCodigoSap(0);
        equipo.setNombre("Tela Extremo Humedo");
        
        return equipo;
    }
    public Equipo crearExSeco()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(9);
        equipo.setCodigoSap(0);
        equipo.setNombre("Nivel Extremo Seco");
        
        return equipo;
    }
    public Equipo crearCintaEn()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(10);
        equipo.setCodigoSap(0);
        equipo.setNombre("Cinta Enhebrado");
        
        return equipo;
    }
    public Equipo crearCHP1()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(11);
        equipo.setCodigoSap(0);
        equipo.setNombre("Canastillo Hernero Primario 1");
        
        return equipo;
    }
    public Equipo crearCHP2()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(12);
        equipo.setCodigoSap(0);
        equipo.setNombre("Canastillo Hernero Primario 2");
        
        return equipo;
    }
    public Equipo crearCHP3()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(13);
        equipo.setCodigoSap(0);
        equipo.setNombre("Canastillo Hernero Primario 3");
        
        return equipo;
    }
    public Equipo crearCHS()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(14);
        equipo.setCodigoSap(0);
        equipo.setNombre("Canastillo Hernero Secundario");
        
        return equipo;
    }
    public Equipo crearCHT()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(15);
        equipo.setCodigoSap(0);
        equipo.setNombre("Canastillo Hernero Terciario");
        
        return equipo;
    }
}
