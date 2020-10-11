import com.kkzu.niziproject.domain.candidate.CandidateName
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class CandidateNameSpec: StringSpec() {

    init {
        "nickname return lastName" {
            val name = CandidateName("姓", "名")
            name.nickname() shouldBe "名"
        }
    }

}