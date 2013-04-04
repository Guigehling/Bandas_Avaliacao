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
    private String descricao;
    private String localizacao;

    public Banda(String descricao, String localizacao) {
        this.descricao = descricao;
        this.localizacao = localizacao;
    }



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }


    
}
