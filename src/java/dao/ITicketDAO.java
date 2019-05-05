/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojos.Ticket;

/**
 *
 * @author Asus
 */
public interface ITicketDAO {
    int save(Ticket ticket);
    int update(Ticket ticket);
    int delete(Ticket ticket);
    
}
