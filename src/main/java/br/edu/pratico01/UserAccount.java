package br.edu.pratico01;

public class UserAccount {
    public static final int MAX_TIMELINE_POSTS = 10;
    public static final int MAX_SIZE_FAKE = 20;

    private String email;
    private String userName;

    private UserAccount[] followers = new UserAccount[MAX_SIZE_FAKE];
    private Post[] timeline = new Post[MAX_TIMELINE_POSTS];
    private Post[] posts = new Post[MAX_SIZE_FAKE];
    
    private int numberOfPosts;
    private int numberOfPostsInTimeline;
    private int numberOfFollowers;

    public UserAccount(String email, String userName) {
        this.email = email;
        this.userName = userName;
    }

    public void publish(String quote){
        Post post = new Post(quote, this);
        posts[numberOfPosts++] = post;

        for (int i = 0; i < numberOfFollowers; i++)
            followers[i].updateTimeline(post);

    }

    public void updateTimeline(Post post){
        timeline[numberOfPostsInTimeline % MAX_TIMELINE_POSTS] = post;
        numberOfPostsInTimeline++;
    }

    public boolean delete(int postIndex){
        if(postIndex < 0 || postIndex >= numberOfPosts)
            return false;

        for (int i = postIndex; i < numberOfPosts - 1; i++)
             posts[i] = posts[i+1];

        numberOfPosts--;
        return true;
    }

    public void booPost(int postIndex){
        if(isInvalidTimelineIndex(postIndex))
            return;
        timeline[postIndex].boo();
    }

    public void clapPost(int postIndex){
        if(isInvalidTimelineIndex(postIndex))
            return;
        timeline[postIndex].clap();
    }

    private boolean isInvalidTimelineIndex(int postIndex) {
        return postIndex < 0 ||
                numberOfPostsInTimeline >= 10 ||
                numberOfPostsInTimeline < 10 && postIndex >= numberOfPostsInTimeline;
    }

    public void acceptFollower(UserAccount user){
        for (int i = 0; i < numberOfFollowers; i++) {
            if(followers[i].getEmail() == user.getEmail())
                return;
        }
        followers[numberOfFollowers++] = user;
    }

    public void blockFollower(UserAccount user){
        if(user == null)
            return;
        for (int i = 0; i < numberOfFollowers; i++) {
             if(user.getEmail() == followers[i].getEmail()){
                 removeUserByIndex(i);
                 break;
             }
        }
    }

    private void removeUserByIndex(int i) {
        for (int j = i; j < numberOfFollowers - 1; j++) {
            followers[j] = followers[j - 1];
        }
        numberOfFollowers--;
    }

    public String getMyPostsInfo(){
        String result = "";
        for (int i = 0; i < numberOfPosts; i++)
            result += posts[i].getPostInfo() + "\n";
        return result;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTimelineInfo(){
        String result = "";
        for (int i = 0; i < Math.min(numberOfPostsInTimeline, 10); i++)
            result += timeline[i].getPostInfo() + "\n";
        return result;
    }

    public String getFollowersInfo(){
        String result = "";
        for (int i = 0; i < numberOfPosts; i++)
            result += buildFollowerInfo(followers[i]);
        return result;
    }

    private String buildFollowerInfo(UserAccount follower) {
        return "Name: " + follower.userName +
                " | e-mail " + follower.email +
                " | Seguidores: " + follower.numberOfFollowers + "\n";
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }
}
