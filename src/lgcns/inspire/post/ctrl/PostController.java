package lgcns.inspire.post.ctrl;

import java.util.List;
import java.util.Optional;

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
}
