package al9rithm.week1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *  기호마다 우선순위를 두어 문제를 해결
 *  연산기호에는 각각 우선순위가 존재한다 ex -> + , - < * , / < ()
 *
 *  중위 표기식을 후위표기식으로 옮길 때 총 3가지 상황이 발생할 수 있다
 *  현재 연산자 보다 앞의 연산자가 연산 우선순위가 높을 시 다음과 같이 표현되는 것을 확인할 수 있다
 *   ex) A*B+C  -> AB*C+  || 즉 + 를 탐색할 때 그앞의 연산자 * 가 자신보다 우선순위가 높다면 현재 문자열 뒤에 위치하게 된다
 *
 *   만약 현재 연산자가 앞의 연산자보다 우선순위가 높을시 어떻게 되는지 확인해보면
 *   ex) A+B*C -> ABC*+   || * 를 탐색할 할 때 그 앞의 연산자 + 가 자신보다 우선순위가 낮으므로 * 가 먼저 후위표기식에 나타나야함
 *    * 가 먼저 후위 표기식에 나타나야 한다는 것은 Stack 에 삽입하여 추후에 함께 POP 해야한다는 말과 같다
 *
 *  마지막으로 괄호가 있을 경우를 생각해본다면  괄호 ( ) 안에 해당하는 연산자들은 모두 괄호 뒤로 빠져나와야 하는것을 홗인할 수 있음
 *  ex) A*(B+C) -> ABC+*
 *  ex2 A+(B+(C+D))) -> A+(B+CD+)) -> A+(BCD++) -> ABCD+++
 *   즉 ) 는 짝궁 ( 를 만날때까지 모든 연산자를 후위 표기식으로 출력해야함을 알 수 있다
 *
 *   따라서 위 조건에 따라 문제를 해결하면 된다
 */
public class BJ_1918_후위표기식 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String input;

        // Map 을 통해 기호들의 우선순위를 저장한다
        Map<Character , Integer> map = new HashMap<>();

        // 기호들의 우선순위를 세팅
        init(map);

        input = br.readLine();
        // 기호들을 담을 Stack
        Stack<Character> operator = new Stack<>();

        for(int i = 0; i < input.length(); i++){

            char c = input.charAt(i);  // 현재의 문자

            if(map.get(c) == null){  // 만약 map에 들어있지 않은 문자라면 알파벳 중 하나이기 때문에 StringBuffer에 입력
                sb.append(c);
            }else{
                if(map.get(c) == 0){  // 만약 '(' 라면 그냥 Stack 에 추가하고 건너뛰기
                    operator.push(c);
                    continue;
                }

                if(operator.isEmpty()){  // 만약 스택이 비어있다면 연산자 삽입
                    operator.push(c);
                }else{  // 스택이 비어있지 않다면

                    if(map.get(c) == 3){ // 만약 현재 기호가 ')' 라면
                        while(true){
                            if(operator.peek() =='('){  // '(' 를 만날 때 까지 계속해서 연산자를 출력한다
                                operator.pop();
                                break;
                            }else{
                                sb.append(operator.pop());
                            }

                            if(operator.isEmpty())  // 만약 스택이 비었다면 반복문 종료
                                break;
                        }
                        continue;
                    }
                    // 사칙연산 기호라면
                    if(map.get(c) > map.get(operator.peek())){ // 만약 현재의 연산자가 그 앞의 연산자보다 우선순위가 높을 시 스택에 넣는다
                        operator.push(c);
                    }else{  // 그렇지 않을 시
                        while(map.get(c) <= map.get(operator.peek())){ // 현재의 연산자가 스택에 가장 위에 있는 연산자보다 우선순위가 같거나 낮을 동안 계속해서 연산자를 출력
                            if(operator.peek()== '('){ // 만약 '(' 기호를 만났다면 멈춰야함 '(' 기호는 ')' 만이  꺼낼 수 있다
                                break;
                            }
                            sb.append(operator.pop());
                            if(operator.isEmpty()); // 만약 스택이 비었다면 종료
                                break;
                        }
                        operator.push(c);
                    }

                }
            }

        }
        while (!operator.isEmpty()){  // 스택에 남아있는 연산자들을 모두 후위 표기식에 출력
            sb.append(operator.pop());
        }
        System.out.println(sb.toString());

    }
    private static void init(Map<Character, Integer> map){
        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put(')', 3);
    }
}
