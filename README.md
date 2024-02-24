# JavaStreamStudy

## 2024/02/24
- 리스트 정렬
- 리스트 역정렬
- 리스트 필터로 필요한 객체만 분류후 단건만 추출
- reduce를 이용해서 Map객체 만들기
- reduce의 두 가지 쓰임방법
  - 하나의 결과를 모아 줄 때
  - 리스트에 있는 단건들을 하나의 결과로 만들 때
- stream과 parallelStream 차이
  -  stream은 순차적으로 처리
  -  parallelStream는 각 스레드들이 처리 후 하나로 합침
  -  데이터가 적을 수록 stream이 빠르고, 데이터가 일정수준이상으로 올라갔을 때 parallelStream이 빠르다
-  앞에 있는 데이터 날리는 방법: skip
-  메소드참조: (들어갈 타입::메소드 이름)
-  Collectors 메소드의 쓰임 분석, Map, Set 만들기
