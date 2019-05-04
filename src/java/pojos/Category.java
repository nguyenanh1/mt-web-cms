package pojos;
// Generated Apr 22, 2019 11:53:07 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Category generated by hbm2java
 */
public class Category  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Integer createBy;
     private Date timeCreate;
     private Integer updateBy;
     private Date timeUpdate;

    public Category() {
    }

    public Category(String name, Integer createBy, Date timeCreate, Integer updateBy, Date timeUpdate) {
       this.name = name;
       this.createBy = createBy;
       this.timeCreate = timeCreate;
       this.updateBy = updateBy;
       this.timeUpdate = timeUpdate;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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

