import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PostCommentTest {

    private Post post;

    @BeforeEach
    public void setup() {
        String[] tags = {"java", "programming"};
        post = new Post(1, "Learning Java Programming",
                "Java is a versatile programming language that is widely used in various domains, from web development to Android app development. Java provides robust and secure applications. Its syntax is influenced by C++.",
                tags, "Easy", "Ordinary");
    }

    @Test
    public void ValidComment() {
        assertTrue(post.addComment("This is a good post."), "Valid comment should be added successfully.");
    }

    @Test
    public void ShortComment() {
        assertFalse(post.addComment("Too short"), "Comment with too few words should not be added.");
    }

    @Test
    public void BigComment() {
        assertFalse(post.addComment("This comment has too many words for the condition to be valid."), "Comment with too many words should not be added.");
    }

    @Test
    public void CapitalLettersBad() {
        assertFalse(post.addComment("this comment does not start with an uppercase letter."), "Comment not starting with an uppercase letter should not be added.");
    }

    @Test
    public void easyordinarytest() {
        assertTrue(post.addComment("First is comment valid."));
        assertTrue(post.addComment("Second is comment valid."));
        assertTrue(post.addComment("Third is comment valid."));
        assertFalse(post.addComment("Fourth is comment invalid."));
    }
    


    @Test
    public void commentLimit() {
        post = new Post(1, "Learning Java Programming",
                "Java is a versatile programming language that is widely used in various domains, from web development to Android app development. Java provides robust and secure applications. Its syntax is influenced by C++.",
                new String[]{"java", "programming"}, "Difficult", "Highly Needed");
        post.addComment("First is comment valid.");
        post.addComment("Second is comment valid.");
        post.addComment("Third is comment valid.");
        post.addComment("Fourth is comment valid.");
        post.addComment("Fifth is comment valid.");
        assertFalse(post.addComment("Sixth Comment is invalid"), "Exceeding comment limit for other post types should not be added.");
    }
}
