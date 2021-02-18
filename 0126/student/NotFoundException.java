package student;

public class NotFoundException extends RuntimeException{
    NotFoundException() {
        System.out.println("정보를 찾을 수 없습니다.");
    }
}
