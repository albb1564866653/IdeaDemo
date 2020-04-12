package cn.sb.dao;


import cn.sb.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentDao {


	/**
	 * select * from student
	 * @return List<Student>
	 */
	List<Student>  selectStudentS();
}
