package com.fatec.zl.amos.aula_mobile_08_exe1.model;

public class ingressosVip extends ingressos {

    @Override
    public float getValorFinal(float taxa) {

        return getValor() + (taxa) + (getValor()* 0.18f);
    }

}
