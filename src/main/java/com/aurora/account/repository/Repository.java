
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
    public abstract List fetchIds();
    public abstract  String getJavaScriptIdList();
    public String toJavascriptArray(List<String> arr){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i=0; i<arr.size(); i++){
            sb.append("\"").append(arr.get(i)).append("\"");
            if(i+1 < arr.size()){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
   
    
    
}
