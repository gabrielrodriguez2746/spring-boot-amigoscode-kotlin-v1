package easy.sport.manager.trainer

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

// Spring Data
// MySQL, PostgreSQL
// MongoDB
// Cloud - Firestore, Datastore, Cloud Spanner
@Table
@Entity
data class Trainer(
    @SequenceGenerator(
        name = "trainer_sequence",
        sequenceName = "trainer_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "trainer_sequence"
    )
    @Id
    val id: Long? = null,
    var email: String? = null,
    val label: String? = null
)