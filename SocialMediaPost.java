import java.util.ArrayList;
import java.util.List;

public class SocialMediaPost {
    private String content;
    private String author;
    private List<String> likes;
    private List<String> comments;

    public SocialMediaPost(String content, String author) {
        this.content = content;
        this.author = author;
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void likePost(String user) {
        if (!likes.contains(user)) {
            likes.add(user);
            System.out.println(user + " liked the post.");
        } else {
            System.out.println(user + " already liked this post.");
        }
    }

    public void addComment(String user, String comment) {
        comments.add(user + ": " + comment);
        System.out.println(user + " commented: " + comment);
    }

    public void displayPost() {
        System.out.println("Post by " + author + ": " + content);
        System.out.println("Likes: " + likes.size());
        System.out.println("Comments: ");
        for (String comment : comments) {
            System.out.println("- " + comment);
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public static void main(String[] args) {
        SocialMediaPost post = new SocialMediaPost("Hello, world!", "Alice");
        post.displayPost();

        post.likePost("Bob");
        post.likePost("Charlie");
        post.addComment("Bob", "Nice post!");
        post.addComment("Charlie", "Agreed!");

        post.displayPost();
    }
}
