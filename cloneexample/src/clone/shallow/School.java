package clone.shallow;


public class School implements Cloneable {

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

	@Override
	public School clone() {
		try {
			School school = (School)super.clone();
			return school;
		} catch (Exception e) {
			//ignore Exception
		}
		return this;
	}
}
