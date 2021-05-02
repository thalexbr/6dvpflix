package devops.fiap.userservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class TaskRequest {
	@NotNull
	@JsonProperty("user_id")
	private int idUser;

	@NotNull
	@JsonProperty("description")
	private String description;
	
	public TaskRequest() {
		
	}

	public TaskRequest(int idUser,String description) {
		super();

		this.idUser = idUser;
		this.description = description;
	}
	
	public int getIdUser() {
		return idUser;
	}

	public String getDescription() {
		return description;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser; 
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
