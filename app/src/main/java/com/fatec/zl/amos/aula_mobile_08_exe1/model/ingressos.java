package com.fatec.zl.amos.aula_mobile_08_exe1.model;

public class ingressos {

    private float valor;
    private String ID;




    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    public float getValor() {
        return valor ;
    }

    public float getValorFinal(float taxa) {
        return  (getValor() * taxa);

    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
