//@Authors: João Dinízio, Pedro, Vanderson e Wender

import java.util.LinkedList;
public class Carta {

    //Variáveis gerais da Carta
    protected String nome;
    protected String codigo;
    protected String tema;
    protected int atributo1;
    protected int atributo2;
    protected double atributo3;
    protected int atributo4;
    protected String curiosidade1;
    protected String curiosidade2;
    protected String curiosidade3;
    protected boolean superTrunfo;
    protected boolean antiSuperTrunfo;//True se o monte do joagador tiver alguma carta da Classe A e false caso contraário, isso impedirá que o adversário com a carta Super Trunfo ganhe a rodada instântaneamente caso seja antiSuperTrunfo = true 

    //Variáveis específicas para identificação dos atributos
    protected String nomeAtributo1;
    protected String nomeAtributo2;
    protected String nomeAtributo3;
    protected String nomeAtributo4;
    protected String unidadeMedida1;
    protected String unidadeMedida2;
    protected String unidadeMedida3;
    protected String unidadeMedida4;
    protected LinkedList<String> listaDeAtributos;
    

    public Carta(String nome, String codigo, String tema, int atributo1, int atributos2, double atributos3, int atributos4, String curiosidade1, String curiosidade2, String curiosidade3, boolean SuperTrunfo, boolean antiSuperTrunfo){
        this.nome = nome;
        this.codigo = codigo;
        this.tema = tema;
        this.atributo1 = atributo1;
        this.atributo2 = atributos2;
        this.atributo3 = atributos3;
        this.atributo4 = atributos4;
        this.curiosidade1 = curiosidade1;
        this.curiosidade2 = curiosidade2;
        this.curiosidade3 = curiosidade3;
        this.superTrunfo = SuperTrunfo;
        this.antiSuperTrunfo = antiSuperTrunfo;
        
        configurarAtributos(tema);
    }

    //Configura os nomes dos atributos e suas unidades de medida através da classe atributo
    public void configurarAtributos(String Tema){
        Atributo Atributos = new Atributo(Tema);
        listaDeAtributos = Atributos.setAtributos(Tema);

        nomeAtributo1 = listaDeAtributos.get(0);
        nomeAtributo2 = listaDeAtributos.get(1);
        nomeAtributo3 = listaDeAtributos.get(2);
        nomeAtributo4 = listaDeAtributos.get(3);

        unidadeMedida1 = listaDeAtributos.get(4);
        unidadeMedida2 = listaDeAtributos.get(5);
        unidadeMedida3 = listaDeAtributos.get(6);
        unidadeMedida4 = listaDeAtributos.get(7);

    }

    //Esse método serve somente para converter o true em "Sim" e false em "Não"
    public String superTrunfoString(Boolean superTrunfo){
        if(superTrunfo == true){return "Sim";}
        else return "Não";
    }

    //Métodos Get
    public String getNome(){return this.nome;}
    public String getCodigo(){return this.codigo;}
    public String getTema(){return this.tema;}
    public int getAtributo1(){return this.atributo1;}
    public int getAtributo2(){return this.atributo2;}
    public double getAtributo3(){return this.atributo3;}
    public int getAtributo4(){return this.atributo4;}
    public String getCuriosidade1(){return this.curiosidade1;}
    public String getCuriosidade2(){return this.curiosidade2;}
    public String getCuriosidade3(){return this.curiosidade3;}
    public boolean getSuperTrunfo(){return this.superTrunfo;}
    public String getSuperTrunfoString(){return this.superTrunfoString(superTrunfo);}//Retorna o Super Trunfo como Sim ou Não
    public LinkedList<String> getListaDeAtributos(){return this.listaDeAtributos;} //Retorna o nome dos atributos e das unidades de medida que variam de acordo com cada tema
    public boolean getAntiSuperTrunfo(){return this.antiSuperTrunfo;}
    public String getNomeAtributo1(){return this.nomeAtributo1;}
    public String getNomeAtributo2(){return this.nomeAtributo2;}
    public String getNomeAtributo3(){return this.nomeAtributo3;}
    public String getNomeAtributo4(){return this.nomeAtributo4;}
    public String getUnidadeAtributo1(){return this.unidadeMedida1;}
    public String getUnidadeAtributo2(){return this.unidadeMedida2;}
    public String getUnidadeAtributo3(){return this.unidadeMedida3;}
    public String getUnidadeAtributo4(){return this.unidadeMedida4;}

    //Métodos Set
    protected void setNome(String nome){this.nome = nome;}
    protected void setCodigo(String codigo){this.codigo = codigo;}
    protected void setAtributo1(int Atributo1){this.atributo1 = Atributo1;}
    protected void setAtributo2(int Atributo2){this.atributo2 = Atributo2;}
    protected void setAtributo3(Double Atributo3){this.atributo3 = Atributo3;}
    protected void setAtributo4(int Atributo4){this.atributo4 = Atributo4;}
    protected void setCuriosidade1(String Curiosidade1){this.curiosidade1 = curiosidade1;}
    protected void setCuriosidade2(String Curiosidade2){this.curiosidade2 = curiosidade2;}
    protected void setCuriosidade3(String Curiosidade3){this.curiosidade3 = curiosidade3;}
    protected void setAntiSuperTrunfo(boolean Estado){this.antiSuperTrunfo = Estado;}
    

    @Override
    public String toString(){
        return "Carta: {Nome: " + this.nome +", Código: " + this.codigo + ", " + nomeAtributo1 +": " + this.atributo1 +" " + unidadeMedida1 + ", " + nomeAtributo2 +": " + this.atributo2 +" " + unidadeMedida2 + ", " + nomeAtributo3 +": " + this.atributo3 +" " + unidadeMedida3 + ", " + nomeAtributo4 +": " + this.atributo4 +" " + unidadeMedida4 + ", Curiosidade 01: " + this.curiosidade1 + ", Curiosidade 02: " + this.curiosidade2 + ", Curiosidade 03: " + this.curiosidade3 + ", Super Trunfo: " + this.superTrunfoString(superTrunfo) + "}";
    }
}