/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import java.util.ArrayList;

/**
 *
 * @author Zerling
 */
public class Datos 
{
    private ArrayList<Equipo> Actual;
    private ArrayList<Equipo> hPickUp;
    private ArrayList<Equipo> h2daPrensa;
    private ArrayList<Equipo> h3raSuperior;
    private ArrayList<Equipo> h3raInferior;
    private ArrayList<Equipo> h3TelaSup;
    private ArrayList<Equipo> h3TelaInf;
    private ArrayList<Equipo> hManta;
    private ArrayList<Equipo> hTransversal;
    private ArrayList<Equipo> hExHumedo;
    private ArrayList<Equipo> hExSeco;
    private ArrayList<Equipo> hCintaEn;
    private ArrayList<Equipo> hCHP1;
    private ArrayList<Equipo> hCHP2;
    private ArrayList<Equipo> hCHP3;
    private ArrayList<Equipo> hCHS;
    private ArrayList<Equipo> hCHT;
    
    public Datos()
    {
        this.Actual = new ArrayList<>(16);
        this.hPickUp = new ArrayList<>();
        this.h2daPrensa = new ArrayList<>();
        this.h3raSuperior = new ArrayList<>();
        this.h3raInferior = new ArrayList<>();
        this.h3TelaSup = new ArrayList<>();
        this.h3TelaInf = new ArrayList<>();
        this.hManta = new ArrayList<>();
        this.hTransversal = new ArrayList<>();
        this.hExHumedo = new ArrayList<>();
        this.hExSeco = new ArrayList<>();
        this.hCintaEn = new ArrayList<>();
        this.hCHP1 = new ArrayList<>();
        this.hCHP2 = new ArrayList<>();
        this.hCHP3 = new ArrayList<>();
        this.hCHS = new ArrayList<>();
        this.hCHT = new ArrayList<>();
    }

    public ArrayList<Equipo> getActual() {
        return Actual;
    }

    public void setActual(ArrayList<Equipo> Actual) {
        this.Actual = Actual;
    }

    public ArrayList<Equipo> gethPickUp() {
        return hPickUp;
    }

    public void sethPickUp(ArrayList<Equipo> hPickUp) {
        this.hPickUp = hPickUp;
    }

    public ArrayList<Equipo> getH2daPrensa() {
        return h2daPrensa;
    }

    public void setH2daPrensa(ArrayList<Equipo> h2daPrensa) {
        this.h2daPrensa = h2daPrensa;
    }

    public ArrayList<Equipo> getH3raSuperior() {
        return h3raSuperior;
    }

    public void setH3raSuperior(ArrayList<Equipo> h3raSuperior) {
        this.h3raSuperior = h3raSuperior;
    }

    public ArrayList<Equipo> getH3raInferior() {
        return h3raInferior;
    }

    public void setH3raInferior(ArrayList<Equipo> h3raInferior) {
        this.h3raInferior = h3raInferior;
    }

    public ArrayList<Equipo> getH3TelaSup() {
        return h3TelaSup;
    }

    public void setH3TelaSup(ArrayList<Equipo> h3TelaSup) {
        this.h3TelaSup = h3TelaSup;
    }

    public ArrayList<Equipo> getH3TelaInf() {
        return h3TelaInf;
    }

    public void setH3TelaInf(ArrayList<Equipo> h3TelaInf) {
        this.h3TelaInf = h3TelaInf;
    }

    public ArrayList<Equipo> gethManta() {
        return hManta;
    }

    public void sethManta(ArrayList<Equipo> hManta) {
        this.hManta = hManta;
    }

    public ArrayList<Equipo> gethTransversal() {
        return hTransversal;
    }

    public void sethTransversal(ArrayList<Equipo> hTransversal) {
        this.hTransversal = hTransversal;
    }

    public ArrayList<Equipo> gethExHumedo() {
        return hExHumedo;
    }

    public void sethExHumedo(ArrayList<Equipo> hExHumedo) {
        this.hExHumedo = hExHumedo;
    }

    public ArrayList<Equipo> gethExSeco() {
        return hExSeco;
    }

    public void sethExSeco(ArrayList<Equipo> hExSeco) {
        this.hExSeco = hExSeco;
    }

    public ArrayList<Equipo> gethCintaEn() {
        return hCintaEn;
    }

    public void sethCintaEn(ArrayList<Equipo> hCintaEn) {
        this.hCintaEn = hCintaEn;
    }

    public ArrayList<Equipo> gethCHP1() {
        return hCHP1;
    }

    public void sethCHP1(ArrayList<Equipo> hCHP1) {
        this.hCHP1 = hCHP1;
    }

    public ArrayList<Equipo> gethCHP2() {
        return hCHP2;
    }

    public void sethCHP2(ArrayList<Equipo> hCHP2) {
        this.hCHP2 = hCHP2;
    }

    public ArrayList<Equipo> gethCHP3() {
        return hCHP3;
    }

    public void sethCHP3(ArrayList<Equipo> hCHP3) {
        this.hCHP3 = hCHP3;
    }

    public ArrayList<Equipo> gethCHS() {
        return hCHS;
    }

    public void sethCHS(ArrayList<Equipo> hCHS) {
        this.hCHS = hCHS;
    }

    public ArrayList<Equipo> gethCHT() {
        return hCHT;
    }

    public void sethCHT(ArrayList<Equipo> hCHT) {
        this.hCHT = hCHT;
    }
}
