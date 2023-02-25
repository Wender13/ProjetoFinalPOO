//@Authors: João Dinízio, Pedro, Vanderson e Wender

import java.util.LinkedList;
public class Atributo extends LinkedList<String> {
    private String Tema;
    private String nomeAtributo1;
    private String nomeAtributo2;
    private String nomeAtributo3;
    private String nomeAtributo4;
    private String unidadeMedida1;
    private String unidadeMedida2;
    private String unidadeMedida3;
    private String unidadeMedida4;

    public Atributo(String Tema){this.Tema = Tema; }

    //Seleciona os nomes dos atributos e as unidades de medida de acordo com o tema e adiciona à própria classe que é uma lista e então retorna ela mesma para ser atribuída a uma lista externa
    public LinkedList<String> setAtributos(String Tema){
        switch (Tema) {
            case "animais":
            nomeAtributo1 = "Peso";
            nomeAtributo2 = "Velocidade";
            nomeAtributo3 = "Comprimento";
            nomeAtributo4 = "Longevidade";
            unidadeMedida1 = "Kg";
            unidadeMedida2 = "Km/h";
            unidadeMedida3 = "m";
            unidadeMedida4 = "anos";
                break;

            case "astronomia":
                nomeAtributo1 = "Massa";
                nomeAtributo2 = "Densidade";
                nomeAtributo3 = "Diâmetro";
                nomeAtributo4 = "Temperatura";
                unidadeMedida1 = "m+";
                unidadeMedida2 = "g/cm³";
                unidadeMedida3 = "Km";
                unidadeMedida4 = "°C";
                break;

            case "carros":
                nomeAtributo1 = "Potência";
                nomeAtributo2 = "Torque";
                nomeAtributo3 = "0-100";
                nomeAtributo4 = "Cilindrada";
                unidadeMedida1 = "cv";
                unidadeMedida2 = "N.m²";
                unidadeMedida3 = "s";
                unidadeMedida4 = "cc";
                break;

            case "deuses":
                nomeAtributo1 = "Força";
                nomeAtributo2 = "Velocidade";
                nomeAtributo3 = "Inteligência";
                nomeAtributo4 = "Poderes";
                unidadeMedida1 = "uF";
                unidadeMedida2 = "uV";
                unidadeMedida3 = "uI";
                unidadeMedida4 = "uP";
                break;

            default: System.out.println("Este tema não existe, selecione um válido!");
                break;
        }

        this.add(nomeAtributo1);
        this.add(nomeAtributo2);
        this.add(nomeAtributo3);
        this.add(nomeAtributo4);
        this.add(unidadeMedida1);
        this.add(unidadeMedida2);
        this.add(unidadeMedida3);
        this.add(unidadeMedida4);

        return this;
    }
}