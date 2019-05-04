/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojos.ZoomDetail;

/**
 *
 * @author Asus
 */
public interface IRoomDetailDAO {

    int save(ZoomDetail zomDetail);

    int update(ZoomDetail zomDetail);

    int delete(ZoomDetail zomDetail);
    
    ZoomDetail findById(int id);
    
    List<ZoomDetail> findAllByIdRoom(int idRoom);
    
    List<ZoomDetail> findAll();

}
