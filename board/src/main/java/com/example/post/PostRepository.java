package com.example.post;

import com.example.user.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {
    PostModel findByTitle(String title);
//    Optional<PostModel> selectStudentById(UUID id);
//    List<PostModel> selectAllStudents();
//    int insertPost(PostModel postModel);
//    int upgradePost(PostModel postModel);
//    int deletePost(UUID id);

}
