package com.kkzu.niziproject.candidate

import com.kkzu.niziproject.domain.candidate.Candidate
import com.kkzu.niziproject.domain.candidate.CandidateName
import com.kkzu.niziproject.domain.candidate.Cube
import com.kkzu.niziproject.domain.candidate.Pendant
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.shouldNotThrowUnit
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec

class CandidateSpec: StringSpec() {

    init {
        "Candidate constructor make init Instance" {
            val name = CandidateName("firstName", "lastName")
            val candidate = Candidate(name)
            candidate.candidateId shouldNotBe null
            candidate.name shouldBe name
            candidate.dropedoutPart1 shouldBe false
            candidate.dropedoutPart1 shouldBe false
            candidate.passed shouldBe false
            candidate.pendant.part1cubes.size shouldBe 0
            candidate.pendant.part2cubes.size shouldBe 0
        }

        "Candidate acquire Part1Cube" {
            val name = CandidateName("firstName", "lastName")
            val candidate = Candidate(name)
            candidate.acquireCubeByPart1(Cube.DANCE)
            candidate.pendant.part1cubes.size shouldBe 1
            candidate.pendant.part1cubes[0] shouldBe Cube.DANCE
            candidate.pendant.part2cubes.size shouldBe 0
        }

        "Candidate acquire Part2Cube" {
            val name = CandidateName("firstName", "lastName")
            val candidate = Candidate(name)
            candidate.acquireCubeByPart2(Cube.PART2CUBE)
            candidate.pendant.part1cubes.size shouldBe 0
            candidate.pendant.part2cubes.size shouldBe 1
            candidate.pendant.part2cubes[0] shouldBe Cube.PART2CUBE
        }

        "Candidate throw error when acquire Part2Cube and dropped out part1" {
            val name = CandidateName("firstName", "lastName")
            val candidate = Candidate(name)
            candidate.dropoutPart1()
            shouldThrow<IllegalArgumentException> {
                candidate.acquireCubeByPart2(Cube.PART2CUBE)
            }
        }

        "Candidate throw error when acquire Part2Cube and dropped out part2" {
            val name = CandidateName("firstName", "lastName")
            val candidate = Candidate(name)
            candidate.dropoutPart2()
            shouldThrow<IllegalArgumentException> {
                candidate.acquireCubeByPart2(Cube.PART2CUBE)
            }
        }

        "Candidate drop out Part1" {
            val name = CandidateName("firstName", "lastName")
            val candidate = Candidate(name)
            candidate.dropoutPart1()
            candidate.dropedoutPart1 shouldBe true
            candidate.dropedoutPart2 shouldBe false
        }

        "Candidate drop out Part2" {
            val name = CandidateName("firstName", "lastName")
            val candidate = Candidate(name)
            candidate.dropoutPart2()
            candidate.dropedoutPart2 shouldBe true
            candidate.dropedoutPart1 shouldBe false
        }
    }

}