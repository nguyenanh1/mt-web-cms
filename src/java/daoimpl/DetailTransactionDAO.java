/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.ITransactionDetailDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pojos.DetailTransaction;
import util.DAOUtil;

/**
 *
 * @author Asus
 */
public class DetailTransactionDAO implements ITransactionDetailDAO{

    @Override
    public List<DetailTransaction> getList(int idTrans) {
        String hql = "From DetailTransaction dt where dt.idTransaction = :idTrans";
        Map<String,Object> map = new HashMap<>();
        map.put("idTrans",idTrans);
        List<DetailTransaction> mList = DAOUtil.getList(hql, map);
        return mList;
    }
    
}
