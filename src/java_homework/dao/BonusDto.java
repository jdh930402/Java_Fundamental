package java_homework.dao;

public class BonusDto {
	String name;
	String job;
	int sal;
	int comm;

	public BonusDto(String name, String job, int sal, int comm) {
		super();
		this.name = name;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}
}
