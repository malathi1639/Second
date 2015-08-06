package dao;

public class Bean {

	private String name;
	private int id;
	private int age;
	private String address;
	private String mailid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
    
	@Override
	public String toString() {
		return "Bean [name=" + name + ", id=" + id + ", age=" + age
				+ ", address=" + address + ", mailid=" + mailid + "]";
	}
}

