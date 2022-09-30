package springbootstarter.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TopicRepo extends JpaRepository<Topic,Long> {
@Query("Select t from Topic t where t.id = :id")
Optional<Topic> findByIdt(@Param("id") Long id);
}
