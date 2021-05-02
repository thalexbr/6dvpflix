package devops.fiap.movieservice.entity;

public class Message {
    public int movieId;
    public int userId;
    public int like;
    public boolean view; 
    
    public Message(int movieId,
    int userId,
    int like,
    boolean view) {
        this.movieId = movieId;
        this.userId = userId;
        this.like = like;
        this.view = view;
    }

    // Getter
    public int getMovieId(){
        return movieId;
    }
    public int getUserId(){
        return userId;
    }
    public int getLike(){
        return like;
    }
    public boolean getView(){
        return view;
    }

    // Setter
    public void setMovieId(int movieId){
        this.movieId = movieId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public void setLike(int like){
        this.like = like;
    }
    public void setView(boolean view){
        this.view = view;
    }
}