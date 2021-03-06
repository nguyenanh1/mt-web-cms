package pojos;
// Generated Apr 22, 2019 11:53:07 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Room generated by hbm2java
 */
public class Room  implements java.io.Serializable {


     private Integer idRoom;
     private String nameRoom;
     private Integer numRow;
     private Integer numCol;
     private Integer createBy;
     private Date timeCreate;
     private Integer updateBy;
     private Date timeUpdate;

    public Room() {
    }

    public Room(String nameRoom, Integer numRow, Integer numCol, Integer createBy, Date timeCreate, Integer updateBy, Date timeUpdate) {
       this.nameRoom = nameRoom;
       this.numRow = numRow;
       this.numCol = numCol;
       this.createBy = createBy;
       this.timeCreate = timeCreate;
       this.updateBy = updateBy;
       this.timeUpdate = timeUpdate;
    }
   
    public Integer getIdRoom() {
        return this.idRoom;
    }
    
    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }
    public String getNameRoom() {
        return this.nameRoom;
    }
    
    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }
    public Integer getNumRow() {
        return this.numRow;
    }
    
    public void setNumRow(Integer numRow) {
        this.numRow = numRow;
    }
    public Integer getNumCol() {
        return this.numCol;
    }
    
    public void setNumCol(Integer numCol) {
        this.numCol = numCol;
    }
    public Integer getCreateBy() {
        return this.createBy;
    }
    
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
    public Date getTimeCreate() {
        return this.timeCreate;
    }
    
    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }
    public Integer getUpdateBy() {
        return this.updateBy;
    }
    
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }
    public Date getTimeUpdate() {
        return this.timeUpdate;
    }
    
    public void setTimeUpdate(Date timeUpdate) {
        this.timeUpdate = timeUpdate;
    }




}


