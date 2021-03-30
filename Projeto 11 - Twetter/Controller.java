import java.util.Map;
import java.util.TreeMap;

public class Controller {
    private Map<String, User> users;
    private Map<Integer, Tweet> tweets;

    public void sendTweet(String username, String msg) throws Exception {
        if (!users.containsKey(username))
            throw new Exception("Este user não esta aqui brow");

        Tweet tweet = new Tweet(username, msg);
        this.users.get(username).sendTweet(tweet);
        this.tweets.put(tweet.getIdTw(), tweet);
    }

    public void addUser(String username) throws Exception {
        if (users.containsKey(username))
            throw new Exception("Este usuario já existe aqui");

        User user = new User(username);
        this.users.put(username, user);
    }

    public User getUser(String username) throws Exception {
        if (!this.users.containsKey(username))
            throw new Exception(" Não existe esse cara man");

        return this.users.get(username);
    }

    public void follow(String follower, String following) throws Exception {
        if (!users.containsKey(follower) || !users.containsKey(following))
            throw new Exception("O seguindo ou o seguidor nao contem aqui");

        User seguidor = users.get(follower);
        User seguindo = users.get(following);

        seguidor.follow(seguindo);
    }

    public void unfollow(String follower, String following) throws Exception {
        if (!users.containsKey(follower) || !users.containsKey(following))
            throw new Exception("Algum desses caras não existe");

        User seguidor = users.get(follower);
        User seguindo = users.get(following);

        seguidor.unfollow(seguindo.getUsername());
    }

    public void like(String username, int idTw) throws Exception {
        if (!users.containsKey(username))
            throw new Exception("Este cara não está aqui mann");

        if (!tweets.containsKey(idTw))
            throw new Exception("Este tweet não está aqui mann");

        if (!users.get(username).getTimeline().containsKey(idTw))
            throw new Exception("Esta timeline não está aqui man");

        Tweet tweet = tweets.get(idTw);
        tweet.like(username);
    }

    public String unread(String username) throws Exception {
        if (!users.containsKey(username))
            throw new Exception("Este cara não esta aqui de novo");

        return users.get(username).getUnread();
    }

    public String timeLine(String username) throws Exception {
        if (!users.containsKey(username)) {
            throw new Exception("O cara não ta man");
        }

        return users.get(username).getTimelineFull();
    }

    public Controller() {
        this.tweets = new TreeMap<>();
        this.users = new TreeMap<>();
    }

}
