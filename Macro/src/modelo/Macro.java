/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

public class Macro {

    public ArrayList<String> tabelaMacros;
    public String nomeMacro;
    public ArrayList<String> Args;
    public String label;
    public int num;

    public Macro() {
        this.label = new String();
        this.nomeMacro = new String();
        this.tabelaMacros = new ArrayList();
        this.Args = new ArrayList();
        this.num = 0;
    }
}
