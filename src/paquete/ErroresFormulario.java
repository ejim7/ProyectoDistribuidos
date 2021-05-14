/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

/**
 *
 * @author Kevin Ibarra
 */
public class ErroresFormulario {
    private StringBuilder errores;

    public ErroresFormulario() {
        this.errores = new StringBuilder();
    }
    
    public void validarVacio(String textoValidar) {
        if (textoValidar.isEmpty()) {
            this.errores.append("- El texto no puede estar vacio\n");
        }
    }
}
