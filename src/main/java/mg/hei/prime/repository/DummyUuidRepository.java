package mg.hei.prime.repository;

import java.util.Optional;
import mg.hei.prime.PojaGenerated;
import mg.hei.prime.repository.model.DummyUuid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@PojaGenerated
@Repository
public interface DummyUuidRepository extends JpaRepository<DummyUuid, String> {

  @Override
  Optional<DummyUuid> findById(String id);
}
