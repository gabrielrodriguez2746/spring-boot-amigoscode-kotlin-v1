package easy.sport.manager.trainer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/trainer")
class TrainerController @Autowired constructor(
	 private val service: TrainerService
) {

	@GetMapping
	fun get(): List<Trainer> {
		return service.get()
	}

	@PostMapping
	fun registerTrainer(@RequestBody trainer: Trainer) {
		service.registerTrainer(trainer)
	}

	@DeleteMapping("{trainerId}")
	fun deleteTrainer(@PathVariable("trainerId") trainerId: Long) {
		service.deleteTrainer(trainerId)
	}

	@PutMapping("{trainerId}")
	fun updateTrainer(
		@PathVariable("trainerId") trainerId: Long,
		@RequestParam(required = false) email: String
	) {
		service.updateTrainer(trainerId, email)
	}
}