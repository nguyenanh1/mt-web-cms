/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojos.DetailTransaction;

/**
 *
 * @author Asus
 */
public interface ITransactionDetailDAO {
    List<DetailTransaction> getList(int idTrans);
}
