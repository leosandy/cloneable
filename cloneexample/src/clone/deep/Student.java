package clone.deep;

import java.io.Serializable;

public class Student implements Serializable,Cloneable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5292309574369573372L;

	private String number;
	
	private String name;
	
	private String sex;
	
	private String grade;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	protected Student clone() {
		try {
			return (Student)super.clone();
		} catch (Exception e) {
			//Ignore Exception
		}
		return this;
	}
	
	
}
