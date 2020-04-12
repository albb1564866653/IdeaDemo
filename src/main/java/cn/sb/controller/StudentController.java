package cn.sb.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


import cn.sb.entity.Student;
import cn.sb.service.impl.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;


	@RequestMapping("/list")
	public String list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Map<String,Object> map, HttpServletRequest request) {
		//引入PageHelper分页插件
		//在查询之前只需要调用，传入 页码、每页的大小
		PageHelper.startPage(pageNum, 5);
		//startPage后面紧跟的这个查询就是一个分页查询
		List<Student> students = studentService.selectStudentS();
		//使用pageinfo包装查询后的结果，只需要将pageInfo交给页面就行了
		//封装了详细的分页信息，包括有我们查询出来的 数据、传入连续显示的页数
		PageInfo<Student> page = new PageInfo<>(students,3);
		map.put("students",students);
		map.put("page",page);

		DateFormat df=new SimpleDateFormat("HH");
		Date date=new Date();
		String format = df.format(date);
		System.out.println(format);
		map.put("currentTime",format);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "list";
	}



}
