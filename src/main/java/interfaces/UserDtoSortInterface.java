package interfaces;

import dto.UserDto;

public interface UserDtoSortInterface {
  public UserDto compare(UserDto u1, UserDto u2);
}
