import lgcns.inspire.post.domain.dto.PostResponseDTO;

public class ArrayApp {
    /* 
    배열(Array)
    - 고정 길이를 갖는다(리사이징 X)
    - 단일 타입만 담는 그릇(기본, 참조)
    - 참조타입으로 취급
    - length 속성을 통해서 배열의 길이를 확인
    - 첨자번지는 0 ~
    - [ ] 사용
    */
    public static void main(String[] args) {
        // int [] ary = new int[10];
        int [] arr = {1,2,3,4,5};
        System.out.println(">>> ary length : " + arr.length);
        for(int i=0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println(">>>> 참조입의 객체를 배열에 담는다면?");
        PostResponseDTO [] postArray = new PostResponseDTO [10]; // 객체 배열 생성
        // PostRequestDTO postRequestDTO = new PostRequestDTO(); // 1) dto 객체 생성
        
        // 2) Builder Patter을 사용한 객체 생성 방법
        PostResponseDTO data = PostResponseDTO.builder().title("빌더 패턴").build();
        System.out.println(">>> getter call : " + data.getTitle());
        postArray[0] = data;
        for (PostResponseDTO post : postArray) {
            if (post != null) { // 참조타입은 기본값이 null이므로 초기화 해줘야 함. 그렇지 않으면 오류 발생
                System.out.println(post.getTitle());
            }
        }
        System.out.println(">>> main end <<<");
    } 
}