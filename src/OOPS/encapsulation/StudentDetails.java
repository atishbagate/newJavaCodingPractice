package OOPS.encapsulation;



public class StudentDetails {
    static class StudentDetail{
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String  toString() {
            return "StudentDetail{} "+this.getName();
        }
    }
    public static void main(String[] args){
        StudentDetail student = new StudentDetail();
        student.setName("Atish");
        System.out.println(student.getName());
        System.out.println(student.toString());
    }
}
