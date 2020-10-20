package com.kkzu.niziproject.candidate

import com.kkzu.niziproject.domain.DomainException
import io.kotlintest.specs.StringSpec
import com.kkzu.niziproject.domain.candidate.Cube.*
import com.kkzu.niziproject.domain.candidate.Pendant
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotThrow
import io.kotlintest.shouldThrow

class PendantSpec: StringSpec() {

    init {
        "Pendant constructor throw error given 5 part1cubes" {
            val error = shouldThrow<DomainException> {
                Pendant(listOf(DANCE,SING,STAR_QUALITY,PERSONALITY,PART2CUBE), listOf(PART2CUBE))
            }
            error.message shouldBe "パート１キューブが４つ以上含まれています。"
        }

        "Pendant constructor throw error given duplicate part1cubes" {
            val error = shouldThrow<DomainException> {
                Pendant(listOf(DANCE,DANCE), listOf(PART2CUBE))
            }
            error.message shouldBe "重複したパート１キューブが含まれています。"
        }

        "Pendant constructor throw error given part2cube in part1cubes" {
            val error = shouldThrow<DomainException> {
                Pendant(listOf(PART2CUBE), listOf(PART2CUBE))
            }
            error.message shouldBe "パート１キューブ以外のキューブが含まれています。"
        }

        "Pendant constructor throw error given 5 part2cubes" {
            val error = shouldThrow<DomainException> {
                Pendant(listOf(DANCE), listOf(PART2CUBE,PART2CUBE,PART2CUBE,PART2CUBE,PART2CUBE))
            }
            error.message shouldBe "パート２キューブが４つ以上含まれています。"
        }

        "Pendant constructor throw error given part1cube in part2cubes" {
            val error = shouldThrow<DomainException> {
                Pendant(listOf(DANCE), listOf(DANCE))
            }
            error.message shouldBe "パート２キューブ以外のキューブが含まれています。"
        }

        "Pendant constructor make Instance by max 4 cubes and no duplicated" {
            shouldNotThrow<DomainException> {
                Pendant(listOf(DANCE,SING,STAR_QUALITY,PERSONALITY), listOf(PART2CUBE,PART2CUBE,PART2CUBE,PART2CUBE))
            }
        }

        "Pendant constructor make Instance by empty list" {
            shouldNotThrow<DomainException> {
                Pendant(listOf(), listOf())
            }
        }

        "Pendant constructor make init Instance" {
            val pendant = Pendant()
            pendant.part1cubes.size shouldBe 0
            pendant.part2cubes.size shouldBe 0
        }
    }

}