package com.greedy.model.dto;

public class MemberDTO {
	
	private String type;
	private String firstName;
	private String lastName;
	private int age;
	
	public MemberDTO() {}

	public MemberDTO(String type, String firstName, String lastName, int age) {
		super();
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/* toString에서 반환하는 문자열을 json 포맷에 맞춰서 작성해둔다. */
	@Override
	public String toString() {
		return "{\"type\":\"" + type + "\"," + "\" firstName\":\""  + firstName + "\"," + "\"lastName\":\"" + lastName + "\"," + "\"age\":" + age + "}";
	}
	
	

}
