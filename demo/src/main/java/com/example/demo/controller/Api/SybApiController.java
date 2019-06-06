package com.example.demo.controller.Api;

import com.alibaba.fastjson.JSON;
import com.example.demo.entiy.Syb;
import com.example.demo.entiy.SybType;
import com.example.demo.entiy.User;
import com.example.demo.service.SybService;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: sunmingyao
 * @Date: 2018/12/12 15 02
 * @Description:
 */
@RestController
@RequestMapping("/sybApi")
public class SybApiController {

    @Autowired
    private SybService sybService;

    @Autowired
    private UserService userService;

    @RequestMapping("/listSyb")
    public String listSyb(@RequestParam(value="page") Integer page, @RequestParam(value="limit") Integer limit, @RequestParam(value = "name",required = false) String name,@RequestParam(value = "sybTypeCode",required = false) String sybTypeCode){

        Integer sybCode = null;

        if(StringUtils.isNotBlank(sybTypeCode)){
            sybCode = Integer.parseInt(sybTypeCode);
        }

        PageHelper.startPage(page,limit);
        List<Syb> sybList = sybService.listSyb(name,sybCode);
        Map<String, Object> sybMap = new HashMap<>();
        PageInfo pages=new PageInfo(sybList,8);
        sybMap.put("code",0);
        sybMap.put("data", pages.getList());
        sybMap.put("msg","");
        sybMap.put("count",pages.getTotal());
        return JSON.toJSONString(sybMap);

    }

    @RequestMapping("/addSyb")
    public String addSyb(HttpServletRequest request, @RequestParam(value = "code") String code, @RequestParam(value = "name") String name,@RequestParam(value="sybTypeCode") String sybTypeCode){
        User currentUser = userService.getCurrentUser(request);

        Syb syb = new Syb();
        syb.setCode(code);
        syb.setName(name);
        syb.setSybTypeCode(sybTypeCode);
        syb.setDeleteFlag(0);
        syb.setOperateTime(new Date());
        syb.setOperateUser(currentUser.getUserName());
        Map<String, Object> result = new HashMap<>();

        try {
            sybService.addSyb(syb);
        }catch (Exception e){
            result.put("code","02");
            result.put("message","插入失败！");
            return JSON.toJSONString(result);

        }

        result.put("code","01");
        result.put("message","插入成功！");

        return JSON.toJSONString(result);

    }

    @RequestMapping("/deleteSyb")
    public String deleteSyb(@RequestParam(value="id") String id){
        Map<String, Object> result = new HashMap<>();

        //删除做校验
        String[] ids = id.split("-");

        for(int i=1;i<ids.length;i++){
            Syb currentSyb = sybService.getById(Integer.parseInt(ids[i]));

            if(currentSyb != null){
                sybService.deleteSyb(currentSyb.getId());
            }
        }


        result.put("code", "01");
        result.put("message", "删除成功");

        return JSON.toJSONString(result);
    }

    @RequestMapping("/getSybForSelect")
    public String getSybForSelect(){

        List<Syb> list = sybService.getSybForSelect();
        return JSON.toJSONString(list);
    }
}
