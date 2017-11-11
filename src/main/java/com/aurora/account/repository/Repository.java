
package com.aurora.account.repository;
import com.aurora.account.Util.DbConnection;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
public abstract class Repository {
    private DbConnection con;
    protected JdbcTemplate stmt;
    
    public Repository(){
       this.con =new DbConnection();
       this.stmt = con.getConnection();
    }
    
    public abstract void saveObj(Object object);
    public abstract Object getOne(String id);
    public abstract boolean checkAvailability(String id);
    
    
}
