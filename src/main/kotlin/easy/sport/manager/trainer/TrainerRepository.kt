package easy.sport.manager.trainer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TrainerRepository : JpaRepository<Trainer, Long> {

    @Query("SELECT trainer FROM Trainer trainer WHERE trainer.email = ?1")
    fun findTrainerByEmail(email: String): Trainer?

}