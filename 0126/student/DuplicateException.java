package student;

public class DuplicateException extends RuntimeException {
    DuplicateException() {
        System.out.println("학번이 중복됩니다.");
    }
}
