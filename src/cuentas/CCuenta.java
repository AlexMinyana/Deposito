/*
 Clase para simular una cuenta corriente
 */
package cuentas;
import java.util.Scanner;
/**
 *
 * @author Alex Miñana
 */
public class CCuenta {
    /**
     * Atributos de la clase CCuenta
     */
    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInterés;
    
    /**
     * Metodos constructores, vacío y normal. Crean un objeto cuenta 
     */
    public CCuenta()
    {
    }

    public CCuenta(String nom, String cue, double sal, double tipo)
    {
        nombre =nom;
        cuenta=cue;
        saldo=sal;
    }
    /**
     * Devuelve el atributo nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para cambiar nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve número de cuenta
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * Cambia número de cuenta
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Devuelve el Saldo de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Cambia el Saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Devuelve el tipo de interés
     */
    public double getTipoInterés() {
        return tipoInterés;
    }

    /**
     * Cambia el tipo de interés 
     */
    public void setTipoInterés(double tipoInterés) {
        this.tipoInterés = tipoInterés;
    }
    /**
     * Devuelve el saldo para saber el estado de la cuenta 
     */
    public double estado()
    {
        return getSaldo();
    }
    
    /**
     * Ingresa la cantidad introducida siempre que sea positiva 
     */
    public void ingresar(double cantidad) throws Exception
    {
        if (cantidad<0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        setSaldo(getSaldo() + cantidad);
    }

    /**
     * Retira una cantidad introducida siempre que sea positiva y que haya suficiente saldo en la cuenta
     */
    public void retirar(double cantidad) throws Exception
    {
        if (cantidad <= 0)
            throw new Exception ("No se puede retirar una cantidad negativa");
        if (estado()< cantidad)
            throw new Exception ("No se hay suficiente saldo");
        setSaldo(getSaldo() - cantidad);
    }
    
    /**
     * Pregunta al usuario que quiere hacer si retirar dinero o ingresarlo
     */
    public void operativa_cuenta(float cantidad) {
        double saldoActual;
        Scanner lectura = new Scanner (System.in);
        saldoActual = this.estado();
        System.out.println("El saldo actual es " + saldoActual );
        System.out.println("¿Quiere retirar efectivo o ingresarlo?");
        String accion = lectura.next();
        
        if(accion.equals("retirar")) { 
        try {
            this.retirar(cantidad);
        } catch (Exception e) {
            System.out.print("Fallo al retirar");
        }
        }
        if (accion.equals("ingresar")) {
        try {
            System.out.println("Ingreso en cuenta");
            this.ingresar(cantidad);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }
        }
    }
}

