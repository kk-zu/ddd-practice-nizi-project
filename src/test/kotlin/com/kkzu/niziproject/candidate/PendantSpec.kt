package com.kkzu.niziproject.candidate

import io.kotlintest.specs.StringSpec
import com.kkzu.niziproject.domain.candidate.Cube.*
import com.kkzu.niziproject.domain.candidate.Pendant
import io.kotlintest.shouldNotThrow
import io.kotlintest.shouldThrow

class PendantSpec: StringSpec() {

    init {
        "Pendant constructor throw error given 5 part1cubes" {
            shouldThrow<IllegalArgumentException> {
                Pendant(listOf(DANCE,SING,STAR_QUALITY,PERSONALITY,PART2CUBE), listOf(PART2CUBE))
            }
        }

        "Pendant constructor throw error given duplicate part1cubes" {
            shouldThrow<IllegalArgumentException> {
                Pendant(listOf(DANCE,DANCE), listOf(PART2CUBE))
            }
        }

        "Pendant constructor throw error given part2cube in part1cubes" {
            shouldThrow<IllegalArgumentException> {
                Pendant(listOf(PART2CUBE), listOf(PART2CUBE))
            }
        }

        "Pendant constructor throw error given 5 part2cubes" {
            shouldThrow<IllegalArgumentException> {
                Pendant(listOf(DANCE), listOf(PART2CUBE,PART2CUBE,PART2CUBE,PART2CUBE,PART2CUBE))
            }
        }

        "Pendant constructor throw error given part1cube in part2cubes" {
            shouldThrow<IllegalArgumentException> {
                Pendant(listOf(DANCE), listOf(DANCE))
            }
        }

        "Pendant constructor make Instance by max 4 cubes and no duplicated" {
            shouldNotThrow<IllegalArgumentException> {
                Pendant(listOf(DANCE,SING,STAR_QUALITY,PERSONALITY), listOf(PART2CUBE,PART2CUBE,PART2CUBE,PART2CUBE))
            }
        }

        "Pendant constructor make Instance by empty list" {
            shouldNotThrow<IllegalArgumentException> {
                Pendant(listOf(), listOf())
            }
        }
    }

}