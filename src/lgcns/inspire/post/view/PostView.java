package lgcns.inspire.post.view;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import lgcns.inspire.post.ctrl.PostController;
import lgcns.inspire.post.domain.dto.PostResponseDTO;

public class PostView {
    private Scanner scan;

    // Dependency Injection (DI)
    private PostController controller; // 참조 타입의 변수 (view는 controller를 참조하므로 참조 타입의 변수 선언 -> controller에서 생성된 객체를 주입. Spring 프레임워크에서 이를 지원)

    public PostView() {
        scan = new Scanner(System.in);
        controller = new PostController();
    }
    
    public void mainView() {
        while (true) {
            System.out.println(">>> Inspire Camp Post Ver(1.0)");
            System.out.println("1. 전체 검색");
            System.out.println("2. 게시글 상세 보기");
            System.out.println("3. 입력 폼으로 이동");
            System.out.println("4. 수정 페이지 이동");
            System.out.println("5. 삭제하기");
            System.out.println("99. 프로그램 종료");
            System.out.print("번호를 선택하세요 : ");
            int num = scan.nextInt();
            switch (num) {
                case 1:
                    list();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 99:
                    System.exit(0); // 프로그램 종료
                    break;
                default:
                    System.out.println("잘못된 번호입니다.");
                    break;
            }
        }
    }

    /**
     * controller에게 데이터를 요청 후 받은 값을 출력
     */
    public void list() {
        System.out.println(">>>> 데이터 출력 <<<<");

        List<PostResponseDTO> list = controller.list(); // view가 controller의 메소드를 호출
        for (PostResponseDTO post : list) {
            System.out.println(post);
        }

        // // stream api 이용
        // list.stream().forEach(System.out::println);

        // // 특정 컬럼만 출력
        // list.stream().map(PostResponseDTO::getTitle)
        //         .forEach(System.out::println);

        list.stream().filter(post -> post.getId() >= 2)
                .forEach(System.out::println);
    }

    public void read() {
        System.out.println(">>>> 게시글 상세 보기 <<<<");
        System.out.print("게시글 번호를 입력하세요 : ");
        int id = scan.nextInt();

        Optional<PostResponseDTO>result = controller.findPost(id);
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("해당 게시글을 찾을 수 없습니다.");
        }
    }

    public void insert() {
        System.out.println(">>> post view insert");
    }
    
    
}
