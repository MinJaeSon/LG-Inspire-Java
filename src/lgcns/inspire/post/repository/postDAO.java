package lgcns.inspire.post.repository;

import java.util.Arrays;
import java.util.List;

import lgcns.inspire.post.domain.dto.PostRequestDTO;
import lgcns.inspire.post.domain.dto.PostResponseDTO;

/**
 * DAO(Data Access Object)
 * - 데이터베이스 작업을 담당하는 클래스
 * - 입력(C), 읽기(R), 수정(U), 삭제(D) => CRUD
 * - Structure Query Language (SQL) : DDL, DML, DCL, Select Query
 */
public interface postDAO {
    private 
    
    // 입력(C)
    public int insertRow(PostRequestDTO req) { // request dto를 받아서 int로 반환
        System.out.println(">>>> dao insertRow");
        return 0;
    }

    // 읽기(R) - 전체
    public List<PostResponseDTO> selectRow() {
        System.out.println(">>>> dao selectRow");

        // DB 연동 후 값을 가져온다 가정하고 더미데이터를 생성
        List<PostResponseDTO> posts = new ArrayList<>(Arrays.asList(
            PostResponseDTO.builder()
                .id(1)
                .title("제목1")
                .content("내용1")
                .build(),
                
                PostResponseDTO.builder()
                .id(2)
                .title("제목2")
                .content("내용2")
                .build(),
                
                PostResponseDTO.builder()
                .id(3)
                .title("제목3")
                .content("내용3")
                .build()
        ));
        
        return posts;
    }

    // 읽기(R) - 특정 조건
    public PostResponseDTO selectRow(String id) {
        System.out.println(">>>> dao selectRow id : " + id);
        return null;
    }

    // 수정(U)
    public int updateRow(PostRequestDTO req) {
        System.out.println(">>>> dao updateRow");
        return 0;
    }

    // 삭제(D)
    public int deleteRow(String id) {
        System.out.println(">>>> dao deleteRow id : " + id);
        return 0;
    }
}
