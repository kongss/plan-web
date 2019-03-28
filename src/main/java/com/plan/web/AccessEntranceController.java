package com.plan.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.plan.utils.bean.MessengerVo;
import com.plan.utils.spring.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@Controller
@RequestMapping(value = "/plan")
public class AccessEntranceController {

    private final static Logger logger = LoggerFactory.getLogger(AccessEntranceController.class);

    @ResponseBody
    @RequestMapping(value = "/entrance", method = RequestMethod.POST)
    public void Entrance(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream  = response.getOutputStream();
        serviceInvoke(request, response);
        outputStream.flush();
    }

    void serviceInvoke(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonData = parseParams(request);
        String invoke = invoke(jsonData);
        //response.getOutputStream().write(invoke.getBytes(Charset.defaultCharset()));
    }

    String invoke(JSONObject jsonObject) {
        logger.info("request invoke Param :{}", jsonObject);
        String serviceCode = jsonObject.getString("service");
        String beanName = "xXPlanServiceImpl"; //TODO
        String beanMethod = "planList"; //TODO
        Object bean = SpringUtil.getBean(beanName);
        System.out.println("bean : "+bean);
        Class<?> clazz = bean.getClass();
        try {
            Method method = clazz.getDeclaredMethod(beanMethod, JSONObject.class);
            System.out.println(method.toString());
            MessengerVo vo = (MessengerVo) method.invoke(bean, jsonObject);
            logger.info("response invoke Result :{}", JSON.toJSONString(vo));
            return JSON.toJSONString(vo);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    JSONObject parseParams(HttpServletRequest request){
        String jsonData = request.getParameter("jsonData");
        if (StringUtils.isEmpty(jsonData)){
            logger.info("jsonData Param Can't be empty");
            return new JSONObject();
        }
        return JSON.parseObject(jsonData);
    }
}

