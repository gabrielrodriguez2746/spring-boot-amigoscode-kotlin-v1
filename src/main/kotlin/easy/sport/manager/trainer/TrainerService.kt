package easy.sport.manager.trainer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TrainerService @Autowired constructor(
    private val repository: TrainerRepository
) {

    fun get(): List<Trainer> {
        return repository.findAll()
    }

    fun registerTrainer(trainer: Trainer) {
        // Should have more complex validations
        repository.findTrainerByEmail(trainer.email.orEmpty())?.let {
            throw IllegalStateException("email taken")
        } ?: run {
            repository.save(trainer)
        }
    }

    fun deleteTrainer(trainerId: Long) {
        if(repository.existsById(trainerId)) {
            repository.deleteById(trainerId)
        } else {
            throw IllegalStateException("trainer with id $trainerId does not exist")
        }
    }

    @Transactional
    fun updateTrainer(trainerId: Long, email: String) {
        when {
            !repository.existsById(trainerId) -> throw IllegalStateException("trainer with id $trainerId does not exist")
            repository.findTrainerByEmail(email) != null -> throw IllegalStateException("email taken")
            else -> {
                val trainer = repository.findById(trainerId)
                trainer.get().email = email
            }
        }
    }
}