package clone.deep;


public class DeepTest {

	public static void main(String[] args) {
		School school = new School();
		school.setSchoolName("希望小学");
		Student student = new Student();
		student.setNumber("001");
		student.setName("张三");
		student.setGrade("一年级");
		student.setSex("男");
		school.setStudent(student);
		School clone = school.clone();
		student.setGrade("二年级");
		school.setSchoolName("实验中学");
		System.out.printf("schoolName:%s,grade:%s", clone.getSchoolName(),clone.getStudent().getGrade());
	}

}
