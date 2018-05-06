package com.zszd.ai.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zszd.ai.tools.SpellHelper;

/**
 * 员工
 * @author lizx 20180103
 *
 */
public class Employee {

	private int id;
	private String name;
	private int roleId;
	private String roleName;
	private int workpoints;
	private String abbr;
	private String namePinyin;
	private String workType;
	private String workUnit;
	private String workState;
	private String major;
	private String endSchool;
	private String education;
	private String endTime;
	private String postalcode;
	private String phone;
	private String address;
	private String intentionalCity;
	private String intentionalPost;
	private String email;
	private String sex;
	private String validDocuments;
	private int classId;
	private String className;
	private String classLeader;
	private String classTeacher;
	private int companyId;
	private String companyName;
	private int departmentId;
	private String departmentName;
	private int devgroupId;
	private String devgroupName;
	private Date birthday;
	private int age;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWorkpoints() {
		return workpoints;
	}
	public void setWorkpoints(int workpoints) {
		this.workpoints = workpoints;
	}
	
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getWorkUnit() {
		return workUnit;
	}
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	public String getWorkState() {
		return workState;
	}
	public void setWorkState(String workState) {
		this.workState = workState;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getEndSchool() {
		return endSchool;
	}
	public void setEndSchool(String endSchool) {
		this.endSchool = endSchool;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIntentionalCity() {
		return intentionalCity;
	}
	public void setIntentionalCity(String intentionalCity) {
		this.intentionalCity = intentionalCity;
	}
	public String getIntentionalPost() {
		return intentionalPost;
	}
	public void setIntentionalPost(String intentionalPost) {
		this.intentionalPost = intentionalPost;
	}
	public String getNamePinyin() throws Exception {
		return SpellHelper.getUpEname(name);
	}
	public void setNamePinyin(String namePinyin) {
		this.namePinyin = namePinyin;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getValidDocuments() {
		return validDocuments;
	}
	public void setValidDocuments(String validDocuments) {
		this.validDocuments = validDocuments;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getDevgroupId() {
		return devgroupId;
	}
	public void setDevgroupId(int devgroupId) {
		this.devgroupId = devgroupId;
	}
	public String getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDevgroupName() {
		return devgroupName;
	}
	public void setDevgroupName(String devgroupName) {
		this.devgroupName = devgroupName;
	}

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getClassLeader() {
		return classLeader;
	}
	public void setClassLeader(String classLeader) {
		this.classLeader = classLeader;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getBirthday() {
		if(birthday !=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			return sdf.format(birthday);
		}
		return null;	
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		if(birthday != null){
			Date date = new Date();
			int age = date.getYear()-birthday.getYear();
			return age;
		}
		return 0;
	}
	public void setAge(int age) {
		this.age = age;
	}

		
}
