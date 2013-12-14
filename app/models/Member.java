package models;

import java.util.UUID;

import javax.persistence.*;
import play.db.jpa.*;
import play.data.validation.*;
import play.data.format.*;

@Entity
public class Member {
	@Id
	String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Constraints.Required
	String email;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Constraints.Required
	String FirstName;
	
	@Constraints.Required
	String LastName;
	
	public Member(String email, String FirstName, String LastName)
	{
		this.id = UUID.randomUUID()+"";
		this.email = email;
		this.FirstName = FirstName;
		this.LastName = LastName;		
	}
	
	public Member()
	{
		this.id = UUID.randomUUID()+"";
	}
	
	/**
     * Insert this new member.
     */
    public void save() {
        JPA.em().persist(this);
    }
    
	
	/**
     * Delete this member.
     */
    public void delete() {
        JPA.em().remove(this);
    }
    
}
