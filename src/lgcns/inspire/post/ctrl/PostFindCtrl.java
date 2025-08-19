package lgcns.inspire.post.ctrl;

import java.util.Optional;

import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.service.PostService;

public class PostFindCtrl {
    private PostService service;

    public PostFindCtrl(PostService service) {
        this.service = service;
    }

    public Optional<PostResponseDTO> find(int id) {
        System.out.println(">>>> post find ctrl findPost params: " + id);
        return service.selectService(id);
    }
}
