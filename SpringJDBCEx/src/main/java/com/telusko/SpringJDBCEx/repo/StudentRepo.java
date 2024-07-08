package com.telusko.SpringJDBCEx.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.telusko.SpringJDBCEx.model.Student;

@Repository
public class StudentRepo {
	
	private JdbcTemplate jdbc;
	
	

	public JdbcTemplate getJdbc() {
		return jdbc;
	}
	
	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void save(Student s) {
		// TODO Auto-generated method stub
		
		String sql="insert into student(rollno,name,marks) values(?,?,?)";
		int rows=jdbc.update(sql,s.getRollno(),s.getName(),s.getMarks());
		System.out.println("Rows affected: "+rows);
	}

	public List<Student> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from student";
		
		//Anonymous class usage
		/*RowMapper<Student> mapper = new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Student s = new Student();
				s.setRollno(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setMarks(rs.getInt("marks"));
				return s; //we are taking the data from rs, adding it to the Student object s and returning it
			}
		};
		*/
		
		//Using Lambda Expression:
		RowMapper<Student> mapper = ( rs, rowNum) -> {
				// TODO Auto-generated method stub
				
				Student s = new Student();
				s.setRollno(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setMarks(rs.getInt("marks"));
				return s; //we are taking the data from rs, adding it to the Student object s and returning it

		};
		
		return jdbc.query(sql, mapper);
	}

	
}
