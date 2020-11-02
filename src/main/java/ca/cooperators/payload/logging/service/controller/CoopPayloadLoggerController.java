package ca.cooperators.payload.logging.service.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.cooperators.payload.logging.service.CoopPayloadLoggerService;
import ca.cooperators.payload.logging.service.entity.PayLoad;

@RestController
@RequestMapping("/cooplogging")
public class CoopPayloadLoggerController {
	
	@Resource
	CoopPayloadLoggerService plService;
	
	@PostMapping(value = "/insertpayload")	
    public Long insertPayload(@RequestBody PayLoad pl) {
		Long flowid = plService.insertPayload(pl);
		return flowid;
		//Long flowid = new Long(112284575);
		//return flowid;
		
	}

}
