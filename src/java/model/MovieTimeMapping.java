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
public class MovieTimeMapping {
    private Integer id;
    private String timeStart;
    private String dateStart;
    private String price;
    private String idMovie;
    private String idRoom;
    private String createBy;
    private String timeCreate;
    private String updateBy;
    private String timeUpdate;

    public MovieTimeMapping() {
    }

    public MovieTimeMapping(Integer id, String timeStart, String dateStart, String price, String idMovie, String idRoom, String createBy, String timeCreate, String updateBy, String timeUpdate) {
        this.id = id;
        this.timeStart = timeStart;
        this.dateStart = dateStart;
        this.price = price;
        this.idMovie = idMovie;
        this.idRoom = idRoom;
        this.createBy = createBy;
        this.timeCreate = timeCreate;
        this.updateBy = updateBy;
        this.timeUpdate = timeUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(String idMovie) {
        this.idMovie = idMovie;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
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
