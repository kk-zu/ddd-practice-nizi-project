package com.kkzu.niziproject.domain.candidate

import com.kkzu.niziproject.domain.candidate.Cube.*

class Pendant {

    val part1cubes: List<Cube>
    val part2cubes: List<Cube>

    private val ACCEPT_PART1CUBES = listOf(DANCE, SING, STAR_QUALITY, PERSONALITY)

    constructor(part1cubes: List<Cube>, part2cubes: List<Cube>) {
        if (part1cubes.size > 4) throw IllegalArgumentException()
        if (part1cubes.distinct().size != part1cubes.size
                || !ACCEPT_PART1CUBES.containsAll(part1cubes))
            throw IllegalArgumentException()
        if (part2cubes.size > 4) throw IllegalArgumentException()
        if (!part2cubes.all { it === PART2CUBE }) throw IllegalArgumentException()

        this.part1cubes = part1cubes
        this.part2cubes = part2cubes
    }

}
