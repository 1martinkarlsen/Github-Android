package dk.vixo.githubandroid.github.domain.model

import dk.vixo.githubandroid.github.data.network.dto.OwnerDTO


data class PullRequest(
    val id: Long,
    val title: String,
    val user: OwnerDTO
)