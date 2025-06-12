package Collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Students{
    int RollNo;
    String Name;
    int Age;

    public Students(int rollNo, String name, int age) {
        RollNo = rollNo;
        Name = name;
        Age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return RollNo == students.RollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(RollNo);
    }

    @Override
    public String toString() {
        return "Students{" +
                "RollNo=" + RollNo +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                '}';
    }
}

public class Learn_HashSet {
    public static void main(String[] args) {

        Set<Students> studentSet = new HashSet<>();
        Scanner get= new Scanner(System.in);

        System.out.print("Type No. Of Record You Want: ");
        int rec=get.nextInt();

        for(int i=0;i<rec;i++){

            System.out.println((i+1)+". Record --");
            System.out.print("Enter Student RollNO: ");
            int rollNo= get.nextInt();
            get.nextLine(); // changing int to string datatype to take input Name.

            System.out.print("Enter Student Name: ");
            String name= get.nextLine();    // now input work without skip this line

            System.out.print("Enter Student Age: ");
            int age= get.nextInt();
            System.out.println("Successfully Added..\n");

            studentSet.add(new Students(rollNo,name,age));
        }

        System.out.println("----- Students Details -----\n");
        for(Students records:studentSet){
            System.out.println(records);
        }

    }

}
