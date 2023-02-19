package SuperTrunfo;

public class Carta {
    String nome;
    String codigo;
    int atributo1;
    int atributo2;
    int atributo3;
    double atributo4;
    String curiosidade1;
    String curiosidade2;
    String curiosidade3;
    boolean superTrunfo;
    

    public Carta(String nome, String codigo, int atributo1, int atributo2, int atributo3, double atributo4, String curiosidade1, String curiosidade2, String curiosidade3, boolean superTrunfo){
        this.nome = nome;
        this.codigo = codigo;
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
        this.atributo3 = atributo3;
        this.atributo4 = atributo4;
        this.curiosidade1 = curiosidade1;
        this.curiosidade2 = curiosidade2;
        this.curiosidade3 = curiosidade3;
        this.superTrunfo = superTrunfo;

    }

    //Métodos Get

    private String getNome(){return this.nome;}
    private String getCodigo(){return this.codigo;}
    private int getAtributo1(){return this.atributo1;}
    private int getAtributo2(){return this.atributo2;}
    private int getAtributo3(){return this.atributo3;}
    private double getAtributo4(){return this.atributo4;}
    private String getCuriosidade1(){return this.curiosidade1;}
    private String getCuriosidade2(){return this.curiosidade2;}
    private String getCuriosidade3(){return this.curiosidade3;}
    private boolean getSuperTrunfo(){return this.superTrunfo;}

    //Métodos Set

    private void setNome(String nome){this.nome = nome;}
    private void setCodigo(String codigo){this.codigo = codigo;}
    private void setAtributo1(int Atributo1){this.atributo1 = Atributo1;}
    private void setAtributo2(int Atributo2){this.atributo2 = Atributo2;}
    private void setAtributo3(int Atributo3){this.atributo3 = Atributo3;}
    private void setAtributo4(double Atributo4){this.atributo4 = Atributo4;}
    private void setCuriosidade1(String Curiosidade1){this.curiosidade1 = curiosidade1;}
    private void setCuriosidade2(String Curiosidade2){this.curiosidade2 = curiosidade2;}
    private void setCuriosidade3(String Curiosidade3){this.curiosidade3 = curiosidade3;}

    @Override

    public String toString(){
        return "{Nome: " + this.nome +", código: " + this.codigo + ", }";
    }
}
