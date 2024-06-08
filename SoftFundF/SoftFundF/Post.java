import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private int postID;
    private String postTitle;
    private String postBody;
    private String[] postTags;
    private String postType;
    private String postEmergency;
    private ArrayList<String> postComments = new ArrayList<>();
// post obj
    public Post(int postID, String postTitle, String postBody, String[] postTags, String postType, String postEmergency) {
        this.postID = postID;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postTags = postTags;
        this.postType = postType;
        this.postEmergency = postEmergency;
    }

    public boolean addPost() {
        try {
            // Check conditions
            if (postTitle == null || postBody == null || postTags == null || postEmergency == null || postType == null) {
                return false;
            }
    
            if (postTitle.length() < 10 || postTitle.length() > 250) {
                return false;
            }
    
            if (!postTitle.substring(0, 5).matches("^[a-zA-Z].*")) {
                return false;
            }
    
            if (postBody.length() < 250) {
                return false;
            }
    
            if (postTags.length < 2 || postTags.length > 5) {
                return false;
            }
    
            for (String tag : postTags) {
                if (tag == null || tag.length() < 2 || tag.length() > 10 || !tag.equals(tag.toLowerCase())) {
                    return false;
                }
            }
    
            if (postType.equals("Easy") && postTags.length > 3) {
                return false;
            }
    
            if ((postType.equals("Very Difficult") || postType.equals("Difficult")) && postBody.length() < 300) {
                return false;
            }
    
            if (postType.equals("Easy") && (postEmergency.equals("Immediately Needed") || postEmergency.equals("Highly Needed"))) {
                return false;
            }
    
            if ((postType.equals("Very Difficult") || postType.equals("Difficult")) && postEmergency.equals("Ordinary")) {
                return false;
            }
    
            // Save post information to file
            try (FileWriter filewrite = new FileWriter("post.txt", true)) {
                filewrite.write(this.toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    

    public boolean addComment(String comment) {
        // Check commnt conditions
        

        String[] words = comment.split("\\s+"); // split on one or more whitespace characters
        int wordCount = words.length;
        if (wordCount < 4 || wordCount > 10) {
            return false;
        }
        
        // Check if the first character of the comment is an uppercase letter
        if (!Character.isUpperCase(comment.charAt(0))) {
            return false;
        }
        
        if (postComments.size() >= 3 && (postType.equals("Easy") )) {
            return false;
        }
        if (postComments.size() >= 5) {
            return false;
        }
    
        // Save comment information to comment file
        try (FileWriter filewrite = new FileWriter("comment.txt", true)) {
            filewrite.write(comment + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        postComments.add(comment);
        return true;
    }
    

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", postTitle='" + postTitle + '\'' +
                ", postBody='" + postBody + '\'' +
                ", postTags=" + String.join(", ", postTags) +
                ", postType='" + postType + '\'' +
                ", postEmergency='" + postEmergency + '\'' +
                ", postComments=" + postComments +
                '}';
    }

    public List<String> getComments() {
           return postComments;
    }


}
