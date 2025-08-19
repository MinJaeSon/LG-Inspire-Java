package lgcns.inspire.post.ctrl;

import lgcns.inspire.post.service.PostService;

public class PostInsertCtrl {
    private PostService service;

    public PostInsertCtrl(PostService service) {
        this.service = service;
    }

    public int insert(String title, String content, String writer) {
        System.out.println(">>>> post insert ctrl insert params: " + title + ", " + content + ", " + writer);
        return service.insertService(title, content, writer);
    }
}
