package dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class UserInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name; 
	long phone;
	String email; 
	String password; 
	Date date; 
	String gender;
	String address; 
	String country; 
	String[] skills;
	int age;
 
}
