package clone.deep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class School implements Cloneable,Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4936999173504294445L;

	private String schoolName;
	
	private Student student;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	//result same as deepClone @see#Student implements java.lang.Cloneable
	@Override
	public School clone() {
		try {
			School school = (School)super.clone();
			school.setStudent(school.getStudent().clone());
			return school;
		} catch (Exception e) {
			//Ignore Exception
		}
		return this;
	}
	
	
	//usage try-with-resource syntax sugar from jdk7+ required implements java.lang.AutoCloseable 
	public School deepJDK7Clone(){
		try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				ObjectOutputStream out = new ObjectOutputStream(outputStream);
				) {
			out.writeObject(this);
			out.flush();
			try (ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
				 ObjectInputStream in = new ObjectInputStream(inputStream);){
				return (School)in.readObject();
			} catch (Exception e) {
				//Ignore Exception
			}
		} catch (Exception e) {
			//Ignore exception
		}
		return this;
	}
	
	public School deepClone(){
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		try {
			out = new ObjectOutputStream(outputStream);
			out.writeObject(this);
			out.flush();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
			in = new ObjectInputStream(inputStream);
			return (School)in.readObject();
		} catch (Exception e) {
			//Ignore exception
		}finally{
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					
				}
			}
			
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					
				}
			}
			
		}
		return this;
	}
	
}
