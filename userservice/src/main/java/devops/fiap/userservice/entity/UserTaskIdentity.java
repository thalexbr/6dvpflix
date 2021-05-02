package devops.fiap.userservice.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class UserTaskIdentity implements Serializable {
    @Column(name = "id")
    @JsonProperty("id")
    private int id;

    @Column(name = "user_id")
    @JsonProperty("user_id")
    private int userId;

    public UserTaskIdentity() {

    }

    public UserTaskIdentity(int id, int userId ) {
        this.id = id;
        this.userId = userId;
    }


    public int getUserId() {
		return userId;
	}

    public int getId() {
		return id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

    public void setId(int id) {
		this.id = id;
	}

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        UserTaskIdentity pk = (UserTaskIdentity) o;
        return Objects.equals( id, pk.id ) &&
                Objects.equals( userId, pk.userId );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, userId );
    }
}
