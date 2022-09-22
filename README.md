# SWEA_java
SW Expert Academy Code Problem solved with java

---

이곳에는

 - 풀이한 문제 번호
 - 기억해둘 부분
 - 새로운 풀이방법

을 누적하여 적어두겠습니다.

문제번호 별 풀이방법은 각 난이도 별 디렉토리 안에 있는 README 를 참고해주세요.

---

출력시에 줄바꿈을 하고 싶지 않다면 `System.out.print();`를 이용한다.

배열 정렬 방법 : `Arrays.sort(arr);` 을 통해서 `arr` 배열을 오름차순 정렬할 수 있다.

특정 상황에서 신호를 변경하고 싶을 땐 `boolean flag = true`를 활용할 수 있다.

`String` 문자열에서 indexing을 하고 싶다면 `str.charAt(0)`를 이용한다.

`String` 문자열을 배열로 바꾸고 싶다면 `str.toCharArray()`를 이용한다.

새로운 메소드를 정의하여 사용할때는 `main`메소드 밖에 작성해야하고 인스턴스를 생성하지 않고 사용해야하기 때문에 `static`을 붙여줘야한다.

배열을 정렬할 때는 `Arrays.sort(arr);`을 사용한다.

`List`를 정렬하고 싶다면, `Collections.sort(list)`를 이용한다.

2차원 배열에서 특정영역에 접근하고 싶을 때 규칙을 찾아 `start`, `mid`, `end` 등의 변수를 이용한다.

상황에 따라 다르겠지만, 주어진 범위내에서의 조건을 부여해야하는 경우, 배열을 사용하는 것이 유리할 수 있다.

현재 상황을 저장하는 변수 `tmp`를 만들어 변화에 따라 변경해주면 용이하게 사용할 수 있다.

델타탐색
 - 행과 열의 인덱스를 1씩 변화시키는 `{1, -1, 0, 0}` 등의 배열을 만들어 방향을 지정하고 더해주는 횟수를 조절하여 탐색을 용이하게 할 수 있다.
 - 좌표에서 무조건적으로 델타이동을 이용하기 보다, 인덱스로 단순하게 접근이 가능한지 먼저 고민해본다. 

두개의 수 중 더 큰 값 혹은 더 작은 값을 알아내기 위해 `Math.max(a, b)`혹은 `Math.min(a, b)`를 사용할 수 있다.

String 문자열을 char[] 배열로 바꾸고 싶다면 `문자열.toCharArray()`메소드를 이용한다. > 이를 이용하여 문자열로 주어진 2차원 데이터를 손쉽게 2차원 배열로 바꿀 수 있다.

Stack클래스를 활용하여 괄호검사를 할 수 있다. `Stack<Character> stack = new Stack<>();`를 통해 스택을 선언.

후위표시식을 이용한 계산을 할 때에, 연산자 스택과 숫자 스택을 적절히 이용하자.

- 연산자들의 우선순위를 비교하기 위해 Map을 사용하여 비교하였다.

heap을 배열로 구현하는 경우, 부모 노드의 인덱스는 `index / 2`, 자식 노드의 인덱스는 `index * 2`와 `index * 2 + 1`이다.

순열, 조합, 부분집합을 사용하는 경우, N의 크기는 최대 30 정도로 생각하는 것이 좋다. 그 이상의 수는 시간초과가 나올 확률이 크다.

중복되는 것을 제외하고 그 수를 세고 싶다면 set을 이용하자!

for문을 통해 다시 원래 상태로 돌려 놓은 뒤 두 번째 재귀함수를 호출하지 않는 순열 조합과 달리 부분집합은 for문을 이용하지 않기 때문에 true일 때, false일 때, 모두 재귀함수를 호출해주어야 한다.

---

## D1
- 1936
- 2058
- 2063

## D2
 - 1204
 - 1926
 - 1940
 - 1945
 - 1946
 - 1948
 - 1954
 - 1959
 - 1961
 - 1970
 - 1974
 - 1979
 - 1984
 - 1989
 - 2001
 - 12712

## D3
 - 1206
 - 1208
 - 1209
 - 1213
 - 1215
 - 1216
 - 1220
 - 1228
 - 1230
 - 1289
 - 1860
 - 1873
 - 2805
 - 2806
 - 2817
 - 2930
 - 4789
 - 5215
 - 5789
 - 6190
 - 6485
 - 11315

## D4
 - 1210
 - 1222
 - 1223
 - 1224
 - 1231
 - 1486
 - 2819
 - 5432
 
## 모의 SW 역량 테스트
- 4012