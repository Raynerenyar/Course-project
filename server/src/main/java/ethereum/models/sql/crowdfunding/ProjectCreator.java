package ethereum.models.sql.crowdfunding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectCreator {
    private String creatorAddress;
    private String name;
}
