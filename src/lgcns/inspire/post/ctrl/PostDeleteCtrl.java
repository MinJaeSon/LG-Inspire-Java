package lgcns.inspire.post.ctrl;

import lgcns.inspire.post.service.PostService;

public class PostDeleteCtrl {
    private PostService service;

    public PostDeleteCtrl(PostService service) {
        this.service = service;
    }

    public int delete(int id) {
        System.out.println(">>>> post delete ctrl delete params: " + id);
        return 1;
    }
}