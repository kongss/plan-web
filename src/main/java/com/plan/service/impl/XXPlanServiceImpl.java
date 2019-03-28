package com.plan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.plan.api.DPlanService;
import com.plan.service.XXPlanService;
import com.plan.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("xXPlanServiceImpl")
public class XXPlanServiceImpl implements XXPlanService {

    //@Autowired
    //DPlanService dPlanService;

    public MessengerVo planList(JSONObject json){
        MessengerVo messengerVo = new MessengerVo();
        messengerVo.setInfo("id","1");
        //messengerVo = dPlanService.queryPlan(messengerVo);
        return messengerVo;
    }
}
