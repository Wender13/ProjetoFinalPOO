import java.util.LinkedList;
public class Carta {

    //Variáveis gerais da Carta
    private String nome;
    private String codigo;
    private String tema;
    private int atributo1;
    private int atributo2;
    private double atributo3;
    private int atributo4;
    private String curiosidade1;
    private String curiosidade2;
    private String curiosidade3;
    private boolean superTrunfo;

    //Variáveis específicas para identificação dos atributos
    private String nomeAtributo1;
    private String nomeAtributo2;
    private String nomeAtributo3;
    private String nomeAtributo4;
    private String unidadeMedida1;
    private String unidadeMedida2;
    private String unidadeMedida3;
    private String unidadeMedida4;
    private LinkedList<String> listaDeAtributos;
    

    public Carta(String nome, String codigo, String tema, int atributo1, int atributos2, double atributos3, int atributos4, String curiosidade1, String curiosidade2, String curiosidade3, boolean SuperTrunfo){
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

    //Métodos Get

    private String getNome(){return this.nome;}
    private String getCodigo(){return this.codigo;}
    private String getTema(){return this.tema;}
    private int getAtributo1(){return this.atributo1;}
    private int getAtributo2(){return this.atributo2;}
    private double getAtributo3(){return this.atributo3;}
    private int getAtributo4(){return this.atributo4;}
    private String getCuriosidade1(){return this.curiosidade1;}
    private String getCuriosidade2(){return this.curiosidade2;}
    private String getCuriosidade3(){return this.curiosidade3;}
    private boolean getSuperTrunfo(){return this.superTrunfo;}

    //Métodos Set

    private void setNome(String nome){this.nome = nome;}
    private void setCodigo(String codigo){this.codigo = codigo;}
    private void setAtributo1(int Atributo1){this.atributo1 = Atributo1;}
    private void setAtributo2(int Atributo2){this.atributo2 = Atributo2;}
    private void setAtributo3(Double Atributo3){this.atributo3 = Atributo3;}
    private void setAtributo4(int Atributo4){this.atributo4 = Atributo4;}
    private void setCuriosidade1(String Curiosidade1){this.curiosidade1 = curiosidade1;}
    private void setCuriosidade2(String Curiosidade2){this.curiosidade2 = curiosidade2;}
    private void setCuriosidade3(String Curiosidade3){this.curiosidade3 = curiosidade3;}
    
    @Override
    public String toString(){
        return "Carta: {Nome: " + this.nome +", Código: " + this.codigo + ", " + nomeAtributo1 +": " + this.atributo1 +" " + unidadeMedida1 + ", " + nomeAtributo2 +": " + this.atributo2 +" " + unidadeMedida2 + ", " + nomeAtributo3 +": " + this.atributo3 +" " + unidadeMedida3 + ", " + nomeAtributo4 +": " + this.atributo4 +" " + unidadeMedida4 + ", Curiosidade 01: " + this.curiosidade1 + ", Curiodidade 02: " + this.curiosidade2 + ", Curiosidade 03: " + this.curiosidade3 + ", Super Trunfo: " + this.superTrunfo + "}";
    }
}