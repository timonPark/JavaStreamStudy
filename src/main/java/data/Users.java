package data;

import dto.UserDto;
import java.util.ArrayList;
import java.util.List;

public class Users {

    public List<UserDto> getUserExample1InSampleList(){
        return new UsersExample1().sampleUsers;
    }

    private class UsersExample1 {
        final public List<UserDto> sampleUsers  = new ArrayList<>();
        public UsersExample1(){
            sampleUsers.add(
                UserDto.builder()
                    .id("test1")
                    .name("tester1")
                    .email("test1@naver.com")
                    .age(24)
                    .build()
            );
            this.sampleUsers.add(
                UserDto.builder()
                    .id("test2")
                    .name("tester2")
                    .email("test2@daum.net")
                    .age(34)
                    .build()
            );
            this.sampleUsers.add(
                UserDto.builder()
                    .id("test3")
                    .name("tester3")
                    .email("test3@google.com")
                    .age(31)
                    .build()
            );
            this.sampleUsers.add(
                UserDto.builder()
                    .id("aTest1")
                    .name("aTester1")
                    .email("aTest1@naver.com")
                    .age(29)
                    .build()
            );
        }
    }

}
