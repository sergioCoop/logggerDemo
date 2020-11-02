package ca.cooperators.payload.logging.service.dao;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ca.cooperators.payload.logging.service.entity.PayLoad;
import ca.cooperators.payload.logging.service.generator.SequenceGenerator;

@Repository
public class PayLoadDaoImpl implements PayloadDao{
	NamedParameterJdbcTemplate template;
	
	public PayLoadDaoImpl(NamedParameterJdbcTemplate template) {
	 this.template = template;
	}

	@Override
	public long insertPayload(PayLoad payload) {
		// TODO Auto-generated method stub
		final String sql = "insert into payload(flowid, appname, requesttype , integrationname, payload, createtime) "
				+ "values(:flowid,:appname,:requesttype,:integrationname,:payload,:createtime)";
		Long id  = payload.getFlowID();
		if(id == 0) {
			SequenceGenerator gen = new SequenceGenerator();
			id = gen.nextId();
		}
		
		Timestamp currentDateTime = Timestamp.from(Instant.now());
		/*
		 KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
        		.addvalue("flowid", id)
        		.addvalue("appname", payload.getAppName())
        		.addvalue("requesttype", payload.getRequestType())
        		.addvalue("integrationname", payload.getIntegrationName())
        		.addvalue("payload", payload.getPayload())
        		.addvalue("createtime",currentDateTime );
        template.update(sql, param, holder);
        */
		
        
        Map<String,Object> map=new HashMap<String,Object>();
				map.put("flowid", id);
				map.put("appname", payload.getAppName());
				map.put("requesttype", payload.getRequestType());
				map.put("integrationname", payload.getIntegrationName());
				map.put("payload", payload.getPayload());
				map.put("createtime",currentDateTime );
				
	   template.execute(sql,map,new PreparedStatementCallback<Object>() {  
				    @Override  
				    public Object doInPreparedStatement(PreparedStatement ps)  
				            throws SQLException, DataAccessException {  
				        return ps.executeUpdate();  
				    }  
				});
				  		
        
        
        return id;

	}

}
