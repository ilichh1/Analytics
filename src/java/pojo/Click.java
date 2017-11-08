/*
 * Licencia pendiente, para cambiar la licencia ir a -> Tools | Templates
 */

package pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ilich Arredondo
 */
@Entity
@Table(name="click",catalog="")
public class Click {
    
    @Id @GeneratedValue
    @Column(name="idClick")
    private int idClick;
    
    @Column(name="datetime")
    private Date dateTime;
    
    @Column(name="coordx")
    private String coordX;
    
    @Column(name="coordy")
    private String coordY;
    
    @Column(name="sizex")
    private String sizeX;
    
    @Column(name="sizey")
    private String sizeY;
    
    @Column(name="useragent")
    private String userAgent;
    
    @Column(name="classlist_target")
    private String classlistTarget;
    
    @Column(name="id_target")
    private String idTarget;
    
    @Column(name="outerhtml_target")
    private String outerHTMLTarget;
    
    @Column(name="target")
    private String targetTagname;
    
    public Click() {}
    
    public Click(
            Date dt,
            String cox,
            String coy,
            String siy,
            String six,
            String ua,
            String ct,
            String idt,
            String ohtml,
            String tar) {
        this.dateTime = dt;
        this.coordX = cox;
        this.coordY = coy;
        this.sizeY = siy;
        this.sizeX = six;
        this.userAgent = ua;
        this.classlistTarget = ct;
        this.idTarget = idt;
        this.outerHTMLTarget = ohtml;
        this.targetTagname = tar;
    }
    
    /**
     * @return the idClick
     */
    public int getIdClick() {
        return idClick;
    }

    /**
     * @param idClick the idClick to set
     */
    public void setIdClick(int idClick) {
        this.idClick = idClick;
    }

    /**
     * @return the dateTime
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the coordX
     */
    public String getCoordX() {
        return coordX;
    }

    /**
     * @param coordX the coordX to set
     */
    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    /**
     * @return the coordY
     */
    public String getCoordY() {
        return coordY;
    }

    /**
     * @param coordY the coordY to set
     */
    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }

    /**
     * @return the sizeX
     */
    public String getSizeX() {
        return sizeX;
    }

    /**
     * @param sizeX the sizeX to set
     */
    public void setSizeX(String sizeX) {
        this.sizeX = sizeX;
    }

    /**
     * @return the sizeY
     */
    public String getSizeY() {
        return sizeY;
    }

    /**
     * @param sizeY the sizeY to set
     */
    public void setSizeY(String sizeY) {
        this.sizeY = sizeY;
    }

    /**
     * @return the userAgent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * @param userAgent the userAgent to set
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * @return the classlistTarget
     */
    public String getClasslistTarget() {
        return classlistTarget;
    }

    /**
     * @param classlistTarget the classlistTarget to set
     */
    public void setClasslistTarget(String classlistTarget) {
        this.classlistTarget = classlistTarget;
    }

    /**
     * @return the idTarget
     */
    public String getIdTarget() {
        return idTarget;
    }

    /**
     * @param idTarget the idTarget to set
     */
    public void setIdTarget(String idTarget) {
        this.idTarget = idTarget;
    }

    /**
     * @return the outerHTMLTarget
     */
    public String getOuterHTMLTarget() {
        return outerHTMLTarget;
    }

    /**
     * @param outerHTMLTarget the outerHTMLTarget to set
     */
    public void setOuterHTMLTarget(String outerHTMLTarget) {
        this.outerHTMLTarget = outerHTMLTarget;
    }

    /**
     * @return the targetTagname
     */
    public String getTargetTagname() {
        return targetTagname;
    }

    /**
     * @param targetTagname the targetTagname to set
     */
    public void setTargetTagname(String targetTagname) {
        this.targetTagname = targetTagname;
    }
    
}