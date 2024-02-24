package main;

import data.Users;
import dto.UserDto;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalStudyMain {

  public static void main(String[] args) {
    Users userData = new Users();

    // userDto의 리스트 가지고 오기
    List<UserDto> users = userData.getUserExample1InSampleList();

    // test10이 아이디인 user를 Optional로 가지고 온다

    Optional<UserDto> userDtoIdTest10 = users.stream().filter(userDto -> userDto.getId().equals("test10")).findAny();
//    try {
//      UserDto test10 = userDtoIdTest10.get();
//    } catch (NoSuchElementException e) {
//      e.printStackTrace();
//    }
    UserDto tempUserTest10 =UserDto.builder().id("test10").build();

    UserDto finalUserTest10 = userDtoIdTest10.isPresent() ? userDtoIdTest10.get()
        : tempUserTest10;

    System.out.println(finalUserTest10);

    UserDto finalUserTest10_2 = userDtoIdTest10.orElse(tempUserTest10);
    System.out.println(finalUserTest10_2);

    UserDto finalUserTest10_3 = userDtoIdTest10.orElseGet(() -> tempUserTest10);
    System.out.println(finalUserTest10_3);

//    try {
//      UserDto finalUserTest10_4 = userDtoIdTest10.orElseThrow(() -> new NullPointerException());
//    } catch (NoSuchElementException e) {
//      e.printStackTrace();
//    }

    // 아무것도 없다는 표시는 empty()로 하자
    Optional<UserDto> newUserDto = Optional.empty();

    // of의 경우 Null 값을 받지 않는다.
    newUserDto = Optional.of(tempUserTest10);

    // null 입력시 NullPointerException 발생함
//    newUserDto = Optional.of(null);

    // 이때는 Exception이 발생하지 않음
    newUserDto = Optional.ofNullable(null);

    // 막상 데이터를 Optional에서 꺼낼때 Exception이 발생한다
//    try {
//      newUserDto.get();
//    } catch (NoSuchElementException e) {
//      e.printStackTrace();
//    }
  }

}
