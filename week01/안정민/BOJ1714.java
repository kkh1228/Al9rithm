import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1713 {
    static class Student implements Comparable<Student> {
        int id;
        int count;
        int time;

        public Student(int id,int count,int time)
        {
            this.id = id;
            this.count = count;
            this.time = time;
        }

        @Override
        public int compareTo(Student o){
            if(this.count == o.count)
            {
                return this.time - o.time;
            }
            return this.count - o.count;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //액자 수
        int n = Integer.parseInt(br.readLine());
        //추천 수
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        //액자에 담을 학생 정보
        List<Student> students = new ArrayList<>();
        //학생의 추천수
        Map<Integer,Student> map = new HashMap<>();

        for(int i = 0; i<k; i++)
        {
            int id = Integer.parseInt(st.nextToken());
            //게시되어있는 학생이면 추천 수 늘리기
            if(map.containsKey(id)){
                map.get(id).count++;
            }
            //게시가 안되어 있을때
            else{
                //액자가 비어있을 떄
                if(students.size()<n){
                    Student student = new Student(id,1,i);
                    students.add(student);
                    map.put(id, student);
                }
                //액자가 꽉차 있을때
                else{
                    Collections.sort(students);
                    Student remove = students.remove(0);
                    map.remove(remove.id);
                    Student student = new Student(id,1,i);
                    students.add(student);
                    map.put(id,student);
                }
            }

        }
        //id 오름차순으로 정렬
        Collections.sort(students, Comparator.comparingInt(s -> s.id));
        //내리림차순 정렬은 Collections.sort(students, Comparator.comparingInt(s -> s.id)).reversed();

        for(Student student : students)
        {
            System.out.print(student.id+" ");
        }

    }
}
