package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto implements Comparable{
    private String id;
    private String name;
    private String email;
    private int age;

    @Override
    public int compareTo(Object o) {
        if (o instanceof UserDto nextUser) {
            return this.id.compareTo(nextUser.getId());
        }
        return 0;
    }

    public UserDto getThis(){
        return this;
    }
}
