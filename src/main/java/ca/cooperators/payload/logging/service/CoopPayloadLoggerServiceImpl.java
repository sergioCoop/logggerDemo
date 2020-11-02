package ca.cooperators.payload.logging.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ca.cooperators.payload.logging.service.dao.PayLoadDaoImpl;
import ca.cooperators.payload.logging.service.entity.PayLoad;


@Component
public class CoopPayloadLoggerServiceImpl implements CoopPayloadLoggerService {
	@Resource
	PayLoadDaoImpl plDao;
	
	@Override
	public Long insertPayload(PayLoad pl) {
		// TODO Auto-generated method stub
		Long flowid = plDao.insertPayload(pl);
		return flowid;
	}

}
