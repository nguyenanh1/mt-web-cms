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
public class RoomUser {
     private Integer idRoom;
     private String nameRoom;
     private Integer numRow;
     private Integer numCol;
     private String createBy;
     private String timeCreate;
     private String updateBy;
     private String timeUpdate;

    public RoomUser() {
    }

    public RoomUser(Integer idRoom, String nameRoom, Integer numRow, Integer numCol, String createBy, String timeCreate, String updateBy, String timeUpdate) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.numRow = numRow;
        this.numCol = numCol;
        this.createBy = createBy;
        this.timeCreate = timeCreate;
        this.updateBy = updateBy;
        this.timeUpdate = timeUpdate;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public Integer getNumRow() {
        return numRow;
    }

    public void setNumRow(Integer numRow) {
        this.numRow = numRow;
    }

    public Integer getNumCol() {
        return numCol;
    }

    public void setNumCol(Integer numCol) {
        this.numCol = numCol;
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
