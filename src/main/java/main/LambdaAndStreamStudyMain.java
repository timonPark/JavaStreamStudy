package main;

import data.Users;
import dto.UserDto;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LambdaAndStreamStudyMain {
    public static void main(String[] args) {
        Users userData = new Users();

        // userDto의 리스트 가지고 오기
        List<UserDto> users = userData.getUserExample1InSampleList();
        System.out.println(users);

        // userDto의 ID 기준으로 정렬하기
        //Collections.sort(users, (u1, u2) -> u1.compareTo(u2)); 람다방식
        Collections.sort(users, UserDto::compareTo); // 메서드 참조
        System.out.println(users);

        // 역정렬
        Collections.reverse(users);
        System.out.println(users);

        // 아이디가 test2 단건 객체 찾기
        UserDto idTest2 =  users.stream()
            .filter(
                userDto -> userDto.getId().contains("test2")
            )
            .findAny() // .findFirst() 해도 됨
            .orElseThrow();
        System.out.println(idTest2);

        // stream의 reduce를 이용하여 아이디를 키값으로 하는 UserDtoMap 만들기
        Map<String, UserDto> userDtoMap = users.stream().reduce(new HashMap<String, UserDto>(),
            (map, userdto) -> {
                if(!map.containsKey(userdto.getId())) {
                    map.put(userdto.getId(), userdto);
                }
                System.out.println("currentThreadName: " +Thread.currentThread().getName());
                return map;
            },
            (m1, m2) -> m1
            );
        System.out.println(userDtoMap);

        // skip 횟수만큼 앞에서 날리기
        List<UserDto> users2 = users.stream().skip(1).toList();
        System.out.println(users2);

        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
            .reduce(10, (a, b) -> {
                return a + b;
            }, (c, d) -> {
                return c + d;
            }
            );
        System.out.println(reducedParallel);

        /**
         * 메소드 참조를 이용한 stream API
         */

        List<String> userEmails = users.stream().map(UserDto::getEmail).toList();
        System.out.println(userEmails);
        String userEmailUnion = users.stream().map(UserDto::getEmail).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(userEmailUnion);
        double userAverageAge = users.stream().collect(Collectors.averagingInt(UserDto::getAge));
        System.out.println(userAverageAge);

        // Collectors.sumarizing 사용, 숫자 분석 라이브러리

        IntSummaryStatistics userSummaryStatistics =users.stream().collect(Collectors.summarizingInt(UserDto::getAge));
        long userUnionAge = userSummaryStatistics.getSum();
        double userAverageAge2 = userSummaryStatistics.getAverage();
        System.out.println(userUnionAge);
        System.out.println(userAverageAge2);

        // Collectors를 이용한 Map 만들기
        Map<String, UserDto> userDtoMap2 = users.stream().collect(Collectors.toMap(UserDto::getId, UserDto::getThis));
        System.out.println(userDtoMap2);

        // Collectors를 이용한 Set 만들기
        Set<String> userEmailSet = users.stream().map(UserDto::getEmail).collect(Collectors.toSet());
        userEmailSet.stream().forEach(System.out::println);

    }
}
