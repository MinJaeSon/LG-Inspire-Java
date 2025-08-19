package lgcns.inspire.post.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lgcns.inspire.post.domain.dto.PostRequestDTO;
import lgcns.inspire.post.domain.dto.PostResponseDTO;
import lgcns.inspire.post.repository.PostDAO;

public class PostServiceImpl implements PostService {
    private PostDAO dao; // 동일 패턴으로 참조 타입의 변수 선언 (service는 dao를 참조하므로 참조 타입의 변수 선언 -> dao에서 생성된 객체를 주입)

    public PostServiceImpl() {
        dao = new PostDAO(); 
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

    @Override
    public int insertService(PostRequestDTO req) {
        System.out.println(">>>> post service insertService : " + req);
        return dao.insertRow(req);
    }

    @Override
    public Optional<List<PostResponseDTO>> searchService(String writer) {
        System.out.println(">>>> post service searchService : " + writer);
        // 존재하지 않는다면 Optional로 감싸서 반환
        List<PostResponseDTO> list = dao.selectRow();
        List<PostResponseDTO> result = list.stream()
                                            .filter(post -> post.getWriter().equals(writer))
                                            .collect(Collectors.toList());
        
        if (result.isEmpty()) {
            return Optional.empty();
        }
        
        return Optional.of(result);
    }
}