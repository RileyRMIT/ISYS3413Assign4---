import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PostTest {

    private Post validPost;
    private Post invalidPost;

    @BeforeEach
    public void setup() {
        // Setup pre-defines the Valid Post and invalid Post variables 
        String[] validTags = {"java", "program"};
        validPost = new Post(1, "Learning Java Programming",
                "Java is a versatile programming language that is widely used in various domains, from web development to Android app development. Java provides robust and secure applications. Its syntax is influenced by C++.testcharactertestcharactertestcharactertestcharactertestcharacter",
                validTags, "Easy", "Ordinary");

       
        String[] invalidTags = {"java", "program"};
        invalidPost = new Post(2, "Short", "Java is a versatile programming language...",
                invalidTags, "Easy", "Ordinary");
    }

    @Test
    public void testAddPost_TitleLength() {
        // Valid post
        assertTrue(validPost.addPost(), "Valid post should be added successfully.");

        // Invalid post with short title
        invalidPost = new Post(2, "Short", "Java is a versatile programming language...",
                new String[]{"java", "program"}, "Easy", "Ordinary");
        assertFalse(invalidPost.addPost(), "Post with invalid title length should not be added.");
    }

    @Test
    public void testAddPost_TitleChars() {
        // Valid post
        assertTrue(validPost.addPost(), "Valid post should be added successfully.");

        // Invalid post with title starting with numbers / invalid characters
        invalidPost = new Post(2, "12345Java Programming", "Java is a versatile programming language...",
                new String[]{"java", "program"}, "Easy", "Ordinary");
        assertFalse(invalidPost.addPost(), "Post with title starting with invalid characters should not be added.");
    }

    @Test
    public void testAddPost_BodyLength() {
        // Valid post
        assertTrue(validPost.addPost(), "Valid post should be added successfully.");

        // Invalid post with short body text
        invalidPost = new Post(2, "Learning Java Programming", "Short body.",
                new String[]{"java", "program"}, "Easy", "Ordinary");
        assertFalse(invalidPost.addPost(), "Post with invalid body length should not be added.");
    }

    @Test
    public void testAddPost_ValidAndInvalidTags() {
        // Valid post
        assertTrue(validPost.addPost(), "Valid post should be added successfully.");

        // Invalid post with invalid tags
        invalidPost = new Post(2, "Learning Java Programming", "Java is a versatile programming language...",
                new String[]{"J", "programming"}, "Easy", "Ordinary");
        assertFalse(invalidPost.addPost(), "Post with invalid tags should not be added.");
    }

    @Test
    public void testAddPost_TypeandEmergency() {
        // Valid post
        assertTrue(validPost.addPost(), "Valid post should be added successfully.");

        // Invalid post with invalid type or emergency level
        invalidPost = new Post(2, "Learning Java Programming", "Java is a versatile programming language...",
                new String[]{"java", "program"}, "Moderate", "Ordinary");
        assertFalse(invalidPost.addPost(), "Post with invalid type or emergency level should not be added.");
    }
}
