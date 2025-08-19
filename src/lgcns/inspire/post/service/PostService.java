package lgcns.inspire.post.service;

import java.util.List;
import java.util.Optional;

import lgcns.inspire.post.domain.dto.PostRequestDTO;
import lgcns.inspire.post.domain.dto.PostResponseDTO;

public interface PostService {
    public List<PostResponseDTO> selectService(); // 추상 메소드
    public Optional<PostResponseDTO> selectService(int id);
    public int insertService(PostRequestDTO req);

    // public List<PostResponseDTO> searchService(String writer);
    public Optional<List<PostResponseDTO>> searchService(String writer);
}
