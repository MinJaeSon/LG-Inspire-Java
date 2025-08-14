package lgcns.inspire.post.ctrl;

import java.util.List;
import java.util.Optional;

import lgcns.inspire.post.domain.dto.PostRequestDTO;
import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.service.PostService;
import lgcns.inspire.post.service.PostServiceImpl;

public class PostController {
    private PostService service; // controller는 model(service)를 참조하므로 service 타입을 참조하기 위한 변수 선언
    public PostController() {
        service = new PostServiceImpl(); // service impl 객체를 주입. impl이 교체되더라도 타입은 service(부모)이므로 유연하게 교체 가능
    }

    public List<PostResponseDTO> list() {
        System.out.println(">>>> post controller list");
        return service.selectService();
    }

    public Optional<PostResponseDTO> findPost(int id) {
        System.out.println(">>>> post controller findPost id : " + id);
        return service.selectService(id);
    }

    public int insertPost(String title, String content, String writer) {
        System.out.println(">>>> post controller insertPost");
        // 전달된 파라미터를 PostResponseDTO 객체로 바인딩하고
        // 기본키 값은 size() + 1 로 id값을 할당
        PostRequestDTO req = PostRequestDTO.builder()
                                        .title(title)
                                        .content(content)
                                        .writer(writer)
                                        .id(service.selectService().size() + 1)
                                        .build();
        return service.insertService(req);
    }
}
