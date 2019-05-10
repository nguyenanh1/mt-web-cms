/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class TicketMapping {
    private int id;
    private Integer status;
    private String price;
    private String position;
    private String createBy;
    private String timeCreate;
    private String updateBy;
    private String timeUpdate;

    public TicketMapping() {
    }

    public TicketMapping(int id, Integer status, String price, String position, String createBy, String timeCreate, String updateBy, String timeUpdate) {
        this.id = id;
        this.status = status;
        this.price = price;
        this.position = position;
        this.createBy = createBy;
        this.timeCreate = timeCreate;
        this.updateBy = updateBy;
        this.timeUpdate = timeUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(String timeCreate) {
        this.timeCreate = timeCreate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(String timeUpdate) {
        this.timeUpdate = timeUpdate;
    }
    
    
}
