package ethereum.models.sql.crowdfunding;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private String projectAddress;
    private String creatorAddress;
    private String title;
    private String description;
    private String imageUrl;
    private Integer goal;
    private Timestamp deadline;
    private boolean completed;
    private boolean expired;
    private String acceptingToken;
    private String tokenName;
    private String tokenSymbol;
    private Timestamp createdDate;
}
