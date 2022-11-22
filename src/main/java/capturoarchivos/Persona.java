/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capturoarchivos;

import java.util.Date;

/**
 *
 * @author CAROL VELEZ
 */
public class Persona {
    
    private String nombre, tipo_documento;
	private int numero_documento;
        private int referencia_pago;
  

	public Persona(String nombre, String tipo_documento , int numero_documento, int referencia_pago) {
		this.nombre = nombre;
		this.tipo_documento = tipo_documento;
                this.numero_documento = numero_documento;
                this.referencia_pago = referencia_pago;
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public int getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(int numero_documento) {
        this.numero_documento = numero_documento;
    }

    public int getReferencia_pago() {
        return referencia_pago;
    }

    public void setReferencia_pago(int referencia_pago) {
        this.referencia_pago = referencia_pago;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", tipo_documento=" + tipo_documento + ", numero_documento=" + numero_documento + ", referencia_pago=" + referencia_pago + '}';
    }

   

    
   

	

}

    

