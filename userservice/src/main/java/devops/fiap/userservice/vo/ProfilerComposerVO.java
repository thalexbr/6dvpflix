package devops.fiap.userservice.vo;

import java.util.List;


public class ProfilerComposerVO {
	
	

	public ProfilerComposerVO(String userName, List<UserMoviesVO> userMoviesVO) {
		super();
		this.userName = userName;
		this.userMoviesVO = userMoviesVO;
	}

	private String userName;
	
	private List<UserMoviesVO> userMoviesVO;

	public List<UserMoviesVO> getUserMovies() {
		return this.userMoviesVO;
	}

	public void setUserMoviesVO(List<UserMoviesVO> userMoviesVO) {
		this.userMoviesVO = userMoviesVO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	
	
}
