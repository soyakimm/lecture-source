package com.greedy.model.dto;

public class MemberDTO {
	
	private String code;
	private String firstName;
	private String lastName;
	private int age;
	
	public MemberDTO() {}

	public MemberDTO(String code, String firstName, String lastName, int age) {
		super();
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
		return "{\"code\":\"" + code + "\"," + "\" firstName\":\""  + firstName + "\"," + "\"lastName\":\"" + lastName + "\"," + "\"age\":" + age + "}";
	}
	
	

}
