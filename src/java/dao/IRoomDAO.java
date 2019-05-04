/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojos.Room;

/**
 *
 * @author Asus
 */
public interface IRoomDAO {
    int save(Room room);
    int update(Room room);
    int delete(Room room);
    Room findRoomById(int id);
    List<Room> findAllRoom();
}
