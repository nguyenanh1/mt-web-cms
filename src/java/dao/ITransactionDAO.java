/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import pojos.Transaction;


/**
 *
 * @author Asus
 */
public interface ITransactionDAO {
    List<Transaction> getTrans(Date from,Date start);
}
