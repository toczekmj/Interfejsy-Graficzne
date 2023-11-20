package pl.interfejsygraficzne.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.interfejsygraficzne.Model.Comment;

import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByTextContaining(String text);

    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM comment",
            nativeQuery = true
    )
    void DeleteData();

    @Modifying
    @Transactional
    @Query(
            value = "ALTER TABLE comment AUTO_INCREMENT = 0",
            nativeQuery = true
    )
    void setIdCounterToZero();

    @Modifying
    @Transactional
    @Query(
            value = "ALTER TABLE comment AUTO_INCREMENT = 1",
            nativeQuery = true
    )
    void setIdCounterToAuto();
}
