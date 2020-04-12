package cn.sb.service.impl;



import cn.sb.entity.Student;
import cn.sb.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;

	@Override
	public List<Student> selectStudentS() {
		List<Student> students = studentDao.selectStudentS();
		return students;
	}
}
