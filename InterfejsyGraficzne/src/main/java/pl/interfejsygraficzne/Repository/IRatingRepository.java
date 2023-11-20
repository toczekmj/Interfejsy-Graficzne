package pl.interfejsygraficzne.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.interfejsygraficzne.Model.Rating;

@Repository
public interface IRatingRepository extends JpaRepository<Rating, Long> {
    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM rating",
            nativeQuery = true
    )
    void DeleteData();
    @Modifying
    @Transactional
    @Query(
            value = "ALTER TABLE movie AUTO_INCREMENT = 1",
            nativeQuery = true
    )
    void setIdCounterToAuto();
    @Modifying
    @Transactional
    @Query(
            value = "ALTER TABLE movie AUTO_INCREMENT = 0",
            nativeQuery = true
    )
    void setIdCounterToZero();
}
