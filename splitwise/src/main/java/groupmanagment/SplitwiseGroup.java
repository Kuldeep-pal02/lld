package groupmanagment;

import expense.Expense;
import lombok.Data;
import usermanagement.model.SplitwiseUser;

import java.util.List;

@Data
public class SplitwiseGroup {

    private String groupId;         // Unique identifier for the group
    private String groupName;       // Name of the group
    private SplitwiseUser createdBy;         // User who created the group
    private List<SplitwiseUser> members;     // List of members in the group
    private List<Expense> expenses; // List of expenses in the group

    public void addMember(SplitwiseUser user) {
        members.add(user);
    }

    public void removeMember(SplitwiseUser user) {
        members.remove(user);
    }
}
