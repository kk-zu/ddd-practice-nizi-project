package com.kkzu.niziproject.domain.candidate

import com.kkzu.niziproject.domain.DomainException
import com.kkzu.niziproject.domain.candidate.Cube.*

class Pendant {

    val part1cubes: List<Cube>
    val part2cubes: List<Cube>

    private val ACCEPT_PART1CUBES = listOf(DANCE, SING, STAR_QUALITY, PERSONALITY)

    constructor() {
        part1cubes = listOf()
        part2cubes = listOf()
    }

    constructor(part1cubes: List<Cube>, part2cubes: List<Cube>) {
        if (part1cubes.size > 4)
            throw DomainException("パート１キューブが４つ以上含まれています。")
        if (part1cubes.distinct().size != part1cubes.size)
            throw DomainException("重複したパート１キューブが含まれています。")
        if (!ACCEPT_PART1CUBES.containsAll(part1cubes))
            throw DomainException("パート１キューブ以外のキューブが含まれています。")
        if (part2cubes.size > 4)
            throw DomainException("パート２キューブが４つ以上含まれています。")
        if (!part2cubes.all { it === PART2CUBE })
            throw DomainException("パート２キューブ以外のキューブが含まれています。")

        this.part1cubes = part1cubes
        this.part2cubes = part2cubes
    }

}
