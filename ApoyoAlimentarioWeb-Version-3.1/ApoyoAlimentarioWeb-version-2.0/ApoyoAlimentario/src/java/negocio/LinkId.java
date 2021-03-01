/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author CARLOS SANTIAGO ROJAS MORENO
 */
public class LinkId {
    private int id;
    private String link;

    public LinkId(int id, String link) {
        this.id = id;
        this.link = link;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
}
