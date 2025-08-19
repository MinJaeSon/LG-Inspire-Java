package lgcns.inspire.post.view;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import lgcns.inspire.post.ctrl.PostController;
import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.front.FrontController;

public class PostView {
    private Scanner scan;

    // Dependency Injection (DI)
    // private PostController controller; // 참조 타입의 변수 (view는 controller를 참조하므로 참조 타입의 변수 선언 -> controller에서 생성된 객체를 주입. Spring 프레임워크에서 이를 지원)
    private FrontController front;

    public PostView() {
        scan = new Scanner(System.in);
        // controller = new PostController();
        front = new FrontController();
    }
    
    public void mainView() {
        while (true) {
            System.out.println(">>> Inspire Camp Post Ver(1.0)");
            System.out.println("1. 전체 검색");
            System.out.println("2. 게시글 상세 보기");
            System.out.println("3. 입력 폼으로 이동");
            System.out.println("4. 수정 페이지 이동");
            System.out.println("5. 삭제하기");
            System.out.println("6. 게시글 작성자로 검색");
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
                    delete();
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

        List<PostResponseDTO> list = front.list("list"); // view가 controller의 메소드를 호출
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

        Optional<PostResponseDTO>result = front.find("find", id);
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("해당 게시글을 찾을 수 없습니다.");
        }
    }

    public void insert() {
        System.out.println(">>>> 제목, 내용, 작성자 입력 <<<<");
        System.out.print(">>> 제목 : ");
        String title = scan.nextLine(); // 문자열로 입력 받기
        System.out.print(">>> 내용 : ");
        String content = scan.nextLine();
        System.out.print(">>> 작성자 : ");
        String writer = scan.nextLine();

        int successFlag = front.insert("insert", title, content, writer);
        if (successFlag == 1) {
            System.out.println("게시글 입력에 성공했습니다.");
        } else {
            System.out.println("게시글 입력에 실패했습니다.");
        }
    }
    
    public void delete() {
        System.out.println(">>>> 게시글 삭제 <<<<");
        System.out.print("삭제할 게시글 번호를 입력하세요 : ");
        int id = Integer.parseInt(scan.nextLine());

        int deleteFlag = front.delete("delete", id);
        System.out.println(deleteFlag == 1 ? "삭제 완료" : "삭제 실패");
    }

    public void update() {
        System.out.println(">>>> 게시글 수정 <<<<");
        System.out.print("수정할 게시물 id :  ");
        int id = Integer.parseInt(scan.nextLine());
        System.out.print("수정할 제목 입력 : ");
        String title = scan.nextLine();
        System.out.println("수정할 내용 입력 : ");
        String content = scan.nextLine();

        int updateFlag = front.update("update", title, content, id);
        System.out.println(updateFlag == 1 ? "수정 완료" : "수정 실패");
    }

    public void search() {
        System.out.println(">>>> 게시글 작성자로 검색 <<<<");
        System.out.print("검색할 작성자 입력 : ");
        String writer = scan.nextLine();

        Optional<List<PostResponseDTO>> result = front.search("search", writer);
        // if (result.isPresent()) {
        //     for (PostResponseDTO post : result.get()) {
        //         System.out.println(post);
        //     }
        // } else {
        //     System.out.println("해당 작성자의 게시글을 찾을 수 없습니다.");
        // }
        result.ifPresentOrElse(
            list -> list.forEach(System.out::println),
            () -> System.out.println(writer + "님이 작성한 게시글이 존재하지 않습니다."));
    }
}
