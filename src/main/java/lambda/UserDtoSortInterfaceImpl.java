package lambda;

import dto.UserDto;
import interfaces.UserDtoSortInterface;

public class UserDtoSortInterfaceImpl {
  public static UserDtoSortInterface getUserDtoSort(){
    return (UserDto u1, UserDto u2) ->
            getUserDtoSortProcess(u1, u2);
  }

  public static UserDto getUserDtoSortProcess(UserDto u1, UserDto u2) {
    if (u1.getId().compareTo(u2.getId()) == 1) {
      return u1;
    }
    if (u1.getId().compareTo(u2.getId()) == -1) {
      return u2;
    }
    return u1;
  }

}
