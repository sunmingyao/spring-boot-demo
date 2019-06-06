package com.example.demo.controller.Api;

import com.alibaba.fastjson.JSON;
import com.example.demo.entiy.Region;
import com.example.demo.entiy.Tree;
import com.example.demo.service.RegionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: sunmingyao
 * @Date: 2018/10/16 12 44
 * @Description:
 */
@RestController
@RequestMapping("/regionApi")
public class RegionApiController {

    @Autowired
    private RegionService regionService;

    @RequestMapping("/listRegion")
    public String listRegion(){

        List<Region> regionList = regionService.listRegion();

        return JSON.toJSONString(regionList);

    }


    /**
     * <禁用大区>
     * @Author SunMingyao
     * @Date 2018/10/19 13:02
     * @Company PengHai
     * @Param []
     * @Return void
     * @See [相关类/方法]
     * @Since [产品/模块版本]
     */
    @RequestMapping("/unActiveRegion")
    public void unActiveRegion(@Param(value = "regionCode") String regionCode,
                               @Param(value = "regionName") String regionName,
                               @Param(value = "open")String open){



        if(open == null  || (open !=null && !open.equals("on"))){

            //如果有开关设置为禁用 那么直接禁用
            List<Region> regionList = getCurrentRegionAndChild(regionCode);
            for(Region region : regionList){
                region.setIsActived("N");
                regionService.updateRegion(region);
            }

        }else {

            //没有开关设置 那么根据大区编号修改大区名称 并设置选中大区为启用
            Region region = regionService.getRegion(regionCode);

            region.setIsActived("Y");
            region.setRegionName(regionName);

            regionService.updateRegion(region);

            //判断父级大区 设置为启用
            regionService.updateParentRegionActive(region.getParentId());
        }


    }

    /**
     * <根据大区编码获取其本身和所有附属大区>
     * @Author SunMingyao
     * @Date 2018/10/19 16:31
     * @Company PengHai
     * @Param [region]
     * @Return java.util.List<com.example.demo.entiy.Region>
     * @See [相关类/方法]
     * @Since [产品/模块版本]
     */
    public List<Region> getCurrentRegionAndChild(String regionCode){
        List<Region> list = regionService.listRegion();
        Region currentRegion = null;

        //获取当前的Region
        for(Region region : list){
            if(region.getRegionItem() == null){
                region.setRegionItem(new ArrayList<Region>());
            }
            if (region.getRegionCode().equals(regionCode)) {
                currentRegion = region;
            }

            if(true){
                for(Region j : list){
                    if(j.getParentId().intValue() == region.getId()){
                        region.getRegionItem().add(j);
                    }
                }
            }

        }

        List<Region> r = new ArrayList<>();
        r.add(currentRegion);

        Boolean flag ;

        do{
            flag = true;
            for(int i=0;i<r.size();i++){
                if(r.get(i).getRegionItem() != null){
                    r.addAll(r.get(i).getRegionItem());
                    r.get(i).setRegionItem(null);
                    flag =false;
                }
            }

        }while (flag == true);

        return r;

    }


    /**
     * <获取大区树状结构字符串>
     * @Author SunMingyao
     * @Date 2018/10/19 12:57
     * @Company PengHai
     * @Param []
     * @Return java.lang.String
     * @See [相关类/方法]
     * @Since [产品/模块版本]
     */
    @RequestMapping("/getRegionTreeNodesStr")
    public String getRegionTreeNodesStr(){

        List<Object> result = new ArrayList<>();
        List<Region> list = regionService.listRegion();

        List<Tree> listT = convertTree(list);

        Tree menu = null;

        for(Tree r : listT){

            if(r.getPid() !=-1){
                //找到父类 并添加到父类里
                Tree t = getByPid(r,listT);
                if(t.getChildren() == null){
                    t.setChildren(new ArrayList<Tree>());
                }
                t.getChildren().add(r);
            }else {
                menu = r;
                result.add(menu);
            }
        }

        return JSON.toJSONString(result);
    }
    public Tree getByPid(Tree tree, List<Tree> list){

        for(Tree t : list){
            if(t.getId().toString().equals(tree.getPid()+"")){

                return t;
            }
        }

        return null;
    }
    public List<Tree> convertTree(List<Region> regions){

        List<Tree> treeList = new ArrayList<>();
        for(Region region : regions){


            Tree tree = new Tree();
            tree.setId(region.getId().intValue());
            tree.setName(region.getRegionName());
            tree.setPid(region.getParentId());
            tree.setSpread(true);
            tree.setCode(region.getRegionCode());
            tree.setFlag(region.getIsActived());
            treeList.add(tree);
        }
        return  treeList;

    }
}
