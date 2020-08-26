package com.icd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icd.annotation.SystemControllerLog;
import com.icd.dal.DemoMapper;
import com.icd.model.Result;
import com.icd.model.demo_User;
import com.icd.model.demo_UserInfo;
import com.icd.unti.JSONHelper;
import com.icd.unti.ResultUtil;

/**
 * @author 李耀华
 * @since 2020年7月8日 控制器实现示例
 */

//注解当前类为控制器
@Controller
public class HomeController {
	DemoMapper demomapper=new DemoMapper();
	
	
	// 注解请求方法，和请求地址进行绑定，请求地址为http://localhost:8080/项目名称/index
	@RequestMapping("/index")
	public ModelAndView index() {
		// 创建模型与视图类的实例，并通过构造函数初始化绑定的jsp页面
		ModelAndView mv = new ModelAndView("index");
		// 如需给页面绑定数据集
		// 可使用如下方法mv.addObject("catelist", catelist);
		return mv;
	}

	// 登录页面
	@RequestMapping("/login")
	// aop切面获取日志信息
	@SystemControllerLog(description = "访问登录页面")
	public ModelAndView login() {
		// 创建模型与视图类的实例，并通过构造函数初始化绑定的jsp页面
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	/**
	 * 不绑定页面，只是编写请求 无返回值，返回对象写void method设置POST或者GET
	 */
	@RequestMapping(value = "/requestGET", method = RequestMethod.GET)
	public void requestGET() {
		System.out.println("GET请求");
	}

	/**
	 * 不绑定页面的请求方法
	 * 接受前端vuecli框架axios请求方法
	 * 通过注解 @RequestBody，我们可以接收前端传过来的javabean对象，后端再对传递数据做序列号处理
	 * 有返回值，注意GET方法不能使用 注解@CrossOrigin为指定该方法允许跨站访问
	 * 用于接收复杂对象，可接收前端传过来的json数据等
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/requestPost", method = RequestMethod.POST)
	public String requestPost(@RequestBody demo_User user) {		
		String name=user.getUsername();
		System.out.println(user.getUsername());	
		return name;
	}
	
	/**
	 * 与上面类似，该方法接收参数vue前端传过来的javabean对象
	 * */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/requestPostObject", method = RequestMethod.POST)
	@SystemControllerLog(description = "请求测试方法")
	public demo_User requestPostObject(@RequestBody demo_User user) {
		//做判断		
		
		
		demo_User login_user=new demo_User();
		String username= user.getUsername();
		System.out.println(username);
		login_user.setUsername("daleilei");
		login_user.setRolename("admin");
		return login_user;
	}
	
	
	
	
	/**
	 * 与上面类似，该方法接收参数vue前端传过来的javabean对象
	 * 带返回值
	 * */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/validateUser", method = RequestMethod.POST)
	@SystemControllerLog(description = "请求测试方法")
	public Object validateUser(@RequestBody demo_User user) {
		String username= user.getUsername();
		System.out.println(username);
		//做判断		
		if(username=="admin") {
			demo_User login_user=new demo_User();			
			login_user.setUsername("daleilei");
			login_user.setRolename("admin");
			
			return ResultUtil.success(login_user, "请求成功");
		}else {
			return ResultUtil.error(403, null, "请求失败");
		}		
	}
	
	
	
	

	/**
	 * 不绑定页面的请求方法
	 * 不绑定页面，只是编写请求 有返回值，接收多个参数 例如用户信息及token
	 * 请求地址示例：http://localhost:8080/requestToken?token=admin
	 */
	@RequestMapping(value = "/requestToken", method = RequestMethod.POST)
	@ResponseBody
	public String requestToken(@RequestBody demo_UserInfo user, @RequestParam("token") String token) {
		return "";
	}

	/**
	 * Restful风格
	 * 使用SpringMVC绑定视图
	 */
	@RequestMapping("/details/{id}")
	public ModelAndView postJsonData(@PathVariable("id") int id) {
		// 创建模型与视图类的实例，并通过构造函数初始化绑定的jsp页面
		ModelAndView mv = new ModelAndView("login");
		// 如需给页面绑定数据集
		// 可使用如下方法mv.addObject("catelist", catelist);
		return mv;
	}
}
