package devops.fiap.userservice.entity;

import java.util.Date;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
// import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tbl_user_tasks")
@IdClass(UserTaskIdentity.class)
public class Task implements Serializable {
	@Id
	@JsonProperty("id")
	private int id;

	@Id
	@JsonProperty("user_id")
	private int userId;

	@JsonProperty("status")
	private String status;

	@JsonProperty("created_date")
	private Date createdDate;

	@JsonProperty("description")
	private String description;
	
	public Task() {
		
	}

	public Task(int userId, String description) {
		super();
		Date date = new Date();
		// UserTaskIdentity userTaskIdentity = new UserTaskIdentity();
		// userTaskIdentity.setUserId(userId);

		// this.userTaskIdentity = userTaskIdentity;
		this.userId = userId;
		this.description = description;
		this.createdDate = date; 
		this.status = "active";
	}

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	// public UserTaskIdentity getUserTaskIdentity() {
	// 	return userTaskIdentity;
	// }

	public String getStatus() {
		return status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	// public void setUserTaskIdentity(UserTaskIdentity userTaskIdentity) {
	// 	this.userTaskIdentity = userTaskIdentity;
	// }

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}


    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Task pk = (Task) o;
        return Objects.equals( id, pk.id ) &&
                Objects.equals( userId, pk.userId );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, userId );
    }
}
