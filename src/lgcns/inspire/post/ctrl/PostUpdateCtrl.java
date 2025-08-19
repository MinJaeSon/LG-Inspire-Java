package lgcns.inspire.post.ctrl;

import lgcns.inspire.post.service.PostService;

public class PostUpdateCtrl {
    private PostService service;

    public PostUpdateCtrl(PostService service) {
        this.service = service;
    }

    public int update(String title, String content, int id) {
        System.out.println(">>>> post update ctrl update params: " + title + ", " + content + ", " + id);
        return 1;
    }
}
