package net.jaswanth.SpringBootRestAPI.controller;

import net.jaswanth.SpringBootRestAPI.Bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @GetMapping("student") //Single student
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "M",
                "Jaswanth"
        );
//      return student;
//      return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header", "Jas")
                .body(student);
    }

    @GetMapping //List of students
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Dinnu", "M"));
        students.add(new Student(2, "Seenu", "N"));
        students.add(new Student(3, "Sarath", "C"));
        students.add(new Student(4, "Prem", "C"));
//        return students;
        return ResponseEntity.ok(students);
    }

//    PathVariable here: {id} - URI template Variable
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVaraible( @PathVariable int id,
                                        @PathVariable("first-name") String firstName,
                                        @PathVariable("last-name") String lastName){
//        return new Student(id, firstName,lastName);
        Student student = new Student(id, firstName,lastName);
        return ResponseEntity.ok(student);
    }

    @GetMapping("query")
    public  ResponseEntity<Student> studentRequestParam( @RequestParam int id,
                                         @RequestParam String firstName,
                                         @RequestParam String lastName){
//        return new Student(id, firstName, lastName);
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    @PostMapping("create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
//        return student;
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
//        return student;
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println("Deleted Student: "+studentId);
//        return "Student deleted successfully!!!...";
        return ResponseEntity.ok("Student deleted successfully!!!...");
    }
}
