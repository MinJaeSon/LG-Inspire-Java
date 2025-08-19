package lgcns.inspire.post.factory;

import java.util.HashMap;
import java.util.Map;

import lgcns.inspire.post.ctrl.PostDeleteCtrl;
import lgcns.inspire.post.ctrl.PostFindCtrl;
import lgcns.inspire.post.ctrl.PostInsertCtrl;
import lgcns.inspire.post.ctrl.PostListCtrl;
import lgcns.inspire.post.ctrl.PostSearchCtrl;
import lgcns.inspire.post.ctrl.PostUpdateCtrl;
import lgcns.inspire.post.service.PostService;

/**
 * Singleton Pattern
 * - 인스턴스를 하나로 유지하는 방법 (무분별한 객체 생성을 방지) : Inversion of Control(IOC)
 * - 문법 :
 *   - 생성자의 접근 제어자를 private
 *   - 자신의 타입을 반환하는 메서드를 static (외부에서 접근할 수 있도록)
 */
public class BeanFactory {
    private static BeanFactory instance;
    private Map<String, Object> map;
    private PostService service;

    private BeanFactory() {
        map = new HashMap<>();
        // 각각의 컨트롤러들이 사용하는 서비스는 동일한 서비스이다. (하나의 service 객체를 의존성 주입)
        map.put("list", new PostListCtrl(service));
        map.put("find", new PostFindCtrl(service));
        map.put("insert", new PostInsertCtrl(service));
        map.put("delete", new PostDeleteCtrl(service));
        map.put("update", new PostUpdateCtrl(service));
        map.put("search", new PostSearchCtrl(service));
    }

    public static BeanFactory getInstance() {
        if (instance == null) {
            instance = new BeanFactory();
        }
        return instance;
    }

    public Object getCtrl(String requestUrl) {
        return map.get(requestUrl);
    }

}
