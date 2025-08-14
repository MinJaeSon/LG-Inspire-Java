package lgcns.inspire.post.service;

import java.util.List;
import java.util.Optional;

import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.repository.postDAO;

public class PostServiceImpl implements PostService {
    private PostDAO dao; // 동일 패턴으로 참조 타입의 변수 선언 (service는 dao를 참조하므로 참조 타입의 변수 선언 -> dao에서 생성된 객체를 주입)

    public PostServiceImpl() {
        dao = new postDAO(); 
    }

    @Override
    public List<PostResponseDTO> selectService() {
        System.out.println(">>>> post service selectService");
        return dao.selectRow();
    }

    /**
     * 가져온 데이터로부터 식별값(id)에 만족하는 데이터를 반환할 때 Optional<PostResponseDTO> 타입으로 반환
     * stream 사용
     */
    @Override
    public Optional<PostResponseDTO> selectService(int id) {
        System.out.println(">>>> post service selectService id : " + id);
        List<PostResponseDTO> list = dao.selectRow();
        Optional<PostResponseDTO> result = list.stream()
                                            .filter(post -> post.getId() == id)
                                            .findFirst();
        return result;
    }

}
