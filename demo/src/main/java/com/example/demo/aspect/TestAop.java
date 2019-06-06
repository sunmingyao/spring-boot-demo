package com.example.demo.aspect;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.annoation.MyInfoAnnotation;
import com.example.demo.utils.Md5;
import com.example.demo.utils.URLFormatUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
@Aspect
public class TestAop{


    @Pointcut("@annotation(com.example.demo.annoation.MyInfoAnnotation)")
    public void myInfoAnnotation() {
    }

    @Pointcut("execution(* com.example.demo.controller..*.*(..))")
    public void excudeController() {
    }

    @Around(value ="myInfoAnnotation()&&excudeController()&& @annotation(annotation)")
    public Object twiceAsOld(ProceedingJoinPoint thisJoinPoint, MyInfoAnnotation annotation) throws Throwable {


        String s = JSON.toJSONString(thisJoinPoint.getSignature());

        Object[] args = thisJoinPoint.getArgs();
        JSONArray paramKey = JSON.parseArray(JSON.parseObject(JSON.toJSONString(thisJoinPoint.getSignature())).getString("parameterNames"));
        JSONArray paramValue = JSON.parseArray(JSON.toJSONString(thisJoinPoint.getArgs()));


        System.out.println(JSON.toJSONString(paramKey));
        System.out.println(JSON.toJSONString(paramValue));


        Map<String,String> paramMap = new HashMap<>();
        Boolean isSign = false;
        String sign = "";

        for(int i=0;i<paramKey.size();i++){

            if(paramKey.get(i).equals("sign")){
                sign =paramValue.get(i).toString();
                isSign = true;
            }else {
                paramMap.put(paramKey.get(i).toString(), paramValue.get(i).toString());
            }

        }
        System.out.println(JSON.toJSONString(paramMap));

        String str = URLFormatUtil.formatUrlMap(paramMap, false, false);
        String signx = Md5.getMd5String(str.concat("&key=").concat("rl^>/f&^7#r@!+3#f@_*r*fxs6%<{^dCK!!"));//测通写到配置文件中




        if(isSign && signx.equals(sign)){

            //环绕通知必须执行，否则不进入注解的方法
            return thisJoinPoint.proceed();
        }else {

            for(int i=0;i<args.length;i++){
                if(args[i].toString().equals(sign)){
                    args[i] = "FALSE";
                }
            }
            System.out.println(JSON.toJSONString(args));
            return thisJoinPoint.proceed(args);
        }

    }
}



