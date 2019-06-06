package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entiy.Region;
import com.example.demo.entiy.Tree;
import com.example.demo.entiy.User;
import com.example.demo.service.RedisService;
import com.example.demo.service.RegionService;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class DemoApplicationTests {


	@Autowired
	private UserService userService;

	@Autowired
	private RegionService regionService;

	@Autowired
	private RedisService redisService;

	@Test
	public void contextLoads() {
		User user = null;
	}
	@Test
	public void testRedis(){
		User user = new User();
		user.setId(4);
		user.setUserName("zhangsan");

		Boolean result = redisService.setWithTime("user1",user,60L);
		System.out.println(result);

		Object o = redisService.get("user1");
		System.out.println(((User) o).getUserName());
	}

	@Test
	public void testRegion(){

		List<Region> list = regionService.listRegion();

		List<Tree> listT = convertTree(list);

		Tree menu = null;

		for(Tree r : listT){

			if(r.getPid() !=-1){
				//找到父类 并添加到父类里
				Tree t = getByPid(r,listT);
				if(t.getChildren() == null){
					t.setChildren(new ArrayList<>());
				}
					t.getChildren().add(r);
			}else {
				menu = r;
			}
		}

		System.out.println(JSON.toJSONString(menu));


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
			treeList.add(tree);
		}
		return  treeList;

	}
}
