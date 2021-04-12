public class Solution {

        public static void main(String[] args){
            Student s = new Student();
            Class stu = s.getClass();
            //OR Class stu = Student.class; for 1 line code
            Method[] methods = stu.getDeclaredMethods();

            ArrayList<String> methodList = new ArrayList<>();
            for(Method m : methods){
                methodList.add(m.getName());
            }
            Collections.sort(methodList);
            for(String name: methodList){
                System.out.println(name);
            }
        }

    }
