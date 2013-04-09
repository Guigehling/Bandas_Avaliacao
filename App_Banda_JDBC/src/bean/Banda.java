/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Gustavo
 */
public class Banda {

    private int cod;
    private String nome;
    private String biografia;

    public Banda() {
    }

    public Banda(String nome, String biografia) {
        this.nome = nome;
        this.biografia = biografia;
    }

    public Banda(int cod) {
        this.cod = cod;
    }

    public Banda(int cod, String nome, String biografia) {
        this.cod = cod;
        this.nome = nome;
        this.biografia = biografia;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
