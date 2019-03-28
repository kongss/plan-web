package com.plan.web;

import com.plan.utils.bean.MessengerVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Discard
 */
@Controller
public class PlanController {

    //@Autowired
    //DPlanService dPlanService;

    @ResponseBody
    @RequestMapping(value = "/plan/planList", method = {RequestMethod.GET,RequestMethod.POST})
    public MessengerVo planList(){
        MessengerVo messengerVo = new MessengerVo();
        messengerVo.setInfo("id","1");
        //messengerVo = dPlanService.queryPlan(messengerVo);
        return messengerVo;
    }
}
