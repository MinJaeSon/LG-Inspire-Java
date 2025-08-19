package lgcns.inspire.post.front;

import java.util.List;
import java.util.Optional;

import lgcns.inspire.post.ctrl.PostDeleteCtrl;
import lgcns.inspire.post.ctrl.PostFindCtrl;
import lgcns.inspire.post.ctrl.PostInsertCtrl;
import lgcns.inspire.post.ctrl.PostListCtrl;
import lgcns.inspire.post.ctrl.PostSearchCtrl;
import lgcns.inspire.post.ctrl.PostUpdateCtrl;
import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.factory.BeanFactory;

public class FrontController {
    private BeanFactory factory;

    public FrontController() {
        factory = BeanFactory.getInstance();
    }

    public List<PostResponseDTO> list(String requestUrl) {
        System.out.println(">>>> front ctrl list");

        PostListCtrl obj = (PostListCtrl)factory.getCtrl(requestUrl);
        return obj.list();
    }

    public Optional<PostResponseDTO> find(String requestUrl, int id) {
        System.out.println(">>>> fribt ctrl findPost params: " + id);

        PostFindCtrl obj = (PostFindCtrl)factory.getCtrl(requestUrl);
        return obj.find(id);
    }

    public int insert(String requestUrl, String title, String content, String writer) {
        System.out.println(">>>> front ctrl insertPost params: " + title + ", " + content + ", " + writer);

        PostInsertCtrl obj = (PostInsertCtrl)factory.getCtrl(requestUrl);
        return obj.insert(title, content, writer);
    }

    public int delete(String requestUrl, int id) {
        System.out.println(">>>> front ctrl deletePost params: " + id);

        PostDeleteCtrl obj = (PostDeleteCtrl)factory.getCtrl(requestUrl);
        return obj.delete(id);
    }

    public int update(String requestUrl, String title, String content, int id) {
        System.out.println(">>>> front ctrl updatePost params: " + title + ", " + content + ", " + id);

        PostUpdateCtrl obj = (PostUpdateCtrl)factory.getCtrl(requestUrl);
        return obj.update(title, content, id);
    }

    public Optional<List<PostResponseDTO>> search(String requestUrl, String writer) {
        System.out.println(">>>> front ctrl searchPost params: " + writer);

        PostSearchCtrl obj = (PostSearchCtrl)factory.getCtrl(requestUrl);
        return obj.search(writer);
    }
}
